package com.ss.android.downloadlib.addownload.sr;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f implements gd {

    /* renamed from: c  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.sr f48650c;

    public static com.ss.android.downloadlib.addownload.c.sr c() {
        return f48650c;
    }

    @Override // com.ss.android.downloadlib.addownload.sr.gd
    public boolean c(final com.ss.android.downloadad.api.c.w wVar, int i4, final ev evVar) {
        DownloadInfo w3;
        if (wVar == null || wVar.oh() || !c(wVar)) {
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
        long curBytes = w3.getCurBytes();
        long totalBytes = w3.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int c4 = com.ss.android.downloadlib.addownload.p.c(w3.getId(), (int) ((curBytes * 100) / totalBytes));
            if (c4 > c(wVar.fz())) {
                f48650c = new com.ss.android.downloadlib.addownload.c.sr() { // from class: com.ss.android.downloadlib.addownload.sr.f.1
                    @Override // com.ss.android.downloadlib.addownload.c.sr
                    public void c() {
                        com.ss.android.downloadlib.addownload.c.sr unused = f.f48650c = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        com.ss.android.downloadlib.sr.c.c().c("pause_optimise", jSONObject, wVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.c.sr
                    public void w() {
                        com.ss.android.downloadlib.addownload.c.sr unused = f.f48650c = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        com.ss.android.downloadlib.sr.c.c().c("pause_optimise", jSONObject, wVar);
                        evVar.c(wVar);
                    }
                };
                TTDelegateActivity.w(wVar, String.format("\u5df2\u4e0b\u8f7d%s%%\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", Integer.valueOf(c4)), "\u7ee7\u7eed", "\u6682\u505c");
                wVar.ys(true);
                return true;
            }
        }
        return false;
    }

    private int c(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("pause_optimise_download_percent", 50);
    }

    private boolean c(com.ss.android.downloadad.api.c.c cVar) {
        return com.ss.android.downloadlib.r.ux.c(cVar).c("pause_optimise_download_percent_switch", 0) == 1 && cVar.ia();
    }
}
