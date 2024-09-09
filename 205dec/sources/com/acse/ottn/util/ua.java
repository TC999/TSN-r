package com.acse.ottn.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class ua implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ va f6888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ua(va vaVar) {
        this.f6888a = vaVar;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        ra.a("MobclickAgentUtil", "\u7edf\u8ba1\u53d1\u9001\u5931\u8d25 throwable =" + th.getMessage());
    }
}
