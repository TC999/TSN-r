package com.acse.ottn.util;

import com.acse.ottn.util.C1685na;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.da */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1665da implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1685na.InterfaceC1686a f3307a;

    /* renamed from: b */
    final /* synthetic */ C1685na f3308b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1665da(C1685na c1685na, C1685na.InterfaceC1686a interfaceC1686a) {
        this.f3308b = c1685na;
        this.f3307a = interfaceC1686a;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        this.f3307a.m55940a(true);
        C1694ra.m55915b("ShopHelperService", "报错了=" + th.getMessage());
    }
}
