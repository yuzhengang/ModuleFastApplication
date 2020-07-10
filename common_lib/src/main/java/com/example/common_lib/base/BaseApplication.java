package com.example.common_lib.base;

import android.app.Application;
import android.util.Log;

import com.example.common_lib.utils.Utils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 */
public class BaseApplication  extends Application {

    public static final String ROOT_PACKAGE = "com.example";

    private static BaseApplication sInstance;

    private List<IApplicationDelegate> mAppDelegateList;

    public static BaseApplication getIns() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("application","BaseApplication_init");
        sInstance = this;
        Logger.init("pattern").logLevel(LogLevel.FULL);
        Utils.init(this);
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, ROOT_PACKAGE);
        Log.e("mAppDelegateList",mAppDelegateList.size()+"  ");
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
