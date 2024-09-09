package com.acse.ottn.service;

import com.acse.ottn.util.ra;
import io.reactivex.functions.Consumer;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class O implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y f6381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(Y y3) {
        this.f6381a = y3;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        ra.b("ShopHelperService", "cutdown=" + str);
    }
}
