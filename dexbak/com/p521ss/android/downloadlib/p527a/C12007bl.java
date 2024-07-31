package com.p521ss.android.downloadlib.p527a;

import android.os.Build;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.guide.install.InterfaceC12183ok;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;

/* renamed from: com.ss.android.downloadlib.a.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12007bl {
    /* renamed from: ok */
    public static void m19406ok(final C11998a c11998a, @NonNull final InterfaceC12183ok interfaceC12183ok) {
        boolean m16854a = C12646ok.m16846ok().m16854a();
        if (!m16854a && Build.VERSION.SDK_INT >= 29) {
            C12197j.m18802bl();
        }
        boolean m16854a2 = C12646ok.m16846ok().m16854a();
        if (!m16854a && m16854a2 && c11998a != null) {
            c11998a.m19491j(true);
        }
        interfaceC12183ok.mo18662ok();
        C12409ok.m17904a("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + m16854a2);
        if (m16854a2) {
            return;
        }
        C12646ok.m16846ok().m16843ok(new C12646ok.InterfaceC12650ok() { // from class: com.ss.android.downloadlib.a.bl.1
            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: a */
            public void mo16836a() {
                C12409ok.m17904a("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                C12646ok.m16846ok().m16853a(this);
                if (C12197j.m18805a(C11998a.this)) {
                    return;
                }
                C11998a.this.m19430z(true);
                C12270ok.m18539ok().m18526ok("install_delay_invoke", C11998a.this);
                interfaceC12183ok.mo18662ok();
            }

            @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
            /* renamed from: bl */
            public void mo16835bl() {
            }
        });
    }
}
