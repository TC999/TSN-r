package com.acse.ottn.service;

import com.acse.ottn.util.C1694ra;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1599i implements ObservableOnSubscribe<String> {

    /* renamed from: a */
    final /* synthetic */ String f3062a;

    /* renamed from: b */
    final /* synthetic */ MainService f3063b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1599i(MainService mainService, String str) {
        this.f3063b = mainService;
        this.f3062a = str;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
        String str;
        String str2;
        try {
            str2 = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f3062a).build()).execute().body().string()).getString("content");
            C1694ra.m55917a("samon-->code1", str2);
        } catch (Exception e) {
            e.printStackTrace();
            C1694ra.m55917a("samon-->code11", "shortcode is null");
            str = MainService.f2999c;
            C1694ra.m55917a(str, e.getMessage());
            str2 = "";
        }
        observableEmitter.onNext(str2);
    }
}
