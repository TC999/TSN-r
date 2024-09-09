package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.a;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class er implements com.kwad.sdk.core.d<a.C0704a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0704a c0704a, JSONObject jSONObject) {
        a2(c0704a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0704a c0704a, JSONObject jSONObject) {
        return b2(c0704a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0704a c0704a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0704a.WO = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0704a.WO)) {
            c0704a.WO = "";
        }
        c0704a.WP = jSONObject.optInt("SDKVersionCode");
        c0704a.ayD = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0704a.ayD)) {
            c0704a.ayD = "";
        }
        c0704a.WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0704a.WQ)) {
            c0704a.WQ = "";
        }
        c0704a.WR = jSONObject.optInt("sdkApiVersionCode");
        c0704a.sdkType = jSONObject.optInt("sdkType");
        c0704a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0704a.appVersion)) {
            c0704a.appVersion = "";
        }
        c0704a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0704a.appName)) {
            c0704a.appName = "";
        }
        c0704a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0704a.appId)) {
            c0704a.appId = "";
        }
        c0704a.aEF = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0704a.aEF)) {
            c0704a.aEF = "";
        }
        c0704a.azu = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0704a.azu)) {
            c0704a.azu = "";
        }
        c0704a.azt = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0704a.azt)) {
            c0704a.azt = "";
        }
        c0704a.WS = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0704a.WS)) {
            c0704a.WS = "";
        }
        c0704a.WT = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0704a.WT)) {
            c0704a.WT = "";
        }
        c0704a.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(c0704a.model)) {
            c0704a.model = "";
        }
        c0704a.WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0704a.WU)) {
            c0704a.WU = "";
        }
        c0704a.WV = jSONObject.optInt("osType");
        c0704a.WW = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0704a.WW)) {
            c0704a.WW = "";
        }
        c0704a.WX = jSONObject.optInt("osApi");
        c0704a.WY = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0704a.WY)) {
            c0704a.WY = "";
        }
        c0704a.WZ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0704a.WZ)) {
            c0704a.WZ = "";
        }
        c0704a.aEG = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c0704a.aEG)) {
            c0704a.aEG = "";
        }
        c0704a.aEH = jSONObject.optBoolean("isDynamic");
        c0704a.Xa = jSONObject.optInt("screenWidth");
        c0704a.Xb = jSONObject.optInt("screenHeight");
        c0704a.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c0704a.atm)) {
            c0704a.atm = "";
        }
        c0704a.atn = jSONObject.optString(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
        if (JSONObject.NULL.toString().equals(c0704a.atn)) {
            c0704a.atn = "";
        }
        c0704a.azo = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0704a.azo)) {
            c0704a.azo = "";
        }
        c0704a.azF = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c0704a.azF)) {
            c0704a.azF = "";
        }
        c0704a.Xc = jSONObject.optInt("statusBarHeight");
        c0704a.Xd = jSONObject.optInt("titleBarHeight");
        c0704a.aEI = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0704a.aEI)) {
            c0704a.aEI = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0704a c0704a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0704a.WO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", c0704a.WO);
        }
        int i4 = c0704a.WP;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i4);
        }
        String str2 = c0704a.ayD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", c0704a.ayD);
        }
        String str3 = c0704a.WQ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", c0704a.WQ);
        }
        int i5 = c0704a.WR;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i5);
        }
        int i6 = c0704a.sdkType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i6);
        }
        String str4 = c0704a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", c0704a.appVersion);
        }
        String str5 = c0704a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", c0704a.appName);
        }
        String str6 = c0704a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", c0704a.appId);
        }
        String str7 = c0704a.aEF;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "globalId", c0704a.aEF);
        }
        String str8 = c0704a.azu;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", c0704a.azu);
        }
        String str9 = c0704a.azt;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", c0704a.azt);
        }
        String str10 = c0704a.WS;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", c0704a.WS);
        }
        String str11 = c0704a.WT;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manufacturer", c0704a.WT);
        }
        String str12 = c0704a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "model", c0704a.model);
        }
        String str13 = c0704a.WU;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", c0704a.WU);
        }
        int i7 = c0704a.WV;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i7);
        }
        String str14 = c0704a.WW;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", c0704a.WW);
        }
        int i8 = c0704a.WX;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i8);
        }
        String str15 = c0704a.WY;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", c0704a.WY);
        }
        String str16 = c0704a.WZ;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", c0704a.WZ);
        }
        String str17 = c0704a.aEG;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "uuid", c0704a.aEG);
        }
        boolean z3 = c0704a.aEH;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDynamic", z3);
        }
        int i9 = c0704a.Xa;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i9);
        }
        int i10 = c0704a.Xb;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i10);
        }
        String str18 = c0704a.atm;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", c0704a.atm);
        }
        String str19 = c0704a.atn;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, c0704a.atn);
        }
        String str20 = c0704a.azo;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", c0704a.azo);
        }
        String str21 = c0704a.azF;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", c0704a.azF);
        }
        int i11 = c0704a.Xc;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i11);
        }
        int i12 = c0704a.Xd;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i12);
        }
        String str22 = c0704a.aEI;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bridgeVersion", c0704a.aEI);
        }
        return jSONObject;
    }
}
