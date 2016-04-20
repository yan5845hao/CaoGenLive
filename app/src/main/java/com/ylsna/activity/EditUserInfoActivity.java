package com.ylsna.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.ylsna.R;

public class EditUserInfoActivity extends AppCompatActivity {
    /**
     * 修改头像
     */
    private RelativeLayout rl_edit_user_info_head;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }
    }
}