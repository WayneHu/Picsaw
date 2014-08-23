package com.example.picsaw.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class UIUtils {

    /**
     * 将对应资源ID的图片缩放至特定大小的Bitmap
     * @param r
     * @param id
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap loadBitmap(Resources r, int id, int reqWidth, int reqHeight) {
        if (reqWidth <= 0 || reqHeight <= 0) {
            return null;
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeResource(r, id);
        } catch (Throwable e) {
            return null;
        }
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }

        Bitmap target = Bitmap.createBitmap(reqWidth, reqHeight, Config.ARGB_8888);

        Canvas canvas = new Canvas();

        Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect dst = new Rect(0, 0, reqWidth, reqHeight);
        Paint paint = new Paint();

        canvas.setBitmap(target);
        canvas.drawBitmap(bitmap, src, dst, paint);

        bitmap.recycle();

        return target;
    }

    /**
     * 根据手机的分辨率从 dip 转成为 px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px 转成为 dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
