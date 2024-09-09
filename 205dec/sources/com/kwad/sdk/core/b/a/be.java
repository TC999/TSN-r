package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.as;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class be implements com.kwad.sdk.core.d<as.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(as.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(as.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(as.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(bVar.appName)) {
            bVar.appName = "";
        }
        bVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(bVar.pkgName)) {
            bVar.pkgName = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.XP = jSONObject.optLong("appSize");
        bVar.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(bVar.md5)) {
            bVar.md5 = "";
        }
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString(RewardPlus.ICON);
        if (JSONObject.NULL.toString().equals(bVar.icon)) {
            bVar.icon = "";
        }
        bVar.qb = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(bVar.qb)) {
            bVar.qb = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(as.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", bVar.appName);
        }
        String str2 = bVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pkgName", bVar.pkgName);
        }
        String str3 = bVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        int i4 = bVar.versionCode;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "versionCode", i4);
        }
        long j4 = bVar.XP;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSize", j4);
        }
        String str4 = bVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5", bVar.md5);
        }
        String str5 = bVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str6 = bVar.icon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, RewardPlus.ICON, bVar.icon);
        }
        String str7 = bVar.qb;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "desc", bVar.qb);
        }
        return jSONObject;
    }
}
