package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1502e implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1502e(AccessibilityService accessibilityService) {
        this.f2762a = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        C1694ra.m55917a("samon-->", "clickOpenBatteryDetails  倒计时");
        if (C1684n.m55975c().m55955g(this.f2762a, "手动管理") != null) {
            TimerTask timerTask = C1505h.f2770d;
            if (timerTask != null) {
                timerTask.cancel();
                C1505h.f2770d = null;
            }
            C1505h.m56611b("允许自启动", this.f2762a);
            C1505h.m56611b("允许关联启动", this.f2762a);
            C1505h.m56611b("允许后台活动", this.f2762a);
            CommonUtil.setButteryState(true);
            C1684n.m55975c().m55969d(this.f2762a);
            C1684n.m55975c().m55969d(this.f2762a);
            C1684n.m55975c().m55969d(this.f2762a);
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56092a("battery_white", false);
            }
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1694ra.m55917a("acse_HuaweiUtils", "结束了");
        C1505h.f2770d = null;
    }
}
