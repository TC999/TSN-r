package com.acse.ottn.util;

import com.acse.ottn.util.C1443na;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.da  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1423da implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1443na.a f6817a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1443na f6818b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1423da(C1443na c1443na, C1443na.a aVar) {
        this.f6818b = c1443na;
        this.f6817a = aVar;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        this.f6817a.a(true);
        ra.b("ShopHelperService", "\u62a5\u9519\u4e86=" + th.getMessage());
    }
}
