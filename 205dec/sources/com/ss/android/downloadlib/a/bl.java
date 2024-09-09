package com.ss.android.downloadlib.a;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.ok.ok;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {
    public static void ok(final com.ss.android.downloadad.api.ok.a aVar, @NonNull final com.ss.android.downloadlib.guide.install.ok okVar) {
        boolean a4 = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        if (!a4 && Build.VERSION.SDK_INT >= 29) {
            j.bl();
        }
        boolean a5 = com.ss.android.socialbase.downloader.ok.ok.ok().a();
        if (!a4 && a5 && aVar != null) {
            aVar.j(true);
        }
        okVar.ok();
        com.ss.android.socialbase.downloader.bl.ok.a("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + a5);
        if (a5) {
            return;
        }
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC1022ok() { // from class: com.ss.android.downloadlib.a.bl.1
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void a() {
                com.ss.android.socialbase.downloader.bl.ok.a("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                if (j.a(com.ss.android.downloadad.api.ok.a.this)) {
                    return;
                }
                com.ss.android.downloadad.api.ok.a.this.z(true);
                com.ss.android.downloadlib.s.ok.ok().ok("install_delay_invoke", com.ss.android.downloadad.api.ok.a.this);
                okVar.ok();
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
            public void bl() {
            }
        });
    }
}
