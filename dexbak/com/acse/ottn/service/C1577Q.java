package com.acse.ottn.service;

import com.acse.ottn.service.C1586Y;
import com.acse.ottn.util.C1694ra;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.Q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1577Q implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1586Y.InterfaceC1587a f3011a;

    /* renamed from: b */
    final /* synthetic */ C1586Y f3012b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1577Q(C1586Y c1586y, C1586Y.InterfaceC1587a interfaceC1587a) {
        this.f3012b = c1586y;
        this.f3011a = interfaceC1587a;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = C1586Y.f3041a;
        C1694ra.m55915b(str, "报错了=" + th.getMessage());
        C1586Y.m56387a(this.f3011a);
    }
}
