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


public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView recycler_view;

    private ArrayList<Customer> datas;
    private CustomerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        initView();
        initDatas();
        initEvent();
    }

    public void initView(){

        recycler_view=(RecyclerView) findViewById(R.id.recycler_view);

    }

    public void initDatas(){
        datas=new ArrayList<Customer>();
        Customer customer1=new Customer();
        customer1.setUsername("科比");
        customer1.setPhone("111111");
        Customer customer2=new Customer();
        customer2.setUsername("詹姆斯");
        customer2.setPhone("222");
        datas.add(customer1);
        datas.add(customer2);
    }

    public void initEvent(){

        adapter=new CustomerAdapter(datas,RecycleViewActivity.this);
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setAdapter(adapter);
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        //recycleview中按钮点击事件
        adapter.buttonSetOnclick(new CustomerAdapter.ButtonInterface() {
            @Override
            public void onclick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, "打电话给"+datas.get(position).getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        /*长按和短按事件*/
        adapter.setOnItemClickLitener(new CustomerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecycleViewActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}
