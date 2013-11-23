package cloudconfvarna.org.libs;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.widget.Toast;

public class Request  
{
	static InputStream is = null;
	
	public static InputStream setHttpRequest(String url)
	{
		try
    	{
	    	//http get
	    	HttpClient httpclient = new DefaultHttpClient();
	        HttpGet httppost = new HttpGet(url);
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity entity = response.getEntity();
	        is = entity.getContent();
	        
	        return is;
    	}
    	catch(Exception e)
    	{
           Context context = null;
           Toast.makeText(context, "Invalid Request", Toast.LENGTH_LONG).show();
        }
		return is;
	}
	
}