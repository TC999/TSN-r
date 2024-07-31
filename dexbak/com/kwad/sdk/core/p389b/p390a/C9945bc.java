package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p372a.C9814b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9945bc implements InterfaceC10273d<C9814b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9814b c9814b, JSONObject jSONObject) {
        m27184a(c9814b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9814b c9814b, JSONObject jSONObject) {
        return m27183b(c9814b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27184a(C9814b c9814b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9814b.status = jSONObject.optInt("status");
        c9814b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9814b.url)) {
            c9814b.url = "";
        }
        c9814b.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(c9814b.aog)) {
            c9814b.aog = "";
        }
        c9814b.downloadId = jSONObject.optString(DownloadModel.DOWNLOAD_ID);
        if (JSONObject.NULL.toString().equals(c9814b.downloadId)) {
            c9814b.downloadId = "";
        }
        c9814b.aoh = jSONObject.optString("apk_package");
        if (JSONObject.NULL.toString().equals(c9814b.aoh)) {
            c9814b.aoh = "";
        }
        c9814b.aoi = jSONObject.optString("apk_name");
        if (JSONObject.NULL.toString().equals(c9814b.aoi)) {
            c9814b.aoi = "";
        }
        c9814b.aoj = jSONObject.optLong("apk_size");
        c9814b.downloadTime = jSONObject.optLong("download_time");
        c9814b.aok = jSONObject.optLong("apk_cur_size");
        c9814b.aol = jSONObject.optInt("apk_install_type");
        c9814b.aom = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27183b(C9814b c9814b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9814b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str = c9814b.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9814b.url);
        }
        String str2 = c9814b.aog;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url_host", c9814b.aog);
        }
        String str3 = c9814b.downloadId;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, DownloadModel.DOWNLOAD_ID, c9814b.downloadId);
        }
        String str4 = c9814b.aoh;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "apk_package", c9814b.aoh);
        }
        String str5 = c9814b.aoi;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "apk_name", c9814b.aoi);
        }
        long j = c9814b.aoj;
        if (j != 0) {
            C11126t.putValue(jSONObject, "apk_size", j);
        }
        long j2 = c9814b.downloadTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "download_time", j2);
        }
        long j3 = c9814b.aok;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "apk_cur_size", j3);
        }
        int i2 = c9814b.aol;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "apk_install_type", i2);
        }
        int i3 = c9814b.aom;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "apk_install_source", i3);
        }
        return jSONObject;
    }
}
