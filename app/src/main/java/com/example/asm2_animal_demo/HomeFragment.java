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
        list.add(new User(R.drawable.cho, R.drawable.cho, "Mam_Chó", "Chó cũng là loài động vật đầu tiên được con người thuần hóa và đã được chọn giống qua hàng thiên niên kỷ với nhiều hành vi, khả năng cảm nhận và đặc tính vật lý.[6] Loài vật này được sử dụng để giữ nhà hoặc làm thú chơi. Răng của chúng dùng để giết mồi, nhai thịt và gặm thịt, thỉnh thoảng để cắn nhau. Chó là loài động vật được nuôi nhiều trên thế giới, có thể trông coi nhà, chăn cừu, dẫn đường, kéo xe, cũng là thực phẩm giàu đạm."));
        list.add(new User(R.drawable.chuot, R.drawable.chuot, "Mam_Chuột", "Họ Chuột (Muridae) là họ động vật ăn tạp và là động vật gặm nhấm lớp thú lớn nhất hành tinh,hơn 1383 loài đã được phát hiện trên toàn cầu bao gồm nhiều nhất loài chuột nhắt,chuột cống,chuột nhảy gerbil,...được tìm thấy trên khắp lục địa Á-Âu, Châu Phi,Úc,Nhật Bản,..."));
        list.add(new User(R.drawable.cho, R.drawable.cho, "Mam_Cóc ", "Cóc trong tiếng Việt khi đề cập tới một nhóm động vật thuộc bộ Ếch nhái hay bộ Không đuôi (Anura) thì nói chung là các động vật có lớp da sần sùi, khi trưởng thành chủ yếu sống trên cạn. Tuy nhiên, nó không là sự phân loại khoa học chính xác do cóc có thể là tên gọi chung cho các loài trong các họ khác nhau"));
        list.add(new User(R.drawable.ga, R.drawable.ga, "Mam_Gà ", "Gà hay gà nhà, gà Đồi (danh pháp hai phần: Gallus gallus, Gallus gallus domesticus) là một loài chim đã được con người thuần hoá cách đây hàng nghìn năm. Một số ý kiến cho rằng loài này có thuỷ tổ từ loài chim hoang dã ở Ấn Độ và loài gà rừng lông đỏ nhiệt đới ở vùng Đông Nam Á."));
        list.add(new User(R.drawable.voi, R.drawable.voi, "Mam_Koala", "Koala, hay gấu túi (danh pháp khoa học: Phascolarctos cinereus) là một loài thú có túi ăn thực vật sống tại Úc và là loài vật duy nhất hiện còn sống trong họ Phascolarctidae, và họ hàng gần gũi nhất còn sinh tồn của nó là wombat.[1] Koala được tìm thấy ở vùng dọc theo bờ biển phía đông và nam đảo chính, chính xác là ở Queensland, New South Wales, Victoria và Nam Úc."));
        list.add(new User(R.drawable.lon, R.drawable.lon, "Mam_Lợn", "Lợn nhà hay heo nhà là một giống loài được thuần hóa từ loài lợn rừng, được chăn nuôi để cung cấp thịt. Hầu hết lợn nhà có lớp lông mỏng trên bề mặt da. Lợn nhà thường được cho rằng là một phân loài từ tổ tiên hoang dã của chúng là lợn rừng, trong trường hợp này chúng được đặt tên sinh học là Sus scrofa domesticus."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Mam_Mèo", "Mèo, chính xác hơn là loài mèo nhà để phân biệt với các loài trong họ Mèo khác, là động vật có vú, nhỏ nhắn và chuyên ăn thịt, sống chung với loài người, được nuôi để săn vật gây hại hoặc làm thú nuôi cùng với chó nhà. Mèo nhà đã sống gần gũi với loài người ít nhất 9.500 năm,[4] và hiện nay chúng là con vật cưng phổ biến nhất trên thế giới."));
        list.add(new User(R.drawable.meo, R.drawable.meo, "Mam_Rắn", "Rắn là tên gọi chung để "));
        return list;
    }
    private List<User> getListuser1() {
        List<User> list=new ArrayList<>();
      list.add(new User(R.drawable.csao,R.drawable.csao,"Chim ","Chim họ Sáo có chân khỏe, đường bay khỏe và thẳng, và chúng thích sống thành bầy. Môi trường sinh sống ưa thích của chúng là vùng nông thôn tương đối thoáng, chúng ăn sâu bọ và quả. Một vài loài sống xung quanh nơi sinh sống của người và chúng là những loài chim thực sự ăn tạp. "));
        list.add(new User(R.drawable.cchaomao,R.drawable.cchaomao,"Chào mào","Chào mào (Pycnonotus jocosus) là một loài chim thuộc bộ Sẻ phân bố ở châu Á. Nó là một thành viên của họ Chào mào. Nó là một loài động vật ăn quả thường trú được tìm thấy chủ yếu ở châu Á nhiệt đới. Nó đã được đưa bởi con người vào nhiều khu vực nhiệt đới trên thế giới, nơi các quần thể đã tự hình thành. Nó ăn trái cây và côn trùng nhỏ. Chúng dễ thấy đậu trên cây và kêu to ba hoặc bốn nốt."));
        list.add(new User(R.drawable.choami,R.drawable.choami,"Hoa mi","Garrulax canorus là một loài chim trong họ Leiothrichidae.[2] Tên gọi họa mi nghĩa là \"được vẽ lên mi mắt\" để chỉ quầng lông sáng màu quanh mắt đặc trưng của loài."));
        list.add(new User(R.drawable.cvet,R.drawable.cvet,"Vẹt","Vẹt còn được gọi là chim két hay chim kơ tia là các loài chim gồm khoảng 393 loài trong 92 chi của Bộ Vẹt Psittaciformes,[2] được tìm thấy chủ yếu ở các vùng nhiệt đới và cận nhiệt đới."));
        list.add(new User(R.drawable.cvkhuyen,R.drawable.cvkhuyen,"Vành khuyên","Họ Vành khuyên hay khoen (danh pháp khoa học: Zosteropidae) là một họ chim chứa khoảng 140 loài thuộc bộ Sẻ (Passeriformes) có nguồn gốc từ vùng nhiệt đới và cận nhiệt đới châu Phi, miền nam châu Á và Australasia. "));
        list.add(new User(R.drawable.cyen,R.drawable.cyen,"Yến","Họ Yến hay họ Vũ yến (danh pháp khoa học: Apodidae) là một họ chim có bề ngoài rất giống với các loài én (họ Hirundinidae) nhưng thực ra chúng không có quan hệ họ hàng gần với những loài chim dạng sẻ này. Các loài yến tạo thành một phần của bộ Yến (Apodiformes), cùng với các họ như họ Chim ruồi (Trochilidae) và họ Yến mào (Hemiprocnidae)."));
        list.add(new User(R.drawable.cvanh,R.drawable.cvanh,"Vàng anh","Họ Vàng anh hay họ Hoàng oanh hoặc họ Hoàng li (danh pháp khoa học: Oriolidae) là một họ chim thuộc bộ Sẻ ở Cựu thế giới. Nó không có họ hàng gì với các loài vàng anh Tân thế giới của họ Icteridae."));
        list.add(new User(R.drawable.ccugay,R.drawable.ccugay,"Cu gáy","Cu gáy (danh pháp khoa học: Streptopelia chinensis) là một loài chim trong họ Columbidae.[2]. Chúng là loài chim bồ câu khá quen thuộc với nông thôn Việt Nam."));
        list.add(new User(R.drawable.csonca,R.drawable.csonca,"Sơn ca ","Sơn ca hay Sơn ca phương Đông (danh pháp hai phần: Alauda gulgula) là một loài chim thuộc Họ Sơn ca. Loài này sinh sống ở Nam Á và Đông Nam Á. Giống như các loài sơn ca khác, nó được tìm thấy trong khu vực đồng cỏ thưa - thường gần các thuỷ vực - nơi nó ăn hạt và côn trùng."));
       return list;
    }
    private List<User> getListuser2() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.bthanmem,R.drawable.bthanmem,"Động vật thân mềm","Động vật thân mềm thường sử dụng các dải răng kitin (một dải cơ nhỏ có răng chỉ có ở động vật thân mềm) để cạo và cắt các loại thực vật, động vật nhỏ trước khi đưa vào thực quản."));
        list.add(new User(R.drawable.bthanxac,R.drawable.bthanxac,"Động vật giáp xác","Động vật giáp xác là một nhóm động vật thủy sinh có vỏ cứng. Nhóm động vật này gồm tôm (tôm hùm, tôm càng, tôm mũ ni…), cua, ghẹ… Một số loài giáp xác còn được mệnh danh là “những người dọn rác” cho đại dương bởi chúng thường ăn những sinh vật chết."));
        list.add(new User(R.drawable.bcavoi,R.drawable.bcavoi,"Cá voi","Cá voi là động vật dưới nước lớn nhất, cũng là động vật lớn nhất trên trái đất. Chúng là động vật có vú và có thể sản xuất sữa từ tuyến vú của mình. Thức ăn của cá voi là các loài sinh vật phù du, cá, động vật thân mềm, cua…"));
        list.add(new User(R.drawable.bcaheo,R.drawable.bcaheo,"Cá heo ","Cá heo là động vật có vú sống ở đại dương và có quan hệ mật thiết với cá voi. Cá heo là loài động vật dưới nước rất thông minh, thường ăn mực, cá và hải cẩu. Cá heo thường sống theo nhóm và có tính đoàn kết rất cao."));
        list.add(new User(R.drawable.bhaithg,R.drawable.bhaithg,"Moóc","Moóc là một trong các con vật sống dưới nước có vú, da màu nâu và rất dễ nhận biết bởi 2 chiếc ngà đặc trưng. Khi trưởng thành, trọng lượng của chúng có thể lên đến 1,7 tấn. Loài động vật này thường sống ở Bắc Băng Dương và các vùng biển cận Bắc Cực"));
        list.add(new User(R.drawable.bcamap,R.drawable.bcamap,"Cá mập","Cá mập là loài động vật dưới nước được mệnh danh là “thợ săn” của biển cả. Chúng có hàm răng rất sắc và một bộ xương vững chãi được cấu tạo từ sụn. Chúng thở dưới nước thông qua mang."));
        list.add(new User(R.drawable.bsanho,R.drawable.bsanho,"San hô","San hô là một trong các con vật sống dưới nước sinh trưởng trong môi trường biển, đôi khi bị nhầm lẫn là thực vật. San hô tồn tại dưới các thể polyp nhỏ giống hải quỳ. Loài động vật dưới biển này thường sống thành quần thể bao gồm các cá thể giống hệt nhau."));
        list.add(new User(R.drawable.bcasau,R.drawable.bcasau,"Cá sấu ","Cá sấu là loài bò sát có nguồn gốc từ Mỹ và Trung Quốc. Đây là con vật sống dưới nước ngọt, sống trong hồ, đầm lầy, ao và sông. Chúng có miệng rộng với lớp da cứng như bọc thép."));
        list.add(new User(R.drawable.brua,R.drawable.brua,"Rùa","Rùa là động vật bò sát có một lớp mai thật cứng và to để bảo vệ cơ thể. Có 2 loại rùa chính là rùa nước ngọt sống trong hồ, ao và rùa biển sống trong đại dương, đẻ trứng trên bãi cát. Rùa là loài ăn tạp, thức ăn chủ yếu là thực vật, cá, côn trùng, động vật thân mềm, ếch, cỏ và tảo."));
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