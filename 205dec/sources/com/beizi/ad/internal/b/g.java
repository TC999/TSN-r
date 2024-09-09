package com.beizi.ad.internal.b;

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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpProxyCacheServerClients.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f13713a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final String f13714b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f13715c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f13716d;

    /* renamed from: e  reason: collision with root package name */
    private final b f13717e;

    /* renamed from: f  reason: collision with root package name */
    private final c f13718f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpProxyCacheServerClients.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f13719a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f13720b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f13719a = str;
            this.f13720b = list;
        }

        @Override // com.beizi.ad.internal.b.b
        public void a(File file, String str, int i4) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i4;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (b bVar : this.f13720b) {
                bVar.a((File) message.obj, this.f13719a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f13716d = copyOnWriteArrayList;
        this.f13714b = (String) k.a(str);
        this.f13718f = (c) k.a(cVar);
        this.f13717e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void b() throws m {
        this.f13715c = this.f13715c == null ? d() : this.f13715c;
    }

    private synchronized void c() {
        if (this.f13713a.decrementAndGet() <= 0) {
            this.f13715c.a();
            this.f13715c = null;
        }
    }

    private e d() throws m {
        e eVar = new e(new h(this.f13714b, this.f13718f.f13688d), new com.beizi.ad.internal.b.a.b(this.f13718f.a(this.f13714b), this.f13718f.f13687c));
        eVar.a(this.f13717e);
        return eVar;
    }

    public void a(d dVar, Socket socket) throws m, IOException {
        b();
        try {
            this.f13713a.incrementAndGet();
            this.f13715c.a(dVar, socket);
        } finally {
            c();
        }
    }

    public int a() {
        return this.f13713a.get();
    }
}
