package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class da implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(bVar.atm)) {
            bVar.atm = "";
        }
        bVar.azg = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(bVar.azg)) {
            bVar.azg = "";
        }
        bVar.azh = jSONObject.optString("imei2");
        if (JSONObject.NULL.toString().equals(bVar.azh)) {
            bVar.azh = "";
        }
        bVar.azi = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(bVar.azi)) {
            bVar.azi = "";
        }
        bVar.atn = jSONObject.optString(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
        if (JSONObject.NULL.toString().equals(bVar.atn)) {
            bVar.atn = "";
        }
        bVar.azj = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(bVar.azj)) {
            bVar.azj = "";
        }
        bVar.azk = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(bVar.azk)) {
            bVar.azk = "";
        }
        bVar.RN = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(bVar.RN)) {
            bVar.RN = "";
        }
        bVar.WV = jSONObject.optInt("osType");
        bVar.WX = jSONObject.optInt("osApi");
        bVar.azl = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(bVar.azl)) {
            bVar.azl = "";
        }
        bVar.WY = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(bVar.WY)) {
            bVar.WY = "";
        }
        bVar.Xa = jSONObject.optInt("screenWidth");
        bVar.Xb = jSONObject.optInt("screenHeight");
        bVar.azm = jSONObject.optInt("deviceWidth");
        bVar.azn = jSONObject.optInt("deviceHeight");
        bVar.azo = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(bVar.azo)) {
            bVar.azo = "";
        }
        bVar.azp = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(bVar.azp)) {
            bVar.azp = "";
        }
        bVar.azq = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(bVar.azq)) {
            bVar.azq = "";
        }
        bVar.azr = jSONObject.optInt("platform");
        bVar.azs = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(bVar.azs)) {
            bVar.azs = "";
        }
        bVar.WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(bVar.WU)) {
            bVar.WU = "";
        }
        bVar.azt = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(bVar.azt)) {
            bVar.azt = "";
        }
        bVar.azu = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(bVar.azu)) {
            bVar.azu = "";
        }
        bVar.azv = jSONObject.optJSONArray("appPackageName");
        bVar.azw = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(bVar.azw)) {
            bVar.azw = "";
        }
        bVar.azx = jSONObject.optInt("screenDirection");
        bVar.azy = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(bVar.azy)) {
            bVar.azy = "";
        }
        bVar.azz = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(bVar.azz)) {
            bVar.azz = "";
        }
        bVar.azA = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(bVar.azA)) {
            bVar.azA = "";
        }
        bVar.azB = jSONObject.optLong("sourceFlag");
        bVar.azC = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(bVar.azC)) {
            bVar.azC = "";
        }
        bVar.azD = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(bVar.azD)) {
            bVar.azD = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.atm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", bVar.atm);
        }
        String str2 = bVar.azg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei1", bVar.azg);
        }
        String str3 = bVar.azh;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei2", bVar.azh);
        }
        String str4 = bVar.azi;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "meid", bVar.azi);
        }
        String str5 = bVar.atn;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, bVar.atn);
        }
        String str6 = bVar.azj;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appMkt", bVar.azj);
        }
        String str7 = bVar.azk;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appMktParam", bVar.azk);
        }
        String str8 = bVar.RN;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "romName", bVar.RN);
        }
        int i4 = bVar.WV;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i4);
        }
        int i5 = bVar.WX;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i5);
        }
        String str9 = bVar.azl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osVersion", bVar.azl);
        }
        String str10 = bVar.WY;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", bVar.WY);
        }
        int i6 = bVar.Xa;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = bVar.Xb;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i7);
        }
        int i8 = bVar.azm;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceWidth", i8);
        }
        int i9 = bVar.azn;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceHeight", i9);
        }
        String str11 = bVar.azo;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", bVar.azo);
        }
        String str12 = bVar.azp;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceId", bVar.azp);
        }
        String str13 = bVar.azq;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceVendor", bVar.azq);
        }
        int i10 = bVar.azr;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "platform", i10);
        }
        String str14 = bVar.azs;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceModel", bVar.azs);
        }
        String str15 = bVar.WU;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", bVar.WU);
        }
        String str16 = bVar.azt;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", bVar.azt);
        }
        String str17 = bVar.azu;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", bVar.azu);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appPackageName", bVar.azv);
        String str18 = bVar.azw;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "arch", bVar.azw);
        }
        int i11 = bVar.azx;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenDirection", i11);
        }
        String str19 = bVar.azy;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kwaiVersionName", bVar.azy);
        }
        String str20 = bVar.azz;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kwaiNebulaVersionName", bVar.azz);
        }
        String str21 = bVar.azA;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "wechatVersionName", bVar.azA);
        }
        long j4 = bVar.azB;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sourceFlag", j4);
        }
        String str22 = bVar.azC;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemBootTime", bVar.azC);
        }
        String str23 = bVar.azD;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemUpdateTime", bVar.azD);
        }
        return jSONObject;
    }
}
