package exper3;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * @author LittleControl
 * @date 2020/5/25 下午 09:21
 * @website www.littlecontrol.cn
 */
public interface Handler {
    public void handle(SelectionKey key) throws IOException;
}
