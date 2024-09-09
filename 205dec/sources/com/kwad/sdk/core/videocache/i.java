package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ap;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class i extends ProxySelector {
    private static final List<Proxy> aCk = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector aCl;
    private final String aCm;
    private final int aCn;

    private i(ProxySelector proxySelector, String str, int i4) {
        this.aCl = (ProxySelector) ap.checkNotNull(proxySelector);
        this.aCm = ap.gH(str);
        this.aCn = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void install(String str, int i4) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i4));
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
