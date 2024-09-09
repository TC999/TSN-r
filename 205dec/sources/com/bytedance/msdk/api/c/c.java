package com.bytedance.msdk.api.c;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements xv {
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private String f27447f;

    /* renamed from: p  reason: collision with root package name */
    private JSONObject f27448p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f27449r;

    /* renamed from: w  reason: collision with root package name */
    private String f27450w;
    private int xv;
    private int sr = 1;
    private int ux = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f27446c = 0;
    private int gd = 2;

    @Override // com.bytedance.msdk.api.c.xv
    public String c() {
        return this.f27450w;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int ev() {
        return this.ev;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public String f() {
        return this.f27447f;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void gd() {
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getLinkedId = " + c());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getAdloadSeq = " + w());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getPrimeRitReqType = " + xv());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getReqType = " + sr());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getIfTest = " + ux());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getTransparentParams = " + f());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "isAdRequestOptmize = " + r());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getIsRa = " + ev());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getBehaviorRequestType = " + p());
    }

    @Override // com.bytedance.msdk.api.c.xv
    public JSONObject k() {
        return this.f27448p;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int p() {
        return this.gd;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public boolean r() {
        return this.f27449r;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int sr() {
        return this.ux;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int ux() {
        return this.f27446c;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int w() {
        return this.xv;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public int xv() {
        return this.sr;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(String str) {
        this.f27450w = str;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void f(int i4) {
        this.gd = i4;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void sr(int i4) {
        this.f27446c = i4;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void ux(int i4) {
        this.ev = i4;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void w(int i4) {
        this.sr = i4;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void xv(int i4) {
        this.ux = i4;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(int i4) {
        this.xv = i4;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void w(String str) {
        this.f27447f = str;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(boolean z3) {
        this.f27449r = z3;
    }

    @Override // com.bytedance.msdk.api.c.xv
    public void c(JSONObject jSONObject) {
        this.f27448p = jSONObject;
    }
}
