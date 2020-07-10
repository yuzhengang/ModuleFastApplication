package com.example.module_main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.base_module.bean.User;
import com.example.base_module.configs.BaseConstants;
import com.example.common_lib.base.BaseActionBarActivity;
import com.example.common_lib.base.BaseActivity;
import com.example.common_lib.base.BaseFragment;
import com.example.common_lib.base.ViewManager;
import com.example.common_lib.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private long mExitTime = 0;
    private List<BaseFragment> mFragments;
    private int currentIndex = 0;
    private Button[] mTabs;
    private int index;
    LinearLayout main_bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewPager();
    }


    public void initViews() {
        mTabs = new Button[4];
        mTabs[0] = (Button) findViewById(R.id.main_home_btn);
        mTabs[1] = (Button) findViewById(R.id.main_course_btn);
        mTabs[2] = (Button) findViewById(R.id.main_org_btn);
        mTabs[3] = (Button) findViewById(R.id.main_my_btn);
        main_bottom = (LinearLayout) findViewById(R.id.main_bottom);
        mTabs[currentIndex].setSelected(true);
    }


    private void initViewPager() {
        mFragments = new ArrayList<>();
        Map<Integer, BaseFragment> fragmentMap = ViewManager.getInstance().getAllFragment();//这几个Fragment是主动添加到ViewManager中的
        Log.e("fragmentMap",fragmentMap.size()+"  ");
        mFragments.add(fragmentMap.get(0));
        mFragments.add(fragmentMap.get(1));
        mFragments.add(fragmentMap.get(2));
        mFragments.add(fragmentMap.get(3));
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mFragments.get(0)).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(getString(R.string.app_exit_hint));
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void onTabClicked(View view) {
        if (view.getId() == R.id.main_home_btn) {
            index = 0;
        } else if (view.getId() == R.id.main_course_btn) {

            index = 1;

        } else if (view.getId() == R.id.main_org_btn) {

            index = 2;

        } else if (view.getId() == R.id.main_my_btn) {
            index = 3;
        }
        if (currentIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(mFragments.get(currentIndex));
            if (!mFragments.get(index).isAdded()) {
                trx.add(R.id.fragment_container, mFragments.get(index));
            }
            trx.show(mFragments.get(index)).commit();
        }
        mTabs[currentIndex].setSelected(false);
        mTabs[index].setSelected(true);
        currentIndex = index;
    }
}
