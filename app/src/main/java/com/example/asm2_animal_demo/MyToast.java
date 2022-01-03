package com.example.asm2_animal_demo;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MyToast extends Toast {
    private final int img;
    private Context context;
    private ImageView img_toast;

    public MyToast(Context context, int img) {
        super(context);
        this.img = img;
        context=context;
        setDuration(Toast.LENGTH_LONG);
        setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
        View view=View.inflate(context,R.layout.layout_custom_toast,null);
        img_toast=view.findViewById(R.id.img_customtoast);
        img_toast.setImageResource(this.img);
        setView(view);
    }
}
