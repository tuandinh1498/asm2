package com.example.asm2_animal_demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {




    private RecyclerView rcv;
    private View mView;
    private MainActivity mainActivity;
    private List<User> listData = new ArrayList<>();
    private UserAdapter userAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_home,container,false);
        mainActivity= (MainActivity) getActivity();
        listData = getListUser();
        //data tu detail ve lay o day ma k duoc
        
        Bundle bundlerc=getArguments();
         User user= (User) bundlerc.get("object_detail");
        updateData(user);


        rcv=mView.findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mainActivity);
        rcv.setLayoutManager(linearLayoutManager);
        UserAdapter userAdapter=new UserAdapter(getListUser(), new UserAdapter.Iclicklistener() {
            @Override
            public void Onclicklistener(User user) {

            mainActivity.gotoDetailFragment(user);
            }
        });

        rcv.setAdapter(userAdapter);

       return mView;
    }

    private List<User> getListUser() {
        List<User> list=new ArrayList<>();
        list.add(new User(R.drawable.cho,R.drawable.cho,"Chó","Chó cũng là loài động vật đầu tiên được con người thuần hóa và đã được chọn giống qua hàng thiên niên kỷ với nhiều hành vi, khả năng cảm nhận và đặc tính vật lý.[6] Loài vật này được sử dụng để giữ nhà hoặc làm thú chơi. Răng của chúng dùng để giết mồi, nhai thịt và gặm thịt, thỉnh thoảng để cắn nhau. Chó là loài động vật được nuôi nhiều trên thế giới, có thể trông coi nhà, chăn cừu, dẫn đường, kéo xe, cũng là thực phẩm giàu đạm."));
        list.add(new User(R.drawable.chuot,R.drawable.chuot,"Chuột","Họ Chuột (Muridae) là họ động vật ăn tạp và là động vật gặm nhấm lớp thú lớn nhất hành tinh,hơn 1383 loài đã được phát hiện trên toàn cầu bao gồm nhiều nhất loài chuột nhắt,chuột cống,chuột nhảy gerbil,...được tìm thấy trên khắp lục địa Á-Âu, Châu Phi,Úc,Nhật Bản,..."));
        list.add(new User(R.drawable.cho,R.drawable.cho,"Cóc ","Cóc trong tiếng Việt khi đề cập tới một nhóm động vật thuộc bộ Ếch nhái hay bộ Không đuôi (Anura) thì nói chung là các động vật có lớp da sần sùi, khi trưởng thành chủ yếu sống trên cạn. Tuy nhiên, nó không là sự phân loại khoa học chính xác do cóc có thể là tên gọi chung cho các loài trong các họ khác nhau"));
        list.add(new User(R.drawable.ga,R.drawable.ga,"Gà ","Gà hay gà nhà, gà Đồi (danh pháp hai phần: Gallus gallus, Gallus gallus domesticus) là một loài chim đã được con người thuần hoá cách đây hàng nghìn năm. Một số ý kiến cho rằng loài này có thuỷ tổ từ loài chim hoang dã ở Ấn Độ và loài gà rừng lông đỏ nhiệt đới ở vùng Đông Nam Á."));
        list.add(new User(R.drawable.voi,R.drawable.voi,"Koala","Koala, hay gấu túi (danh pháp khoa học: Phascolarctos cinereus) là một loài thú có túi ăn thực vật sống tại Úc và là loài vật duy nhất hiện còn sống trong họ Phascolarctidae, và họ hàng gần gũi nhất còn sinh tồn của nó là wombat.[1] Koala được tìm thấy ở vùng dọc theo bờ biển phía đông và nam đảo chính, chính xác là ở Queensland, New South Wales, Victoria và Nam Úc."));
        list.add(new User(R.drawable.lon,R.drawable.lon,"Lợn","Lợn nhà hay heo nhà là một giống loài được thuần hóa từ loài lợn rừng, được chăn nuôi để cung cấp thịt. Hầu hết lợn nhà có lớp lông mỏng trên bề mặt da. Lợn nhà thường được cho rằng là một phân loài từ tổ tiên hoang dã của chúng là lợn rừng, trong trường hợp này chúng được đặt tên sinh học là Sus scrofa domesticus."));
        list.add(new User(R.drawable.meo,R.drawable.meo,"Mèo","Mèo, chính xác hơn là loài mèo nhà để phân biệt với các loài trong họ Mèo khác, là động vật có vú, nhỏ nhắn và chuyên ăn thịt, sống chung với loài người, được nuôi để săn vật gây hại hoặc làm thú nuôi cùng với chó nhà. Mèo nhà đã sống gần gũi với loài người ít nhất 9.500 năm,[4] và hiện nay chúng là con vật cưng phổ biến nhất trên thế giới."));
        list.add(new User(R.drawable.meo,R.drawable.meo,"Rắn","Rắn là tên gọi chung để chỉ một nhóm các loài động vật bò sát ăn thịt, từng có chân và thân hình tròn dài (hình trụ), thuộc phân bộ Serpentes, có thể phân biệt với các loài thằn lằn không chân bằng các đặc trưng như không có mí mắt và tai ngoài. Giống như các loài bò sát có vảy (Squamata) khác, rắn là động vật có xương sống, có màng ối, ngoại nhiệt với các lớp vảy xếp chồng lên nhau che phủ cơ thể."));

        return list;
    }
    private void updateData(User user){
        for(int i = 0; i < listData.size(); ++i) {
            if (listData.get(i).equals(user)){
                listData.get(i).setLiked(user.getLiked());
                userAdapter.notifyDataSetChanged();
                return;
            }
        }
    }
}