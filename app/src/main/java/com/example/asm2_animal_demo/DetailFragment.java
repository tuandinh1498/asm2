package com.example.asm2_animal_demo;


import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {
    private Context mContext;

    private String topicName;
    private ArrayList<User> user;

    private int position;
    private static final String USER_DATA = "USER_DATA";
    private static final String DEFAULT_POSITION = "DEFAULT_POSITION";
    public static final String TAG = DetailFragment.class.getName();


    public static DetailFragment newInstance(List<User> listUsers,int position) {
        ArrayList<User> listData = new ArrayList(listUsers.size());
        listData.addAll(listUsers);
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(USER_DATA, listData);
        args.putInt(DEFAULT_POSITION,position);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          user = getArguments().getParcelableArrayList(USER_DATA);
          position = getArguments().getInt(DEFAULT_POSITION);
          Log.e("data received", position + " : " + user.size());
        }
    }
    public void gotoHomefragment(User user, int position) {
        if(getFragmentManager()!=null) {
            HomeFragment homeFragment=new HomeFragment();
            Bundle bundle=new Bundle();
            bundle.putSerializable("ob_user_updated", user);
            homeFragment.setArguments(bundle);
            getFragmentManager().popBackStack();
        }
        getActivity().getSupportFragmentManager().popBackStack();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m003_frg_detail_story, container, false);
        ViewPager vp = rootView.findViewById(R.id.vp_story);
        DetailStoryAdapter adapter = new DetailStoryAdapter(user, mContext, new DetailStoryAdapter.Iclicklistenerback() {
            @Override
            public void Onclicklistenerback(User itemuser, int position) {
                gotoHomefragment(user.get(position),position);
            }
        });
         vp.setAdapter(adapter);
         vp.setCurrentItem(position);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public void setData(ArrayList<User> user) {
        this.user=user;
    }


    //  textdetail = mView.findViewById(R.id.tv_detail);
        //imgdetail = mView.findViewById(R.id.img_detail);
        //  tv_mota = mView.findViewById(R.id.tv_mota);
        // button = mView.findViewById(R.id.bt_back);
        //  imgfavordetail = mView.findViewById(R.id.img_favordetail);

        // textdetail.setText(user.getText2());
        //  imgdetail.setImageResource(user.getImg2());
        // tv_mota.setText(user.getMota());
        // isLiked = user.getLiked();
        //checkIsFavored();

        //imgfavordetail.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View view) {
        //    isLiked = !isLiked;
        //  checkIsFavored();
        //  user.setLiked(isLiked);

        //  if (listener != null)
        //   listener.onFavouriteChanged(user);
        // }
        // });
        // button.setOnClickListener(new View.OnClickListener() {
                                      //    @Override
                                      //public void onClick(View view) {
                //    getActivity().getSupportFragmentManager().popBackStack();
                //  }
                                      //  });


    // private void checkIsFavored(){
        //  if (isLiked){
            //  imgfavordetail.setImageResource(R.drawable.ic_favor);
            //  }
        // else{
            //  imgfavordetail.setImageResource(R.drawable.ic_not_favor);
            // }
        // }

    //public void setOnFavouriteChangedListener(OnItemFavouriteChangedListener listener){
        //this.listener = listener;
   // }

    interface OnItemFavouriteChangedListener{
       void onFavouriteChanged(User newUserData);
    }
}