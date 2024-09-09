package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class q {
    public static boolean a(int i4) {
        return i4 == 2 || i4 == 1;
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean ok(int i4) {
        return i4 == 0 || i4 == 1;
    }

    public static boolean ok(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean ok(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar, boolean z3, com.ss.android.socialbase.appdownloader.kf kfVar) {
        int i4;
        if (kfVar == null || TextUtils.isEmpty(kfVar.ok()) || kfVar.getContext() == null) {
            return 0;
        }
        try {
            i4 = ok(kfVar, kfVar.ok());
        } catch (Throwable th) {
            r.u().ok(th, "redirectSavePathIfPossible");
            i4 = 4;
        }
        kfVar.ok(i4);
        if (i4 == 0) {
            kfVar.ok(new com.ss.android.downloadlib.bl.ok());
        }
        if (!kfVar.ew()) {
            kfVar.ok(new com.ss.android.downloadlib.bl.a());
        }
        int ok = com.ss.android.socialbase.appdownloader.s.k().ok(kfVar);
        com.ss.android.downloadad.api.ok.a ok2 = ok(nVar, ok);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(ok2);
        ok2.h(ok);
        ok2.p(System.currentTimeMillis());
        ok2.q(0L);
        com.ss.android.socialbase.downloader.h.ok ok3 = com.ss.android.socialbase.downloader.h.ok.ok(kfVar.to());
        if (!ok(kfVar, ok3, ok) && nVar.f48371a.isShowToast()) {
            String startToast = nVar.f48371a.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = ok3.bl("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z3 ? "\u5df2\u5f00\u59cb\u4e0b\u8f7d\uff0c\u53ef\u5728\"\u6211\u7684\"\u91cc\u67e5\u770b\u7ba1\u7406" : "\u5df2\u5f00\u59cb\u4e0b\u8f7d";
            }
            r.bl().ok(2, kfVar.getContext(), nVar.f48371a, startToast, null, 0);
        }
        return ok;
    }

    private static com.ss.android.downloadad.api.ok.a ok(com.ss.android.downloadlib.addownload.a.n nVar, int i4) {
        com.ss.android.downloadad.api.ok.a aVar = new com.ss.android.downloadad.api.ok.a(nVar.f48371a, nVar.bl, nVar.f48373s, i4);
        boolean z3 = true;
        if (com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("download_event_opt", 1) > 1) {
            try {
                String packageName = nVar.f48371a.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (r.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z3 = false;
                    }
                    aVar.p(z3);
                }
            } catch (Throwable unused) {
            }
        }
        return aVar;
    }

    private static boolean ok(com.ss.android.socialbase.appdownloader.kf kfVar, @NonNull com.ss.android.socialbase.downloader.h.ok okVar, int i4) {
        String optString;
        JSONArray n4 = okVar.n("ah_plans");
        if (n4 != null && n4.length() != 0) {
            int length = n4.length();
            JSONObject jSONObject = null;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    JSONObject optJSONObject = n4.optJSONObject(i5);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.kf.ok.ok(optJSONObject))) {
                        optString.hashCode();
                        char c4 = '\uffff';
                        switch (optString.hashCode()) {
                            case -985763637:
                                if (optString.equals("plan_a")) {
                                    c4 = 0;
                                    break;
                                }
                                break;
                            case -985763636:
                                if (optString.equals("plan_b")) {
                                    c4 = 1;
                                    break;
                                }
                                break;
                            case -985763635:
                                if (optString.equals("plan_c")) {
                                    c4 = 2;
                                    break;
                                }
                                break;
                            case -985763634:
                                if (optString.equals("plan_d")) {
                                    c4 = 3;
                                    break;
                                }
                                break;
                            case -985763633:
                                if (optString.equals("plan_e")) {
                                    c4 = 4;
                                    break;
                                }
                                break;
                            case -985763632:
                                if (optString.equals("plan_f")) {
                                    c4 = 5;
                                    break;
                                }
                                break;
                            case -985763631:
                                if (optString.equals("plan_g")) {
                                    c4 = 6;
                                    break;
                                }
                                break;
                            case -985763630:
                                if (optString.equals("plan_h")) {
                                    c4 = 7;
                                    break;
                                }
                                break;
                        }
                        switch (c4) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                                if (com.ss.android.socialbase.appdownloader.a.ok(optJSONObject, okVar).f49159a == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 2:
                                jSONObject = optJSONObject;
                                continue;
                            case 6:
                                if (com.ss.android.socialbase.appdownloader.a.a(optJSONObject, okVar).f49159a == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                    i5++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.a.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), (Intent) null, jSONObject, i4, new com.ss.android.socialbase.appdownloader.ok());
                }
            }
        }
        return false;
    }

    public static String ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    private static int ok(com.ss.android.socialbase.appdownloader.kf kfVar, String str) {
        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(kfVar.to());
        JSONObject s3 = ok.s("download_dir");
        if (s3 == null || TextUtils.isEmpty(s3.optString("dir_name"))) {
            return -1;
        }
        String a4 = kfVar.a();
        String qu = kfVar.qu();
        if (TextUtils.isEmpty(qu)) {
            qu = com.ss.android.socialbase.appdownloader.bl.ok(str, a4, kfVar.j(), true);
        }
        if (qu.length() > 255) {
            qu = qu.substring(qu.length() - 255);
        }
        if (TextUtils.isEmpty(a4)) {
            a4 = qu;
        }
        String bl = kfVar.bl();
        if (TextUtils.isEmpty(bl)) {
            bl = com.ss.android.socialbase.appdownloader.bl.a();
        }
        String str2 = bl + File.separator + com.ss.android.socialbase.appdownloader.bl.ok(a4, ok);
        DownloadInfo ok2 = com.ss.android.socialbase.appdownloader.s.k().ok(kfVar.getContext(), str);
        if (ok2 != null && ok2.isSavePathRedirected()) {
            kfVar.bl(ok2.getSavePath());
            try {
                kfVar.ok(new JSONObject(ok2.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        } else if (ok2 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.s.k().ok(qu, kfVar.j()))) {
            return ok2 != null ? 8 : 9;
        } else {
            int ok3 = com.ss.android.socialbase.appdownloader.a.ok(ok);
            if (ok3 == 0) {
                kfVar.bl(str2);
                return ok3;
            }
            return ok3;
        }
    }
}
