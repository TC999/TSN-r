package com.acse.ottn.util;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.C1648S;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1691q implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ C1617A f3355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1691q(C1617A c1617a) {
        this.f3355a = c1617a;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1689p(this), 0L);
        } catch (Exception unused) {
        }
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        String str;
        str = C1617A.f3113e;
        C1694ra.m55917a(str, "结束了");
        TimerTask timerTask = C1617A.f3111c;
        if (timerTask != null) {
            timerTask.cancel();
            C1617A.f3111c = null;
        }
    }
}
