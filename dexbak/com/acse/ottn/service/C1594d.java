package com.acse.ottn.service;

import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.C1694ra;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1594d implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ String f3056a;

    /* renamed from: b */
    final /* synthetic */ MainService f3057b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1594d(MainService mainService, String str) {
        this.f3057b = mainService;
        this.f3056a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        String str2;
        AccessiblityModel accessiblityModel;
        str2 = MainService.f2999c;
        StringBuilder sb = new StringBuilder();
        sb.append("请求成功 limit_tips =");
        accessiblityModel = this.f3057b.f3001e;
        sb.append(accessiblityModel.toString());
        C1694ra.m55917a(str2, sb.toString());
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("r") == 1 && jSONObject.getInt("code") == 1) {
            this.f3057b.m56407e(this.f3056a);
        } else {
            this.f3057b.m56412c();
        }
    }
}
