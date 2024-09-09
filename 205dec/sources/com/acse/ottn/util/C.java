package com.acse.ottn.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ D f6709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(D d4) {
        this.f6709a = d4;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = D.f6712b;
        ra.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
    }
}
