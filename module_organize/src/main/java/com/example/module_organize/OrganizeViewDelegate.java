package com.example.module_organize;

import android.support.annotation.Keep;
import android.view.View;

import android.support.annotation.Keep;

import com.example.common_lib.base.BaseFragment;
import com.example.common_lib.base.IApplicationDelegate;
import com.example.common_lib.base.IViewDelegate;
import com.example.common_lib.base.ViewManager;


@Keep
public class OrganizeViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return OrganizeFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return  OrganizeFragment.newInstance().getView();
    }
}
