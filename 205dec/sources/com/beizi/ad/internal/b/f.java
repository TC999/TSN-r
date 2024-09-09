package com.beizi.ad.internal.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.beizi.ad.internal.utilities.HaoboLog;
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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpProxyCacheServer.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f13697a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f13698b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, g> f13699c;

    /* renamed from: d  reason: collision with root package name */
    private final ServerSocket f13700d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13701e;

    /* renamed from: f  reason: collision with root package name */
    private final Thread f13702f;

    /* renamed from: g  reason: collision with root package name */
    private final com.beizi.ad.internal.b.c f13703g;

    /* renamed from: h  reason: collision with root package name */
    private final j f13704h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpProxyCacheServer.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private File f13705a;

        /* renamed from: d  reason: collision with root package name */
        private com.beizi.ad.internal.b.b.c f13708d;

        /* renamed from: c  reason: collision with root package name */
        private com.beizi.ad.internal.b.a.a f13707c = new com.beizi.ad.internal.b.a.g(536870912);

        /* renamed from: b  reason: collision with root package name */
        private com.beizi.ad.internal.b.a.c f13706b = new com.beizi.ad.internal.b.a.f();

        public a(Context context) {
            this.f13708d = com.beizi.ad.internal.b.b.d.a(context);
            this.f13705a = q.a(context);
        }

        private com.beizi.ad.internal.b.c b() {
            return new com.beizi.ad.internal.b.c(this.f13705a, this.f13706b, this.f13707c, this.f13708d);
        }

        public a a(long j4) {
            this.f13707c = new com.beizi.ad.internal.b.a.g(j4);
            return this;
        }

        public f a() {
            return new f(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpProxyCacheServer.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Socket f13710b;

        public b(Socket socket) {
            this.f13710b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.a(this.f13710b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpProxyCacheServer.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CountDownLatch f13712b;

        public c(CountDownLatch countDownLatch) {
            this.f13712b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13712b.countDown();
            f.this.b();
        }
    }

    private String c(String str) {
        String a4 = com.beizi.ad.lance.a.b.a("aHR0cDovLyVzOiVkLyVz");
        if (TextUtils.isEmpty(a4)) {
            return null;
        }
        return String.format(Locale.US, a4, com.beizi.ad.lance.a.b.a("MTI3LjAuMC4x"), Integer.valueOf(this.f13701e), n.b(str));
    }

    private File d(String str) {
        com.beizi.ad.internal.b.c cVar = this.f13703g;
        return new File(cVar.f13685a, cVar.f13686b.a(str));
    }

    private g e(String str) throws m {
        g gVar;
        synchronized (this.f13697a) {
            gVar = this.f13699c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.f13703g);
                this.f13699c.put(str, gVar);
            }
        }
        return gVar;
    }

    public boolean b(String str) {
        k.a(str, "Url can't be null!");
        return d(str).exists();
    }

    private f(com.beizi.ad.internal.b.c cVar) {
        this.f13697a = new Object();
        this.f13698b = Executors.newFixedThreadPool(8);
        this.f13699c = new ConcurrentHashMap();
        this.f13703g = (com.beizi.ad.internal.b.c) k.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(com.beizi.ad.lance.a.b.a("MTI3LjAuMC4x")));
            this.f13700d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f13701e = localPort;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f13702f = thread;
            thread.start();
            countDownLatch.await();
            this.f13704h = new j(com.beizi.ad.lance.a.b.a("MTI3LjAuMC4x"), localPort);
            String str = HaoboLog.httpProxyCacheServerLogTag;
            HaoboLog.i(str, "Proxy cache server started. Is it alive? " + a());
        } catch (IOException | InterruptedException e4) {
            this.f13698b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f13700d.accept();
                String str = HaoboLog.httpProxyCacheServerLogTag;
                HaoboLog.d(str, "Accept new socket " + accept);
                this.f13698b.submit(new b(accept));
            } catch (IOException e4) {
                a(new m("Error during waiting connection", e4));
                return;
            }
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    private int c() {
        int i4;
        synchronized (this.f13697a) {
            i4 = 0;
            for (g gVar : this.f13699c.values()) {
                i4 += gVar.a();
            }
        }
        return i4;
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e4) {
            HaoboLog.w(HaoboLog.httpProxyCacheServerLogTag, "Failed to close socket on proxy side: {}. It seems client have already closed connection.", e4);
        }
    }

    public String a(String str, boolean z3) {
        if (!z3 || !b(str)) {
            return a() ? c(str) : str;
        }
        File d4 = d(str);
        a(d4);
        return Uri.fromFile(d4).toString();
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e4) {
            a(new m("Error closing socket", e4));
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private boolean a() {
        return this.f13704h.a(3, 70);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
        } catch (IOException e4) {
            a(new m("Error closing socket input stream", e4));
        }
    }

    private void a(File file) {
        try {
            this.f13703g.f13687c.a(file);
        } catch (IOException e4) {
            String str = HaoboLog.httpProxyCacheServerLogTag;
            HaoboLog.e(str, "Error touching file " + file, e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        String str;
        StringBuilder sb;
        try {
            try {
                d a4 = d.a(socket.getInputStream());
                String str2 = HaoboLog.httpProxyCacheServerLogTag;
                HaoboLog.d(str2, "Request to cache proxy:" + a4);
                String c4 = n.c(a4.f13691a);
                if (this.f13704h.a(c4)) {
                    this.f13704h.a(socket);
                } else {
                    e(c4).a(a4, socket);
                }
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            } catch (m e4) {
                e = e4;
                a(new m("Error processing request", e));
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            } catch (SocketException unused) {
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            } catch (IOException e5) {
                e = e5;
                a(new m("Error processing request", e));
                b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(c());
            HaoboLog.d(str, sb.toString());
        } catch (Throwable th) {
            b(socket);
            String str3 = HaoboLog.httpProxyCacheServerLogTag;
            HaoboLog.d(str3, "Opened connections: " + c());
            throw th;
        }
    }

    private void a(Throwable th) {
        HaoboLog.e(HaoboLog.httpProxyCacheServerLogTag, "HttpProxyCacheServer error", th);
    }
}
