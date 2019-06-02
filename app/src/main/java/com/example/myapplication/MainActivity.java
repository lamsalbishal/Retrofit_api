package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ApiClass.Comment;
import com.example.myapplication.ApiClass.Post;
import com.example.myapplication.ApiClass.Prabhu;
import com.example.myapplication.ApiClass.Safari;
import com.example.myapplication.ApiClass.Service;
import com.example.myapplication.ApiClass.Services;
import com.example.myapplication.Helper.TvInfo;
import com.example.myapplication.Interface.JsonPlaceHolder;
import com.example.myapplication.ListViewData.TvListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Services> data;
    private DataAdapter adapter;
    private ListView listView;


   private  String[] arrayReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listView = (ListView) findViewById(R.id.tvlist);


        Bundle bundle = getIntent().getExtras();
        arrayReceived = bundle.getStringArray("opcode");
//       for(int j = 0; j< arrayReceived.length; j++){
//            Log.i("bundel data ", arrayReceived[j]);
//        }




        //getApi();
       // postApi();
        prabhuApi();
        //safariApi();
    }


    public void getApi(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://peadforg.000webhostapp.com/findway/findway/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<Post>> call = jsonPlaceHolder.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                List<Post> posts = response.body();

                for(Post post : posts){
                    String  content ="";
                    content += "ID:"+post.getFullname();
//                    showApi.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    public  void postApi(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://peadforg.000webhostapp.com/findway/findway/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Comment comment = new Comment("hello i like it","bishal","10");
        Call<Comment> call = jsonPlaceHolder.createPost(comment);

        call.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {

                Comment commentpost = response.body();

                    String  content ="";
                    content += "ID:"+commentpost.getComment();
                  //  showApi.append(content);

            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {

            }
        });

    }

    public void  prabhuApi(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://www.eprabhu.com/ApiMobile/MobileService.svc/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Prabhu prabhu = new Prabhu("KAPIL1","JHK#1234");
        Call<Prabhu> callapi =  jsonPlaceHolder.creatPostApi("fyZbT@r6_Rx$HGfNKyUL",prabhu);
        callapi.enqueue(new Callback<Prabhu>() {
            @Override
            public void onResponse(Call<Prabhu> call, Response<Prabhu> response) {

                Log.i("response data form api",response.body().getServices().toString());
                Prabhu commentpost = response.body();

                ArrayList<TvInfo> list = new ArrayList<>();

                ArrayList<Services> services =  response.body().getServices();
                for(int i = 0; i<services.size(); i++){
//                    Log.i("sercies data",services.get(i).getCategory());
                    if((services.get(i).getCategory()).equals("Bill Payment")){
                        ArrayList<Service> services1 = services.get(i).getService();
                        for(int x =0; x<services1.size(); x++){

                           Log.i("Service data", services1.get(x).getOperatorCode());

                           for (int y = 0; y <arrayReceived.length ; y++){

                              if((services1.get(x).getOperatorCode()).equals(arrayReceived[y])){
                                  Log.i("success data only",services1.get(x).getName());

                                  TvInfo info = new TvInfo();
                                  info.Name = services1.get(x).getName();
                                  info.Image = services1.get(x).getLogo();
                                  list.add(info);
                              }
                           }


                        }

                    }

                }

                listView.setAdapter(new TvListView(MainActivity.this,list));

//                for(int j = 0; j< tv.length; j++){
//
//                    if((services1.get(x).getOperatorCode()).equals(tv[x])){
//                        Log.i("name of api data",services1.get(x).getName());
//                    }
//                }








               // showApi.append(data.toString());
            }

            @Override
            public void onFailure(Call<Prabhu> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Soory api data error", Toast.LENGTH_SHORT).show();
                Log.i("Api data error",t.toString());

            }
        });
    }

    private void  safariApi(){


        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://192.168.12.9:9000/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Prabhu prabhu = new Prabhu("KAPIL1","JHK#1234");
        Safari safari = new Safari("HillTrake","this is ony check","https:image/url");
        Call<Safari> callapi =  jsonPlaceHolder.createSafari(safari);
         callapi.enqueue(new Callback<Safari>() {
             @Override
             public void onResponse(Call<Safari> call, Response<Safari> response) {
                 Toast.makeText(MainActivity.this, "Success Full api data"+response.body().get_id(), Toast.LENGTH_SHORT).show();

             }

             @Override
             public void onFailure(Call<Safari> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "Soory data not insert", Toast.LENGTH_SHORT).show();
             }
         });
    }
}
