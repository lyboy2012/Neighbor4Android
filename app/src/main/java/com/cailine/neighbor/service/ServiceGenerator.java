package com.cailine.neighbor.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liying on 2016/2/18.
 */
public class ServiceGenerator {
    public static final String API_BASE_URL = "http://192.168.100.192:3003/api/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(120, TimeUnit.SECONDS);
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());

    /**
    * 如果不需要token验证通过此方法创建service
    *
    * @author liying
    * @Data 2016/2/18 16:47
    */

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    /**
     * 如果需要token 验证通过此方法创建service
     * @param serviceClass
     * @param baseToken
     * @param <S>
     * @return
     */
    public static <S> S createService(Class<S> serviceClass, final String baseToken) {
        if (baseToken != null) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder().header("x-access-token", baseToken).
                    header("Accept", "application/json").
                    method(original.method(), original.body());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

}


