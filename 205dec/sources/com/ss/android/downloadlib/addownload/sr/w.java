package com.ss.android.downloadlib.addownload.sr;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements r {

    /* renamed from: c  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.sr f48657c;

    /* renamed from: w  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.xv f48658w;

    public static com.ss.android.downloadlib.addownload.c.xv w() {
        return f48658w;
    }

    public static com.ss.android.downloadlib.addownload.c.sr c() {
        return f48657c;
    }

    public static void c(com.ss.android.downloadlib.addownload.c.xv xvVar) {
        f48658w = xvVar;
    }

    @Override // com.ss.android.downloadlib.addownload.sr.r
    public boolean c(final com.ss.android.downloadad.api.c.w wVar, int i4, final ev evVar, final com.ss.android.downloadlib.addownload.c.xv xvVar) {
        DownloadInfo w3;
        if (wVar != null && c(wVar)) {
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
            if (c4 >= 0 && totalBytes > 0) {
                if (totalBytes <= c(wVar.fz())) {
                    final int i5 = (int) (c4 / 1048576);
                    f48657c = new com.ss.android.downloadlib.addownload.c.sr() { // from class: com.ss.android.downloadlib.addownload.sr.w.1
                        @Override // com.ss.android.downloadlib.addownload.c.sr
                        public void c() {
                            com.ss.android.downloadlib.addownload.c.sr unused = w.f48657c = null;
                            w.this.c(i5, i5, wVar, "apk_size_cancel", "confirm");
                        }

                        @Override // com.ss.android.downloadlib.addownload.c.sr
                        public void w() {
                            com.ss.android.downloadlib.addownload.c.sr unused = w.f48657c = null;
                            w.this.c(i5, i5, wVar, "apk_size_cancel", "cancel");
                            evVar.c(wVar);
                        }
                    };
                    String format = String.format("\u8be5\u4e0b\u8f7d\u4efb\u52a1\u4ec5\u9700%s\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", com.ss.android.downloadlib.r.a.c(totalBytes - c4));
                    if (xvVar != null) {
                        c(new com.ss.android.downloadlib.addownload.c.xv() { // from class: com.ss.android.downloadlib.addownload.sr.w.2
                            @Override // com.ss.android.downloadlib.addownload.c.xv
                            public void delete() {
                                com.ss.android.downloadlib.addownload.c.sr unused = w.f48657c = null;
                                w.this.c(i5, i5, wVar, "apk_size_cancel", "delete");
                                xvVar.delete();
                            }
                        });
                    }
                    TTDelegateActivity.c(wVar, format, "\u7ee7\u7eed", "\u6682\u505c", "\u5220\u9664");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private int c(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean c(com.ss.android.downloadad.api.c.c cVar) {
        return com.ss.android.downloadlib.r.ux.c(cVar).c("cancel_pause_optimise_apk_retain_switch", 0) == 1 && cVar.ia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5, com.ss.android.downloadad.api.c.w wVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i4));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i5));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("pause_cancel_optimise", jSONObject, wVar);
    }
}
