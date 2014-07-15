package redditRST;

import java.util.LinkedList;

public class RunWindowTask extends java.util.TimerTask{
	private LinkedList<RequestWindow> downloadWindowQueue;
	private int secondsPerWindow;

	public RunWindowTask(LinkedList<RequestWindow> downloadWindowQueue,
						 int secondsPerWindow){
		super();
		this.downloadWindowQueue = downloadWindowQueue;
		this.secondsPerWindow = secondsPerWindow;
	}

	@Override
	public void run(){
		RequestWindow window = downloadWindowQueue.peekFirst();
		if (window != null) {
			boolean response = window.activate();
			if (!response){
				System.out.println("Activation failed: already activated");
			}
		}
		else {
			System.out.println("Activation failed: no window to activate");
		}
	}
}