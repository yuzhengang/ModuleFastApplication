package com.example.module_me;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common_lib.base.BaseFragment;

public class MeFragment extends BaseFragment {

    public static MeFragment newInstance() {

        return new MeFragment();
    }


    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_me, container, false);
    }

}
