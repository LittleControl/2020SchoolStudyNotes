package exper1;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: www.littlecontrol.cn
 * @Date: 2020/5/15 上午 06:22
 */
public class Client {
    public static void main(String[] args) {
        String hostName = "www.littlecontrol.cn";
        int port = 80;
        Socket cs = null;
        try{
            cs = new Socket(hostName, port);
            System.out.println("连接"+hostName+"的端口"+port+"成功");
            System.out.println("对方主机" + cs.getInetAddress() + "：对方端口" + cs.getPort());
            System.out.println("本地主机" + cs.getLocalAddress() + "：本地端口" + cs.getLocalPort());
        }catch(Exception e){
            System.err.println("无法连接指定服务");
        } finally {
            if(cs != null) {
                try {
                    cs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
