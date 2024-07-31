package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.C1648S;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.util.N */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1643N extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ int[] f3260a;

    /* renamed from: b */
    final /* synthetic */ int f3261b;

    /* renamed from: c */
    final /* synthetic */ int f3262c;

    /* renamed from: d */
    final /* synthetic */ C1648S.InterfaceC1649a f3263d;

    /* renamed from: e */
    final /* synthetic */ C1648S f3264e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1643N(C1648S c1648s, int[] iArr, int i, int i2, C1648S.InterfaceC1649a interfaceC1649a) {
        this.f3264e = c1648s;
        this.f3260a = iArr;
        this.f3261b = i;
        this.f3262c = i2;
        this.f3263d = interfaceC1649a;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnableC1641M;
        int[] iArr = this.f3260a;
        iArr[0] = iArr[0] + this.f3261b;
        if (iArr[0] >= this.f3262c) {
            cancel();
            handler = new Handler(Looper.getMainLooper());
            runnableC1641M = new RunnableC1639L(this);
        } else {
            handler = new Handler(Looper.getMainLooper());
            runnableC1641M = new RunnableC1641M(this);
        }
        handler.postDelayed(runnableC1641M, 0L);
    }
}
