package redditRST;

import java.util.LinkedList;

public class RequestWindow{
	private LinkedList<RequestTask> RequestList;
	private int size;
	private int maxSize;
	private boolean activated;

	public RequestWindow(int maxSize){
		RequestList = new LinkedList<RequestItem>();
		this.size = 0;
		this.maxSize = maxSize;
		this.activated = false;
	}

	public int getSize(){
		return size;
	}

	public int getMaxSize(){
		return maxSize;
	}

	public RequestTask getFirst(){
		return RequestList.getFirst();
	}

	public RequestTask getLast(){
		return RequestList.getLast();
	}

	public boolean addFirst(RequestTask e){
		if (size + e.getSize() <= maxSize){
			RequestList.addFirst(e);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean addLast(RequestTask e){
		if (size + e.getSize() <= maxSize){
			RequestList.addLast(e);
			return true;
		}
		else {
			return false;
		}
	}

	public RequestTask pollFirst() {
		RequstTask e = RequestList.pollFirst();
		// lower the size of RequestList
		if (!(e == null)) {
			size -= e.getSize();
		}
		return e;
	}

	public RequestTask pollLast() {
		RequestTask e = RequestList.pollLast();
		// lower the size of RequestList
		if (!(e == null)) {
			size -= e.getSize();
		}
		return e;
	}

	/*
		This set of functions deals with the timer aspect
		*/
	protected boolean activate(){
		if (activated){
			return false;
		}
		else {
			return true;
		}
	}
}