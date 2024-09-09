package com.acse.ottn.service;

import android.content.Context;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;
import com.acse.ottn.util.Ha;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class G implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y.a f6325a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6326b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f6327c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y f6328d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(Y y3, Y.a aVar, AccessiblityModel accessiblityModel, Context context) {
        this.f6328d = y3;
        this.f6325a = aVar;
        this.f6326b = accessiblityModel;
        this.f6327c = context;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("r") != 0) {
            String string = jSONObject.getString("gwc_link");
            this.f6326b.getData().setSpop_deeplink(jSONObject.getString("gwc_deeplink"));
            this.f6326b.getData().setSpop_link(string);
            Ha.b().b(this.f6327c, this.f6326b);
        }
        Y.a(this.f6325a);
    }
}
