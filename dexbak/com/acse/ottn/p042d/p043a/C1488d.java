package com.acse.ottn.p042d.p043a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.a.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1488d implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ String f2729a;

    /* renamed from: b */
    final /* synthetic */ AccessibilityService f2730b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1488d(String str, AccessibilityService accessibilityService) {
        this.f2729a = str;
        this.f2730b = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TimerTask timerTask;
        TimerTask timerTask2;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        try {
            if (this.f2729a == null) {
                return;
            }
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2730b, this.f2729a);
            if (m55955g == null) {
                C1490f.m56657j(this.f2730b);
                accessibilityNodeInfo = C1490f.f2736e;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1490f.f2736e;
                    m55975c.m55978b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            timerTask = C1490f.f2735d;
            if (timerTask != null) {
                timerTask2 = C1490f.f2735d;
                timerTask2.cancel();
                TimerTask unused = C1490f.f2735d = null;
            }
            C1694ra.m55917a("LocationManager", "找到了定位");
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
            AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(this.f2730b, "始终允许");
            AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(this.f2730b, "允许", true);
            if (m55955g2 != null) {
                C1684n.m55975c().m55958f(m55955g2);
            } else if (m55996a == null) {
                return;
            } else {
                C1684n.m55975c().m55958f(m55996a);
            }
            C1490f.m56669b(this.f2730b, 1);
        } catch (Exception e) {
            C1694ra.m55917a("LocationManager", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask unused = C1490f.f2735d = null;
    }
}
