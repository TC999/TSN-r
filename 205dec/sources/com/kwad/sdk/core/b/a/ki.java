package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ki implements com.kwad.sdk.core.d<AdInfo.UnDownloadRegionConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        a2(unDownloadRegionConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        return b2(unDownloadRegionConf, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = unDownloadRegionConf.materialJumpType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialJumpType", i4);
        }
        int i5 = unDownloadRegionConf.actionBarType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionBarType", i5);
        }
        int i6 = unDownloadRegionConf.describeBarType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "describeBarType", i6);
        }
        return jSONObject;
    }
}
