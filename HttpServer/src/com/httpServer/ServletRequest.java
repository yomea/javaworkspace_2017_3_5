package com.httpServer;

public interface ServletRequest {

	
	// Method descriptor #4 (Ljava/lang/String;)Ljava/lang/Object;
	  public abstract java.lang.Object getAttribute(java.lang.String arg0);
	  
	  // Method descriptor #6 ()Ljava/util/Enumeration;
	  // Signature: ()Ljava/util/Enumeration<Ljava/lang/String;>;
	  public abstract java.util.Enumeration getAttributeNames();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getCharacterEncoding();
	  
	  // Method descriptor #12 (Ljava/lang/String;)V
	  public abstract void setCharacterEncoding(java.lang.String arg0) throws java.io.UnsupportedEncodingException;
	  
	  // Method descriptor #16 ()I
	  public abstract int getContentLength();
	  
	  // Method descriptor #18 ()J
	  public abstract long getContentLengthLong();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getContentType();
	  
	  // Method descriptor #21 ()Ljavax/servlet/ServletInputStream;
	 // public abstract ServletInputStream getInputStream() throws java.io.IOException;
	  
	  // Method descriptor #24 (Ljava/lang/String;)Ljava/lang/String;
	  public abstract java.lang.String getParameter(java.lang.String arg0);
	  
	  // Method descriptor #6 ()Ljava/util/Enumeration;
	  // Signature: ()Ljava/util/Enumeration<Ljava/lang/String;>;
	  public abstract java.util.Enumeration getParameterNames();
	  
	  // Method descriptor #27 (Ljava/lang/String;)[Ljava/lang/String;
	  public abstract java.lang.String[] getParameterValues(java.lang.String arg0);
	  
	  // Method descriptor #29 ()Ljava/util/Map;
	  // Signature: ()Ljava/util/Map<Ljava/lang/String;[Ljava/lang/String;>;
	  public abstract java.util.Map getParameterMap();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getProtocol();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getScheme();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getServerName();
	  
	  // Method descriptor #16 ()I
	  public abstract int getServerPort();
	  
	  // Method descriptor #36 ()Ljava/io/BufferedReader;
	  public abstract java.io.BufferedReader getReader() throws java.io.IOException;
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getRemoteAddr();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getRemoteHost();
	  
	  // Method descriptor #40 (Ljava/lang/String;Ljava/lang/Object;)V
	  public abstract void setAttribute(java.lang.String arg0, java.lang.Object arg1);
	  
	  // Method descriptor #12 (Ljava/lang/String;)V
	  public abstract void removeAttribute(java.lang.String arg0);
	  
	  // Method descriptor #43 ()Ljava/util/Locale;
	  public abstract java.util.Locale getLocale();
	  
	  // Method descriptor #6 ()Ljava/util/Enumeration;
	  // Signature: ()Ljava/util/Enumeration<Ljava/util/Locale;>;
	  public abstract java.util.Enumeration getLocales();
	  
	  // Method descriptor #47 ()Z
	  public abstract boolean isSecure();
	  
	  // Method descriptor #49 (Ljava/lang/String;)Ljavax/servlet/RequestDispatcher;
	 // public abstract RequestDispatcher getRequestDispatcher(java.lang.String arg0);
	  
	  // Method descriptor #24 (Ljava/lang/String;)Ljava/lang/String; (deprecated)
	  public abstract java.lang.String getRealPath(java.lang.String arg0);
	  
	  // Method descriptor #16 ()I
	  public abstract int getRemotePort();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getLocalName();
	  
	  // Method descriptor #10 ()Ljava/lang/String;
	  public abstract java.lang.String getLocalAddr();
	  
	  // Method descriptor #16 ()I
	  public abstract int getLocalPort();
	  
	  // Method descriptor #57 ()Ljavax/servlet/ServletContext;
	 //public abstract ServletContext getServletContext();
	  
	  // Method descriptor #59 ()Ljavax/servlet/AsyncContext;
	  //public abstract AsyncContext startAsync() throws java.lang.IllegalStateException;
	  
	  // Method descriptor #61 (Ljavax/servlet/ServletRequest;Ljavax/servlet/ServletResponse;)Ljavax/servlet/AsyncContext;
	 // public abstract AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) throws java.lang.IllegalStateException;
	  
	  // Method descriptor #47 ()Z
	  //public abstract boolean isAsyncStarted();
	  
	  // Method descriptor #47 ()Z
	  //public abstract boolean isAsyncSupported();
	  
	  // Method descriptor #59 ()Ljavax/servlet/AsyncContext;
	 // public abstract AsyncContext getAsyncContext();
	  
	  // Method descriptor #66 ()Ljavax/servlet/DispatcherType;
	 //public abstract DispatcherType getDispatcherType();

}