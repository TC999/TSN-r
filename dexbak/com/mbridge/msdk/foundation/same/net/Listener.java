package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.LoadTime;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p485f.RequestControlUtil;
import com.mbridge.msdk.foundation.same.report.p487a.CampaignRequestTimeUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.SettingManager;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.net.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Listener<T> implements IListener<T> {

    /* renamed from: a */
    private long f30755a;

    /* renamed from: d */
    public String f30757d = "";

    /* renamed from: e */
    public String f30758e = "";

    /* renamed from: f */
    public int f30759f = 0;

    /* renamed from: b */
    private CampaignRequestTimeUtil f30756b = null;

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public void mo21053a() {
        this.f30755a = System.currentTimeMillis();
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public void mo22265a(long j, long j2) {
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public void mo21052a(CommonError commonError) {
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: b */
    public void mo22264b() {
    }

    /* renamed from: b */
    public final void m22263b(int i) {
        CampaignRequestTimeUtil campaignRequestTimeUtil = this.f30756b;
        if (campaignRequestTimeUtil != null) {
            campaignRequestTimeUtil.m22143c(i);
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: c */
    public void mo22262c() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: d */
    public final void mo22261d() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: e */
    public final void mo22260e() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public void mo21051a(C11356k<T> c11356k) {
        try {
            String str = MBSDKContext.m22865f().m22860k() + "_" + this.f30758e + "_" + this.f30757d + "_" + this.f30759f;
            SettingManager.m23261a().m23247d(this.f30757d);
            SameLogTool.m21733d("Listener", c11356k.f30855a + " " + str);
            T t = c11356k.f30855a;
            if (t instanceof JSONObject) {
                RequestControlUtil.m22253a().m22250a(str, ((JSONObject) t).optInt("status"), ((JSONObject) c11356k.f30855a).toString(), System.currentTimeMillis());
            }
            if (c11356k.f30855a instanceof String) {
                RequestControlUtil.m22253a().m22250a(str, new JSONObject((String) c11356k.f30855a).optInt("status"), (String) c11356k.f30855a, System.currentTimeMillis());
            }
        } catch (Exception e) {
            SameLogTool.m21733d("Listener", e.getMessage());
        }
    }

    /* renamed from: a */
    public final void m22266a(long j) {
        CampaignRequestTimeUtil campaignRequestTimeUtil = new CampaignRequestTimeUtil(new LoadTime());
        this.f30756b = campaignRequestTimeUtil;
        campaignRequestTimeUtil.m22144b(this.f30757d);
        this.f30756b.m22147a(1);
        CampaignRequestTimeUtil campaignRequestTimeUtil2 = this.f30756b;
        campaignRequestTimeUtil2.m22146a((j - this.f30755a) + "");
    }

    /* renamed from: a */
    public final void m22267a(int i) {
        CampaignRequestTimeUtil campaignRequestTimeUtil = this.f30756b;
        if (campaignRequestTimeUtil != null) {
            campaignRequestTimeUtil.m22145b(i);
            this.f30756b.m22148a();
        }
    }
}
