package com.example.asm2_animal_demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private static final String USER_DATA = "USER_DATA";
    public static final String TAG = DetailFragment.class.getName();

    // TODO: Rename and change types of parameters
    private TextView textdetail,tv_mota;
    private ImageView imgdetail,imgfavordetail;
    private Button button;
    private View mView;
    private User user;
    private boolean isLiked = false;
    private OnItemFavouriteChangedListener listener;

    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(User userData) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(USER_DATA, userData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(USER_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail, container, false);

        textdetail = mView.findViewById(R.id.tv_detail);
        imgdetail = mView.findViewById(R.id.img_detail);
        tv_mota = mView.findViewById(R.id.tv_mota);
        button = mView.findViewById(R.id.bt_back);
        imgfavordetail = mView.findViewById(R.id.img_favordetail);

        textdetail.setText(user.getText2());
        imgdetail.setImageResource(user.getImg2());
        tv_mota.setText(user.getMota());
        isLiked = user.getLiked();
        checkIsFavored();

        imgfavordetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLiked = !isLiked;
                checkIsFavored();
                user.setLiked(isLiked);

                if (listener != null)
                    listener.onFavouriteChanged(user);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return mView;
    }
    private void checkIsFavored(){
        if (isLiked){
            imgfavordetail.setImageResource(R.drawable.ic_favor);
        }
        else{
            imgfavordetail.setImageResource(R.drawable.ic_not_favor);
        }
    }

    public void setOnFavouriteChangedListener(OnItemFavouriteChangedListener listener){
        this.listener = listener;
    }

    interface OnItemFavouriteChangedListener{
        void onFavouriteChanged(User newUserData);
    }
}