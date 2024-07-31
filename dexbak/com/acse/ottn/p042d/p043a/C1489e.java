package com.acse.ottn.p042d.p043a;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.a.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1489e implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1489e(AccessibilityService accessibilityService) {
        this.f2731a = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TimerTask timerTask;
        TimerTask timerTask2;
        if (C1684n.m55975c().m55953h(this.f2731a, "定位") != null) {
            C1684n.m55975c().m55952i(this.f2731a, "定位");
            C1684n.m55975c().m56005a(100L);
            AccessibilityNodeInfo m55953h = C1684n.m55975c().m55953h(this.f2731a, "始终允许");
            if (m55953h != null) {
                timerTask = C1490f.f2735d;
                if (timerTask != null) {
                    timerTask2 = C1490f.f2735d;
                    timerTask2.cancel();
                    TimerTask unused = C1490f.f2735d = null;
                }
                C1694ra.m55917a("LocationManager", "clickVivoLocation appNodeInfo is not null");
                C1684n.m55975c().m55958f(m55953h);
                C1490f.m56669b(this.f2731a, 1);
                return;
            }
            C1694ra.m55917a("LocationManager", "clickVivoLocation appNodeInfo is null");
            if (Build.VERSION.SDK_INT < 24) {
                return;
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        AccessibilityService accessibilityService = this.f2731a;
        C1684n.m56001a(accessibilityService, C1638Ka.m56190c(accessibilityService) / 3, ((C1638Ka.m56192b(this.f2731a) * 2) / 3) + 300, (C1638Ka.m56190c(this.f2731a) / 3) + 100, C1638Ka.m56192b(this.f2731a) / 3, 200);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask unused = C1490f.f2735d = null;
    }
}
