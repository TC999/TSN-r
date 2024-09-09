package com.bytedance.adsdk.lottie.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private float f25609a;

    /* renamed from: b  reason: collision with root package name */
    private int f25610b;

    public void a(float f4) {
        float f5 = this.f25609a + f4;
        this.f25609a = f5;
        int i4 = this.f25610b + 1;
        this.f25610b = i4;
        if (i4 == Integer.MAX_VALUE) {
            this.f25609a = f5 / 2.0f;
            this.f25610b = i4 / 2;
        }
    }
}
