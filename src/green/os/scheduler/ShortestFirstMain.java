package green.os.scheduler;

import java.util.List;

public class ShortestFirstMain {
	
	
	public static void main (String [] args){
		long startTime = 0;
		ShortFirstAlgorithm shortest = new ShortFirstAlgorithm();
		Scheduler s = new Scheduler(shortest);
		s.populateList();
		try {
			startTime = System.currentTimeMillis();
			s.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println ("done " + time);
	/*	List<FakeProcesses> list = s.getList();
		System.out.println (list.size());*/
	}

}
