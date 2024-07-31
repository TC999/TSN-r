package com.bxkj.student.common.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.stub.StubApp;

/* renamed from: com.bxkj.student.common.utils.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class UiUtil {

    /* renamed from: a */
    private static String f16242a = "com.ads.demo.UiUtil";

    /* renamed from: a */
    public static int m42796a(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static float m42795b(Context context) {
        return m42791f(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    /* renamed from: c */
    public static int m42794c(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: d */
    public static float m42793d(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    /* renamed from: e */
    public static int m42792e(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: f */
    public static int m42791f(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: g */
    public static void m42790g(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
