package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HttpProxyCacheServerClients.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f36776a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final String f36777b;

    /* renamed from: c  reason: collision with root package name */
    private volatile h f36778c;

    /* renamed from: d  reason: collision with root package name */
    private final List<e> f36779d;

    /* renamed from: e  reason: collision with root package name */
    private final e f36780e;

    /* renamed from: f  reason: collision with root package name */
    private final f f36781f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: HttpProxyCacheServerClients.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static final class a extends Handler implements e {

        /* renamed from: a  reason: collision with root package name */
        private final String f36782a;

        /* renamed from: b  reason: collision with root package name */
        private final List<e> f36783b;

        public a(String str, List<e> list) {
            super(Looper.getMainLooper());
            this.f36782a = str;
            this.f36783b = list;
        }

        @Override // com.danikula.videocache.e
        public void a(File file, String str, int i4) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i4;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (e eVar : this.f36783b) {
                eVar.a((File) message.obj, this.f36782a, message.arg1);
            }
        }
    }

    public j(String str, f fVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f36779d = copyOnWriteArrayList;
        this.f36777b = (String) n.d(str);
        this.f36781f = (f) n.d(fVar);
        this.f36780e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void a() {
        if (this.f36776a.decrementAndGet() <= 0) {
            this.f36778c.m();
            this.f36778c = null;
        }
    }

    private h c() throws ProxyCacheException {
        h hVar = new h(new k(this.f36777b, this.f36781f.f36735d), new com.danikula.videocache.file.b(this.f36781f.a(this.f36777b), this.f36781f.f36734c));
        hVar.t(this.f36780e);
        return hVar;
    }

    private synchronized void g() throws ProxyCacheException {
        this.f36778c = this.f36778c == null ? c() : this.f36778c;
    }

    public int b() {
        return this.f36776a.get();
    }

    public void d(g gVar, Socket socket) throws ProxyCacheException, IOException {
        g();
        try {
            this.f36776a.incrementAndGet();
            this.f36778c.s(gVar, socket);
        } finally {
            a();
        }
    }

    public void e(e eVar) {
        this.f36779d.add(eVar);
    }

    public void f() {
        this.f36779d.clear();
        if (this.f36778c != null) {
            this.f36778c.t(null);
            this.f36778c.m();
            this.f36778c = null;
        }
        this.f36776a.set(0);
    }

    public void h(e eVar) {
        this.f36779d.remove(eVar);
    }
}
