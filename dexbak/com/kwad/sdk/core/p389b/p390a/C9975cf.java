package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9975cf implements InterfaceC10273d<AdInfo.ComplianceInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        m27124a(complianceInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        return m27123b(complianceInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27124a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27123b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = complianceInfo.materialJumpType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "materialJumpType", i);
        }
        int i2 = complianceInfo.actionBarType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "actionBarType", i2);
        }
        int i3 = complianceInfo.describeBarType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "describeBarType", i3);
        }
        int i4 = complianceInfo.titleBarTextSwitch;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "titleBarTextSwitch", i4);
        }
        return jSONObject;
    }
}
