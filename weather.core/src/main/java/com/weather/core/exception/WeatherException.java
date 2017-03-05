package com.weather.core.exception;

public class WeatherException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code = -1;
	
	public WeatherException()
	{
		super();
	}
	
	public WeatherException(int _code, String msg)
	{
		super(msg);
		code = _code;
	}
	
	public WeatherException(int _code, String msg, Throwable ex)
	{
		super(msg,ex);
		code = _code;
	}

		
	public int getCode() {
		return code;
	}
	
}
