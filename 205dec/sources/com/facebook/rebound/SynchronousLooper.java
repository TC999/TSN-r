package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SynchronousLooper extends SpringLooper {

    /* renamed from: d  reason: collision with root package name */
    public static double f37084d = 16.6667d;

    /* renamed from: b  reason: collision with root package name */
    private double f37085b = f37084d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37086c;

    @Override // com.facebook.rebound.SpringLooper
    public void b() {
        this.f37086c = true;
        while (!this.f37081a.g() && this.f37086c) {
            this.f37081a.i(this.f37085b);
        }
    }

    @Override // com.facebook.rebound.SpringLooper
    public void c() {
        this.f37086c = false;
    }

    public double d() {
        return this.f37085b;
    }

    public void e(double d4) {
        this.f37085b = d4;
    }
}
