package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.C2580aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.bh */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2621bh implements C2580aa.InterfaceC2581a {

    /* renamed from: c */
    final /* synthetic */ AbstractC2619bg f8673c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2621bh(AbstractC2619bg abstractC2619bg) {
        this.f8673c = abstractC2619bg;
    }

    @Override // com.baidu.mobads.sdk.internal.C2580aa.InterfaceC2581a
    public void onFailure() {
        this.f8673c.f8664i.m50740a(AbstractC2619bg.f8657b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f8673c.m50807j();
    }

    @Override // com.baidu.mobads.sdk.internal.C2580aa.InterfaceC2581a
    public void onSuccess() {
        this.f8673c.f8664i.m50740a(AbstractC2619bg.f8657b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f8673c.mo50497i();
    }
}
