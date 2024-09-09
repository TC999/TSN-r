package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HttpUrlSource.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class k implements q {

    /* renamed from: e  reason: collision with root package name */
    private static final org.slf4j.c f36784e = org.slf4j.d.j("HttpUrlSource");

    /* renamed from: f  reason: collision with root package name */
    private static final int f36785f = 5;

    /* renamed from: a  reason: collision with root package name */
    private final com.danikula.videocache.sourcestorage.c f36786a;

    /* renamed from: b  reason: collision with root package name */
    private s f36787b;

    /* renamed from: c  reason: collision with root package name */
    private HttpURLConnection f36788c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f36789d;

    public k(String str) {
        this(str, com.danikula.videocache.sourcestorage.d.a());
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() throws com.danikula.videocache.ProxyCacheException {
        /*
            r8 = this;
            org.slf4j.c r0 = com.danikula.videocache.k.f36784e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info from "
            r1.append(r2)
            com.danikula.videocache.s r2 = r8.f36787b
            java.lang.String r2 = r2.f36815a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.debug(r1)
            r1 = 0
            r3 = 10000(0x2710, float:1.4013E-41)
            r4 = 0
            java.net.HttpURLConnection r1 = r8.f(r1, r3)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L62
            long r2 = r8.c(r1)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r5 = r1.getContentType()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.s r6 = new com.danikula.videocache.s     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.s r7 = r8.f36787b     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r7 = r7.f36815a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r6.<init>(r7, r2, r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r8.f36787b = r6     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.sourcestorage.c r2 = r8.f36786a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r3 = r6.f36815a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2.a(r3, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2.<init>()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r3 = "Source info fetched: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.s r3 = r8.f36787b     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r0.debug(r2)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            com.danikula.videocache.p.c(r4)
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
            org.slf4j.c r2 = com.danikula.videocache.k.f36784e     // Catch: java.lang.Throwable -> L5b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = "Error fetching info from "
            r3.append(r5)     // Catch: java.lang.Throwable -> L5b
            com.danikula.videocache.s r5 = r8.f36787b     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r5.f36815a     // Catch: java.lang.Throwable -> L5b
            r3.append(r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5b
            r2.error(r3, r0)     // Catch: java.lang.Throwable -> L5b
            com.danikula.videocache.p.c(r4)
            if (r1 == 0) goto L86
        L83:
            r1.disconnect()
        L86:
            return
        L87:
            com.danikula.videocache.p.c(r4)
            if (r1 == 0) goto L8f
            r1.disconnect()
        L8f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.k.b():void");
    }

    private long c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection f(long j4, int i4) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z3;
        String str2 = this.f36787b.f36815a;
        int i5 = 0;
        do {
            org.slf4j.c cVar = f36784e;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j4 > 0) {
                str = " with offset " + j4;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            cVar.debug(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (j4 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j4 + "-");
            }
            if (i4 > 0) {
                httpURLConnection.setConnectTimeout(i4);
                httpURLConnection.setReadTimeout(i4);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z3 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z3) {
                str2 = httpURLConnection.getHeaderField("Location");
                i5++;
                httpURLConnection.disconnect();
            }
            if (i5 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i5);
            }
        } while (z3);
        return httpURLConnection;
    }

    private long g(HttpURLConnection httpURLConnection, long j4, int i4) throws IOException {
        long c4 = c(httpURLConnection);
        return i4 == 200 ? c4 : i4 == 206 ? c4 + j4 : this.f36787b.f36816b;
    }

    @Override // com.danikula.videocache.q
    public void a(long j4) throws ProxyCacheException {
        try {
            HttpURLConnection f4 = f(j4, -1);
            this.f36788c = f4;
            String contentType = f4.getContentType();
            this.f36789d = new BufferedInputStream(this.f36788c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f36788c;
            s sVar = new s(this.f36787b.f36815a, g(httpURLConnection, j4, httpURLConnection.getResponseCode()), contentType);
            this.f36787b = sVar;
            this.f36786a.a(sVar.f36815a, sVar);
        } catch (IOException e4) {
            throw new ProxyCacheException("Error opening connection for " + this.f36787b.f36815a + " with offset " + j4, e4);
        }
    }

    @Override // com.danikula.videocache.q
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f36788c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e4) {
                f36784e.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", (Throwable) e4);
            } catch (IllegalArgumentException e5) {
                e = e5;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e6) {
                e = e6;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String d() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f36787b.f36817c)) {
            b();
        }
        return this.f36787b.f36817c;
    }

    public String e() {
        return this.f36787b.f36815a;
    }

    @Override // com.danikula.videocache.q
    public synchronized long length() throws ProxyCacheException {
        if (this.f36787b.f36816b == -2147483648L) {
            b();
        }
        return this.f36787b.f36816b;
    }

    @Override // com.danikula.videocache.q
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f36789d;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e4) {
                throw new InterruptedProxyCacheException("Reading source " + this.f36787b.f36815a + " is interrupted", e4);
            } catch (IOException e5) {
                throw new ProxyCacheException("Error reading data from " + this.f36787b.f36815a, e5);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.f36787b.f36815a + ": connection is absent!");
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f36787b + "}";
    }

    public k(String str, com.danikula.videocache.sourcestorage.c cVar) {
        this.f36786a = (com.danikula.videocache.sourcestorage.c) n.d(cVar);
        s sVar = cVar.get(str);
        this.f36787b = sVar == null ? new s(str, -2147483648L, p.g(str)) : sVar;
    }

    public k(k kVar) {
        this.f36787b = kVar.f36787b;
        this.f36786a = kVar.f36786a;
    }
}
