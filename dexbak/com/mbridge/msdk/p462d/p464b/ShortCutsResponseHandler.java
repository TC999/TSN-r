package com.mbridge.msdk.p462d.p464b;

import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.CommonHttpConfig;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.d.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class ShortCutsResponseHandler extends Listener<JSONObject> {

    /* renamed from: a */
    private static final String f30174a = "b";

    /* renamed from: b */
    private long f30175b;

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21053a() {
        super.mo21053a();
        this.f30175b = System.currentTimeMillis();
    }

    /* renamed from: a */
    public abstract void mo22970a(int i, String str, CampaignUnit campaignUnit);

    /* renamed from: a */
    public abstract void mo22969a(List<C11336b> list, CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<JSONObject> c11356k) {
        NetworkResponse networkResponse;
        CampaignUnit parseCampaignUnit;
        if (c11356k == null || (networkResponse = c11356k.f30857c) == null) {
            return;
        }
        List<C11336b> list = networkResponse.f30754d;
        JSONObject jSONObject = c11356k.f30855a;
        int optInt = jSONObject.optInt("status");
        if (1 == optInt) {
            m22266a(System.currentTimeMillis());
            if ("v5".equals(jSONObject.optString(ConstantHelper.LOG_VS))) {
                parseCampaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"));
            } else {
                parseCampaignUnit = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"));
            }
            if (parseCampaignUnit != null && parseCampaignUnit.getAds() != null && parseCampaignUnit.getAds().size() > 0) {
                mo22969a(list, parseCampaignUnit);
                m22267a(parseCampaignUnit.getAds().size());
                return;
            }
            String msg = parseCampaignUnit != null ? parseCampaignUnit.getMsg() : null;
            if (TextUtils.isEmpty(msg)) {
                msg = jSONObject.optString("msg");
            }
            mo22970a(optInt, msg, parseCampaignUnit);
            return;
        }
        mo22970a(optInt, jSONObject.optString("msg"), null);
    }

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        String str = f30174a;
        SameLogTool.m21733d(str, "errorCode = " + commonError.f30690a);
        mo22970a(commonError.f30690a, CommonHttpConfig.m22259a(commonError), null);
    }
}
