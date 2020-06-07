package exper5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author LittleControl
 * @date 2020/6/1 上午 07:01
 * @website www.littlecontrol.cn
 */
public class EchoClient {
    private String remoteHost = "localhost";
    private int remotePort = 8000;
    private DatagramSocket socket;

    public EchoClient() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new EchoClient().talk();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void talk() throws IOException{
        try {
            InetAddress remoteIP = InetAddress.getByName(remoteHost);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {
                byte[] outputData = msg.getBytes();
                DatagramPacket outputPacket = new DatagramPacket(outputData, outputData.length, remoteIP,remotePort);
                socket.send((outputPacket));
                DatagramPacket inputPacket = new DatagramPacket(new byte[512], 512);
                socket.receive(inputPacket);
                System.out.println(new String(inputPacket.getData(), 0, inputPacket.getLength()));
                if(msg.equals("bye")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}























