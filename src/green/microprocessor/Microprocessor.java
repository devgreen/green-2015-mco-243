package green.microprocessor;

import java.util.Scanner;

public class Microprocessor {

	public static void main(String[] args) {

		String accuA = "0";
		String accuB = "0";

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		String[] info = new String[256];
		for (int k = 0; k < info.length; k++) {
			info[k] = String.valueOf(input.charAt(k));
		}
		int i = 0;
		int instruction;

		StringBuilder builder = new StringBuilder();

		do {

			instruction = Integer.parseInt(info[i], 16);

			switch (instruction) {

			case 0:

				builder.append(info[i + 1]);
				builder.append(info[i + 2]);
				String loc = builder.toString();
				int a = Integer.parseInt(loc, 16);
				accuA = info[a].toUpperCase();
				i = i + 3;
				builder.setLength(0);
				break;

			case 1:

				builder.append(info[i + 1]);
				builder.append(info[i + 2]);
				loc = builder.toString();

				a = Integer.parseInt(loc, 16);
				info[a] = accuA;

				i = i + 3;
				builder.setLength(0);
				break;
			case 2:
				String temp = accuA;
				accuA = accuB;
				accuB = temp;
				i++;
				break;
			case 3:
				int valueA = Integer.parseInt(accuA, 16);
				int fromB = Integer.parseInt(accuB, 16);
				int total = valueA + fromB;
				String hex = Integer.toHexString(total);
				if (hex.length() == 2) {
					accuA = String.valueOf(hex.charAt(1)).toUpperCase();
					accuB = String.valueOf(hex.charAt(0)).toUpperCase();
				} else {
					accuA = hex.toUpperCase();
				}
				i++;
				break;
			case 4:
				int value = Integer.parseInt(accuA, 16);
				if (value < 15) {
					value++;
					accuA = Integer.toHexString(value).toUpperCase();
				} else if (value == 15) {
					accuA = "0";
				}
				i++;

				break;
			case 5:
				value = Integer.parseInt(accuA, 16);
				if (value != 0) {
					value--;
					accuA = Integer.toHexString(value).toUpperCase();
				} else if (value == 0) {
					accuA = "F";
				}
				i++;
				break;
			case 6:
				value = Integer.parseInt(accuA, 16);
				if (value != 0) {
					i = i + 3;
					break;
				} else {

					builder.append(info[i + 1]);
					builder.append(info[i + 2]);
					loc = builder.toString();
					a = Integer.parseInt(loc, 16);
					i = a;
					builder.setLength(0);
					i = i + 3;

				}

				break;
			case 7:
				builder.append(info[i + 1]);
				builder.append(info[i + 2]);
				loc = builder.toString();
				a = Integer.parseInt(loc, 16);
				i = a;
				builder.setLength(0);
				break;

			}

		} while (instruction != 8);

		for (int j = 0; j < info.length; j++) {
			System.out.print(info[j]);

		}
		System.out.println("\n");

	}

}
