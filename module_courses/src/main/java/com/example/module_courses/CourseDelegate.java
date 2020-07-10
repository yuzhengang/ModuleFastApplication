package com.example.module_courses;

import android.support.annotation.Keep;

import com.example.common_lib.base.IApplicationDelegate;
import com.example.common_lib.base.ViewManager;


@Keep
public class CourseDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(1, CourseFragment.newInstance());
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
