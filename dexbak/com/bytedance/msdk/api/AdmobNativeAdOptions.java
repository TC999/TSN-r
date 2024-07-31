package com.bytedance.msdk.api;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdmobNativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;

    /* renamed from: a */
    private int f21578a = 1;

    /* renamed from: b */
    private boolean f21579b = true;

    /* renamed from: c */
    private boolean f21580c = true;

    public int getAdChoicesPlacement() {
        return this.f21578a;
    }

    public boolean isRequestMultipleImages() {
        return this.f21580c;
    }

    public boolean isReturnUrlsForImageAssets() {
        return this.f21579b;
    }

    public AdmobNativeAdOptions setAdChoicesPlacement(int i) {
        this.f21578a = i;
        return this;
    }

    public AdmobNativeAdOptions setRequestMultipleImages(boolean z) {
        this.f21580c = z;
        return this;
    }

    public AdmobNativeAdOptions setReturnUrlsForImageAssets(boolean z) {
        this.f21579b = z;
        return this;
    }
}
