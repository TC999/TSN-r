package com.acse.ottn.util;

import com.acse.ottn.util.C1443na;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.ma  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1441ma implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1443na.a f6849a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1443na f6850b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1441ma(C1443na c1443na, C1443na.a aVar) {
        this.f6850b = c1443na;
        this.f6849a = aVar;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1443na.a aVar;
        boolean z3 = true;
        if (new JSONObject(str).getInt("state") == 1) {
            aVar = this.f6849a;
        } else {
            aVar = this.f6849a;
            z3 = false;
        }
        aVar.a(z3);
    }
}
