package com.example.asm2_animal_demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements DetailFragment.OnItemFavouriteChangedListener {

    private RecyclerView rcv;
    private View mView;
    private MainActivity mainActivity;
    private List<User> listData =getListuser();
    private List<User> listData1 =getListuser1();



    private UserAdapter userAdapter;
    private DrawerLayout mdrawer;
    private ImageView imgsea,imgmama,imgbird;
    private com.google.android.material.appbar.MaterialToolbar btdrawer;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mainActivity = (MainActivity) getActivity();
        mdrawer=mView.findViewById(R.id.drawer);
        btdrawer=mView.findViewById(R.id.bt_clicknavi);
        imgbird=mView.findViewById(R.id.iv_bird);
        imgmama=mView.findViewById(R.id.iv_mammal);
        imgsea=mView.findViewById(R.id.iv_sea);
        rcv = mView.findViewById(R.id.rcv_user);

        btdrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdrawer.openDrawer(GravityCompat.START);
                imgsea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(mainActivity,3);
                        rcv.setLayoutManager(linearLayoutManager);
                        userAdapter = new UserAdapter(listData, new UserAdapter.Iclicklistener() {
                            @Override
                            public void Onclicklistener(User user, int position) {
                                gotoDetailFragment(listData, position);
                            }
                        });

                        rcv.setAdapter(userAdapter);

                        mdrawer.closeDrawers();
                    }
                });
                imgbird.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(mainActivity,3);
                        rcv.setLayoutManager(linearLayoutManager);
                        userAdapter = new UserAdapter(listData1, new UserAdapter.Iclicklistener() {
                            @Override
                            public void Onclicklistener(User user, int position) {
                                gotoDetailFragment(listData1, position);
                            }
                        });

                        rcv.setAdapter(userAdapter);
                        mdrawer.closeDrawers();
                    }
                });
                imgmama.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mdrawer.closeDrawers();
                    }
                });

            }
        });





        return mView;
    }

    private List<User> getListuser() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.cho, R.drawable.cho, "Chó", "Chó cũng là loài động vật đầu tiên được con người thuần hóa và đã được chọn giống qua hàng thiên niên kỷ với nhiều hành vi, khả năng cảm nhận và đặc tính vật lý.[6] Loài vật này được sử dụng để giữ nhà hoặc làm thú chơi. Răng của chúng dùng để giết mồi, nhai thịt và gặm thịt, thỉnh thoảng để cắn nhau. Chó là loài động vật được nuôi nhiều trên thế giới, có thể trông coi nhà, chăn cừu, dẫn đường, kéo xe, cũng là thực phẩm giàu đạm."));
        list.add(new User(R.drawable.chuot, R.drawable.chuot, "Chuột", "Họ Chuột (Muridae) là họ động vật ăn tạp và là động vật gặm nhấm lớp thú lớn nhất hành tinh,hơn 1383 loài đã được phát hiện trên toàn cầu bao gồm nhiều nhất loài chuột nhắt,chuột cống,chuột nhảy gerbil,...được tìm thấy trên khắp lục địa Á-Âu, Châu Phi,Úc,Nhật Bản,..."));
        list.add(new User(R.drawable.cho, R.drawable.cho, "Cóc ", "Cóc trong tiếng Việt khi đề cập tới một nhóm động vật thuộc bộ Ếch nhái hay bộ Không đuôi (Anura) thì nói chung là các động vật có lớp da sần sùi, khi trưởng thành chủ yếu sống trên cạn. Tuy nhiên, nó không là sự phân loại khoa học chính xác do cóc có thể là tên gọi chung cho các loài trong các họ khác nhau"));
        list.add(new User(R.drawable.ga, R.drawable.ga, "Gà ", "Gà hay gà nhà, gà Đồi (danh pháp hai phần: Gallus gallus, Gallus gallus domesticus) là một loài chim đã được con người thuần hoá cách đây hàng nghìn năm. Một số ý kiến cho rằng loài này có thuỷ tổ từ loài chim hoang dã ở Ấn Độ và loài gà rừng lông đỏ nhiệt đới ở vùng Đông Nam Á."));
        list.add(new User(R.drawable.voi, R.drawable.voi, "Koala", "Koala, hay gấu túi (danh pháp khoa học: Phascolarctos cinereus) là một loài thú có túi ăn thực vật sống tại Úc và là loài vật duy nhất hiện còn sống trong họ Phascolarctidae, và họ hàng gần gũi nhất còn sinh tồn của nó là wombat.[1] Koala được tìm thấy ở vùng dọc theo bờ biển phía đông và nam đảo chính, chính xác là ở Queensland, New South Wales, Victoria và Nam Úc."));
        list.add(new User(R.drawable.lon, R.drawable.lon, "Lợn", "Lợn nhà hay heo nhà là một giống loài được thuần hóa từ loài lợn rừng, được chăn nuôi để cung cấp thịt. Hầu hết lợn nhà có lớp lông mỏng trên bề mặt da. Lợn nhà thường được cho rằng là một phân loài từ tổ tiên hoang dã của chúng là lợn rừng, trong trường hợp này chúng được đặt tên sinh học là Sus scrofa domesticus."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Mèo", "Mèo, chính xác hơn là loài mèo nhà để phân biệt với các loài trong họ Mèo khác, là động vật có vú, nhỏ nhắn và chuyên ăn thịt, sống chung với loài người, được nuôi để săn vật gây hại hoặc làm thú nuôi cùng với chó nhà. Mèo nhà đã sống gần gũi với loài người ít nhất 9.500 năm,[4] và hiện nay chúng là con vật cưng phổ biến nhất trên thế giới."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Rắn", "Rắn là tên gọi chung để c"));
        return list;
    }
    private List<User> getListuser1() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.voi, R.drawable.voi, "Chó", "Chó cũng là loài động vật đầu tiên được con người thuần hóa và đã được chọn giống qua hàng thiên niên kỷ với nhiều hành vi, khả năng cảm nhận và đặc tính vật lý.[6] Loài vật này được sử dụng để giữ nhà hoặc làm thú chơi. Răng của chúng dùng để giết mồi, nhai thịt và gặm thịt, thỉnh thoảng để cắn nhau. Chó là loài động vật được nuôi nhiều trên thế giới, có thể trông coi nhà, chăn cừu, dẫn đường, kéo xe, cũng là thực phẩm giàu đạm."));
        list.add(new User(R.drawable.voi, R.drawable.voi, "Chuột", "Họ Chuột (Muridae) là họ động vật ăn tạp và là động vật gặm nhấm lớp thú lớn nhất hành tinh,hơn 1383 loài đã được phát hiện trên toàn cầu bao gồm nhiều nhất loài chuột nhắt,chuột cống,chuột nhảy gerbil,...được tìm thấy trên khắp lục địa Á-Âu, Châu Phi,Úc,Nhật Bản,..."));
        list.add(new User(R.drawable.cho, R.drawable.cho, "Cóc ", "Cóc trong tiếng Việt khi đề cập tới một nhóm động vật thuộc bộ Ếch nhái hay bộ Không đuôi (Anura) thì nói chung là các động vật có lớp da sần sùi, khi trưởng thành chủ yếu sống trên cạn. Tuy nhiên, nó không là sự phân loại khoa học chính xác do cóc có thể là tên gọi chung cho các loài trong các họ khác nhau"));
        list.add(new User(R.drawable.ga, R.drawable.ga, "Gà ", "Gà hay gà nhà, gà Đồi (danh pháp hai phần: Gallus gallus, Gallus gallus domesticus) là một loài chim đã được con người thuần hoá cách đây hàng nghìn năm. Một số ý kiến cho rằng loài này có thuỷ tổ từ loài chim hoang dã ở Ấn Độ và loài gà rừng lông đỏ nhiệt đới ở vùng Đông Nam Á."));
        list.add(new User(R.drawable.voi, R.drawable.voi, "Koala", "Koala, hay gấu túi (danh pháp khoa học: Phascolarctos cinereus) là một loài thú có túi ăn thực vật sống tại Úc và là loài vật duy nhất hiện còn sống trong họ Phascolarctidae, và họ hàng gần gũi nhất còn sinh tồn của nó là wombat.[1] Koala được tìm thấy ở vùng dọc theo bờ biển phía đông và nam đảo chính, chính xác là ở Queensland, New South Wales, Victoria và Nam Úc."));
        list.add(new User(R.drawable.lon, R.drawable.lon, "Lợn", "Lợn nhà hay heo nhà là một giống loài được thuần hóa từ loài lợn rừng, được chăn nuôi để cung cấp thịt. Hầu hết lợn nhà có lớp lông mỏng trên bề mặt da. Lợn nhà thường được cho rằng là một phân loài từ tổ tiên hoang dã của chúng là lợn rừng, trong trường hợp này chúng được đặt tên sinh học là Sus scrofa domesticus."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Mèo", "Mèo, chính xác hơn là loài mèo nhà để phân biệt với các loài trong họ Mèo khác, là động vật có vú, nhỏ nhắn và chuyên ăn thịt, sống chung với loài người, được nuôi để săn vật gây hại hoặc làm thú nuôi cùng với chó nhà. Mèo nhà đã sống gần gũi với loài người ít nhất 9.500 năm,[4] và hiện nay chúng là con vật cưng phổ biến nhất trên thế giới."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Rắn", "Rắn là tên gọi chung để c"));
        return list;
    }



    private void updateData(User user) {
        for (int i = 0; i < listData.size(); ++i) {
            if (listData.get(i).equals(user)) {
                listData.get(i).setLiked(user.getLiked());
                return;
            }
        }
        for (int i = 0; i < listData1.size(); ++i) {
            if (listData1.get(i).equals(user)) {
                listData1.get(i).setLiked(user.getLiked());
                return;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (userAdapter != null) {
            userAdapter.notifyDataSetChanged();

        }
    }

    void gotoDetailFragment(List<User> listData, int position) {
        DetailFragment detailFragment = DetailFragment.newInstance(listData, position);
       // detailFragment.setOnFavouriteChangedListener(this);

        FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, detailFragment);
        fragmentTransaction.addToBackStack(DetailFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onFavouriteChanged(User newUserData) {
        updateData(newUserData);
    }
}