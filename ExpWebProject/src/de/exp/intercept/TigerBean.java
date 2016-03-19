package de.exp.intercept;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

@Named
@MyInterceptable
public class TigerBean {
	
	@PostConstruct
	public void onPostConstruct(){
		System.out.println("Tiger created");
	}
	
	@PreDestroy
	public void onPreDestroy(){
		System.out.println("Tiger destroyed.");		
	}

	@Interceptors({ MyInterceptor1.class, MyInterceptor2.class} )
	public void meow(StringBuffer stringBuffer){
		stringBuffer.append("Arrrrrrrrrr!");
	}
	
	@AroundInvoke
	public Object internalInterceptor(InvocationContext c) throws Exception{
		Object paramter = c.getParameters()[0];
		StringBuffer stringBuffer = (StringBuffer) paramter;
		stringBuffer.append("Tiger says: ");
		
		// important - call next interceptor or the intercepted method here!
		try{
			return c.proceed();	
		}finally{
			stringBuffer.append("Tadaaa! The end of the tiger.");	
		}
	}
}
