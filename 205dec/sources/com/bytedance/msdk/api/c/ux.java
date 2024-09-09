package com.bytedance.msdk.api.c;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements sr {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f27451c;

    /* renamed from: f  reason: collision with root package name */
    private int f27452f = -1;
    private int sr;
    private ValueSet ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.w f27453w;
    private Map<String, Object> xv;

    public ux(int i4, ValueSet valueSet) {
        if (valueSet != null) {
            this.ux = valueSet;
            this.sr = i4;
            com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = new com.bytedance.sdk.openadsdk.mediation.c.w.c(valueSet);
            this.f27451c = cVar;
            this.f27453w = cVar.c();
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "valueset is null");
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String ba() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        return cVar != null ? cVar.ys() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public float bk() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.p();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String ck() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar;
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        String t3 = wVar != null ? wVar.t() : "";
        return (!TextUtils.isEmpty(t3) || (cVar = this.f27451c) == null) ? t3 : cVar.n();
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int eq() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.ia();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public void ev(int i4) {
        this.sr = i4;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int fp() {
        return this.f27452f;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int fz() {
        return this.sr;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public void gd() {
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getAdType = " + fz());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getAdUnitId = " + u());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getImgAcceptedWidth = " + q());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getImgAcceptedHeight = " + j());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getExpressViewAcceptedWidth = " + bk());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getExpressViewAcceptedHeight = " + t());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "isSupportRenderConrol = " + ys());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getAdCount = " + ls());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "isSupportDeepLink = " + n());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getMediaExtra = " + ba());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getUserID = " + y());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getOrientation = " + eq());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getRewardName = " + ck());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getRewardAmount = " + z());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getScenarioId = " + i());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "isMuted = " + me());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getTestSlotId = " + wv());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "isBidNotify = " + xk());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getCustomData = " + yu());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getTimeOut = " + fp());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "isAllowShowCloseBtn = " + ia());
        com.bytedance.msdk.adapter.sr.xv.w("AdLinkInfo", "getValueSet = " + wx());
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String i() {
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        return wVar != null ? wVar.ev() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean ia() {
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        if (wVar != null) {
            return wVar.gd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int j() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.gd();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int ls() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.t();
        }
        return 1;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean me() {
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        if (wVar != null) {
            return wVar.xv();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean n() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.a();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int q() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.ev();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public void r(int i4) {
        this.f27452f = i4;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public com.bytedance.sdk.openadsdk.mediation.c.w.c s() {
        return this.f27451c;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public float t() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.k();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String u() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        return cVar != null ? cVar.f() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String wv() {
        Map<String, Object> f4;
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        if (wVar == null || (f4 = wVar.f()) == null) {
            return "";
        }
        Object obj = f4.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public ValueSet wx() {
        return this.ux;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean xk() {
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        if (wVar != null) {
            return wVar.r();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public String y() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        return cVar != null ? cVar.fp() : "";
    }

    @Override // com.bytedance.msdk.api.c.sr
    public boolean ys() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar = this.f27451c;
        if (cVar != null) {
            return cVar.bk();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public Map<String, Object> yu() {
        Map<String, Object> map = this.xv;
        if (map != null) {
            return map;
        }
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        if (wVar != null) {
            this.xv = wVar.f();
        }
        if (this.xv == null) {
            this.xv = new HashMap();
        }
        return this.xv;
    }

    @Override // com.bytedance.msdk.api.c.sr
    public int z() {
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar;
        com.bytedance.sdk.openadsdk.mediation.c.w.w wVar = this.f27453w;
        int ys = wVar != null ? wVar.ys() : 0;
        return (ys != 0 || (cVar = this.f27451c) == null) ? ys : cVar.ck();
    }
}
