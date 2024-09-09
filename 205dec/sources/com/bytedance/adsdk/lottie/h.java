package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final int f25625a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25626b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25627c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25628d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25629e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f25630f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public h(int i4, int i5, String str, String str2, String str3) {
        this.f25625a = i4;
        this.f25626b = i5;
        this.f25627c = str;
        this.f25628d = str2;
        this.f25629e = str3;
    }

    public int a() {
        return this.f25625a;
    }

    public void b(Bitmap bitmap) {
        this.f25630f = bitmap;
    }

    public String c() {
        return this.f25628d;
    }

    public Bitmap d() {
        return this.f25630f;
    }

    public int e() {
        return this.f25626b;
    }

    public String f() {
        return this.f25627c;
    }
}
