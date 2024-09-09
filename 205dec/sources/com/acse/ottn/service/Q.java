package com.acse.ottn.service;

import com.acse.ottn.service.Y;
import com.acse.ottn.util.ra;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Q implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y.a f6383a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Y f6384b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(Y y3, Y.a aVar) {
        this.f6384b = y3;
        this.f6383a = aVar;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = Y.f6415a;
        ra.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
        Y.a(this.f6383a);
    }
}
