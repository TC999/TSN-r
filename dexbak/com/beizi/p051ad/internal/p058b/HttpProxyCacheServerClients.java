package com.beizi.p051ad.internal.p058b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.beizi.p051ad.internal.p058b.p059a.FileCache;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.b.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HttpProxyCacheServerClients {

    /* renamed from: a */
    private final AtomicInteger f10036a = new AtomicInteger(0);

    /* renamed from: b */
    private final String f10037b;

    /* renamed from: c */
    private volatile HttpProxyCache f10038c;

    /* renamed from: d */
    private final List<CacheListener> f10039d;

    /* renamed from: e */
    private final CacheListener f10040e;

    /* renamed from: f */
    private final Config f10041f;

    /* compiled from: HttpProxyCacheServerClients.java */
    /* renamed from: com.beizi.ad.internal.b.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class HandlerC2870a extends Handler implements CacheListener {

        /* renamed from: a */
        private final String f10042a;

        /* renamed from: b */
        private final List<CacheListener> f10043b;

        public HandlerC2870a(String str, List<CacheListener> list) {
            super(Looper.getMainLooper());
            this.f10042a = str;
            this.f10043b = list;
        }

        @Override // com.beizi.p051ad.internal.p058b.CacheListener
        /* renamed from: a */
        public void mo49585a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (CacheListener cacheListener : this.f10043b) {
                cacheListener.mo49585a((File) message.obj, this.f10042a, message.arg1);
            }
        }
    }

    public HttpProxyCacheServerClients(String str, Config config) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f10039d = copyOnWriteArrayList;
        this.f10037b = (String) Preconditions.m49572a(str);
        this.f10041f = (Config) Preconditions.m49572a(config);
        this.f10040e = new HandlerC2870a(str, copyOnWriteArrayList);
    }

    /* renamed from: b */
    private synchronized void m49588b() throws ProxyCacheException {
        this.f10038c = this.f10038c == null ? m49586d() : this.f10038c;
    }

    /* renamed from: c */
    private synchronized void m49587c() {
        if (this.f10036a.decrementAndGet() <= 0) {
            this.f10038c.m49567a();
            this.f10038c = null;
        }
    }

    /* renamed from: d */
    private HttpProxyCache m49586d() throws ProxyCacheException {
        HttpProxyCache httpProxyCache = new HttpProxyCache(new HttpUrlSource(this.f10037b, this.f10041f.f10011d), new FileCache(this.f10041f.m49621a(this.f10037b), this.f10041f.f10010c));
        httpProxyCache.m49617a(this.f10040e);
        return httpProxyCache;
    }

    /* renamed from: a */
    public void m49589a(GetRequest getRequest, Socket socket) throws ProxyCacheException, IOException {
        m49588b();
        try {
            this.f10036a.incrementAndGet();
            this.f10038c.m49615a(getRequest, socket);
        } finally {
            m49587c();
        }
    }

    /* renamed from: a */
    public int m49590a() {
        return this.f10036a.get();
    }
}
