# 线程的创建

1. 继承Thread类
2. 实现 runnable接口 ，

# 共同点

* 都需要实现run 方法。

# 不同点

* 唯一不同的是 还要引用Tread类的构造函数才能真正成为一个thread类
 
> 如：Thread a = new Thread(new Mythread()); myThread 是实现runnable接口的类。