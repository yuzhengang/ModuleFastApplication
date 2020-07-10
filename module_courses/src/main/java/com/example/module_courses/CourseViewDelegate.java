package com.example.module_courses;

import android.support.annotation.Keep;
import android.view.View;

import com.example.common_lib.base.BaseFragment;
import com.example.common_lib.base.IViewDelegate;


@Keep
public class CourseViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return CourseFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return  CourseFragment.newInstance().getView();
    }
}
