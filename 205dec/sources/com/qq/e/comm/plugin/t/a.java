package com.qq.e.comm.plugin.t;

import android.text.TextUtils;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.g0.b0;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f46236c;

    /* renamed from: a  reason: collision with root package name */
    private volatile b0 f46237a;

    /* renamed from: b  reason: collision with root package name */
    private volatile ConcurrentHashMap<Integer, b0> f46238b = new ConcurrentHashMap<>();

    private a() {
    }

    private static <T> void a(b0 b0Var, String str, T t3) {
    }

    public static a b() {
        if (f46236c == null) {
            synchronized (a.class) {
                if (f46236c == null) {
                    f46236c = new a();
                }
            }
        }
        return f46236c;
    }

    public int a(b0 b0Var, String str, int i4) {
        return b(b0Var, str, i4);
    }

    public String a(b0 b0Var, String str, String str2) {
        return b(b0Var, str, str2);
    }

    public int a(String str, int i4) {
        return a(this.f46237a, str, i4);
    }

    public int a(int i4, String str, int i5) {
        return a(this.f46238b.get(Integer.valueOf(i4)), str, i5);
    }

    public void a(b0 b0Var, g gVar) {
        this.f46237a = b0Var;
        if (gVar != null) {
            this.f46238b.put(Integer.valueOf(gVar.c()), b0Var);
        }
    }

    private int b(b0 b0Var, String str, int i4) {
        a(b0Var, str, Integer.valueOf(i4));
        return (b0Var == null || b0Var.f43488b == null || TextUtils.isEmpty(str)) ? i4 : b0Var.f43488b.optInt(str, i4);
    }

    public b0 a() {
        return this.f46237a;
    }

    public b0 a(int i4) {
        return this.f46238b.get(Integer.valueOf(i4));
    }

    private String b(b0 b0Var, String str, String str2) {
        a(b0Var, str, str2);
        return (b0Var == null || b0Var.f43488b == null || TextUtils.isEmpty(str)) ? str2 : b0Var.f43488b.optString(str, str2);
    }
}
