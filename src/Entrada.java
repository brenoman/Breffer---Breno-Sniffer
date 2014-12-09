import java.io.IOException;
import java.net.NetworkInterface;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterfaceAddress;

public class Entrada {
	private static final String FILTER = "proto TCP";
	public static void main(String[] args) {
		jpcap.NetworkInterface[] devices = JpcapCaptor.getDeviceList();
		// for each network interface
		for (int i = 0; i < devices.length; i++) {
			// print out its name and description
			System.out.println(i + ": " + devices[i].name + "("
					+ devices[i].description + ")");

			// print out its datalink name and description
			System.out.println(" datalink: " + devices[i].datalink_name + "("
					+ devices[i].datalink_description + ")");

			// print out its MAC address
			System.out.print(" MAC address:");
			for (byte b : devices[i].mac_address)
				System.out.print(Integer.toHexString(b & 0xff) + ":");
			System.out.println();

			// print out its IP address, subnet mask and broadcast address
			for (NetworkInterfaceAddress a : devices[i].addresses)
				System.out.println(" address:" + a.address + " " + a.subnet
						+ " " + a.broadcast);
		}
		try {
			JpcapCaptor capturador = JpcapCaptor.openDevice(devices[2],65000,true,20);
			//call processPacket() to let Jpcap call PacketPrinter.receivePacket() for every packet capture.
			//capturador.setFilter(FILTER, true);
			capturador.loopPacket(-1,new Imprimidor());

			capturador.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}