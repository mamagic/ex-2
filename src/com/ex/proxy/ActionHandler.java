package com.ex.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.springframework.dao.DuplicateKeyException;

import com.ex.domain.Member;


public class ActionHandler implements InvocationHandler{
	
	private Object target;
	
	public ActionHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] arg) {
		Object ret = null;
		try {
			ret = method.invoke(target, arg);
			
			String className = target.getClass().getName();
			String methodName = method.getName();
			
			System.out.println(className + " 클래스이름의 " + methodName + "함수이름이 실행되었다");
			
			if(method.getName().startsWith("save")) {
				Member m = (Member)arg[0];
				System.out.println(m.getId() +" 아이디로 "+ m.getName() + " 이름을 저장하였습니다");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
