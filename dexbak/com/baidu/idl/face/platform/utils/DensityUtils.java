package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DensityUtils {
    private static final String[] BUILD_MODELS = {"i700v", "A862W", "V8526"};
    private static final float DOT_FIVE = 0.5f;
    private static final int PORTRAIT_DEGREE_270 = 270;
    private static final int PORTRAIT_DEGREE_90 = 90;

    private DensityUtils() {
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * getDensity(context)) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getDisplayHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getPortraitDegree() {
        for (String str : BUILD_MODELS) {
            if (TextUtils.equals(str, Build.MODEL)) {
                return 270;
            }
        }
        return 90;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / getDensity(context)) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static boolean supportCameraPortrait() {
        return APIUtils.hasFroyo() && !TextUtils.equals("GT-S5830i", Build.PRODUCT);
    }
}
