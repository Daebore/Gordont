package com.backendstreetboys.gordont.util;

import android.content.Context;
import android.widget.Toast;

public class AppToast {

    public static Toast toast = null;

    public static void showToast(final Context context, CharSequence text, int duration){
        if(toast!=null){
            toast.cancel();
            toast=null;
            showToast(context, text, duration);
        }else{
            toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}
