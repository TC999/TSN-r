package com.mbridge.msdk.mbbid.common;

/* renamed from: com.mbridge.msdk.mbbid.common.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class BidRequestParams {

    /* renamed from: a */
    private String f31231a;

    /* renamed from: b */
    private String f31232b;

    /* renamed from: c */
    private String f31233c;

    public BidRequestParams(String str, String str2) {
        this.f31231a = str;
        this.f31232b = str2;
    }

    public String getmFloorPrice() {
        return this.f31233c;
    }

    public String getmPlacementId() {
        return this.f31231a;
    }

    public String getmUnitId() {
        return this.f31232b;
    }

    public void setmFloorPrice(String str) {
        this.f31233c = str;
    }

    public void setmPlacementId(String str) {
        this.f31231a = str;
    }

    public void setmUnitId(String str) {
        this.f31232b = str;
    }

    public BidRequestParams(String str, String str2, String str3) {
        this.f31231a = str;
        this.f31232b = str2;
        this.f31233c = str3;
    }
}
