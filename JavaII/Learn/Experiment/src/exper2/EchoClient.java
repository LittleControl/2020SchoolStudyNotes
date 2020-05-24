package exper2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: www.littlecontrol.cn
 * @Date: 2020/5/22 上午 06:28
 */
public class EchoClient {
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
            System.out.print("请输入你的name：");
            String username = stdIn.readUTF();
            System.out.println(username);
            os.writeUTF(username);
//            String fromServer, fromUser;
//            while ((fromServer = is.readUTF()) != null) {
//                System.out.println("Server:" + fromServer);
//                if (fromServer.equals("bye")) break;
//                System.out.print("Client:");
//                fromUser = stdIn.readLine();
//                os.writeUTF(username + "#" + fromUser);
//            }
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
