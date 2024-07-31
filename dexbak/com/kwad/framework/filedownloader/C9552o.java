package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p353f.C9489a;
import com.kwad.framework.filedownloader.services.BinderC9570e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.framework.filedownloader.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9552o implements BinderC9570e.InterfaceC9571a, InterfaceC9577u {
    private static Class<?> aeS;
    private final ArrayList<Runnable> aeT = new ArrayList<>();
    private BinderC9570e aeU;

    /* renamed from: uP */
    private static Class<?> m28436uP() {
        if (aeS == null) {
            aeS = FileDownloadService.SharedMainProcessService.class;
        }
        return aeS;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: a */
    public final boolean mo28339a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C9462b c9462b, boolean z3) {
        if (!isConnected()) {
            return C9489a.m28555h(str, str2, z);
        }
        this.aeU.mo28386b(str, str2, z, i, i2, i3, z2, c9462b, z3);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: ak */
    public final void mo28338ak(Context context) {
        m28437a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: bd */
    public final boolean mo28337bd(int i) {
        if (!isConnected()) {
            return C9489a.m28558bd(i);
        }
        return this.aeU.mo28385bd(i);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: be */
    public final byte mo28336be(int i) {
        if (!isConnected()) {
            return C9489a.m28557be(i);
        }
        return this.aeU.mo28384be(i);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: bf */
    public final boolean mo28335bf(int i) {
        if (!isConnected()) {
            return C9489a.m28556bf(i);
        }
        return this.aeU.mo28383bf(i);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    public final boolean isConnected() {
        return this.aeU != null;
    }

    @Override // com.kwad.framework.filedownloader.services.BinderC9570e.InterfaceC9571a
    public final void onDisconnected() {
        this.aeU = null;
        C9487f.m28560uz().m28562c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, m28436uP()));
    }

    /* renamed from: a */
    private void m28437a(Context context, Runnable runnable) {
        context.startService(new Intent(context, m28436uP()));
    }

    @Override // com.kwad.framework.filedownloader.services.BinderC9570e.InterfaceC9571a
    /* renamed from: a */
    public final void mo28377a(BinderC9570e binderC9570e) {
        this.aeU = binderC9570e;
        this.aeT.clear();
        for (Runnable runnable : (List) this.aeT.clone()) {
            runnable.run();
        }
        C9487f.m28560uz().m28562c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, m28436uP()));
    }
}
