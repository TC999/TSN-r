package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.adlog.p386a.C9900c;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.af */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9921af implements InterfaceC10273d<C9900c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9900c c9900c, JSONObject jSONObject) {
        m27232a(c9900c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9900c c9900c, JSONObject jSONObject) {
        return m27231b(c9900c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27232a(C9900c c9900c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9900c.apz = jSONObject.optBoolean("retrySwitch");
        c9900c.apA = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        c9900c.apB = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        c9900c.apC = jSONObject.optInt("retryQueueSize", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27231b(C9900c c9900c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9900c.apz;
        if (z) {
            C11126t.putValue(jSONObject, "retrySwitch", z);
        }
        C11126t.putValue(jSONObject, "retryCountConfig", c9900c.apA);
        C11126t.putValue(jSONObject, "cacheExpireTime", c9900c.apB);
        C11126t.putValue(jSONObject, "retryQueueSize", c9900c.apC);
        return jSONObject;
    }
}
