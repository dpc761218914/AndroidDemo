package com.dpc.administrator.androiddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dpc.administrator.androiddemo.R;
import com.dpc.administrator.androiddemo.bean.Customer;


import java.util.ArrayList;


/**
 * Created by linkmax on 2016/8/3.
 */
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ListViewHolder> {


    private ArrayList<Customer> mdatas;

    private Context mContext;

    //配置按钮点击事件
    private ButtonInterface buttonInterface;

    /*
    * 配置recycleView长按和短按事件
    * */
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public CustomerAdapter(ArrayList<Customer> datas, Context context) {
        mdatas = datas;
        mContext = context;
    }

    /**
     *item中按钮点击事件需要的方法
     */
    public void buttonSetOnclick(ButtonInterface buttonInterface){
        this.buttonInterface=buttonInterface;
    }

    /**
     * item按钮点击事件对应的接口
     */
    public interface ButtonInterface{
        public void onclick( View view,int position);
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_activity, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, final int position) {
        holder.tv_username.setText(mdatas.get(position).getUsername());
        holder.tv_phone.setText(mdatas.get(position).getPhone());
        /*按钮点击事件*/
        holder.bt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonInterface.onclick(view,position);
            }
        });

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                    //addData(pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    //removeData(pos);
                    return false;
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if(mdatas==null || mdatas.size()<=0){
            return 0;
        }
        return mdatas.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_username;
        TextView tv_phone;
        Button   bt_phone;
        public ListViewHolder(View itemView) {
            super(itemView);
            tv_username=(TextView) itemView.findViewById(R.id.tv_username);
            tv_phone=(TextView) itemView.findViewById(R.id.tv_phone);
            bt_phone=(Button) itemView.findViewById(R.id.bt_phone);
        }
    }
}
