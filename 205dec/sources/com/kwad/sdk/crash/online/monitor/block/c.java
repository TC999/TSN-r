package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.ranger.RangerInjector;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static volatile boolean aGF;

    private static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.Du().decode((bVar == null || TextUtils.isEmpty(bVar.aGY)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.aGY));
        com.kwad.sdk.core.e.c.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aGF) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b c4 = c(aVar);
            RangerInjector.a(b(c4), a(c4), new RangerInjector.b() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void a(String str, long j4, long j5, String str2, String str3) {
                    f.a(str, j4, j5, str2, str3, false);
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            aGF = true;
        } catch (Exception e4) {
            onError(Log.getStackTraceString(e4));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        h hVar = (h) ServiceProvider.get(h.class);
        String appId = hVar != null ? hVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.fz(appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        f.fy(str);
        com.kwad.sdk.core.e.c.w("perfMonitor.Injector", str);
    }

    private static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.Du().decode((bVar == null || TextUtils.isEmpty(bVar.aGX)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : bVar.aGX));
        com.kwad.sdk.core.e.c.d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }
}
