package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.CountDownTimer;
import com.acse.ottn.util.S;

/* renamed from: com.acse.ottn.util.i  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1432i implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f6835a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1442n f6836b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1432i(C1442n c1442n, AccessibilityService accessibilityService) {
        this.f6836b = c1442n;
        this.f6835a = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        if (this.f6835a == null || C1442n.c().f(this.f6835a, "com.tencent.mm:id/gix") == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            C1442n.c().a(this.f6835a, "com.tencent.mm:id/gix");
        }
        CountDownTimer countDownTimer = this.f6836b.f6858h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f6836b.f6858h = null;
        }
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        this.f6836b.f6858h = null;
    }
}
