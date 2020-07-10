package com.example.base_module.bean;

import com.example.common_lib.utils.BaseUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

import static com.example.base_module.configs.BaseConstants.CACHEDIR;

public class User  implements Serializable, Cloneable{

    private static final long serialVersionUID = 1L;

    private static User instance;

    public final static String TAG = "User";

    public static User getInstance() {
        if (instance == null) {
            Object object = BaseUtils.restoreObject(CACHEDIR + TAG);
            if (object == null) {//APP第一次启动,文件不存在,则新建之
                object = new User();
                BaseUtils.saveObject(CACHEDIR + TAG, object);
            }
            instance = (User) object;
        }
        return instance;
    }


    public void save() {
        BaseUtils.saveObject(CACHEDIR + TAG, this);
    }

    // -----------以下3个方法用于序列化-----------------
    public User readResolve() throws ObjectStreamException, CloneNotSupportedException {
        instance = (User) this.clone();
        return instance;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
    }

    public Object Clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
