package clientside;

import java.io.IOException;
import java.net.*;

public class JeopardyClient {

	public static void main(String[] args) {
		try {
			MulticastSocket socket = new MulticastSocket(42420);
			InetAddress group = InetAddress.getByName("233.0.113.0");
			socket.joinGroup(group);
			
			DatagramPacket packet;
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			
			String msg = new String(packet.getData());
			System.out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
