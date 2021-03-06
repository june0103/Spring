package kr.spring.main.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	//의존관계 설정
	@Resource
	private MemberService memberService;
	
	//자바빈 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	//회원가입
	//아이디 중복 체크
	@RequestMapping("/member/confirmId.do")
	@ResponseBody
	public Map<String, String> Process(@RequestParam("id") String id){
		
		if(log.isDebugEnabled()) {
			log.debug("====id==== : " + id);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		MemberVO member = memberService.selectCheckMember(id);
		if(member!=null) {
			//id중복
			map.put("result", "idDuplicated");
		}else {
			if (!Pattern.matches("^[A-za-z0-9+]{4,12}$",id)) {
				//패턴 불일치
				map.put("result", "notMatchPattern");
			}else {
				//패턴 일치 아이디 미중복
				map.put("result", "idNotFound");
			}
		}
		
		
		return map;
	}
	
	//회원등록 폼 호출
	@RequestMapping(value="/member/registerUser.do",method=RequestMethod.GET)
	public String form() {
				//뷰이름(타일스 식별자)
		return "memberRegister";
	}
	
	//회원등록 데이터 전송
	@RequestMapping(value="/member/registerUser.do",method=RequestMethod.POST)
	public String submit(@Valid MemberVO memberVO, BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("====회원가입==== : " + memberVO);
		}
		
		//유효성 체크결과 오류가 있으면 폼을 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//회원가입
		memberService.insertMember(memberVO);
		
		return "redirect:/main/main.do";
	}
	
	//로그인
	//로그인 폼 호출
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String formLogin() {
		return "memberLogin";
	}
	
	//로그인 폼에 전송된 데이터 처리
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String submitLogin(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("====로그인==== : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		//id와 passwd필드만 체크
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formLogin();
		}
		
		//로그인체크(입력한 id와 pw가 db에 저장된 정보와 일치여부 판단)
		try {
			MemberVO member = memberService.selectCheckMember(memberVO.getId());
			boolean check = false;
			if(member!=null) {
				//비밀번호 일치여부 판단
				check=member.isCheckedPassword(memberVO.getPasswd());
			}
			if(check) {//인증성공, 로그인처리
				session.setAttribute("user_num", member.getMem_num());
				session.setAttribute("user_id", member.getId());
				
				return "redirect:/main/main.do";
			}else {
				throw new AuthCheckException();
			}
		}catch (AuthCheckException e) {
			//에러 메시지 처리
			result.reject("invalidIdOrPassword");
			//인증실패로 로그인폼 호출
			return formLogin();
		}
	}
	
	//회원로그아웃
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		
		//로그아웃
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	//회원상세정보
	@RequestMapping("/member/myPage.do")
	public String process(HttpSession session,Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		MemberVO member = memberService.selectMember(user_num);
		
		model.addAttribute("member", member);
		
		return "memberView";
	}
	
	//회원정보수정
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String formUpdate(HttpSession session, Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		MemberVO memberVO = memberService.selectMember(user_num);
		
		model.addAttribute("memberVO", memberVO);
		
		
		return "memberModify";
	}
	
	//수정폼에서 전송된 데이터 처리
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result, HttpSession session ) {
		
		if(log.isDebugEnabled()) {
			log.debug("====회원정보수정====  :  " + memberVO );
		}
		
		//유효성체크결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "memberModify";
		}
		
		//회원번호구하기
		Integer user_num = (Integer)session.getAttribute("user_num");
		memberVO.setMem_num(user_num);
		
		//회원정보 수정
		memberService.updateMember(memberVO);
		
		
		return "redirect:/member/myPage.do";
	}
	
	//비밀번호 수정
	//비밀번호 수정 폼
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.GET)
	public String formChangePassword() {
		return "memberChangePassword";
	}
	
	//비밀번호 수정폼에서 전송된 데이터 처리
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.POST)
	public String submitChangePassword(@Valid MemberVO memberVO, BindingResult result,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("====비밀번호 수정==== : " + memberVO);
		}
		//유효성체크결과 오류가 있으면 폼 호출
		if(result.hasFieldErrors("now_passwd") || result.hasFieldErrors("passwd")) {
			return formChangePassword();
		}

		//비밀번호 일치 여부 체크
		//회원번호구하기
		Integer user_num = (Integer)session.getAttribute("user_num");
		MemberVO member = memberService.selectMember(user_num);
		//폼에서 전송한 현재 비밀번호와 DB의 비밀번호 일치여부 판단
		if(!member.getPasswd().equals(memberVO.getNow_passwd())) {
			//인증 실패
			result.rejectValue("now_passwd", "invalidPassword");
			return formChangePassword();
		}
		
		//비밀번호 변경
		memberVO.setMem_num(user_num);
		memberService.updatePassword(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	//회원탈퇴
	//회원정보 삭제 폼
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String formDelete() {
		return "memberDelete";
	}
	
	//회원정보 삭제를 위한 데이터처리
	@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
	public String submitDelete(@Valid MemberVO memberVO, BindingResult result,HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("====회원탈퇴==== : " + memberVO);
		}
		
		//유효성체크 id,pw체크
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formDelete();
		}
		Integer user_num = (Integer)session.getAttribute("user_num");
		//id,pw인증
		try {
			MemberVO member = memberService.selectMember(user_num);
			boolean check = false;
			
			if(member != null && memberVO.getId().equals(member.getId())) {
				//비밀번호 일치 여부
				check=member.isCheckedPassword(memberVO.getPasswd());
			}
			if(check) {
				//인증성공, 회원탈퇴
				memberService.deleteMember(user_num);
				//로그아웃
				session.invalidate();
				
				return "redirect:/main/main.do";
			}else {
				//인증실패
				throw new AuthCheckException();
			}
			
			
		} catch (AuthCheckException e) {
			result.reject("invalidIdOrPassword");
			return formDelete();
		}
		
		
	}
	
}
