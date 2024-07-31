package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.videocache.p413a.C10556f;
import com.kwad.sdk.core.videocache.p413a.C10557g;
import com.kwad.sdk.core.videocache.p413a.InterfaceC10549a;
import com.kwad.sdk.core.videocache.p413a.InterfaceC10551c;
import com.kwad.sdk.core.videocache.p414b.C10559a;
import com.kwad.sdk.core.videocache.p414b.InterfaceC10560b;
import com.kwad.sdk.core.videocache.p416d.C10567d;
import com.kwad.sdk.core.videocache.p416d.InterfaceC10566c;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.C11023ap;
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
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.kwad.sdk.core.videocache.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10569f {
    private final Object aBU;
    private final ExecutorService aBV;
    private final Map<String, C10573g> aBW;
    private final ServerSocket aBX;
    private final Thread aBY;
    private final C10561c aBZ;
    private final int port;

    /* renamed from: com.kwad.sdk.core.videocache.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10570a {
        private File aBG;
        private InterfaceC10566c aBJ;
        private int aBL;
        private Context context;
        private int aBM = 0;
        private InterfaceC10549a aBI = new C10557g(IjkMediaMeta.AV_CH_STEREO_LEFT);
        private InterfaceC10551c aBH = new C10556f();
        private InterfaceC10560b aBK = new C10559a();

        public C10570a(Context context) {
            this.context = context;
            this.aBG = C10583o.m25394bk(context);
        }

        /* renamed from: Gs */
        private C10561c m25431Gs() {
            return new C10561c(this.aBG, this.aBH, this.aBI, this.aBJ, this.aBK, this.aBL, this.aBM);
        }

        /* renamed from: Gr */
        public final C10569f m25432Gr() {
            this.aBJ = C10567d.m25459j(this.context, this.aBM);
            return new C10569f(m25431Gs(), (byte) 0);
        }

        /* renamed from: as */
        public final C10570a m25430as(long j) {
            this.aBI = new C10557g(IjkMediaMeta.AV_CH_STEREO_LEFT);
            return this;
        }

        /* renamed from: ds */
        public final C10570a m25429ds(int i) {
            this.aBL = i;
            return this;
        }

        /* renamed from: dt */
        public final C10570a m25428dt(int i) {
            this.aBM = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.videocache.f$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class RunnableC10571b implements Runnable {
        private final Socket aCa;

        public RunnableC10571b(Socket socket) {
            this.aCa = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C10331c.m26254d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            C10569f.this.m25446a(this.aCa);
        }
    }

    /* renamed from: com.kwad.sdk.core.videocache.f$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    final class RunnableC10572c implements Runnable {
        private final CountDownLatch aCc;

        public RunnableC10572c(CountDownLatch countDownLatch) {
            this.aCc = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aCc.countDown();
                C10569f.this.m25452Gp();
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
            }
        }
    }

    /* synthetic */ C10569f(C10561c c10561c, byte b) {
        this(c10561c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Gp */
    public void m25452Gp() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aBX.accept();
                C10331c.m26254d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aBV.submit(new RunnableC10571b(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* renamed from: Gq */
    private int m25451Gq() {
        int i;
        synchronized (this.aBU) {
            i = 0;
            for (C10573g c10573g : this.aBW.values()) {
                i += c10573g.m25427Gq();
            }
        }
        return i;
    }

    /* renamed from: T */
    private File m25450T(String str) {
        C10561c c10561c = this.aBZ;
        return new File(c10561c.aBG, c10561c.aBH.generate(str));
    }

    /* renamed from: b */
    private void m25445b(Socket socket) {
        m25444c(socket);
        m25443d(socket);
        m25442e(socket);
    }

    /* renamed from: c */
    private void m25444c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            C10331c.m26254d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    /* renamed from: d */
    private static void m25443d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            C10331c.m26246w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    /* renamed from: e */
    private void m25442e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    /* renamed from: eE */
    private String m25437eE(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), C10580l.encode(str));
    }

    /* renamed from: eF */
    private File m25436eF(String str) {
        File file = this.aBZ.aBG;
        return new File(file, this.aBZ.aBH.generate(str) + ".download");
    }

    /* renamed from: eG */
    private C10573g m25435eG(String str) {
        C10573g c10573g;
        synchronized (this.aBU) {
            c10573g = this.aBW.get(str);
            if (c10573g == null) {
                c10573g = new C10573g(str, this.aBZ);
                this.aBW.put(str, c10573g);
            }
        }
        return c10573g;
    }

    /* renamed from: f */
    private String m25434f(String str, boolean z) {
        if (m25450T(str).exists()) {
            File m25450T = m25450T(str);
            m25433r(m25450T);
            return Uri.fromFile(m25450T).toString();
        }
        return m25437eE(str);
    }

    private static void onError(Throwable th) {
        C10331c.printStackTraceOnly(th);
    }

    /* renamed from: r */
    private void m25433r(File file) {
        try {
            this.aBZ.aBI.mo25476s(file);
        } catch (IOException unused) {
            C10331c.m26250e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    /* renamed from: eA */
    public final String m25441eA(String str) {
        return m25434f(str, true);
    }

    /* renamed from: eB */
    public final boolean m25440eB(String str) {
        C11023ap.m24089ax(str, "Url can't be null!");
        return m25450T(str).exists();
    }

    /* renamed from: eC */
    public final boolean m25439eC(String str) {
        C11023ap.m24089ax(str, "Url can't be null!");
        return m25436eF(str).exists() || m25450T(str).exists();
    }

    /* renamed from: eD */
    public final boolean m25438eD(String str) {
        C10573g c10573g = this.aBW.get(str);
        if (c10573g != null) {
            c10573g.shutdown();
            this.aBW.remove(str);
            return true;
        }
        return false;
    }

    private C10569f(C10561c c10561c) {
        this.aBU = new Object();
        this.aBV = GlobalThreadPools.m25600FI();
        this.aBW = new ConcurrentHashMap();
        this.aBZ = (C10561c) C11023ap.checkNotNull(c10561c);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aBX = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            C10576i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new RunnableC10572c(countDownLatch));
            this.aBY = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aBV.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* renamed from: a */
    public final boolean m25447a(String str, long j, C10404a.C10405a c10405a, AdHttpResponseListener adHttpResponseListener) {
        C10331c.m26254d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (m25440eB(str)) {
            return true;
        }
        return C10404a.m26173a(m25437eE(str), null, c10405a, j, adHttpResponseListener);
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
    /* renamed from: a */
    public void m25446a(Socket socket) {
        StringBuilder sb;
        ?? r0 = "Opened connections: ";
        try {
            try {
                C10563d m25466b = C10563d.m25466b(socket.getInputStream());
                C10331c.m26254d("HttpProxyCacheServer", "Request to cache proxy:" + m25466b);
                m25435eG(C10580l.decode(m25466b.uri)).m25422a(m25466b, socket);
                m25445b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                m25445b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                C10331c.m26254d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                m25445b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                m25445b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            r0 = m25451Gq();
            sb.append((int) r0);
            socket = sb.toString();
            C10331c.m26254d("HttpProxyCacheServer", socket);
        } catch (Throwable th) {
            m25445b(socket);
            C10331c.m26254d("HttpProxyCacheServer", ((String) r0) + m25451Gq());
            throw th;
        }
    }
}
