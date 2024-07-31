package com.kwad.components.offline.p343c.p344a;

import com.kwad.components.offline.api.p341tk.IOfflineApkLoader;
import com.kwad.components.offline.api.p341tk.IOfflineApkLoaderHolder;
import com.kwad.sdk.components.InterfaceC9869j;

/* renamed from: com.kwad.components.offline.c.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9409e implements IOfflineApkLoaderHolder {

    /* renamed from: Zk */
    private InterfaceC9869j f29469Zk;

    public C9409e(InterfaceC9869j interfaceC9869j) {
        this.f29469Zk = interfaceC9869j;
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i) {
        return new C9407d(this.f29469Zk.mo27492aS(i));
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new C9407d(this.f29469Zk.mo27491aT(str));
    }
}
