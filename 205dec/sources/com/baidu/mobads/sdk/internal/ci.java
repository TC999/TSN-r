package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ao;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ci implements ao.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f12624a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cb cbVar) {
        this.f12624a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        boolean z3;
        z3 = this.f12624a.A;
        if (z3) {
            this.f12624a.A = false;
            this.f12624a.a(false, "remote update Network access failed");
        }
    }
}
