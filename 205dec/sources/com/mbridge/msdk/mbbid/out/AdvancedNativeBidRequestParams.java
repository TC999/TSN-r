package com.mbridge.msdk.mbbid.out;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AdvancedNativeBidRequestParams extends CommonBidRequestParams {

    /* renamed from: a  reason: collision with root package name */
    private int f40010a;

    /* renamed from: b  reason: collision with root package name */
    private int f40011b;

    public AdvancedNativeBidRequestParams(String str, String str2, int i4, int i5) {
        super(str, str2);
        this.f40010a = i5;
        this.f40011b = i4;
    }

    public int getHeight() {
        return this.f40010a;
    }

    public int getWidth() {
        return this.f40011b;
    }

    public void setHeight(int i4) {
        this.f40010a = i4;
    }

    public void setWidth(int i4) {
        this.f40011b = i4;
    }

    public AdvancedNativeBidRequestParams(String str, String str2, String str3, int i4, int i5) {
        super(str, str2, str3);
        this.f40010a = i5;
        this.f40011b = i4;
    }
}
