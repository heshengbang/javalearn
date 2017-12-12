package com.hsb.client.httpclient.util;/*
 * Copyright ©2011-2016 hsb
 */

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tongheshang on 2017/10/26.
 * weibo.com/yunshixin
 * https://github.com/tongheshang
 * email: trulyheshengbang@gmail.com
 */
public class HttpClientUtil implements Runnable{

    private String username;
    private String password;
    private String path;

    public HttpClientUtil(String name, String password,String path) {
        // 初始化用户名和密码
        this.username = name;
        this.password = password;
        this.path = path;
    }

    public void run() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);

        String result = sendHttpClientPost(path, params, "utf-8");
        System.out.println(result);
    }

    private String sendHttpClientPost(String path, Map<String, String> params, String encode) {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry: params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        HttpPost httpPost = null;
        CloseableHttpClient client = null;
        InputStream inputStream = null;

        try {

            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(list, encode);
            httpPost = new HttpPost(path);
            httpPost.setEntity(encodedFormEntity);
            client = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = client.execute(httpPost);
            System.err.println("status:"+httpResponse.getStatusLine().getStatusCode());

            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                try {
                    inputStream = httpResponse.getEntity().getContent();
                    return changeInputStream(inputStream, encode);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        httpResponse.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }  catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "走完所有函数。execute done.";
    }

    private String changeInputStream(InputStream inputStream, String encode) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = "";
        if (inputStream != null) {
            try {
                while ((len = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                }
                result = new String(outputStream.toByteArray(), encode);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
