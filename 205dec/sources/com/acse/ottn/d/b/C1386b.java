package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.b  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1386b implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5431a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5432b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1386b(AccessibilityService accessibilityService, String str) {
        this.f5431a = accessibilityService;
        this.f5432b = str;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        try {
            ra.a("samon-->", "clickSoftList  \u5012\u8ba1\u65f6");
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5431a, this.f5432b);
            if (g4 != null) {
                TimerTask timerTask = h.f5446d;
                if (timerTask != null) {
                    timerTask.cancel();
                    h.f5446d = null;
                }
                C1442n.c().f(g4);
                if (C1419ba.a() != null) {
                    ra.a(l1.f5876a, "set battery_white is true");
                    C1419ba.a().a("battery_white", true);
                }
            }
        } catch (Exception e4) {
            ra.a(l1.f5876a, "e =" + e4.getMessage());
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        h.f5446d = null;
    }
}
