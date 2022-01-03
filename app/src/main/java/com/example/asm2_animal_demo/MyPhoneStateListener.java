package com.example.asm2_animal_demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Toast;

public class MyPhoneStateListener extends PhoneStateListener {
    Context context;
    public  int img;
    public MyPhoneStateListener(Context context) {
        this.context=context;
    }

    @Override
    public void onCallStateChanged(int state, String phoneNumber) {
        super.onCallStateChanged(state, phoneNumber);
        if(state== TelephonyManager.CALL_STATE_RINGING) {
        //Read du lieu tu Sharepreferences

            SharedPreferences preferences= context.getSharedPreferences("FILE_SAVED",Context.MODE_PRIVATE);
            img= preferences.getInt(phoneNumber,0);
            if(img!=0) {
                Toast toast=new Toast(context);
                toast.show();

            }
        }
    }


}
