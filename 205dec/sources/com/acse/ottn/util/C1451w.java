package com.acse.ottn.util;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.w  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1451w implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f6893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1451w(A a4) {
        this.f6893a = a4;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = A.f6686e;
        ra.b(str, "\u62a5\u9519\u4e86=" + th.getMessage());
        List<String> list = this.f6893a.f6692k;
        if (list != null) {
            list.removeAll(list);
            this.f6893a.f6692k = new ArrayList();
            this.f6893a.f6693l = 0;
        }
    }
}
