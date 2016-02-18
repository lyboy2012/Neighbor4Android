package com.cailine.neighbor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cailine.neighbor.model.TokenInfo;
import com.cailine.neighbor.model.User;
import com.cailine.neighbor.service.NeighborService;
import com.cailine.neighbor.service.ServiceGenerator;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends BaseActivity {

    private Timer timer;
    private TextView welcomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void init() {
        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        getUser();






    }
    private void login(){
        NeighborService service = ServiceGenerator.createService(NeighborService.class);
        Call<TokenInfo> call = service.login("admin", "1");


        call.enqueue(new Callback<TokenInfo>() {
            @Override
            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {
                Log.d(TAG,response.body().getToken());
                welcomeTextView.setText(response.body().getToken());
                TimerTask task = new TimerTask() {

                    @Override
                    public void run() {
                        startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                        finish();
                    }

                };

                timer = new Timer();
                timer.schedule(task, 2000);// 开启定时器，delay 2s后执行task
            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {
                Log.d(TAG,t.toString());
            }


        });

    }
    private void getUser(){
        String baseToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiI1NjlkZWUwYTJjZWMxZTI0MTEwMTVjMDEiLCJleHAiOjE0NTYzOTEwNjIzMTJ9.RZGxXNUlipI5vWeNvSG3oPjyV40PANlnDqVneF5-Muw";
        NeighborService service = ServiceGenerator.createService(NeighborService.class,baseToken);
        Call<User> call = service.getUser("569dee0a2cec1e2411015c01");


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG,response.body().getUsername());
                welcomeTextView.setText(response.body().getUsername());



            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG,t.toString());
            }


        });
    }

    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();// 销毁定时器
        }

        Log.d(TAG, "cancel timer");
        super.onDestroy();
    }
}
