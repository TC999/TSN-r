package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.y */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1522y implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1522y(AccessibilityService accessibilityService) {
        this.f2807a = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    @RequiresApi(api = 16)
    /* renamed from: a */
    public void mo55884a(long j) {
        C1694ra.m55917a("samon-->", "backClick  倒计时");
        AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(this.f2807a, "允许", true);
        if (m55996a != null) {
            TimerTask timerTask = C1523z.f2810c;
            if (timerTask != null) {
                timerTask.cancel();
                C1523z.f2810c = null;
            }
            C1684n.m55975c().m55958f(m55996a);
            CommonUtil.setButteryState(true);
            C1684n.m55975c().m55969d(this.f2807a);
            C1684n.m55975c().m55969d(this.f2807a);
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        TimerTask timerTask = C1523z.f2810c;
        if (timerTask != null) {
            timerTask.cancel();
            C1523z.f2810c = null;
        }
        CommonUtil.setButteryState(true);
        C1684n.m55975c().m55969d(this.f2807a);
        C1684n.m55975c().m55969d(this.f2807a);
    }
}
