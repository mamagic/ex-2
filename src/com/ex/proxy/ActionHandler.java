package com.ex.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;

public class ActionHandler implements InvocationHandler{
	
	private Object target;
	
	public ActionHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
		Object ret = method.invoke(target, arg);
		return ret;
	}

}
