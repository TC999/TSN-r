package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Toast f46412a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile TextView f46413b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46414c;

        a(String str) {
            this.f46414c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e2.b(this.f46414c);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46415c;

        b(String str) {
            this.f46415c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e2.a(this.f46415c);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        a(com.qq.e.comm.plugin.d0.a.d().a(), str);
        f46412a.setDuration(1);
        f46412a.show();
    }

    public static void b(String str) {
        a(com.qq.e.comm.plugin.d0.a.d().a(), str);
        f46412a.setDuration(0);
        f46412a.show();
    }

    public static void c(String str) {
        p0.d(new b(str));
    }

    public static void d(String str) {
        p0.d(new a(str));
    }

    private static void a(Context context, String str) {
        if (f46412a == null) {
            synchronized (e2.class) {
                if (f46412a == null) {
                    a(context);
                }
            }
        }
        f46413b.setText(str);
    }

    private static void a(Context context) {
        f46413b = new TextView(context);
        f46413b.setPadding(f1.a(context, 20), f1.a(context, 12), f1.a(context, 20), f1.a(context, 12));
        f46413b.setTextColor(-1);
        f46413b.setTextSize(2, 16.0f);
        f46413b.setBackgroundDrawable(n1.a(60.0f, -16777216, 100));
        f46412a = new Toast(context);
        f46412a.setGravity(17, 0, 0);
        f46412a.setView(f46413b);
    }
}
