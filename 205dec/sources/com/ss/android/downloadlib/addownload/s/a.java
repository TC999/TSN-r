package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ok.bl f48615a;
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.bl a() {
        return f48615a;
    }

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.bl blVar) {
        f48615a = blVar;
    }

    @Override // com.ss.android.downloadlib.addownload.s.h
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i4, final p pVar, final com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo a4;
        if (aVar != null && ok(aVar)) {
            if (!TextUtils.isEmpty(aVar.ld())) {
                a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
            } else {
                a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
            }
            if (a4 == null) {
                return false;
            }
            long ok2 = com.ss.android.downloadlib.addownload.k.ok(a4.getId(), a4.getCurBytes(), a4.getTotalBytes());
            long totalBytes = a4.getTotalBytes();
            if (ok2 >= 0 && totalBytes > 0) {
                if (totalBytes <= ok(aVar.zz())) {
                    final int i5 = (int) (ok2 / 1048576);
                    ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.a.1
                        @Override // com.ss.android.downloadlib.addownload.ok.s
                        public void a() {
                            com.ss.android.downloadlib.addownload.ok.s unused = a.ok = null;
                            a.this.ok(i5, i5, aVar, "apk_size_cancel", "cancel");
                            pVar.ok(aVar);
                        }

                        @Override // com.ss.android.downloadlib.addownload.ok.s
                        public void ok() {
                            com.ss.android.downloadlib.addownload.ok.s unused = a.ok = null;
                            a.this.ok(i5, i5, aVar, "apk_size_cancel", "confirm");
                        }
                    };
                    String format = String.format("\u8be5\u4e0b\u8f7d\u4efb\u52a1\u4ec5\u9700%s\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", com.ss.android.downloadlib.h.j.ok(totalBytes - ok2));
                    if (blVar != null) {
                        ok(new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.s.a.2
                            @Override // com.ss.android.downloadlib.addownload.ok.bl
                            public void delete() {
                                com.ss.android.downloadlib.addownload.ok.s unused = a.ok = null;
                                a.this.ok(i5, i5, aVar, "apk_size_cancel", "delete");
                                blVar.delete();
                            }
                        });
                    }
                    TTDelegateActivity.ok(aVar, format, "\u7ee7\u7eed", "\u6682\u505c", "\u5220\u9664");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private int ok(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("cancel_pause_optimise_apk_retain_switch", 0) == 1 && okVar.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, com.ss.android.downloadad.api.ok.a aVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i4));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i5));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("pause_cancel_optimise", jSONObject, aVar);
    }
}
