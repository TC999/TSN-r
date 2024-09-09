package com.mbridge.msdk.mbbid.out;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BannerBidRequestParams extends CommonBidRequestParams {

    /* renamed from: a  reason: collision with root package name */
    private int f40012a;

    /* renamed from: b  reason: collision with root package name */
    private int f40013b;

    public BannerBidRequestParams(String str, String str2, int i4, int i5) {
        super(str, str2);
        this.f40012a = i5;
        this.f40013b = i4;
    }

    public int getHeight() {
        return this.f40012a;
    }

    public int getWidth() {
        return this.f40013b;
    }

    public void setHeight(int i4) {
        this.f40012a = i4;
    }

    public void setWidth(int i4) {
        this.f40013b = i4;
    }

    public BannerBidRequestParams(String str, String str2, String str3, int i4, int i5) {
        super(str, str2, str3);
        this.f40012a = i5;
        this.f40013b = i4;
    }
}
