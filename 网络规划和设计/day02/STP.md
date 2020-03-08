# STP

STP: Spanning Tree Protocol(生成树协议)  

- 逻辑上断开环路,防止广播风暴的产生
- 当线路故障,阻塞被激活,恢复通信,起备份线路的作用

## STP算法

- 选择根网桥(Root Bridge)
- 选择根端口(Root Ports)
- 选择指定端口(Designated Ports)

### 网桥ID(BID)

- 网桥ID是唯一的
- 选择交换网络中网桥ID最小的交换机成为根网桥

BID格式: 网桥优先级(2字节)+网桥的MAC地址(6字节)

### 根端口

- 到根网桥最低的根路径成本
- 直连的网桥ID最小
- 端口ID最小

根路径成本: 网桥到根网桥的路径上所有路径的成本之和  
端口ID格式: 端口优先级(8位)+端口编号(8位)

## 指定端口

- 根网桥上的端口全部都是指定端口
- 每个网段上,选择1个指定端口
- 非根网桥上的指定端口,选择顺序
  - 根路径成本低
  - 所在的交换机的网桥ID的值较小
  - 端口ID较小

## STP状态

- BPDU
  - Bridge Protocol Data Unit - 桥协议数据单元
  - 使用组播发送BPDU
- 交换机端口的5中STP状态
  
  - 转发
  - 学习
  - 侦听
  - 阻塞
  - 禁用

- STP的3中计时器
  
  - Hello时间
  - 转发延迟
  - 最大老化时间

## STP配置

### PVST+配置的意义

- 配置网络中比较稳定的交换机为根网桥
- 利用PVST+实现网络的负载分担

## RSTP和MSTP

### RSTP

- 快速生成树
  - Repid Spanning Tree Protocol
  - IEEE 802.1w
- RSTP端口角色
  - 根端口,指定端口和阻塞端口
  - 替代端口,备用端口
- RSTP端口状态
  - 丢弃,学习,转发

### MSTP

多生成树(MSTP)

- MST (Multiple Spanning Tree Protocol)
- IEEE 802.1s
- 将一个或多个VLAN映射到一个STP实例
