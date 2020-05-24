package exper1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: www.littlecontrol.cn
 * @Date: 2020/5/15 上午 06:26
 */
public class server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket cs = null;
        DataOutputStream os = null;
        DataInputStream is = null;
        try {
            ss = new ServerSocket(8090);
            System.out.println("服务器开始监听8090端口的连接请求");
            cs = ss.accept();
            os = new DataOutputStream(cs.getOutputStream());
            is = new DataInputStream(cs.getInputStream());
            String inputStr, outputStr;
            //输出操作
            os.writeUTF("Welcome to My Chat Server");
            os.flush();//立即将数据从输出缓存提交给网络发送
            DataInputStream stdIn = new DataInputStream(System.in); //获得键盘输入流
            //输入操作
            while ((inputStr = is.readUTF()) != null) { //接受网络数据
                System.out.println("Customer:" + inputStr);
                System.out.print("Server:");
                outputStr = stdIn.readUTF();  //接受键盘输入
                os.writeBytes(outputStr);
                os.flush();
                if (outputStr.equals("bye")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(cs != null) {
                try {
                    cs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
