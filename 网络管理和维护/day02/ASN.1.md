# ASN.1的基本概念

ASN.1中定义数据类型是为了应用程序通信,为了让接收方能明确地知道收到的每个数据的类型,就要对各种数据类型进行系统性的编号.  
解决办法

- 发送方为每个数据附加了一个传输标记,成为标签(tag),即没一个数据类型都被分配一个tag
- 在ASN.1中每种类型的tag是唯一的,是类型的标识符

## 标签

组成: 标签类|P/C|标签号

- 便签类(class, 2位)
- P/C指示位(1位)
- 标签号(tag number 5位)

tag是区分类型的关键所在,**不论类型符号如何定义,如果他们的tag相同,则认为是同一种类型**

### 便签的类别

- 通用类(UNIVERSAL)
- 应用类(APPLICATION)
- 上下文专用类(CONTEXT SPECIFIC)
- 私有类(PRIVATE)

以上标签类实际提供了不同的tag空间.在一个上下文中,如果Class不同,则相同number的两个tag也是不同的  

SNMP定义的APPLICATION数据类型:

- NetworkAddress
- IpAddress
- Counter
- Gauge
- TimeTicks
- Opaque

***

- P/C指示位在标签中用于指明该类型是简单类型还是构造类型(primitive/construct)
- 标签号是一个正整数,用来唯一区分所有**属于同一类别中的不同类型**

## ASN.1数据类型

- 简单类型
- 构造类型
- 标签类型
- 其他类型

2.1表中16,17为构造类型,其他的都是简单类型

2.1表中2,4,5,6,16标签必须记住
|        tag         |  ASN.1 Tag   | Tag Number | Tag Value |
| :----------------: | :----------: | :--------: | :-------: |
| INTERGER/integer32 | UNIVERSAL 2  |    0x02    |   0x02    |
|    OCTET STRING    | UNIVERSAL 4  |    0x04    |   0x04    |
|        NULL        | UNIVERSAL 5  |    0x05    |   0x05    |
| OBJECT IDENTIFIER  | UNIVERSAL 6  |    0x06    |   0x06    |
|      SEQUENCE      | UNIVERSAL 16 |    0x10    |   0x30    |
