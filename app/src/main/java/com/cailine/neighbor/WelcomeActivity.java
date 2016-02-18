package com.cailine.neighbor;

import android.os.Bundle;
import android.util.Log;

import com.cailine.neighbor.model.TokenInfo;
import com.cailine.neighbor.service.NeighborService;
import com.cailine.neighbor.service.ServiceGenerator;

import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends BaseActivity {

    private Timer timer;

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


        NeighborService service = ServiceGenerator.createService(NeighborService.class); // Fetch and print a list of the contributors to this library.
        Call<TokenInfo> call = service.login("admin", "1");


        call.enqueue(new Callback<TokenInfo>() {
            @Override
            public void onResponse(Call<TokenInfo> call, Response<TokenInfo> response) {
                Log.d(TAG,response.body().getToken());
            }

            @Override
            public void onFailure(Call<TokenInfo> call, Throwable t) {
                Log.d(TAG,t.toString());
            }


        });





       /* TimerTask task = new TimerTask() {

            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                finish();
            }

        };

        timer = new Timer();
        timer.schedule(task, 2000);// 开启定时器，delay 2s后执行task*/
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
