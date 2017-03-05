package com.weather.core.json;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.weather.core.exception.WeatherException;

@Service
public class JsonHandler {

	private static final String SUCCESS = "SUCCESS"; 
	
	public JSONObject createJsonResponse(int status, String message) {
		JSONObject response = new JSONObject();

		response.put("status", status);
		response.put("message", message);

		return response;
	}
	
	public String createSuccessJsonResponse()
	{
		return createJsonResponse(0, SUCCESS).toString();
	}
	
	public String createJsonResponseFromException(WeatherException ex)
	{
		return createJsonResponse(ex.getCode(),ex.getMessage()).toString();
	}
	
	public String createSuccessJsonResponseWithBody(String bodyName,Object body)
	{
		JSONObject response = createJsonResponse(0, SUCCESS);
		response.put(bodyName, body);
		return response.toString();		
	}
	
}
