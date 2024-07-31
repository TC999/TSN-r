package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ao */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9930ao implements InterfaceC10273d<AdStatusInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        m27214a(adStatusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return m27213b(adStatusInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27214a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt("downloadStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27213b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adStatusInfo.loadFromCache;
        if (z) {
            C11126t.putValue(jSONObject, "loadFromCache", z);
        }
        long j = adStatusInfo.loadDataTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "loadDataTime", j);
        }
        long j2 = adStatusInfo.downloadFinishTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "downloadFinishTime", j2);
        }
        int i = adStatusInfo.downloadType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "downloadType", i);
        }
        long j3 = adStatusInfo.downloadSize;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "downloadSize", j3);
        }
        int i2 = adStatusInfo.downloadStatus;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "downloadStatus", i2);
        }
        return jSONObject;
    }
}
