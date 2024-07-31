package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.CountDownTimer;
import com.acse.ottn.util.C1648S;

/* renamed from: com.acse.ottn.util.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1674i implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityService f3325a;

    /* renamed from: b */
    final /* synthetic */ C1684n f3326b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1674i(C1684n c1684n, AccessibilityService accessibilityService) {
        this.f3326b = c1684n;
        this.f3325a = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        if (this.f3325a == null || C1684n.m55975c().m55959f(this.f3325a, "com.tencent.mm:id/gix") == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            C1684n.m55975c().m55998a(this.f3325a, "com.tencent.mm:id/gix");
        }
        CountDownTimer countDownTimer = this.f3326b.f3348h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f3326b.f3348h = null;
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        this.f3326b.f3348h = null;
    }
}
