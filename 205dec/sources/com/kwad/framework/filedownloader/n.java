package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n implements u {
    private final u aeQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final n aeR = new n((byte) 0);
    }

    /* synthetic */ n(byte b4) {
        this();
    }

    public static n uM() {
        return a.aeR;
    }

    public static e.a uN() {
        if (uM().aeQ instanceof o) {
            return (e.a) uM().aeQ;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z3, int i4, int i5, int i6, boolean z4, com.kwad.framework.filedownloader.d.b bVar, boolean z5) {
        return this.aeQ.a(str, str2, z3, i4, i5, i6, z4, bVar, z5);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        this.aeQ.ak(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i4) {
        return this.aeQ.bd(i4);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i4) {
        return this.aeQ.be(i4);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i4) {
        return this.aeQ.bf(i4);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aeQ.isConnected();
    }

    private n() {
        this.aeQ = com.kwad.framework.filedownloader.f.e.wN().aip ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }
}
