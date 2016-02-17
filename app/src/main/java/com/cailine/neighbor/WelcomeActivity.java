package com.cailine.neighbor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

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
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();// 销毁定时器
        }

        Log.d(TAG, "cancel timer");
        super.onDestroy();
    }
}
