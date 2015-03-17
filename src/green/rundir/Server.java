package green.rundir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(3787);
			while (true) {
				socket = serverSocket.accept();

				InputStream in = socket.getInputStream();

				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					// System.out.println("hello");
				}
				in.close();
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
