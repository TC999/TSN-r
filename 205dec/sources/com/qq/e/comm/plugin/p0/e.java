package com.qq.e.comm.plugin.p0;

import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private ServerSocket f45326a;

    /* renamed from: b  reason: collision with root package name */
    private int f45327b;

    /* renamed from: c  reason: collision with root package name */
    private Thread f45328c;

    /* renamed from: d  reason: collision with root package name */
    private Object f45329d;

    /* renamed from: e  reason: collision with root package name */
    private LinkedHashMap<String, com.qq.e.comm.plugin.p0.d> f45330e;

    /* renamed from: f  reason: collision with root package name */
    private h f45331f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45332g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicInteger f45333h;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends LinkedHashMap<String, com.qq.e.comm.plugin.p0.d> {
        a(e eVar) {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, com.qq.e.comm.plugin.p0.d> entry) {
            return size() > 30;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private final class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final String f45335c;

        /* renamed from: d  reason: collision with root package name */
        private final int f45336d;

        /* renamed from: e  reason: collision with root package name */
        private final String f45337e;

        public c(String str, int i4, String str2) {
            this.f45335c = str;
            this.f45336d = i4;
            this.f45337e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.f45335c, this.f45336d, this.f45337e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private static e f45339a = new e(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.p0.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public final class RunnableC0872e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final Socket f45340c;

        public RunnableC0872e(Socket socket) {
            this.f45340c = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d(this.f45340c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public final class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final CountDownLatch f45342c;

        public f(CountDownLatch countDownLatch) {
            this.f45342c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45342c.countDown();
            e.this.d();
        }
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f45326a.accept();
                d1.a("VideoCache", "Accept new socket: " + accept);
                d0.f46406b.submit(new RunnableC0872e(accept));
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    private void e(Socket socket) {
        b(socket);
        c(socket);
        a(socket);
    }

    public void b() {
        d1.a("VideoCache_init socket ", new Object[0]);
        int incrementAndGet = this.f45333h.incrementAndGet();
        if (incrementAndGet > 10) {
            if (incrementAndGet == 11) {
                v.a(1130121, (com.qq.e.comm.plugin.n0.c) null);
            }
            d1.a("VideoCache_init socket more than 10");
            return;
        }
        try {
            boolean z3 = GlobalSetting.isEnableVideoDownloadingCache() && com.qq.e.comm.plugin.d0.a.d().f().a("viCaE", 1) == 1;
            this.f45332g = z3;
            if (!z3) {
                this.f45326a = null;
                this.f45327b = 0;
                this.f45328c = null;
                this.f45331f = null;
                return;
            }
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f45326a = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f45327b = localPort;
            g.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new f(countDownLatch), "GDT_VIDEO_CACHE");
            this.f45328c = thread;
            thread.start();
            countDownLatch.await();
            this.f45331f = new h("127.0.0.1", this.f45327b);
        } catch (Throwable th) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", th.getMessage());
            v.a(1130123, null, Integer.valueOf(incrementAndGet), dVar);
        }
    }

    public String c(String str, int i4) {
        d1.a("VideoCache", "wrap video url:" + str);
        if (!TextUtils.isEmpty(str) && this.f45332g) {
            if (c()) {
                return a(str, i4);
            }
            v.b(1130120, null, Integer.valueOf(this.f45331f == null ? 1 : 2));
            d0.f46406b.submit(new b());
            return null;
        }
        return null;
    }

    private e() {
        this.f45329d = new Object();
        this.f45330e = new a(this);
        this.f45333h = new AtomicInteger(0);
    }

    public static e a() {
        return d.f45339a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i4, String str2) {
        try {
            b(str, i4).a(str2);
        } catch (k e4) {
            e4.printStackTrace();
        }
    }

    public String a(String str) {
        return c(str, 0);
    }

    private String a(String str, int i4) {
        Locale locale = Locale.US;
        return String.format(locale, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f45327b), l.b(str) + "%26sdk_ad_type%3D" + i4 + "%26video_view_hashcode%3D12345567");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #1 {all -> 0x0040, blocks: (B:3:0x0003, B:5:0x0030, B:6:0x0036, B:13:0x0045, B:15:0x004e, B:18:0x0066), top: B:23:0x0003, inners: #4, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.net.Socket r7) {
        /*
            r6 = this;
            java.lang.String r0 = "e"
            r1 = 0
            java.io.InputStream r2 = r7.getInputStream()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            com.qq.e.comm.plugin.p0.b r2 = com.qq.e.comm.plugin.p0.b.a(r2)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            java.lang.String r3 = r2.f45314a     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            java.lang.String r3 = com.qq.e.comm.plugin.p0.l.a(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            java.lang.String r5 = "VideoCache_Server process socket url: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            r4.append(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            com.qq.e.comm.plugin.util.d1.a(r4, r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            com.qq.e.comm.plugin.p0.h r4 = r6.f45331f     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            boolean r4 = r4.a(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            if (r4 == 0) goto L36
            com.qq.e.comm.plugin.p0.h r2 = r6.f45331f     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            r2.a(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            goto L61
        L36:
            int r4 = r2.f45317d     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            com.qq.e.comm.plugin.p0.d r3 = r6.b(r3, r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            r3.a(r2, r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 com.qq.e.comm.plugin.p0.k -> L44 java.net.SocketException -> L65
            goto L61
        L40:
            r0 = move-exception
            goto L82
        L42:
            r2 = move-exception
            goto L45
        L44:
            r2 = move-exception
        L45:
            java.lang.String r3 = "VideoCache_Error processing request"
            com.qq.e.comm.plugin.util.d1.a(r3, r2)     // Catch: java.lang.Throwable -> L40
            boolean r3 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto L61
            r3 = 1130118(0x113e86, float:1.583633E-39)
            com.qq.e.comm.plugin.n0.d r4 = new com.qq.e.comm.plugin.n0.d     // Catch: java.lang.Throwable -> L40
            r4.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L40
            com.qq.e.comm.plugin.n0.d r0 = r4.a(r0, r2)     // Catch: java.lang.Throwable -> L40
            com.qq.e.comm.plugin.n0.v.a(r3, r1, r1, r1, r0)     // Catch: java.lang.Throwable -> L40
        L61:
            r6.e(r7)
            goto L81
        L65:
            r2 = move-exception
            java.lang.String r3 = "VideoCache_Closing socket\u2026 Socket is closed by client."
            com.qq.e.comm.plugin.util.d1.a(r3, r2)     // Catch: java.lang.Throwable -> L40
            r3 = 1130122(0x113e8a, float:1.583638E-39)
            com.qq.e.comm.plugin.n0.d r4 = new com.qq.e.comm.plugin.n0.d     // Catch: java.lang.Throwable -> L40
            r4.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L40
            com.qq.e.comm.plugin.n0.d r0 = r4.a(r0, r2)     // Catch: java.lang.Throwable -> L40
            com.qq.e.comm.plugin.n0.v.a(r3, r1, r1, r1, r0)     // Catch: java.lang.Throwable -> L40
            r6.e(r7)
        L81:
            return
        L82:
            r6.e(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.p0.e.d(java.net.Socket):void");
    }

    private void c(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e4) {
            d1.a("VideoCache_Failed to close socket on proxy side: {}. It seems client have already closed connection.", e4);
        }
    }

    private void a(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e4) {
            d1.a("VideoCache_Failed to close socket", e4);
        }
    }

    private boolean c() {
        h hVar = this.f45331f;
        if (hVar != null) {
            return hVar.a(3, 70);
        }
        return false;
    }

    public void b(String str, int i4, String str2) {
        d0.f46406b.submit(new c(str, i4, str2));
    }

    private com.qq.e.comm.plugin.p0.d b(String str, int i4) throws k {
        com.qq.e.comm.plugin.p0.d dVar;
        synchronized (this.f45329d) {
            String str2 = i4 + str;
            dVar = this.f45330e.get(str2);
            if (dVar == null) {
                dVar = new com.qq.e.comm.plugin.p0.d(str, i4);
                this.f45330e.put(str2, dVar);
            }
        }
        return dVar;
    }

    private void b(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException e4) {
            d1.a("VideoCache_Releasing input stream\u2026 Socket is closed by client.", e4);
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
