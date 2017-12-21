package com.example.jingdongapp.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class RetrofitHelper {
public static OkHttpClient client;
public static StringApi stringApi;

static {
    initClient();
}

    /**
     * 实例化client对象
     */
    private static void initClient() {
        if(client==null){
            synchronized (RetrofitHelper.class){
                if(client==null){
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
                }
            }
        }
    }

    public static StringApi stringApi(){
        if(stringApi==null){
            synchronized (RetrofitHelper.class){
                if(stringApi==null){
                    stringApi = OnCreate(StringApi.class,Api.BASE_URL);
                }
            }
        }
        return stringApi;
    }

    private static <T> T OnCreate(Class<T> tClass, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
