package com.acse.ottn.util;

import android.util.Log;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.m  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1440m implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1442n f6848a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1440m(C1442n c1442n) {
        this.f6848a = c1442n;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        String str;
        str = C1442n.f6852b;
        Log.d(str, "throwable=" + th.getMessage());
    }
}
