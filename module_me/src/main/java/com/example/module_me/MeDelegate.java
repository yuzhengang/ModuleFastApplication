package com.example.module_me;

import android.support.annotation.Keep;

import com.example.common_lib.base.IApplicationDelegate;
import com.example.common_lib.base.ViewManager;


@Keep
public class MeDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(3, MeFragment.newInstance());
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
