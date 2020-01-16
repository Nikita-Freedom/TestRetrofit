package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvMain);
        getJSONResponse();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CameraMy.class);
                intent.putExtra("Position",position);
                startActivity(intent);
            }
        });
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void getJSONResponse(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ARIInterface.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ARIInterface api = retrofit.create(ARIInterface.class);

        Call call = api.myMetod(new Request(0, new ModelDev())) ;
        call.enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {
                Toast.makeText(getApplicationContext(),"УСПЕХ",Toast.LENGTH_LONG).show();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Toast.makeText(getApplicationContext(),"УСПЕХ",Toast.LENGTH_LONG).show();
                        String jsonresponse = response.body().toString();
                        writeListView(jsonresponse);

                    } else {
                        Toast.makeText(getApplicationContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Request> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"НИЧЕГО",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void writeListView(String response){

        try {

            JSONObject paramObject = new JSONObject();
            if(paramObject.optString("status").equals("true")){
                ArrayList<ModelDev> modelListViewArrayList = new ArrayList<>();
                JSONArray dataArray  = paramObject.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    ModelDev modelDev = new ModelDev();
                    JSONObject dataobj = dataArray.getJSONObject(i);
                    String[] contacts = new String[paramObject.length()];
                    modelListViewArrayList.add(modelDev);

                }

                 mAdapter = new Adapter(this, modelListViewArrayList);
                 listView.setAdapter(mAdapter);

            }else {
                Toast.makeText(MainActivity.this, paramObject.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




}
