package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.af;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hs implements com.kwad.sdk.core.d<af.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.WO = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(aVar.WO)) {
            aVar.WO = "";
        }
        aVar.WP = jSONObject.optInt("SDKVersionCode");
        aVar.WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(aVar.WQ)) {
            aVar.WQ = "";
        }
        aVar.WR = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.WS = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(aVar.WS)) {
            aVar.WS = "";
        }
        aVar.WT = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(aVar.WT)) {
            aVar.WT = "";
        }
        aVar.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(aVar.WU)) {
            aVar.WU = "";
        }
        aVar.WV = jSONObject.optInt("osType");
        aVar.WW = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(aVar.WW)) {
            aVar.WW = "";
        }
        aVar.WX = jSONObject.optInt("osApi");
        aVar.WY = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(aVar.WY)) {
            aVar.WY = "";
        }
        aVar.WZ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(aVar.WZ)) {
            aVar.WZ = "";
        }
        aVar.Xa = jSONObject.optInt("screenWidth");
        aVar.Xb = jSONObject.optInt("screenHeight");
        aVar.Xc = jSONObject.optInt("statusBarHeight");
        aVar.Xd = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.WO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", aVar.WO);
        }
        int i4 = aVar.WP;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i4);
        }
        String str2 = aVar.WQ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", aVar.WQ);
        }
        int i5 = aVar.WR;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i5);
        }
        int i6 = aVar.sdkType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i6);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", aVar.appId);
        }
        String str6 = aVar.WS;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", aVar.WS);
        }
        String str7 = aVar.WT;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manufacturer", aVar.WT);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "model", aVar.model);
        }
        String str9 = aVar.WU;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", aVar.WU);
        }
        int i7 = aVar.WV;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i7);
        }
        String str10 = aVar.WW;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", aVar.WW);
        }
        int i8 = aVar.WX;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i8);
        }
        String str11 = aVar.WY;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", aVar.WY);
        }
        String str12 = aVar.WZ;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", aVar.WZ);
        }
        int i9 = aVar.Xa;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i9);
        }
        int i10 = aVar.Xb;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i10);
        }
        int i11 = aVar.Xc;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i11);
        }
        int i12 = aVar.Xd;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i12);
        }
        return jSONObject;
    }
}
