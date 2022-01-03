package com.example.asm2_animal_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MyBrocastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager telephonyManager=(TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
         MyPhoneStateListener myPhoneStateListener= new MyPhoneStateListener(context);
         telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
