package com.fisherman.quickdev.baseadapter.sample.adapter;

import com.fisherman.quickdev.baseadapter.MultiItemCommonAdapter;
import com.fisherman.quickdev.baseadapter.MultiItemTypeSupport;
import com.fisherman.quickdev.baseadapter.ViewHolder;
import com.fisherman.quickdev.baseadapter.sample.R;
import com.fisherman.quickdev.baseadapter.sample.bean.ChatMessage;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by LiuGang on 2016/1/21 17:24.
 */
public class ChatAdapter extends MultiItemCommonAdapter<ChatMessage> {

    private final int FROM_MSG = 0;
    private final int SEND_MSG = 1;
    private final int VIEW_TYPE_COUNT = 2;

    private final String TAG = "ChatAdapter";

    public ChatAdapter(Context context, List<ChatMessage> datas) {
        super(context, datas, new MultiItemTypeSupport<ChatMessage>() {
            @Override
            public int getLayoutId(int position, ChatMessage msg) {

                if (msg.isComMeg())
                    return R.layout.main_chat_from_msg;
                else
                    return R.layout.main_chat_send_msg;
            }

            @Override
            public int getViewTypeCount() {
                return ChatMessage.VIEW_TYPE_COUNT;
            }

            @Override
            public int getItemViewType(int postion, ChatMessage msg) {
                if (msg.isComMeg())
                    return ChatMessage.FROM_MSG;
                else
                    return ChatMessage.SEND_MSG;

            }
        });
    }

    @Override
    public void convert(ViewHolder viewHolder, ChatMessage chatMessage) {
        Log.d(TAG, "convert : " + viewHolder.getPosition() + "...layoutId:" + viewHolder.getLayoutId());
        switch (viewHolder.getLayoutId())
        {
            case R.layout.main_chat_from_msg:
                viewHolder.setText(R.id.chat_from_content, chatMessage.getContent());
                viewHolder.setText(R.id.chat_from_name, chatMessage.getName());
                viewHolder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
                break;
            case R.layout.main_chat_send_msg:
                viewHolder.setText(R.id.chat_send_content, chatMessage.getContent());
                viewHolder.setText(R.id.chat_send_name, chatMessage.getName());
                viewHolder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
                break;
        }
    }


}
