package serverside;

import java.io.IOException;
import java.net.*;

public class JeopardyServerThread extends Thread {
	private DatagramSocket socket;
	
	public JeopardyServerThread() {
		super("Jeopardy Server Thread");
	}
	
	public JeopardyServerThread(String name) throws SocketException {
		super(name);
		socket = new DatagramSocket(42420);
	}
	
	public void run() {
		try {
			byte[] buf = new byte[256];
			
			String msg = "Hello world!";
			buf = msg.getBytes();
			
			InetAddress group = InetAddress.getByName("2013.0.113.0");
			DatagramPacket packet;
			packet = new DatagramPacket(buf, buf.length, group, 42420);
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}
