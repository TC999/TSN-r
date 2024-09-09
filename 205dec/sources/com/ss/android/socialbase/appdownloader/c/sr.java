package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {
    public static c c(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo);
        if (str.equals(EventMonitor.V1_STAGING_ADLOG)) {
            return new p(context, c4, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new k(context, c4, file.getAbsolutePath());
        }
        if (str.equals(EventMonitor.V3_STAGING_ADLOG)) {
            return new a(context, c4, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new r(context, c4, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new ev(context, c4, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new gd(context, c4, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        } else if (str.equals("custom")) {
            return new xv(context, c4, file.getAbsolutePath(), jSONObject);
        } else {
            if (str.equals("vbi")) {
                IDownloadFileUriProvider downloadFileUriProvider = Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId());
                String sr = com.ss.android.socialbase.appdownloader.sr.p().sr();
                return new bk(context, c4, com.ss.android.socialbase.appdownloader.xv.c(downloadInfo.getId(), downloadFileUriProvider, context, sr, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
            }
            return null;
        }
    }

    public static boolean c(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.r.c cVar) {
        if (context == null || str == null) {
            return false;
        }
        c cVar2 = null;
        String w3 = com.ss.android.socialbase.appdownloader.xv.w();
        if (TextUtils.isEmpty(w3) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.f.ux.sr() && str.equals(EventMonitor.V1_STAGING_ADLOG)) {
            cVar2 = new p(context, cVar, w3);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.sr() && str.equals("v2")) {
            cVar2 = new k(context, cVar, w3);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.sr() && str.equals(EventMonitor.V3_STAGING_ADLOG)) {
            cVar2 = new a(context, cVar, w3);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.ux() && str.equals("o1")) {
            cVar2 = new r(context, cVar, w3);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.ux() && str.equals("o2")) {
            cVar2 = new ev(context, cVar, w3);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.ux() && str.equals("o3")) {
            cVar2 = new gd(context, cVar, w3, w3, w3);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.sr() && str.equals("custom")) {
            cVar2 = new xv(context, cVar, w3, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.f.ux.sr() && str.equals("vbi")) {
            cVar2 = new bk(context, cVar, w3);
        }
        return cVar2 != null && cVar2.c();
    }
}
