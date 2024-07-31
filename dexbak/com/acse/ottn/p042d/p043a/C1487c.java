package com.acse.ottn.p042d.p043a;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.a.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1487c implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2727a;

    /* renamed from: b */
    final /* synthetic */ String f2728b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1487c(AccessibilityService accessibilityService, String str) {
        this.f2727a = accessibilityService;
        this.f2728b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TimerTask timerTask;
        TimerTask timerTask2;
        AccessibilityNodeInfo m56664c = C1490f.m56664c(this.f2727a.getRootInActiveWindow());
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2727a, this.f2728b);
        if (m55955g == null) {
            if (m56664c != null) {
                C1684n.m55975c().m55978b(m56664c);
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
        if ("honor".equals(C1638Ka.m56193b()) || "tianyi".equals(C1638Ka.m56193b())) {
            C1684n.m55975c().m55958f(m55955g);
            C1490f.m56660g(this.f2727a);
            return;
        }
        C1661ba.m56097a().m56092a("battery_white", true);
        C1684n.m55975c().m55958f(m55955g);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1694ra.m55917a("LocationManager", "结束了");
    }
}
