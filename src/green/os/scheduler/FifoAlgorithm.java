package green.os.scheduler;

import java.util.List;

public class FifoAlgorithm implements SchedulerAlgorithm {

	@Override
	public FakeProcesses getNextProcess(List<FakeProcesses> list) {
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
