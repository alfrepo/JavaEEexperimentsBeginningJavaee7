package de.exp.cdibean.producer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import de.exp.cdibean.stateless.qualifier.TempFile;

/**
 * This is a Producer class.
 * It only defines some injectable numbers.
 * The numbers are injected by type and name.
 * 
 * @NumberCalculation2016Prefix, @NumberCalculation2016Middle, @NumberCalculation2016Random
 * are Qualifiers - names to distinguish which String needs to be injected.
 * 
 */
@SessionScoped
public class TempFileStreamProducer implements Serializable {
	
	private static final long serialVersionUID = -7807447424135647046L;
	
	private final int serviceIdentifier = Math.abs(new Random().nextInt()); 
	
	/**
	 * Producer method - creates a FileOutputStream
	 * 
	 * @param injectionPoint - contains infos about the environment: InjectionPoint, Bean containing the InjectionPoint etc.  
	 * 
	 * @TempFile will be used at InjectionPoints, so say, that this concrete FileOutputStream is needed
	 * 
	 * @return
	 */
	@Produces 
	@TempFile
	private FileOutputStream getFileInputStream(InjectionPoint injectionPoint){
		String beantype = injectionPoint.getBean().getBeanClass().getSimpleName();
		String name = UUID.randomUUID().toString();
		
		File file = new File(String.format("d:\\Temp\\%s-service%s-%s",beantype, serialVersionUID, name));
		FileOutputStream f = null;
		try {
			f = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	/**
	 * Destructor method - closes FileOutputStream, opened by Producer method.
	 * Destructor is triggered, when the associated Context is destoyed by the Application.
	 * E.g. if the injectionPoint is within a RESTful service - the Destruction will happen directly after the service returned it's value. 
	 * 
	 * The Qualifier MUST be the same for disposal method to work.
	 */
	private void disposeFileInputStream(@Disposes @TempFile FileOutputStream f) throws IOException{
		f.close();
	}
}
