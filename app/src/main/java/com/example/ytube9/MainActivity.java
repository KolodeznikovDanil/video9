package com.example.ytube9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textview);

        //Retforit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        MyAPICall myAPICall = retrofit.create(MyAPICall.class);
        Call<DataModel> call = myAPICall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                //Checking for the response
                if(response.code() != 200){
                    txt.setText("Check the connection");
                    return;
                }

                //Get the data into textview
                String jsony = "";

                jsony = "ID= " + response.body().getId() +
                        "\n userId= " + response.body().getUserId() +
                        "\n title= " + response.body().getTitle() +
                        "\n Completed= " + response.body().isCompleted();

                txt.append(jsony);



            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });

    }
}