package com.acse.ottn.util;

import android.util.Log;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1682m implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ C1684n f3338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1682m(C1684n c1684n) {
        this.f3338a = c1684n;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = C1684n.f3342b;
        Log.d(str, "throwable=" + th.getMessage());
    }
}
