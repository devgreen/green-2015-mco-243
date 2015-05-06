package green.os.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scheduler{

	private static final int QUANTAM = 10;

	private List<FakeProcesses> list;
	private SchedulerAlgorithm algorithm;

	public Scheduler(SchedulerAlgorithm algorithm) {
		this.algorithm = algorithm;
		list = new ArrayList<>();
	}

	public void run() throws InterruptedException {
		
		while (!list.isEmpty()) {
			FakeProcesses process = algorithm.getNextProcess(list);
			/*if (process == null){
				break;
			}*/
			list.remove(process);
			process.run(QUANTAM);
			if (process.isStillRunning()) {
				list.add(process);
				process.setLastProcessed(System.currentTimeMillis());
				//System.out.println ("put back on the list");
			}
		}
	}

	public void populateList(){
		Random random = new Random ();
		for (int i =0; i< 100; i++){
			int runtime = random.nextInt(25) + 5;
			FakeProcesses f = new FakeProcesses (i, runtime *10, 0);
			list.add(f);
			
		}
	}

	public List<FakeProcesses> getList() {
		return list;
	}
	
	

}
