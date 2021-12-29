package com.example.asm2_animal_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> listuser;
    private Iclicklistener mIclicklistener;
    private Context mContext;
    private User user;



    public interface Iclicklistener{
             void Onclicklistener(User user,int position);
         }
    public UserAdapter(List<User> listuser,Iclicklistener listener) {
        this.listuser = listuser;
        this.mIclicklistener=listener;
    }
    public  void setData(Context context, List<User> list){
        this.mContext=context;
        this.listuser=list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listuser.get(position);
        if(user == null){
            return;
        }

        if (user.getLiked()){
            holder.imgfavorhome.setImageResource(R.drawable.ic_favor);
        }
        else {
            holder.imgfavorhome.setImageResource(R.drawable.ic_not_favor);
        }

          holder.imagehome.setImageResource(user.getImg1());
          holder.imagehome.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                mIclicklistener.Onclicklistener(user,position);
              }
          });
    }

    @Override
    public int getItemCount() {
        if(listuser!=null) {
            return listuser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
         private TextView texthome;
         private ImageView imagehome,imgfavorhome;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imagehome=itemView.findViewById(R.id.img_home);
            imgfavorhome=itemView.findViewById(R.id.img_favorhome);
        }
    }
}
