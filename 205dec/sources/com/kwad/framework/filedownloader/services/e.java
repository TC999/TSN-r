package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.n;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e extends b.a implements i {
    private final g ahY;
    private final WeakReference<FileDownloadServiceProxy> ahZ;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.ahZ = weakReference;
        this.ahY = gVar;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z3, int i4, int i5, int i6, boolean z4, com.kwad.framework.filedownloader.d.b bVar, boolean z5) {
        this.ahY.b(str, str2, z3, i4, i5, i6, z4, bVar, z5);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bd(int i4) {
        return this.ahY.bd(i4);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte be(int i4) {
        return this.ahY.be(i4);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bf(int i4) {
        return this.ahY.bf(i4);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bx(int i4) {
        return this.ahY.bx(i4);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long by(int i4) {
        return this.ahY.bJ(i4);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bz(int i4) {
        return this.ahY.bz(i4);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.ahY.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        n.uN().onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.ahY.wE();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i4, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ahZ.get().context.startForeground(i4, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z3) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ahZ.get().context.stopForeground(z3);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean u(String str, String str2) {
        return this.ahY.y(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void vV() {
        this.ahY.vV();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void wB() {
        n.uN().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder wC() {
        return null;
    }
}
