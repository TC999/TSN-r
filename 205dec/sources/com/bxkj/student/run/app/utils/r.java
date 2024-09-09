package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ScreenUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class r {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ScreenUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f22939a;

        /* renamed from: b  reason: collision with root package name */
        public int f22940b;

        public a() {
        }

        public a(int widthPixels, int heightPixels) {
            this.f22939a = widthPixels;
            this.f22940b = heightPixels;
        }
    }

    public static int a(Context context, float dpValue) {
        return (int) ((dpValue * b(context)) + 0.5f);
    }

    public static float b(Context context) {
        new DisplayMetrics();
        return context.getResources().getDisplayMetrics().density;
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static a d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new a(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int f() {
        return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int g(Context context, float pxValue) {
        return (int) ((pxValue / b(context)) + 0.5f);
    }

    public static void h(ListView listView) {
        ListAdapter adapter;
        if (listView == null || (adapter = listView.getAdapter()) == null) {
            return;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < adapter.getCount(); i5++) {
            View view = adapter.getView(i5, null, listView);
            view.measure(0, 0);
            i4 += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = i4 + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
    }
}
