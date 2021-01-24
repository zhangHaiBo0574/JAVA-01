#                        GC分析

## 串行GC

```tex
Heap
 def new generation   total 157248K, used 13117K [0x00000000e0000000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  eden space 139776K,   9% used [0x00000000e0000000, 0x00000000e0ccf700, 0x00000000e8880000)
  from space 17472K,   0% used [0x00000000e9990000, 0x00000000e9990000, 0x00000000eaaa0000)
  to   space 17472K,   0% used [0x00000000e8880000, 0x00000000e8880000, 0x00000000e9990000)
 tenured generation   total 349568K, used 349246K [0x00000000eaaa0000, 0x0000000100000000, 0x0000000100000000)
   the space 349568K,  99% used [0x00000000eaaa0000, 0x00000000fffaf910, 0x00000000fffafa00, 0x0000000100000000)
 Metaspace       used 2651K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K

  
```

- new generation，年轻代总计 157248K，使用量 13117K，后面的方括号中是内存地址信息
- tenured generation,老年代总计349568K，使用量349246K
  - 其中the space 349568K,使用99%

-  Metaspace， 元数据区总计使用了 32651K， 容量是 4486K， JVM保证可用的大小是 4864K， 保留空 

  间1GB左右 

  - 其中 class space 使用了 297K， capacity 386K，JVM保证可用的大小是 512K， 保留空 

    间1GB左右 