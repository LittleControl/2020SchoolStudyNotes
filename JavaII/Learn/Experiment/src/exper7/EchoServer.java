package exper7;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author LittleControl
 * @date 2020/6/25 下午 10:42
 * @website www.littlecontrol.cn
 */
public interface EchoServer extends Remote {
    String sayHello(String message) throws RemoteException;
    public int plus(int a, int b);
    public int minus(int a, int b);

}
