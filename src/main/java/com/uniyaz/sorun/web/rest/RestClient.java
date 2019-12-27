package com.uniyaz.sorun.web.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by AKARTAL on 27.12.2019.
 */
public class RestClient {

    public static void main(String[] args) throws UnsupportedEncodingException {

        ClientCategoryDto clientCategoryDto = new ClientCategoryDto();
        clientCategoryDto.setName("Mali Hizmetler");

        Gson gson = new GsonBuilder().create();
        String categoryDtoJson = gson.toJson(clientCategoryDto);

        HttpPost post = new HttpPost("http://localhost:8080/rest/category/saveCategory");
        HttpEntity httpEntity = new StringEntity(categoryDtoJson, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            ClientCategoryDto savedCategory = gson.fromJson(dataAsJsonStr, ClientCategoryDto.class);
            System.out.println(savedCategory.getId() + " " + savedCategory.getName());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
