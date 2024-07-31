package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9969c implements InterfaceC10273d<AdStyleInfo.PlayDetailInfo.ActionBarInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        m27136a(actionBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        return m27135b(actionBarInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27136a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfo.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
        actionBarInfo.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
        actionBarInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27135b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = actionBarInfo.translateBtnShowTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "translateBtnShowTime", j);
        }
        long j2 = actionBarInfo.lightBtnShowTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "lightBtnShowTime", j2);
        }
        long j3 = actionBarInfo.cardShowTime;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "cardShowTime", j3);
        }
        return jSONObject;
    }
}
