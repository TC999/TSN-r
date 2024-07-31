package com.acse.ottn.util;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.Ca */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1622Ca implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1624Da f3137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1622Ca(C1624Da c1624Da) {
        this.f3137a = c1624Da;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        List list;
        List list2;
        List list3;
        str = C1624Da.f3141b;
        C1694ra.m55915b(str, "报错了=" + th.getMessage());
        list = this.f3137a.f3142c;
        if (list != null) {
            list2 = this.f3137a.f3142c;
            list3 = this.f3137a.f3142c;
            list2.removeAll(list3);
        }
    }
}
