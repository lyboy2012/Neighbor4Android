package com.cailine.neighbor.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 对callback封装一层以完成返回结果同意拦截例如 身份认证是否有效
 * Created by liying on 2016/2/19.
 */
public abstract class ServiceCallback<T> implements Callback {

    @Override
    public void onResponse(Call call, Response response) {
        onSuccess(call, response);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        onFail(call, t);
    }

    public abstract void onSuccess(Call<T> call, Response<T> response);
    public abstract void onFail(Call<T> call, Throwable t);
}
