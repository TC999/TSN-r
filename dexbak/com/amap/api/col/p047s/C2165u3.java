package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy.java */
/* renamed from: com.amap.api.col.s.u3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2165u3 extends AbstractC2189v3 {

    /* renamed from: b */
    protected int f6553b;

    /* renamed from: c */
    protected long f6554c;

    /* renamed from: d */
    private String f6555d;

    /* renamed from: e */
    private Context f6556e;

    public C2165u3(Context context, int i, String str, AbstractC2189v3 abstractC2189v3) {
        super(abstractC2189v3);
        this.f6553b = i;
        this.f6555d = str;
        this.f6556e = context;
    }

    @Override // com.amap.api.col.p047s.AbstractC2189v3
    /* renamed from: b */
    public final void mo52380b(boolean z) {
        super.mo52380b(z);
        if (z) {
            String str = this.f6555d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f6554c = currentTimeMillis;
            C2051e2.m53022d(this.f6556e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.col.p047s.AbstractC2189v3
    /* renamed from: c */
    protected final boolean mo52342c() {
        if (this.f6554c == 0) {
            String m53025a = C2051e2.m53025a(this.f6556e, this.f6555d);
            this.f6554c = TextUtils.isEmpty(m53025a) ? 0L : Long.parseLong(m53025a);
        }
        return System.currentTimeMillis() - this.f6554c >= ((long) this.f6553b);
    }
}
