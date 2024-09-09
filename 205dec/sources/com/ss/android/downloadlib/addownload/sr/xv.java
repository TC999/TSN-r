package com.ss.android.downloadlib.addownload.sr;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements r {

    /* renamed from: c  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.sr f48663c;

    /* renamed from: w  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.c.xv f48664w;

    public static com.ss.android.downloadlib.addownload.c.xv w() {
        return f48664w;
    }

    public static com.ss.android.downloadlib.addownload.c.sr c() {
        return f48663c;
    }

    public static void c(com.ss.android.downloadlib.addownload.c.xv xvVar) {
        f48664w = xvVar;
    }

    @Override // com.ss.android.downloadlib.addownload.sr.r
    public boolean c(final com.ss.android.downloadad.api.c.w wVar, int i4, final ev evVar, final com.ss.android.downloadlib.addownload.c.xv xvVar) {
        DownloadInfo w3;
        String format;
        if (wVar != null && c(wVar)) {
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
            if (curBytes < 0 || totalBytes <= 0) {
                return false;
            }
            final int c4 = com.ss.android.downloadlib.addownload.p.c(w3.getId(), (int) ((100 * curBytes) / totalBytes));
            final int i5 = (int) (curBytes / 1048576);
            boolean z3 = c4 > c(wVar.fz());
            f48663c = new com.ss.android.downloadlib.addownload.c.sr() { // from class: com.ss.android.downloadlib.addownload.sr.xv.1
                @Override // com.ss.android.downloadlib.addownload.c.sr
                public void c() {
                    com.ss.android.downloadlib.addownload.c.sr unused = xv.f48663c = null;
                    xv.this.c(c4, i5, i5, wVar, "download_percent_cancel", "confirm");
                }

                @Override // com.ss.android.downloadlib.addownload.c.sr
                public void w() {
                    com.ss.android.downloadlib.addownload.c.sr unused = xv.f48663c = null;
                    xv.this.c(c4, i5, i5, wVar, "download_percent_cancel", "cancel");
                    evVar.c(wVar);
                }
            };
            String c5 = com.ss.android.downloadlib.r.a.c(com.ss.android.downloadlib.addownload.p.c(wVar.fz(), curBytes, totalBytes));
            if (z3) {
                format = String.format("\u8be5\u4efb\u52a1\u5df2\u4e0b\u8f7d%s\uff0c\u4ec5\u9700%s\u5373\u53ef\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\uff1f", c5, com.ss.android.downloadlib.r.a.c(totalBytes - curBytes));
            } else {
                format = String.format("\u8be5\u4efb\u52a1\u5df2\u4e0b\u8f7d%s\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", c5);
            }
            String str = format;
            if (xvVar != null) {
                c(new com.ss.android.downloadlib.addownload.c.xv() { // from class: com.ss.android.downloadlib.addownload.sr.xv.2
                    @Override // com.ss.android.downloadlib.addownload.c.xv
                    public void delete() {
                        com.ss.android.downloadlib.addownload.c.sr unused = xv.f48663c = null;
                        xv.this.c(c4, i5, i5, wVar, "download_percent_cancel", "delete");
                        xvVar.delete();
                    }
                });
            }
            TTDelegateActivity.w(wVar, str, "\u7ee7\u7eed", "\u6682\u505c", "\u5220\u9664");
            return true;
        }
        return false;
    }

    private int c(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean c(com.ss.android.downloadad.api.c.c cVar) {
        return com.ss.android.downloadlib.r.ux.c(cVar).c("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && cVar.ia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5, int i6, com.ss.android.downloadad.api.c.w wVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i4));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i5));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i6));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("pause_cancel_optimise", jSONObject, wVar);
    }
}
