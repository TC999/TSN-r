package com.mbridge.msdk.mbbid.out;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdvancedNativeBidRequestParams extends CommonBidRequestParams {

    /* renamed from: a */
    private int f31236a;

    /* renamed from: b */
    private int f31237b;

    public AdvancedNativeBidRequestParams(String str, String str2, int i, int i2) {
        super(str, str2);
        this.f31236a = i2;
        this.f31237b = i;
    }

    public int getHeight() {
        return this.f31236a;
    }

    public int getWidth() {
        return this.f31237b;
    }

    public void setHeight(int i) {
        this.f31236a = i;
    }

    public void setWidth(int i) {
        this.f31237b = i;
    }

    public AdvancedNativeBidRequestParams(String str, String str2, String str3, int i, int i2) {
        super(str, str2, str3);
        this.f31236a = i2;
        this.f31237b = i;
    }
}
