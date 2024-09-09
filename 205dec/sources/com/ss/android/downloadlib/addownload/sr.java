package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.ux;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private Handler f48633c;

    /* renamed from: w  reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.w.ux f48634w;
    private AtomicBoolean xv = new AtomicBoolean(false);
    private AtomicBoolean sr = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr(Handler handler) {
        this.f48633c = handler;
    }

    private static long sr() {
        return com.ss.android.downloadlib.r.a.w(0L);
    }

    public static long w() {
        if (k.bk() != null) {
            return k.bk().c();
        }
        return 0L;
    }

    static /* synthetic */ long xv() {
        return sr();
    }

    private void w(com.ss.android.downloadad.api.c.w wVar, JSONObject jSONObject, long j4, long j5) {
        wVar.a("1");
        com.ss.android.downloadlib.addownload.w.gd.c().c(wVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j5 - j4));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("cleanspace_download_after_quite_clean", jSONObject, wVar);
    }

    public void c(com.ss.android.downloadlib.addownload.w.ux uxVar) {
        this.f48634w = uxVar;
    }

    public boolean c() {
        return this.sr.get();
    }

    public void c(boolean z3) {
        this.sr.set(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final int i4, final long j4, long j5, final ux.c cVar) {
        this.sr.set(false);
        if (cVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.r.ux.f(i4) && com.ss.android.downloadlib.r.ux.ux(i4)) {
            long xv = com.ss.android.downloadlib.r.ux.xv(i4);
            this.xv.set(false);
            final String downloadUrl = this.f48634w.f48723w.getDownloadUrl();
            com.ss.android.downloadad.api.c.w w3 = com.ss.android.downloadlib.addownload.w.f.c().w(downloadUrl);
            if (w3 == null) {
                com.ss.android.downloadlib.addownload.w.ux uxVar = this.f48634w;
                w3 = new com.ss.android.downloadad.api.c.w(uxVar.f48723w, uxVar.xv, uxVar.sr, 0);
                com.ss.android.downloadlib.addownload.w.f.c().c(w3);
            }
            final com.ss.android.downloadad.api.c.w wVar = w3;
            wVar.ux(false);
            if (k.bk() != null) {
                k.bk().c(wVar.w());
            }
            com.ss.android.downloadlib.addownload.xv.sr.c().c(wVar.c());
            boolean sr = com.ss.android.downloadlib.r.ux.sr(i4);
            if (j5 > 0) {
                c(i4, downloadUrl, j5, wVar, j4, cVar);
            } else if (sr) {
                c(downloadUrl, wVar, new ux.w() { // from class: com.ss.android.downloadlib.addownload.sr.1
                    @Override // com.ss.android.downloadlib.addownload.ux.w
                    public void c(long j6) {
                        sr.this.c(i4, downloadUrl, j6, wVar, j4, cVar);
                    }
                });
            } else {
                xv = 0;
            }
            this.f48633c.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.sr.2
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.xv.get()) {
                        return;
                    }
                    sr.this.xv.set(true);
                    cVar.c();
                }
            }, xv);
            return;
        }
        cVar.c();
    }

    private void c(String str, com.ss.android.downloadad.api.c.w wVar, final ux.w wVar2) {
        if (wVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.c.w.c(str, new com.ss.android.socialbase.downloader.network.p() { // from class: com.ss.android.downloadlib.addownload.sr.3
            public void c(Map<String, String> map) {
                if (sr.this.xv.get()) {
                    return;
                }
                sr.this.xv.set(true);
                long c4 = sr.this.c(map);
                if (c4 > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(c4));
                        jSONObject.putOpt("available_space", Long.valueOf(sr.xv()));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                wVar2.c(c4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(entry.getKey())) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, String str, long j4, final com.ss.android.downloadad.api.c.w wVar, long j5, final ux.c cVar) {
        this.xv.set(true);
        boolean z3 = false;
        if (j4 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j4));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            double d4 = j4;
            Double.isNaN(d4);
            long longValue = (Double.valueOf((com.ss.android.downloadlib.r.ux.c(i4) + 1.0d) * d4).longValue() + com.ss.android.downloadlib.r.ux.w(i4)) - j5;
            long sr = sr();
            if (sr < longValue) {
                c(wVar, jSONObject, longValue, sr);
                c(wVar);
                long sr2 = sr();
                if (sr2 < longValue) {
                    wVar.sr(true);
                    final String c4 = wVar.c();
                    com.ss.android.downloadlib.addownload.xv.sr.c().c(c4, new com.ss.android.downloadlib.addownload.xv.ux() { // from class: com.ss.android.downloadlib.addownload.sr.4
                    });
                    z3 = c(i4, wVar, str, longValue);
                    if (z3) {
                        wVar.ux(true);
                    }
                } else {
                    w(wVar, jSONObject, sr, sr2);
                }
            }
        }
        if (z3) {
            return;
        }
        this.f48633c.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.sr.5
            @Override // java.lang.Runnable
            public void run() {
                cVar.c();
            }
        });
    }

    private boolean c(int i4, @NonNull com.ss.android.downloadad.api.c.w wVar, String str, long j4) {
        if (com.ss.android.downloadlib.r.ux.f(i4)) {
            if (k.bk() != null) {
                return k.bk().c(i4, str, true, j4);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("show_dialog_result", 3);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.ss.android.downloadlib.sr.c.c().c("cleanspace_window_show", jSONObject, wVar);
            return false;
        }
        return false;
    }

    public static boolean c(final DownloadInfo downloadInfo, long j4) {
        int id = downloadInfo.getId();
        boolean z3 = false;
        if (com.ss.android.downloadlib.r.ux.f(id)) {
            if (k.bk() != null && (z3 = k.bk().c(id, downloadInfo.getUrl(), false, j4))) {
                com.ss.android.downloadlib.addownload.xv.sr.c().c(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.xv.ux() { // from class: com.ss.android.downloadlib.addownload.sr.6
                });
            }
            return z3;
        }
        return false;
    }

    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static void c(int i4) {
        if (com.ss.android.downloadlib.r.ux.f(i4) && k.bk() != null && k.bk().w()) {
            k.bk().xv();
        }
    }

    private static void c(com.ss.android.downloadad.api.c.w wVar) {
        long sr = sr();
        if (k.bk() != null) {
            k.bk().ux();
        }
        com.ss.android.downloadlib.addownload.xv.xv.c();
        com.ss.android.downloadlib.addownload.xv.xv.w();
        if (com.ss.android.downloadlib.r.ux.r(wVar.fz())) {
            com.ss.android.downloadlib.addownload.xv.xv.c(k.getContext());
        }
        long sr2 = sr();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(sr2 - sr));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("clean_quite_finish", jSONObject, wVar);
    }

    private void c(com.ss.android.downloadad.api.c.w wVar, JSONObject jSONObject, long j4, long j5) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j5));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j4));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("clean_space_no_enough_for_download", jSONObject, wVar);
    }
}
