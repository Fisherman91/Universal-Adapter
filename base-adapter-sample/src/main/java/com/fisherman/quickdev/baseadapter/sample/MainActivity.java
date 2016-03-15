package com.fisherman.quickdev.baseadapter.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private final int TAB_COUNT = 2;

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mButton = (Button) findViewById(R.id.btn_recyler);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == TAB_COUNT - 1) return new MultiItemTypeFragment();
                return new SingleItemTypeFragment();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Single Item Type";
                    case 1:
                        return "Mutli Item Type";
                }
                return "Helloworld";
            }

            @Override
            public int getCount() {
                return TAB_COUNT;
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
