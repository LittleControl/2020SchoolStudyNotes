package exper7;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author LittleControl
 * @date 2020/6/25 下午 10:05
 * @website www.littlecontrol.cn
 */
public class Client {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 11099;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello("Hello");
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

/*LocateRegistry.getRegistry(host, port); 获取 rmi registry
registry.lookup("Hello") 获取 remote object stub
调用 stub 的 sayHello() 方法背后的流程：
client 端通过 stub 中包含的 host、port 信息，与 remote object 所在的 server 建立连接 ，然后序列化调用数据
server 端接收调用请求，将调用转发给 remote object，然后序列化结果，返回给 client
client 端接收、反序列化结果
*/
