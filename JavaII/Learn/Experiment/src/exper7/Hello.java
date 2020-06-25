package exper7;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author LittleControl
 * @date 2020/6/25 下午 10:03
 * @website www.littlecontrol.cn
 */
public interface Hello extends Remote {
//    String sayHello() throws RemoteException;
    String sayHello(String message) throws RemoteException;
    public int plus(int a, int b);
    public int minus(int a, int b);

}
//需要实现 Remote 接口，接口方法需要抛出 RemoteException 或其父类的异常