package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12352s {
    /* renamed from: ok */
    public static AbstractC12348ok m18107ok(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        C12534ok m17596ok = C12534ok.m17596ok(downloadInfo);
        if (str.equals("v1")) {
            return new C12345k(context, m17596ok, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new C12351r(context, m17596ok, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new C12344j(context, m17596ok, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new C12343h(context, m17596ok, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new C12349p(context, m17596ok, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new C12350q(context, m17596ok, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        } else if (str.equals("custom")) {
            return new C12342bl(context, m17596ok, file.getAbsolutePath(), jSONObject);
        } else {
            if (str.equals("vbi")) {
                IDownloadFileUriProvider downloadFileUriProvider = Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId());
                String m18041s = C12361s.m18068k().m18041s();
                return new C12353z(context, m17596ok, C12293bl.m18431ok(downloadInfo.getId(), downloadFileUriProvider, context, m18041s, new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
            }
            return null;
        }
    }

    /* renamed from: ok */
    public static boolean m18108ok(Context context, String str, JSONObject jSONObject, C12534ok c12534ok) {
        if (context == null || str == null) {
            return false;
        }
        AbstractC12348ok abstractC12348ok = null;
        String m18446a = C12293bl.m18446a();
        if (TextUtils.isEmpty(m18446a) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (C12317n.m18230s() && str.equals("v1")) {
            abstractC12348ok = new C12345k(context, c12534ok, m18446a);
        } else if (C12317n.m18230s() && str.equals("v2")) {
            abstractC12348ok = new C12351r(context, c12534ok, m18446a);
        } else if (C12317n.m18230s() && str.equals("v3")) {
            abstractC12348ok = new C12344j(context, c12534ok, m18446a);
        } else if (C12317n.m18237n() && str.equals("o1")) {
            abstractC12348ok = new C12343h(context, c12534ok, m18446a);
        } else if (C12317n.m18237n() && str.equals("o2")) {
            abstractC12348ok = new C12349p(context, c12534ok, m18446a);
        } else if (C12317n.m18237n() && str.equals("o3")) {
            abstractC12348ok = new C12350q(context, c12534ok, m18446a, m18446a, m18446a);
        } else if (C12317n.m18230s() && str.equals("custom")) {
            abstractC12348ok = new C12342bl(context, c12534ok, m18446a, jSONObject);
        } else if (C12317n.m18230s() && str.equals("vbi")) {
            abstractC12348ok = new C12353z(context, c12534ok, m18446a);
        }
        return abstractC12348ok != null && abstractC12348ok.m18109ok();
    }
}
