package kr.spring.ch05;

public class WriteArticleService {
	private WriteArticleDAO writeArticleDAO;
	
	//의존 관계 설정 방식 : 생성자
	public WriteArticleService(WriteArticleDAO writeArticleDAO) {
		this.writeArticleDAO = writeArticleDAO;
	}
	
	public void write() {
		System.out.println("WriteArticleService의 write 메서드 실행");
		
		writeArticleDAO.insert();
	}
}
