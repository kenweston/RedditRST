package redditRSA;

import java.util.TimerTask;

public class RequestTask extends TimerTask{
	private ApiRequest [] requests;
	
	public RequestTask(ApiCall call){
		super();
		requests = new ApiRequest[1];
		requests[0] = new ApiRequest(call);
	}

	public RequestTask(ApiCall [] calls){
		super();
		requests = new ApiRequest[calls.length];
		for (int i = 0; i < calls.length; i++){
			requests[i] = new ApiRequest(calls[i]);
		}
	}

	@Override
	public void run(){

	}

	public int getSize(){
		return requests.length;
	}
}