package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements h {

    /* renamed from: a  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ok.bl f48622a;
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.bl a() {
        return f48622a;
    }

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.bl blVar) {
        f48622a = blVar;
    }

    @Override // com.ss.android.downloadlib.addownload.s.h
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i4, final p pVar, final com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo a4;
        String format;
        if (aVar != null && ok(aVar)) {
            if (!TextUtils.isEmpty(aVar.ld())) {
                a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
            } else {
                a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
            }
            if (a4 == null) {
                return false;
            }
            long curBytes = a4.getCurBytes();
            long totalBytes = a4.getTotalBytes();
            if (curBytes < 0 || totalBytes <= 0) {
                return false;
            }
            final int ok2 = com.ss.android.downloadlib.addownload.k.ok(a4.getId(), (int) ((100 * curBytes) / totalBytes));
            final int i5 = (int) (curBytes / 1048576);
            boolean z3 = ok2 > ok(aVar.zz());
            ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.bl.1
                @Override // com.ss.android.downloadlib.addownload.ok.s
                public void a() {
                    com.ss.android.downloadlib.addownload.ok.s unused = bl.ok = null;
                    bl.this.ok(ok2, i5, i5, aVar, "download_percent_cancel", "cancel");
                    pVar.ok(aVar);
                }

                @Override // com.ss.android.downloadlib.addownload.ok.s
                public void ok() {
                    com.ss.android.downloadlib.addownload.ok.s unused = bl.ok = null;
                    bl.this.ok(ok2, i5, i5, aVar, "download_percent_cancel", "confirm");
                }
            };
            String ok3 = com.ss.android.downloadlib.h.j.ok(com.ss.android.downloadlib.addownload.k.ok(aVar.zz(), curBytes, totalBytes));
            if (z3) {
                format = String.format("\u8be5\u4efb\u52a1\u5df2\u4e0b\u8f7d%s\uff0c\u4ec5\u9700%s\u5373\u53ef\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\uff1f", ok3, com.ss.android.downloadlib.h.j.ok(totalBytes - curBytes));
            } else {
                format = String.format("\u8be5\u4efb\u52a1\u5df2\u4e0b\u8f7d%s\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", ok3);
            }
            String str = format;
            if (blVar != null) {
                ok(new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.s.bl.2
                    @Override // com.ss.android.downloadlib.addownload.ok.bl
                    public void delete() {
                        com.ss.android.downloadlib.addownload.ok.s unused = bl.ok = null;
                        bl.this.ok(ok2, i5, i5, aVar, "download_percent_cancel", "delete");
                        blVar.delete();
                    }
                });
            }
            TTDelegateActivity.a(aVar, str, "\u7ee7\u7eed", "\u6682\u505c", "\u5220\u9664");
            return true;
        }
        return false;
    }

    private int ok(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && okVar.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, int i6, com.ss.android.downloadad.api.ok.a aVar, String str, String str2) {
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
        com.ss.android.downloadlib.s.ok.ok().ok("pause_cancel_optimise", jSONObject, aVar);
    }
}
