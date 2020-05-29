package exper3;

import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LittleControl
 * @date 2020/5/25 下午 09:29
 * @website www.littlecontrol.cn
 */
public class Request {
    static class Action {
        private String name;

        private Action(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }

        static Action GET = new Action("GET");
        static Action PUT = new Action("PUT");
        static Action POST = new Action("POST");
        static Action HEAD = new Action("HEAD");

        public static Action parse(String s) throws IllegalAccessException {
            if (s.equals("GET"))
                return GET;
            if (s.equals("PUT"))
                return PUT;
            if (s.equals("POST"))
                return POST;
            if (s.equals("HEAD"))
                return HEAD;
            throw new IllegalAccessException(s);
        }
    }

    private Action action;
    private String version;
    private URI uri;
    private  HashMap<String, String> parameterMap = new HashMap<String, String>();

    public Action action() {
        return action;
    }

    public String version() {
        return version;
    }

    public URI uri() {
        return uri;
    }

    public HashMap parameter() {
        return parameterMap;
    }

    private Request(Action a, String v, URI u, HashMap<String, String> p) {
        action = a;
        version = v;
        uri = u;
        parameterMap = p;
    }

    public String toString() {
        return (action + " " + version + " " + uri);
    }

    private static Charset requestCharset = Charset.forName("GBK");

    public static boolean isComplete(ByteBuffer bb) {
        ByteBuffer temp = bb.asReadOnlyBuffer();
        temp.flip();
        String data = requestCharset.decode(temp).toString();
        if (data.indexOf("\r\n\r\n") != -1) {
            return true;
        }
        return false;
    }

    public static ByteBuffer deleteContent(ByteBuffer bb) {
        ByteBuffer temp = bb.asReadOnlyBuffer();
        String data = requestCharset.decode(temp).toString();
        if (data.indexOf("\r\n\r\n") != -1) {
            data = data.substring(0, data.indexOf("\r\n\r\n") + 4);
            return requestCharset.encode(data);
        }
        return bb;
    }

    private static Pattern requestPattern = Pattern.compile("\\(A[A-Z]+)+([^]+)+HTTP/([0-9\\.]+)$)" + ".*^Host:([^]+$.*\r\n\r\n\\z", Pattern.MULTILINE | Pattern.DOTALL);

    public static Request parse(ByteBuffer bb) throws MalformedInputException {
        bb = deleteContent(bb);
        CharBuffer cb = requestCharset.decode(bb);
        Matcher m = requestPattern.matcher(cb);
        if (!m.matches()) {
            throw new MalformedInputException();
        }
        Action a;
        try {
            a = Action.parse(m.group(1));
        } catch (IllegalAccessException x) {
            throw new MalformedRequestException();
        }
        URI u;
        HashMap<String, String> parameterMap = new HashMap<String, String>();
        try {
            u = new URI("http://" + m.group(4) + m.group(2));
            String parameter = m.group(2);
            if(parameter.contains("?")) {
                String[] piarPara = (parameter.substring(parameter.indexOf("?"), parameter.length())).split("");
                for(String paras:piarPara) {
                    String[] para =paras.split("=");
                    parameterMap.put(para[10], para[1]);
                }
            }
        } catch (URISyntaxException x) {
            throw new MalformedRequestException();
        }
    }
    public String getParameter(String key) {
        return parameterMap.get(key);
    }
}
