package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy.java */
/* renamed from: com.amap.api.col.s.s3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2142s3 extends AbstractC2189v3 {

    /* renamed from: c */
    private Context f6486c;

    /* renamed from: d */
    private boolean f6487d;

    /* renamed from: e */
    private int f6488e;

    /* renamed from: f */
    private int f6489f;

    /* renamed from: b */
    private String f6485b = "iKey";

    /* renamed from: g */
    private int f6490g = 0;

    public C2142s3(Context context, boolean z, int i, int i2, String str, int i3) {
        m52464f(context, z, i, i2, str, i3);
    }

    /* renamed from: f */
    private void m52464f(Context context, boolean z, int i, int i2, String str, int i3) {
        this.f6486c = context;
        this.f6487d = z;
        this.f6488e = i;
        this.f6489f = i2;
        this.f6485b = str;
        this.f6490g = i3;
    }

    @Override // com.amap.api.col.p047s.AbstractC2189v3
    /* renamed from: a */
    public final void mo52381a(int i) {
        if (C2023c1.m53200D(this.f6486c) == 1) {
            return;
        }
        String m52874c = C2079j1.m52874c(System.currentTimeMillis(), "yyyyMMdd");
        String m53025a = C2051e2.m53025a(this.f6486c, this.f6485b);
        if (!TextUtils.isEmpty(m53025a)) {
            String[] split = m53025a.split("\\|");
            if (split != null && split.length >= 2) {
                if (m52874c.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            } else {
                C2051e2.m53019g(this.f6486c, this.f6485b);
            }
        }
        Context context = this.f6486c;
        String str = this.f6485b;
        C2051e2.m53022d(context, str, m52874c + "|" + i);
    }

    @Override // com.amap.api.col.p047s.AbstractC2189v3
    /* renamed from: c */
    protected final boolean mo52342c() {
        if (C2023c1.m53200D(this.f6486c) == 1) {
            return true;
        }
        if (this.f6487d) {
            String m53025a = C2051e2.m53025a(this.f6486c, this.f6485b);
            if (TextUtils.isEmpty(m53025a)) {
                return true;
            }
            String[] split = m53025a.split("\\|");
            if (split != null && split.length >= 2) {
                return !C2079j1.m52874c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f6489f;
            }
            C2051e2.m53019g(this.f6486c, this.f6485b);
            return true;
        }
        return false;
    }

    @Override // com.amap.api.col.p047s.AbstractC2189v3
    /* renamed from: d */
    public final int mo52379d() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((C2023c1.m53200D(this.f6486c) != 1 && (i = this.f6488e) > 0) || ((i = this.f6490g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        AbstractC2189v3 abstractC2189v3 = this.f6618a;
        return abstractC2189v3 != null ? Math.max(i2, abstractC2189v3.mo52379d()) : i2;
    }
}
