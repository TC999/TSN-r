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

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd {
    public static boolean c(int i4) {
        return i4 == 0 || i4 == 1;
    }

    public static boolean c(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean w(int i4) {
        return i4 == 2 || i4 == 1;
    }

    public static boolean w(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean c(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int c(@NonNull com.ss.android.downloadlib.addownload.w.ux uxVar, boolean z3, com.ss.android.socialbase.appdownloader.f fVar) {
        int i4;
        if (fVar == null || TextUtils.isEmpty(fVar.c()) || fVar.getContext() == null) {
            return 0;
        }
        try {
            i4 = c(fVar, fVar.c());
        } catch (Throwable th) {
            k.u().c(th, "redirectSavePathIfPossible");
            i4 = 4;
        }
        fVar.c(i4);
        if (i4 == 0) {
            fVar.c(new com.ss.android.downloadlib.xv.c());
        }
        if (!fVar.ng()) {
            fVar.c(new com.ss.android.downloadlib.xv.w());
        }
        int c4 = com.ss.android.socialbase.appdownloader.sr.p().c(fVar);
        com.ss.android.downloadad.api.c.w c5 = c(uxVar, c4);
        com.ss.android.downloadlib.addownload.w.f.c().c(c5);
        c5.r(c4);
        c5.ev(System.currentTimeMillis());
        c5.gd(0L);
        com.ss.android.socialbase.downloader.r.c c6 = com.ss.android.socialbase.downloader.r.c.c(fVar.fm());
        if (!c(fVar, c6, c4) && uxVar.f48723w.isShowToast()) {
            String startToast = uxVar.f48723w.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = c6.xv("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z3 ? "\u5df2\u5f00\u59cb\u4e0b\u8f7d\uff0c\u53ef\u5728\"\u6211\u7684\"\u91cc\u67e5\u770b\u7ba1\u7406" : "\u5df2\u5f00\u59cb\u4e0b\u8f7d";
            }
            k.xv().c(2, fVar.getContext(), uxVar.f48723w, startToast, null, 0);
        }
        return c4;
    }

    private static com.ss.android.downloadad.api.c.w c(com.ss.android.downloadlib.addownload.w.ux uxVar, int i4) {
        com.ss.android.downloadad.api.c.w wVar = new com.ss.android.downloadad.api.c.w(uxVar.f48723w, uxVar.xv, uxVar.sr, i4);
        boolean z3 = true;
        if (com.ss.android.socialbase.downloader.r.c.c(i4).c("download_event_opt", 1) > 1) {
            try {
                String packageName = uxVar.f48723w.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (k.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z3 = false;
                    }
                    wVar.ev(z3);
                }
            } catch (Throwable unused) {
            }
        }
        return wVar;
    }

    private static boolean c(com.ss.android.socialbase.appdownloader.f fVar, @NonNull com.ss.android.socialbase.downloader.r.c cVar, int i4) {
        String optString;
        JSONArray ux = cVar.ux("ah_plans");
        if (ux != null && ux.length() != 0) {
            int length = ux.length();
            JSONObject jSONObject = null;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    JSONObject optJSONObject = ux.optJSONObject(i5);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.f.c.c(optJSONObject))) {
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
                                if (com.ss.android.socialbase.appdownloader.w.c(optJSONObject, cVar).f49036w == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 2:
                                jSONObject = optJSONObject;
                                continue;
                            case 6:
                                if (com.ss.android.socialbase.appdownloader.w.w(optJSONObject, cVar).f49036w == 0) {
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
                    return com.ss.android.socialbase.appdownloader.w.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), (Intent) null, jSONObject, i4, new com.ss.android.socialbase.appdownloader.c());
                }
            }
        }
        return false;
    }

    public static String c(DownloadInfo downloadInfo) {
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

    private static int c(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(fVar.fm());
        JSONObject sr = c4.sr("download_dir");
        if (sr == null || TextUtils.isEmpty(sr.optString("dir_name"))) {
            return -1;
        }
        String w3 = fVar.w();
        String bw = fVar.bw();
        if (TextUtils.isEmpty(bw)) {
            bw = com.ss.android.socialbase.appdownloader.xv.c(str, w3, fVar.a(), true);
        }
        if (bw.length() > 255) {
            bw = bw.substring(bw.length() - 255);
        }
        if (TextUtils.isEmpty(w3)) {
            w3 = bw;
        }
        String xv = fVar.xv();
        if (TextUtils.isEmpty(xv)) {
            xv = com.ss.android.socialbase.appdownloader.xv.w();
        }
        String str2 = xv + File.separator + com.ss.android.socialbase.appdownloader.xv.c(w3, c4);
        DownloadInfo c5 = com.ss.android.socialbase.appdownloader.sr.p().c(fVar.getContext(), str);
        if (c5 != null && c5.isSavePathRedirected()) {
            fVar.xv(c5.getSavePath());
            try {
                fVar.c(new JSONObject(c5.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        } else if (c5 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.sr.p().c(bw, fVar.a()))) {
            return c5 != null ? 8 : 9;
        } else {
            int c6 = com.ss.android.socialbase.appdownloader.w.c(c4);
            if (c6 == 0) {
                fVar.xv(str2);
                return c6;
            }
            return c6;
        }
    }
}
