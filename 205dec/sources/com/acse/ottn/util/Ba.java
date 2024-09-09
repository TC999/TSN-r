package com.acse.ottn.util;

import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Ba implements Consumer<AccessiblityModel> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6707a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Da f6708b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(Da da, String str) {
        this.f6708b = da;
        this.f6707a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(AccessiblityModel accessiblityModel) throws Exception {
        String str;
        str = Da.f6714b;
        ra.a(str, "\u8bf7\u6c42\u6210\u529f string =" + accessiblityModel.toString());
        if (1 == accessiblityModel.getR()) {
            A.b().a(accessiblityModel, this.f6707a);
        }
    }
}
