package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.C2598ao;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.cf */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2652cf implements C2598ao.InterfaceC2599a {

    /* renamed from: a */
    final /* synthetic */ C2640by f8805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2652cf(C2640by c2640by) {
        this.f8805a = c2640by;
    }

    @Override // com.baidu.mobads.sdk.internal.C2598ao.InterfaceC2599a
    /* renamed from: a */
    public void mo50651a() {
        boolean z;
        z = this.f8805a.f8784A;
        if (z) {
            this.f8805a.f8784A = false;
            this.f8805a.m50691a(false, "remote update Network access failed");
        }
    }
}
