package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.C1648S;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.util.Q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1647Q extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ int[] f3271a;

    /* renamed from: b */
    final /* synthetic */ int f3272b;

    /* renamed from: c */
    final /* synthetic */ int f3273c;

    /* renamed from: d */
    final /* synthetic */ C1648S.InterfaceC1649a f3274d;

    /* renamed from: e */
    final /* synthetic */ C1648S f3275e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1647Q(C1648S c1648s, int[] iArr, int i, int i2, C1648S.InterfaceC1649a interfaceC1649a) {
        this.f3275e = c1648s;
        this.f3271a = iArr;
        this.f3272b = i;
        this.f3273c = i2;
        this.f3274d = interfaceC1649a;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnableC1646P;
        int[] iArr = this.f3271a;
        iArr[0] = iArr[0] + this.f3272b;
        if (iArr[0] >= this.f3273c) {
            cancel();
            handler = new Handler(Looper.getMainLooper());
            runnableC1646P = new RunnableC1645O(this);
        } else {
            handler = new Handler(Looper.getMainLooper());
            runnableC1646P = new RunnableC1646P(this);
        }
        handler.postDelayed(runnableC1646P, 0L);
    }
}
