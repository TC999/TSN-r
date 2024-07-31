package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.C */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1494C implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2742a;

    /* renamed from: b */
    final /* synthetic */ String f2743b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1494C(AccessibilityService accessibilityService, String str) {
        this.f2742a = accessibilityService;
        this.f2743b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1497F.m56627h(this.f2742a);
        try {
            if (C1684n.m55975c().m55955g(this.f2742a, this.f2743b) == null) {
                accessibilityNodeInfo = C1497F.f2752d;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1497F.f2752d;
                    m55975c.m55978b(accessibilityNodeInfo2);
                }
            } else {
                TimerTask timerTask = C1497F.f2751c;
                if (timerTask != null) {
                    timerTask.cancel();
                    C1497F.f2751c = null;
                }
            }
        } catch (Exception e) {
            C1694ra.m55917a("acse_VivoUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1497F.f2751c = null;
    }
}
