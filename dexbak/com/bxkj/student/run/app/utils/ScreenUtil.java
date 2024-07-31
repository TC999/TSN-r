package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.idl.face.platform.FaceEnvironment;

/* renamed from: com.bxkj.student.run.app.utils.r */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ScreenUtil {

    /* compiled from: ScreenUtil.java */
    /* renamed from: com.bxkj.student.run.app.utils.r$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C5405a {

        /* renamed from: a */
        public int f19709a;

        /* renamed from: b */
        public int f19710b;

        public C5405a() {
        }

        public C5405a(int widthPixels, int heightPixels) {
            this.f19709a = widthPixels;
            this.f19710b = heightPixels;
        }
    }

    /* renamed from: a */
    public static int m39538a(Context context, float dpValue) {
        return (int) ((dpValue * m39537b(context)) + 0.5f);
    }

    /* renamed from: b */
    public static float m39537b(Context context) {
        new DisplayMetrics();
        return context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: c */
    public static int m39536c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* renamed from: d */
    public static C5405a m39535d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new C5405a(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* renamed from: e */
    public static int m39534e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: f */
    public static int m39533f() {
        return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS));
    }

    /* renamed from: g */
    public static int m39532g(Context context, float pxValue) {
        return (int) ((pxValue / m39537b(context)) + 0.5f);
    }

    /* renamed from: h */
    public static void m39531h(ListView listView) {
        ListAdapter adapter;
        if (listView == null || (adapter = listView.getAdapter()) == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(0, 0);
            i += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = i + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
    }
}
