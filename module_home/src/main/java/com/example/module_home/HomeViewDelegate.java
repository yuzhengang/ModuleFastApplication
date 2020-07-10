package com.example.module_home;

import android.support.annotation.Keep;
import android.view.View;

import com.example.common_lib.base.BaseFragment;
import com.example.common_lib.base.IViewDelegate;


@Keep
public class HomeViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return HomeFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return  HomeFragment.newInstance().getView();
    }
}
