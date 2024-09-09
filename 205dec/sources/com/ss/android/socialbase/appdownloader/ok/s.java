package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    public static ok ok(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo);
        if (str.equals(EventMonitor.V1_STAGING_ADLOG)) {
            return new k(context, ok, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new r(context, ok, file.getAbsolutePath());
        }
        if (str.equals(EventMonitor.V3_STAGING_ADLOG)) {
            return new j(context, ok, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new h(context, ok, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new p(context, ok, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new q(context, ok, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        } else if (str.equals("custom")) {
            return new bl(context, ok, file.getAbsolutePath(), jSONObject);
        } else {
            if (str.equals("vbi")) {
                IDownloadFileUriProvider downloadFileUriProvider = Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId());
                String s3 = com.ss.android.socialbase.appdownloader.s.k().s();
                return new z(context, ok, com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo.getId(), downloadFileUriProvider, context, s3, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
            }
            return null;
        }
    }

    public static boolean ok(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.h.ok okVar) {
        if (context == null || str == null) {
            return false;
        }
        ok okVar2 = null;
        String a4 = com.ss.android.socialbase.appdownloader.bl.a();
        if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals(EventMonitor.V1_STAGING_ADLOG)) {
            okVar2 = new k(context, okVar, a4);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals("v2")) {
            okVar2 = new r(context, okVar, a4);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals(EventMonitor.V3_STAGING_ADLOG)) {
            okVar2 = new j(context, okVar, a4);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.n() && str.equals("o1")) {
            okVar2 = new h(context, okVar, a4);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.n() && str.equals("o2")) {
            okVar2 = new p(context, okVar, a4);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.n() && str.equals("o3")) {
            okVar2 = new q(context, okVar, a4, a4, a4);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals("custom")) {
            okVar2 = new bl(context, okVar, a4, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals("vbi")) {
            okVar2 = new z(context, okVar, a4);
        }
        return okVar2 != null && okVar2.ok();
    }
}
