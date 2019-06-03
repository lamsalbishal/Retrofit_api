package com.example.myapplication.Interface;

import com.example.myapplication.ApiClass.Comment;
import com.example.myapplication.ApiClass.Post;
import com.example.myapplication.ApiClass.Prabhu;
import com.example.myapplication.ApiClass.PrabhuTv;
import com.example.myapplication.ApiClass.Safari;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolder {

    @GET("follow.php?id=8")
    Call<List<Post>> getPost();

    @POST("commentadd.php")
    Call<Comment> createPost(@Body Comment comment);



    @POST("GetProductList")
    Call<Prabhu> creatPostApi( @Header("x-token")String token,@Body Prabhu prabhu);

    @POST("{fullUrl}")
    Call<PrabhuTv> createPostTvApi(@Path(value = "fullUrl", encoded = true) String fullUrl,@Header("x-token")String token, @Body PrabhuTv prabhuTv);




    @POST("home")
    Call<Safari> createSafari(@Body Safari safari);
}
