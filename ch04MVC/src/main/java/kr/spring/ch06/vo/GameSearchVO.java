package kr.spring.ch06.vo;

public class GameSearchVO {
	private String type;
	private String query;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	@Override
	public String toString() {
		return "GameSearchVO [type=" + type + ", query=" + query + "]";
	}
}




