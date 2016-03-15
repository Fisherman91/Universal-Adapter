package com.fisherman.quickdev.baseadapter.recyler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuGang on 2016/3/4 11:08.
 * 通用的Adapter，供RecyclerView使用
 */
public abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<CommonRecyclerViewHolder> {

    public static final String TAG = "CommonRecyclerAdapter";

    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected final int mItemLayoutId;

    public CommonRecyclerAdapter(Context context, List<T> datas, int itemLayoutId) {
        mDatas = new ArrayList<>();
        if (datas != null && !datas.isEmpty()) {//第一次创建CommonRecyclerAdapter，如果有
            mDatas.addAll(datas);
        }
        mDatas = datas;
        mItemLayoutId = itemLayoutId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder()------------------------");
        View itemView = mInflater.inflate(mItemLayoutId, parent, false);
        return new CommonRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommonRecyclerViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder()-------------------position:" + position);
        convert(holder, getItem(position), position);
    }

    public abstract void convert(CommonRecyclerViewHolder viewHolder, T item, int position);

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> list) {
        mDatas.clear();
        if (list != null)
            mDatas.addAll(list);
    }

    public void addData(T item) {
        mDatas.add(item);
    }

    public void addData(List<T> list) {
        mDatas.addAll(list);
    }

}