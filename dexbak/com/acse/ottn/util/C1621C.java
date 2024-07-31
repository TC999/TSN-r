package com.acse.ottn.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.C */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1621C implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1623D f3136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1621C(C1623D c1623d) {
        this.f3136a = c1623d;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = C1623D.f3139b;
        C1694ra.m55915b(str, "报错了=" + th.getMessage());
    }
}
