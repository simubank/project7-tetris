package com.levelup.mutualfunds.rest;

import java.security.SecureRandom;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import jersey.repackaged.com.google.common.collect.Lists;

public class HttpClientFactory {
	  	private static CloseableHttpClient client;

	  	/*method will return httpClient object which can be used to make any HTTPS calls. 
	  	Performing HTTPS call is no different from making HTTP call from now on. */
	    public HttpClient getHttpsClient() throws Exception {

	        if (client != null) {
	            return client;
	        }
	        SSLContext sslcontext = SSLContexts.custom().useSSL().build();
	        sslcontext.init(null, new X509TrustManager[]{new HttpsTrustManager()}, new SecureRandom());
	        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext,
	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	        client = HttpClients.custom().setSSLSocketFactory(factory).build();
	        return client;
	    }

/*	    //custom header for Community banking:
	    Header header = new BasicHeader(
	    		  HttpHeaders.CONTENT_TYPE, "application/json");
	    		List<Header> headers = Lists.newArrayList(header);
	    		HttpClient client = HttpClients.custom()
	    		  .setDefaultHeaders(headers).build();
	    		HttpUriRequest request = RequestBuilder.get()
	    		  .setUri(SAMPLE_URL).build();
	    		client.execute(request);*/
	    
	    public static void releaseInstance() {
	        client = null;
	    }
	    
	 
}
