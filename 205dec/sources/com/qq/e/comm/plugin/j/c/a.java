package com.qq.e.comm.plugin.j.c;

import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class f44494a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f44495b;

    static {
        try {
            f44494a = Class.forName("androidx.recyclerview.widget.RecyclerView");
            Class.forName("androidx.recyclerview.widget.RecyclerView$LayoutParams");
        } catch (ClassNotFoundException unused) {
            f44494a = null;
        }
        try {
            f44495b = Class.forName("android.support.v7.widget.RecyclerView");
        } catch (ClassNotFoundException unused2) {
            f44495b = null;
        }
    }

    public static boolean a() {
        return f44494a != null;
    }

    public static void b() {
        int i4;
        if (f44494a != null) {
            i4 = 1;
        } else {
            i4 = f44495b != null ? 2 : -1;
        }
        v.a(9130035, null, Integer.valueOf(i4));
    }
}
