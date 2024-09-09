package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.cb;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ac implements cb.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f12331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.f12331a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cb.c
    public void a(boolean z3) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z3) {
            try {
                cb cbVar = g.f12853a;
                if (cbVar != null) {
                    this.f12331a.f12319b = cbVar.i();
                    iXAdContainerFactory = this.f12331a.f12319b;
                    if (iXAdContainerFactory != null) {
                        this.f12331a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f12331a.a("\u52a0\u8f7ddex\u5f02\u5e38");
                return;
            }
        }
        g.f12853a = null;
        this.f12331a.a("\u52a0\u8f7ddex\u5931\u8d25");
    }
}
