package com.mbridge.msdk.mbbid.common;

/* compiled from: BidRequestParams.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private String f40005a;

    /* renamed from: b  reason: collision with root package name */
    private String f40006b;

    /* renamed from: c  reason: collision with root package name */
    private String f40007c;

    public b(String str, String str2) {
        this.f40005a = str;
        this.f40006b = str2;
    }

    public String getmFloorPrice() {
        return this.f40007c;
    }

    public String getmPlacementId() {
        return this.f40005a;
    }

    public String getmUnitId() {
        return this.f40006b;
    }

    public void setmFloorPrice(String str) {
        this.f40007c = str;
    }

    public void setmPlacementId(String str) {
        this.f40005a = str;
    }

    public void setmUnitId(String str) {
        this.f40006b = str;
    }

    public b(String str, String str2, String str3) {
        this.f40005a = str;
        this.f40006b = str2;
        this.f40007c = str3;
    }
}
