package com.mbridge.msdk.rover;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.rover.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class RoverResponseHandler extends Listener<JSONObject> {

    /* renamed from: a */
    private static final String f31686a = "h";

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21051a(C11356k<JSONObject> c11356k) {
        if (c11356k != null) {
            mo21303a(RoverCampaignUnit.parseCampaignUnit(c11356k.f30855a));
        }
    }

    /* renamed from: a */
    public abstract void mo21303a(RoverCampaignUnit roverCampaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
    /* renamed from: a */
    public final void mo21052a(CommonError commonError) {
        String str = f31686a;
        SameLogTool.m21733d(str, "errorCode = " + commonError.f30690a);
    }
}
