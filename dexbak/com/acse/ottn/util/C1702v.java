package com.acse.ottn.util;

import com.acse.ottn.model.AccessiblityModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.v */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1702v implements Consumer<AccessiblityModel> {

    /* renamed from: a */
    final /* synthetic */ String f3379a;

    /* renamed from: b */
    final /* synthetic */ C1617A f3380b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1702v(C1617A c1617a, String str) {
        this.f3380b = c1617a;
        this.f3379a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(AccessiblityModel accessiblityModel) throws Exception {
        String str;
        str = C1617A.f3113e;
        C1694ra.m55917a(str, "请求成功 string =" + accessiblityModel.toString());
        this.f3380b.m56346a(accessiblityModel, this.f3379a);
        List<String> list = this.f3380b.f3119k;
        if (list != null) {
            list.removeAll(list);
            this.f3380b.f3119k = new ArrayList();
            this.f3380b.f3120l = 0;
        }
    }
}
