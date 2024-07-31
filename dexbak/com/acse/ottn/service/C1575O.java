package com.acse.ottn.service;

import com.acse.ottn.util.C1694ra;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.O */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1575O implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ C1586Y f3009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1575O(C1586Y c1586y) {
        this.f3009a = c1586y;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1694ra.m55915b("ShopHelperService", "cutdown=" + str);
    }
}
