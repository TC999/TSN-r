package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.a.n f48605a;
    private Handler ok;
    private AtomicBoolean bl = new AtomicBoolean(false);

    /* renamed from: s  reason: collision with root package name */
    private AtomicBoolean f48606s = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Handler handler) {
        this.ok = handler;
    }

    public static long a() {
        if (r.z() != null) {
            return r.z().ok();
        }
        return 0L;
    }

    static /* synthetic */ long bl() {
        return s();
    }

    private static long s() {
        return com.ss.android.downloadlib.h.j.a(0L);
    }

    private void a(com.ss.android.downloadad.api.ok.a aVar, JSONObject jSONObject, long j4, long j5) {
        aVar.j("1");
        com.ss.android.downloadlib.addownload.a.q.ok().ok(aVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j5 - j4));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_download_after_quite_clean", jSONObject, aVar);
    }

    public void ok(com.ss.android.downloadlib.addownload.a.n nVar) {
        this.f48605a = nVar;
    }

    public boolean ok() {
        return this.f48606s.get();
    }

    public void ok(boolean z3) {
        this.f48606s.set(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(final int i4, final long j4, long j5, final n.ok okVar) {
        this.f48606s.set(false);
        if (okVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.h.n.kf(i4) && com.ss.android.downloadlib.h.n.n(i4)) {
            long bl = com.ss.android.downloadlib.h.n.bl(i4);
            this.bl.set(false);
            final String downloadUrl = this.f48605a.f48371a.getDownloadUrl();
            com.ss.android.downloadad.api.ok.a a4 = com.ss.android.downloadlib.addownload.a.kf.ok().a(downloadUrl);
            if (a4 == null) {
                com.ss.android.downloadlib.addownload.a.n nVar = this.f48605a;
                a4 = new com.ss.android.downloadad.api.ok.a(nVar.f48371a, nVar.bl, nVar.f48373s, 0);
                com.ss.android.downloadlib.addownload.a.kf.ok().ok(a4);
            }
            final com.ss.android.downloadad.api.ok.a aVar = a4;
            aVar.n(false);
            if (r.z() != null) {
                r.z().ok(aVar.a());
            }
            com.ss.android.downloadlib.addownload.bl.s.ok().ok(aVar.ok());
            boolean s3 = com.ss.android.downloadlib.h.n.s(i4);
            if (j5 > 0) {
                ok(i4, downloadUrl, j5, aVar, j4, okVar);
            } else if (s3) {
                ok(downloadUrl, aVar, new n.a() { // from class: com.ss.android.downloadlib.addownload.s.1
                    @Override // com.ss.android.downloadlib.addownload.n.a
                    public void ok(long j6) {
                        s.this.ok(i4, downloadUrl, j6, aVar, j4, okVar);
                    }
                });
            } else {
                bl = 0;
            }
            this.ok.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.s.2
                @Override // java.lang.Runnable
                public void run() {
                    if (s.this.bl.get()) {
                        return;
                    }
                    s.this.bl.set(true);
                    okVar.ok();
                }
            }, bl);
            return;
        }
        okVar.ok();
    }

    private void ok(String str, com.ss.android.downloadad.api.ok.a aVar, final n.a aVar2) {
        if (aVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.ok.a.ok(str, new com.ss.android.socialbase.downloader.network.k() { // from class: com.ss.android.downloadlib.addownload.s.3
            @Override // com.ss.android.socialbase.downloader.network.k
            public void ok(Map<String, String> map) {
                if (s.this.bl.get()) {
                    return;
                }
                s.this.bl.set(true);
                long ok = s.this.ok(map);
                if (ok > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(ok));
                        jSONObject.putOpt("available_space", Long.valueOf(s.bl()));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                aVar2.ok(ok);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ok(Map<String, String> map) {
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
    public void ok(int i4, String str, long j4, final com.ss.android.downloadad.api.ok.a aVar, long j5, final n.ok okVar) {
        this.bl.set(true);
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
            long longValue = (Double.valueOf((com.ss.android.downloadlib.h.n.ok(i4) + 1.0d) * d4).longValue() + com.ss.android.downloadlib.h.n.a(i4)) - j5;
            long s3 = s();
            if (s3 < longValue) {
                ok(aVar, jSONObject, longValue, s3);
                ok(aVar);
                long s4 = s();
                if (s4 < longValue) {
                    aVar.s(true);
                    final String ok = aVar.ok();
                    com.ss.android.downloadlib.addownload.bl.s.ok().ok(ok, new com.ss.android.downloadlib.addownload.bl.n() { // from class: com.ss.android.downloadlib.addownload.s.4
                    });
                    z3 = ok(i4, aVar, str, longValue);
                    if (z3) {
                        aVar.n(true);
                    }
                } else {
                    a(aVar, jSONObject, s3, s4);
                }
            }
        }
        if (z3) {
            return;
        }
        this.ok.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.s.5
            @Override // java.lang.Runnable
            public void run() {
                okVar.ok();
            }
        });
    }

    private boolean ok(int i4, @NonNull com.ss.android.downloadad.api.ok.a aVar, String str, long j4) {
        if (com.ss.android.downloadlib.h.n.kf(i4)) {
            if (r.z() != null) {
                return r.z().ok(i4, str, true, j4);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("show_dialog_result", 3);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_window_show", jSONObject, aVar);
            return false;
        }
        return false;
    }

    public static boolean ok(final DownloadInfo downloadInfo, long j4) {
        int id = downloadInfo.getId();
        boolean z3 = false;
        if (com.ss.android.downloadlib.h.n.kf(id)) {
            if (r.z() != null && (z3 = r.z().ok(id, downloadInfo.getUrl(), false, j4))) {
                com.ss.android.downloadlib.addownload.bl.s.ok().ok(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.bl.n() { // from class: com.ss.android.downloadlib.addownload.s.6
                });
            }
            return z3;
        }
        return false;
    }

    public static JSONObject ok(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static void ok(int i4) {
        if (com.ss.android.downloadlib.h.n.kf(i4) && r.z() != null && r.z().a()) {
            r.z().bl();
        }
    }

    private static void ok(com.ss.android.downloadad.api.ok.a aVar) {
        long s3 = s();
        if (r.z() != null) {
            r.z().n();
        }
        com.ss.android.downloadlib.addownload.bl.bl.ok();
        com.ss.android.downloadlib.addownload.bl.bl.a();
        if (com.ss.android.downloadlib.h.n.h(aVar.zz())) {
            com.ss.android.downloadlib.addownload.bl.bl.ok(r.getContext());
        }
        long s4 = s();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(s4 - s3));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("clean_quite_finish", jSONObject, aVar);
    }

    private void ok(com.ss.android.downloadad.api.ok.a aVar, JSONObject jSONObject, long j4, long j5) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j5));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j4));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("clean_space_no_enough_for_download", jSONObject, aVar);
    }
}
