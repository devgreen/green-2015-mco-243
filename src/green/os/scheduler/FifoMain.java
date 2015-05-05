package green.os.scheduler;

import java.util.List;

public class FifoMain {
	
	
	public static void main (String [] args){
		
		FifoAlgorithm fifo = new FifoAlgorithm();
		FifoScheduler s = new FifoScheduler(fifo);
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
