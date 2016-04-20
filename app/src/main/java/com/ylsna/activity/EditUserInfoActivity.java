package com.ylsna.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.ylsna.Configs;
import com.ylsna.R;

public class EditUserInfoActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 修改头像
     */
    private RelativeLayout rl_edit_user_info_head;
    /**
     * 修改名字
     */
    private RelativeLayout rl_edit_user_info_name;
    /**
     * 修改房间号
     */
    private RelativeLayout rl_edit_user_info_room;
    /**
     * 修改个人简介
     */
    private RelativeLayout rl_edit_user_info_introduce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }

        initView();
        setListeners();
    }

    /**
     * 控件的监听事件
     */
    private void setListeners() {
        rl_edit_user_info_head.setOnClickListener(this);
        rl_edit_user_info_name.setOnClickListener(this);
        rl_edit_user_info_room.setOnClickListener(this);
        rl_edit_user_info_introduce.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        rl_edit_user_info_head = (RelativeLayout) findViewById(R.id.rl_edit_user_info_head);
        rl_edit_user_info_name = (RelativeLayout) findViewById(R.id.rl_edit_user_info_name);
        rl_edit_user_info_room = (RelativeLayout) findViewById(R.id.rl_edit_user_info_room);
        rl_edit_user_info_introduce = (RelativeLayout) findViewById(R.id.rl_edit_user_info_introduce);
    }

    @Override
    public void onClick(View v) {
        String title = null;
        Intent titleIntent = new Intent(EditUserInfoActivity.this, SaveUserInfoActivity.class);
        switch (v.getId()) {
            case R.id.rl_edit_user_info_head:
                break;
            case R.id.rl_edit_user_info_name:
                title = "更改名字";
                titleIntent.putExtra(Configs.EDIT_USER_INFO_TITLE, title);
                startActivity(titleIntent);
                break;
            case R.id.rl_edit_user_info_room:
                title = "更改房间号";
                titleIntent.putExtra(Configs.EDIT_USER_INFO_TITLE, title);
                startActivity(titleIntent);
                break;
            case R.id.rl_edit_user_info_introduce:
                title = "更改个人简介";
                titleIntent.putExtra(Configs.EDIT_USER_INFO_TITLE, title);
                startActivity(titleIntent);
                break;
        }
    }
}