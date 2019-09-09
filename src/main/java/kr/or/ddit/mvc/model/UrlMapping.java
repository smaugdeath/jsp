package kr.or.ddit.mvc.model;

public class UrlMapping {
	
	private String url;
	private String Controller;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getController() {
		return Controller;
	}
	public void setController(String controller) {
		Controller = controller;
	}
	
	@Override
	public String toString() {
		return "UrlMapping [url=" + url + ", Controller=" + Controller + "]";
	}
	
	

}
