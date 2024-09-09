package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cp;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ce implements cp.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f12617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cb cbVar) {
        this.f12617a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cp.a
    public void a(String str) {
        try {
            this.f12617a.b();
            this.f12617a.a(str);
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }
}
