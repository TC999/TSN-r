package com.danikula.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pinger.java */
/* renamed from: com.danikula.videocache.m */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6564m {

    /* renamed from: d */
    private static final InterfaceC15424c f23127d = LoggerFactory.m2655j("Pinger");

    /* renamed from: e */
    private static final String f23128e = "ping";

    /* renamed from: f */
    private static final String f23129f = "ping ok";

    /* renamed from: a */
    private final ExecutorService f23130a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private final String f23131b;

    /* renamed from: c */
    private final int f23132c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Pinger.java */
    /* renamed from: com.danikula.videocache.m$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CallableC6566b implements Callable<Boolean> {
        private CallableC6566b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            return Boolean.valueOf(C6564m.this.m35863f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6564m(String str, int i) {
        this.f23131b = (String) C6567n.m35858d(str);
        this.f23132c = i;
    }

    /* renamed from: b */
    private List<Proxy> m35867b() {
        try {
            return ProxySelector.getDefault().select(new URI(m35866c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: c */
    private String m35866c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f23131b, Integer.valueOf(this.f23132c), f23128e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m35863f() throws ProxyCacheException {
        C6563k c6563k = new C6563k(m35866c());
        try {
            byte[] bytes = f23129f.getBytes();
            c6563k.mo35833a(0L);
            byte[] bArr = new byte[bytes.length];
            c6563k.read(bArr);
            boolean equals = Arrays.equals(bytes, bArr);
            InterfaceC15424c interfaceC15424c = f23127d;
            interfaceC15424c.info("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (ProxyCacheException e) {
            f23127d.error("Error reading ping response", (Throwable) e);
            return false;
        } finally {
            c6563k.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m35865d(String str) {
        return f23128e.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean m35864e(int i, int i2) {
        C6567n.m35860b(i >= 1);
        C6567n.m35860b(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException e) {
                e = e;
                f23127d.error("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                f23127d.error("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                InterfaceC15424c interfaceC15424c = f23127d;
                interfaceC15424c.warn("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.f23130a.submit(new CallableC6566b()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), m35867b());
        f23127d.error(format, (Throwable) new ProxyCacheException(format));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m35862g(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(f23129f.getBytes());
    }
}
