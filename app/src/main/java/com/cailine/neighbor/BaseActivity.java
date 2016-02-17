package com.cailine.neighbor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public abstract class BaseActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityManager.addActivity(this);
        setContentView(getLayout());
        init();
    }
    /**
     * getLayout:(获得布局文件). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     *
     * @return
     * @author liying
     * @since JDK 1.6
     */
    public abstract int getLayout();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
    /**
     * init:(初始化方法). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author liying
     * @since JDK 1.6
     */
    public abstract void init();
}
