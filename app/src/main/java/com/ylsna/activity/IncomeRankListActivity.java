package com.ylsna.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.ylsna.R;

public class IncomeRankListActivity extends AppCompatActivity {
    /**
     * 返回按钮
     */
    private ImageButton imb_income_rank_list_toolbar_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_rank_list);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }

        initView();
        setListener();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        imb_income_rank_list_toolbar_back = (ImageButton) findViewById(R.id.imb_income_rank_list_toolbar_back);
    }

    /**
     * 设置监听器
     */
    private void setListener() {
        imb_income_rank_list_toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
