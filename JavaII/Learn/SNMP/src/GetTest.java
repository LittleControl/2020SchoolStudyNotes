/**
 * @author LittleControl
 * @date 2020/6/18 上午 11:21
 * @website www.littlecontrol.cn
 */

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;
import java.util.Vector;

public class GetTest {

    private Snmp snmp = null;

    private Address targetAddress = null;

    public void initComm() throws IOException {

        TransportMapping transport = new DefaultUdpTransportMapping();
        snmp = new Snmp(transport);
        transport.listen();
        // 设置代理方的IP地址和端口号
        targetAddress = GenericAddress.parse("udp:192.168.1.4/161");
    }

    public void sendPDU() throws IOException {
        // 设置管理目标target，如果实现的是SNMPv2c或者SNMPv1，需要实例化一个CommunityTarget对象。
        CommunityTarget target = new CommunityTarget();
        // 设置target团体名
        target.setCommunity(new OctetString("public"));
        // 设置target的IP地址和端口号
        target.setAddress(targetAddress);
        // 通信不成功时的重试次数
        target.setRetries(2);
        // 超时时间
        target.setTimeout(1500);
        //设置SNMP版本号
        target.setVersion(SnmpConstants.version2c);
        // 创建 PDU
        PDU pdu = new PDU();
        //调用add方法绑定要查询的对象/实例OID
        pdu.add(new VariableBinding(new OID(new int[] { 1, 3, 6, 1, 2, 1, 1, 5, 0 })));
        // 设置PDU类型
        pdu.setType(PDU.GET);
        // 向Agent发送PDU，并接收Response
        ResponseEvent respEvnt = snmp.send(pdu, target);
        // 解析Response
        if (respEvnt != null && respEvnt.getResponse() != null) {
            Vector<VariableBinding> recVBs = (Vector<VariableBinding>) respEvnt.getResponse()
                    .getVariableBindings();
            for (int i = 0; i < recVBs.size(); i++) {
                VariableBinding recVB = recVBs.elementAt(i);
                System.out.println(recVB.getOid() + " : " + recVB.getVariable());
            }
        }
    }

    public static void main(String[] args) {
        try {
            GetTest util = new GetTest();
            util.initComm();
            util.sendPDU();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}