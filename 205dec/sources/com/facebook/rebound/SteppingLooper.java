package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SteppingLooper extends SpringLooper {

    /* renamed from: b  reason: collision with root package name */
    private boolean f37082b;

    /* renamed from: c  reason: collision with root package name */
    private long f37083c;

    @Override // com.facebook.rebound.SpringLooper
    public void b() {
        this.f37082b = true;
        this.f37083c = 0L;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void c() {
        this.f37082b = false;
    }

    public boolean d(long j4) {
        BaseSpringSystem baseSpringSystem = this.f37081a;
        if (baseSpringSystem == null || !this.f37082b) {
            return false;
        }
        long j5 = this.f37083c + j4;
        baseSpringSystem.i(j5);
        this.f37083c = j5;
        return this.f37081a.g();
    }
}
