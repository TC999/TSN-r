package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o implements e.a, u {
    private static Class<?> aeS;
    private final ArrayList<Runnable> aeT = new ArrayList<>();
    private com.kwad.framework.filedownloader.services.e aeU;

    private static Class<?> uP() {
        if (aeS == null) {
            aeS = FileDownloadService.SharedMainProcessService.class;
        }
        return aeS;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z3, int i4, int i5, int i6, boolean z4, com.kwad.framework.filedownloader.d.b bVar, boolean z5) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z3);
        }
        this.aeU.b(str, str2, z3, i4, i5, i6, z4, bVar, z5);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i4) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bd(i4);
        }
        return this.aeU.bd(i4);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i4) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.be(i4);
        }
        return this.aeU.be(i4);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i4) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bf(i4);
        }
        return this.aeU.bf(i4);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aeU != null;
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aeU = null;
        f.uz().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, uP()));
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, uP()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.aeU = eVar;
        this.aeT.clear();
        for (Runnable runnable : (List) this.aeT.clone()) {
            runnable.run();
        }
        f.uz().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, uP()));
    }
}
