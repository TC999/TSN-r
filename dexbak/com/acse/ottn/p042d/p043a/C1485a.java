package com.acse.ottn.p042d.p043a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.a.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1485a implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2723a;

    /* renamed from: b */
    final /* synthetic */ String f2724b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1485a(AccessibilityService accessibilityService, String str) {
        this.f2723a = accessibilityService;
        this.f2724b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TimerTask timerTask;
        TimerTask timerTask2;
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2723a, this.f2724b);
            if (m55955g != null) {
                timerTask = C1490f.f2735d;
                if (timerTask != null) {
                    timerTask2 = C1490f.f2735d;
                    timerTask2.cancel();
                    TimerTask unused = C1490f.f2735d = null;
                }
                C1684n.m55975c().m55958f(m55955g);
                if (C1661ba.m56097a() != null) {
                    C1661ba.m56097a().m56092a("battery_white", true);
                    C1661ba.m56097a().m56092a("location_permission", true);
                }
            }
        } catch (Exception e) {
            C1694ra.m55917a("LocationManager", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask unused = C1490f.f2735d = null;
    }
}
