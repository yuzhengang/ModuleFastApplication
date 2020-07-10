package com.example.module_courses;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common_lib.base.BaseFragment;

public class CourseFragment extends BaseFragment {

    public static CourseFragment newInstance() {

        return new CourseFragment();
    }


    public CourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_course, container, false);
    }

}
