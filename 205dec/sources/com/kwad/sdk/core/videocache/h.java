package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.ap;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c aBJ;
    private final com.kwad.sdk.core.videocache.b.b aBK;
    private n aCh;
    private HttpURLConnection aCi;
    private InputStream aCj;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aBJ = (com.kwad.sdk.core.videocache.d.c) ap.checkNotNull(cVar);
        this.aBK = (com.kwad.sdk.core.videocache.b.b) ap.checkNotNull(bVar);
        n eJ = cVar.eJ(str);
        this.aCh = eJ == null ? new n(str, -2147483648L, l.eH(str)) : eJ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void Gx() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.e.c.d("HttpUrlSource", "Read content info from " + this.aCh.url);
        ?? r02 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = c(0L, 10000);
            } catch (IOException unused) {
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                r02 = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r02);
                throw th;
            }
            try {
                long d4 = d(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                n nVar = new n(this.aCh.url, d4, contentType);
                this.aCh = nVar;
                this.aBJ.a(nVar.url, nVar);
                com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + this.aCh);
                r02 = httpURLConnection;
            } catch (IOException unused2) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aCh.url);
                r02 = httpURLConnection;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r02);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r02);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r02);
            throw th;
        }
    }

    private void Gz() {
        n eJ;
        com.kwad.sdk.core.videocache.d.c cVar = this.aBJ;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (eJ = cVar.eJ(getUrl())) == null || TextUtils.isEmpty(eJ.aCy) || eJ.aCx == -2147483648L) {
            return;
        }
        this.aCh = eJ;
    }

    private long a(HttpURLConnection httpURLConnection, long j4, int i4) {
        long d4 = d(httpURLConnection);
        return i4 == 200 ? d4 : i4 == 206 ? d4 + j4 : this.aCh.aCx;
    }

    private HttpURLConnection c(long j4, int i4) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z3;
        String str2 = this.aCh.url;
        int i5 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j4 > 0) {
                str = " with offset " + j4;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.e.c.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (j4 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j4 + "-");
            }
            if (i4 > 0) {
                httpURLConnection.setConnectTimeout(i4);
                httpURLConnection.setReadTimeout(i4);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
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

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Gy() {
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            Gz();
        }
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            Gx();
        }
        return this.aCh.aCy;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void at(long j4) {
        try {
            HttpURLConnection c4 = c(j4, -1);
            this.aCi = c4;
            String contentType = c4.getContentType();
            this.aCj = new BufferedInputStream(this.aCi.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aCi;
            n nVar = new n(this.aCh.url, a(httpURLConnection, j4, httpURLConnection.getResponseCode()), contentType);
            this.aCh = nVar;
            this.aBJ.a(nVar.url, nVar);
        } catch (IOException e4) {
            throw new ProxyCacheException("Error opening connection for " + this.aCh.url + " with offset " + j4, e4);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aCi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e4) {
                e = e4;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e5) {
                e = e5;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aCh.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.aCh.aCx == -2147483648L) {
            Gz();
        }
        if (this.aCh.aCx == -2147483648L) {
            Gx();
        }
        return this.aCh.aCx;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aCj;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, 1024);
            } catch (InterruptedIOException e4) {
                throw new InterruptedProxyCacheException("Reading source " + this.aCh.url + " is interrupted", e4);
            } catch (IOException e5) {
                throw new ProxyCacheException("Error reading data from " + this.aCh.url, e5);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.aCh.url + ": connection is absent!");
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aCh + "}";
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aBK.GG().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public h(h hVar) {
        this.aCh = hVar.aCh;
        this.aBJ = hVar.aBJ;
        this.aBK = hVar.aBK;
    }
}
