package com.kwad.sdk.collector;

import android.content.Context;
import android.util.Log;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void cq(String str);

        void onLoaded();
    }

    public static boolean Ax() {
        return ISLOADED.get();
    }

    public static void a(Context context, final a aVar) {
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
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(str);
        bVar.Jd = true;
        bVar.akf = str2;
        bVar.version = "3.1";
        bVar.akj = false;
        bVar.aki = str3;
        bVar.akl = hashMap;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.collector.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.cq("load canceled");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, com.kwad.library.solder.lib.h hVar) {
                super.a((AnonymousClass1) cVar, (com.kwad.library.solder.lib.b.c) hVar);
                d.a(a.this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0679b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                super.a((AnonymousClass1) cVar, pluginError);
                if (a.this != null) {
                    a.this.cq(pluginError == null ? "load error" : pluginError.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        try {
            System.loadLibrary("kwappstatus");
            ISLOADED.set(true);
            if (aVar != null) {
                aVar.onLoaded();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.cq(Log.getStackTraceString(th));
            }
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            if (th instanceof UnsatisfiedLinkError) {
                return;
            }
            com.kwad.sdk.service.c.gatherException(th);
        }
    }
}
