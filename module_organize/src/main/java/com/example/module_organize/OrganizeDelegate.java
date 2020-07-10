package com.example.module_organize;

import android.support.annotation.Keep;

import com.example.common_lib.base.IApplicationDelegate;
import com.example.common_lib.base.ViewManager;


@Keep
public class OrganizeDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(2, OrganizeFragment.newInstance());
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
