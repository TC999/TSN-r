package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TimeUpdateStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u3 extends v3 {

    /* renamed from: b  reason: collision with root package name */
    protected int f10281b;

    /* renamed from: c  reason: collision with root package name */
    protected long f10282c;

    /* renamed from: d  reason: collision with root package name */
    private String f10283d;

    /* renamed from: e  reason: collision with root package name */
    private Context f10284e;

    public u3(Context context, int i4, String str, v3 v3Var) {
        super(v3Var);
        this.f10281b = i4;
        this.f10283d = str;
        this.f10284e = context;
    }

    @Override // com.amap.api.col.s.v3
    public final void b(boolean z3) {
        super.b(z3);
        if (z3) {
            String str = this.f10283d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f10282c = currentTimeMillis;
            e2.d(this.f10284e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        if (this.f10282c == 0) {
            String a4 = e2.a(this.f10284e, this.f10283d);
            this.f10282c = TextUtils.isEmpty(a4) ? 0L : Long.parseLong(a4);
        }
        return System.currentTimeMillis() - this.f10282c >= ((long) this.f10281b);
    }
}
