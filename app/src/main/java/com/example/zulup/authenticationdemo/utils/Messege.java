package com.example.zulup.authenticationdemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zulup on 1/23/2018.
 */

public class Messege {
    public static void messege(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
