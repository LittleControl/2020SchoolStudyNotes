# TCP可靠传输

- 传输层: 使用TCP实现可靠传输
- 提供尽最大努力交付, 不可靠传输
- 可靠: 保证接收方进程从缓存区读出的字节流与发送方发出的字节流是完全一样的
- TCP实现可靠传输的机制
  - 校验, 与UDP校验一样,增加伪首部
  - 序号, 一个字节占一个序号,序号字段指的是一个报文段第一个字节的序号
  - 确认, TCP默认使用累计确认
  - 重传, 确认重传不分家, 超时重传, TCP使用自适应算法,动态改变重传时间RTTs(加权平均往返时间)

## 冗余ACK(冗余确认)

- 每当比期望序号大的失序报文段到达时,发送一个冗余ACK, 指明下一个期待字节的序号
- 发送方收到多个对于同一报文段的冗余ACK, 就可以认为该报文段丢失,重传该报文段 -> 快速重传
