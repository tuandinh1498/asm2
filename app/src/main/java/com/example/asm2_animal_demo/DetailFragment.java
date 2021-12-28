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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = DetailFragment.class.getName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textdetail,tv_mota;
    private ImageView imgdetail,imgfavordetail;
    private Button button;
    private View mView;
    private User user;
    private boolean isLiked=false;


    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_detail,container,false);

        textdetail=mView.findViewById(R.id.tv_detail);
        imgdetail=mView.findViewById(R.id.img_detail);
        tv_mota=mView.findViewById(R.id.tv_mota);
        button=mView.findViewById(R.id.bt_back);
        imgfavordetail=mView.findViewById(R.id.img_favordetail);
        Bundle bundlerc=getArguments();
        User user= (User) bundlerc.get("object_user");
        textdetail.setText(user.getText2());
        imgdetail.setImageResource(user.getImg2());
        tv_mota.setText(user.getMota());
        isLiked=user.getLiked();
        checkIsFavored();

        imgfavordetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLiked = !isLiked;
                checkIsFavored();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getFragmentManager()!=null) {
                    HomeFragment homeFragment=new HomeFragment();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("object_detail",user);
                    homeFragment.setArguments(bundle);
                    getFragmentManager().popBackStack();
                }
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
        user.setLiked(isLiked);


    }
}