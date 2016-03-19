package de.exp.intercept;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyInterceptable
@Priority(300)
public class MyInterceptor4 {

	/**
	 * - LifeCycle intercepors must be void 
	 */
	@PostConstruct
	public void onPostConstruct(InvocationContext c){
		System.out.println(getClass().getSimpleName() + ": I know that the Object will be created");
		try {
			c.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void onPreDestroy(InvocationContext c){
		System.out.println(getClass().getSimpleName() + ": I know that the Object will be destroyed");
		try {
			c.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AroundInvoke
	public Object onAroundInvoke(InvocationContext c) throws Exception{
		Object paramter = c.getParameters()[0];
		StringBuffer stringBuffer = (StringBuffer) paramter;
		stringBuffer.append(getClass().getSimpleName()+" says: ");
		return c.proceed();
	}
}
