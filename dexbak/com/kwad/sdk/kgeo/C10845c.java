package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.C11028au;
import com.kwad.sdk.utils.C11120o;
import com.kwai.library.ipneigh.C11176c;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.kgeo.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10845c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.kgeo.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10847a {
        /* renamed from: Ho */
        void mo24647Ho();

        void onSuccess(String str);
    }

    /* renamed from: a */
    public static void m24652a(final Context context, final InterfaceC10847a interfaceC10847a) {
        if (C11028au.m24070Mm()) {
            interfaceC10847a.mo24647Ho();
        } else if (!C11120o.m23761Lj()) {
            interfaceC10847a.mo24647Ho();
        } else if (Build.VERSION.SDK_INT < 23) {
            interfaceC10847a.mo24647Ho();
        } else {
            AtomicBoolean atomicBoolean = sHasInit;
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            boolean isArm64 = AbiUtil.isArm64(context);
            C9617b c9617b = new C9617b();
            c9617b.version = "1.0.3";
            c9617b.akf = isArm64 ? "kmc-v8a" : "kmc-v7a";
            c9617b.akg = C10425a.m26107DU().m26085dU(isArm64 ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32");
            c9617b.aki = isArm64 ? "db9a8da62a0354ec5710ec03e2743f07" : "2440a8221230913d4287c6b1e02b49f1";
            c9617b.f29489Jd = true;
            C9602a.m28256a(context, c9617b, new InterfaceC9629b.C9632c() { // from class: com.kwad.sdk.kgeo.c.1
                /* renamed from: tG */
                private void m24648tG() {
                    C10331c.m26254d("KGeoSoHelper", "onPostLoad");
                    try {
                        System.loadLibrary("ipneigh-android");
                        InterfaceC10847a.this.onSuccess(C11176c.m23475dw(context).aUy);
                    } catch (Throwable unused) {
                        C10331c.m26254d("KGeoSoHelper", "loadLibrary fail");
                        InterfaceC10847a.this.mo24647Ho();
                    }
                }

                @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
                /* renamed from: a */
                public final /* synthetic */ void mo24651a(AbstractC9608e abstractC9608e, AbstractC9604a abstractC9604a) {
                    m24648tG();
                }

                @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ void mo24650a(AbstractC9608e abstractC9608e, PluginError pluginError) {
                    m24649a(pluginError);
                }

                /* renamed from: a */
                private void m24649a(PluginError pluginError) {
                    C10331c.m26254d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                    InterfaceC10847a.this.mo24647Ho();
                }
            });
        }
    }
}
