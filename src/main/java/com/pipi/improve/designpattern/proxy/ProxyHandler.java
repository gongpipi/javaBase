package com.pipi.improve.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pipi on 2017/8/27.
 */
public class ProxyHandler implements InvocationHandler {

    private Object tar;

    public Object bind(Object tar){
        this.tar = tar;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        // 调用方法前执行的操作
        System.out.println(1);

        result = method.invoke(tar,args);

        //在调用具体函数方法后，执行功能处理
        System.out.println(2);

        return result;
    }


}
