package com.p521ss.android.downloadlib.p527a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12011kf {

    /* renamed from: ok */
    private static Handler f34016ok = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m19403a(@NonNull final C11998a c11998a, final int i) {
        if (i <= 0) {
            return;
        }
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.a.kf.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (C12197j.m18800bl(C11998a.this.mo19300n())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!C11998a.this.m19504ew()) {
                            i2 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    C12270ok.m18539ok().m18521ok("deeplink_success_2", jSONObject, C11998a.this);
                    return;
                }
                C12011kf.m19403a(C11998a.this, i - 1);
            }
        }, m19393q(c11998a) * 1000);
    }

    /* renamed from: bl */
    public static boolean m19402bl(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17607a("app_link_opt_invoke_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static int m19400k(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17593ok("app_link_check_count", 10);
    }

    /* renamed from: n */
    public static long m19398n(C11998a c11998a) {
        if (c11998a == null) {
            return 3000L;
        }
        return C12201n.m18737ok(c11998a).m17593ok("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static long m19394p(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17592ok("app_link_check_timeout", 300000L);
    }

    /* renamed from: q */
    private static int m19393q(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17593ok("app_link_check_delay", 1);
    }

    /* renamed from: s */
    public static boolean m19392s(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17607a("app_link_opt_dialog_switch") == 1;
    }

    /* renamed from: ok */
    public static void m19395ok(final C11998a c11998a, @NonNull final InterfaceC12022p interfaceC12022p) {
        boolean m16854a = C12646ok.m16846ok().m16854a();
        if (!m16854a && Build.VERSION.SDK_INT >= 29) {
            C12197j.m18802bl();
        }
        boolean m16854a2 = C12646ok.m16846ok().m16854a();
        boolean z = !m16854a && m16854a2;
        if (c11998a != null) {
            c11998a.m19491j(z);
        }
        interfaceC12022p.mo19373ok(z);
        if (c11998a == null) {
            return;
        }
        m19403a(c11998a, m19400k(c11998a));
        if (m16854a2) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        C12646ok.m16846ok().m16843ok(new C12646ok.InterfaceC12650ok() { // from class: com.ss.android.downloadlib.a.kf.1
            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: a */
            public void mo16836a() {
                C12646ok.m16846ok().m16853a(this);
                C12265s.m18554ok().m18553ok(new Runnable() { // from class: com.ss.android.downloadlib.a.kf.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean m18800bl = C12197j.m18800bl(C11998a.this.mo19300n());
                        long m19398n = C12011kf.m19398n(C11998a.this);
                        if (!m18800bl || m19398n >= System.currentTimeMillis() - currentTimeMillis) {
                            long m19394p = C12011kf.m19394p(C11998a.this);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            C120121 c120121 = C120121.this;
                            if (currentTimeMillis2 - currentTimeMillis > m19394p) {
                                C12270ok.m18539ok().m18526ok("deeplink_delay_timeout", C11998a.this);
                                return;
                            }
                            C11998a.this.m19491j(true);
                            C12270ok.m18539ok().m18526ok("deeplink_delay_invoke", C11998a.this);
                            interfaceC12022p.mo19373ok(true);
                            C11998a c11998a2 = C11998a.this;
                            C12011kf.m19403a(c11998a2, C12011kf.m19400k(c11998a2));
                        }
                    }
                });
            }

            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: bl */
            public void mo16835bl() {
            }
        });
    }

    /* renamed from: a */
    public static boolean m19404a(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17607a("app_link_opt_install_switch") == 1;
    }

    /* renamed from: ok */
    public static boolean m19397ok(C11998a c11998a) {
        return C12201n.m18737ok(c11998a).m17607a("app_link_opt_switch") == 1;
    }
}
