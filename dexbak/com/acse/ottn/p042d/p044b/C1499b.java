package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1499b implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2755a;

    /* renamed from: b */
    final /* synthetic */ String f2756b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1499b(AccessibilityService accessibilityService, String str) {
        this.f2755a = accessibilityService;
        this.f2756b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        try {
            C1694ra.m55917a("samon-->", "clickSoftList  倒计时");
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2755a, this.f2756b);
            if (m55955g != null) {
                TimerTask timerTask = C1505h.f2770d;
                if (timerTask != null) {
                    timerTask.cancel();
                    C1505h.f2770d = null;
                }
                C1684n.m55975c().m55958f(m55955g);
                if (C1661ba.m56097a() != null) {
                    C1694ra.m55917a("acse_HuaweiUtils", "set battery_white is true");
                    C1661ba.m56097a().m56092a("battery_white", true);
                }
            }
        } catch (Exception e) {
            C1694ra.m55917a("acse_HuaweiUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1505h.f2770d = null;
    }
}
