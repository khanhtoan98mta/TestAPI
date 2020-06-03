package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends AppCompatActivity {
    String url="httpss://localhost:8081/hoadons";
    TextView txtJson;
    Button btnClickme;
    ArrayList<mathang> listmh;
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtJson = (TextView) findViewById(R.id.txtJson);
        btnClickme= findViewById(R.id.btn_click);



//                getData("http://35.198.237.116/coffeshop/api/mathangs");
        new getURL().execute("http://35.198.237.116/coffeshop/api/mathangs");

    }
class getURL extends AsyncTask<String,Void,String>
{
    OkHttpClient client=new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15,TimeUnit.SECONDS)
                            .readTimeout(15,TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .build();
    @Override
    protected String doInBackground(String... strings) {
        Request.Builder builder = new Request.Builder();
        builder.url(strings[0]);
        Request request=builder.build();
        try {
            Response response= client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if(!s.equals(""))
        {

    }

        super.onPostExecute(s);
    }
}





}