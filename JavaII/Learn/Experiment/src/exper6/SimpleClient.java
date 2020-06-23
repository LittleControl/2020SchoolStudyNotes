package exper6;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
public class SimpleClient {
    public void receive()throws Exception{
        Socket socket = new Socket("localhost",8001);
        InputStream in=socket.getInputStream();
        ObjectInputStream ois=new ObjectInputStream(in);
        Object object1 =ois.readObject();  //接收服务器发送的第一个对象
        Object object2=ois.readObject();//接收服务器发送的第二个对象
        System.out.println(object1);
        System.out.println(object2);
        System.out.println("objectl与object2是否为同一个对象:" +(object1==object2));
    }
    public static void main(String args[])throws Exception {
        new SimpleClient().receive();
    }
}
