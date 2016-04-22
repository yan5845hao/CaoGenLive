package com.ylsna.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jaeger.library.StatusBarUtil;
import com.ylsna.R;

public class IncomeRecordActivity extends AppCompatActivity {
    /**
     * 返回按钮
     */
    private ImageButton imb_income_record_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_record);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorOrangeDarker), 0);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }

        initView();
        setListeners();
    }

    /**
     * 设置监听
     */
    private void setListeners() {
        //返回按钮
        imb_income_record_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        imb_income_record_back = (ImageButton) findViewById(R.id.imb_income_record_back);
    }
}
