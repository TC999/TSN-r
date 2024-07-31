package com.acse.ottn.service;

import com.acse.ottn.util.C1631H;
import com.acse.ottn.util.C1694ra;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.service.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1597g implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ MainService f3060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1597g(MainService mainService) {
        this.f3060a = mainService;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1694ra.m55917a("samon-->code111", str);
        C1631H.m56262a().m56260a(this.f3060a, str);
    }
}
