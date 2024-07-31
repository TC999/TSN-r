package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1500c implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2757a;

    /* renamed from: b */
    final /* synthetic */ String f2758b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1500c(AccessibilityService accessibilityService, String str) {
        this.f2757a = accessibilityService;
        this.f2758b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1694ra.m55917a("samon-->", "openHonorFlowWindowPermission  倒计时");
        C1505h.m56601f(this.f2757a);
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2757a, this.f2758b);
            if (m55955g == null) {
                accessibilityNodeInfo = C1505h.f2771e;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1505h.f2771e;
                    m55975c.m55978b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = C1505h.f2770d;
            if (timerTask != null) {
                timerTask.cancel();
                C1505h.f2770d = null;
            }
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m56005a(500L);
            C1505h.m56624a(this.f2757a, System.currentTimeMillis(), true);
        } catch (Exception e) {
            C1694ra.m55917a("acse_HuaweiUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1505h.f2770d = null;
    }
}
