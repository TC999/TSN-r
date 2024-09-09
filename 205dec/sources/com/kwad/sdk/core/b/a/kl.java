package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ah;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kl implements com.kwad.sdk.core.d<ah.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ah.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ah.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.Xg = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.Xh = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.Xh)) {
            aVar.Xh = "";
        }
        aVar.icon = jSONObject.optString(RewardPlus.ICON);
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.qb = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(aVar.qb)) {
            aVar.qb = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.Xi = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.Xi)) {
            aVar.Xi = "";
        }
        aVar.Xj = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.Xk = jSONObject.optBoolean("isLandscapeSupported");
        aVar.Xl = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.type;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i4);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", aVar.version);
        }
        int i5 = aVar.versionCode;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "versionCode", i5);
        }
        int i6 = aVar.Xg;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSize", i6);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5", aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.Xh;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appLink", aVar.Xh);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, RewardPlus.ICON, aVar.icon);
        }
        String str8 = aVar.qb;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "desc", aVar.qb);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", aVar.appId);
        }
        String str10 = aVar.Xi;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "marketUri", aVar.Xi);
        }
        boolean z3 = aVar.Xj;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableLandingPageDeepLink", z3);
        }
        boolean z4 = aVar.Xk;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isLandscapeSupported", z4);
        }
        boolean z5 = aVar.Xl;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isFromLive", z5);
        }
        return jSONObject;
    }
}
