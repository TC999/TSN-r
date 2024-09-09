package com.bytedance.sdk.openadsdk.core.u;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.sdk.openadsdk.ys.w.w.xv {

    /* renamed from: c  reason: collision with root package name */
    private ux f34584c;

    public a(me meVar) {
        if (meVar == null) {
            return;
        }
        this.f34584c = meVar.zg();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public String c() {
        ux uxVar = this.f34584c;
        return uxVar == null ? "" : uxVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public String f() {
        ux uxVar = this.f34584c;
        if (uxVar == null) {
            return null;
        }
        return uxVar.w();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public String r() {
        ux uxVar = this.f34584c;
        if (uxVar == null) {
            return null;
        }
        return uxVar.gd();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public String sr() {
        ux uxVar = this.f34584c;
        return uxVar == null ? "" : uxVar.ev();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public Map<String, String> ux() {
        ux uxVar = this.f34584c;
        if (uxVar == null) {
            return null;
        }
        return uxVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public String w() {
        ux uxVar = this.f34584c;
        return uxVar == null ? "" : uxVar.ux();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.xv
    public String xv() {
        ux uxVar = this.f34584c;
        return uxVar == null ? "" : uxVar.r();
    }
}
