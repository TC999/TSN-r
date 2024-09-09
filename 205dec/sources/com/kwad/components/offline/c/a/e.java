package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.sdk.components.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e implements IOfflineApkLoaderHolder {
    private j Zk;

    public e(j jVar) {
        this.Zk = jVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(int i4) {
        return new d(this.Zk.aS(i4));
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder
    public final IOfflineApkLoader getApkLoader(String str) {
        return new d(this.Zk.aT(str));
    }
}
