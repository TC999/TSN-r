package com.mbridge.msdk.rover;

import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONObject;

/* compiled from: RoverResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class h extends com.mbridge.msdk.foundation.same.net.f<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40457a = "h";

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<JSONObject> kVar) {
        if (kVar != null) {
            a(RoverCampaignUnit.parseCampaignUnit(kVar.f39628a));
        }
    }

    public abstract void a(RoverCampaignUnit roverCampaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f40457a;
        x.d(str, "errorCode = " + aVar.f39484a);
    }
}
