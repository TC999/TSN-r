package com.bytedance.sdk.openadsdk.core.live;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.eq;
import com.bytedance.sdk.openadsdk.core.z.r;
import com.bytedance.sdk.openadsdk.live.core.ITTLiveHostAction;
import java.io.Serializable;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.openadsdk.ys.w.w implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private eq f33857c;

    public w() {
        this.f33857c = null;
        this.f33857c = ls.w().ng();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w
    public com.bytedance.sdk.openadsdk.ys.w.xv.sr c() {
        return k.sr().ux();
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getAppName() {
        return ls.getContext().getPackageName();
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getChannel() {
        return "csj_channel";
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getECHostAppId() {
        return "1371";
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getGeneralAppId() {
        eq eqVar = this.f33857c;
        return String.valueOf(eqVar != null ? eqVar.w() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public ITTLiveHostAction getLiveHostAction() {
        return new xv();
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getPartner() {
        eq eqVar = this.f33857c;
        if (eqVar != null) {
            return eqVar.xv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getPartnerSecret() {
        eq eqVar = this.f33857c;
        if (eqVar != null) {
            return eqVar.sr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public String getVersion() {
        return com.bytedance.sdk.openadsdk.core.eq.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public int getVersionCode() {
        return com.bytedance.sdk.openadsdk.core.eq.f33190w;
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public boolean isDebug() {
        return a.xv();
    }

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public boolean isValid() {
        r w3 = ls.w();
        eq ng = w3.ng();
        int w4 = k.sr().a().w();
        return (ng == null || !ng.ux() || !w3.dk() || w4 == 4 || w4 == 5) ? false : true;
    }
}
