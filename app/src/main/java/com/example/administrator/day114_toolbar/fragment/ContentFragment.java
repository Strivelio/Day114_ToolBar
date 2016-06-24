package com.example.administrator.day114_toolbar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.day114_toolbar.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    private ArrayList<String> list;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        Bundle bundle = getArguments();
        setTextBgColor(view, bundle);
        setRecyclerView(view, bundle);
        return view;
    }

    private void setTextBgColor(View view, Bundle bundle) {
        TextView tv_fragment = (TextView) view.findViewById(R.id.tv_fragment);
        int color = bundle.getInt("color");
        tv_fragment.setBackgroundColor(color);
    }

    private void setRecyclerView(View view, Bundle bundle) {
        String title = bundle.getString("title");
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(title + i);
        }
        RecyclerView rv_show = (RecyclerView) view.findViewById(R.id.rv_show);
        //设置布局管理器
        rv_show.setLayoutManager(new LinearLayoutManager(getContext()));

        //设置适配器
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        rv_show.setAdapter(recyclerAdapter);
    }
    //适配器构建
//    1.	定义类继承RecycleView.Adapter<>  泛型传入2写的子类
//    2.	在其中定义类继承RecycleView.ViewHolder, 定义构造方法（传入的是View）
//    3.	实现1要求实现的方法

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
        class ViewHolder extends RecyclerView.ViewHolder{


            TextView text1;

            public ViewHolder(View itemView) {
                super(itemView);
                //找到要显示的控件
                text1 = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(getActivity().getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text1.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }

}
