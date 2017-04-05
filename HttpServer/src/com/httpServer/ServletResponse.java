package com.httpServer;

public interface ServletResponse {
	
	 // Method descriptor #4 ()Ljava/lang/String;
	  public abstract java.lang.String getCharacterEncoding();
	  
	  // Method descriptor #4 ()Ljava/lang/String;
	  public abstract java.lang.String getContentType();
	  
	  // Method descriptor #7 ()Ljavax/servlet/ServletOutputStream;
	  //public abstract ServletOutputStream getOutputStream() throws java.io.IOException;
	  
	  // Method descriptor #11 ()Ljava/io/PrintWriter;
	  public abstract java.io.PrintWriter getWriter() throws java.io.IOException;
	  
	  // Method descriptor #13 (Ljava/lang/String;)V
	  public abstract void setCharacterEncoding(java.lang.String arg0);
	  
	  // Method descriptor #15 (I)V
	  public abstract void setContentLength(int arg0);
	  
	  // Method descriptor #17 (J)V
	  public abstract void setContentLengthLong(long arg0);
	  
	  // Method descriptor #13 (Ljava/lang/String;)V
	  public abstract void setContentType(java.lang.String arg0);
	  
	  // Method descriptor #15 (I)V
	  public abstract void setBufferSize(int arg0);
	  
	  // Method descriptor #21 ()I
	  public abstract int getBufferSize();
	  
	  // Method descriptor #23 ()V
	  public abstract void flushBuffer() throws java.io.IOException;
	  
	  // Method descriptor #23 ()V
	  public abstract void resetBuffer();
	  
	  // Method descriptor #26 ()Z
	  public abstract boolean isCommitted();
	  
	  // Method descriptor #23 ()V
	  public abstract void reset();
	  
	  // Method descriptor #29 (Ljava/util/Locale;)V
	  public abstract void setLocale(java.util.Locale arg0);
	  
	  // Method descriptor #31 ()Ljava/util/Locale;
	  public abstract java.util.Locale getLocale();

}
