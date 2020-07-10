package com.example.common_lib.base;

import android.view.View;

public interface IViewDelegate {


    BaseFragment getFragment(String name);

    View getView(String name);
}
