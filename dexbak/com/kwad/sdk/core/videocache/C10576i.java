package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.C11023ap;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.kwad.sdk.core.videocache.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10576i extends ProxySelector {
    private static final List<Proxy> aCk = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector aCl;
    private final String aCm;
    private final int aCn;

    private C10576i(ProxySelector proxySelector, String str, int i) {
        this.aCl = (ProxySelector) C11023ap.checkNotNull(proxySelector);
        this.aCm = C11023ap.m24086gH(str);
        this.aCn = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void install(String str, int i) {
        ProxySelector.setDefault(new C10576i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aCl.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.aCm.equals(uri.getHost()) && this.aCn == uri.getPort() ? aCk : this.aCl.select(uri);
    }
}
