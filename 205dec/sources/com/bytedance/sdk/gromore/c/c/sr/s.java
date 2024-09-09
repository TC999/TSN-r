package com.bytedance.sdk.gromore.c.c.sr;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s extends com.bytedance.sdk.openadsdk.ys.w.w.bk {

    /* renamed from: c  reason: collision with root package name */
    private String f31199c;

    /* renamed from: w  reason: collision with root package name */
    private int f31200w;
    private int xv;

    public s(String str) {
        this.f31199c = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
    public int c() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
    public double sr() {
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
    public boolean ux() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
    public int w() {
        return this.f31200w;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.bk
    public String xv() {
        return !TextUtils.isEmpty(this.f31199c) ? this.f31199c : "";
    }

    public s(String str, int i4, int i5) {
        this.f31199c = str;
        this.f31200w = i4;
        this.xv = i5;
    }
}
