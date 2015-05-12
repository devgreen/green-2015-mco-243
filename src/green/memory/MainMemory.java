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
		memory.allocate(1, 100);
		memory.allocate(2, 50);
		memory.allocate(3, 256);
		memory.allocate(1, 50);
		memory.free(1);
		memory.print();
		memory.allocate(4, 256);
		memory.print();
	}

}
