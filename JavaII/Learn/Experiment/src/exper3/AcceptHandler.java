package exper3;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author LittleControl
 * @date 2020/5/25 下午 09:22
 * @website www.littlecontrol.cn
 */
public class AcceptHandler implements Handler{
    @Override
    public void handle(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        if(socketChannel == null) return;
        System.out.println("接收到客户连接,来自: " + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
        ChannelIO cio = new ChannelIO(socketChannel, false);
//        RequestHandler rh = new RequestHandler(cio);
        RequestHandler rh = new RequestHandler();
        socketChannel.register(key.selector(), SelectionKey.OP_READ, rh);
    }
}
