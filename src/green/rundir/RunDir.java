package green.rundir;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class RunDir {

		public static void main(String[] args) {

			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
			catch (IOException e1) {
			}

		}


}
