package com.example.asm2_animal_demo;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailStoryAdapter extends PagerAdapter {

    private final Context mContext;
    private ArrayList<User> user;
    public int postion1;
    private ImageView imgfavor;
    private boolean isLike;
    private MainActivity mainActivity;
    private User object;
    private OnItemFavouriteChangedListener listener;
    private Iclicklistenerback mIclicklistener;



    public interface Iclicklistenerback{
        void Onclicklistenerback(User itemuser,int position);
    }
    public void setData(User user) {
        this.object=user;
    }

   public DetailStoryAdapter(ArrayList<User> user, Context mcontext,Iclicklistenerback mIclicklistener) {
        this.user = user;

        this.mContext=mcontext;
        this.mIclicklistener=mIclicklistener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_detail, container, false);
        User object=user.get(position);


        ImageView imgdt = view.findViewById(R.id.img_detail);


        imgdt.setImageResource(object.getImg2());
        TextView tvdt = view.findViewById(R.id.tv_detail);
        TextView tvddaydu = view.findViewById(R.id.tv_textdaydu);
        tvddaydu.setText(object.getMota());
        Button bt = view.findViewById(R.id.bt_back);
        ImageView img_call=view.findViewById(R.id.tmg_savecall);
        TextView text_sdt=view.findViewById(R.id.tv_sdt);




        imgfavor = view.findViewById(R.id.img_favordetail);
        tvdt.setText(object.getText2());
        boolean isLike = object.getLiked();
        checkIsFavored(isLike, imgfavor);

        imgfavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 object.setLiked(!object.getLiked());
                 checkIsFavored(object.getLiked(), imgfavor);
                mIclicklistener.Onclicklistenerback(user.get(position),postion1);

                if (listener != null)
                    listener.onFavouriteChanged(object);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          mIclicklistener.Onclicklistenerback(user.get(position),postion1);

            }
        });



        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDialog myDialog=new MyDialog(mContext);
                EditText editText=(EditText) myDialog.findViewById(R.id.tv_editdiaolg);
                Button bt_save=(Button) myDialog.findViewById(R.id.bt_save_dialog);
                Button bt_delete=(Button) myDialog.findViewById(R.id.bt_delete_dialog);
                ImageView imag_dialog=(ImageView) myDialog.findViewById(R.id.img_dialog);
                imag_dialog.setImageResource(object.getImg1());



                bt_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String textsdt=editText.getText().toString().trim();

                        //Shared prefenrences luu data sdt
                    SharedPreferences sharedPreferences=mContext.getSharedPreferences("FILE_SAVED",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putInt(textsdt,object.getImg1());
                    editor.putString("abc",textsdt);
                    editor.apply();
                        SharedPreferences Preferences=mContext.getSharedPreferences("FILE_SAVED",Context.MODE_PRIVATE);
                        String sdt=Preferences.getString("abc",null);
                        myDialog.dismiss();
                        text_sdt.setText(sdt);


                    }


                });
                bt_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        text_sdt.setText(null);
                        myDialog.dismiss();
                    }
                });

                myDialog.show();
            }
        });
        //isLike=user.get(position).getLiked();
        //checkIsFavored();


        container.addView(view);
        return view;
    }

    private void checkIsFavored(boolean isLike, ImageView imgfavor) {
        if (isLike) {
            imgfavor.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_favor));
        } else {
            imgfavor.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_not_favor));
        }
        imgfavor.invalidate();
    }
    public void setOnFavouriteChangedListener(OnItemFavouriteChangedListener listener){
        this.listener = listener;
    }

    interface OnItemFavouriteChangedListener{
        void onFavouriteChanged(User newUserData);
    }



    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    //public void setOnFavouriteChangedListener(OnItemFavouriteChangedListener listener){
   // this.listener = listener;
    //}

   // interface OnItemFavouriteChangedListener{
     //   void onFavouriteChanged(User newUserData);
    //}
}




    // View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_detail, container, false);
       // User item = list.get(position);
       // ImageView imgdt=view.findViewById(R.id.img_detail);
       // TextView tvdt=view.findViewById(R.id.tv_detail);
        ///Button bt=view.findViewById(R.id.bt_back);
       // ImageView imgfavor=view.findViewById(R.id.img_favordetail);
       // imgdt.setImageResource(item.getImg2());
        //tvdt.setText(item.getText2());




