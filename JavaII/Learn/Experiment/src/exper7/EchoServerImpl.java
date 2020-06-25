package exper7;

import java.rmi.RemoteException;

/**
 * @author LittleControl
 * @date 2020/6/25 下午 10:17
 * @website www.littlecontrol.cn
 */


public class EchoServerImpl implements Hello {
    protected EchoServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String message) throws RemoteException {
        System.out.println("我在RMI的服务器端，客户端正在调用'sayHello'方法。 ");
        System.out.println("Hello " + message);
        return message;
    }

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
