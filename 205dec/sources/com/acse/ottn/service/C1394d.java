package com.acse.ottn.service;

import com.acse.ottn.util.ra;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.service.d  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1394d implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6547a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MainService f6548b;

    C1394d(MainService mainService, String str) {
        this.f6548b = mainService;
        this.f6547a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        String str2 = MainService.f6368e;
        ra.a(str2, "\u8bf7\u6c42\u6210\u529f limit_tips =" + this.f6548b.f6370b.toString());
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("r") == 1 && jSONObject.getInt("code") == 1) {
            MainService.a(this.f6548b, this.f6547a);
        } else {
            this.f6548b.c();
        }
    }
}
