package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONArray;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    String url="httpss://localhost:8081/hoadons";
    TextView txtJson;
    Button btnClickme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtJson = (TextView) findViewById(R.id.txtJson);
        btnClickme= findViewById(R.id.btn_click);
        final String myjson="";

        OkHttpClient client = new OkHttpClient();
        Request request=new Request.Builder().url("http://localhost:8081/hoadons").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Loi","Loi");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtJson.setText(json);
                    }
                });
            }
        });

    }





}