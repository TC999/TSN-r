package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.danikula.videocache.file.C6545b;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpProxyCacheServerClients.java */
/* renamed from: com.danikula.videocache.j */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6561j {

    /* renamed from: a */
    private final AtomicInteger f23109a = new AtomicInteger(0);

    /* renamed from: b */
    private final String f23110b;

    /* renamed from: c */
    private volatile C6555h f23111c;

    /* renamed from: d */
    private final List<InterfaceC6542e> f23112d;

    /* renamed from: e */
    private final InterfaceC6542e f23113e;

    /* renamed from: f */
    private final C6543f f23114f;

    /* compiled from: HttpProxyCacheServerClients.java */
    /* renamed from: com.danikula.videocache.j$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class HandlerC6562a extends Handler implements InterfaceC6542e {

        /* renamed from: a */
        private final String f23115a;

        /* renamed from: b */
        private final List<InterfaceC6542e> f23116b;

        public HandlerC6562a(String str, List<InterfaceC6542e> list) {
            super(Looper.getMainLooper());
            this.f23115a = str;
            this.f23116b = list;
        }

        @Override // com.danikula.videocache.InterfaceC6542e
        /* renamed from: a */
        public void mo35682a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (InterfaceC6542e interfaceC6542e : this.f23116b) {
                interfaceC6542e.mo35682a((File) message.obj, this.f23115a, message.arg1);
            }
        }
    }

    public C6561j(String str, C6543f c6543f) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f23112d = copyOnWriteArrayList;
        this.f23110b = (String) C6567n.m35858d(str);
        this.f23114f = (C6543f) C6567n.m35858d(c6543f);
        this.f23113e = new HandlerC6562a(str, copyOnWriteArrayList);
    }

    /* renamed from: a */
    private synchronized void m35883a() {
        if (this.f23109a.decrementAndGet() <= 0) {
            this.f23111c.m35844m();
            this.f23111c = null;
        }
    }

    /* renamed from: c */
    private C6555h m35881c() throws ProxyCacheException {
        C6555h c6555h = new C6555h(new C6563k(this.f23110b, this.f23114f.f23068d), new C6545b(this.f23114f.m35943a(this.f23110b), this.f23114f.f23067c));
        c6555h.m35917t(this.f23113e);
        return c6555h;
    }

    /* renamed from: g */
    private synchronized void m35877g() throws ProxyCacheException {
        this.f23111c = this.f23111c == null ? m35881c() : this.f23111c;
    }

    /* renamed from: b */
    public int m35882b() {
        return this.f23109a.get();
    }

    /* renamed from: d */
    public void m35880d(C6554g c6554g, Socket socket) throws ProxyCacheException, IOException {
        m35877g();
        try {
            this.f23109a.incrementAndGet();
            this.f23111c.m35918s(c6554g, socket);
        } finally {
            m35883a();
        }
    }

    /* renamed from: e */
    public void m35879e(InterfaceC6542e interfaceC6542e) {
        this.f23112d.add(interfaceC6542e);
    }

    /* renamed from: f */
    public void m35878f() {
        this.f23112d.clear();
        if (this.f23111c != null) {
            this.f23111c.m35917t(null);
            this.f23111c.m35844m();
            this.f23111c = null;
        }
        this.f23109a.set(0);
    }

    /* renamed from: h */
    public void m35876h(InterfaceC6542e interfaceC6542e) {
        this.f23112d.remove(interfaceC6542e);
    }
}
