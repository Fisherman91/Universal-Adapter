package com.fisherman.quickdev.baseadapter.recyler;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LiuGang on 2016/3/4 14:33.
 */
public class CommonRecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;

    public CommonRecyclerViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }


    /*-------------set values------------------------------*/

    /**
     * 为TextView设置字符串
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 设置Bitmap
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 设置网络图片
     */
    public ViewHolder setImageByUrl(int viewId, String url) {
        ImageLoader.getInstance().displayImage(url,
                (ImageView) getView(viewId));
        return this;
    }

    /*-------------set listeners-----------------*/

    /**
     * Item 点击事件
     * @param listener
     */
    public void setOnItemClickListener(View.OnClickListener listener) {
        this.mItemView.setOnClickListener(listener);
    }

    /**
     * Item 长按事件
     * @param listener
     */
    public void setOnLongClickListener(View.OnLongClickListener listener) {
        this.mItemView.setOnLongClickListener(listener);
    }

    /**
     * 监听Item中子View的点击事件
     */
    public ViewHolder setOnlickListener(int viewId, View.OnClickListener listener) {
        View v = getView(viewId);
        v.setOnClickListener(listener);
        return this;
    }

    public ViewHolder setOnTouchListener(int viewId,
                                         View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public ViewHolder setOnLongClickListener(int viewId,
                                             View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

}
