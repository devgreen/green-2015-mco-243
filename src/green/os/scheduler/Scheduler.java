package green.os.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler{

	private static final int QUANTAM = 10;

	private List<FakeProcesses> list;
	private SchedulerAlgorithm algorithm;

	public Scheduler(SchedulerAlgorithm algorithm) {
		this.algorithm = algorithm;
		list = new ArrayList<>();
	}

	public void run() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis()-startTime)< 10000) {
			FakeProcesses process = algorithm.getNextProcess(list);
			if (process == null){
				break;
			}
			list.remove(process);
			process.run(QUANTAM);
			if (process.isStillRunning()) {
				list.add(process);
				process.setLastProcessed(System.currentTimeMillis());
				System.out.println ("put back on the list");
			}
		}
	}

	public void populateList(){
		for (int i =0; i< 100; i++){
			FakeProcesses f = new FakeProcesses (i, i*1000 + 5, 0);
			list.add(f);
			
		}
	}

	public List<FakeProcesses> getList() {
		return list;
	}
	
	

}
