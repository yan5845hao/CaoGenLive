package com.ylsna.outerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ylsna.R;
import com.ylsna.activity.IncomeRankListActivity;
import com.ylsna.activity.SupportRankListActivity;
import com.ylsna.adapter.InnerFragmentViewPagerAdapter;
import com.ylsna.innerfragment.FocusFragment;
import com.ylsna.innerfragment.HotFragment;
import com.ylsna.innerfragment.RecentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by halsey on 16-4-18.
 */
public class ListFragment extends Fragment {
    /**
     * 内层ViewPager
     */
    private ViewPager mVpList;
    /**
     * 装fragment，3个
     */
    private List<Fragment> fragments = new ArrayList<>();
    /**
     * 关注，热门，最新的fragment
     */
    private FocusFragment mFocusFragment;
    private HotFragment mHotFragment;
    private RecentFragment mNewFragment;
    /**
     * 顶栏的RadioButton
     */
    private RadioGroup rg_list;
    private RadioButton rb_focus;
    private RadioButton rb_hot;
    private RadioButton rb_new;
    /**
     * 点击赞助榜和收入榜的按钮
     */
    private Button btn_support_rank_list;
    private Button btn_income_rank_list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        initViewPager(view);
        initView(view);
        init_event();

        return view;
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initView(View view) {
        btn_support_rank_list = (Button) view.findViewById(R.id.btn_support_rank_list);
        btn_income_rank_list = (Button) view.findViewById(R.id.btn_income_rank_list);
        //进入赞助榜单
        btn_support_rank_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SupportRankListActivity.class));
            }
        });
        //进入收入榜
        btn_income_rank_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), IncomeRankListActivity.class));
            }
        });
    }

    /**
     * 初始化ViewPager相关
     *
     * @param view
     */
    private void initViewPager(View view) {
        mVpList = (ViewPager) view.findViewById(R.id.vp_list);

        rg_list = (RadioGroup) view.findViewById(R.id.rg_list);
        rb_focus = (RadioButton) view.findViewById(R.id.rb_focus);
        rb_hot = (RadioButton) view.findViewById(R.id.rb_hot);
        rb_new = (RadioButton) view.findViewById(R.id.rb_new);

        mFocusFragment = new FocusFragment();
        mHotFragment = new HotFragment();
        mNewFragment = new RecentFragment();

        if (fragments.size() == 0) {
            fragments.add(mFocusFragment);
            fragments.add(mHotFragment);
            fragments.add(mNewFragment);
        }

        InnerFragmentViewPagerAdapter viewPagerAdapter = new InnerFragmentViewPagerAdapter(getChildFragmentManager(), fragments);
        mVpList.setAdapter(viewPagerAdapter);
        //默认显示热门页面
        rb_hot.setChecked(true);
        mVpList.setCurrentItem(1);
    }

    /**
     * 初始化页面tabs点击事件
     */
    private void init_event() {
        rg_list.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_focus:
                        mVpList.setCurrentItem(0);
                        break;
                    case R.id.rb_hot:
                        mVpList.setCurrentItem(1);
                        break;
                    case R.id.rb_new:
                        mVpList.setCurrentItem(2);
                        break;
                }
            }
        });

        mVpList.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb_focus.setChecked(true);
                        break;
                    case 1:
                        rb_hot.setChecked(true);
                        break;
                    case 2:
                        rb_new.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
