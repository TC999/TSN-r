package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1503f implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2763a;

    /* renamed from: b */
    final /* synthetic */ AccessibilityNodeInfo f2764b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1503f(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2763a = accessibilityService;
        this.f2764b = accessibilityNodeInfo;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        C1694ra.m55917a("samon-->", "bbbb  倒计时");
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2763a, "后台弹窗");
        if (m55955g == null) {
            C1684n.m55975c().m55978b(this.f2764b);
            return;
        }
        TimerTask timerTask = C1505h.f2770d;
        if (timerTask != null) {
            timerTask.cancel();
            C1505h.f2770d = null;
        }
        C1684n.m55975c().m55958f(m55955g);
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56092a("battery_white", true);
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1694ra.m55917a("acse_HuaweiUtils", "结束了");
    }
}
