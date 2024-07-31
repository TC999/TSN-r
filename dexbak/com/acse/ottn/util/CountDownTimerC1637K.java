package com.acse.ottn.util;

import android.os.CountDownTimer;
import com.acse.ottn.util.C1648S;

/* renamed from: com.acse.ottn.util.K */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class CountDownTimerC1637K extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ C1648S.InterfaceC1649a f3252a;

    /* renamed from: b */
    final /* synthetic */ C1648S f3253b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTimerC1637K(C1648S c1648s, long j, long j2, C1648S.InterfaceC1649a interfaceC1649a) {
        super(j, j2);
        this.f3253b = c1648s;
        this.f3252a = interfaceC1649a;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f3252a.onFinish();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.f3252a.mo55884a(j);
    }
}
