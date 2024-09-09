package com.bytedance.sdk.component.xv.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class z {

    /* renamed from: c  reason: collision with root package name */
    long f31129c = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    long f31130f;

    /* renamed from: r  reason: collision with root package name */
    long f31131r;
    long sr;
    long ux;

    /* renamed from: w  reason: collision with root package name */
    long f31132w;
    long xv;

    public void c() {
        this.xv = System.currentTimeMillis();
    }

    public long ev() {
        return this.f31130f;
    }

    public long f() {
        return this.sr;
    }

    public long gd() {
        return this.f31131r;
    }

    public void k() {
        this.f31132w = System.currentTimeMillis();
    }

    public long p() {
        return this.f31132w;
    }

    public long r() {
        return this.ux;
    }

    public long sr() {
        return this.f31129c;
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.f31129c + ", asyncCallExecTs=" + this.f31132w + ", requestStartExecTs=" + this.xv + ", requestConnectStartTs=" + this.sr + ", requestConnectFinishTs=" + this.ux + ", reqCallServerStartTs=" + this.f31130f + ", reqCallServerFinishTs=" + this.f31131r + '}';
    }

    public long ux() {
        return this.xv;
    }

    public void w() {
        this.sr = System.currentTimeMillis();
    }

    public void xv() {
        this.ux = System.currentTimeMillis();
    }

    public void c(long j4) {
        this.f31130f = j4;
    }

    public void w(long j4) {
        this.f31131r = j4;
    }
}
