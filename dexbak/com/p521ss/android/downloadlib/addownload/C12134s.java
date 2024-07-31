package com.p521ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12095n;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.addownload.p528a.C12038q;
import com.p521ss.android.downloadlib.addownload.p529bl.C12049bl;
import com.p521ss.android.downloadlib.addownload.p529bl.C12052s;
import com.p521ss.android.downloadlib.addownload.p529bl.InterfaceC12050n;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12622k;
import com.p521ss.android.socialbase.downloader.network.p553ok.C12626a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12134s {

    /* renamed from: a */
    private C12035n f34336a;

    /* renamed from: ok */
    private Handler f34338ok;

    /* renamed from: bl */
    private AtomicBoolean f34337bl = new AtomicBoolean(false);

    /* renamed from: s */
    private AtomicBoolean f34339s = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C12134s(Handler handler) {
        this.f34338ok = handler;
    }

    /* renamed from: a */
    public static long m18931a() {
        if (C12128r.m18937z() != null) {
            return C12128r.m18937z().m19642ok();
        }
        return 0L;
    }

    /* renamed from: bl */
    static /* synthetic */ long m18929bl() {
        return m18912s();
    }

    /* renamed from: s */
    private static long m18912s() {
        return C12197j.m18808a(0L);
    }

    /* renamed from: a */
    private void m18930a(C11998a c11998a, JSONObject jSONObject, long j, long j2) {
        c11998a.m19492j("1");
        C12038q.m19278ok().m19277ok(c11998a);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("cleanspace_download_after_quite_clean", jSONObject, c11998a);
    }

    /* renamed from: ok */
    public void m18921ok(C12035n c12035n) {
        this.f34336a = c12035n;
    }

    /* renamed from: ok */
    public boolean m18928ok() {
        return this.f34339s.get();
    }

    /* renamed from: ok */
    public void m18913ok(boolean z) {
        this.f34339s.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m18926ok(final int i, final long j, long j2, final C12095n.InterfaceC12107ok interfaceC12107ok) {
        this.f34339s.set(false);
        if (interfaceC12107ok == null) {
            return;
        }
        if (C12201n.m18743kf(i) && C12201n.m18741n(i)) {
            long m18747bl = C12201n.m18747bl(i);
            this.f34337bl.set(false);
            final String downloadUrl = this.f34336a.f34076a.getDownloadUrl();
            C11998a m19330a = C12032kf.m19324ok().m19330a(downloadUrl);
            if (m19330a == null) {
                C12035n c12035n = this.f34336a;
                m19330a = new C11998a(c12035n.f34076a, c12035n.f34077bl, c12035n.f34080s, 0);
                C12032kf.m19324ok().m19318ok(m19330a);
            }
            final C11998a c11998a = m19330a;
            c11998a.m19475n(false);
            if (C12128r.m18937z() != null) {
                C12128r.m18937z().m19640ok(c11998a.mo19309a());
            }
            C12052s.m19245ok().m19242ok(c11998a.mo19298ok());
            boolean m18734s = C12201n.m18734s(i);
            if (j2 > 0) {
                m18924ok(i, downloadUrl, j2, c11998a, j, interfaceC12107ok);
            } else if (m18734s) {
                m18915ok(downloadUrl, c11998a, new C12095n.InterfaceC12105a() { // from class: com.ss.android.downloadlib.addownload.s.1
                    @Override // com.p521ss.android.downloadlib.addownload.C12095n.InterfaceC12105a
                    /* renamed from: ok */
                    public void mo18911ok(long j3) {
                        C12134s.this.m18924ok(i, downloadUrl, j3, c11998a, j, interfaceC12107ok);
                    }
                });
            } else {
                m18747bl = 0;
            }
            this.f34338ok.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.s.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C12134s.this.f34337bl.get()) {
                        return;
                    }
                    C12134s.this.f34337bl.set(true);
                    interfaceC12107ok.mo19048ok();
                }
            }, m18747bl);
            return;
        }
        interfaceC12107ok.mo19048ok();
    }

    /* renamed from: ok */
    private void m18915ok(String str, C11998a c11998a, final C12095n.InterfaceC12105a interfaceC12105a) {
        if (interfaceC12105a == null) {
            return;
        }
        C12626a.m16935ok(str, new InterfaceC12622k() { // from class: com.ss.android.downloadlib.addownload.s.3
            @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12622k
            /* renamed from: ok */
            public void mo16946ok(Map<String, String> map) {
                if (C12134s.this.f34337bl.get()) {
                    return;
                }
                C12134s.this.f34337bl.set(true);
                long m18914ok = C12134s.this.m18914ok(map);
                if (m18914ok > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(m18914ok));
                        jSONObject.putOpt("available_space", Long.valueOf(C12134s.m18929bl()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                interfaceC12105a.mo18911ok(m18914ok);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public long m18914ok(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(entry.getKey())) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18924ok(int i, String str, long j, final C11998a c11998a, long j2, final C12095n.InterfaceC12107ok interfaceC12107ok) {
        this.f34337bl.set(true);
        boolean z = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            double d = j;
            Double.isNaN(d);
            long longValue = (Double.valueOf((C12201n.m18739ok(i) + 1.0d) * d).longValue() + C12201n.m18752a(i)) - j2;
            long m18912s = m18912s();
            if (m18912s < longValue) {
                m18922ok(c11998a, jSONObject, longValue, m18912s);
                m18923ok(c11998a);
                long m18912s2 = m18912s();
                if (m18912s2 < longValue) {
                    c11998a.m19450s(true);
                    final String mo19298ok = c11998a.mo19298ok();
                    C12052s.m19245ok().m19241ok(mo19298ok, new InterfaceC12050n() { // from class: com.ss.android.downloadlib.addownload.s.4
                    });
                    z = m18925ok(i, c11998a, str, longValue);
                    if (z) {
                        c11998a.m19475n(true);
                    }
                } else {
                    m18930a(c11998a, jSONObject, m18912s, m18912s2);
                }
            }
        }
        if (z) {
            return;
        }
        this.f34338ok.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.s.5
            @Override // java.lang.Runnable
            public void run() {
                interfaceC12107ok.mo19048ok();
            }
        });
    }

    /* renamed from: ok */
    private boolean m18925ok(int i, @NonNull C11998a c11998a, String str, long j) {
        if (C12201n.m18743kf(i)) {
            if (C12128r.m18937z() != null) {
                return C12128r.m18937z().m19641ok(i, str, true, j);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("show_dialog_result", 3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            C12270ok.m18539ok().m18521ok("cleanspace_window_show", jSONObject, c11998a);
            return false;
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m18917ok(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (C12201n.m18743kf(id)) {
            if (C12128r.m18937z() != null && (z = C12128r.m18937z().m19641ok(id, downloadInfo.getUrl(), false, j))) {
                C12052s.m19245ok().m19241ok(downloadInfo.getUrl(), new InterfaceC12050n() { // from class: com.ss.android.downloadlib.addownload.s.6
                });
            }
            return z;
        }
        return false;
    }

    /* renamed from: ok */
    public static JSONObject m18916ok(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ok */
    public static void m18927ok(int i) {
        if (C12201n.m18743kf(i) && C12128r.m18937z() != null && C12128r.m18937z().m19645a()) {
            C12128r.m18937z().m19644bl();
        }
    }

    /* renamed from: ok */
    private static void m18923ok(C11998a c11998a) {
        long m18912s = m18912s();
        if (C12128r.m18937z() != null) {
            C12128r.m18937z().m19643n();
        }
        C12049bl.m19257ok();
        C12049bl.m19258a();
        if (C12201n.m18744h(c11998a.mo19285zz())) {
            C12049bl.m19256ok(C12128r.getContext());
        }
        long m18912s2 = m18912s();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(m18912s2 - m18912s));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("clean_quite_finish", jSONObject, c11998a);
    }

    /* renamed from: ok */
    private void m18922ok(C11998a c11998a, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12270ok.m18539ok().m18521ok("clean_space_no_enough_for_download", jSONObject, c11998a);
    }
}
