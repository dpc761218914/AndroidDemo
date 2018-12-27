package com.dpc.administrator.androiddemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dpc.administrator.androiddemo.adapter.CustomerAdapter;
import com.dpc.administrator.androiddemo.bean.Customer;

import java.util.ArrayList;


public class InputActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        initView();
        initDatas();
        initEvent();
    }

    public void initView(){



    }

    public void initDatas(){

    }

    public void initEvent(){


    }
}
