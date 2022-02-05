/**
 * 
 */
package exception;

import java.io.Serializable;

/**
 * @author harshadnelwadkar
 *
 */
public class ServiceTestException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceTestException(String message) {
		super(message);
	}

}
