package redditRSA;

import java.net.URL;

public class ApiCall {
	private URL url;

	public final String REDDIT_DOMAIN = "www.reddit.com";
	public final String HTTP_METHOD = "http";
	public final String HTTPS_METHOD = "https";

	public ApiCall(String command) throws Exception{
		url = new URL(HTTP_METHOD,
					  REDDIT_DOMAIN,
					  command);
	}

	public URL get_url(){
		return url;
	}
}