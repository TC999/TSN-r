package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf implements q {
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i4, final p pVar) {
        DownloadInfo a4;
        if (aVar == null || aVar.dn() || !ok(aVar)) {
            return false;
        }
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
        if (curBytes > 0 && totalBytes > 0) {
            int ok2 = com.ss.android.downloadlib.addownload.k.ok(a4.getId(), (int) ((curBytes * 100) / totalBytes));
            if (ok2 > ok(aVar.zz())) {
                ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.kf.1
                    @Override // com.ss.android.downloadlib.addownload.ok.s
                    public void a() {
                        com.ss.android.downloadlib.addownload.ok.s unused = kf.ok = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
                        pVar.ok(aVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.ok.s
                    public void ok() {
                        com.ss.android.downloadlib.addownload.ok.s unused = kf.ok = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
                    }
                };
                TTDelegateActivity.a(aVar, String.format("\u5df2\u4e0b\u8f7d%s%%\uff0c\u5373\u5c06\u4e0b\u8f7d\u5b8c\u6210\uff0c\u662f\u5426\u7ee7\u7eed\u4e0b\u8f7d\uff1f", Integer.valueOf(ok2)), "\u7ee7\u7eed", "\u6682\u505c");
                aVar.t(true);
                return true;
            }
        }
        return false;
    }

    private int ok(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("pause_optimise_download_percent", 50);
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("pause_optimise_download_percent_switch", 0) == 1 && okVar.x();
    }
}
