package com.example.common_lib.base;

import android.support.annotation.Keep;

@Keep
public  interface BaseView<T>{

    void setPresenter(T presenter);
}
