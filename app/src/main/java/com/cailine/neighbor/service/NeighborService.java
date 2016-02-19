package com.cailine.neighbor.service;


import com.cailine.neighbor.model.TokenInfo;
import com.cailine.neighbor.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by liying on 2016/2/18.
 */
public interface NeighborService {


    @FormUrlEncoded
    @POST("login/")
    Call<TokenInfo> login(@Field("username") String userName, @Field("password") String password);

    @GET("{id}/user/")
    Call<User> getUser(@Path("id") String userId);

    @GET("{id}/user/")
    Observable<User> getUserRx(@Path("id") String userId);


}
