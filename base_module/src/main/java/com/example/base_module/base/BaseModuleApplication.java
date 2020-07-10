package com.example.base_module.base;

import android.util.Log;

import com.example.base_module.configs.AppConstant;
import com.example.common_lib.base.BaseApplication;
import com.example.common_lib.utils.SystemInfoUtils;
import com.zhouyou.http.BuildConfig;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.SerializableDiskConverter;
import com.zhouyou.http.model.HttpHeaders;
import com.zhouyou.http.model.HttpParams;

public class BaseModuleApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("application","BaseModuleApplication_init");
        EasyHttp.init(this);
        //这里涉及到安全我把url去掉了，demo都是调试通的
        String Url = "http://www.xxx.com";
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.put("User-Agent", SystemInfoUtils.getUserAgent(this, AppConstant.APPID));
        EasyHttp.getInstance()
                .debug("RxEasyHttp", BuildConfig.DEBUG)
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 1000)
                .setConnectTimeout(60 * 1000)
                .setRetryCount(3)//默认网络不好自动重试3次
                .setRetryDelay(500)//每次延时500ms重试
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setBaseUrl(Url)
                .setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
                .setCacheMaxSize(50 * 1024 * 1024)//设置缓存大小为50M
                .setCacheVersion(1)//缓存版本为1
                .setCertificates()//信任所有证书
                .addCommonHeaders(headers);//设置全局公共头
    }
}
