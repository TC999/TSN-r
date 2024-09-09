package com.ss.android.downloadlib.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.ok.ok;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {
    private static Handler ok = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull final com.ss.android.downloadad.api.ok.a aVar, final int i4) {
        if (i4 <= 0) {
            return;
        }
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.a.kf.2
            @Override // java.lang.Runnable
            public void run() {
                int i5 = 1;
                if (j.bl(com.ss.android.downloadad.api.ok.a.this.n())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!com.ss.android.downloadad.api.ok.a.this.ew()) {
                            i5 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i5));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    com.ss.android.downloadlib.s.ok.ok().ok("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.ok.a.this);
                    return;
                }
                kf.a(com.ss.android.downloadad.api.ok.a.this, i4 - 1);
            }
        }, q(aVar) * 1000);
    }

    public static boolean bl(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_invoke_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_check_count", 10);
    }

    public static long n(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long p(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_check_timeout", 300000L);
    }

    private static int q(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).ok("app_link_check_delay", 1);
    }

    public static boolean s(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_dialog_switch") == 1;
    }

    public static void ok(final com.ss.android.downloadad.api.ok.a aVar, @NonNull final p pVar) {
        boolean a4 = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        if (!a4 && Build.VERSION.SDK_INT >= 29) {
            j.bl();
        }
        boolean a5 = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        boolean z3 = !a4 && a5;
        if (aVar != null) {
            aVar.j(z3);
        }
        pVar.ok(z3);
        if (aVar == null) {
            return;
        }
        a(aVar, k(aVar));
        if (a5) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC1022ok() { // from class: com.ss.android.downloadlib.a.kf.1
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void a() {
                com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.a.kf.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean bl = j.bl(com.ss.android.downloadad.api.ok.a.this.n());
                        long n4 = kf.n(com.ss.android.downloadad.api.ok.a.this);
                        if (!bl || n4 >= System.currentTimeMillis() - currentTimeMillis) {
                            long p3 = kf.p(com.ss.android.downloadad.api.ok.a.this);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis2 - currentTimeMillis > p3) {
                                com.ss.android.downloadlib.s.ok.ok().ok("deeplink_delay_timeout", com.ss.android.downloadad.api.ok.a.this);
                                return;
                            }
                            com.ss.android.downloadad.api.ok.a.this.j(true);
                            com.ss.android.downloadlib.s.ok.ok().ok("deeplink_delay_invoke", com.ss.android.downloadad.api.ok.a.this);
                            pVar.ok(true);
                            com.ss.android.downloadad.api.ok.a aVar2 = com.ss.android.downloadad.api.ok.a.this;
                            kf.a(aVar2, kf.k(aVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void bl() {
            }
        });
    }

    public static boolean a(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_install_switch") == 1;
    }

    public static boolean ok(com.ss.android.downloadad.api.ok.a aVar) {
        return com.ss.android.downloadlib.h.n.ok(aVar).a("app_link_opt_switch") == 1;
    }
}
