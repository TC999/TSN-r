package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p418b.p419a.C10613a;
import com.kwad.sdk.core.webview.p418b.p419a.C10614b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ge */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10082ge implements InterfaceC10273d<C10614b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10614b c10614b, JSONObject jSONObject) {
        m26924a(c10614b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10614b c10614b, JSONObject jSONObject) {
        return m26923b(c10614b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26924a(C10614b c10614b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10614b.status = jSONObject.optInt("Status");
        c10614b.contentEncoding = jSONObject.optString("Content-Encoding");
        if (JSONObject.NULL.toString().equals(c10614b.contentEncoding)) {
            c10614b.contentEncoding = "";
        }
        c10614b.aEu = jSONObject.optString("Cache-Control");
        if (JSONObject.NULL.toString().equals(c10614b.aEu)) {
            c10614b.aEu = "";
        }
        c10614b.aEs = jSONObject.optString("Content-Type");
        if (JSONObject.NULL.toString().equals(c10614b.aEs)) {
            c10614b.aEs = "";
        }
        C10613a c10613a = new C10613a();
        c10614b.aEv = c10613a;
        c10613a.parseJson(jSONObject.optJSONObject(TTDownloadField.TT_HEADERS));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26923b(C10614b c10614b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10614b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "Status", i);
        }
        String str = c10614b.contentEncoding;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "Content-Encoding", c10614b.contentEncoding);
        }
        String str2 = c10614b.aEu;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "Cache-Control", c10614b.aEu);
        }
        String str3 = c10614b.aEs;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "Content-Type", c10614b.aEs);
        }
        C11126t.m23678a(jSONObject, TTDownloadField.TT_HEADERS, c10614b.aEv);
        return jSONObject;
    }
}
