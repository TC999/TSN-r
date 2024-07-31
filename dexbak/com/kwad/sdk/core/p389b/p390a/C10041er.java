package com.kwad.sdk.core.p389b.p390a;

import com.baidu.mobads.sdk.internal.C2624bk;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p423d.C10633a;
import com.kwad.sdk.utils.C11126t;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.er */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10041er implements InterfaceC10273d<C10633a.C10634a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10633a.C10634a c10634a, JSONObject jSONObject) {
        m27006a(c10634a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10633a.C10634a c10634a, JSONObject jSONObject) {
        return m27005b(c10634a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27006a(C10633a.C10634a c10634a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10634a.f29624WO = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c10634a.f29624WO)) {
            c10634a.f29624WO = "";
        }
        c10634a.f29625WP = jSONObject.optInt("SDKVersionCode");
        c10634a.ayD = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c10634a.ayD)) {
            c10634a.ayD = "";
        }
        c10634a.f29626WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c10634a.f29626WQ)) {
            c10634a.f29626WQ = "";
        }
        c10634a.f29627WR = jSONObject.optInt("sdkApiVersionCode");
        c10634a.sdkType = jSONObject.optInt("sdkType");
        c10634a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c10634a.appVersion)) {
            c10634a.appVersion = "";
        }
        c10634a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c10634a.appName)) {
            c10634a.appName = "";
        }
        c10634a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c10634a.appId)) {
            c10634a.appId = "";
        }
        c10634a.aEF = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c10634a.aEF)) {
            c10634a.aEF = "";
        }
        c10634a.azu = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c10634a.azu)) {
            c10634a.azu = "";
        }
        c10634a.azt = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c10634a.azt)) {
            c10634a.azt = "";
        }
        c10634a.f29628WS = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c10634a.f29628WS)) {
            c10634a.f29628WS = "";
        }
        c10634a.f29629WT = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c10634a.f29629WT)) {
            c10634a.f29629WT = "";
        }
        c10634a.model = jSONObject.optString(C2624bk.f8685i);
        if (JSONObject.NULL.toString().equals(c10634a.model)) {
            c10634a.model = "";
        }
        c10634a.f29630WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c10634a.f29630WU)) {
            c10634a.f29630WU = "";
        }
        c10634a.f29631WV = jSONObject.optInt("osType");
        c10634a.f29632WW = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c10634a.f29632WW)) {
            c10634a.f29632WW = "";
        }
        c10634a.f29633WX = jSONObject.optInt("osApi");
        c10634a.f29634WY = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c10634a.f29634WY)) {
            c10634a.f29634WY = "";
        }
        c10634a.f29635WZ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c10634a.f29635WZ)) {
            c10634a.f29635WZ = "";
        }
        c10634a.aEG = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c10634a.aEG)) {
            c10634a.aEG = "";
        }
        c10634a.aEH = jSONObject.optBoolean("isDynamic");
        c10634a.f29636Xa = jSONObject.optInt("screenWidth");
        c10634a.f29637Xb = jSONObject.optInt("screenHeight");
        c10634a.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c10634a.atm)) {
            c10634a.atm = "";
        }
        c10634a.atn = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c10634a.atn)) {
            c10634a.atn = "";
        }
        c10634a.azo = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c10634a.azo)) {
            c10634a.azo = "";
        }
        c10634a.azF = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        if (JSONObject.NULL.toString().equals(c10634a.azF)) {
            c10634a.azF = "";
        }
        c10634a.f29638Xc = jSONObject.optInt("statusBarHeight");
        c10634a.f29639Xd = jSONObject.optInt("titleBarHeight");
        c10634a.aEI = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c10634a.aEI)) {
            c10634a.aEI = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27005b(C10633a.C10634a c10634a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10634a.f29624WO;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "SDKVersion", c10634a.f29624WO);
        }
        int i = c10634a.f29625WP;
        if (i != 0) {
            C11126t.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c10634a.ayD;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "tkVersion", c10634a.ayD);
        }
        String str3 = c10634a.f29626WQ;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "sdkApiVersion", c10634a.f29626WQ);
        }
        int i2 = c10634a.f29627WR;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c10634a.sdkType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c10634a.appVersion;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "appVersion", c10634a.appVersion);
        }
        String str5 = c10634a.appName;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "appName", c10634a.appName);
        }
        String str6 = c10634a.appId;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "appId", c10634a.appId);
        }
        String str7 = c10634a.aEF;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "globalId", c10634a.aEF);
        }
        String str8 = c10634a.azu;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "eGid", c10634a.azu);
        }
        String str9 = c10634a.azt;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "deviceSig", c10634a.azt);
        }
        String str10 = c10634a.f29628WS;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "networkType", c10634a.f29628WS);
        }
        String str11 = c10634a.f29629WT;
        if (str11 != null && !str11.equals("")) {
            C11126t.putValue(jSONObject, "manufacturer", c10634a.f29629WT);
        }
        String str12 = c10634a.model;
        if (str12 != null && !str12.equals("")) {
            C11126t.putValue(jSONObject, C2624bk.f8685i, c10634a.model);
        }
        String str13 = c10634a.f29630WU;
        if (str13 != null && !str13.equals("")) {
            C11126t.putValue(jSONObject, "deviceBrand", c10634a.f29630WU);
        }
        int i4 = c10634a.f29631WV;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "osType", i4);
        }
        String str14 = c10634a.f29632WW;
        if (str14 != null && !str14.equals("")) {
            C11126t.putValue(jSONObject, "systemVersion", c10634a.f29632WW);
        }
        int i5 = c10634a.f29633WX;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c10634a.f29634WY;
        if (str15 != null && !str15.equals("")) {
            C11126t.putValue(jSONObject, "language", c10634a.f29634WY);
        }
        String str16 = c10634a.f29635WZ;
        if (str16 != null && !str16.equals("")) {
            C11126t.putValue(jSONObject, "locale", c10634a.f29635WZ);
        }
        String str17 = c10634a.aEG;
        if (str17 != null && !str17.equals("")) {
            C11126t.putValue(jSONObject, "uuid", c10634a.aEG);
        }
        boolean z = c10634a.aEH;
        if (z) {
            C11126t.putValue(jSONObject, "isDynamic", z);
        }
        int i6 = c10634a.f29636Xa;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c10634a.f29637Xb;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c10634a.atm;
        if (str18 != null && !str18.equals("")) {
            C11126t.putValue(jSONObject, "imei", c10634a.atm);
        }
        String str19 = c10634a.atn;
        if (str19 != null && !str19.equals("")) {
            C11126t.putValue(jSONObject, "oaid", c10634a.atn);
        }
        String str20 = c10634a.azo;
        if (str20 != null && !str20.equals("")) {
            C11126t.putValue(jSONObject, "androidId", c10634a.azo);
        }
        String str21 = c10634a.azF;
        if (str21 != null && !str21.equals("")) {
            C11126t.putValue(jSONObject, SocializeProtocolConstants.PROTOCOL_KEY_MAC, c10634a.azF);
        }
        int i8 = c10634a.f29638Xc;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c10634a.f29639Xd;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "titleBarHeight", i9);
        }
        String str22 = c10634a.aEI;
        if (str22 != null && !str22.equals("")) {
            C11126t.putValue(jSONObject, "bridgeVersion", c10634a.aEI);
        }
        return jSONObject;
    }
}
