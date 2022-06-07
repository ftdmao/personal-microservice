package com.mjw.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description :
 * @Date : 2022/6/6
 * @Author : jiawei_mao
 **/
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = 3326647150049980856L;

    private Map<String, String> sqlSession;

    private final Class<T> mapperInterface;


    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }
        return "你被代理了" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
    }
}
