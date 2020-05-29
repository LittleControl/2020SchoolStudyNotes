package exper3;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author LittleControl
 * @date 2020/5/25 下午 09:08
 * @website www.littlecontrol.cn
 */
public class ChannelIO {
    protected SocketChannel socketChannel;
    protected ByteBuffer requestBuffer;
    private static int requestBufferSize = 4096;

    public ChannelIO(SocketChannel socketChannel, boolean blocking) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(blocking);
        requestBuffer = ByteBuffer.allocate(requestBufferSize);
    }
    public SocketChannel getSocketChannel() {
        return socketChannel;
    }
    protected void resizeRequestBuffer(int remaining) {
        if(requestBuffer.remaining() < remaining) {
            ByteBuffer bb = ByteBuffer.allocate(requestBuffer.capacity() * 2);
            requestBuffer.flip();
            bb.put(requestBuffer);
            requestBuffer = bb;
        }
    }
    public ByteBuffer getRequestBuffer() {
        return requestBuffer;
    }
    public long transferTo(FileChannel fc, long pos, long len) throws IOException {
        return fc.transferTo(pos, len, socketChannel);
    }
    public void close() throws IOException {
        socketChannel.close();
    }
}
