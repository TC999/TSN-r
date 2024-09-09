package com.hw.videoprocessor.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoMultiStepProgress.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class i implements k {

    /* renamed from: a  reason: collision with root package name */
    private float[] f37661a;

    /* renamed from: b  reason: collision with root package name */
    private int f37662b;

    /* renamed from: c  reason: collision with root package name */
    private k f37663c;

    /* renamed from: d  reason: collision with root package name */
    private float f37664d;

    public i(float[] fArr, k kVar) {
        this.f37661a = fArr;
        this.f37663c = kVar;
    }

    @Override // com.hw.videoprocessor.util.k
    public void a(float f4) {
        k kVar = this.f37663c;
        if (kVar != null) {
            kVar.a((f4 * this.f37661a[this.f37662b]) + this.f37664d);
        }
    }

    public void b(int i4) {
        this.f37662b = i4;
        this.f37664d = 0.0f;
        for (int i5 = 0; i5 < i4; i5++) {
            this.f37664d += this.f37661a[i5];
        }
    }

    public void c(k kVar) {
        this.f37663c = kVar;
    }
}
