package green.memory;

public class MainMemory {

	private int totalBytes;
	private int[][] memory;

	public MainMemory(int totalBytes) {
		this.totalBytes = totalBytes;
		memory = new int[totalBytes / 128][128];

	}

	public boolean allocate(int processID, int numBytes) {
		int numPlaced = 0;
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == 0) {
					memory[i][j] = processID;
					numPlaced++;
					if (numPlaced == numBytes) {
						return true;
					}
				}
			}

		}
		free(processID);

		return false;

	}

	public void free(int pid) {
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == pid) {
					memory[i][j] = 0;

				}
			}

		}

	}

	public void print() {
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] != 0) {
					System.out.print(memory[i][j]);
				} else {
					System.out.print("-");
				}
			}
			System.out.println();

		}

	}

	public static void main(String[] args) {
		MainMemory memory = new MainMemory(640);
		boolean allocate = memory.allocate(1, 100);
		if (!allocate){
			System.out.println ("not enough memory available");
		}
		allocate = memory.allocate(2, 50);
		if (!allocate){
			System.out.println ("not enough memory available");
		}
		allocate = memory.allocate(3, 256);
		if (!allocate){
			System.out.println ("not enough memory available");
		}
		allocate =	memory.allocate(1, 50);
		if (!allocate){
			System.out.println ("not enough memory available");
		}
		memory.print();
		memory.free(1);
		memory.print();
		allocate = memory.allocate(4, 256);
		if (!allocate){
			System.out.println ("not enough memory available");
		}
		memory.print();
	}

}
