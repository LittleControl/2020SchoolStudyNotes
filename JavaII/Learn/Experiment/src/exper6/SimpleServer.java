package exper6;

import java.io.*;
import java.net.*;
import java.util.*;
public class SimpleServer {
    public void send(Object object)throws IOException{
        ServerSocket serverSocket = new ServerSocket(8001);
        while(true){
            Socket socket=serverSocket.accept();//建立socket连接
            OutputStream out=socket.getOutputStream();//获得socket输入流
            ObjectOutputStream oos=new ObjectOutputStream(out);//获得对象输出流
            oos.writeObject(object); // 第一次发送对象
            oos.writeObject(object); // 第二次发送同一个对象
            oos.writeFloat(1.2f);//发送一个浮点数
            oos.close();//输出路关闭
            socket.close();//socket关闭
        }
    }
    public static void main(String args[])throws IOException {
        Object object=null;
        if(args.length>0 && args[0].equals("Date"))
            object=new Date();
        else if(args.length>0 && args[0].equals("Customer1"))
            object=new Customer1("Tom","1234");
        else if(args.length>0 && args[0].equals("Customer2")){
            Customer2 customer=new Customer2("Tom");
            Order2 order1=new Order2("number1",customer);
            Order2 order2=new Order2("number2",customer);
            customer.addOrder(order1);
            customer.addOrder(order2);
            object=customer;
        }else if(args.length>0 && args[0].equals("Customer3")){
            object=new Customer3("Tom","1234");
        }else if(args.length>0 && args[0].equals("Customer4")){
            Customer4 customer=new Customer4("Tom");
            Order4 order1=new Order4("number1",customer);
            Order4 order2=new Order4("number2",customer);
            customer.addOrder(order1);
            customer.addOrder(order2);
            object=customer;
        }else if(args.length>0 && args[0].equals("Customer5")){
            object=new Customer5("Tom",25);
        }else{
            object="Hello";
        }
        System.out.println("waiting for sent object:"+object);
        new SimpleServer().send(object);
    }
}
