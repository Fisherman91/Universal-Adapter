package com.fisherman.quickdev.baseadapter;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by LiuGang on 2016/1/20 16:14.
 */
public class ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;
    private int mPosition;
    private int mLayoutId;

    private ViewHolder(Context ctx, ViewGroup parent, int layoutId, int position) {
        mPosition = position;
        mViews = new SparseArray<>();
        mLayoutId = layoutId;
        mConvertView = LayoutInflater.from(ctx).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context, int position, View convertView,
                                           ViewGroup parent, int layoutId) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Log.e("ViewHolder", "convertView is null ");
            viewHolder = new ViewHolder(context, parent, layoutId, position);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.mPosition = position;
        }

        return viewHolder;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
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
     * 监听点击事件
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

    public int getPosition() {
        return mPosition;
    }

    public View getConvertView() {
        return mConvertView;
    }

    public int getLayoutId() {
        return mLayoutId;
    }

}
