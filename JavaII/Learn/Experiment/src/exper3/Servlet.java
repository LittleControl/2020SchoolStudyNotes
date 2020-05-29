package exper3;

import java.io.IOException;

/**
 * @author LittleControl
 * @date 2020/5/26 上午 07:35
 * @website www.littlecontrol.cn
 */
public interface Servlet {
    public void service(Request request, Response response) throws IOException;
}
