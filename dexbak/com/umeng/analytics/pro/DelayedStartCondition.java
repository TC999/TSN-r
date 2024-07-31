package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.ac */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DelayedStartCondition implements ActionCondition {

    /* renamed from: a */
    private long f37605a;

    public DelayedStartCondition(long j) {
        this.f37605a = j;
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: a */
    public boolean mo14750a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: b */
    public boolean mo14749b() {
        return !mo14750a();
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: c */
    public long mo14748c() {
        return this.f37605a;
    }
}
