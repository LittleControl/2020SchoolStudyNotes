package cn.littlecontrol;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: www.littlecontrol.cn
 * @Date: 2020/5/9 上午 08:25
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.1.4");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.littlecontrol.cn");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
