# MIB结构

## MIB注册层次

除了根节点以外,每个节点有一个标签(label),一个简单的文本描述加一个整数.

## OID查询

## 分层的属性结构有3个作用

- 表示管理和控制关系
  - 上层的中间节点是某些组织机构的名字,说明这些机构负责它下面的子树信息的管理和审批
  - 根没有名字和标号,默认为抽象语法表示ASN.1.根有三个子节点
  - ccitt(0)子树,
  - iso(1)子树
  - joint-iso-ccitt(2)子树
  - SNMO定义的管理对象全部在节点internet下
- 提供了结构化的信息组织技术
  - 下层的中间节点代表的子树是与每个被管资源或网络协议相关的信息集合
  - 提供了对象命名机制,所有对象构成要给命名树.树中的每个节点都有一个分层的编号.叶子节点代表实际的被管对象,有实例值可以直接访问.从树根至对象所在点的路径上所有节点的编号串联起来,用圆点隔开,就形成了该对象的对象标识符(全局标识)

### 关注Internet下面的4个子节点

- directory, 保留,用于OSI目录服务(X.500)
- mgmt, 包括由IAM批准的所有管理对象--标准MIB文档中定义的管理对象
- experimental,处于实验阶段的协议和设备的管理信息放在该子树下.由IAB负责管理
- private, 是为企业私有管理信息准备的,由IANA负责.目前这个子树只有一个子节点enterprises

## SMI定义

### ASN.1与管理信息

什么是被管对象

- 被管对象是网络资源的管理信息的抽象表示
- 一个被管对象对应一种或一类管理信息

管理信息怎么表示

- 管理信息可以使用数值或文字(字符串)表示
- 可以去整数值或字符串
- 数据类型可以被唯一标识
- 具有传输编码

使用ASN.1的类型值来表示管理信息.颇具优势

- ASN.1具有丰富的数据类型
- 每种类型都有唯一的tag标识
- 每种类型还有对应的传输编码
- 还可以使用对象标识符来标识管理信息

### MIB的数据类型

RFC1155-SMI规定了可以在SNMP MIB中使用ASN.1数据类型

- 5种通用类型(INTEGER, OCTET STRING, NULL, OBJECT IDENTIFIER, SEQUENCE(OF))
- 几种应用类型

应用数据类型

- NetworkAddress::= CHOICE{internet IpAddress}
- IpAddress::=[APPLICATION 0] IMPLICIT OCTET STRING(SIZE(4))
- Counter::=[APPLICATION 1] IMPLICIT INTERGER(0...4, 294 967 295)
- Gauge::=[APPLICATION 2] INTEGER(0..4 294 967 295)
- TImeTicks
- Opaque

管理信息结构SMI的定义  
MIB包含各种类型的被管对象,如何定义各种被管对象?可以提出3种方法:

- 为每个对象定义一种对象类型,这种方法会产生很多对象类型,而且定义的方式可能是各种各样的,这使得MIB的实现复杂化
- 定义一种带参数的通用对象类型
- ASN.1中的类型符号形式有限,不足以满足我们定义管理信息的需要,但利用ASN.1宏定义表示一个有关类型的集合,然后用这些类型定义被管对象

## 定义被管对象

一个被管对象的定义至少应包含一下信息

- 对象的标识,包括一个被称为对象描述符(OBJECT DESCRIPTOR)的文本名和一个对象标识符
- 对象类型的语法(SYNTAX)--数据类型
- 访问(ACCESS) --对象的访问权限
- 状态(STATUS) --对象的实现状态

***

- SYNTAX
- ACCESS
  - read-only
  - read-write
  - write-only
  - not-accessible
- STATUS
  - mandatory
  - optional
  - obsolete

使用宏定义在MIB中定义一个被管对象的过程,就是由OBJECT-TYPE宏定义得出一个宏实例的过程

## MIB文件中定义了

- 应用类型部分
- 文本约定
- MIB顶端节点,组节点的OID分配
- 定义管理对象(约占90%篇幅)
