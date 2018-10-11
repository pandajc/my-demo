package com.ljc.mydemo.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ljc.mydemo.common.datasource.DBContextHolder;

@Component  
@Aspect
public class DataSourceAop{

	protected final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Before("@annotation(com.ljc.mydemo.annotation.WriteDataSource)")
    public void before()throws Throwable {
		logger.debug("切换到写数据库源");
		DBContextHolder.setDbType(DBContextHolder.DB_TYPE_RW);
    }
	
	@After("@annotation(com.ljc.mydemo.annotation.WriteDataSource)")
	public void after(JoinPoint joinPoint)throws Throwable{
		logger.debug("切换到读数据库源");
		DBContextHolder.setDbType(DBContextHolder.DB_TYPE_R);
	}
	
	public Annotation getAnnotationByMethod(Method method , Class<?> annoClass){  
		Annotation all[] = method.getAnnotations();  
	    for (Annotation annotation : all) {  
	    	if (annotation.annotationType() == annoClass) {  
	    		return annotation;  
	        }  
	    }
	    return null;  
	 }
	 
	public Method getMethodByClassAndName(Class<?> c , String methodName){  
		Method[] methods = c.getDeclaredMethods();  
	    for (Method method : methods) {  
	    	if(method.getName().equals(methodName)){  
	    		return method ;  
	        }
	    }  
	    return null;  
	}

	public int getOrder() {
		//如果有多个层是，order越小，越优先执行
		return 0;
	}
}