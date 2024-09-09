package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.h2;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class k implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5453a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, AccessibilityService accessibilityService) {
        this.f5453a = str;
        this.f5454b = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ra.a("samon-->", "clickHouTaiShowPage\u5012\u8ba1\u65f6");
        try {
            if (this.f5453a == null) {
                return;
            }
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5454b, this.f5453a);
            if (g4 == null) {
                ra.a("samonp-->", "appNodeInfo is null");
                l.i(this.f5454b);
                accessibilityNodeInfo = l.f5458d;
                if (accessibilityNodeInfo != null) {
                    C1442n c4 = C1442n.c();
                    accessibilityNodeInfo2 = l.f5458d;
                    c4.b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            ra.a("samonp-->", "appNodeInfo is not null");
            TimerTask timerTask = l.f5457c;
            if (timerTask != null) {
                timerTask.cancel();
                l.f5457c = null;
            }
            ra.a(h2.f5715a, "\u627e\u5230\u4e86");
            C1442n.c().f(g4);
            C1442n.c().a(V.a().b(500));
            AccessibilityNodeInfo j5 = C1442n.c().j(this.f5454b, "\u59cb\u7ec8\u5141\u8bb8");
            AccessibilityNodeInfo j6 = C1442n.c().j(this.f5454b, "\u5141\u8bb8");
            if (j5 != null) {
                ra.a("samonp-->", "appinfo is not null");
                C1442n.c().f(j5);
                C1442n.c().a(V.a().b(200));
                C1442n.c().d(this.f5454b);
            } else if (j6 != null) {
                C1442n.c().f(j6);
                C1442n.c().a(V.a().b(200));
                C1442n.c().d(this.f5454b);
                ra.a("samonp-->", "appinfo1 is not null");
            }
            if (C1419ba.a().a("is_pengpai")) {
                C1442n.c().d(this.f5454b);
                C1442n.c().a(V.a().b(100));
                C1442n.c().d(this.f5454b);
            }
        } catch (Exception e4) {
            ra.a(h2.f5715a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        l.f5457c = null;
    }
}
