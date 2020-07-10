package com.example.common_lib.base;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;

import com.example.common_lib.R;

public abstract class BaseActionBarActivity extends BaseActivity {

    /*默认的ActionBar*/
    protected ActionBar mActionBar;

    /**
     * 设置默认标题id
     *
     * @return 标题id
     */
    @StringRes
    protected abstract int setTitleId();


    /**
     * 更新标题
     *
     * @param title String标题
     */
    protected void setTitle(String title) {
        if (mActionBar != null) {
            mActionBar.setTitle(title);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //标题栏设置
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setTitle(setTitleId());
        }
    }
}
