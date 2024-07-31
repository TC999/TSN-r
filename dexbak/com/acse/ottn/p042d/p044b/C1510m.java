package com.acse.ottn.p042d.p044b;

import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1510m implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ ShopHelperService f2783a;

    /* renamed from: b */
    final /* synthetic */ String f2784b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1510m(ShopHelperService shopHelperService, String str) {
        this.f2783a = shopHelperService;
        this.f2784b = str;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        try {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2783a, this.f2784b);
            if (m55955g == null) {
                C1514q.m56553h(this.f2783a);
                accessibilityNodeInfo = C1514q.f2791c;
                if (accessibilityNodeInfo == null) {
                    return;
                }
                C1684n m55975c = C1684n.m55975c();
                accessibilityNodeInfo2 = C1514q.f2791c;
                m55975c.m55978b(accessibilityNodeInfo2);
                return;
            }
            TimerTask timerTask = C1514q.f2790b;
            if (timerTask != null) {
                timerTask.cancel();
                C1514q.f2790b = null;
            }
            C1694ra.m55917a("NubiaUtils", "找到了");
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m55969d(this.f2783a);
        } catch (Exception e) {
            C1694ra.m55917a("NubiaUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1514q.f2790b = null;
        C1694ra.m55917a("NubiaUtils", "结束了");
    }
}
