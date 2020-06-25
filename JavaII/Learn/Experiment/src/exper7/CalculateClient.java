package exper7;

/**
 * @author LittleControl
 * @date 2020/6/25 下午 10:26
 * @website www.littlecontrol.cn
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculateClient {
    public static void main(String[] args) {
        try {
            Hello h = (Hello)Naming.lookup("rmi://192.168.1.4:8848/Hello");
            System.out.println(h.sayHello("Okay"));
        } catch (MalformedURLException e) {
            System.out.println("url格式异常");
        } catch (RemoteException e) {
            System.out.println("创建对象异常");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("对象未绑定");
        }
    }
}
