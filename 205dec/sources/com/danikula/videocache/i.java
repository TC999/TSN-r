package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HttpProxyCacheServer.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class i {

    /* renamed from: i  reason: collision with root package name */
    private static final org.slf4j.c f36757i = org.slf4j.d.j("HttpProxyCacheServer");

    /* renamed from: j  reason: collision with root package name */
    private static final String f36758j = "127.0.0.1";

    /* renamed from: a  reason: collision with root package name */
    private final Object f36759a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f36760b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, j> f36761c;

    /* renamed from: d  reason: collision with root package name */
    private final ServerSocket f36762d;

    /* renamed from: e  reason: collision with root package name */
    private final int f36763e;

    /* renamed from: f  reason: collision with root package name */
    private final Thread f36764f;

    /* renamed from: g  reason: collision with root package name */
    private final f f36765g;

    /* renamed from: h  reason: collision with root package name */
    private final m f36766h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: HttpProxyCacheServer.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        private static final long f36767e = 536870912;

        /* renamed from: a  reason: collision with root package name */
        private File f36768a;

        /* renamed from: d  reason: collision with root package name */
        private com.danikula.videocache.sourcestorage.c f36771d;

        /* renamed from: c  reason: collision with root package name */
        private com.danikula.videocache.file.a f36770c = new com.danikula.videocache.file.h(536870912);

        /* renamed from: b  reason: collision with root package name */
        private com.danikula.videocache.file.c f36769b = new com.danikula.videocache.file.f();

        public b(Context context) {
            this.f36771d = com.danikula.videocache.sourcestorage.d.b(context);
            this.f36768a = t.c(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public f c() {
            return new f(this.f36768a, this.f36769b, this.f36770c, this.f36771d);
        }

        public i b() {
            return new i(c());
        }

        public b d(File file) {
            this.f36768a = (File) n.d(file);
            return this;
        }

        public b e(com.danikula.videocache.file.a aVar) {
            this.f36770c = (com.danikula.videocache.file.a) n.d(aVar);
            return this;
        }

        public b f(com.danikula.videocache.file.c cVar) {
            this.f36769b = (com.danikula.videocache.file.c) n.d(cVar);
            return this;
        }

        public b g(int i4) {
            this.f36770c = new com.danikula.videocache.file.g(i4);
            return this;
        }

        public b h(long j4) {
            this.f36770c = new com.danikula.videocache.file.h(j4);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: HttpProxyCacheServer.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Socket f36772a;

        public c(Socket socket) {
            this.f36772a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.o(this.f36772a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: HttpProxyCacheServer.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f36774a;

        public d(CountDownLatch countDownLatch) {
            this.f36774a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f36774a.countDown();
            i.this.w();
        }
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f36763e), p.f(str));
    }

    private void d(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e4) {
            n(new ProxyCacheException("Error closing socket", e4));
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            f36757i.debug("Releasing input stream\u2026 Socket is closed by client.");
        } catch (IOException e4) {
            n(new ProxyCacheException("Error closing socket input stream", e4));
        }
    }

    private void f(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e4) {
            f36757i.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e4.getMessage());
        }
    }

    private File g(String str) {
        f fVar = this.f36765g;
        return new File(fVar.f36732a, fVar.f36733b.generate(str));
    }

    private j h(String str) throws ProxyCacheException {
        j jVar;
        synchronized (this.f36759a) {
            jVar = this.f36761c.get(str);
            if (jVar == null) {
                jVar = new j(str, this.f36765g);
                this.f36761c.put(str, jVar);
            }
        }
        return jVar;
    }

    private int i() {
        int i4;
        synchronized (this.f36759a) {
            i4 = 0;
            for (j jVar : this.f36761c.values()) {
                i4 += jVar.b();
            }
        }
        return i4;
    }

    private boolean l() {
        return this.f36766h.e(3, 70);
    }

    private void n(Throwable th) {
        f36757i.error("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Socket socket) {
        try {
            try {
                g c4 = g.c(socket.getInputStream());
                org.slf4j.c cVar = f36757i;
                cVar.debug("Request to cache proxy:" + c4);
                String e4 = p.e(c4.f36750a);
                if (this.f36766h.d(e4)) {
                    this.f36766h.g(socket);
                } else {
                    h(e4).d(c4, socket);
                }
                q(socket);
                cVar.debug("Opened connections: " + i());
            } catch (ProxyCacheException e5) {
                e = e5;
                n(new ProxyCacheException("Error processing request", e));
            } catch (SocketException unused) {
                org.slf4j.c cVar2 = f36757i;
                cVar2.debug("Closing socket\u2026 Socket is closed by client.");
                q(socket);
                cVar2.debug("Opened connections: " + i());
            } catch (IOException e6) {
                e = e6;
                n(new ProxyCacheException("Error processing request", e));
            }
        } finally {
            q(socket);
            org.slf4j.c cVar3 = f36757i;
            cVar3.debug("Opened connections: " + i());
        }
    }

    private void q(Socket socket) {
        e(socket);
        f(socket);
        d(socket);
    }

    private void s() {
        synchronized (this.f36759a) {
            for (j jVar : this.f36761c.values()) {
                jVar.f();
            }
            this.f36761c.clear();
        }
    }

    private void t(File file) {
        try {
            this.f36765g.f36734c.a(file);
        } catch (IOException e4) {
            org.slf4j.c cVar = f36757i;
            cVar.error("Error touching file " + file, (Throwable) e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f36762d.accept();
                org.slf4j.c cVar = f36757i;
                cVar.debug("Accept new socket " + accept);
                this.f36760b.submit(new c(accept));
            } catch (IOException e4) {
                n(new ProxyCacheException("Error during waiting connection", e4));
                return;
            }
        }
    }

    public String j(String str) {
        return k(str, true);
    }

    public String k(String str, boolean z3) {
        if (!z3 || !m(str)) {
            return l() ? c(str) : str;
        }
        File g4 = g(str);
        t(g4);
        return Uri.fromFile(g4).toString();
    }

    public boolean m(String str) {
        n.e(str, "Url can't be null!");
        return g(str).exists();
    }

    public void p(e eVar, String str) {
        n.a(eVar, str);
        synchronized (this.f36759a) {
            try {
                h(str).e(eVar);
            } catch (ProxyCacheException e4) {
                f36757i.warn("Error registering cache listener", (Throwable) e4);
            }
        }
    }

    public void r() {
        f36757i.info("Shutdown proxy server");
        s();
        this.f36765g.f36735d.release();
        this.f36764f.interrupt();
        try {
            if (this.f36762d.isClosed()) {
                return;
            }
            this.f36762d.close();
        } catch (IOException e4) {
            n(new ProxyCacheException("Error shutting down proxy server", e4));
        }
    }

    public void u(e eVar) {
        n.d(eVar);
        synchronized (this.f36759a) {
            for (j jVar : this.f36761c.values()) {
                jVar.h(eVar);
            }
        }
    }

    public void v(e eVar, String str) {
        n.a(eVar, str);
        synchronized (this.f36759a) {
            try {
                h(str).h(eVar);
            } catch (ProxyCacheException e4) {
                f36757i.warn("Error registering cache listener", (Throwable) e4);
            }
        }
    }

    public i(Context context) {
        this(new b(context).c());
    }

    private i(f fVar) {
        this.f36759a = new Object();
        this.f36760b = Executors.newFixedThreadPool(8);
        this.f36761c = new ConcurrentHashMap();
        this.f36765g = (f) n.d(fVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f36762d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f36763e = localPort;
            l.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new d(countDownLatch));
            this.f36764f = thread;
            thread.start();
            countDownLatch.await();
            this.f36766h = new m("127.0.0.1", localPort);
            org.slf4j.c cVar = f36757i;
            cVar.info("Proxy cache server started. Is it alive? " + l());
        } catch (IOException | InterruptedException e4) {
            this.f36760b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e4);
        }
    }
}
