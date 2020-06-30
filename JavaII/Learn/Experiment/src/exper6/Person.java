package exper6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LittleControl
 * @date 2020/6/30 下午 04:24
 * @website www.littlecontrol.cn
 */
public class Person {
    String name;
    int age;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8001);
            Socket socket=serverSocket.accept();
            OutputStream out=socket.getOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\person.txt"));
            oos.writeObject(new Person());
            oos.writeObject(new Person());
            oos.close();
            socket.close();
    }
}
