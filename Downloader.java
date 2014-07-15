package redditRST;

import java.util.LinkedList;
import java.util.Timer;

public class Downloader{
	private LinkedList<RequestWindow> downloadWindowQueue;
	private int callsPerWindow;
	private int secondsPerWindow;
	private Timer windowTimer;
	private RunWindowTask windowTask;
	private boolean activated;

	public Downloader(int callsPerWindow,
					  int secondsPerWindow){
		this.callsPerWindow = callsPerWindow;
		this.secondsPerWindow = secondsPerWindow;
		this.downloadQueue = new LinkedList<RequestWindow>();
		this.windowTask = new RunWindowTask(downloadQueue, secondsPerWindow);
		this.activated = false;
	}

	/*
		This block of functions are add requests. They utilize the addRequestHelper to
		add API calls to the download queue.
		*/
	public int addRequest(ApiCall call) {
		return addRequest(call, 0);
	}

	public int addRequest(ApiCall [] calls) throws Exception{
		return addRequest(calls, 0);
	}

	public int addRequest(ApiCall call, int windowIndex) {
		RequestTask request = new RequestTask(call);
		return addRequestHelper(request, windowIndex);
	}

	public int addRequest(ApiCall [] calls, int windowIndex) throws Exception{
		if (calls.length > callsPerWindow) {
			throw new Exeption();
		}
		RequestTask = new RequestTask(calls);
		return addRequestHelper(request, windowIndex);
	}

	private int addRequestHelper(RequestTask request, int windowIndex){
		RequestWindow window;
		try {
			// get the current window
			window = downloadWindowQueue.get(windowIndex);
		}
		catch (IndexOutOfBoundsException err) {
			// current window does not exist; make it
			window = new RequestWindow(callsperWindow);
			downloadWindowQueue.addLast(window);
		}
		if (window.getSize() + request.getSize() <= window.getMaxSize()){
			// add this request to the end of the window
			window.addLast(request);
			return windowIndex;
		}
		else{
			return addRequestHelper(request, windowIndex + 1);
		}
	}

	public boolean beginDownloading(){
		if (this.activated){
			return false;
		}
		else {
			this.activated = true;
			windowTimer.scheduleAtFixedRate((Timer)windowTask,
											0,
											secondsPerWindow * 1000);
			return true;
		}
}