package com.ylsna.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ylsna.Configs;
import com.ylsna.R;

public class SaveUserInfoActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 这个Act的title名字，比如更改名字/更改房间号/更改个人简介
     */
    private TextView tv_save_user_title;
    /**
     * 取消
     */
    private TextView tv_save_user_cancel;
    /**
     * 保存
     */
    private TextView tv_save_user_save;
    /**
     * 用户输入的字符
     */
    private EditText et_save_user_info;
    /**
     * 获取用户输入的字符串
     */
    private String userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_user_info);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }

        initView();
        setListeners();
    }

    /**
     * 控件监听事件
     */
    private void setListeners() {
        tv_save_user_title.setOnClickListener(this);
        tv_save_user_cancel.setOnClickListener(this);
        tv_save_user_save.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tv_save_user_title = (TextView) findViewById(R.id.tv_save_user_title);
        tv_save_user_cancel = (TextView) findViewById(R.id.tv_save_user_cancel);
        tv_save_user_save = (TextView) findViewById(R.id.tv_save_user_save);
        et_save_user_info = (EditText) findViewById(R.id.et_save_user_info);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_save_user_title:
                Intent titleIntent = getIntent();
                String title = titleIntent.getStringExtra(Configs.EDIT_USER_INFO_TITLE);
                //如果title为空
                if (title != null) {
                    tv_save_user_title.setText(title);
                } else {
                    tv_save_user_title.setText("更改信息");
                }
                break;
            case R.id.tv_save_user_cancel:
                finish();
                break;
            case R.id.tv_save_user_save:
                userInfo = et_save_user_info.getText().toString().trim();
                //判断如果EditText为空，则不能点击
                if (TextUtils.isEmpty(userInfo)) {
                    tv_save_user_save.setEnabled(false);
                } else {
                    tv_save_user_save.setEnabled(true);
                    // TODO: 16-4-20  如果不为空，就发送网络请求修改

                    // 返回给前一个Activity
                    Intent contentIntent = new Intent(this, EditUserInfoActivity.class);
                    contentIntent.putExtra(Configs.CONFIRM_USER_INFO_BACK, userInfo);
                    startActivity(contentIntent);
                }
                break;
        }
    }
}
