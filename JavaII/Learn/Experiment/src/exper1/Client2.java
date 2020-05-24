package exper1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: www.littlecontrol.cn
 * @Date: 2020/5/15 上午 06:46
 */
public class Client2 {
    public static void main(String[] args) {
        Socket cs = null;//发出连接请求
        DataOutputStream os = null;
        DataInputStream is = null;
        DataInputStream stdIn = null;
        try {
            cs = new Socket("localhost", 8090);
            is = new DataInputStream(cs.getInputStream());
            os = new DataOutputStream(cs.getOutputStream());
            stdIn = new DataInputStream(System.in);
            System.out.print("请输入你的用户名：");
            String username = stdIn.readLine();
            String fromServer, fromUser;
            while ((fromServer = is.readUTF()) != null) {
                System.out.println("Server:" + fromServer);
                if (fromServer.equals("bye")) break;
                System.out.print("Client:");
                fromUser = stdIn.readLine();
                os.writeUTF(username + "#" + fromUser);
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
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(stdIn != null) {
                try {
                    stdIn.close();
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
        }
    }
}
