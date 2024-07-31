package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9944bb implements InterfaceC10273d<AnrReason> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AnrReason anrReason, JSONObject jSONObject) {
        m27186a(anrReason, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AnrReason anrReason, JSONObject jSONObject) {
        return m27185b(anrReason, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27186a(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        anrReason.mTag = jSONObject.optString("mTag");
        if (JSONObject.NULL.toString().equals(anrReason.mTag)) {
            anrReason.mTag = "";
        }
        anrReason.mShortMsg = jSONObject.optString("mShortMsg");
        if (JSONObject.NULL.toString().equals(anrReason.mShortMsg)) {
            anrReason.mShortMsg = "";
        }
        anrReason.mLongMsg = jSONObject.optString("mLongMsg");
        if (JSONObject.NULL.toString().equals(anrReason.mLongMsg)) {
            anrReason.mLongMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27185b(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = anrReason.mTag;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "mTag", anrReason.mTag);
        }
        String str2 = anrReason.mShortMsg;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "mShortMsg", anrReason.mShortMsg);
        }
        String str3 = anrReason.mLongMsg;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "mLongMsg", anrReason.mLongMsg);
        }
        return jSONObject;
    }
}
