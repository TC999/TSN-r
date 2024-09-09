package com.ss.android.downloadlib.w;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.c.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static Handler f48972c = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static long ev(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).c("app_link_check_timeout", 300000L);
    }

    private static int gd(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).c("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).c("app_link_check_count", 10);
    }

    public static boolean sr(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).w("app_link_opt_dialog_switch") == 1;
    }

    public static long ux(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.r.ux.c(wVar).c("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(@NonNull final com.ss.android.downloadad.api.c.w wVar, final int i4) {
        if (i4 <= 0) {
            return;
        }
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.w.f.2
            @Override // java.lang.Runnable
            public void run() {
                int i5 = 1;
                if (a.xv(com.ss.android.downloadad.api.c.w.this.ux())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!com.ss.android.downloadad.api.c.w.this.ng()) {
                            i5 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i5));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    com.ss.android.downloadlib.sr.c.c().c("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.c.w.this);
                    return;
                }
                f.w(com.ss.android.downloadad.api.c.w.this, i4 - 1);
            }
        }, gd(wVar) * 1000);
    }

    public static boolean xv(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).w("app_link_opt_invoke_switch") == 1;
    }

    public static void c(final com.ss.android.downloadad.api.c.w wVar, @NonNull final ev evVar) {
        boolean w3 = com.ss.android.socialbase.downloader.c.c.c().w();
        if (!w3 && Build.VERSION.SDK_INT >= 29) {
            a.xv();
        }
        boolean w4 = com.ss.android.socialbase.downloader.c.c.c().w();
        boolean z3 = !w3 && w4;
        if (wVar != null) {
            wVar.a(z3);
        }
        evVar.c(z3);
        if (wVar == null) {
            return;
        }
        w(wVar, p(wVar));
        if (w4) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.c.c.c().c(new c.InterfaceC0974c() { // from class: com.ss.android.downloadlib.w.f.1
            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void w() {
                com.ss.android.socialbase.downloader.c.c.c().w(this);
                com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.w.f.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean xv = a.xv(com.ss.android.downloadad.api.c.w.this.ux());
                        long ux = f.ux(com.ss.android.downloadad.api.c.w.this);
                        if (!xv || ux >= System.currentTimeMillis() - currentTimeMillis) {
                            long ev = f.ev(com.ss.android.downloadad.api.c.w.this);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis2 - currentTimeMillis > ev) {
                                com.ss.android.downloadlib.sr.c.c().c("deeplink_delay_timeout", com.ss.android.downloadad.api.c.w.this);
                                return;
                            }
                            com.ss.android.downloadad.api.c.w.this.a(true);
                            com.ss.android.downloadlib.sr.c.c().c("deeplink_delay_invoke", com.ss.android.downloadad.api.c.w.this);
                            evVar.c(true);
                            com.ss.android.downloadad.api.c.w wVar2 = com.ss.android.downloadad.api.c.w.this;
                            f.w(wVar2, f.p(wVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void xv() {
            }
        });
    }

    public static boolean w(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).w("app_link_opt_install_switch") == 1;
    }

    public static boolean c(com.ss.android.downloadad.api.c.w wVar) {
        return com.ss.android.downloadlib.r.ux.c(wVar).w("app_link_opt_switch") == 1;
    }
}
