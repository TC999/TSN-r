package com.qq.e.comm.plugin.p0;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g extends ProxySelector {

    /* renamed from: d  reason: collision with root package name */
    private static final List<Proxy> f45344d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a  reason: collision with root package name */
    private final ProxySelector f45345a;

    /* renamed from: b  reason: collision with root package name */
    private final String f45346b;

    /* renamed from: c  reason: collision with root package name */
    private final int f45347c;

    g(ProxySelector proxySelector, String str, int i4) {
        this.f45345a = proxySelector;
        this.f45346b = str;
        this.f45347c = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i4) {
        ProxySelector.setDefault(new g(ProxySelector.getDefault(), str, i4));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f45345a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f45346b.equals(uri.getHost()) && this.f45347c == uri.getPort() ? f45344d : this.f45345a.select(uri);
    }
}
