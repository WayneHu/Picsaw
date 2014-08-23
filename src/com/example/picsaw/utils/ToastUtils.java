package com.example.picsaw.utils;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.picsaw.R;

public class ToastUtils {

    private static Toast mToast = null;
    private static int mDefaultGravity = 0;
    private static int mDefaultXOffset = 0;
    private static int mDefaultYOffset = 0;

    /**
     * 显示Toast
     * @param context
     * @param resId
     * @param duration Toast.LENGTH_LONG / Toast.LENGTH_SHORT
     */
    public void showToast(Context context, int resId, int duration) {
        makeToast(context, resId, duration).show();;
    }

    private static Toast makeToast(Context context, int resId, int duration) {
        Context c = context.getApplicationContext();
        TextView textView = new TextView(c);
//        textView.setBackgroundResource(R.drawable.shield_loading_bg);
        textView.setText(resId);
//        textView.setTextColor(c.getResources().getColor(R.color.white));
        textView.setTextSize(18);

        int padding = (int) c.getResources().getDimension(R.dimen.toast_padding);
        textView.setPadding(padding, padding, padding, padding);

        Toast toast = getToast(c);
        toast.setGravity(mDefaultGravity, mDefaultXOffset, mDefaultYOffset);
        toast.setDuration(duration);
        toast.setView(textView);

        return toast;
    }

    private static Toast getToast(Context context) {
        if (mToast == null) {
            mToast = new Toast(context.getApplicationContext());
            mDefaultGravity = mToast.getGravity();
            mDefaultXOffset = mToast.getXOffset();
            mDefaultYOffset = mToast.getYOffset();
        }
        return mToast;
    }

}
