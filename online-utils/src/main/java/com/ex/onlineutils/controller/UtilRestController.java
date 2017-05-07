package com.ex.onlineutils.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilRestController {
	
	@RequestMapping("/httpredirect")
	public String httpRedirector(@RequestParam(value="uristring", defaultValue="http://www.163.com") String uriString, @RequestParam(value="charset", defaultValue="UTF-8") String charset){
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		URI uri;
		StringBuilder sb = new StringBuilder();
		try {
			uri = new URI(uriString);
			ClientHttpRequest chr = simpleClientHttpRequestFactory.createRequest(uri, HttpMethod.GET);
			ClientHttpResponse res = chr.execute();
			InputStream is = res.getBody();
			InputStreamReader isr = new InputStreamReader(is, charset);
			BufferedReader br = new BufferedReader(isr);
			String str = "";
			while((str = br.readLine())!=null){
				sb.append(str + "\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "Invalid chartset";
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "Invalid URI";
		}
		return sb.toString();
	}
}
