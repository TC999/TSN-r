package com.acse.ottn.util;

import android.os.CountDownTimer;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1648S;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.util.Ma */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1642Ma implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessibilityNodeInfo f3258a;

    /* renamed from: b */
    final /* synthetic */ C1644Na f3259b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1642Ma(C1644Na c1644Na, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3259b = c1644Na;
        this.f3258a = accessibilityNodeInfo;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    @RequiresApi(api = 16)
    /* renamed from: a */
    public void mo55884a(long j) {
        CountDownTimer countDownTimer;
        this.f3259b.f3268d = new ArrayList();
        this.f3259b.m56169a(this.f3258a);
        C1644Na c1644Na = this.f3259b;
        if (!c1644Na.m56167a(c1644Na.f3268d) || (countDownTimer = C1644Na.f3267c) == null) {
            return;
        }
        countDownTimer.cancel();
        C1644Na.f3267c = null;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
    }
}
