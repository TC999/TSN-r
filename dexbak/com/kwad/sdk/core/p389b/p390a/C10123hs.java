package com.kwad.sdk.core.p389b.p390a;

import com.baidu.mobads.sdk.internal.C2624bk;
import com.kwad.components.core.webview.jshandler.C9055af;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10123hs implements InterfaceC10273d<C9055af.C9056a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9055af.C9056a c9056a, JSONObject jSONObject) {
        m26842a(c9056a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9055af.C9056a c9056a, JSONObject jSONObject) {
        return m26841b(c9056a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26842a(C9055af.C9056a c9056a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9056a.f29111WO = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c9056a.f29111WO)) {
            c9056a.f29111WO = "";
        }
        c9056a.f29112WP = jSONObject.optInt("SDKVersionCode");
        c9056a.f29113WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c9056a.f29113WQ)) {
            c9056a.f29113WQ = "";
        }
        c9056a.f29114WR = jSONObject.optInt("sdkApiVersionCode");
        c9056a.sdkType = jSONObject.optInt("sdkType");
        c9056a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c9056a.appVersion)) {
            c9056a.appVersion = "";
        }
        c9056a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c9056a.appName)) {
            c9056a.appName = "";
        }
        c9056a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c9056a.appId)) {
            c9056a.appId = "";
        }
        c9056a.f29115WS = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c9056a.f29115WS)) {
            c9056a.f29115WS = "";
        }
        c9056a.f29116WT = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c9056a.f29116WT)) {
            c9056a.f29116WT = "";
        }
        c9056a.model = jSONObject.optString(C2624bk.f8685i);
        if (JSONObject.NULL.toString().equals(c9056a.model)) {
            c9056a.model = "";
        }
        c9056a.f29117WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c9056a.f29117WU)) {
            c9056a.f29117WU = "";
        }
        c9056a.f29118WV = jSONObject.optInt("osType");
        c9056a.f29119WW = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c9056a.f29119WW)) {
            c9056a.f29119WW = "";
        }
        c9056a.f29120WX = jSONObject.optInt("osApi");
        c9056a.f29121WY = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c9056a.f29121WY)) {
            c9056a.f29121WY = "";
        }
        c9056a.f29122WZ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c9056a.f29122WZ)) {
            c9056a.f29122WZ = "";
        }
        c9056a.f29123Xa = jSONObject.optInt("screenWidth");
        c9056a.f29124Xb = jSONObject.optInt("screenHeight");
        c9056a.f29125Xc = jSONObject.optInt("statusBarHeight");
        c9056a.f29126Xd = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26841b(C9055af.C9056a c9056a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9056a.f29111WO;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "SDKVersion", c9056a.f29111WO);
        }
        int i = c9056a.f29112WP;
        if (i != 0) {
            C11126t.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c9056a.f29113WQ;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "sdkApiVersion", c9056a.f29113WQ);
        }
        int i2 = c9056a.f29114WR;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c9056a.sdkType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "sdkType", i3);
        }
        String str3 = c9056a.appVersion;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "appVersion", c9056a.appVersion);
        }
        String str4 = c9056a.appName;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "appName", c9056a.appName);
        }
        String str5 = c9056a.appId;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "appId", c9056a.appId);
        }
        String str6 = c9056a.f29115WS;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "networkType", c9056a.f29115WS);
        }
        String str7 = c9056a.f29116WT;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "manufacturer", c9056a.f29116WT);
        }
        String str8 = c9056a.model;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, C2624bk.f8685i, c9056a.model);
        }
        String str9 = c9056a.f29117WU;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "deviceBrand", c9056a.f29117WU);
        }
        int i4 = c9056a.f29118WV;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "osType", i4);
        }
        String str10 = c9056a.f29119WW;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "systemVersion", c9056a.f29119WW);
        }
        int i5 = c9056a.f29120WX;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "osApi", i5);
        }
        String str11 = c9056a.f29121WY;
        if (str11 != null && !str11.equals("")) {
            C11126t.putValue(jSONObject, "language", c9056a.f29121WY);
        }
        String str12 = c9056a.f29122WZ;
        if (str12 != null && !str12.equals("")) {
            C11126t.putValue(jSONObject, "locale", c9056a.f29122WZ);
        }
        int i6 = c9056a.f29123Xa;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c9056a.f29124Xb;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "screenHeight", i7);
        }
        int i8 = c9056a.f29125Xc;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c9056a.f29126Xd;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }
}
