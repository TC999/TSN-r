package com.acse.ottn.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.ua */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1701ua implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1703va f3378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1701ua(C1703va c1703va) {
        this.f3378a = c1703va;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        C1694ra.m55917a("MobclickAgentUtil", "统计发送失败 throwable =" + th.getMessage());
    }
}
