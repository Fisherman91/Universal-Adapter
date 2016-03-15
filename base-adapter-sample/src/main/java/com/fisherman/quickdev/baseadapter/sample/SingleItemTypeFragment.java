package com.fisherman.quickdev.baseadapter.sample;

import com.fisherman.quickdev.baseadapter.CommonAdapter;
import com.fisherman.quickdev.baseadapter.ViewHolder;
import com.fisherman.quickdev.baseadapter.sample.bean.Bean;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuGang on 2016/1/21 15:25.
 */
public class SingleItemTypeFragment extends android.support.v4.app.ListFragment {
    private List<Bean> mDatas;

    private final String TAG = "SingleItemTypeFragment";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new CommonAdapter<Bean>(getActivity(), mDatas,
                R.layout.item_single_listview)
        {
            @Override
            public void convert(final ViewHolder viewHolder, final Bean bean)
            {
                Log.d(TAG, "convert : " + viewHolder.getPosition() + "...");
                viewHolder.setText(R.id.id_title, bean.getTitle())
                        .setText(R.id.id_desc, bean.getDesc())
                        .setText(R.id.id_time, bean.getTime())
                        .setText(R.id.id_phone, bean.getPhone());

                viewHolder.setOnlickListener(R.id.id_title, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), bean.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initDatas()
    {
        mDatas = new ArrayList<Bean>();

        Bean bean = new Bean("Android新技能Get 1",
                "Android打造万能的ListView和GridView适配器", "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 2", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 3", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10000");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 4", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10010");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 5", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "95555");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 6", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 7", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 8", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能Get 9", "Android打造万能的ListView和GridView适配器",
                "2014-12-12", "10086");
        mDatas.add(bean);

    }

}
