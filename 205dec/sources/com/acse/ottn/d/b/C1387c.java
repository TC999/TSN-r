package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.c  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1387c implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5433a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5434b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1387c(AccessibilityService accessibilityService, String str) {
        this.f5433a = accessibilityService;
        this.f5434b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ra.a("samon-->", "openHonorFlowWindowPermission  \u5012\u8ba1\u65f6");
        h.f(this.f5433a);
        try {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5433a, this.f5434b);
            if (g4 == null) {
                accessibilityNodeInfo = h.f5447e;
                if (accessibilityNodeInfo != null) {
                    C1442n c4 = C1442n.c();
                    accessibilityNodeInfo2 = h.f5447e;
                    c4.b(accessibilityNodeInfo2);
                    return;
                }
                return;
            }
            TimerTask timerTask = h.f5446d;
            if (timerTask != null) {
                timerTask.cancel();
                h.f5446d = null;
            }
            C1442n.c().f(g4);
            C1442n.c().a(500L);
            h.a(this.f5433a, System.currentTimeMillis(), true);
        } catch (Exception e4) {
            ra.a(l1.f5876a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        h.f5446d = null;
    }
}
