package com.kwad.sdk.collector;

import android.content.Context;
import android.util.Log;
import com.kwad.library.solder.lib.C9644h;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p361b.C9614c;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.utils.AbiUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.collector.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9796d {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.collector.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9798a {
        /* renamed from: cq */
        void mo27756cq(String str);

        void onLoaded();
    }

    /* renamed from: Ax */
    public static boolean m27763Ax() {
        return ISLOADED.get();
    }

    /* renamed from: a */
    public static void m27762a(Context context, final InterfaceC9798a interfaceC9798a) {
        String str;
        String str2;
        String str3;
        if (ISLOADED.get()) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put("libkwappstatus.so", "40eb0d1d346cab7ced4d02a3065b7a94");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
            str2 = "kwappstatus-v8a";
            str3 = "c66bf3f78bd997bbd5b6e5038a23dff6";
        } else {
            hashMap.put("libkwappstatus.so", "b60d5c17b0cc4aa03e8180bc5cedaf3d");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
            str2 = "kwappstatus-v7a";
            str3 = "b9c0eff152a62bd5062844255107f3e0";
        }
        C9617b c9617b = new C9617b();
        c9617b.akg = C10425a.m26107DU().m26085dU(str);
        c9617b.f29489Jd = true;
        c9617b.akf = str2;
        c9617b.version = "3.1";
        c9617b.akj = false;
        c9617b.aki = str3;
        c9617b.akl = hashMap;
        C9602a.m28256a(context, c9617b, new InterfaceC9629b.C9632c() { // from class: com.kwad.sdk.collector.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo25118f(C9614c c9614c) {
                super.mo25118f(c9614c);
                InterfaceC9798a interfaceC9798a2 = InterfaceC9798a.this;
                if (interfaceC9798a2 != null) {
                    interfaceC9798a2.mo27756cq("load canceled");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo24651a(C9614c c9614c, C9644h c9644h) {
                super.mo24651a((C97971) c9614c, (C9614c) c9644h);
                C9796d.m27761a(InterfaceC9798a.this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo24650a(C9614c c9614c, PluginError pluginError) {
                super.mo24650a((C97971) c9614c, pluginError);
                if (InterfaceC9798a.this != null) {
                    InterfaceC9798a.this.mo27756cq(pluginError == null ? "load error" : pluginError.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m27761a(InterfaceC9798a interfaceC9798a) {
        try {
            System.loadLibrary("kwappstatus");
            ISLOADED.set(true);
            if (interfaceC9798a != null) {
                interfaceC9798a.onLoaded();
            }
        } catch (Throwable th) {
            if (interfaceC9798a != null) {
                interfaceC9798a.mo27756cq(Log.getStackTraceString(th));
            }
            C10331c.printStackTraceOnly(th);
            if (th instanceof UnsatisfiedLinkError) {
                return;
            }
            C10974c.gatherException(th);
        }
    }
}
