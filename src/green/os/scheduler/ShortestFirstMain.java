package green.os.scheduler;

import java.util.List;

public class ShortestFirstMain {
	
	
	public static void main (String [] args){
		
		ShortFirstAlgorithm shortest = new ShortFirstAlgorithm();
		Scheduler s = new Scheduler(shortest);
		s.populateList();
		try {
			s.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println ("done");
		List<FakeProcesses> list = s.getList();
		System.out.println (list.size());
	}

}
