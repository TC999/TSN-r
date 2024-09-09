package com.bytedance.msdk.core.ux.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements Comparable<ev> {

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.msdk.c.ux f28224c;
    private boolean sr = false;
    private com.bytedance.msdk.api.c.w ux;

    /* renamed from: w  reason: collision with root package name */
    public com.bytedance.msdk.core.k.xv f28225w;
    private long xv;

    public ev(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.core.k.xv xvVar, long j4, com.bytedance.msdk.api.c.w wVar) {
        this.f28224c = uxVar;
        this.f28225w = xvVar;
        this.xv = j4;
        this.ux = wVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(ev evVar) {
        return this.f28224c.compareTo(evVar.f28224c);
    }

    public boolean w() {
        return this.sr;
    }

    public com.bytedance.msdk.api.c.w xv() {
        return this.ux;
    }

    public long c() {
        return this.xv;
    }

    public void c(boolean z3) {
        this.sr = z3;
    }
}
