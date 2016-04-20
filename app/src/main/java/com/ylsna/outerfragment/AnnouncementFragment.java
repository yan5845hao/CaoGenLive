package com.ylsna.outerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ylsna.R;
import com.ylsna.adapter.InnerFragmentViewPagerAdapter;
import com.ylsna.innerfragment.LiveConventionFragment;
import com.ylsna.innerfragment.NoticeFragment;
import com.ylsna.innerfragment.RewardFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by halsey on 16-4-18.
 */
public class AnnouncementFragment extends Fragment {
    /**
     * 内层ViewPager
     */
    private ViewPager mVpAnnouncement;
    /**
     * 顶栏的RadioButton
     */
    private RadioGroup rg_announcement;
    private RadioButton rb_anno_angel;
    private RadioButton rb_anno_convention;
    private RadioButton rb_anno_notice;
    /**
     * RadioButton被选中的下方横条的显示和隐藏
     */
    private ImageView im_announcement_rb_checked_1;
    private ImageView im_announcement_rb_checked_2;
    private ImageView im_announcement_rb_checked_3;

    /**
     * 装fragment，3个
     */
    private List<Fragment> fragments = new ArrayList<>();
    /**
     * 天使奖励计划，直播公约，官方通知的fragment
     */
    private RewardFragment mRewardFragment;
    private LiveConventionFragment mLiveConventionFragment;
    private NoticeFragment mNoticeFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        initViewPager(view);
        init_event();

        return view;
    }

    /**
     * 初始化ViewPager相关
     *
     * @param view
     */
    private void initViewPager(View view) {
        mVpAnnouncement = (ViewPager) view.findViewById(R.id.vp_announcement);

        rg_announcement = (RadioGroup) view.findViewById(R.id.rg_announcement);
        rb_anno_angel = (RadioButton) view.findViewById(R.id.rb_anno_angel);
        rb_anno_convention = (RadioButton) view.findViewById(R.id.rb_anno_convention);
        rb_anno_notice = (RadioButton) view.findViewById(R.id.rb_anno_notice);

        im_announcement_rb_checked_1 = (ImageView) view.findViewById(R.id.im_announcement_rb_checked_1);
        im_announcement_rb_checked_2 = (ImageView) view.findViewById(R.id.im_announcement_rb_checked_2);
        im_announcement_rb_checked_3 = (ImageView) view.findViewById(R.id.im_announcement_rb_checked_3);

        mRewardFragment = new RewardFragment();
        mLiveConventionFragment = new LiveConventionFragment();
        mNoticeFragment = new NoticeFragment();

        if (fragments.size() == 0) {
            fragments.add(mRewardFragment);
            fragments.add(mLiveConventionFragment);
            fragments.add(mNoticeFragment);
        }

        InnerFragmentViewPagerAdapter viewPagerAdapter = new InnerFragmentViewPagerAdapter(getChildFragmentManager(), fragments);
        mVpAnnouncement.setAdapter(viewPagerAdapter);
        //默认显示天使奖励计划页面
        rb_anno_angel.setChecked(true);
        mVpAnnouncement.setCurrentItem(0);
    }


    /**
     * 初始化页面tabs点击事件
     */
    private void init_event() {
        rg_announcement.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_anno_angel:
                        mVpAnnouncement.setCurrentItem(0);
                        break;
                    case R.id.rb_anno_convention:
                        mVpAnnouncement.setCurrentItem(1);
                        break;
                    case R.id.rb_anno_notice:
                        mVpAnnouncement.setCurrentItem(2);
                        break;
                }
            }
        });

        mVpAnnouncement.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb_anno_angel.setChecked(true);
                        rbCheckedLineMode();
                        break;
                    case 1:
                        rb_anno_convention.setChecked(true);
                        rbCheckedLineMode();

                        break;
                    case 2:
                        rb_anno_notice.setChecked(true);
                        rbCheckedLineMode();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 判断什么时候该隐藏RadioButton下方的横条
     */
    public void rbCheckedLineMode() {
        if (rb_anno_angel.isChecked()) {
            im_announcement_rb_checked_1.setVisibility(View.VISIBLE);
            im_announcement_rb_checked_2.setVisibility(View.GONE);
            im_announcement_rb_checked_3.setVisibility(View.GONE);
        } else if (rb_anno_convention.isChecked()) {
            im_announcement_rb_checked_1.setVisibility(View.GONE);
            im_announcement_rb_checked_2.setVisibility(View.VISIBLE);
            im_announcement_rb_checked_3.setVisibility(View.GONE);
        } else if (rb_anno_notice.isChecked()) {
            im_announcement_rb_checked_1.setVisibility(View.GONE);
            im_announcement_rb_checked_2.setVisibility(View.GONE);
            im_announcement_rb_checked_3.setVisibility(View.VISIBLE);
        }

    }
}
