package xyz.adscope.ad.control.render.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ShapeUtil {
    private static Drawable createDrawable(String str, int i4, String str2, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        if (i5 > 0 && AdScopeSDK.getContext() != null) {
            gradientDrawable.setCornerRadius(DeviceInfoUtil.dip2px(AdScopeSDK.getContext(), i5));
        }
        if (i4 > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#") && AdScopeSDK.getContext() != null) {
            gradientDrawable.setStroke(DeviceInfoUtil.dip2px(AdScopeSDK.getContext(), i4), Color.parseColor(str2));
        }
        return gradientDrawable;
    }

    public static void setViewBackGround(View view, String str, int i4, String str2, int i5) {
        view.setBackground(createDrawable(str, i4, str2, i5));
    }

    public static void setViewBackGround(View view, String str, int i4, String str2, float[] fArr) {
        view.setBackground(createDrawable(str, i4, str2, fArr));
    }

    private static Drawable createDrawable(String str, int i4, String str2, float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            if (fArr[i5] >= 0.0f) {
                fArr2[i5] = DeviceInfoUtil.dip2px(AdScopeSDK.getContext(), fArr[i5]);
            } else {
                fArr2[i5] = 0.0f;
            }
        }
        gradientDrawable.setCornerRadii(fArr2);
        if (i4 > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(DeviceInfoUtil.dip2px(AdScopeSDK.getContext(), i4), Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
