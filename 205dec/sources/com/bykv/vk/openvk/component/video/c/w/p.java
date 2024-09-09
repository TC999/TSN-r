package com.bykv.vk.openvk.component.video.c.w;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class p extends ProxySelector {

    /* renamed from: c  reason: collision with root package name */
    private static final List<Proxy> f25105c = Collections.singletonList(Proxy.NO_PROXY);
    private final int sr;

    /* renamed from: w  reason: collision with root package name */
    private final ProxySelector f25106w = ProxySelector.getDefault();
    private final String xv;

    private p(String str, int i4) {
        this.xv = str;
        this.sr = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, int i4) {
        ProxySelector.setDefault(new p(str, i4));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f25106w.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.xv.equalsIgnoreCase(uri.getHost()) && this.sr == uri.getPort()) ? f25105c : this.f25106w.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
