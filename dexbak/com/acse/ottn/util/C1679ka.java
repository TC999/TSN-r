package com.acse.ottn.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.ka */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1679ka implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ String f3333a;

    /* renamed from: b */
    final /* synthetic */ C1685na f3334b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1679ka(C1685na c1685na, String str) {
        this.f3334b = c1685na;
        this.f3333a = str;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1663ca.m56080c().m56083a(this.f3333a);
    }
}
