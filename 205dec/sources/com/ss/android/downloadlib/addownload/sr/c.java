package com.ss.android.downloadlib.addownload.sr;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements gd {

    /* renamed from: c  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.sr f48647c;

    public static com.ss.android.downloadlib.addownload.c.sr c() {
        return f48647c;
    }

    @Override // com.ss.android.downloadlib.addownload.sr.gd
    public boolean c(final com.ss.android.downloadad.api.c.w wVar, int i4, final ev evVar) {
        DownloadInfo w3;
        if (wVar == null || wVar.h() || !c(wVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(wVar.te())) {
            w3 = com.ss.android.downloadlib.ev.c(com.ss.android.downloadlib.addownload.k.getContext()).c(wVar.te(), null, true);
        } else {
            w3 = com.ss.android.downloadlib.ev.c(com.ss.android.downloadlib.addownload.k.getContext()).w(wVar.c());
        }
        if (w3 == null) {
            return false;
        }
        long c4 = com.ss.android.downloadlib.addownload.p.c(w3.getId(), w3.getCurBytes(), w3.getTotalBytes());
        long totalBytes = w3.getTotalBytes();
        if (c4 <= 0 || totalBytes <= 0 || totalBytes > c(wVar.fz())) {
            return false;
        }
        f48647c = new com.ss.android.downloadlib.addownload.c.sr() { // from class: com.ss.android.downloadlib.addownload.sr.c.1
            @Override // com.ss.android.downloadlib.addownload.c.sr
            public void c() {
                com.ss.android.downloadlib.addownload.c.sr unused = c.f48647c = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                com.ss.android.downloadlib.sr.c.c().c("pause_optimise", jSONObject, wVar);
            }

            @Override // com.ss.android.downloadlib.addownload.c.sr
            public void w() {
                com.ss.android.downloadlib.addownload.c.sr unused = c.f48647c = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                com.ss.android.downloadlib.sr.c.c().c("pause_optimise", jSONObject, wVar);
                evVar.c(wVar);
            }
        };
        TTDelegateActivity.c(wVar, String.format("\u8be5\u4e0b\u8f7d\u4efb\u52a1\u4ec5\u9700%s\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", com.ss.android.downloadlib.r.a.c(totalBytes - c4)), "\u7ee7\u7eed", "\u6682\u505c");
        wVar.t(true);
        return true;
    }

    private int c(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean c(com.ss.android.downloadad.api.c.c cVar) {
        return com.ss.android.downloadlib.r.ux.c(cVar).c("pause_optimise_apk_size_switch", 0) == 1 && cVar.ia();
    }
}
