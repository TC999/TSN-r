package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.p */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1513p implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ ShopHelperService f2788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1513p(ShopHelperService shopHelperService) {
        this.f2788a = shopHelperService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    @RequiresApi(api = 16)
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a((AccessibilityService) this.f2788a, "允许", true);
        if (m55996a != null) {
            TimerTask timerTask = C1514q.f2790b;
            if (timerTask != null) {
                timerTask.cancel();
                C1514q.f2790b = null;
            }
            C1684n.m55975c().m55958f(m55996a);
            CommonUtil.setButteryState(true);
            C1684n.m55975c().m55969d(this.f2788a);
            C1684n.m55975c().m55969d(this.f2788a);
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask timerTask = C1514q.f2790b;
        if (timerTask != null) {
            timerTask.cancel();
            C1514q.f2790b = null;
        }
        CommonUtil.setButteryState(true);
        C1684n.m55975c().m55969d(this.f2788a);
        C1684n.m55975c().m55969d(this.f2788a);
    }
}
