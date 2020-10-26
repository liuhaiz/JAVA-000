第3课作业
===============
1、使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。
----------------------
* 串行 GC

 ```java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:serial.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
  
   [串行GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/serial.gc.demo.log "串行GC日志")

* 并行GC

  ```java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:paralle.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
  
   [并行GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/paralle.gc.demo.log "并行GC日志")
   
* CMS GC

  ```java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:cms.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
  
   [CMS GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/cms.gc.demo.log "CMS GC日志")
   
* G1 GC

  ```java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:g1.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
  
   [G1 GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/g1.gc.demo.log "G1 GC日志")
   



2、使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例。
----------------------
  
* 串行GC

  ```java -jar -XX:+UseSerialGC -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar```
  ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/%E4%B8%B2%E8%A1%8C01.png)
  ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/%E4%B8%B2%E8%A1%8C02.png)
  
* 并行GC

  ```java -jar -XX:+UseParallelGC -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar```
 ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/并行01.png)
 ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/并行02.png)
 
* CMS GC

  ```java -jar -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar```
 ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/CMS%2001.png)
 ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/CMS%2002.png)
 
* G1 GC

  ```java -jar -XX:+UseG1GC -Xms512m -Xmx512m  gateway-server-0.0.1-SNAPSHOT.jar```
 ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/G1%2001.png)
 ![](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/img/G1%2002.png)
 
 
 
 * 知识小结
 
 程序在运行过程中，会产生大量的内存垃圾（一些没有引用指向的内存对象都属于内存垃圾，因为这些对象已经无法访问，程序用不了它们了，对程序而言它们已经死亡），为了确保程序运行时的性能，java虚拟机在程序运行的过程中不断地进行自动的垃圾回收（GC）。关于 JVM 的 GC 算法主要有下面四种：


1、引用计数算法（Reference counting）
每个对象在创建的时候，就给这个对象绑定一个计数器。每当有一个引用指向该对象时，计数器加一；每当有一个指向它的引用被删除时，计数器减一。这样，当没有引用指向该对象时，该对象死亡，计数器为0，这时就应该对这个对象进行垃圾回收操作。


2、标记–清除算法（Mark-Sweep）
为每个对象存储一个标记位，记录对象的状态（活着或是死亡）。
分为两个阶段，一个是标记阶段，这个阶段内，为每个对象更新标记位，检查对象是否死亡；第二个阶段是清除阶段，该阶段对死亡的对象进行清除，执行 GC 操作。


3、标记–整理算法
标记-整理法是标记-清除法的一个改进版。同样，在标记阶段，该算法也将所有对象标记为存活和死亡两种状态；不同的是，在第二个阶段，该算法并没有直接对死亡的对象进行清理，而是将所有存活的对象整理一下，放到另一处空间，然后把剩下的所有对象全部清除。这样就达到了标记-整理的目的。


4、复制算法
该算法将内存平均分成两部分，然后每次只使用其中的一部分，当这部分内存满的时候，将内存中所有存活的对象复制到另一个内存中，然后将之前的内存清空，只使用这部分内存，循环下去。

这个算法与标记-整理算法的区别在于，该算法不是在同一个区域复制，而是将所有存活的对象复制到另一个区域内。


 分析总结
 -------------------------------
 
 
