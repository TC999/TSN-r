package com.hw.videoprocessor.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoProgressAve.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private k f37665a;

    /* renamed from: b  reason: collision with root package name */
    private float f37666b;

    /* renamed from: c  reason: collision with root package name */
    private float f37667c;

    /* renamed from: d  reason: collision with root package name */
    private int f37668d;

    /* renamed from: e  reason: collision with root package name */
    private int f37669e;

    /* renamed from: f  reason: collision with root package name */
    private Float f37670f;

    public j(k kVar) {
        this.f37665a = kVar;
    }

    public void a(float f4) {
        this.f37667c = f4;
        k kVar = this.f37665a;
        if (kVar != null) {
            kVar.a((this.f37666b + f4) / 2.0f);
        }
        c.k("mAudioProgress:" + this.f37667c, new Object[0]);
    }

    public void b(long j4) {
        int i4;
        if (this.f37665a == null) {
            return;
        }
        Float f4 = this.f37670f;
        if (f4 != null) {
            j4 = ((float) j4) * f4.floatValue();
        }
        float f5 = ((((float) j4) / 1000.0f) - this.f37668d) / (this.f37669e - i4);
        this.f37666b = f5;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        this.f37666b = f5;
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.f37666b = f5;
        this.f37665a.a((f5 + this.f37667c) / 2.0f);
        c.k("mEncodeProgress:" + this.f37666b, new Object[0]);
    }

    public void c(int i4) {
        this.f37669e = i4;
    }

    public void d(Float f4) {
        this.f37670f = f4;
    }

    public void e(int i4) {
        this.f37668d = i4;
    }
}
