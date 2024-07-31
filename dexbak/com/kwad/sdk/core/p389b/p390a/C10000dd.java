package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10000dd implements InterfaceC10273d<AdInfo.DownloadSafeInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        m27082a(downloadSafeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        return m27081b(downloadSafeInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27082a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.permissionInfo)) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appName)) {
            downloadSafeInfo.appName = "";
        }
        downloadSafeInfo.corporationName = jSONObject.optString("corporationName");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.corporationName)) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        downloadSafeInfo.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appVersion)) {
            downloadSafeInfo.appVersion = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appPrivacyUrl)) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appPermissionInfoUrl)) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.introductionInfo = jSONObject.optString("introductionInfo");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.introductionInfo)) {
            downloadSafeInfo.introductionInfo = "";
        }
        downloadSafeInfo.introductionInfoUrl = jSONObject.optString("introductionInfoUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.introductionInfoUrl)) {
            downloadSafeInfo.introductionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.windowPopUrl)) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.webPageTipbarText)) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.autoDownloadUrl)) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        AdInfo.ComplianceInfo complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo = complianceInfo;
        complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27081b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadSafeInfo.permissionInfo;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        String str2 = downloadSafeInfo.appName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "appName", downloadSafeInfo.appName);
        }
        String str3 = downloadSafeInfo.corporationName;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "corporationName", downloadSafeInfo.corporationName);
        }
        long j = downloadSafeInfo.packageSize;
        if (j != 0) {
            C11126t.putValue(jSONObject, "packageSize", j);
        }
        String str4 = downloadSafeInfo.appVersion;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "appVersion", downloadSafeInfo.appVersion);
        }
        String str5 = downloadSafeInfo.appPrivacyUrl;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        String str6 = downloadSafeInfo.appPermissionInfoUrl;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        String str7 = downloadSafeInfo.introductionInfo;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "introductionInfo", downloadSafeInfo.introductionInfo);
        }
        String str8 = downloadSafeInfo.introductionInfoUrl;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "introductionInfoUrl", downloadSafeInfo.introductionInfoUrl);
        }
        boolean z = downloadSafeInfo.secWindowPopNoWifiSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "secWindowPopNoWifiSwitch", z);
        }
        boolean z2 = downloadSafeInfo.secWindowPopSwitch;
        if (z2) {
            C11126t.putValue(jSONObject, "secWindowPopSwitch", z2);
        }
        C11126t.putValue(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        String str9 = downloadSafeInfo.windowPopUrl;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        C11126t.putValue(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        String str10 = downloadSafeInfo.webPageTipbarText;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        String str11 = downloadSafeInfo.autoDownloadUrl;
        if (str11 != null && !str11.equals("")) {
            C11126t.putValue(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        C11126t.m23678a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        return jSONObject;
    }
}
