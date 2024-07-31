package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p361b.C9614c;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.crash.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10674g {
    private static final AtomicBoolean aFO = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.crash.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10676a {
        /* renamed from: Hn */
        void mo25116Hn();

        /* renamed from: Ho */
        void mo25115Ho();
    }

    /* renamed from: a */
    public static void m25123a(@NonNull C10668c c10668c, InterfaceC10676a interfaceC10676a) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = aFO;
        if (atomicBoolean.get()) {
            interfaceC10676a.mo25116Hn();
        } else if (c10668c.sdkVersion.compareTo(c10668c.aFr) < 0) {
            C10331c.m26254d("ExceptionSoLoadHelper", "sdkVersion:" + c10668c.sdkVersion + "*supportAppVersion:" + c10668c.aFr);
            interfaceC10676a.mo25115Ho();
        } else {
            Context context = c10668c.context;
            atomicBoolean.set(true);
            if (AbiUtil.isArm64(context)) {
                str = c10668c.aFu;
                if (TextUtils.isEmpty(str)) {
                    str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArm64v8aRelease-3.3.47-e8fbb3a5f8-666.apk";
                }
                str2 = c10668c.aFw;
                str3 = "exception-v8a";
            } else {
                str = c10668c.aFv;
                if (TextUtils.isEmpty(str)) {
                    str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/exception/202305301754/ks_so-exceptionArmeabiv7aRelease-3.3.47-e8fbb3a5f8-666.apk";
                }
                str2 = c10668c.aFx;
                str3 = "exception-v7a";
            }
            C9617b c9617b = new C9617b();
            c9617b.akg = C10425a.m26107DU().m26085dU(str);
            c9617b.f29489Jd = true;
            c9617b.akf = str3;
            c9617b.version = c10668c.aFq;
            c9617b.aki = str2;
            c9617b.akj = false;
            m25124a(context, c9617b, interfaceC10676a);
        }
    }

    /* renamed from: a */
    private static void m25124a(Context context, C9617b c9617b, @Nullable final InterfaceC10676a interfaceC10676a) {
        C9602a.m28256a(context, c9617b, new InterfaceC9629b.C9632c() { // from class: com.kwad.sdk.crash.g.1
            /* renamed from: HD */
            private void m25122HD() {
                C10331c.m26254d("ExceptionSoLoadHelper", "onFail thread=" + Thread.currentThread().getName());
                InterfaceC10676a interfaceC10676a2 = InterfaceC10676a.this;
                if (interfaceC10676a2 != null) {
                    interfaceC10676a2.mo25115Ho();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: c */
            public void mo25119d(C9614c c9614c) {
                super.mo25119d(c9614c);
                C10331c.m26254d("ExceptionSoLoadHelper", "onPostUpdate thread=" + Thread.currentThread().getName());
            }

            /* renamed from: tG */
            private void m25117tG() {
                C10331c.m26254d("ExceptionSoLoadHelper", "onPostLoad");
                InterfaceC10676a interfaceC10676a2 = InterfaceC10676a.this;
                if (interfaceC10676a2 != null) {
                    interfaceC10676a2.mo25116Hn();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public final /* synthetic */ void mo24651a(AbstractC9608e abstractC9608e, AbstractC9604a abstractC9604a) {
                m25117tG();
            }

            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public final /* synthetic */ void mo24650a(AbstractC9608e abstractC9608e, PluginError pluginError) {
                m25122HD();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo25118f(C9614c c9614c) {
                super.mo25118f(c9614c);
                C10331c.m26254d("ExceptionSoLoadHelper", "onCanceled thread=" + Thread.currentThread().getName());
            }
        });
    }
}
