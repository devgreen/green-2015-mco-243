package green.os.scheduler;

public class FakeProcesses {

	private int priority;
	private int timeToCompletion;
	private long lastProcessed;

	public FakeProcesses(int priority, int timeToCompletion, int lastProcessed) {
		this.priority = priority;
		this.timeToCompletion = timeToCompletion;
		this.lastProcessed = lastProcessed;

	}
	
	public void run(int quantam) throws InterruptedException {
	/*	for (int i = 0; i < quantam; i++) {
			timeToCompletion--;
		}*/
		
		/*long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis()-startTime)< quantam){
			timeToCompletion--;
		}*/
		Thread.sleep(quantam);
		timeToCompletion -=quantam;
	}

	public boolean isStillRunning() {
		return timeToCompletion > 0 ;
	}
	
	public int getPriority() {
		return priority;
	}

	public int getTimeToCompletion() {
		return timeToCompletion;
	}
	
	public long getLastProcessed() {
		return lastProcessed;
	}

	public void setLastProcessed(long lastProcessed) {
		this.lastProcessed = lastProcessed;
	}



	public void setPriority(int i) {
		this.priority = i;
		
	}

}
