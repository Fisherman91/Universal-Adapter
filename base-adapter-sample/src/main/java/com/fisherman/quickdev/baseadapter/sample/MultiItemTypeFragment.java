package com.fisherman.quickdev.baseadapter.sample;

import com.fisherman.quickdev.baseadapter.sample.adapter.ChatAdapter;
import com.fisherman.quickdev.baseadapter.sample.bean.ChatMessage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by LiuGang on 2016/1/21 16:28.
 */
public class MultiItemTypeFragment extends ListFragment {

    private ArrayList<ChatMessage> mDatas = new ArrayList<ChatMessage>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(null);
        setListAdapter(new ChatAdapter(getActivity(), mDatas));
    }

    private void initDatas()
    {

        ChatMessage msg = null;
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "renma", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "renma", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);

        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "renma", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, false);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
                null, true);
        mDatas.add(msg);
        msg = new ChatMessage(R.drawable.renma, "xiaohei", "where are you ",
                null, true);
        mDatas.add(msg);

    }
}
