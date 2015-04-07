package cn.edu.bupt.entity;

public class TargetUrl {
	private String name;
	private String url;
	private String host;
	private String referer;
	private String pattern;
	public TargetUrl(String name, String url, String host, String referer,
			String pattern) {
		super();
		this.name = name;
		this.url = url;
		this.host = host;
		this.referer = referer;
		this.pattern = pattern;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String getHost() {
		return host;
	}
	public String getReferer() {
		return referer;
	}
	public String getPattern() {
		return pattern;
	}
	
	
}
