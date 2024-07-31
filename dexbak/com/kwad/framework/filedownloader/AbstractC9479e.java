package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.AbstractC9485b;
import com.kwad.framework.filedownloader.event.AbstractC9486c;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* renamed from: com.kwad.framework.filedownloader.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9479e extends AbstractC9486c {
    private DownloadServiceConnectChangedEvent.ConnectStatus aey;

    @Override // com.kwad.framework.filedownloader.event.AbstractC9486c
    /* renamed from: a */
    public final boolean mo28561a(AbstractC9485b abstractC9485b) {
        if (abstractC9485b instanceof DownloadServiceConnectChangedEvent) {
            DownloadServiceConnectChangedEvent.ConnectStatus m28566vT = ((DownloadServiceConnectChangedEvent) abstractC9485b).m28566vT();
            this.aey = m28566vT;
            if (m28566vT == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
                mo28313uw();
                return false;
            }
            mo28312ux();
            return false;
        }
        return false;
    }

    /* renamed from: uw */
    public abstract void mo28313uw();

    /* renamed from: ux */
    public abstract void mo28312ux();

    /* renamed from: uy */
    public final DownloadServiceConnectChangedEvent.ConnectStatus m28568uy() {
        return this.aey;
    }
}
