package com.kwad.sdk.core.p389b.p390a;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.webview.jshandler.C9059ah;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10197kl implements InterfaceC10273d<C9059ah.C9062a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9059ah.C9062a c9062a, JSONObject jSONObject) {
        m26694a(c9062a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9059ah.C9062a c9062a, JSONObject jSONObject) {
        return m26693b(c9062a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26694a(C9059ah.C9062a c9062a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9062a.type = jSONObject.optInt("type");
        c9062a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c9062a.appName)) {
            c9062a.appName = "";
        }
        c9062a.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(c9062a.pkgName)) {
            c9062a.pkgName = "";
        }
        c9062a.version = jSONObject.optString(ConstantHelper.LOG_VS);
        if (JSONObject.NULL.toString().equals(c9062a.version)) {
            c9062a.version = "";
        }
        c9062a.versionCode = jSONObject.optInt(TTDownloadField.TT_VERSION_CODE);
        c9062a.f29132Xg = jSONObject.optInt("appSize");
        c9062a.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(c9062a.md5)) {
            c9062a.md5 = "";
        }
        c9062a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9062a.url)) {
            c9062a.url = "";
        }
        c9062a.f29133Xh = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(c9062a.f29133Xh)) {
            c9062a.f29133Xh = "";
        }
        c9062a.icon = jSONObject.optString(RewardPlus.ICON);
        if (JSONObject.NULL.toString().equals(c9062a.icon)) {
            c9062a.icon = "";
        }
        c9062a.f29138qb = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(c9062a.f29138qb)) {
            c9062a.f29138qb = "";
        }
        c9062a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c9062a.appId)) {
            c9062a.appId = "";
        }
        c9062a.f29134Xi = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(c9062a.f29134Xi)) {
            c9062a.f29134Xi = "";
        }
        c9062a.f29135Xj = jSONObject.optBoolean("disableLandingPageDeepLink");
        c9062a.f29136Xk = jSONObject.optBoolean("isLandscapeSupported");
        c9062a.f29137Xl = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26693b(C9059ah.C9062a c9062a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9062a.type;
        if (i != 0) {
            C11126t.putValue(jSONObject, "type", i);
        }
        String str = c9062a.appName;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "appName", c9062a.appName);
        }
        String str2 = c9062a.pkgName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "pkgName", c9062a.pkgName);
        }
        String str3 = c9062a.version;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, c9062a.version);
        }
        int i2 = c9062a.versionCode;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_VERSION_CODE, i2);
        }
        int i3 = c9062a.f29132Xg;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "appSize", i3);
        }
        String str4 = c9062a.md5;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "md5", c9062a.md5);
        }
        String str5 = c9062a.url;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "url", c9062a.url);
        }
        String str6 = c9062a.f29133Xh;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "appLink", c9062a.f29133Xh);
        }
        String str7 = c9062a.icon;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, RewardPlus.ICON, c9062a.icon);
        }
        String str8 = c9062a.f29138qb;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "desc", c9062a.f29138qb);
        }
        String str9 = c9062a.appId;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "appId", c9062a.appId);
        }
        String str10 = c9062a.f29134Xi;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "marketUri", c9062a.f29134Xi);
        }
        boolean z = c9062a.f29135Xj;
        if (z) {
            C11126t.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = c9062a.f29136Xk;
        if (z2) {
            C11126t.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = c9062a.f29137Xl;
        if (z3) {
            C11126t.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }
}
