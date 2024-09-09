package com.kwad.framework.filedownloader.event;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus ahf;
    private final Class<?> ahg;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
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

    public final ConnectStatus vT() {
        return this.ahf;
    }
}
