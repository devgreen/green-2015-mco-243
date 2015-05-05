package green.os.scheduler;

import java.util.List;

public class ShortFirstAlgorithm implements SchedulerAlgorithm {

	@Override
	public FakeProcesses getNextProcess(List<FakeProcesses> list) {
		FakeProcesses shortest = null;
		if (list.isEmpty()){
			System.out.println ("all processes have completes");
			
		}
		else {
		shortest = list.get(0);
		for (FakeProcesses p : list) {
			if (p.getTimeToCompletion() < shortest.getTimeToCompletion()) {
				shortest = p;
			}
		}
		}
		return shortest;
	}

}
