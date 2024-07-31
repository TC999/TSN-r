package com.kwad.framework.filedownloader.event;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DownloadServiceConnectChangedEvent extends AbstractC9485b {
    private final ConnectStatus ahf;
    private final Class<?> ahg;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.ahf = connectStatus;
        this.ahg = cls;
    }

    /* renamed from: vT */
    public final ConnectStatus m28566vT() {
        return this.ahf;
    }
}
