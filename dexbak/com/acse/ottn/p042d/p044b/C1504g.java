package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1504g implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2765a;

    /* renamed from: b */
    final /* synthetic */ String f2766b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1504g(AccessibilityService accessibilityService, String str) {
        this.f2765a = accessibilityService;
        this.f2766b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        C1694ra.m55917a("samon-->", "clickView  倒计时");
        AccessibilityNodeInfo m56605d = C1505h.m56605d(this.f2765a.getRootInActiveWindow());
        if (C1684n.m55975c().m55955g(this.f2765a, this.f2766b) == null) {
            if (m56605d != null) {
                C1684n.m55975c().m55978b(m56605d);
                return;
            }
            return;
        }
        TimerTask timerTask = C1505h.f2770d;
        if (timerTask != null) {
            timerTask.cancel();
            C1505h.f2770d = null;
        }
        C1505h.m56611b(this.f2766b, this.f2765a);
        CommonUtil.setServiceHightButteryState(true);
        C1684n.m55975c().m55969d(this.f2765a);
        C1684n.m55975c().m55969d(this.f2765a);
        C1684n.m55975c().m55969d(this.f2765a);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1694ra.m55917a("acse_HuaweiUtils", "结束了");
    }
}
