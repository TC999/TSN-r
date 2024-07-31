package com.facebook.rebound;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SynchronousLooper extends SpringLooper {

    /* renamed from: d */
    public static double f23488d = 16.6667d;

    /* renamed from: b */
    private double f23489b = f23488d;

    /* renamed from: c */
    private boolean f23490c;

    @Override // com.facebook.rebound.SpringLooper
    /* renamed from: b */
    public void mo35549b() {
        this.f23490c = true;
        while (!this.f23485a.m35635g() && this.f23490c) {
            this.f23485a.m35633i(this.f23489b);
        }
    }

    @Override // com.facebook.rebound.SpringLooper
    /* renamed from: c */
    public void mo35548c() {
        this.f23490c = false;
    }

    /* renamed from: d */
    public double m35547d() {
        return this.f23489b;
    }

    /* renamed from: e */
    public void m35546e(double d) {
        this.f23489b = d;
    }
}
