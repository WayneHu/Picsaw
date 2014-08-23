package com.example.picsaw.utils;

import android.os.Build;
import android.os.SystemProperties;

public class DeviceUtils {

    private static final int ANDROID_SDK_VERSION = Build.VERSION.SDK_INT;

    private static final String PRODUCT = Build.PRODUCT.toLowerCase();

    private static final String MODEL = Build.MODEL.toLowerCase();

    // 手机品牌
    private static final String BRAND = Build.BRAND.toLowerCase();

    private static final String MANUFACTURER = Build.MANUFACTURER.toLowerCase();

    private static final String HOST = Build.HOST.toLowerCase();

    private static final String DISPLAY = Build.DISPLAY.toLowerCase();


    /**
     * 判断是否Android 2.2 以上
     * @return
     */
    public static boolean isAboveAndroid22() {
        return ANDROID_SDK_VERSION >= 8;
    }
    /**
     * 判断是否Android 4.0 以上
     * @return
     */
    public static boolean isAboveAndroid40() {
        return ANDROID_SDK_VERSION >= 14;
    }

    /**
     * 判断是否Android 4.4 以上
     * @return
     */
    public static boolean isAboveAndroid44() {
        return ANDROID_SDK_VERSION >= 19;
    }

    public static boolean isMeizuM9() {
        return PRODUCT.contains("meizu_m9") && MODEL.contains("m9");
    }

    public static boolean isMeizuMX() {
        return PRODUCT.contains("meizu_mx");
    }

    public static boolean isMeizuMX2() {
        return PRODUCT.contains("meizu_mx2");
    }

    public static boolean isMeizuMX3() {
        return PRODUCT.contains("meizu_mx3");
    }

    public static boolean isMeizu() {
        return PRODUCT.contains("meizu");
    }

    public static boolean isMiOne() {
        return MODEL.startsWith("mi-one");
    }

    /**
     * 检测小米V5.
     * 方法来源：小米论坛，开发者板块。
     * @return
     */
     public static boolean isMiuiV5() {
         String miuiVersionName = "";
         try {
             miuiVersionName = SystemProperties.get("ro.miui.ui.version.name");
         } catch (Exception e) {
             miuiVersionName = "";
         }
         return "V5".equalsIgnoreCase(miuiVersionName);
     }

}
