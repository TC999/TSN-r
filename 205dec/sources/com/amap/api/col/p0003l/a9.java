package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TWifi.java */
/* renamed from: com.amap.api.col.3l.a9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a9 extends w9 {
    private static int a(v9 v9Var) {
        return v9Var.n();
    }

    public static int b(v9 v9Var, int i4) {
        v9Var.q(1);
        d(v9Var, i4);
        return a(v9Var);
    }

    public static int c(v9 v9Var, int[] iArr) {
        v9Var.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            v9Var.e(iArr[length]);
        }
        return v9Var.a();
    }

    private static void d(v9 v9Var, int i4) {
        v9Var.r(0, i4);
    }
}
