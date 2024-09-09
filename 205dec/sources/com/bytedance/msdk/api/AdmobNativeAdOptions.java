package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdmobNativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f27309a = 1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27310b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27311c = true;

    public int getAdChoicesPlacement() {
        return this.f27309a;
    }

    public boolean isRequestMultipleImages() {
        return this.f27311c;
    }

    public boolean isReturnUrlsForImageAssets() {
        return this.f27310b;
    }

    public AdmobNativeAdOptions setAdChoicesPlacement(int i4) {
        this.f27309a = i4;
        return this;
    }

    public AdmobNativeAdOptions setRequestMultipleImages(boolean z3) {
        this.f27311c = z3;
        return this;
    }

    public AdmobNativeAdOptions setReturnUrlsForImageAssets(boolean z3) {
        this.f27310b = z3;
        return this;
    }
}
