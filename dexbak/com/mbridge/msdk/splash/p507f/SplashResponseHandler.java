package com.mbridge.msdk.splash.p507f;

import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.CommonHttpConfig;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.f.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SplashResponseHandler extends Listener<JSONObject> {

    /* renamed from: a */
    private static final String f31924a = "c";

    /* renamed from: b */
    private int f31925b;

    /* renamed from: c */
    private String f31926c;

    /* renamed from: a */
    public abstract void mo21048a(List<Frame> list);

    /* renamed from: a */
    public abstract void mo21047a(List<C11336b> list, CampaignUnit campaignUnit);

    /* renamed from: b */
    public abstract void mo21046b(int i, String str);

    /* renamed from: a */
    public final void m21049a(String str) {
        this.f31926c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21053a() {
        super.mo21053a();
    }

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<JSONObject> c11356k) {
        NetworkResponse networkResponse;
        CampaignUnit parseCampaignUnit;
        super.mo21051a(c11356k);
        if (c11356k == null || (networkResponse = c11356k.f30857c) == null) {
            return;
        }
        int i = this.f31925b;
        if (i == 0) {
            final List<C11336b> list = networkResponse.f30754d;
            final JSONObject jSONObject = c11356k.f30855a;
            final int optInt = jSONObject.optInt("status");
            if (1 == optInt) {
                m22266a(System.currentTimeMillis());
                final String optString = jSONObject.optString(ConstantHelper.LOG_VS);
                ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.splash.f.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final CampaignUnit parseV5CampaignUnit = "v5".equals(optString) ? CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"), SplashResponseHandler.this.f31926c) : CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"), SplashResponseHandler.this.f31926c);
                        ThreadPoolUtils.m22306d().post(new Runnable() { // from class: com.mbridge.msdk.splash.f.c.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                CampaignUnit campaignUnit = parseV5CampaignUnit;
                                if (campaignUnit != null && campaignUnit.getAds() != null && parseV5CampaignUnit.getAds().size() > 0) {
                                    RunnableC116031 runnableC116031 = RunnableC116031.this;
                                    SplashResponseHandler.this.mo21047a(list, parseV5CampaignUnit);
                                    SplashResponseHandler.this.m22267a(parseV5CampaignUnit.getAds().size());
                                    return;
                                }
                                CampaignUnit campaignUnit2 = parseV5CampaignUnit;
                                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                                if (TextUtils.isEmpty(msg)) {
                                    msg = jSONObject.optString("msg");
                                }
                                RunnableC116031 runnableC1160312 = RunnableC116031.this;
                                SplashResponseHandler.this.mo21046b(optInt, msg);
                            }
                        });
                    }
                });
                return;
            }
            mo21046b(optInt, jSONObject.optString("msg"));
        } else if (i == 1) {
            List<C11336b> list2 = networkResponse.f30754d;
            JSONObject jSONObject2 = c11356k.f30855a;
            int optInt2 = jSONObject2.optInt("status");
            if (1 == optInt2) {
                m22266a(System.currentTimeMillis());
                if ("v5".equals(jSONObject2.optString(ConstantHelper.LOG_VS))) {
                    parseCampaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject2.optJSONObject("data"), this.f31926c);
                } else {
                    parseCampaignUnit = CampaignUnit.parseCampaignUnit(jSONObject2.optJSONObject("data"), this.f31926c);
                }
                if (parseCampaignUnit != null && parseCampaignUnit.getListFrames() != null && parseCampaignUnit.getListFrames().size() > 0) {
                    List<Frame> listFrames = parseCampaignUnit.getListFrames();
                    mo21048a(listFrames);
                    m22267a(listFrames.size());
                    return;
                }
                String msg = parseCampaignUnit != null ? parseCampaignUnit.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = jSONObject2.optString("msg");
                }
                mo21046b(optInt2, msg);
                return;
            }
            mo21046b(optInt2, jSONObject2.optString("msg"));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        String str = f31924a;
        SameLogTool.m21733d(str, "errorCode = " + commonError.f30690a);
        mo21046b(commonError.f30690a, CommonHttpConfig.m22259a(commonError));
    }
}
