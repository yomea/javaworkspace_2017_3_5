package com.log;

/**
 * This is a custom {@link org.apache.log4j.Level} for security logging. Nods to Jaikiran Pai for
 * his example code {@linkplain http://jaikiran.wordpress.com/2006/07/12/create-your-own-logging-level-in-log4j/} of which
 * this is a total bite. Also, thanks to Roman Hustad for helped me realize I should stop bitching about Log4j
 * not having one of these and make it myself.
 * 
 * If you're getting a "No appenders could be found" error, make sure your log4j.xml or log4j.properties file
 * is on the classpath, because it isn't.
 * 
 * 
 * 自定义日志输出级别
 * 
 * @author Arshan Dabirsiaghi
 * 
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class SecurityLevel extends Level {
	   
	private static final long serialVersionUID = 616340239445975245L;

		/**
	     * Value of security level. This value is slightly higher than {@link org.apache.log4j.Priority#INFO_INT}.
	     */
	    public static final int SECURITY_LEVEL_INT = Level.INFO_INT + 1;
	   
	    /**
	     * {@link Level} representing my log level
	     */
	    public static final Level SECURITY = new SecurityLevel(SECURITY_LEVEL_INT,"SECURITY",7);

	    private static final String SECURITY_MSG = "SECURITY";
	    
	    /**
	     * Default constructor.
	     */
	    protected SecurityLevel(int arg0, String arg1, int arg2) {
	        super(arg0, arg1, arg2);

	    }
	   
	    /**
	     * Checks whether <code>sArg</code> is "SECURITY" level. If yes then returns {@link SecurityLevel#SECURITY},
	     * else calls {@link SecurityLevel#toLevel(String, Level)} passing it {@link Level#DEBUG} as the defaultLevel
	     *
	     * @see Level#toLevel(java.lang.String)
	     * @see Level#toLevel(java.lang.String, org.apache.log4j.Level)
	     *
	     */
	    public static Level toLevel(String sArg) {
	        if (sArg != null && sArg.toUpperCase().equals(SECURITY_MSG)) {
	            return SECURITY;
	        }
	        return (Level) toLevel(sArg, Level.DEBUG);//交由父类中定义的static方法处理
	    }

	    /**
	     * Checks whether <code>val</code> is {@link SecurityLevel#SECURITY_LEVEL_INT}. If yes then returns {@link SecurityLevel#SECURITY},
	     * else calls {@link SecurityLevel#toLevel(int, Level)} passing it {@link Level#DEBUG} as the defaultLevel
	     *
	     * @see Level#toLevel(int)
	     * @see Level#toLevel(int, org.apache.log4j.Level)
	     *
	     */
	    public static Level toLevel(int val) {
	        if (val == SECURITY_LEVEL_INT) {
	            return SECURITY;
	        }
	        return (Level) toLevel(val, Level.DEBUG);
	    }

	    /**
	     * Checks whether <code>val</code> is {@link SecurityLevel#SECURITY_LEVEL_INT}. If yes then returns {@link SecurityLevel#SECURITY},
	     * else calls {@link Level#toLevel(int, org.apache.log4j.Level)}
	     *
	     * @see Level#toLevel(int, org.apache.log4j.Level)
	     */
	    public static Level toLevel(int val, Level defaultLevel) {
	        if (val == SECURITY_LEVEL_INT) {
	            return SECURITY;
	        }
	        return Level.toLevel(val,defaultLevel);
	    }

	    /**
	     * Checks whether <code>sArg</code> is "SECURITY" level. If yes then returns {@link SecurityLevel#SECURITY},
	     * else calls {@link Level#toLevel(java.lang.String, org.apache.log4j.Level)}
	     *
	     * @see Level#toLevel(java.lang.String, org.apache.log4j.Level)
	     */
	    public static Level toLevel(String sArg, Level defaultLevel) {                 
	    if(sArg != null && sArg.toUpperCase().equals(SECURITY_MSG)) {
	        return SECURITY;
	    }
	    return Level.toLevel(sArg,defaultLevel);
	 }
	    
	 public static void main(String[] args) {
		 
		 //Logger logger = Logger.getLogger(SecurityLevel.class.getName());
		 
		 Logger logger = Logger.getLogger(SecurityLevel.class);
		 
		 logger.log(SecurityLevel.SECURITY,"This is a SECURITY level message");
	     System.out.println("Wrote the log with my security level");
	     
	     logger.log(Level.DEBUG ,"I am a debug message");
	     System.out.println("Wrote the log with debug level");
	 
	 }
}