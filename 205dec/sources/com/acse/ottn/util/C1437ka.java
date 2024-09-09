package com.acse.ottn.util;

import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.ka  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1437ka implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6843a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1443na f6844b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1437ka(C1443na c1443na, String str) {
        this.f6844b = c1443na;
        this.f6843a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1421ca.c().a(this.f6843a);
    }
}
