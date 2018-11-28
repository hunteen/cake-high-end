package com.project.android.projectwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class ShoppingDetailActivity extends AppCompatActivity {
    private Gallery gallery;
    private ImageView imageView;
    private ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commoditydetails);
        //商品图片滑动
        gallery=findViewById(R.id.detail_picture_glr);
        imageView=findViewById(R.id.detail_picture);
        list=new ArrayList();
        list.add(R.drawable.cake_1);
        list.add(R.drawable.cake_2);
        list.add(R.drawable.cake_3);
        list.add(R.drawable.cake_4);
        list.add(R.drawable.cake_5);
        list.add(R.drawable.cake_6);
        GalleryAdpter adpter=new GalleryAdpter(list);
        gallery.setAdapter(adpter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource((int)list.get(position));
            }
        });
    }
    //商品图片滑动
    private class GalleryAdpter extends BaseAdapter {
        private ArrayList list;
        public GalleryAdpter(ArrayList list){
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=new ImageView(ShoppingDetailActivity.this);
            }
            ((ImageView)convertView).setImageResource((int)list.get(position));
            ((ImageView)convertView).setAdjustViewBounds(true);
            return convertView;
        }
    }
}