package com.ylsna.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ylsna.R;
import com.ylsna.outerfragment.AnnouncementFragment;
import com.ylsna.outerfragment.ListFragment;
import com.ylsna.outerfragment.MyFragment;
import com.ylsna.outerfragment.PhotoFragment;

public class MainActivity extends AppCompatActivity {
    /**
     * 底栏RadioGroup
     */
    private RadioGroup rg;
    /**
     * 开始直播按钮
     */
    private Button btn_start_live;

    /**
     * 外层Fragment的Tag
     */
    public static final String AnnouncementFragmentTag = "AnnouncementFragment";
    public static final String ListFragmentTag = "ListFragment";
    public static final String PhotoFragmentTag = "PhotoFragment";
    public static final String MyFragmentTag = "MyFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }

        initView(savedInstanceState);
        setListener();
    }

    /**
     * 按钮的事件监听
     */
    private void setListener() {
        //“开始直播”按钮的监听事件
        btn_start_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //暂时用这个，到时候替换成用户是否认证的属性
                boolean isUserAuthentication = false;
                //判断是否是实名用户
                if (isUserAuthentication) {
                    //如果是，则直接跳转到直播页面

                } else {
                    //如果不是，则提示用户进行认证
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.InfoUserToAuthenticAlertDialog);
                    builder.setTitle("实名认证").setMessage(R.string.info_user_to_authentication).setPositiveButton("去认证", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //点了“去认证”，则跳转到认证界面
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //如果点了“取消”，就什么也不做
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }

    /**
     * 底栏点击切换Fragment
     *
     * @param savedInstanceState 保存fragment状态
     */
    private void initView(Bundle savedInstanceState) {
        rg = (RadioGroup) findViewById(R.id.rg_outer_fragment);
        RadioButton rbList = (RadioButton) findViewById(R.id.rb_list);
        //开始直播按钮
        btn_start_live = (Button) findViewById(R.id.btn_start_live);
        //默认选中第二个（加载热门页面）
        rbList.setChecked(true);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Fragment mAnnouncementFragment = fm.findFragmentByTag(AnnouncementFragmentTag);
                Fragment mListFragment = fm.findFragmentByTag(ListFragmentTag);
                Fragment mPhotoFragment = fm.findFragmentByTag(PhotoFragmentTag);
                Fragment mMyFragment = fm.findFragmentByTag(MyFragmentTag);
                //如果fragment不为null，则先隐藏
                if (mAnnouncementFragment != null) {
                    ft.hide(mAnnouncementFragment);
                }
                if (mListFragment != null) {
                    ft.hide(mListFragment);
                }
                if (mPhotoFragment != null) {
                    ft.hide(mPhotoFragment);
                }
                if (mMyFragment != null) {
                    ft.hide(mMyFragment);
                }
                //判断点击的RadioButton
                switch (checkedId) {
                    case R.id.rb_notice:
                        //如果fragment是null，则new出来，然后添加到事务管理器中
                        if (mAnnouncementFragment == null) {
                            mAnnouncementFragment = new AnnouncementFragment();
                            ft.add(R.id.outer_fragment_container, mAnnouncementFragment, AnnouncementFragmentTag);
                        } else {
                            ft.show(mAnnouncementFragment);
                        }
                        break;
                    case R.id.rb_list:
                        if (mListFragment == null) {
                            mListFragment = new ListFragment();
                            ft.add(R.id.outer_fragment_container, mListFragment, ListFragmentTag);
                        } else {
                            ft.show(mListFragment);
                        }
                        break;
                    case R.id.rb_portrait:
                        if (mPhotoFragment == null) {
                            mPhotoFragment = new PhotoFragment();
                            ft.add(R.id.outer_fragment_container, mPhotoFragment, PhotoFragmentTag);
                        } else {
                            ft.show(mPhotoFragment);
                        }
                        break;
                    case R.id.rb_my:
                        if (mMyFragment == null) {
                            mMyFragment = new MyFragment();
                            ft.add(R.id.outer_fragment_container, mMyFragment, MyFragmentTag);
                        } else {
                            ft.show(mMyFragment);
                        }
                        break;
                }
                ft.commit();
            }
        });
        //保存fragment状态
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment mListFragment = new ListFragment();
            fragmentManager.beginTransaction().replace(R.id.outer_fragment_container, mListFragment, ListFragmentTag).commit();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < rg.getChildCount(); i++) {
            RadioButton mTab = (RadioButton) rg.getChildAt(i);
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (!mTab.isChecked()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }
}
