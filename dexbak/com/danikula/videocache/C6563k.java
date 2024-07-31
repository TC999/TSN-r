package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.sourcestorage.C6577d;
import com.danikula.videocache.sourcestorage.InterfaceC6576c;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* compiled from: HttpUrlSource.java */
/* renamed from: com.danikula.videocache.k */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6563k implements InterfaceC6572q {

    /* renamed from: e */
    private static final InterfaceC15424c f23117e = LoggerFactory.m2655j("HttpUrlSource");

    /* renamed from: f */
    private static final int f23118f = 5;

    /* renamed from: a */
    private final InterfaceC6576c f23119a;

    /* renamed from: b */
    private C6573s f23120b;

    /* renamed from: c */
    private HttpURLConnection f23121c;

    /* renamed from: d */
    private InputStream f23122d;

    public C6563k(String str) {
        this(str, C6577d.m35829a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.net.HttpURLConnection] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m35875b() throws com.danikula.videocache.ProxyCacheException {
        /*
            r8 = this;
            org.slf4j.c r0 = com.danikula.videocache.C6563k.f23117e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info from "
            r1.append(r2)
            com.danikula.videocache.s r2 = r8.f23120b
            java.lang.String r2 = r2.f23148a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.debug(r1)
            r1 = 0
            r3 = 10000(0x2710, float:1.4013E-41)
            r4 = 0
            java.net.HttpURLConnection r1 = r8.m35871f(r1, r3)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L62
            long r2 = r8.m35874c(r1)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r5 = r1.getContentType()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.s r6 = new com.danikula.videocache.s     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.s r7 = r8.f23120b     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r7 = r7.f23148a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r6.<init>(r7, r2, r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r8.f23120b = r6     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.sourcestorage.c r2 = r8.f23119a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r3 = r6.f23148a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2.mo35830a(r3, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2.<init>()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r3 = "Source info fetched: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.s r3 = r8.f23120b     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r0.debug(r2)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.C6571p.m35839c(r4)
            goto L83
        L5b:
            r0 = move-exception
            goto L87
        L5d:
            r0 = move-exception
            goto L64
        L5f:
            r0 = move-exception
            r1 = r4
            goto L87
        L62:
            r0 = move-exception
            r1 = r4
        L64:
            org.slf4j.c r2 = com.danikula.videocache.C6563k.f23117e     // Catch: java.lang.Throwable -> L5b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = "Error fetching info from "
            r3.append(r5)     // Catch: java.lang.Throwable -> L5b
            com.danikula.videocache.s r5 = r8.f23120b     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r5.f23148a     // Catch: java.lang.Throwable -> L5b
            r3.append(r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5b
            r2.error(r3, r0)     // Catch: java.lang.Throwable -> L5b
            com.danikula.videocache.C6571p.m35839c(r4)
            if (r1 == 0) goto L86
        L83:
            r1.disconnect()
        L86:
            return
        L87:
            com.danikula.videocache.C6571p.m35839c(r4)
            if (r1 == 0) goto L8f
            r1.disconnect()
        L8f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.C6563k.m35875b():void");
    }

    /* renamed from: c */
    private long m35874c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    /* renamed from: f */
    private HttpURLConnection m35871f(long j, int i) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f23120b.f23148a;
        int i2 = 0;
        do {
            InterfaceC15424c interfaceC15424c = f23117e;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            interfaceC15424c.debug(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpHeaders.Names.LOCATION);
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    /* renamed from: g */
    private long m35870g(HttpURLConnection httpURLConnection, long j, int i) throws IOException {
        long m35874c = m35874c(httpURLConnection);
        return i == 200 ? m35874c : i == 206 ? m35874c + j : this.f23120b.f23149b;
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    /* renamed from: a */
    public void mo35833a(long j) throws ProxyCacheException {
        try {
            HttpURLConnection m35871f = m35871f(j, -1);
            this.f23121c = m35871f;
            String contentType = m35871f.getContentType();
            this.f23122d = new BufferedInputStream(this.f23121c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f23121c;
            C6573s c6573s = new C6573s(this.f23120b.f23148a, m35870g(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.f23120b = c6573s;
            this.f23119a.mo35830a(c6573s.f23148a, c6573s);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.f23120b.f23148a + " with offset " + j, e);
        }
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f23121c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                f23117e.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", (Throwable) e);
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    /* renamed from: d */
    public synchronized String m35873d() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f23120b.f23150c)) {
            m35875b();
        }
        return this.f23120b.f23150c;
    }

    /* renamed from: e */
    public String m35872e() {
        return this.f23120b.f23148a;
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    public synchronized long length() throws ProxyCacheException {
        if (this.f23120b.f23149b == -2147483648L) {
            m35875b();
        }
        return this.f23120b.f23149b;
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f23122d;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.f23120b.f23148a + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.f23120b.f23148a, e2);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.f23120b.f23148a + ": connection is absent!");
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f23120b + "}";
    }

    public C6563k(String str, InterfaceC6576c interfaceC6576c) {
        this.f23119a = (InterfaceC6576c) C6567n.m35858d(interfaceC6576c);
        C6573s c6573s = interfaceC6576c.get(str);
        this.f23120b = c6573s == null ? new C6573s(str, -2147483648L, C6571p.m35835g(str)) : c6573s;
    }

    public C6563k(C6563k c6563k) {
        this.f23120b = c6563k.f23120b;
        this.f23119a = c6563k.f23119a;
    }
}
