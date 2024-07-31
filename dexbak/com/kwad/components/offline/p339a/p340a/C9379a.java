package com.kwad.components.offline.p339a.p340a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.p355b.C9586a;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.C11006aa;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.offline.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9379a {
    private static final AtomicBoolean acE = new AtomicBoolean(false);
    private static final String acF = C11006aa.format("lib%s.so", "c++_shared");
    private static final String acG = C11006aa.format("lib%s.so", "kwaiplayer");
    private static final String acH = C11006aa.format("lib%s.so", "kste");
    private static final String acI = C11006aa.format("lib%s.so", "hodor");
    private static final String acJ = C11006aa.format("lib%s.so", "aegon");

    /* renamed from: a */
    public static void m28868a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = acE;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put(acF, "dcd68cd059cb06a9596ba6839c2e8858");
            hashMap.put(acG, "cf71bcc476b2b25e2e62b541275ad78c");
            hashMap.put(acH, "ebb56fa9c5701350497e281c2446660f");
            hashMap.put(acI, "a61edf93bc5abc7799c5444ccbaf140b");
            hashMap.put(acJ, "c256c0d7f79ad4d47db61cb8e8ab142a");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArm64v8aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v8a";
            str3 = "41a4213dcbf3ed262fc69daf7d4a29e5";
        } else {
            hashMap.put(acF, "e3fdbf82716c2cb9b666a3880ab94003");
            hashMap.put(acG, "2ba24f9d0a6e786af477ed1e2dad148b");
            hashMap.put(acH, "71a9baa45905a6f0e527e5a2e06e8808");
            hashMap.put(acI, "d997935a035d00a67dc46e26427b8bf9");
            hashMap.put(acJ, "bdac6eea0d25da98061c21234f3b20c5");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArmeabiv7aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v7a";
            str3 = "ceddd5a3aae9148992bee153a29a25fb";
        }
        C9617b c9617b = new C9617b();
        C9586a m28255i = C9602a.m28255i(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        C10331c.m26254d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + m28255i);
        if (m28255i instanceof C9586a) {
            c9617b.ako = m28255i.m28309wU();
        }
        c9617b.akg = C10425a.m26107DU().m26085dU(str);
        c9617b.f29489Jd = true;
        c9617b.akf = str2;
        c9617b.version = "3.3.44.3";
        c9617b.akl = hashMap;
        c9617b.aki = str3;
        c9617b.akj = true;
        C9602a.m28256a(context, c9617b, new InterfaceC9629b.C9632c() { // from class: com.kwad.components.offline.a.a.a.1
            /* renamed from: tG */
            private void m28866tG() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public final /* synthetic */ void mo24651a(AbstractC9608e abstractC9608e, AbstractC9604a abstractC9604a) {
                m28866tG();
            }

            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ void mo24650a(AbstractC9608e abstractC9608e, PluginError pluginError) {
                m28867a(pluginError);
            }

            /* renamed from: a */
            private void m28867a(PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
            }
        });
    }
}
