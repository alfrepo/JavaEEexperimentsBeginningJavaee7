package de.exp.intercept;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

@Named
@Interceptors(MyInterceptor1.class)
public class JanBean {
	
	@PostConstruct
	public void onPostConstruct(){
		System.out.println("Jan created");
	}
	
	// I dont want class Intereptors to change that method
	@ExcludeClassInterceptors
	@PreDestroy
	public void onPreDestroy(){
		System.out.println("Jan destroyed. Class interceptors wont pass.");		
	}
	
	public void meow(StringBuffer stringBuffer){
		stringBuffer.append("Uaaaa!");
	}
	
	/**
	 * Interceptors must return Object c.proceed(), so that the next method in interceptor chain is called
	 */
	@AroundInvoke
	public Object internalInterceptor(InvocationContext c) throws Exception{
		Object paramter = c.getParameters()[0];
		StringBuffer stringBuffer = (StringBuffer) paramter;
		stringBuffer.append("Jan says: ");
		
		// important - call next interceptor or the intercepted method here! 
		try{
			return c.proceed();	
		} finally{
			stringBuffer.append("And then again the same.");	
		}
	}
}
