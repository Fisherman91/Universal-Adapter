package com.fisherman.quickdev.baseadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by LiuGang on 2016/1/21 17:08.
 * 适用多种类型item的适配器
 */
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    MultiItemTypeSupport mMultiItemTypeSupport;

    public MultiItemCommonAdapter(Context context, List<T> datas, MultiItemTypeSupport multiItemTypeSupport) {
        super(context, datas, -1);
        mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getViewTypeCount() {
        if (mMultiItemTypeSupport != null)
            return mMultiItemTypeSupport.getViewTypeCount();
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultiItemTypeSupport != null)
            return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mMultiItemTypeSupport == null) {
            return super.getView(position, convertView, parent);
        }

        int layoutId = mMultiItemTypeSupport.getLayoutId(position, mDatas.get(position));
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext, position, convertView, parent, layoutId);
        convert(viewHolder, mDatas.get(position));
        return viewHolder.getConvertView();
    }
}
