package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10168jj implements InterfaceC10273d<AdMatrixInfo.SplashSlideInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        m26752a(splashSlideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        return m26751b(splashSlideInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26752a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(splashSlideInfo.title)) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString("subtitle");
        if (JSONObject.NULL.toString().equals(splashSlideInfo.subtitle)) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt("style");
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26751b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashSlideInfo.title;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "title", splashSlideInfo.title);
        }
        String str2 = splashSlideInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "subtitle", splashSlideInfo.subtitle);
        }
        int i = splashSlideInfo.style;
        if (i != 0) {
            C11126t.putValue(jSONObject, "style", i);
        }
        int i2 = splashSlideInfo.convertDistance;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "convertDistance", i2);
        }
        C11126t.m23678a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }
}
