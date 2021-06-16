package com.example.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MessageHelper {


    private static void makeCustomToast(final LayoutInflater inflater, final String message, final Context context, final String bColor, final String textColor, final int icon){
        ((Activity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View toastRoot = inflater.inflate(R.layout.toast, null);
                RelativeLayout container = toastRoot.findViewById(R.id.toast_container);
                TextView txt_message = toastRoot.findViewById(R.id.toast_message);
                ImageView img_toast = toastRoot.findViewById(R.id.toast_image);
                container.setBackgroundColor(Color.parseColor(bColor));
                txt_message.setText(message);
                txt_message.setTextColor(Color.parseColor(textColor));
                img_toast.setBackground(context.getResources().getDrawable(icon));
                Toast toast = new Toast(context);
                toast.setView(toastRoot);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public static void showCustomToastSuccess(Context context, LayoutInflater inflater, String message){

        makeCustomToast(inflater,message,context,"#e0e0e0", "#20ab2a", R.drawable.icon_ok_2);
    }

    public static void showCustomToastError(Context context, LayoutInflater inflater, String message){
        makeCustomToast(inflater,message,context,"#e0e0e0","#d01716", R.drawable.icon_error);

    }


}