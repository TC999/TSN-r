package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MobileUpdateStrategy.java */
/* renamed from: com.amap.api.col.3l.t7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t7 extends w7 {

    /* renamed from: c  reason: collision with root package name */
    private Context f9077c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9078d;

    /* renamed from: e  reason: collision with root package name */
    private int f9079e;

    /* renamed from: f  reason: collision with root package name */
    private int f9080f;

    /* renamed from: b  reason: collision with root package name */
    private String f9076b = "iKey";

    /* renamed from: g  reason: collision with root package name */
    private int f9081g = 0;

    public t7(Context context, boolean z3, int i4, int i5, String str) {
        f(context, z3, i4, i5, str, 0);
    }

    private void f(Context context, boolean z3, int i4, int i5, String str, int i6) {
        this.f9077c = context;
        this.f9078d = z3;
        this.f9079e = i4;
        this.f9080f = i5;
        this.f9076b = str;
        this.f9081g = i6;
    }

    @Override // com.amap.api.col.p0003l.w7
    public final int a() {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if ((i4.M(this.f9077c) != 1 && (i4 = this.f9079e) > 0) || ((i4 = this.f9081g) > 0 && i4 < Integer.MAX_VALUE)) {
            i5 = i4;
        }
        w7 w7Var = this.f9370a;
        return w7Var != null ? Math.max(i5, w7Var.a()) : i5;
    }

    @Override // com.amap.api.col.p0003l.w7
    public final void b(int i4) {
        if (i4.M(this.f9077c) == 1) {
            return;
        }
        String c4 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
        String a4 = r5.a(this.f9077c, this.f9076b);
        if (!TextUtils.isEmpty(a4)) {
            String[] split = a4.split("\\|");
            if (split != null && split.length >= 2) {
                if (c4.equals(split[0])) {
                    i4 += Integer.parseInt(split[1]);
                }
            } else {
                r5.g(this.f9077c, this.f9076b);
            }
        }
        Context context = this.f9077c;
        String str = this.f9076b;
        r5.d(context, str, c4 + "|" + i4);
    }

    @Override // com.amap.api.col.p0003l.w7
    protected final boolean d() {
        if (i4.M(this.f9077c) == 1) {
            return true;
        }
        if (this.f9078d) {
            String a4 = r5.a(this.f9077c, this.f9076b);
            if (TextUtils.isEmpty(a4)) {
                return true;
            }
            String[] split = a4.split("\\|");
            if (split != null && split.length >= 2) {
                return !q4.c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f9080f;
            }
            r5.g(this.f9077c, this.f9076b);
            return true;
        }
        return false;
    }

    public t7(Context context, boolean z3, int i4, int i5, String str, int i6) {
        f(context, z3, i4, i5, str, i6);
    }
}
