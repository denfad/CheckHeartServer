package ru.denfad.healthcare.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PythonConnector {

    private final String URL = "http://pythonservice:8888/";
    private final OkHttpClient httpClient = new OkHttpClient();

    @Autowired
    public PythonConnector(){}

    public String sendGet(){

        Request request = new Request.Builder()
                .url(URL+"tasks")
                .get()
                .build();

        try(Response response = httpClient.newCall(request).execute()){
            return response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "пиздец";
    }
}
