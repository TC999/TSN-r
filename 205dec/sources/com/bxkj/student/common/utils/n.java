package com.bxkj.student.common.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.stub.StubApp;

/* compiled from: UiUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static String f19644a = "com.ads.demo.UiUtil";

    public static int a(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(Context context) {
        return f(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int c(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static float d(Context context) {
        float f4 = context.getResources().getDisplayMetrics().density;
        float f5 = context.getResources().getDisplayMetrics().widthPixels;
        if (f4 <= 0.0f) {
            f4 = 1.0f;
        }
        return (f5 / f4) + 0.5f;
    }

    public static int e(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int f(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void g(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
