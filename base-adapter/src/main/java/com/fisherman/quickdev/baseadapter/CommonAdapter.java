package com.fisherman.quickdev.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by LiuGang on 2016/1/20 17:15.
 * 适用单类型item的适配器，供ListView使用
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> datas, int itemLayoutId) {
        mContext = context;
        mDatas = datas;
        mItemLayoutId = itemLayoutId;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder viewHolder, T item);

    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent) {
        return ViewHolder.getViewHolder(mContext, position, convertView, parent, mItemLayoutId);
    }
}
