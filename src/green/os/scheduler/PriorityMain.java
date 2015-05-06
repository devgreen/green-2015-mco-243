package green.os.scheduler;

import java.util.List;

public class PriorityMain {

	public static void main(String[] args) {
		long startTime = 0;
		PriorityAlgorithm p = new PriorityAlgorithm();
		Scheduler s = new Scheduler(p);
		s.populateList();
		try {
			startTime = System.currentTimeMillis();
			s.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("done " + time);
	/*	List<FakeProcesses> list = s.getList();
		System.out.println(list.size());*/
	}

}
