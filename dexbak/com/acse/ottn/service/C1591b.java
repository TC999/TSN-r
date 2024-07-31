package com.acse.ottn.service;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1591b implements C1648S.InterfaceC1649a {
    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        String str;
        str = DemoService.f2957c;
        C1694ra.m55917a(str, "结束了");
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1589a(this), 0L);
    }
}
