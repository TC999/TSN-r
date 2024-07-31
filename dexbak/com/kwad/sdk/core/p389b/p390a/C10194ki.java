package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ki */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10194ki implements InterfaceC10273d<AdInfo.UnDownloadRegionConf> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        m26700a(unDownloadRegionConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        return m26699b(unDownloadRegionConf, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26700a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26699b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = unDownloadRegionConf.materialJumpType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "materialJumpType", i);
        }
        int i2 = unDownloadRegionConf.actionBarType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "actionBarType", i2);
        }
        int i3 = unDownloadRegionConf.describeBarType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "describeBarType", i3);
        }
        return jSONObject;
    }
}
