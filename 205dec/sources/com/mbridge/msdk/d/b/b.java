package com.mbridge.msdk.d.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.e.c;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ShortCutsResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b extends f<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39001a = "b";

    /* renamed from: b  reason: collision with root package name */
    private long f39002b;

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a() {
        super.a();
        this.f39002b = System.currentTimeMillis();
    }

    public abstract void a(int i4, String str, CampaignUnit campaignUnit);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<JSONObject> kVar) {
        c cVar;
        CampaignUnit parseCampaignUnit;
        if (kVar == null || (cVar = kVar.f39630c) == null) {
            return;
        }
        List<com.mbridge.msdk.foundation.same.net.c.b> list = cVar.f39548d;
        JSONObject jSONObject = kVar.f39628a;
        int optInt = jSONObject.optInt("status");
        if (1 == optInt) {
            a(System.currentTimeMillis());
            if ("v5".equals(jSONObject.optString("version"))) {
                parseCampaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"));
            } else {
                parseCampaignUnit = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"));
            }
            if (parseCampaignUnit != null && parseCampaignUnit.getAds() != null && parseCampaignUnit.getAds().size() > 0) {
                a(list, parseCampaignUnit);
                a(parseCampaignUnit.getAds().size());
                return;
            }
            String msg = parseCampaignUnit != null ? parseCampaignUnit.getMsg() : null;
            if (TextUtils.isEmpty(msg)) {
                msg = jSONObject.optString("msg");
            }
            a(optInt, msg, parseCampaignUnit);
            return;
        }
        a(optInt, jSONObject.optString("msg"), null);
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f39001a;
        x.d(str, "errorCode = " + aVar.f39484a);
        a(aVar.f39484a, com.mbridge.msdk.foundation.same.net.f.a.a(aVar), null);
    }
}
