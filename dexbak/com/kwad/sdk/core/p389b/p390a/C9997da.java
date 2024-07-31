package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.C10475b;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.da */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9997da implements InterfaceC10273d<C10475b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10475b c10475b, JSONObject jSONObject) {
        m27088a(c10475b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10475b c10475b, JSONObject jSONObject) {
        return m27087b(c10475b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27088a(C10475b c10475b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10475b.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c10475b.atm)) {
            c10475b.atm = "";
        }
        c10475b.azg = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(c10475b.azg)) {
            c10475b.azg = "";
        }
        c10475b.azh = jSONObject.optString("imei2");
        if (JSONObject.NULL.toString().equals(c10475b.azh)) {
            c10475b.azh = "";
        }
        c10475b.azi = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(c10475b.azi)) {
            c10475b.azi = "";
        }
        c10475b.atn = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c10475b.atn)) {
            c10475b.atn = "";
        }
        c10475b.azj = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(c10475b.azj)) {
            c10475b.azj = "";
        }
        c10475b.azk = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(c10475b.azk)) {
            c10475b.azk = "";
        }
        c10475b.f29575RN = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(c10475b.f29575RN)) {
            c10475b.f29575RN = "";
        }
        c10475b.f29577WV = jSONObject.optInt("osType");
        c10475b.f29578WX = jSONObject.optInt("osApi");
        c10475b.azl = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(c10475b.azl)) {
            c10475b.azl = "";
        }
        c10475b.f29579WY = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c10475b.f29579WY)) {
            c10475b.f29579WY = "";
        }
        c10475b.f29580Xa = jSONObject.optInt("screenWidth");
        c10475b.f29581Xb = jSONObject.optInt("screenHeight");
        c10475b.azm = jSONObject.optInt("deviceWidth");
        c10475b.azn = jSONObject.optInt("deviceHeight");
        c10475b.azo = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c10475b.azo)) {
            c10475b.azo = "";
        }
        c10475b.azp = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(c10475b.azp)) {
            c10475b.azp = "";
        }
        c10475b.azq = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(c10475b.azq)) {
            c10475b.azq = "";
        }
        c10475b.azr = jSONObject.optInt(Constants.PARAM_PLATFORM);
        c10475b.azs = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(c10475b.azs)) {
            c10475b.azs = "";
        }
        c10475b.f29576WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c10475b.f29576WU)) {
            c10475b.f29576WU = "";
        }
        c10475b.azt = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c10475b.azt)) {
            c10475b.azt = "";
        }
        c10475b.azu = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c10475b.azu)) {
            c10475b.azu = "";
        }
        c10475b.azv = jSONObject.optJSONArray("appPackageName");
        c10475b.azw = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(c10475b.azw)) {
            c10475b.azw = "";
        }
        c10475b.azx = jSONObject.optInt("screenDirection");
        c10475b.azy = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(c10475b.azy)) {
            c10475b.azy = "";
        }
        c10475b.azz = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(c10475b.azz)) {
            c10475b.azz = "";
        }
        c10475b.azA = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(c10475b.azA)) {
            c10475b.azA = "";
        }
        c10475b.azB = jSONObject.optLong("sourceFlag");
        c10475b.azC = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(c10475b.azC)) {
            c10475b.azC = "";
        }
        c10475b.azD = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(c10475b.azD)) {
            c10475b.azD = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27087b(C10475b c10475b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10475b.atm;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "imei", c10475b.atm);
        }
        String str2 = c10475b.azg;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "imei1", c10475b.azg);
        }
        String str3 = c10475b.azh;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "imei2", c10475b.azh);
        }
        String str4 = c10475b.azi;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "meid", c10475b.azi);
        }
        String str5 = c10475b.atn;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "oaid", c10475b.atn);
        }
        String str6 = c10475b.azj;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "appMkt", c10475b.azj);
        }
        String str7 = c10475b.azk;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "appMktParam", c10475b.azk);
        }
        String str8 = c10475b.f29575RN;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "romName", c10475b.f29575RN);
        }
        int i = c10475b.f29577WV;
        if (i != 0) {
            C11126t.putValue(jSONObject, "osType", i);
        }
        int i2 = c10475b.f29578WX;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "osApi", i2);
        }
        String str9 = c10475b.azl;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "osVersion", c10475b.azl);
        }
        String str10 = c10475b.f29579WY;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "language", c10475b.f29579WY);
        }
        int i3 = c10475b.f29580Xa;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "screenWidth", i3);
        }
        int i4 = c10475b.f29581Xb;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "screenHeight", i4);
        }
        int i5 = c10475b.azm;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "deviceWidth", i5);
        }
        int i6 = c10475b.azn;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "deviceHeight", i6);
        }
        String str11 = c10475b.azo;
        if (str11 != null && !str11.equals("")) {
            C11126t.putValue(jSONObject, "androidId", c10475b.azo);
        }
        String str12 = c10475b.azp;
        if (str12 != null && !str12.equals("")) {
            C11126t.putValue(jSONObject, "deviceId", c10475b.azp);
        }
        String str13 = c10475b.azq;
        if (str13 != null && !str13.equals("")) {
            C11126t.putValue(jSONObject, "deviceVendor", c10475b.azq);
        }
        int i7 = c10475b.azr;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, Constants.PARAM_PLATFORM, i7);
        }
        String str14 = c10475b.azs;
        if (str14 != null && !str14.equals("")) {
            C11126t.putValue(jSONObject, "deviceModel", c10475b.azs);
        }
        String str15 = c10475b.f29576WU;
        if (str15 != null && !str15.equals("")) {
            C11126t.putValue(jSONObject, "deviceBrand", c10475b.f29576WU);
        }
        String str16 = c10475b.azt;
        if (str16 != null && !str16.equals("")) {
            C11126t.putValue(jSONObject, "deviceSig", c10475b.azt);
        }
        String str17 = c10475b.azu;
        if (str17 != null && !str17.equals("")) {
            C11126t.putValue(jSONObject, "eGid", c10475b.azu);
        }
        C11126t.putValue(jSONObject, "appPackageName", c10475b.azv);
        String str18 = c10475b.azw;
        if (str18 != null && !str18.equals("")) {
            C11126t.putValue(jSONObject, "arch", c10475b.azw);
        }
        int i8 = c10475b.azx;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "screenDirection", i8);
        }
        String str19 = c10475b.azy;
        if (str19 != null && !str19.equals("")) {
            C11126t.putValue(jSONObject, "kwaiVersionName", c10475b.azy);
        }
        String str20 = c10475b.azz;
        if (str20 != null && !str20.equals("")) {
            C11126t.putValue(jSONObject, "kwaiNebulaVersionName", c10475b.azz);
        }
        String str21 = c10475b.azA;
        if (str21 != null && !str21.equals("")) {
            C11126t.putValue(jSONObject, "wechatVersionName", c10475b.azA);
        }
        long j = c10475b.azB;
        if (j != 0) {
            C11126t.putValue(jSONObject, "sourceFlag", j);
        }
        String str22 = c10475b.azC;
        if (str22 != null && !str22.equals("")) {
            C11126t.putValue(jSONObject, "systemBootTime", c10475b.azC);
        }
        String str23 = c10475b.azD;
        if (str23 != null && !str23.equals("")) {
            C11126t.putValue(jSONObject, "systemUpdateTime", c10475b.azD);
        }
        return jSONObject;
    }
}
