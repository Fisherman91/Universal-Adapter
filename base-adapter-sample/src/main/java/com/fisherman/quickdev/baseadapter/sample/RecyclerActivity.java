package com.fisherman.quickdev.baseadapter.sample;

import com.fisherman.quickdev.baseadapter.recyler.CommonRecyclerAdapter;
import com.fisherman.quickdev.baseadapter.recyler.CommonRecyclerViewHolder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的RecyclerView Adapter基本用法
 */
public class RecyclerActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler);
        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.MyRecyclerView);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        mRecyclerView.setAdapter(new CommonRecyclerAdapter<String>(this, mDatas, R.layout.item_single_recylerview) {
            @Override
            public void convert(CommonRecyclerViewHolder viewHolder, final String item, final int position) {
                viewHolder.setText(R.id.id_num, item);//赋值
                viewHolder.setOnlickListener(R.id.id_num, new View.OnClickListener() {//监听事件
                    @Override
                    public void onClick(View v) {

                    }
                });

                viewHolder.setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RecyclerActivity.this, "点击了第" + position + "行," + item, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'a'; i <= 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
