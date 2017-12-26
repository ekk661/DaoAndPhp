package com.chape.daoandphp.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/10/3.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {

        super.onCreate();
        context=getApplicationContext();
    }
    private static Context getContext(){
        return context;
    }
}
