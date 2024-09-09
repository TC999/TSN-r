package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TData.java */
/* renamed from: com.amap.api.col.3l.s8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s8 extends w9 {

    /* compiled from: AMapCustomStyleManager.java */
    /* renamed from: com.amap.api.col.3l.s8$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a();
    }

    private static int a(v9 v9Var) {
        return v9Var.n();
    }

    public static int b(v9 v9Var, byte b4, int i4) {
        v9Var.q(2);
        e(v9Var, i4);
        d(v9Var, b4);
        return a(v9Var);
    }

    public static int c(v9 v9Var, byte[] bArr) {
        v9Var.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            v9Var.d(bArr[length]);
        }
        return v9Var.a();
    }

    private static void d(v9 v9Var, byte b4) {
        v9Var.f(0, b4);
    }

    private static void e(v9 v9Var, int i4) {
        v9Var.r(1, i4);
    }
}
