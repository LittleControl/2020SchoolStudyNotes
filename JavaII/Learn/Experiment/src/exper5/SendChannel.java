package exper5;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author LittleControl
 * @date 2020/6/2 上午 07:18
 * @website www.littlecontrol.cn
 */
public class SendChannel {
    public static void main(String[] args) throws InterruptedException, IOException {
        DatagramChannel channel = DatagramChannel.open();
        DatagramSocket socket = channel.socket();
        SocketAddress localAddr = new InetSocketAddress(7000);
        SocketAddress remoteAddr = new InetSocketAddress(InetAddress.getByName("localhost"),8000);
        socket.bind(localAddr);
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            System.out.println("Buffer remain bytes: "+ buffer.remaining());
            int n = channel.send(buffer, remoteAddr);
            System.out.println("Sended bytes: " + n);
            Thread.sleep(500);
        }
    }
}
