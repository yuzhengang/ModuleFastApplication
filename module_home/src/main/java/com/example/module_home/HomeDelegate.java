package com.example.module_home;

import android.support.annotation.Keep;
import android.util.Log;

import com.example.common_lib.base.IApplicationDelegate;
import com.example.common_lib.base.ViewManager;


@Keep
public class HomeDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        Log.e("HomeDelegate","HomeDelegate");
        //主动添加
        ViewManager.getInstance().addFragment(0, HomeFragment.newInstance());
    }
    @Override
    public void onTerminate() {

    }
    @Override
    public void onLowMemory() {

    }
    @Override
    public void onTrimMemory(int level) {

    }
}
