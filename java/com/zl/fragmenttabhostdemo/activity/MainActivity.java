package com.zl.fragmenttabhostdemo.activity;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.zl.fragmenttabhostdemo.R;
import com.zl.fragmenttabhostdemo.entity.Tab;
import com.zl.fragmenttabhostdemo.fragment.ChatFragment;
import com.zl.fragmenttabhostdemo.fragment.HomeFragment;
import com.zl.fragmenttabhostdemo.fragment.PhotoFragment;
import com.zl.fragmenttabhostdemo.fragment.ScheduleFragment;
import com.zl.fragmenttabhostdemo.fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    private List<Tab> mTabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTabs();
    }

    private void initView() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    private void initTabs() {
        tabHost.setup(this,getSupportFragmentManager(),R.id.tab_content);
        Tab home = new Tab(HomeFragment.class,R.string.home,R.drawable.home);
        Tab chat = new Tab(ChatFragment.class,R.string.chat,R.drawable.chat);
        Tab photo = new Tab(PhotoFragment.class,R.string.photo,R.drawable.photo);
        Tab schedule = new Tab(ScheduleFragment.class,R.string.schedule,R.drawable.schedule);
        Tab set = new Tab(SetFragment.class,R.string.set,R.drawable.set);
        mTabs.add(home);
        mTabs.add(chat);
        mTabs.add(photo);
        mTabs.add(schedule);
        mTabs.add(set);

        for(Tab tab : mTabs){
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(bindIndicator(tab));
            tabHost.addTab(tabSpec,tab.getFragment(),null);
        }

        tabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabHost.setCurrentTab(0);
    }

    private View bindIndicator(Tab tab) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator,null);
        TextView tv = (TextView) view.findViewById(R.id.tv_indicator);
        ImageView iv = view.findViewById(R.id.iv_indicator);
        tv.setText(tab.getTitle());
        iv.setBackgroundResource(tab.getIcon());
        return view;
    }


}
