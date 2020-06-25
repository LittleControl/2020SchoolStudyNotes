package exper7;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author LittleControl
 * @date 2020/6/25 下午 10:04
 * @website www.littlecontrol.cn
 */
public class Server implements Hello {
    public static void main(String[] args) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 56666);
            Registry registry = LocateRegistry.createRegistry(11099);
            registry.bind("Hello", stub);

        } catch (Exception e) {
            System.out.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public String sayHello() throws RemoteException {
        return "Hello, World";
    }

    @Override
    public String sayHello(String message) throws RemoteException {
        return message;
    }
}

/*
Server 类实现了 Hello 接口，在 main 函数中创建并导出 remote object，接着将 remote object 注册到 RMI registry 中
UnicastRemoteObject.exportObject(obj, 56666) 方法执行完后，会运行 rmi server，监听在本地 56666 端口，
等待 client 的请求。exportObject() 方法返回结果为 remote object stub (代理对象，实现了与 Hello 接口同样的方法，
包含 rmi server 的 host、port 信息)
LocateRegistry.createRegistry(11099); 执行完后，会创建并启动 RMI registry，监听在本地 11099 端口
registry.bind("Hello", stub); 将 stub 注册到 registry，并与 name Hello 绑定
*/
