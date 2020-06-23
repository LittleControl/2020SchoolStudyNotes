package exper6;

import java.io.*;
import java.util.*;

public class Customer2 implements Serializable {
    private String name;
    private Set<Order2> orders = new HashSet<Order2>();             //Customer2与Order2关联
    static {
        System.out.println("调用Customer2类的静态代码块");
    }
    public Customer2() {
        System.out.println("调用Customer2类的不带参数的构造方法");
    }
    public Customer2(String name) {
        System.out.println("调用Customer2类的带参数的构造方法");
        this.name = name;
    }
    public void addOrder(Order2 order) {
        orders.add(order);
    }
    public String toString() {
        String result = super.toString() + "\r\n"
                + orders + "\r\n";
        return result;
    }
}

class Order2 implements Serializable {          //表示订单
    private String number;
    private Customer2 customer;
    //Order2与Customer2关联
    public Order2() {
        System.out.println("调用Order2类的不带参数的构造方法");
    }
    public Order2(String number, Customer2 customer) {
        System.out.println("调用Order2类的带参数的构造方法");
        this.number = number;
        this.customer = customer;
    }
}
