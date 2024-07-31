package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.DialogFragmentC7931h;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9972cc implements InterfaceC10273d<DialogFragmentC7931h.C7944c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(DialogFragmentC7931h.C7944c c7944c, JSONObject jSONObject) {
        m27130a(c7944c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(DialogFragmentC7931h.C7944c c7944c, JSONObject jSONObject) {
        return m27129b(c7944c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27130a(DialogFragmentC7931h.C7944c c7944c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7944c.style = jSONObject.optInt("style");
        c7944c.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(c7944c.title)) {
            c7944c.title = "";
        }
        c7944c.f26645pW = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(c7944c.f26645pW)) {
            c7944c.f26645pW = "";
        }
        c7944c.f26646pX = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(c7944c.f26646pX)) {
            c7944c.f26646pX = "";
        }
        c7944c.f26647pY = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(c7944c.f26647pY)) {
            c7944c.f26647pY = "";
        }
        c7944c.f26648pZ = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(c7944c.f26648pZ)) {
            c7944c.f26648pZ = "";
        }
        c7944c.f26651qa = jSONObject.optString("iconUrl");
        if (JSONObject.NULL.toString().equals(c7944c.f26651qa)) {
            c7944c.f26651qa = "";
        }
        c7944c.f26652qb = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(c7944c.f26652qb)) {
            c7944c.f26652qb = "";
        }
        c7944c.f26653qc = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(c7944c.f26653qc)) {
            c7944c.f26653qc = "";
        }
        c7944c.f26654qd = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(c7944c.f26654qd)) {
            c7944c.f26654qd = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27129b(DialogFragmentC7931h.C7944c c7944c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c7944c.style;
        if (i != 0) {
            C11126t.putValue(jSONObject, "style", i);
        }
        String str = c7944c.title;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "title", c7944c.title);
        }
        String str2 = c7944c.f26645pW;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "closeBtnText", c7944c.f26645pW);
        }
        String str3 = c7944c.f26646pX;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "continueBtnText", c7944c.f26646pX);
        }
        String str4 = c7944c.f26647pY;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "viewDetailText", c7944c.f26647pY);
        }
        String str5 = c7944c.f26648pZ;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "unWatchedVideoTime", c7944c.f26648pZ);
        }
        String str6 = c7944c.f26651qa;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "iconUrl", c7944c.f26651qa);
        }
        String str7 = c7944c.f26652qb;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "desc", c7944c.f26652qb);
        }
        String str8 = c7944c.f26653qc;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "descTxt", c7944c.f26653qc);
        }
        String str9 = c7944c.f26654qd;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "currentPlayTime", c7944c.f26654qd);
        }
        return jSONObject;
    }
}
