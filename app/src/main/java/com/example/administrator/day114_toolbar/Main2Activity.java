package com.example.administrator.day114_toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.day114_toolbar.adapter.VpFragAdapter;
import com.example.administrator.day114_toolbar.fragment.ContentFragment;

public class Main2Activity extends AppCompatActivity {
    public static String[] titles = {"热点", "社会", "健康", "机智", "闪现", "引燃", "冷点"};
    private int[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GRAY, Color.GREEN, Color.BLACK, Color.MAGENTA};
    private ViewPager vp_scroll;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        //浮动按钮
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    final Snackbar snackbar = Snackbar.make(view, "我是Snackbar", Snackbar.LENGTH_LONG);
                    snackbar.setAction("取消", new View.OnClickListener() {

                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            }).show();
                }
            });
        }
    }

    private void initView() {
        initFragments();
    }
    Fragment[] fragments = new Fragment[titles.length];
    private void initFragments() {
        fragments = new Fragment[titles.length];
        for (int i = 0; i < titles.length; i++) {
            fragments[i] = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("color", colors[i]);
            bundle.putString("title", titles[i]);
            fragments[i].setArguments(bundle);
        }
        //设置ViewPager
        setViewPager();
    }

    private void setViewPager() {
        vp_scroll = (ViewPager) findViewById(R.id.vp_scroll);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        vp_scroll.setAdapter(new VpFragAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(vp_scroll);
    }
}
