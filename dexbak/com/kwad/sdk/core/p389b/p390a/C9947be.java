package com.kwad.sdk.core.p389b.p390a;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.webview.jshandler.C9098as;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.be */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9947be implements InterfaceC10273d<C9098as.C9101b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9098as.C9101b c9101b, JSONObject jSONObject) {
        m27180a(c9101b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9098as.C9101b c9101b, JSONObject jSONObject) {
        return m27179b(c9101b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27180a(C9098as.C9101b c9101b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9101b.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c9101b.appName)) {
            c9101b.appName = "";
        }
        c9101b.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(c9101b.pkgName)) {
            c9101b.pkgName = "";
        }
        c9101b.version = jSONObject.optString(ConstantHelper.LOG_VS);
        if (JSONObject.NULL.toString().equals(c9101b.version)) {
            c9101b.version = "";
        }
        c9101b.versionCode = jSONObject.optInt(TTDownloadField.TT_VERSION_CODE);
        c9101b.f29195XP = jSONObject.optLong("appSize");
        c9101b.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(c9101b.md5)) {
            c9101b.md5 = "";
        }
        c9101b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9101b.url)) {
            c9101b.url = "";
        }
        c9101b.icon = jSONObject.optString(RewardPlus.ICON);
        if (JSONObject.NULL.toString().equals(c9101b.icon)) {
            c9101b.icon = "";
        }
        c9101b.f29196qb = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(c9101b.f29196qb)) {
            c9101b.f29196qb = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27179b(C9098as.C9101b c9101b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9101b.appName;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "appName", c9101b.appName);
        }
        String str2 = c9101b.pkgName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "pkgName", c9101b.pkgName);
        }
        String str3 = c9101b.version;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, c9101b.version);
        }
        int i = c9101b.versionCode;
        if (i != 0) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_VERSION_CODE, i);
        }
        long j = c9101b.f29195XP;
        if (j != 0) {
            C11126t.putValue(jSONObject, "appSize", j);
        }
        String str4 = c9101b.md5;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "md5", c9101b.md5);
        }
        String str5 = c9101b.url;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "url", c9101b.url);
        }
        String str6 = c9101b.icon;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, RewardPlus.ICON, c9101b.icon);
        }
        String str7 = c9101b.f29196qb;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "desc", c9101b.f29196qb);
        }
        return jSONObject;
    }
}
