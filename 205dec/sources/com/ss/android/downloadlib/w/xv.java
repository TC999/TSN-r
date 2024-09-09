package com.ss.android.downloadlib.w;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.c.c;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {
    public static void c(final com.ss.android.downloadad.api.c.w wVar, @NonNull final com.ss.android.downloadlib.guide.install.c cVar) {
        boolean w3 = com.ss.android.socialbase.downloader.c.c.c().w();
        if (!w3 && Build.VERSION.SDK_INT >= 29) {
            a.xv();
        }
        boolean w4 = com.ss.android.socialbase.downloader.c.c.c().w();
        if (!w3 && w4 && wVar != null) {
            wVar.a(true);
        }
        cVar.c();
        com.ss.android.socialbase.downloader.xv.c.w("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + w4);
        if (w4) {
            return;
        }
        com.ss.android.socialbase.downloader.c.c.c().c(new c.InterfaceC0974c() { // from class: com.ss.android.downloadlib.w.xv.1
            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void w() {
                com.ss.android.socialbase.downloader.xv.c.w("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.c.c.c().w(this);
                if (a.w(com.ss.android.downloadad.api.c.w.this)) {
                    return;
                }
                com.ss.android.downloadad.api.c.w.this.bk(true);
                com.ss.android.downloadlib.sr.c.c().c("install_delay_invoke", com.ss.android.downloadad.api.c.w.this);
                cVar.c();
            }

            @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
            public void xv() {
            }
        });
    }
}
