package com.example.modulefast;

import android.widget.Toast;


import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base_module.base.BaseModuleApplication;
import com.example.common_lib.utils.Utils;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import java.util.Locale;

import static com.tencent.bugly.beta.tinker.TinkerManager.getApplication;

public class DJApplication  extends BaseModuleApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        initBuggly();
        initTinkerPatch();
    }


    private void initBuggly() {
        initTinkerPatch( );
        Bugly.init(this, "6e2747d944", true);
    }
    public   void  initTinkerPatch(  ){
        //设置本机为测试开发设备
        Bugly.setIsDevelopmentDevice(this,true);
        // 设置是否开启热更新能力，默认为true
        Beta.enableHotfix = true;
        // 设置是否自动下载补丁
        Beta.canAutoDownloadPatch = true;
        // 设置是否提示用户重启
        Beta.canNotifyUserRestart = true;
        // 设置是否自动合成补丁
        Beta.canAutoPatch = true;
        /**
         * 补丁回调接口，可以监听补丁接收、下载、合成的回调
         */
        Beta.betaPatchListener = new BetaPatchListener() {
            @Override
            public void onPatchReceived(String patchFileUrl) {

            }

            @Override
            public void onDownloadReceived(long savedLength, long totalLength) {
                Toast.makeText(getApplicationContext(), String.format(Locale.getDefault(), "%s %d%%", Beta.strNotificationDownloading, (int) (totalLength == 0 ? 0 : savedLength * 100 / totalLength)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDownloadSuccess(String patchFilePath) {
                Beta.applyDownloadedPatch();
            }

            @Override
            public void onDownloadFailure(String msg) {

            }

            @Override
            public void onApplySuccess(String msg) {
                Toast.makeText(getApplicationContext(), "补丁加载成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onApplyFailure(String msg) {

            }

            @Override
            public void onPatchRollback() {

            }
        };
    }
}
