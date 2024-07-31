package com.mbridge.msdk.mbbid.out;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BannerBidRequestParams extends CommonBidRequestParams {

    /* renamed from: a */
    private int f31238a;

    /* renamed from: b */
    private int f31239b;

    public BannerBidRequestParams(String str, String str2, int i, int i2) {
        super(str, str2);
        this.f31238a = i2;
        this.f31239b = i;
    }

    public int getHeight() {
        return this.f31238a;
    }

    public int getWidth() {
        return this.f31239b;
    }

    public void setHeight(int i) {
        this.f31238a = i;
    }

    public void setWidth(int i) {
        this.f31239b = i;
    }

    public BannerBidRequestParams(String str, String str2, String str3, int i, int i2) {
        super(str, str2, str3);
        this.f31238a = i2;
        this.f31239b = i;
    }
}
