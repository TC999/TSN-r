package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.C2640by;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.ac */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2583ac implements C2640by.InterfaceC2643c {

    /* renamed from: a */
    final /* synthetic */ C2580aa f8535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2583ac(C2580aa c2580aa) {
        this.f8535a = c2580aa;
    }

    @Override // com.baidu.mobads.sdk.internal.C2640by.InterfaceC2643c
    /* renamed from: a */
    public void mo50656a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                C2640by c2640by = C2708g.f9067a;
                if (c2640by != null) {
                    this.f8535a.f8523b = c2640by.m50664i();
                    iXAdContainerFactory = this.f8535a.f8523b;
                    if (iXAdContainerFactory != null) {
                        this.f8535a.m51041k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f8535a.m51052a("加载dex异常");
                return;
            }
        }
        C2708g.f9067a = null;
        this.f8535a.m51052a("加载dex失败");
    }
}
