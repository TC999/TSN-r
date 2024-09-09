package com.acse.ottn.service;

import com.acse.ottn.util.ra;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.service.i  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1399i implements ObservableOnSubscribe<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6553a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MainService f6554b;

    C1399i(MainService mainService, String str) {
        this.f6554b = mainService;
        this.f6553a = str;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
        String str;
        try {
            str = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f6553a).build()).execute().body().string()).getString("content");
            ra.a("samon-->code1", str);
        } catch (Exception e4) {
            e4.printStackTrace();
            ra.a("samon-->code11", "shortcode is null");
            ra.a(MainService.f6368e, e4.getMessage());
            str = "";
        }
        observableEmitter.onNext(str);
    }
}
