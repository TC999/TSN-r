package com.acse.ottn.service;

import com.acse.ottn.util.ra;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.service.g  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1397g implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainService f6551a;

    C1397g(MainService mainService) {
        this.f6551a = mainService;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        ra.a("samon-->code111", str);
        com.acse.ottn.util.H.a().a(this.f6551a, str);
    }
}
