package com.dpc.administrator.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button recycleview_btn;
    private Button input_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    public void initView(){
        recycleview_btn =(Button)findViewById(R.id.recycleview_btn);
        input_btn =(Button)findViewById(R.id.input_btn);
    }

    public void initEvent(){
        recycleview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,RecycleViewActivity.class);
                startActivity(intent);
            }
        });
        input_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,InputActivity.class);
                startActivity(intent);
            }
        });
    }
}
