package com.ylsna.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ylsna.R;
import com.ylsna.adapter.InnerFragmentViewPagerAdapter;
import com.ylsna.fansfocusfragment.FansMyFragment;
import com.ylsna.fansfocusfragment.FocusMyFragment;
import com.ylsna.utils.Configs;

import java.util.ArrayList;
import java.util.List;

public class FocusFansActivity extends AppCompatActivity {
    /**
     * 内层ViewPager
     */
    private ViewPager vp_focus_fans;
    /**
     * 装fragment，2个
     */
    private List<Fragment> fragments = new ArrayList<>();
    /**
     * 关注，粉丝的fragment;
     */
    private FocusMyFragment mFocusMyFragment;
    private FansMyFragment mFansMyFragment;
    /**
     * 顶栏的RadioButton
     */
    private RadioGroup rg_focus_and_fans;
    private RadioButton rb_focus_fans_focus;
    private RadioButton rb_focus_fans_fans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_fans_activty);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }

        initViewPager();
        init_event();
    }

    /**
     * 初始化控件
     */
    private void initViewPager() {
        vp_focus_fans = (ViewPager) findViewById(R.id.vp_focus_fans);

        rg_focus_and_fans = (RadioGroup) findViewById(R.id.rg_focus_and_fans);
        rb_focus_fans_fans = (RadioButton) findViewById(R.id.rb_focus_fans_fans);
        rb_focus_fans_focus = (RadioButton) findViewById(R.id.rb_focus_fans_focus);

        mFansMyFragment = new FansMyFragment();
        mFocusMyFragment = new FocusMyFragment();

        if (fragments.size() == 0) {
            fragments.add(mFansMyFragment);
            fragments.add(mFocusMyFragment);
        }

        InnerFragmentViewPagerAdapter viewPagerAdapter = new InnerFragmentViewPagerAdapter(getSupportFragmentManager(), fragments);
        vp_focus_fans.setAdapter(viewPagerAdapter);

        //默认显示热门页面
        int item = getIntent().getIntExtra(Configs.SET_ITEM_TO_WITCH, 0);
        switch (item) {
            case 0:
                rb_focus_fans_focus.setChecked(true);
                vp_focus_fans.setCurrentItem(0);
                break;
            case 1:
                rb_focus_fans_fans.setChecked(true);
                vp_focus_fans.setCurrentItem(1);
                break;
        }
    }

    /**
     * 初始化页面tabs点击事件
     */
    private void init_event() {
        rg_focus_and_fans.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_focus_fans_focus:
                        vp_focus_fans.setCurrentItem(0);
                        break;
                    case R.id.rb_focus_fans_fans:
                        vp_focus_fans.setCurrentItem(1);
                        break;
                }
            }
        });

        vp_focus_fans.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb_focus_fans_focus.setChecked(true);
                        break;
                    case 1:
                        rb_focus_fans_fans.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
