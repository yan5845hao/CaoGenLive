package com.ylsna.outerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ylsna.R;
import com.ylsna.activity.EditUserInfoActivity;


/**
 * Created by halsey on 16-4-18.
 */
public class MyFragment extends Fragment implements View.OnClickListener {
    /**
     * 用户信息页头部（包括头像，昵称什么的）
     */
    private RelativeLayout rl_my_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        initView(view);
        setListeners();
        return view;
    }

    /**
     * 添加监听方法
     */
    private void setListeners() {
        rl_my_title.setOnClickListener(this);
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initView(View view) {
        rl_my_title = (RelativeLayout) view.findViewById(R.id.rl_my_title);
    }

    /**
     * 控件的点击事件监听
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_my_title:
                startActivity(new Intent(getActivity(), EditUserInfoActivity.class));
                break;
        }
    }
}
