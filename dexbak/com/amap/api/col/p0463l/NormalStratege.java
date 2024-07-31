package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.f3 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NormalStratege implements LinkLogStrategy {
    @Override // com.amap.api.col.p0463l.LinkLogStrategy
    /* renamed from: a */
    public final void mo54938a(int i, String str, String str2) {
        if (i == 0) {
            AMapLogManager.m55679c(C1732a3.m55691s()).m55674h(AMapLogEntity.m53331b(str, str2));
        } else {
            AMapLogManager.m55679c(C1732a3.m55691s()).m55674h(AMapLogEntity.m53327f(str, str2));
        }
    }

    @Override // com.amap.api.col.p0463l.LinkLogStrategy
    /* renamed from: a */
    public final void mo54939a() {
        try {
            AMapLogManager.m55679c(C1732a3.m55691s()).m55677e();
        } catch (Throwable unused) {
        }
    }
}
