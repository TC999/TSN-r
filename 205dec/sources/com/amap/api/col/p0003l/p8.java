package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TCell.java */
/* renamed from: com.amap.api.col.3l.p8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p8 extends w9 {
    private static int a(v9 v9Var) {
        return v9Var.n();
    }

    public static int b(v9 v9Var, int i4, byte b4, int i5, int i6) {
        v9Var.q(4);
        h(v9Var, i6);
        g(v9Var, i5);
        e(v9Var, i4);
        d(v9Var, b4);
        return a(v9Var);
    }

    public static int c(v9 v9Var, int[] iArr) {
        v9Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            v9Var.e(iArr[length]);
        }
        return v9Var.a();
    }

    private static void d(v9 v9Var, byte b4) {
        v9Var.f(1, b4);
    }

    private static void e(v9 v9Var, int i4) {
        v9Var.r(0, i4);
    }

    public static int f(v9 v9Var, int[] iArr) {
        v9Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            v9Var.e(iArr[length]);
        }
        return v9Var.a();
    }

    private static void g(v9 v9Var, int i4) {
        v9Var.r(2, i4);
    }

    private static void h(v9 v9Var, int i4) {
        v9Var.r(3, i4);
    }
}
