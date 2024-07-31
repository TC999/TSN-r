package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.p351d.C9462b;
import com.kwad.framework.filedownloader.p353f.C9499e;
import com.kwad.framework.filedownloader.services.BinderC9570e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* renamed from: com.kwad.framework.filedownloader.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9550n implements InterfaceC9577u {
    private final InterfaceC9577u aeQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.framework.filedownloader.n$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9551a {
        private static final C9550n aeR = new C9550n((byte) 0);
    }

    /* synthetic */ C9550n(byte b) {
        this();
    }

    /* renamed from: uM */
    public static C9550n m28440uM() {
        return C9551a.aeR;
    }

    /* renamed from: uN */
    public static BinderC9570e.InterfaceC9571a m28439uN() {
        if (m28440uM().aeQ instanceof C9552o) {
            return (BinderC9570e.InterfaceC9571a) m28440uM().aeQ;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: a */
    public final boolean mo28339a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C9462b c9462b, boolean z3) {
        return this.aeQ.mo28339a(str, str2, z, i, i2, i3, z2, c9462b, z3);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: ak */
    public final void mo28338ak(Context context) {
        this.aeQ.mo28338ak(context);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: bd */
    public final boolean mo28337bd(int i) {
        return this.aeQ.mo28337bd(i);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: be */
    public final byte mo28336be(int i) {
        return this.aeQ.mo28336be(i);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: bf */
    public final boolean mo28335bf(int i) {
        return this.aeQ.mo28335bf(i);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    public final boolean isConnected() {
        return this.aeQ.isConnected();
    }

    private C9550n() {
        this.aeQ = C9499e.m28530wN().aip ? new C9552o() : new C9553p(FileDownloadService.SeparateProcessService.class);
    }
}
