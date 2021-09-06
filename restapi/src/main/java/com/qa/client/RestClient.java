package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// 1. GET Method without Headers:
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit GET url

		return closeableHttpResponse;

//		//a. Status code
//		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
//		System.out.println("Status Code----> " + statusCode);
//		
//		//b. JSON string:
//		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//		
//		JSONObject responseJson = new JSONObject(responseString);
//		System.out.println("Response JSON from API----> " + responseJson);
//		
//		//c. All Headers
//		Header[] headersArray = closeableHttpResponse.getAllHeaders();
//		
//		HashMap<String, String> allHeaders = new HashMap<String, String>();
//		
//		for(Header header : headersArray) {
//			allHeaders.put(header.getName(), header.getValue());
//		}
//		
//		System.out.println("Header Array----> " + allHeaders);
	}

	// 2. GET Method with Headers:
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit GET url

		return closeableHttpResponse;
	}
	
	
	// 3. POST Method:
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url); // http post request
		httppost.setEntity(new StringEntity(entityString)); // for payload
		
		// for headers:
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httppost);
		
		return closeableHttpResponse;
	}

}
