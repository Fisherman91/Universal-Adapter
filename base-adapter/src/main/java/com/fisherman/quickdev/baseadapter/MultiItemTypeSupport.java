package com.fisherman.quickdev.baseadapter;

/**
 * Created by LiuGang on 2016/1/21 17:09.
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int position, T t);
    int getViewTypeCount();
    int getItemViewType(int postion, T t);
}
