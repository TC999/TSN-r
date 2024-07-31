package com.acse.ottn.util;

import com.acse.ottn.util.C1685na;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.ma */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1683ma implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ C1685na.InterfaceC1686a f3339a;

    /* renamed from: b */
    final /* synthetic */ C1685na f3340b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1683ma(C1685na c1685na, C1685na.InterfaceC1686a interfaceC1686a) {
        this.f3340b = c1685na;
        this.f3339a = interfaceC1686a;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1685na.InterfaceC1686a interfaceC1686a;
        boolean z = true;
        if (new JSONObject(str).getInt("state") == 1) {
            interfaceC1686a = this.f3339a;
        } else {
            interfaceC1686a = this.f3339a;
            z = false;
        }
        interfaceC1686a.m55940a(z);
    }
}
