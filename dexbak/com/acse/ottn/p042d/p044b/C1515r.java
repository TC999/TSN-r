package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.r */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1515r implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2792a;

    /* renamed from: b */
    final /* synthetic */ String f2793b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1515r(AccessibilityService accessibilityService, String str) {
        this.f2792a = accessibilityService;
        this.f2793b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2792a, this.f2793b);
            if (m55955g == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    C1694ra.m55917a("OnePlusUtils", "滑动");
                    Application application = AcseHelpManager.mContext;
                    if (application == null) {
                        return;
                    }
                    C1684n.m56001a(this.f2792a, C1638Ka.m56190c(application) / 3, ((C1638Ka.m56192b(AcseHelpManager.mContext) * 2) / 3) + 300, (C1638Ka.m56190c(AcseHelpManager.mContext) / 3) + 100, C1638Ka.m56192b(AcseHelpManager.mContext) / 3, 300);
                    return;
                }
                return;
            }
            TimerTask timerTask = C1517t.f2798c;
            if (timerTask != null) {
                timerTask.cancel();
                C1517t.f2798c = null;
            }
            C1694ra.m55917a("OnePlusUtils", "找到了");
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56092a("battery_white", true);
            }
            C1684n.m55975c().m55958f(m55955g);
        } catch (Exception e) {
            C1694ra.m55917a("OnePlusUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1517t.f2798c = null;
    }
}
