# anwser

```PDU
30 26    表示SNMP消息是ASN.1的SEQUENCE类型,长度是38
        02 01 00    版本号为SNMPv1(0)
        04 06 75 62 6c 69 63 团体名为public
        a1 19      PDU type为GetNextRequest, PDU长度为25
                02 02 00 99 Request id为153
                02 01 00 error-statue 为0
                02 01 00 error-index 为0
                30 0d   variable-bindlings是ASN.1的SEQUENCE类型,长度是13
                        30 0b variable-name1 | variable-value1 对是ASN.1的SEQUENCE类型,长度是11
                                06 07 2b 06 01 02 01 01 01  OID为1.3.6.1.2.1.1.1
                                05 00   值为null
```

```PDU
30 24
    02 01 00
    04 06 75 62 6c 69 63
    a1 18
        02 02 04 12
        02 01 00
        02 01 00
        30 0C
             06 07 2b 06 01 02 01 01 02 00(1.3.6.1.2.1.1.2.0)
             05 00
```

```PDU
30 27
    02 01 00
    04 06 75 62 6c 69 63
    a0 1B
        02 02 04 12
        02 01 00
        02 01 00
        30 0F
             06 07 2b 06 01 02 01 01 03 00(1.3.6.1.2.1.1.3.0)
             02 01 0A 5F AF(679855)
```
