package redditRST;

import java.net.URL;

public class ApiRequest extends java.net.HttpURLConnection{
	
	public ApiRequest(ApiCall call){
		super(call.get_url());
	}

	@Override
	public void connect() {
		
	}
	@Override
	public void disconnect(){

	}

	@Override
	public boolean usingProxy() {
		return false;
	}

}