package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus aey;

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (bVar instanceof DownloadServiceConnectChangedEvent) {
            DownloadServiceConnectChangedEvent.ConnectStatus vT = ((DownloadServiceConnectChangedEvent) bVar).vT();
            this.aey = vT;
            if (vT == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                uw();
                return false;
            }
            ux();
            return false;
        }
        return false;
    }

    public abstract void uw();

    public abstract void ux();

    public final DownloadServiceConnectChangedEvent.ConnectStatus uy() {
        return this.aey;
    }
}
