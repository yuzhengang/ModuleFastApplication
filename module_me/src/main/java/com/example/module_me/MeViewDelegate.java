package com.example.module_me;

import android.support.annotation.Keep;
import android.view.View;

import com.example.common_lib.base.BaseFragment;
import com.example.common_lib.base.IViewDelegate;


@Keep
public class MeViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return MeFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return  MeFragment.newInstance().getView();
    }
}
