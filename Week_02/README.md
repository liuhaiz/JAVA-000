第3课作业
===============
1、使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。
----------------------
串行 GC

  ```java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:serial.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
  
  [串行GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/serial.gc.demo.log "串行GC日志")

并行GC

  ```java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:paralle.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
   [并行GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/paralle.gc.demo.log "并行GC日志")
   
CMS GC

  ```java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:cms.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis```
   [CMS GC日志](https://github.com/liuhaiz/JAVA-000/blob/main/Week_02/log/cms.gc.demo.log "CMS GC日志")
   
G1 GC

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
 
