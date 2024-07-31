package com.acse.ottn.util;

import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.Ba */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1620Ba implements Consumer<AccessiblityModel> {

    /* renamed from: a */
    final /* synthetic */ String f3134a;

    /* renamed from: b */
    final /* synthetic */ C1624Da f3135b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1620Ba(C1624Da c1624Da, String str) {
        this.f3135b = c1624Da;
        this.f3134a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(AccessiblityModel accessiblityModel) throws Exception {
        String str;
        str = C1624Da.f3141b;
        C1694ra.m55917a(str, "请求成功 string =" + accessiblityModel.toString());
        if (1 == accessiblityModel.getR()) {
            C1617A.m56331b().m56346a(accessiblityModel, this.f3134a);
        }
    }
}
