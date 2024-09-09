package com.kwad.framework.filedownloader.download;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    final long afO;
    final long afP;
    final long afQ;
    final long contentLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j4, long j5, long j6, long j7) {
        this.afO = j4;
        this.afP = j5;
        this.afQ = j6;
        this.contentLength = j7;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("range[%d, %d) current offset[%d]", Long.valueOf(this.afO), Long.valueOf(this.afQ), Long.valueOf(this.afP));
    }
}
