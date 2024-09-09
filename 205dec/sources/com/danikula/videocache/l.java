package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: IgnoreHostProxySelector.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
class l extends ProxySelector {

    /* renamed from: d  reason: collision with root package name */
    private static final List<Proxy> f36790d = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: a  reason: collision with root package name */
    private final ProxySelector f36791a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36792b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36793c;

    l(ProxySelector proxySelector, String str, int i4) {
        this.f36791a = (ProxySelector) n.d(proxySelector);
        this.f36792b = (String) n.d(str);
        this.f36793c = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i4) {
        ProxySelector.setDefault(new l(ProxySelector.getDefault(), str, i4));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f36791a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f36792b.equals(uri.getHost()) && this.f36793c == uri.getPort() ? f36790d : this.f36791a.select(uri);
    }
}
