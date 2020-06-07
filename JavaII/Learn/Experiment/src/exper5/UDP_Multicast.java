package exper5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author LittleControl
 * @date 2020/6/5 上午 07:30
 * @website www.littlecontrol.cn
 */

public class UDP_Multicast {
    private InetAddress Groupip;//设置组播地址
    private int port;//设置组播端口
    private MulticastSocket msocket;//设置组播套接字

    public UDP_Multicast(String groupip, int port)throws Exception {
        super();
        Groupip = InetAddress.getByName(groupip);
        this.port = port;
        this.msocket = new MulticastSocket(port);//套接字绑定组播端口
        //this.msocket.setTimeToLive(1);//设置组播范围为本地网络
        this.msocket.joinGroup(Groupip);//加入多播组
    }

    public void UDP_Multicast_Leave() {
        try {
            this.msocket.leaveGroup(Groupip);
        } catch (IOException e) {
            System.out.println("退出组播失败！\n");
        }
    }

    public void UDP_Multicast_Send(String msg)throws Exception {

        byte[] buffer = msg.getBytes();//Change String to byte
        DatagramPacket pack = new DatagramPacket(buffer, buffer.length, Groupip, port);//create send package
        try {
            this.msocket.send(pack);//send massage
        }
        catch (Exception e) {
            System.out.println("UDP 数据报发送失败！");
        }
    }

    public String UDP_Multicast_Receive()throws Exception {

        byte[] buffer = new byte[512];//create byte to receive massage
        DatagramPacket pack = new DatagramPacket(buffer, buffer.length);//create pack to receive massage
        this.msocket.receive(pack);//write received massage to pack
        return new String(pack.getData(),0,pack.getLength());//get received massage
    }

    public static void main(String[] args)throws Exception {
        String msg = "Hello!Everyone--by user3\n";//Set user1's massage to send

        UDP_Multicast[]  user = new UDP_Multicast[3];
        for(int i=0;i<3;i++)
            user[i] = new UDP_Multicast("224.119.81.9", 5003);

        user[2].UDP_Multicast_Send(msg);//send massage

        for(int i=0;i<3;i++)
            System.out.println("user["+i+"]received:\r\n"+user[i].UDP_Multicast_Receive());//received massage
    }
}

