package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.l1;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b.d  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1388d implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f5435a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5436b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f5437c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1388d(AccessibilityService accessibilityService, String str, boolean z3) {
        this.f5435a = accessibilityService;
        this.f5436b = str;
        this.f5437c = z3;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        ra.a("samon-->", "aaaa  \u5012\u8ba1\u65f6");
        h.f(this.f5435a.getRootInActiveWindow());
        accessibilityNodeInfo = h.f5448f;
        if (accessibilityNodeInfo != null) {
            AccessibilityNodeInfo g4 = C1442n.c().g(this.f5435a, this.f5436b);
            if (g4 == null) {
                C1442n c4 = C1442n.c();
                accessibilityNodeInfo2 = h.f5448f;
                c4.b(accessibilityNodeInfo2);
                return;
            }
            TimerTask timerTask = h.f5446d;
            if (timerTask != null) {
                timerTask.cancel();
                h.f5446d = null;
            }
            h.g(g4);
            h.a(this.f5435a, this.f5437c);
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        ra.a(l1.f5876a, "\u7ed3\u675f\u4e86");
    }
}
