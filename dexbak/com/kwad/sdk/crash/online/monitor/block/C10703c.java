package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.crash.online.monitor.p428a.C10697b;
import com.kwad.sdk.ranger.RangerInjector;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10703c {
    private static volatile boolean aGF;

    /* renamed from: a */
    private static String m25084a(C10697b c10697b) {
        String str = new String(C9886c.m27442Du().decode((c10697b == null || TextUtils.isEmpty(c10697b.aGY)) ? "b25SZXBvcnRJc3N1ZQ==" : c10697b.aGY));
        C10331c.m26254d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    /* renamed from: b */
    public static void m25083b(C10696a c10696a) {
        if (aGF) {
            return;
        }
        try {
            C10697b m25081c = m25081c(c10696a);
            RangerInjector.m24408a(m25082b(m25081c), m25084a(m25081c), new RangerInjector.InterfaceC10943b() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.ranger.RangerInjector.InterfaceC10943b
                /* renamed from: a */
                public final void mo24397a(String str, long j, long j2, String str2, String str3) {
                    C10707f.m25073a(str, j, j2, str2, str3, false);
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.InterfaceC10943b
                public final void onError(String str) {
                    C10703c.onError(str);
                }
            });
            aGF = true;
        } catch (Exception e) {
            onError(Log.getStackTraceString(e));
        }
    }

    /* renamed from: c */
    private static C10697b m25081c(C10696a c10696a) {
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        String appId = interfaceC10970h != null ? interfaceC10970h.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return c10696a.m25096fz(appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        C10707f.m25068fy(str);
        C10331c.m26246w("perfMonitor.Injector", str);
    }

    /* renamed from: b */
    private static String m25082b(C10697b c10697b) {
        String str = new String(C9886c.m27442Du().decode((c10697b == null || TextUtils.isEmpty(c10697b.aGX)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : c10697b.aGX));
        C10331c.m26254d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }
}
