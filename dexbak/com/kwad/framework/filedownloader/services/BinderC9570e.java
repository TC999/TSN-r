package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.C9550n;
import com.kwad.framework.filedownloader.p350c.InterfaceC9453a;
import com.kwad.framework.filedownloader.p350c.InterfaceC9456b;
import com.kwad.framework.filedownloader.p351d.C9462b;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.framework.filedownloader.services.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class BinderC9570e extends InterfaceC9456b.AbstractBinderC9457a implements InterfaceC9575i {
    private final C9573g ahY;
    private final WeakReference<FileDownloadServiceProxy> ahZ;

    /* renamed from: com.kwad.framework.filedownloader.services.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9571a {
        /* renamed from: a */
        void mo28377a(BinderC9570e binderC9570e);

        void onDisconnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderC9570e(WeakReference<FileDownloadServiceProxy> weakReference, C9573g c9573g) {
        this.ahZ = weakReference;
        this.ahY = c9573g;
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: a */
    public final void mo28388a(InterfaceC9453a interfaceC9453a) {
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: b */
    public final void mo28387b(InterfaceC9453a interfaceC9453a) {
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: b */
    public final void mo28386b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C9462b c9462b, boolean z3) {
        this.ahY.m28375b(str, str2, z, i, i2, i3, z2, c9462b, z3);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: bd */
    public final boolean mo28385bd(int i) {
        return this.ahY.m28372bd(i);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: be */
    public final byte mo28384be(int i) {
        return this.ahY.m28371be(i);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: bf */
    public final boolean mo28383bf(int i) {
        return this.ahY.m28370bf(i);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: bx */
    public final boolean mo28382bx(int i) {
        return this.ahY.m28369bx(i);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: by */
    public final long mo28381by(int i) {
        return this.ahY.m28373bJ(i);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: bz */
    public final long mo28380bz(int i) {
        return this.ahY.m28368bz(i);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    public final boolean isIdle() {
        return this.ahY.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.InterfaceC9575i
    public final void onDestroy() {
        C9550n.m28439uN().onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    public final void pauseAllTasks() {
        this.ahY.m28365wE();
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ahZ.get().context.startForeground(i, notification);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahZ;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ahZ.get().context.stopForeground(z);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: u */
    public final boolean mo28379u(String str, String str2) {
        return this.ahY.m28364y(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
    /* renamed from: vV */
    public final void mo28378vV() {
        this.ahY.m28367vV();
    }

    @Override // com.kwad.framework.filedownloader.services.InterfaceC9575i
    /* renamed from: wB */
    public final void mo28356wB() {
        C9550n.m28439uN().mo28377a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.InterfaceC9575i
    /* renamed from: wC */
    public final IBinder mo28355wC() {
        return null;
    }
}
