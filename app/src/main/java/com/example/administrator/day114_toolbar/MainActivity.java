package com.example.administrator.day114_toolbar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.day114_toolbar.adapter.VpFragAdapter;
import com.example.administrator.day114_toolbar.fragment.ContentFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private Context context = MainActivity.this;
    public static String[] titles = {"热点", "社会", "健康", "机智", "闪现", "引燃", "冷点"};
    private int[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GRAY, Color.GREEN, Color.BLACK, Color.MAGENTA};
    private ViewPager vp_show;
    private Fragment[] fragments;
    private TabLayout tl_tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        setToolBar();
        initFragments();
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, Main2Activity.class));
            }
        });
    }

    private void initFragments() {
        fragments = new Fragment[titles.length];
        for (int i = 0; i < titles.length; i++) {
            fragments[i] = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("color", colors[i]);
            bundle.putString("title", titles[i]);
            fragments[i].setArguments(bundle);
        }
        setViewPager();
    }

    private void setViewPager() {
        vp_show = (ViewPager) findViewById(R.id.vp_show);
        tl_tabs = (TabLayout) findViewById(R.id.tl_tabs);
        vp_show.setAdapter(new VpFragAdapter(getSupportFragmentManager(), fragments));
        tl_tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl_tabs.setupWithViewPager(vp_show);
    }

    private void setToolBar() {

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setNavigationIcon(R.mipmap.header_btn_more_nor);
        toolBar.setTitle("发现");
        //toolBar.setTitleTextColor(Color.WHITE);
        //toolBar.setSubtitle("小标题");
        //toolBar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolBar);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            private String title;

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_search:
                        title = (String) item.getTitle();
                        break;
                    case R.id.menu_more:
                        title = (String) item.getTitle();
                        break;
                    case R.id.menu_pay:
                        title = (String) item.getTitle();
                        break;
                    case R.id.menu_sao:
                        title = (String) item.getTitle();
                        break;
                }
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "回退键", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
