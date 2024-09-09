package com.acse.ottn.util;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Ca implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Da f6710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(Da da) {
        this.f6710a = da;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        List list;
        List list2;
        List list3;
        str = Da.f6714b;
        ra.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
        list = this.f6710a.f6715c;
        if (list != null) {
            list2 = this.f6710a.f6715c;
            list3 = this.f6710a.f6715c;
            list2.removeAll(list3);
        }
    }
}
