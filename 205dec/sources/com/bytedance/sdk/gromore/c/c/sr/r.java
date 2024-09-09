package com.bytedance.sdk.gromore.c.c.sr;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.gromore.c.c.w f31198c;

    public r(com.bytedance.sdk.gromore.c.c.w wVar) {
        this.f31198c = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getAbTestId() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.t() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getChannel() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.a() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public Map<String, String> getCustomData() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getCustomSdkName() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.xv() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getEcpm() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.f() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getErrorMsg() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.ev() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getLevelTag() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.ux() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public int getReqBiddingType() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        if (wVar != null) {
            return wVar.r();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getRequestId() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.gd() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getRitType() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.p() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getScenarioId() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.ys() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getSdkName() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.w() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getSegmentId() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.k() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getSlotId() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.sr() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c
    public String getSubChannel() {
        com.bytedance.sdk.gromore.c.c.w wVar = this.f31198c;
        return wVar != null ? wVar.bk() : "";
    }
}
