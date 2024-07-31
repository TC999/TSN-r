package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.p353f.C9501f;

/* renamed from: com.kwad.framework.filedownloader.download.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9469a {
    final long afO;
    final long afP;
    final long afQ;
    final long contentLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9469a(long j, long j2, long j3, long j4) {
        this.afO = j;
        this.afP = j2;
        this.afQ = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return C9501f.m28515b("range[%d, %d) current offset[%d]", Long.valueOf(this.afO), Long.valueOf(this.afQ), Long.valueOf(this.afP));
    }
}
