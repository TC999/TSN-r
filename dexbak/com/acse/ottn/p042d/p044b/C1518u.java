package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.app.Application;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.u */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1518u implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2800a;

    /* renamed from: b */
    final /* synthetic */ String f2801b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1518u(AccessibilityService accessibilityService, String str) {
        this.f2800a = accessibilityService;
        this.f2801b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        Application application;
        C1694ra.m55917a("samon-->", "openOppoFlowWindowPermission  倒计时");
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2800a, this.f2801b);
            if (m55955g == null) {
                if (Build.VERSION.SDK_INT < 24 || (application = AcseHelpManager.mContext) == null) {
                    return;
                }
                C1684n.m56001a(this.f2800a, C1638Ka.m56190c(application) / 3, ((C1638Ka.m56192b(AcseHelpManager.mContext) * 2) / 3) + 300, (C1638Ka.m56190c(AcseHelpManager.mContext) / 3) + 100, C1638Ka.m56192b(AcseHelpManager.mContext) / 3, 300);
                return;
            }
            TimerTask timerTask = C1523z.f2810c;
            if (timerTask != null) {
                timerTask.cancel();
                C1523z.f2810c = null;
            }
            C1694ra.m55917a("OppoUtils", "找到了");
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m55969d(this.f2800a);
        } catch (Exception e) {
            C1694ra.m55917a("OppoUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1523z.f2810c = null;
        C1694ra.m55917a("OppoUtils", "结束了");
    }
}
