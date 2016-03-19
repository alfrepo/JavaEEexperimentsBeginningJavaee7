package de.exp.intercept;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Using "Interceptor Binding technique" 
 *
 */
@InterceptorBinding
@Target({java.lang.annotation.ElementType.TYPE}) 
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME) 
public @interface  MyInterceptable {

}
