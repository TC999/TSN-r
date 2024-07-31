package com.acse.ottn.service;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.service.C1586Y;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1612v implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ C1586Y.InterfaceC1587a f3096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1612v(C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3096a = interfaceC1587a;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        String str;
        str = C1586Y.f3041a;
        C1694ra.m55917a(str, "开始倒计时");
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1600j(this), 0L);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        String str;
        str = C1586Y.f3041a;
        C1694ra.m55917a(str, "结束了");
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1601k(this), 0L);
    }
}
