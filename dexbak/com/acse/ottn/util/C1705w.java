package com.acse.ottn.util;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.w */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1705w implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1617A f3383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1705w(C1617A c1617a) {
        this.f3383a = c1617a;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = C1617A.f3113e;
        C1694ra.m55915b(str, "报错了=" + th.getMessage());
        List<String> list = this.f3383a.f3119k;
        if (list != null) {
            list.removeAll(list);
            this.f3383a.f3119k = new ArrayList();
            this.f3383a.f3120l = 0;
        }
    }
}
