package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.clj.fastble.BleManager;
import com.kwad.sdk.core.network.C10440p;
import com.kwad.sdk.core.network.C10442r;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.videocache.p414b.InterfaceC10560b;
import com.kwad.sdk.core.videocache.p416d.C10565b;
import com.kwad.sdk.core.videocache.p416d.InterfaceC10566c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.utils.C11023ap;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: com.kwad.sdk.core.videocache.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10575h extends AbstractC10584p {
    private final InterfaceC10566c aBJ;
    private final InterfaceC10560b aBK;
    private C10582n aCh;
    private HttpURLConnection aCi;
    private InputStream aCj;

    public C10575h(String str, InterfaceC10566c interfaceC10566c, InterfaceC10560b interfaceC10560b) {
        this.aBJ = (InterfaceC10566c) C11023ap.checkNotNull(interfaceC10566c);
        this.aBK = (InterfaceC10560b) C11023ap.checkNotNull(interfaceC10560b);
        C10582n mo25460eJ = interfaceC10566c.mo25460eJ(str);
        this.aCh = mo25460eJ == null ? new C10582n(str, -2147483648L, C10580l.m25396eH(str)) : mo25460eJ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    /* renamed from: Gx */
    private void m25420Gx() {
        HttpURLConnection httpURLConnection;
        C10331c.m26254d("HttpUrlSource", "Read content info from " + this.aCh.url);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = m25416c(0L, BleManager.f22896l);
            } catch (IOException unused) {
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                r0 = 0;
                C10738b.closeQuietly(inputStream);
                C10738b.m25007a(r0);
                throw th;
            }
            try {
                long m25415d = m25415d(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                C10582n c10582n = new C10582n(this.aCh.url, m25415d, contentType);
                this.aCh = c10582n;
                this.aBJ.mo25461a(c10582n.url, c10582n);
                C10331c.m26254d("HttpUrlSource", "Source info fetched: " + this.aCh);
                r0 = httpURLConnection;
            } catch (IOException unused2) {
                C10331c.m26250e("HttpUrlSource", "Error fetching info from " + this.aCh.url);
                r0 = httpURLConnection;
                C10738b.closeQuietly(inputStream);
                C10738b.m25007a(r0);
            }
            C10738b.closeQuietly(inputStream);
            C10738b.m25007a(r0);
        } catch (Throwable th2) {
            th = th2;
            C10738b.closeQuietly(inputStream);
            C10738b.m25007a(r0);
            throw th;
        }
    }

    /* renamed from: Gz */
    private void m25419Gz() {
        C10582n mo25460eJ;
        InterfaceC10566c interfaceC10566c = this.aBJ;
        if (interfaceC10566c == null || !(interfaceC10566c instanceof C10565b) || (mo25460eJ = interfaceC10566c.mo25460eJ(getUrl())) == null || TextUtils.isEmpty(mo25460eJ.aCy) || mo25460eJ.aCx == -2147483648L) {
            return;
        }
        this.aCh = mo25460eJ;
    }

    /* renamed from: a */
    private long m25418a(HttpURLConnection httpURLConnection, long j, int i) {
        long m25415d = m25415d(httpURLConnection);
        return i == 200 ? m25415d : i == 206 ? m25415d + j : this.aCh.aCx;
    }

    /* renamed from: c */
    private HttpURLConnection m25416c(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.aCh.url;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            C10331c.m26254d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            C10442r.wrapHttpURLConnection(httpURLConnection);
            m25417a(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            C10440p.m26066b(httpURLConnection);
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

    /* renamed from: d */
    private static long m25415d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.AbstractC10584p
    /* renamed from: Gy */
    public final synchronized String mo25393Gy() {
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            m25419Gz();
        }
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            m25420Gx();
        }
        return this.aCh.aCy;
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    /* renamed from: at */
    public final void mo25395at(long j) {
        try {
            HttpURLConnection m25416c = m25416c(j, -1);
            this.aCi = m25416c;
            String contentType = m25416c.getContentType();
            this.aCj = new BufferedInputStream(this.aCi.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aCi;
            C10582n c10582n = new C10582n(this.aCh.url, m25418a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.aCh = c10582n;
            this.aBJ.mo25461a(c10582n.url, c10582n);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.aCh.url + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aCi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                C10331c.m26250e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.AbstractC10584p
    public final String getUrl() {
        return this.aCh.url;
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    public final synchronized long length() {
        if (this.aCh.aCx == -2147483648L) {
            m25419Gz();
        }
        if (this.aCh.aCx == -2147483648L) {
            m25420Gx();
        }
        return this.aCh.aCx;
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aCj;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, 1024);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.aCh.url + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.aCh.url, e2);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.aCh.url + ": connection is absent!");
    }

    @Override // com.kwad.sdk.core.videocache.AbstractC10584p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aCh + "}";
    }

    /* renamed from: a */
    private void m25417a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aBK.mo25471GG().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public C10575h(C10575h c10575h) {
        this.aCh = c10575h.aCh;
        this.aBJ = c10575h.aBJ;
        this.aBK = c10575h.aBK;
    }
}
