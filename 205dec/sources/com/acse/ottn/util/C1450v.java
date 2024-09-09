package com.acse.ottn.util;

import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.v  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1450v implements Consumer<AccessiblityModel> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6889a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ A f6890b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1450v(A a4, String str) {
        this.f6890b = a4;
        this.f6889a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(AccessiblityModel accessiblityModel) throws Exception {
        String str;
        str = A.f6686e;
        ra.a(str, "\u8bf7\u6c42\u6210\u529f string =" + accessiblityModel.toString());
        this.f6890b.a(accessiblityModel, this.f6889a);
        List<String> list = this.f6890b.f6692k;
        if (list != null) {
            list.removeAll(list);
            this.f6890b.f6692k = new ArrayList();
            this.f6890b.f6693l = 0;
        }
    }
}
