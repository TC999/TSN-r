package com.amap.api.col.p047s;

/* compiled from: UpdateStrategy.java */
/* renamed from: com.amap.api.col.s.v3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2189v3 {

    /* renamed from: a */
    AbstractC2189v3 f6618a;

    public AbstractC2189v3() {
    }

    /* renamed from: a */
    public void mo52381a(int i) {
        AbstractC2189v3 abstractC2189v3 = this.f6618a;
        if (abstractC2189v3 != null) {
            abstractC2189v3.mo52381a(i);
        }
    }

    /* renamed from: b */
    public void mo52380b(boolean z) {
        AbstractC2189v3 abstractC2189v3 = this.f6618a;
        if (abstractC2189v3 != null) {
            abstractC2189v3.mo52380b(z);
        }
    }

    /* renamed from: c */
    protected abstract boolean mo52342c();

    /* renamed from: d */
    public int mo52379d() {
        AbstractC2189v3 abstractC2189v3 = this.f6618a;
        return Math.min(Integer.MAX_VALUE, abstractC2189v3 != null ? abstractC2189v3.mo52379d() : Integer.MAX_VALUE);
    }

    /* renamed from: e */
    public final boolean m52378e() {
        AbstractC2189v3 abstractC2189v3 = this.f6618a;
        if (abstractC2189v3 != null ? abstractC2189v3.m52378e() : true) {
            return mo52342c();
        }
        return false;
    }

    public AbstractC2189v3(AbstractC2189v3 abstractC2189v3) {
        this.f6618a = abstractC2189v3;
    }
}
