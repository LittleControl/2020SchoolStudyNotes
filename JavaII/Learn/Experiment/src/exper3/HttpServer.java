package exper3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Handler;

/**
 * @author LittleControl
 * @date 2020/5/22 下午 09:00
 * @website www.littlecontrol.cn
 */
public class HttpServer {
    private Selector selector = null; //声明一个Selector成员变量
    private ServerSocketChannel serverSocketChannel = null; //声明一个ServerSocketChannel成员变量
    private int port = 8062; //设置端口号为8062
    private Charset charset = Charset.forName("UTF-8"); //设置字符集为UTF-8

    public HttpServer() throws IOException{ //HttpServer类唯一构造器
        selector = Selector.open();//注册一个selector对象
        serverSocketChannel = ServerSocketChannel.open();//创建一个serverSocketChannel对象
        serverSocketChannel.socket().setReuseAddress(true);//设置为可以顺利在重启后绑定端口
        serverSocketChannel.configureBlocking(false);//设置为非阻塞模式
        serverSocketChannel.socket().bind(new InetSocketAddress(port));//把服务器与一个本地端口进行绑定
        System.out.println("server is running!");
    }
    public void service() throws IOException {
        //注册连接就绪事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT,new AcceptHandler());
        //死循环保持监听
        for(;;){
            int n = selector.select();//取得监听到的事件的数量
            if(n==0) continue; //若无事件发生，则进入下一次循环
            Set readyKeys = selector.selectedKeys(); //将事件存入Set集合中
            Iterator it = readyKeys.iterator(); //获取Set集合的迭代器
            while(it.hasNext()){
                SelectionKey key = null;
                key = (SelectionKey) it.next(); //使用迭代器将事件存入句柄对象
                it.remove();                    //将取出的对象从集合中移除
                final Handler handler = (Handler) key.attachment(); //将与key关联的附件传给handler
//                    handler.handle(key); //在Handler中处理事件
            }
        }
    }
}
