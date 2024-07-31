package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import com.danikula.videocache.file.C6552f;
import com.danikula.videocache.file.C6553h;
import com.danikula.videocache.file.InterfaceC6544a;
import com.danikula.videocache.file.InterfaceC6546c;
import com.danikula.videocache.file.TotalCountLruDiskUsage;
import com.danikula.videocache.sourcestorage.C6577d;
import com.danikula.videocache.sourcestorage.InterfaceC6576c;
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
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* compiled from: HttpProxyCacheServer.java */
/* renamed from: com.danikula.videocache.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6556i {

    /* renamed from: i */
    private static final InterfaceC15424c f23090i = LoggerFactory.m2655j("HttpProxyCacheServer");

    /* renamed from: j */
    private static final String f23091j = "127.0.0.1";

    /* renamed from: a */
    private final Object f23092a;

    /* renamed from: b */
    private final ExecutorService f23093b;

    /* renamed from: c */
    private final Map<String, C6561j> f23094c;

    /* renamed from: d */
    private final ServerSocket f23095d;

    /* renamed from: e */
    private final int f23096e;

    /* renamed from: f */
    private final Thread f23097f;

    /* renamed from: g */
    private final C6543f f23098g;

    /* renamed from: h */
    private final C6564m f23099h;

    /* compiled from: HttpProxyCacheServer.java */
    /* renamed from: com.danikula.videocache.i$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6558b {

        /* renamed from: e */
        private static final long f23100e = 536870912;

        /* renamed from: a */
        private File f23101a;

        /* renamed from: d */
        private InterfaceC6576c f23104d;

        /* renamed from: c */
        private InterfaceC6544a f23103c = new C6553h(536870912);

        /* renamed from: b */
        private InterfaceC6546c f23102b = new C6552f();

        public C6558b(Context context) {
            this.f23104d = C6577d.m35828b(context);
            this.f23101a = C6578t.m35825c(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public C6543f m35889c() {
            return new C6543f(this.f23101a, this.f23102b, this.f23103c, this.f23104d);
        }

        /* renamed from: b */
        public C6556i m35890b() {
            return new C6556i(m35889c());
        }

        /* renamed from: d */
        public C6558b m35888d(File file) {
            this.f23101a = (File) C6567n.m35858d(file);
            return this;
        }

        /* renamed from: e */
        public C6558b m35887e(InterfaceC6544a interfaceC6544a) {
            this.f23103c = (InterfaceC6544a) C6567n.m35858d(interfaceC6544a);
            return this;
        }

        /* renamed from: f */
        public C6558b m35886f(InterfaceC6546c interfaceC6546c) {
            this.f23102b = (InterfaceC6546c) C6567n.m35858d(interfaceC6546c);
            return this;
        }

        /* renamed from: g */
        public C6558b m35885g(int i) {
            this.f23103c = new TotalCountLruDiskUsage(i);
            return this;
        }

        /* renamed from: h */
        public C6558b m35884h(long j) {
            this.f23103c = new C6553h(j);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpProxyCacheServer.java */
    /* renamed from: com.danikula.videocache.i$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public final class RunnableC6559c implements Runnable {

        /* renamed from: a */
        private final Socket f23105a;

        public RunnableC6559c(Socket socket) {
            this.f23105a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6556i.this.m35900o(this.f23105a);
        }
    }

    /* compiled from: HttpProxyCacheServer.java */
    /* renamed from: com.danikula.videocache.i$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private final class RunnableC6560d implements Runnable {

        /* renamed from: a */
        private final CountDownLatch f23107a;

        public RunnableC6560d(CountDownLatch countDownLatch) {
            this.f23107a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23107a.countDown();
            C6556i.this.m35892w();
        }
    }

    /* renamed from: c */
    private String m35912c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", f23091j, Integer.valueOf(this.f23096e), C6571p.m35836f(str));
    }

    /* renamed from: d */
    private void m35911d(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            m35901n(new ProxyCacheException("Error closing socket", e));
        }
    }

    /* renamed from: e */
    private void m35910e(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            f23090i.debug("Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            m35901n(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    /* renamed from: f */
    private void m35909f(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            f23090i.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e.getMessage());
        }
    }

    /* renamed from: g */
    private File m35908g(String str) {
        C6543f c6543f = this.f23098g;
        return new File(c6543f.f23065a, c6543f.f23066b.generate(str));
    }

    /* renamed from: h */
    private C6561j m35907h(String str) throws ProxyCacheException {
        C6561j c6561j;
        synchronized (this.f23092a) {
            c6561j = this.f23094c.get(str);
            if (c6561j == null) {
                c6561j = new C6561j(str, this.f23098g);
                this.f23094c.put(str, c6561j);
            }
        }
        return c6561j;
    }

    /* renamed from: i */
    private int m35906i() {
        int i;
        synchronized (this.f23092a) {
            i = 0;
            for (C6561j c6561j : this.f23094c.values()) {
                i += c6561j.m35882b();
            }
        }
        return i;
    }

    /* renamed from: l */
    private boolean m35903l() {
        return this.f23099h.m35864e(3, 70);
    }

    /* renamed from: n */
    private void m35901n(Throwable th) {
        f23090i.error("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m35900o(Socket socket) {
        try {
            try {
                C6554g m35922c = C6554g.m35922c(socket.getInputStream());
                InterfaceC15424c interfaceC15424c = f23090i;
                interfaceC15424c.debug("Request to cache proxy:" + m35922c);
                String m35837e = C6571p.m35837e(m35922c.f23083a);
                if (this.f23099h.m35865d(m35837e)) {
                    this.f23099h.m35862g(socket);
                } else {
                    m35907h(m35837e).m35880d(m35922c, socket);
                }
                m35898q(socket);
                interfaceC15424c.debug("Opened connections: " + m35906i());
            } catch (ProxyCacheException e) {
                e = e;
                m35901n(new ProxyCacheException("Error processing request", e));
            } catch (SocketException unused) {
                InterfaceC15424c interfaceC15424c2 = f23090i;
                interfaceC15424c2.debug("Closing socket… Socket is closed by client.");
                m35898q(socket);
                interfaceC15424c2.debug("Opened connections: " + m35906i());
            } catch (IOException e2) {
                e = e2;
                m35901n(new ProxyCacheException("Error processing request", e));
            }
        } finally {
            m35898q(socket);
            InterfaceC15424c interfaceC15424c3 = f23090i;
            interfaceC15424c3.debug("Opened connections: " + m35906i());
        }
    }

    /* renamed from: q */
    private void m35898q(Socket socket) {
        m35910e(socket);
        m35909f(socket);
        m35911d(socket);
    }

    /* renamed from: s */
    private void m35896s() {
        synchronized (this.f23092a) {
            for (C6561j c6561j : this.f23094c.values()) {
                c6561j.m35878f();
            }
            this.f23094c.clear();
        }
    }

    /* renamed from: t */
    private void m35895t(File file) {
        try {
            this.f23098g.f23067c.mo35925a(file);
        } catch (IOException e) {
            InterfaceC15424c interfaceC15424c = f23090i;
            interfaceC15424c.error("Error touching file " + file, (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m35892w() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f23095d.accept();
                InterfaceC15424c interfaceC15424c = f23090i;
                interfaceC15424c.debug("Accept new socket " + accept);
                this.f23093b.submit(new RunnableC6559c(accept));
            } catch (IOException e) {
                m35901n(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* renamed from: j */
    public String m35905j(String str) {
        return m35904k(str, true);
    }

    /* renamed from: k */
    public String m35904k(String str, boolean z) {
        if (!z || !m35902m(str)) {
            return m35903l() ? m35912c(str) : str;
        }
        File m35908g = m35908g(str);
        m35895t(m35908g);
        return Uri.fromFile(m35908g).toString();
    }

    /* renamed from: m */
    public boolean m35902m(String str) {
        C6567n.m35857e(str, "Url can't be null!");
        return m35908g(str).exists();
    }

    /* renamed from: p */
    public void m35899p(InterfaceC6542e interfaceC6542e, String str) {
        C6567n.m35861a(interfaceC6542e, str);
        synchronized (this.f23092a) {
            try {
                m35907h(str).m35879e(interfaceC6542e);
            } catch (ProxyCacheException e) {
                f23090i.warn("Error registering cache listener", (Throwable) e);
            }
        }
    }

    /* renamed from: r */
    public void m35897r() {
        f23090i.info("Shutdown proxy server");
        m35896s();
        this.f23098g.f23068d.release();
        this.f23097f.interrupt();
        try {
            if (this.f23095d.isClosed()) {
                return;
            }
            this.f23095d.close();
        } catch (IOException e) {
            m35901n(new ProxyCacheException("Error shutting down proxy server", e));
        }
    }

    /* renamed from: u */
    public void m35894u(InterfaceC6542e interfaceC6542e) {
        C6567n.m35858d(interfaceC6542e);
        synchronized (this.f23092a) {
            for (C6561j c6561j : this.f23094c.values()) {
                c6561j.m35876h(interfaceC6542e);
            }
        }
    }

    /* renamed from: v */
    public void m35893v(InterfaceC6542e interfaceC6542e, String str) {
        C6567n.m35861a(interfaceC6542e, str);
        synchronized (this.f23092a) {
            try {
                m35907h(str).m35876h(interfaceC6542e);
            } catch (ProxyCacheException e) {
                f23090i.warn("Error registering cache listener", (Throwable) e);
            }
        }
    }

    public C6556i(Context context) {
        this(new C6558b(context).m35889c());
    }

    private C6556i(C6543f c6543f) {
        this.f23092a = new Object();
        this.f23093b = Executors.newFixedThreadPool(8);
        this.f23094c = new ConcurrentHashMap();
        this.f23098g = (C6543f) C6567n.m35858d(c6543f);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(f23091j));
            this.f23095d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f23096e = localPort;
            IgnoreHostProxySelector.m35869a(f23091j, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new RunnableC6560d(countDownLatch));
            this.f23097f = thread;
            thread.start();
            countDownLatch.await();
            this.f23099h = new C6564m(f23091j, localPort);
            InterfaceC15424c interfaceC15424c = f23090i;
            interfaceC15424c.info("Proxy cache server started. Is it alive? " + m35903l());
        } catch (IOException | InterruptedException e) {
            this.f23093b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }
}
