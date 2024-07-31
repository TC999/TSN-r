package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ds */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10015ds implements InterfaceC10273d<AdStyleInfo.FeedAdInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        m27052a(feedAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        return m27051b(feedAdInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27052a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedAdInfo.templateConfig = jSONObject.optString("templateConfig");
        if (JSONObject.NULL.toString().equals(feedAdInfo.templateConfig)) {
            feedAdInfo.templateConfig = "";
        }
        feedAdInfo.heightRatio = jSONObject.optDouble("heightRatio");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27051b(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedAdInfo.templateConfig;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateConfig", feedAdInfo.templateConfig);
        }
        double d = feedAdInfo.heightRatio;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "heightRatio", d);
        }
        return jSONObject;
    }
}
