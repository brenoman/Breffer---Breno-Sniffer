import jpcap.PacketReceiver;
import jpcap.packet.Packet;

class Imprimidor implements PacketReceiver {
	// this method is called every time Jpcap captures a packet
	public void receivePacket(Packet packet) {
		
		if ((packet.toString().toString().indexOf("TCP 1863") != -1) || (packet.toString().toString().indexOf(" > 1863") != -1)) {
			// just print out a captured packet
			/*
			 * System.out.println(packet.toString().toString());
			 * System.out.println(packet.header.length);
			 */
			int i = 0;
			byte[] bytes = packet.data;
			String x = new String(bytes);
			String informacoes[] = new String[3];
			informacoes[0] = new String();
			informacoes[1] = new String();
			informacoes[2] = new String();
			//System.out.println(packet.data.toString());
			System.out.println(packet.toString());
			System.out.println(x + "\n--------------------\n");
			/*
			try {
				informacoes[0] = x.substring(x.indexOf("MSG"), x.indexOf("\n"));
				informacoes[1] = packet.toString().substring(
						packet.toString().indexOf("/"),
						packet.toString().indexOf("->"));
				informacoes[2] = x.substring(x.indexOf("RL=0") + 5);
				System.out.println("De: " + informacoes[0] + "\nPara: "
						+ informacoes[1] + "\nMensagem: " + informacoes[2]);
			} catch (Exception e) {
			}
			System.out.println();*/
		}
		
	}
}
