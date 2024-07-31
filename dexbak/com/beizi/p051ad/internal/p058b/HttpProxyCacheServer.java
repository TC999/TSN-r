package com.beizi.p051ad.internal.p058b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.beizi.p051ad.internal.p058b.p059a.DiskUsage;
import com.beizi.p051ad.internal.p058b.p059a.FileNameGenerator;
import com.beizi.p051ad.internal.p058b.p059a.Md5FileNameGenerator;
import com.beizi.p051ad.internal.p058b.p059a.TotalSizeLruDiskUsage;
import com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorage;
import com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorageFactory;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.lance.p062a.C3019b;
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
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.beizi.ad.internal.b.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpProxyCacheServer {

    /* renamed from: a */
    private final Object f10020a;

    /* renamed from: b */
    private final ExecutorService f10021b;

    /* renamed from: c */
    private final Map<String, HttpProxyCacheServerClients> f10022c;

    /* renamed from: d */
    private final ServerSocket f10023d;

    /* renamed from: e */
    private final int f10024e;

    /* renamed from: f */
    private final Thread f10025f;

    /* renamed from: g */
    private final Config f10026g;

    /* renamed from: h */
    private final Pinger f10027h;

    /* compiled from: HttpProxyCacheServer.java */
    /* renamed from: com.beizi.ad.internal.b.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C2867a {

        /* renamed from: a */
        private File f10028a;

        /* renamed from: d */
        private SourceInfoStorage f10031d;

        /* renamed from: c */
        private DiskUsage f10030c = new TotalSizeLruDiskUsage(IjkMediaMeta.AV_CH_STEREO_LEFT);

        /* renamed from: b */
        private FileNameGenerator f10029b = new Md5FileNameGenerator();

        public C2867a(Context context) {
            this.f10031d = SourceInfoStorageFactory.m49622a(context);
            this.f10028a = StorageUtils.m49541a(context);
        }

        /* renamed from: b */
        private Config m49591b() {
            return new Config(this.f10028a, this.f10029b, this.f10030c, this.f10031d);
        }

        /* renamed from: a */
        public C2867a m49592a(long j) {
            this.f10030c = new TotalSizeLruDiskUsage(j);
            return this;
        }

        /* renamed from: a */
        public HttpProxyCacheServer m49593a() {
            return new HttpProxyCacheServer(m49591b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpProxyCacheServer.java */
    /* renamed from: com.beizi.ad.internal.b.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC2868b implements Runnable {

        /* renamed from: b */
        private final Socket f10033b;

        public RunnableC2868b(Socket socket) {
            this.f10033b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpProxyCacheServer.this.m49604a(this.f10033b);
        }
    }

    /* compiled from: HttpProxyCacheServer.java */
    /* renamed from: com.beizi.ad.internal.b.f$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private final class RunnableC2869c implements Runnable {

        /* renamed from: b */
        private final CountDownLatch f10035b;

        public RunnableC2869c(CountDownLatch countDownLatch) {
            this.f10035b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10035b.countDown();
            HttpProxyCacheServer.this.m49603b();
        }
    }

    /* renamed from: c */
    private String m49599c(String str) {
        String m49089a = C3019b.m49089a("aHR0cDovLyVzOiVkLyVz");
        if (TextUtils.isEmpty(m49089a)) {
            return null;
        }
        return String.format(Locale.US, m49089a, C3019b.m49089a("MTI3LjAuMC4x"), Integer.valueOf(this.f10024e), ProxyCacheUtils.m49548b(str));
    }

    /* renamed from: d */
    private File m49597d(String str) {
        Config config = this.f10026g;
        return new File(config.f10008a, config.f10009b.mo49631a(str));
    }

    /* renamed from: e */
    private HttpProxyCacheServerClients m49595e(String str) throws ProxyCacheException {
        HttpProxyCacheServerClients httpProxyCacheServerClients;
        synchronized (this.f10020a) {
            httpProxyCacheServerClients = this.f10022c.get(str);
            if (httpProxyCacheServerClients == null) {
                httpProxyCacheServerClients = new HttpProxyCacheServerClients(str, this.f10026g);
                this.f10022c.put(str, httpProxyCacheServerClients);
            }
        }
        return httpProxyCacheServerClients;
    }

    /* renamed from: b */
    public boolean m49602b(String str) {
        Preconditions.m49571a(str, "Url can't be null!");
        return m49597d(str).exists();
    }

    private HttpProxyCacheServer(Config config) {
        this.f10020a = new Object();
        this.f10021b = Executors.newFixedThreadPool(8);
        this.f10022c = new ConcurrentHashMap();
        this.f10026g = (Config) Preconditions.m49572a(config);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(C3019b.m49089a("MTI3LjAuMC4x")));
            this.f10023d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f10024e = localPort;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new RunnableC2869c(countDownLatch));
            this.f10025f = thread;
            thread.start();
            countDownLatch.await();
            this.f10027h = new Pinger(C3019b.m49089a("MTI3LjAuMC4x"), localPort);
            String str = HaoboLog.httpProxyCacheServerLogTag;
            HaoboLog.m49288i(str, "Proxy cache server started. Is it alive? " + m49611a());
        } catch (IOException | InterruptedException e) {
            this.f10021b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m49603b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f10023d.accept();
                String str = HaoboLog.httpProxyCacheServerLogTag;
                HaoboLog.m49292d(str, "Accept new socket " + accept);
                this.f10021b.submit(new RunnableC2868b(accept));
            } catch (IOException e) {
                m49605a(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* renamed from: a */
    public String m49607a(String str) {
        return m49606a(str, true);
    }

    /* renamed from: c */
    private int m49600c() {
        int i;
        synchronized (this.f10020a) {
            i = 0;
            for (HttpProxyCacheServerClients httpProxyCacheServerClients : this.f10022c.values()) {
                i += httpProxyCacheServerClients.m49590a();
            }
        }
        return i;
    }

    /* renamed from: d */
    private void m49596d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            HaoboLog.m49283w(HaoboLog.httpProxyCacheServerLogTag, "Failed to close socket on proxy side: {}. It seems client have already closed connection.", e);
        }
    }

    /* renamed from: a */
    public String m49606a(String str, boolean z) {
        if (!z || !m49602b(str)) {
            return m49611a() ? m49599c(str) : str;
        }
        File m49597d = m49597d(str);
        m49608a(m49597d);
        return Uri.fromFile(m49597d).toString();
    }

    /* renamed from: e */
    private void m49594e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            m49605a(new ProxyCacheException("Error closing socket", e));
        }
    }

    /* renamed from: b */
    private void m49601b(Socket socket) {
        m49598c(socket);
        m49596d(socket);
        m49594e(socket);
    }

    /* renamed from: a */
    private boolean m49611a() {
        return this.f10027h.m49578a(3, 70);
    }

    /* renamed from: c */
    private void m49598c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
        } catch (IOException e) {
            m49605a(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    /* renamed from: a */
    private void m49608a(File file) {
        try {
            this.f10026g.f10010c.mo49629a(file);
        } catch (IOException e) {
            String str = HaoboLog.httpProxyCacheServerLogTag;
            HaoboLog.m49289e(str, "Error touching file " + file, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49604a(Socket socket) {
        String str;
        StringBuilder sb;
        try {
            try {
                GetRequest m49620a = GetRequest.m49620a(socket.getInputStream());
                String str2 = HaoboLog.httpProxyCacheServerLogTag;
                HaoboLog.m49292d(str2, "Request to cache proxy:" + m49620a);
                String m49547c = ProxyCacheUtils.m49547c(m49620a.f10014a);
                if (this.f10027h.m49576a(m49547c)) {
                    this.f10027h.m49575a(socket);
                } else {
                    m49595e(m49547c).m49589a(m49620a, socket);
                }
                m49601b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            } catch (ProxyCacheException e) {
                e = e;
                m49605a(new ProxyCacheException("Error processing request", e));
                m49601b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            } catch (SocketException unused) {
                m49601b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            } catch (IOException e2) {
                e = e2;
                m49605a(new ProxyCacheException("Error processing request", e));
                m49601b(socket);
                str = HaoboLog.httpProxyCacheServerLogTag;
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(m49600c());
            HaoboLog.m49292d(str, sb.toString());
        } catch (Throwable th) {
            m49601b(socket);
            String str3 = HaoboLog.httpProxyCacheServerLogTag;
            HaoboLog.m49292d(str3, "Opened connections: " + m49600c());
            throw th;
        }
    }

    /* renamed from: a */
    private void m49605a(Throwable th) {
        HaoboLog.m49289e(HaoboLog.httpProxyCacheServerLogTag, "HttpProxyCacheServer error", th);
    }
}
