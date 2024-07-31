package com.acse.ottn.service;

import android.content.Context;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;
import com.acse.ottn.util.C1632Ha;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.G */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1567G implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ C1586Y.InterfaceC1587a f2976a;

    /* renamed from: b */
    final /* synthetic */ AccessiblityModel f2977b;

    /* renamed from: c */
    final /* synthetic */ Context f2978c;

    /* renamed from: d */
    final /* synthetic */ C1586Y f2979d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1567G(C1586Y c1586y, C1586Y.InterfaceC1587a interfaceC1587a, AccessiblityModel accessiblityModel, Context context) {
        this.f2979d = c1586y;
        this.f2976a = interfaceC1587a;
        this.f2977b = accessiblityModel;
        this.f2978c = context;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("r") != 0) {
            String string = jSONObject.getString("gwc_link");
            this.f2977b.getData().setSpop_deeplink(jSONObject.getString("gwc_deeplink"));
            this.f2977b.getData().setSpop_link(string);
            C1632Ha.m56256b().m56255b(this.f2978c, this.f2977b);
        }
        C1586Y.m56387a(this.f2976a);
    }
}
