package com.qdc.demoeurekaconsumer1.Utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

public class HttpClientWithBasicAuth {
    private String getHeader(String username,String password){
        String auth=username+":"+password;
        byte[] enCodeAuth= Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader="Basic"+new String(enCodeAuth);
        return authHeader;
    }
    public String send(String url, String username, String password, Map<String,String>params){
        HttpPost post=new HttpPost();
        CloseableHttpClient client= HttpClients.createDefault();
        List<NameValuePair> paramlist=new ArrayList<NameValuePair>();
        if(paramlist !=null&&params.size()>0){
            Set<String> keySet=params.keySet();
            for (String key:keySet){
                paramlist.add(new BasicNameValuePair(key,params.get(key)));
            }
        }
        try {
            post.setEntity(new UrlEncodedFormEntity(paramlist,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //在设置的请求中将basic auth信息添加到post请求包头
        post.addHeader("Authorization",getHeader(username,password));
        String responeContext=null;
        CloseableHttpResponse response=null;
        try {
            response=client.execute(post);
            int status_code=response.getStatusLine().getStatusCode();
            System.out.println("status_code"+status_code);
            if (response.getStatusLine().getStatusCode()==200){
                HttpEntity entity=response.getEntity();
                responeContext= EntityUtils.toString(entity,"UTF-8");
                System.out.println("responeContext"+responeContext);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responeContext;


    }
}
