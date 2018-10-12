# 概念

### 操作系统内核
操作系统内核是指大多数操作系统的核心部分。它由操作系统中用于管理存储器、文件、外设和系统资源的那些部分组成。操作系统内核通常运行进程，并提供进程间的通信。
### 微内核
微内核（Microkernelkernel）微内核是内核的一种精简形式。微内核结构由一个非常简单的硬件抽象层和一组比较关键的原语或系统调用组成，这些原语仅仅包括了建立一个系统必需的几个部分，如线程管理，地址空间和进程间通信等。通常与内核集成在一起的系统服务层被分离出来，变成可以根据需求加入的组件，这样就可提供更好的可扩展性和更加有效的应用环境。使用微内核设计，对系统进行升级，只要用新模块替换旧模块，不需要改变整个操作系统。其最大的问题是性能由于进程间频繁通信而会受到影响。
### 实模式与保护模式的区别
|模式|访问物理空间大小|进程是否受保护(根本)|CPU启动|
|:--|:------------:|:---------------:|:----:|
|实模式|不超过1m|指针指向具体物理地址|启动为16位实模式|
|保护模式|地址线都有效|逻辑地址需要转化为无力地址|启动后转化为保护模式|
### 中断
1. 程序中断
2. 时钟中断
3. I/O中断
4. 硬件失效中断