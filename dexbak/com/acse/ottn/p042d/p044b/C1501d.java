package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1501d implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f2759a;

    /* renamed from: b */
    final /* synthetic */ String f2760b;

    /* renamed from: c */
    final /* synthetic */ boolean f2761c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1501d(AccessibilityService accessibilityService, String str, boolean z) {
        this.f2759a = accessibilityService;
        this.f2760b = str;
        this.f2761c = z;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1694ra.m55917a("samon-->", "aaaa  倒计时");
        C1505h.m56599f(this.f2759a.getRootInActiveWindow());
        accessibilityNodeInfo = C1505h.f2772f;
        if (accessibilityNodeInfo != null) {
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2759a, this.f2760b);
            if (m55955g == null) {
                C1684n m55975c = C1684n.m55975c();
                accessibilityNodeInfo2 = C1505h.f2772f;
                m55975c.m55978b(accessibilityNodeInfo2);
                return;
            }
            TimerTask timerTask = C1505h.f2770d;
            if (timerTask != null) {
                timerTask.cancel();
                C1505h.f2770d = null;
            }
            C1505h.m56597g(m55955g);
            C1505h.m56622a(this.f2759a, this.f2761c);
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1694ra.m55917a("acse_HuaweiUtils", "结束了");
    }
}
