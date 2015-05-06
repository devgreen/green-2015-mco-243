package green.os.scheduler;

import java.util.List;

public class FifoMain {
	
	
	public static void main (String [] args){
		
		long startTime = 0;
		FifoAlgorithm fifo = new FifoAlgorithm();
		Scheduler s = new Scheduler(fifo);
		s.populateList();
		try {
			s.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("done " + time);
	/*	List<FakeProcesses> list = s.getList();
		System.out.println (list.size());*/
	}

}
