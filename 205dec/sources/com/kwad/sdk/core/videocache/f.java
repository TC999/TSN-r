package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.ap;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    private final Object aBU;
    private final ExecutorService aBV;
    private final Map<String, g> aBW;
    private final ServerSocket aBX;
    private final Thread aBY;
    private final com.kwad.sdk.core.videocache.c aBZ;
    private final int port;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private File aBG;
        private com.kwad.sdk.core.videocache.d.c aBJ;
        private int aBL;
        private Context context;
        private int aBM = 0;
        private com.kwad.sdk.core.videocache.a.a aBI = new com.kwad.sdk.core.videocache.a.g(536870912);
        private com.kwad.sdk.core.videocache.a.c aBH = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aBK = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aBG = o.bk(context);
        }

        private com.kwad.sdk.core.videocache.c Gs() {
            return new com.kwad.sdk.core.videocache.c(this.aBG, this.aBH, this.aBI, this.aBJ, this.aBK, this.aBL, this.aBM);
        }

        public final f Gr() {
            this.aBJ = com.kwad.sdk.core.videocache.d.d.j(this.context, this.aBM);
            return new f(Gs(), (byte) 0);
        }

        public final a as(long j4) {
            this.aBI = new com.kwad.sdk.core.videocache.a.g(536870912L);
            return this;
        }

        public final a ds(int i4) {
            this.aBL = i4;
            return this;
        }

        public final a dt(int i4) {
            this.aBM = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class b implements Runnable {
        private final Socket aCa;

        public b(Socket socket) {
            this.aCa = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aCa);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    final class c implements Runnable {
        private final CountDownLatch aCc;

        public c(CountDownLatch countDownLatch) {
            this.aCc = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aCc.countDown();
                f.this.Gp();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b4) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aBX.accept();
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aBV.submit(new b(accept));
            } catch (IOException e4) {
                onError(new ProxyCacheException("Error during waiting connection", e4));
                return;
            }
        }
    }

    private int Gq() {
        int i4;
        synchronized (this.aBU) {
            i4 = 0;
            for (g gVar : this.aBW.values()) {
                i4 += gVar.Gq();
            }
        }
        return i4;
    }

    private File T(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aBZ;
        return new File(cVar.aBG, cVar.aBH.generate(str));
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Releasing input stream\u2026 Socket is closed by client.");
        } catch (IOException e4) {
            onError(new ProxyCacheException("Error closing socket input stream", e4));
        }
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.e.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e4) {
            onError(new ProxyCacheException("Error closing socket", e4));
        }
    }

    private String eE(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), l.encode(str));
    }

    private File eF(String str) {
        File file = this.aBZ.aBG;
        return new File(file, this.aBZ.aBH.generate(str) + ".download");
    }

    private g eG(String str) {
        g gVar;
        synchronized (this.aBU) {
            gVar = this.aBW.get(str);
            if (gVar == null) {
                gVar = new g(str, this.aBZ);
                this.aBW.put(str, gVar);
            }
        }
        return gVar;
    }

    private String f(String str, boolean z3) {
        if (T(str).exists()) {
            File T = T(str);
            r(T);
            return Uri.fromFile(T).toString();
        }
        return eE(str);
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
    }

    private void r(File file) {
        try {
            this.aBZ.aBI.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.e.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final String eA(String str) {
        return f(str, true);
    }

    public final boolean eB(String str) {
        ap.ax(str, "Url can't be null!");
        return T(str).exists();
    }

    public final boolean eC(String str) {
        ap.ax(str, "Url can't be null!");
        return eF(str).exists() || T(str).exists();
    }

    public final boolean eD(String str) {
        g gVar = this.aBW.get(str);
        if (gVar != null) {
            gVar.shutdown();
            this.aBW.remove(str);
            return true;
        }
        return false;
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aBU = new Object();
        this.aBV = GlobalThreadPools.FI();
        this.aBW = new ConcurrentHashMap();
        this.aBZ = (com.kwad.sdk.core.videocache.c) ap.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aBX = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aBY = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e4) {
            this.aBV.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e4);
        }
    }

    public final boolean a(String str, long j4, a.C0699a c0699a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (eB(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(eE(str), null, c0699a, j4, adHttpResponseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    public void a(Socket socket) {
        StringBuilder sb;
        ?? r02 = "Opened connections: ";
        try {
            try {
                d b4 = d.b(socket.getInputStream());
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Request to cache proxy:" + b4);
                eG(l.decode(b4.uri)).a(b4, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e4) {
                e = e4;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e5) {
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Closing socket\u2026 Socket is closed by client.");
                e5.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e6) {
                e = e6;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            r02 = Gq();
            sb.append((int) r02);
            socket = sb.toString();
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", ((String) r02) + Gq());
            throw th;
        }
    }
}
