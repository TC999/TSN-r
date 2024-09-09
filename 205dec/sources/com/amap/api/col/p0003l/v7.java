package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TimeUpdateStrategy.java */
/* renamed from: com.amap.api.col.3l.v7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v7 extends w7 {

    /* renamed from: b  reason: collision with root package name */
    protected int f9293b;

    /* renamed from: c  reason: collision with root package name */
    protected long f9294c;

    /* renamed from: d  reason: collision with root package name */
    private String f9295d;

    /* renamed from: e  reason: collision with root package name */
    private Context f9296e;

    public v7(Context context, int i4, String str, w7 w7Var) {
        super(w7Var);
        this.f9293b = i4;
        this.f9295d = str;
        this.f9296e = context;
    }

    @Override // com.amap.api.col.p0003l.w7
    public final void c(boolean z3) {
        super.c(z3);
        if (z3) {
            String str = this.f9295d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f9294c = currentTimeMillis;
            r5.d(this.f9296e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.col.p0003l.w7
    protected final boolean d() {
        if (this.f9294c == 0) {
            String a4 = r5.a(this.f9296e, this.f9295d);
            this.f9294c = TextUtils.isEmpty(a4) ? 0L : Long.parseLong(a4);
        }
        return System.currentTimeMillis() - this.f9294c >= ((long) this.f9293b);
    }
}
