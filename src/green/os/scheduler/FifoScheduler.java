package green.os.scheduler;

import java.util.ArrayList;
import java.util.List;

public class FifoScheduler {
	
	private List<FakeProcesses> list;
	private SchedulerAlgorithm algorithm;

	public FifoScheduler(SchedulerAlgorithm algorithm) {
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
			process.run(process.getTimeToCompletion());
			System.out.println ("finished a process");
			/*if (process.isStillRunning()) {
				list.add(process);
				System.out.println ("put back on the list");
			}*/
		}
	}

	public void populateList(){
		for (int i =0; i< 100; i++){
			FakeProcesses f = new FakeProcesses (i, i*100 + 5, 0);
			list.add(f);
			
		}
	}

	public List<FakeProcesses> getList() {
		return list;
	}
	
	


}
