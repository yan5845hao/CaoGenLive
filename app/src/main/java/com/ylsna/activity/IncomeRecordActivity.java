package com.ylsna.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ylsna.R;

public class IncomeRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_record);
        if (getSupportActionBar() != null) {
            //隐藏ActionBar
            getSupportActionBar().hide();
        }
    }
}
