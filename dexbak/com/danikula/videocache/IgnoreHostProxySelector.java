package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.danikula.videocache.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class IgnoreHostProxySelector extends ProxySelector {

    /* renamed from: d */
    private static final List<Proxy> f23123d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a */
    private final ProxySelector f23124a;

    /* renamed from: b */
    private final String f23125b;

    /* renamed from: c */
    private final int f23126c;

    IgnoreHostProxySelector(ProxySelector proxySelector, String str, int i) {
        this.f23124a = (ProxySelector) C6567n.m35858d(proxySelector);
        this.f23125b = (String) C6567n.m35858d(str);
        this.f23126c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m35869a(String str, int i) {
        ProxySelector.setDefault(new IgnoreHostProxySelector(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f23124a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f23125b.equals(uri.getHost()) && this.f23126c == uri.getPort() ? f23123d : this.f23124a.select(uri);
    }
}
