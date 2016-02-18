package com.cailine.neighbor.service;


import com.cailine.neighbor.model.TokenInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by liying on 2016/2/18.
 */
public interface NeighborService {


    @FormUrlEncoded
    @POST("login/")
    Call<TokenInfo> login(@Field("username") String userName, @Field("password") String password);


}
