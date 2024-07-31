package com.facebook.rebound;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SteppingLooper extends SpringLooper {

    /* renamed from: b */
    private boolean f23486b;

    /* renamed from: c */
    private long f23487c;

    @Override // com.facebook.rebound.SpringLooper
    /* renamed from: b */
    public void mo35549b() {
        this.f23486b = true;
        this.f23487c = 0L;
    }

    @Override // com.facebook.rebound.SpringLooper
    /* renamed from: c */
    public void mo35548c() {
        this.f23486b = false;
    }

    /* renamed from: d */
    public boolean m35550d(long j) {
        BaseSpringSystem baseSpringSystem = this.f23485a;
        if (baseSpringSystem == null || !this.f23486b) {
            return false;
        }
        long j2 = this.f23487c + j;
        baseSpringSystem.m35633i(j2);
        this.f23487c = j2;
        return this.f23485a.m35635g();
    }
}
