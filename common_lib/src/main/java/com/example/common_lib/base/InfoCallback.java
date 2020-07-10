package com.example.common_lib.base;

import android.support.annotation.Keep;

@Keep
public interface InfoCallback<T> {

    void onSuccess(T info);

    void onError(int code, String message);

}
