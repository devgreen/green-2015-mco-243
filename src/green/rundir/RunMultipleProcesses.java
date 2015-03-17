package green.rundir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunMultipleProcesses {

	public static void main(String[] args) {
		// tell java program to use bin folder as class path- java -cp ./bin
		try {
			// Process p = Runtime.getRuntime().exec("cmd /c echo %cd%");
			// Process p2 = Runtime.getRuntime().exec("Client");

			Process runServer = Runtime.getRuntime().exec("java -cp ./bin green.rundir.Server");
			Process runClient = Runtime.getRuntime().exec("java -cp ./bin green.rundir.Client");

			BufferedReader reader = new BufferedReader(new InputStreamReader(runServer.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("im done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
