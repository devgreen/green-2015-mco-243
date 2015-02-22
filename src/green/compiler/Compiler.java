package green.compiler;

import java.util.ArrayList;
import java.util.Scanner;

public class Compiler {

	public static void main (String [] args){
		
		Scanner scanner = new Scanner (System.in);
		StringBuilder output = new StringBuilder();
		int [] ready = new int[256];
		int counter = 0;
		
		
		ArrayList<String> input = new ArrayList<String>();
		
		for (int i =0; i< 10; i++){
			String next = scanner.nextLine();
			input.add(next);
		}
		String nextLine;
		do{
			nextLine = input.get(counter);	
			String [] info = nextLine.split(" ");
			input.remove(counter);
			for (int i =0; i< info.length; i++){
				
			}
			
			
			
		switch(/*nextLine*/ info[0]){
		
		
		case "LD"://need to add
			ready[counter] = 0;
			counter++;
			output.append(0);
			output.append(Integer.toHexString(Integer.parseInt(info[1])));
			
			break;
			
		case "ST"://need to add
			ready[counter] = 1;
			counter++;
			output.append(1);
			output.append(Integer.toHexString(Integer.parseInt(info[1])));
			break;
			
		case "SWP":
			ready[counter] = 2;
			counter++;
			output.append(2);
			break;
			
		case "ADD":
			ready[counter] = 3;
			counter++;
			output.append(3);
			break;
			
		case "INC":
			ready[counter] = 4;
			counter++;
			output.append(4);
			break;
		case "DEC":
			ready[counter] = 5;
			counter++;
			output.append(5);
			break;
			
		case "BZ"://need to add
			ready[counter] = 6;
			counter++;
			output.append(6);
			output.append(Integer.toHexString(Integer.parseInt(info[1])));
			break;
		case "BR"://need to add
			ready[counter] = 7;
			counter++;
			output.append(7);
			output.append(Integer.toHexString(Integer.parseInt(info[1])));
			break;
			
		case "STP":
			ready[counter] = 8;
			counter++;
			output.append(8);
			break;
		case "DATA":
			output.
			break;
		}
	}while (!input.isEmpty());
		}
}
