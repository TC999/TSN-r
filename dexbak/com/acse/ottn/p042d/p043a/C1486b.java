package com.acse.ottn.p042d.p043a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.a.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1486b implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2725a;

    /* renamed from: b */
    final /* synthetic */ AccessibilityNodeInfo f2726b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1486b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2725a = accessibilityService;
        this.f2726b = accessibilityNodeInfo;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TimerTask timerTask;
        TimerTask timerTask2;
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2725a, "位置信息");
        if (m55955g == null) {
            C1684n.m55975c().m55978b(this.f2726b);
            return;
        }
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

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1694ra.m55917a("LocationManager", "结束了");
    }
}
