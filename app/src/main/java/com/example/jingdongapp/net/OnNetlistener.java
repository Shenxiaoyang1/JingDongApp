package com.example.jingdongapp.net;

import android.widget.EditText;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public interface OnNetlistener<T> {
    public void onSuccess(T t);
    public void onError(Exception e);
}
