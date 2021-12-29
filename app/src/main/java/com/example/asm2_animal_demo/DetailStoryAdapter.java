package com.example.asm2_animal_demo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class DetailStoryAdapter extends PagerAdapter {

    private final Context mContext;
    private User user;

    public DetailStoryAdapter(User user, Context mContext) {
        this.user = user;
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_detail, container, false);


        ImageView imgdt=view.findViewById(R.id.img_detail);
        imgdt.setImageResource(user.getImg2());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}




    // View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_detail, container, false);
       // User item = list.get(position);
       // ImageView imgdt=view.findViewById(R.id.img_detail);
       // TextView tvdt=view.findViewById(R.id.tv_detail);
        ///Button bt=view.findViewById(R.id.bt_back);
       // ImageView imgfavor=view.findViewById(R.id.img_favordetail);
       // imgdt.setImageResource(item.getImg2());
        //tvdt.setText(item.getText2());




