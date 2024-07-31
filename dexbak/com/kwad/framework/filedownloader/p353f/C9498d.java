package com.kwad.framework.filedownloader.p353f;

import android.util.Log;

/* renamed from: com.kwad.framework.filedownloader.f.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9498d {
    public static boolean ail;

    /* renamed from: a */
    public static void m28537a(Object obj, Throwable th, String str, Object... objArr) {
        m28539a(6, obj, th, str, objArr);
    }

    /* renamed from: b */
    public static void m28536b(Object obj, String str, Object... objArr) {
        m28540a(4, obj, str, objArr);
    }

    /* renamed from: c */
    public static void m28535c(Object obj, String str, Object... objArr) {
        m28540a(3, obj, str, objArr);
    }

    /* renamed from: d */
    public static void m28534d(Object obj, String str, Object... objArr) {
        m28540a(5, obj, str, objArr);
    }

    /* renamed from: e */
    public static void m28533e(Object obj, String str, Object... objArr) {
        m28540a(2, obj, str, objArr);
    }

    /* renamed from: f */
    private static String m28532f(Object obj) {
        StringBuilder sb = new StringBuilder("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }

    /* renamed from: a */
    public static void m28538a(Object obj, String str, Object... objArr) {
        m28540a(6, obj, str, objArr);
    }

    /* renamed from: a */
    private static void m28540a(int i, Object obj, String str, Object... objArr) {
        m28539a(i, obj, null, str, objArr);
    }

    /* renamed from: a */
    private static void m28539a(int i, Object obj, Throwable th, String str, Object... objArr) {
        if ((i >= 5) || ail) {
            Log.println(i, m28532f(obj), C9501f.m28515b(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
