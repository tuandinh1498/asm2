package com.example.asm2_animal_demo;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements DetailStoryAdapter.OnItemFavouriteChangedListener{

    private RecyclerView rcv;
    private View mView;
    private Context mContext;
    private MainActivity mainActivity;
    private List<User> listData =getListuser();
    private List<User> listData1 =getListuser1();
    private List<User> listData2 =getListuser2();
    private static int key;


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
                        key=3;
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(mainActivity,3);
                        rcv.setLayoutManager(linearLayoutManager);
                        userAdapter = new UserAdapter(listData2, new UserAdapter.Iclicklistener() {
                            @Override
                            public void Onclicklistener(User user, int position) {
                                gotoDetailFragment(listData2, position);
                            }
                        });

                        rcv.setAdapter(userAdapter);

                        mdrawer.closeDrawers();
                    }
                });
                imgbird.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       key=1;
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
                     key=2;
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

            }
        });





        return mView;
    }

    private List<User> getListuser() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.cho, R.drawable.cho, "Mam_Ch??", "Ch?? c??ng l?? lo??i ?????ng v???t ?????u ti??n ???????c con ng?????i thu???n h??a v?? ???? ???????c ch???n gi???ng qua h??ng thi??n ni??n k??? v???i nhi???u h??nh vi, kh??? n??ng c???m nh???n v?? ?????c t??nh v???t l??.[6] Lo??i v???t n??y ???????c s??? d???ng ????? gi??? nh?? ho???c l??m th?? ch??i. R??ng c???a ch??ng d??ng ????? gi???t m???i, nhai th???t v?? g???m th???t, th???nh tho???ng ????? c???n nhau. Ch?? l?? lo??i ?????ng v???t ???????c nu??i nhi???u tr??n th??? gi???i, c?? th??? tr??ng coi nh??, ch??n c???u, d???n ???????ng, k??o xe, c??ng l?? th???c ph???m gi??u ?????m."));
        list.add(new User(R.drawable.chuot, R.drawable.chuot, "Mam_Chu???t", "H??? Chu???t (Muridae) l?? h??? ?????ng v???t ??n t???p v?? l?? ?????ng v???t g???m nh???m l???p th?? l???n nh???t h??nh tinh,h??n 1383 lo??i ???? ???????c ph??t hi???n tr??n to??n c???u bao g???m nhi???u nh???t lo??i chu???t nh???t,chu???t c???ng,chu???t nh???y gerbil,...???????c t??m th???y tr??n kh???p l???c ?????a ??-??u, Ch??u Phi,??c,Nh???t B???n,..."));
        list.add(new User(R.drawable.cho, R.drawable.cho, "Mam_C??c ", "C??c trong ti???ng Vi???t khi ????? c???p t???i m???t nh??m ?????ng v???t thu???c b??? ???ch nh??i hay b??? Kh??ng ??u??i (Anura) th?? n??i chung l?? c??c ?????ng v???t c?? l???p da s???n s??i, khi tr?????ng th??nh ch??? y???u s???ng tr??n c???n. Tuy nhi??n, n?? kh??ng l?? s??? ph??n lo???i khoa h???c ch??nh x??c do c??c c?? th??? l?? t??n g???i chung cho c??c lo??i trong c??c h??? kh??c nhau"));
        list.add(new User(R.drawable.ga, R.drawable.ga, "Mam_G?? ", "G?? hay g?? nh??, g?? ?????i (danh ph??p hai ph???n: Gallus gallus, Gallus gallus domesticus) l?? m???t lo??i chim ???? ???????c con ng?????i thu???n ho?? c??ch ????y h??ng ngh??n n??m. M???t s??? ?? ki???n cho r???ng lo??i n??y c?? thu??? t??? t??? lo??i chim hoang d?? ??? ???n ????? v?? lo??i g?? r???ng l??ng ????? nhi???t ?????i ??? v??ng ????ng Nam ??."));
        list.add(new User(R.drawable.voi, R.drawable.voi, "Mam_Koala", "Koala, hay g???u t??i (danh ph??p khoa h???c: Phascolarctos cinereus) l?? m???t lo??i th?? c?? t??i ??n th???c v???t s???ng t???i ??c v?? l?? lo??i v???t duy nh???t hi???n c??n s???ng trong h??? Phascolarctidae, v?? h??? h??ng g???n g??i nh???t c??n sinh t???n c???a n?? l?? wombat.[1] Koala ???????c t??m th???y ??? v??ng d???c theo b??? bi???n ph??a ????ng v?? nam ?????o ch??nh, ch??nh x??c l?? ??? Queensland, New South Wales, Victoria v?? Nam ??c."));
        list.add(new User(R.drawable.lon, R.drawable.lon, "Mam_L???n", "L???n nh?? hay heo nh?? l?? m???t gi???ng lo??i ???????c thu???n h??a t??? lo??i l???n r???ng, ???????c ch??n nu??i ????? cung c???p th???t. H???u h???t l???n nh?? c?? l???p l??ng m???ng tr??n b??? m???t da. L???n nh?? th?????ng ???????c cho r???ng l?? m???t ph??n lo??i t??? t??? ti??n hoang d?? c???a ch??ng l?? l???n r???ng, trong tr?????ng h???p n??y ch??ng ???????c ?????t t??n sinh h???c l?? Sus scrofa domesticus."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Mam_M??o", "M??o, ch??nh x??c h??n l?? lo??i m??o nh?? ????? ph??n bi???t v???i c??c lo??i trong h??? M??o kh??c, l?? ?????ng v???t c?? v??, nh??? nh???n v?? chuy??n ??n th???t, s???ng chung v???i lo??i ng?????i, ???????c nu??i ????? s??n v???t g??y h???i ho???c l??m th?? nu??i c??ng v???i ch?? nh??. M??o nh?? ???? s???ng g???n g??i v???i lo??i ng?????i ??t nh???t 9.500 n??m,[4] v?? hi???n nay ch??ng l?? con v???t c??ng ph??? bi???n nh???t tr??n th??? gi???i."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Mam_R???n", "R???n l?? t??n g???i chung ????? "));
        return list;
    }
    private List<User> getListuser1() {
        List<User> list=new ArrayList<>();
      list.add(new User(R.drawable.csao,R.drawable.csao,"Chim ","Chim h??? S??o c?? ch??n kh???e, ???????ng bay kh???e v?? th???ng, v?? ch??ng th??ch s???ng th??nh b???y. M??i tr?????ng sinh s???ng ??a th??ch c???a ch??ng l?? v??ng n??ng th??n t????ng ?????i tho??ng, ch??ng ??n s??u b??? v?? qu???. M???t v??i lo??i s???ng xung quanh n??i sinh s???ng c???a ng?????i v?? ch??ng l?? nh???ng lo??i chim th???c s??? ??n t???p. "));
        list.add(new User(R.drawable.cchaomao,R.drawable.cchaomao,"Ch??o m??o","Ch??o m??o (Pycnonotus jocosus) l?? m???t lo??i chim thu???c b??? S??? ph??n b??? ??? ch??u ??. N?? l?? m???t th??nh vi??n c???a h??? Ch??o m??o. N?? l?? m???t lo??i ?????ng v???t ??n qu??? th?????ng tr?? ???????c t??m th???y ch??? y???u ??? ch??u ?? nhi???t ?????i. N?? ???? ???????c ????a b???i con ng?????i v??o nhi???u khu v???c nhi???t ?????i tr??n th??? gi???i, n??i c??c qu???n th??? ???? t??? h??nh th??nh. N?? ??n tr??i c??y v?? c??n tr??ng nh???. Ch??ng d??? th???y ?????u tr??n c??y v?? k??u to ba ho???c b???n n???t."));
        list.add(new User(R.drawable.choami,R.drawable.choami,"Hoa mi","Garrulax canorus l?? m???t lo??i chim trong h??? Leiothrichidae.[2] T??n g???i h???a mi ngh??a l?? \"???????c v??? l??n mi m???t\" ????? ch??? qu???ng l??ng s??ng m??u quanh m???t ?????c tr??ng c???a lo??i."));
        list.add(new User(R.drawable.cvet,R.drawable.cvet,"V???t","V???t c??n ???????c g???i l?? chim k??t hay chim k?? tia l?? c??c lo??i chim g???m kho???ng 393 lo??i trong 92 chi c???a B??? V???t Psittaciformes,[2] ???????c t??m th???y ch??? y???u ??? c??c v??ng nhi???t ?????i v?? c???n nhi???t ?????i."));
        list.add(new User(R.drawable.cvkhuyen,R.drawable.cvkhuyen,"V??nh khuy??n","H??? V??nh khuy??n hay khoen (danh ph??p khoa h???c: Zosteropidae) l?? m???t h??? chim ch???a kho???ng 140 lo??i thu???c b??? S??? (Passeriformes) c?? ngu???n g???c t??? v??ng nhi???t ?????i v?? c???n nhi???t ?????i ch??u Phi, mi???n nam ch??u ?? v?? Australasia. "));
        list.add(new User(R.drawable.cyen,R.drawable.cyen,"Y???n","H??? Y???n hay h??? V?? y???n (danh ph??p khoa h???c: Apodidae) l?? m???t h??? chim c?? b??? ngo??i r???t gi???ng v???i c??c lo??i ??n (h??? Hirundinidae) nh??ng th???c ra ch??ng kh??ng c?? quan h??? h??? h??ng g???n v???i nh???ng lo??i chim d???ng s??? n??y. C??c lo??i y???n t???o th??nh m???t ph???n c???a b??? Y???n (Apodiformes), c??ng v???i c??c h??? nh?? h??? Chim ru???i (Trochilidae) v?? h??? Y???n m??o (Hemiprocnidae)."));
        list.add(new User(R.drawable.cvanh,R.drawable.cvanh,"V??ng anh","H??? V??ng anh hay h??? Ho??ng oanh ho???c h??? Ho??ng li (danh ph??p khoa h???c: Oriolidae) l?? m???t h??? chim thu???c b??? S??? ??? C???u th??? gi???i. N?? kh??ng c?? h??? h??ng g?? v???i c??c lo??i v??ng anh T??n th??? gi???i c???a h??? Icteridae."));
        list.add(new User(R.drawable.ccugay,R.drawable.ccugay,"Cu g??y","Cu g??y (danh ph??p khoa h???c: Streptopelia chinensis) l?? m???t lo??i chim trong h??? Columbidae.[2]. Ch??ng l?? lo??i chim b??? c??u kh?? quen thu???c v???i n??ng th??n Vi???t Nam."));
        list.add(new User(R.drawable.csonca,R.drawable.csonca,"S??n ca ","S??n ca hay S??n ca ph????ng ????ng (danh ph??p hai ph???n: Alauda gulgula) l?? m???t lo??i chim thu???c H??? S??n ca. Lo??i n??y sinh s???ng ??? Nam ?? v?? ????ng Nam ??. Gi???ng nh?? c??c lo??i s??n ca kh??c, n?? ???????c t??m th???y trong khu v???c ?????ng c??? th??a - th?????ng g???n c??c thu??? v???c - n??i n?? ??n h???t v?? c??n tr??ng."));
       return list;
    }
    private List<User> getListuser2() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.bthanmem,R.drawable.bthanmem,"?????ng v???t th??n m???m","?????ng v???t th??n m???m th?????ng s??? d???ng c??c d???i r??ng kitin (m???t d???i c?? nh??? c?? r??ng ch??? c?? ??? ?????ng v???t th??n m???m) ????? c???o v?? c???t c??c lo???i th???c v???t, ?????ng v???t nh??? tr?????c khi ????a v??o th???c qu???n."));
        list.add(new User(R.drawable.bthanxac,R.drawable.bthanxac,"?????ng v???t gi??p x??c","?????ng v???t gi??p x??c l?? m???t nh??m ?????ng v???t th???y sinh c?? v??? c???ng. Nh??m ?????ng v???t n??y g???m t??m (t??m h??m, t??m c??ng, t??m m?? ni???), cua, gh?????? M???t s??? lo??i gi??p x??c c??n ???????c m???nh danh l?? ???nh???ng ng?????i d???n r??c??? cho ?????i d????ng b???i ch??ng th?????ng ??n nh???ng sinh v???t ch???t."));
        list.add(new User(R.drawable.bcavoi,R.drawable.bcavoi,"C?? voi","C?? voi l?? ?????ng v???t d?????i n?????c l???n nh???t, c??ng l?? ?????ng v???t l???n nh???t tr??n tr??i ?????t. Ch??ng l?? ?????ng v???t c?? v?? v?? c?? th??? s???n xu???t s???a t??? tuy???n v?? c???a m??nh. Th???c ??n c???a c?? voi l?? c??c lo??i sinh v???t ph?? du, c??, ?????ng v???t th??n m???m, cua???"));
        list.add(new User(R.drawable.bcaheo,R.drawable.bcaheo,"C?? heo ","C?? heo l?? ?????ng v???t c?? v?? s???ng ??? ?????i d????ng v?? c?? quan h??? m???t thi???t v???i c?? voi. C?? heo l?? lo??i ?????ng v???t d?????i n?????c r???t th??ng minh, th?????ng ??n m???c, c?? v?? h???i c???u. C?? heo th?????ng s???ng theo nh??m v?? c?? t??nh ??o??n k???t r???t cao."));
        list.add(new User(R.drawable.bhaithg,R.drawable.bhaithg,"Mo??c","Mo??c l?? m???t trong c??c con v???t s???ng d?????i n?????c c?? v??, da m??u n??u v?? r???t d??? nh???n bi???t b???i 2 chi???c ng?? ?????c tr??ng. Khi tr?????ng th??nh, tr???ng l?????ng c???a ch??ng c?? th??? l??n ?????n 1,7 t???n. Lo??i ?????ng v???t n??y th?????ng s???ng ??? B???c B??ng D????ng v?? c??c v??ng bi???n c???n B???c C???c"));
        list.add(new User(R.drawable.bcamap,R.drawable.bcamap,"C?? m???p","C?? m???p l?? lo??i ?????ng v???t d?????i n?????c ???????c m???nh danh l?? ???th??? s??n??? c???a bi???n c???. Ch??ng c?? h??m r??ng r???t s???c v?? m???t b??? x????ng v???ng ch??i ???????c c???u t???o t??? s???n. Ch??ng th??? d?????i n?????c th??ng qua mang."));
        list.add(new User(R.drawable.bsanho,R.drawable.bsanho,"San h??","San h?? l?? m???t trong c??c con v???t s???ng d?????i n?????c sinh tr?????ng trong m??i tr?????ng bi???n, ????i khi b??? nh???m l???n l?? th???c v???t. San h?? t???n t???i d?????i c??c th??? polyp nh??? gi???ng h???i qu???. Lo??i ?????ng v???t d?????i bi???n n??y th?????ng s???ng th??nh qu???n th??? bao g???m c??c c?? th??? gi???ng h???t nhau."));
        list.add(new User(R.drawable.bcasau,R.drawable.bcasau,"C?? s???u ","C?? s???u l?? lo??i b?? s??t c?? ngu???n g???c t??? M??? v?? Trung Qu???c. ????y l?? con v???t s???ng d?????i n?????c ng???t, s???ng trong h???, ?????m l???y, ao v?? s??ng. Ch??ng c?? mi???ng r???ng v???i l???p da c???ng nh?? b???c th??p."));
        list.add(new User(R.drawable.brua,R.drawable.brua,"R??a","R??a l?? ?????ng v???t b?? s??t c?? m???t l???p mai th???t c???ng v?? to ????? b???o v??? c?? th???. C?? 2 lo???i r??a ch??nh l?? r??a n?????c ng???t s???ng trong h???, ao v?? r??a bi???n s???ng trong ?????i d????ng, ????? tr???ng tr??n b??i c??t. R??a l?? lo??i ??n t???p, th???c ??n ch??? y???u l?? th???c v???t, c??, c??n tr??ng, ?????ng v???t th??n m???m, ???ch, c??? v?? t???o."));
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
        for (int i = 0; i < listData2.size(); ++i) {
            if (listData2.get(i).equals(user)) {
                listData2.get(i).setLiked(user.getLiked());
                return;
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
                 if(key==1){

               if (userAdapter != null) {

                userAdapter.notifyDataSetChanged();
                GridLayoutManager linearLayoutManager = new GridLayoutManager(mainActivity, 3);
                rcv.setLayoutManager(linearLayoutManager);
                userAdapter = new UserAdapter(listData1, new UserAdapter.Iclicklistener() {
                    @Override
                    public void Onclicklistener(User user, int position) {
                        gotoDetailFragment(listData1, position);
                    }
                });

                rcv.setAdapter(userAdapter);
                 }
                 }
                 else if (key==2) {
                     if (userAdapter != null) {

                         userAdapter.notifyDataSetChanged();
                         GridLayoutManager linearLayoutManager = new GridLayoutManager(mainActivity, 3);
                         rcv.setLayoutManager(linearLayoutManager);
                         userAdapter = new UserAdapter(listData, new UserAdapter.Iclicklistener() {
                             @Override
                             public void Onclicklistener(User user, int position) {
                                 gotoDetailFragment(listData, position);
                             }
                         });

                         rcv.setAdapter(userAdapter);
                     }
                 }
                 else if (key==3) {
                     if (userAdapter != null) {

                         userAdapter.notifyDataSetChanged();
                         GridLayoutManager linearLayoutManager = new GridLayoutManager(mainActivity, 3);
                         rcv.setLayoutManager(linearLayoutManager);
                         userAdapter = new UserAdapter(listData2, new UserAdapter.Iclicklistener() {
                             @Override
                             public void Onclicklistener(User user, int position) {
                                 gotoDetailFragment(listData2, position);
                             }
                         });

                         rcv.setAdapter(userAdapter);
                     }
                 }
    }

    void gotoDetailFragment(List<User> listData, int position) {
        DetailFragment detailFragment = DetailFragment.newInstance(listData, position);
         detailFragment.setData((ArrayList<User>) listData);

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