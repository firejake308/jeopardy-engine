package serverside;

import java.net.SocketException;

public class Main {

	public static void main(String[] args) {
		try {
			new JeopardyServerThread().start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}
