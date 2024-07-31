package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9999dc implements InterfaceC10273d<DownloadParams> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(DownloadParams downloadParams, JSONObject jSONObject) {
        m27084a(downloadParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(DownloadParams downloadParams, JSONObject jSONObject) {
        return m27083b(downloadParams, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27084a(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        if (JSONObject.NULL.toString().equals(downloadParams.mDownloadid)) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (JSONObject.NULL.toString().equals(downloadParams.mAppName)) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (JSONObject.NULL.toString().equals(downloadParams.mPkgname)) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (JSONObject.NULL.toString().equals(downloadParams.mVersion)) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (JSONObject.NULL.toString().equals(downloadParams.mVersionCode)) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (JSONObject.NULL.toString().equals(downloadParams.mFileMd5)) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (JSONObject.NULL.toString().equals(downloadParams.mFileUrl)) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (JSONObject.NULL.toString().equals(downloadParams.mAppIcon)) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (JSONObject.NULL.toString().equals(downloadParams.mShortDesc)) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString(TTDownloadField.TT_FILE_PATH);
        if (JSONObject.NULL.toString().equals(downloadParams.filePath)) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27083b(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadParams.mDownloadid;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        String str2 = downloadParams.mAppName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        String str3 = downloadParams.mPkgname;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        String str4 = downloadParams.mVersion;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        String str5 = downloadParams.mVersionCode;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        long j = downloadParams.mAppSize;
        if (j != 0) {
            C11126t.putValue(jSONObject, "mAppSize", j);
        }
        String str6 = downloadParams.mFileMd5;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        String str7 = downloadParams.mFileUrl;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        String str8 = downloadParams.mAppIcon;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        String str9 = downloadParams.mShortDesc;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        int i = downloadParams.mTaskId;
        if (i != 0) {
            C11126t.putValue(jSONObject, "mTaskId", i);
        }
        String str10 = downloadParams.filePath;
        if (str10 != null && !str10.equals("")) {
            C11126t.putValue(jSONObject, TTDownloadField.TT_FILE_PATH, downloadParams.filePath);
        }
        boolean z = downloadParams.requestInstallPermission;
        if (z) {
            C11126t.putValue(jSONObject, "requestInstallPermission", z);
        }
        boolean z2 = downloadParams.downloadEnablePause;
        if (z2) {
            C11126t.putValue(jSONObject, "downloadEnablePause", z2);
        }
        int i2 = downloadParams.downloadPlace;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "downloadPlace", i2);
        }
        return jSONObject;
    }
}
