package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.clj.fastble.BleManager;
import com.kwad.sdk.core.network.p404a.C10409d;
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
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.kwad.sdk.core.videocache.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10577j extends AbstractC10584p {
    private final InterfaceC10566c aBJ;
    private final InterfaceC10560b aBK;
    private C10582n aCh;
    private InputStream aCj;
    private OkHttpClient aCo = new OkHttpClient();

    public C10577j(String str, InterfaceC10566c interfaceC10566c, InterfaceC10560b interfaceC10560b) {
        this.aBJ = (InterfaceC10566c) C11023ap.checkNotNull(interfaceC10566c);
        this.aBK = (InterfaceC10560b) C11023ap.checkNotNull(interfaceC10560b);
        C10582n mo25460eJ = interfaceC10566c.mo25460eJ(str);
        this.aCh = mo25460eJ == null ? new C10582n(str, -2147483648L, C10580l.m25396eH(str)) : mo25460eJ;
    }

    /* renamed from: Gx */
    private void m25414Gx() {
        Response response = null;
        try {
            try {
                response = m25409du(BleManager.f22896l);
            } catch (IOException unused) {
                C10331c.m26250e("HttpUrlSource", "Error fetching info from " + this.aCh.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response != null && response.isSuccessful()) {
                C10582n c10582n = new C10582n(this.aCh.url, m25411c(response), response.header("Content-Type"));
                this.aCh = c10582n;
                this.aBJ.mo25461a(c10582n.url, c10582n);
                C10331c.m26254d("HttpUrlSource", "Source info fetched: " + this.aCh);
                if (response.body() == null) {
                    return;
                }
                C10738b.closeQuietly(response.body());
                return;
            }
            throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                C10738b.closeQuietly(response.body());
            }
            throw th;
        }
    }

    /* renamed from: Gz */
    private void m25413Gz() {
        C10582n mo25460eJ;
        InterfaceC10566c interfaceC10566c = this.aBJ;
        if (interfaceC10566c == null || !(interfaceC10566c instanceof C10565b) || (mo25460eJ = interfaceC10566c.mo25460eJ(getUrl())) == null || TextUtils.isEmpty(mo25460eJ.aCy) || mo25460eJ.aCx == -2147483648L) {
            return;
        }
        this.aCh = mo25460eJ;
    }

    /* renamed from: a */
    private long m25412a(Response response, long j) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j : this.aCh.aCx;
    }

    /* renamed from: c */
    private static long m25411c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    /* renamed from: d */
    private Response m25410d(long j, int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aCo.newBuilder();
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new C10409d());
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
        this.aCo = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader("Range", "bytes=" + j + "-");
            }
            execute = this.aCo.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header(HttpHeaders.Names.LOCATION);
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return execute;
    }

    /* renamed from: du */
    private Response m25409du(int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(10000L, timeUnit);
        newBuilder.readTimeout(10000L, timeUnit);
        newBuilder.writeTimeout(10000L, timeUnit);
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new C10409d());
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
        this.aCo = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aCo.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header(HttpHeaders.Names.LOCATION);
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return execute;
    }

    @Override // com.kwad.sdk.core.videocache.AbstractC10584p
    /* renamed from: Gy */
    public final synchronized String mo25393Gy() {
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            m25413Gz();
        }
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            m25414Gx();
        }
        return this.aCh.aCy;
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    /* renamed from: at */
    public final void mo25395at(long j) {
        try {
            Response m25410d = m25410d(j, -1);
            String mediaType = m25410d.body().contentType().toString();
            long m25412a = m25412a(m25410d, j);
            this.aCj = new BufferedInputStream(m25410d.body().byteStream(), 1024);
            C10582n c10582n = new C10582n(this.aCh.url, m25412a, mediaType);
            this.aCh = c10582n;
            this.aBJ.mo25461a(c10582n.url, c10582n);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    public final void close() {
        C10738b.closeQuietly(this.aCj);
    }

    @Override // com.kwad.sdk.core.videocache.AbstractC10584p
    public final String getUrl() {
        return this.aCh.url;
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10581m
    public final synchronized long length() {
        if (this.aCh.aCx == -2147483648L) {
            m25413Gz();
        }
        if (this.aCh.aCx == -2147483648L) {
            m25414Gx();
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

    public C10577j(C10577j c10577j) {
        this.aCh = c10577j.aCh;
        this.aBJ = c10577j.aBJ;
        this.aBK = c10577j.aBK;
    }
}
