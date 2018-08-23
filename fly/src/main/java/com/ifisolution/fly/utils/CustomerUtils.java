package com.ifisolution.fly.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifisolution.fly.domain.Customer;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class CustomerUtils {
    private final String domain = "http://localhost:8080";

    public static Object get(String JsonSource, Object xxx) throws IOException {

        URL website = new URL(JsonSource);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {
            inputStream = website.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

            StringBuilder stringBuilder = new StringBuilder();
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                stringBuilder.append((char) cp);
            }
            ObjectMapper mapper = new ObjectMapper();
            xxx = mapper.readValue(stringBuilder.toString(), xxx.getClass());

        } catch (Exception e) {
            inputStream.close();
            bufferedReader.close();

        }
        return xxx;
    }

    public List<Object> getLst(String JsonSoure, Object xxx) throws IOException {

        URL website = new URL(JsonSoure);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<Object> lst = null;
        try {
            inputStream = website.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

            StringBuilder stringBuilder = new StringBuilder();
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                stringBuilder.append((char) cp);
            }
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, xxx.getClass());
            lst = mapper.readValue(stringBuilder.toString(), type);
        } catch (Exception e) {
            inputStream.close();
            bufferedReader.close();

        }

        return lst;
    }
    public boolean saveCustomer(Customer cus) throws IOException {
        boolean check = true;
        JSONObject json = new JSONObject();
        json.put("customerName", cus.getCustomerName());
        json.put("otherDetails", cus.getOtherDetails());

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            //HttpPost request = new HttpPost(domain+"/api/customer");
            HttpPost request = new HttpPost(domain + "/customer/new");
            StringEntity params = new StringEntity(json.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
            check = true;
        } catch (Exception ex) {
            check = false;
        } finally {
            httpClient.close();
        }
        return check;
    }

    public boolean delete(String id) throws IOException {
        boolean check = true;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            //HttpPost request = new HttpPost(domain+"/api/customer");
            HttpDelete request = new HttpDelete(domain + "/customer/delete/" + id);
            request.addHeader("content-type", "application/json");
            httpClient.execute(request);
        } catch (Exception ex) {
            check = false;
        }
        return check;
    }

    public boolean showCustomer() {
        boolean check = true;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            //HttpPost request = new HttpPost(domain+"/api/customer");
            HttpGet request = new HttpGet(domain + "/customer/get");
            request.addHeader("content-type", "application/json");
            httpClient.execute(request);
        } catch (Exception ex) {
            check = false;
        }
        return check;
    }

    public Customer getUserByName(String name) throws IOException {
        String Jsonpath = domain + "/api/user/" + name;
        Customer us = new Customer();
        us = (Customer) new CustomerUtils().get(Jsonpath, us);
        return us;
    }
}
