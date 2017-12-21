package com.example.jingdongapp.net;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class MyApp extends Application {
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sp = getSharedPreferences("users", MODE_PRIVATE);
        edit = sp.edit();
    }
}
