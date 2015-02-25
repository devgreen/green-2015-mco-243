package green.compiler;

import java.util.ArrayList;
import java.util.Scanner;

public class Compiler {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// StringBuilder output = new StringBuilder();
		String[] ready = new String[256];

		for (int i = 0; i < ready.length; i++) {
			ready[i] = "0";
		}
		int counter = 0;
		int i = 0;

		ArrayList<String> input = new ArrayList<String>();
		String nextA = "";
		while (scanner.hasNextLine()) {
			nextA = scanner.nextLine();
			/*
			 * if (nextA.equals("z")) { break; }
			 */
			input.add(nextA);
		}
		String nextLine;
		do {
			nextLine = input.get(0);
			String[] info = nextLine.split(" ");
			input.remove(0);

			switch (info[0]) {

			case "LD":// need to add
				ready[counter] = "0";
				counter++;
				String next = info[1];
				String hex = Integer.toHexString(Integer.parseInt(next));
				String hexUp = hex.toUpperCase();
				for (int j = 0; j < hexUp.length(); j++) {
					ready[counter] = String.valueOf(hexUp.charAt(j));
					counter++;
				}
				// output.append(0);
				// output.append(Integer.toHexString(Integer.parseInt(info[1])));

				break;

			case "ST":// need to add
				ready[counter] = "1";
				counter++;

				next = info[1];
				hex = Integer.toHexString(Integer.parseInt(next));
				hexUp = hex.toUpperCase();
				for (int k = 0; k < hexUp.length(); k++) {
					ready[counter] = String.valueOf(hexUp.charAt(k));

					counter++;
				}
				// output.append(1);
				// output.append(Integer.toHexString(Integer.parseInt(info[1])));
				break;

			case "SWP":
				ready[counter] = "2";
				counter++;
				// output.append(2);
				break;

			case "ADD":
				ready[counter] = "3";
				counter++;
				// output.append(3);
				break;

			case "INC":
				ready[counter] = "4";
				counter++;
				// output.append(4);
				break;
			case "DEC":
				ready[counter] = "5";
				counter++;
				// output.append(5);
				break;

			case "BZ":// need to add
				ready[counter] = "6";
				counter++;

				next = info[1];
				hex = Integer.toHexString(Integer.parseInt(next));
				hexUp = hex.toUpperCase();
				for (int l = 0; l < hexUp.length(); l++) {
					ready[counter] = String.valueOf(hexUp.charAt(l));
					counter++;
				}
				// output.append(6);
				// output.append(Integer.toHexString(Integer.parseInt(info[1])));
				break;
			case "BR":// need to add
				ready[counter] = "7";
				counter++;
				next = info[1];
				hex = Integer.toHexString(Integer.parseInt(next));
				hexUp = hex.toUpperCase();
				for (int m = 0; m < hexUp.length(); m++) {
					ready[counter] = String.valueOf(hexUp.charAt(m));
					counter++;
				}

				// output.append(7);
				// output.append(Integer.toHexString(Integer.parseInt(info[1])));
				break;

			case "STP":
				ready[counter] = "8";
				counter++;
				// output.append(8);
				break;
			case "DATA":
				int loc = Integer.parseInt(info[0]);
				next = info[1];
				String data = Integer.toHexString(Integer.parseInt(next));
				ready[loc] = String.valueOf(data.charAt(0));
				// output.
				break;

			// case "//":
			// i++;
			// break;
			}
		} while (!input.isEmpty());

		for (int n = 0; n < ready.length; n++) {

			System.out.print(ready[n]);

		}
	}
}
