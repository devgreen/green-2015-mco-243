package green.os.scheduler;

import java.util.List;

public class PriorityAlgorithm implements SchedulerAlgorithm{

	@Override
	public FakeProcesses getNextProcess(List<FakeProcesses> list) {
	/*	FakeProcesses priority = null;
		if (list.isEmpty()){
			System.out.println ("all processes have completes");
			
		}
		else {*/
		FakeProcesses priority = list.get(0);
		for (FakeProcesses p : list) {
			if (System.currentTimeMillis() - p.getLastProcessed() > 100){
				p.setPriority(0);
				return p;
			}
			if (p.getPriority() < priority.getPriority()) {
				priority = p;
			}
		}
		
		return priority;
	}

}
