package com.kwad.sdk.core.b.a;

import com.mbridge.msdk.foundation.download.database.DownloadModel;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bc implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.aog)) {
            bVar.aog = "";
        }
        bVar.downloadId = jSONObject.optString(DownloadModel.DOWNLOAD_ID);
        if (JSONObject.NULL.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.aoh = jSONObject.optString("apk_package");
        if (JSONObject.NULL.toString().equals(bVar.aoh)) {
            bVar.aoh = "";
        }
        bVar.aoi = jSONObject.optString("apk_name");
        if (JSONObject.NULL.toString().equals(bVar.aoi)) {
            bVar.aoi = "";
        }
        bVar.aoj = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.aok = jSONObject.optLong("apk_cur_size");
        bVar.aol = jSONObject.optInt("apk_install_type");
        bVar.aom = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.aog;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_host", bVar.aog);
        }
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DownloadModel.DOWNLOAD_ID, bVar.downloadId);
        }
        String str4 = bVar.aoh;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_package", bVar.aoh);
        }
        String str5 = bVar.aoi;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_name", bVar.aoi);
        }
        long j4 = bVar.aoj;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_size", j4);
        }
        long j5 = bVar.downloadTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_time", j5);
        }
        long j6 = bVar.aok;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_cur_size", j6);
        }
        int i5 = bVar.aol;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_type", i5);
        }
        int i6 = bVar.aom;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_source", i6);
        }
        return jSONObject;
    }
}
