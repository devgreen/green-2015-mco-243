package green.os.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {

	FakeProcesses getNextProcess(List<FakeProcesses> list);

}
