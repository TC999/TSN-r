package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.utils.ap;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aBJ;
    private final com.kwad.sdk.core.videocache.b.b aBK;
    private n aCh;
    private InputStream aCj;
    private OkHttpClient aCo = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aBJ = (com.kwad.sdk.core.videocache.d.c) ap.checkNotNull(cVar);
        this.aBK = (com.kwad.sdk.core.videocache.b.b) ap.checkNotNull(bVar);
        n eJ = cVar.eJ(str);
        this.aCh = eJ == null ? new n(str, -2147483648L, l.eH(str)) : eJ;
    }

    private void Gx() {
        Response response = null;
        try {
            try {
                response = du(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aCh.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response != null && response.isSuccessful()) {
                n nVar = new n(this.aCh.url, c(response), response.header("Content-Type"));
                this.aCh = nVar;
                this.aBJ.a(nVar.url, nVar);
                com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + this.aCh);
                if (response.body() == null) {
                    return;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
                return;
            }
            throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
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

    private long a(Response response, long j4) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j4 : this.aCh.aCx;
    }

    private static long c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    private Response d(long j4, int i4) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aCo.newBuilder();
        int i5 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aCo = newBuilder.build();
        String url = getUrl();
        boolean z3 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j4 > 0) {
                builder.addHeader("Range", "bytes=" + j4 + "-");
            }
            execute = this.aCo.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z3 = execute.isRedirect();
                i5++;
            }
            if (i5 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i5);
            }
        } while (z3);
        return execute;
    }

    private Response du(int i4) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit);
        newBuilder.readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit);
        newBuilder.writeTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit);
        int i5 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aCo = newBuilder.build();
        String url = getUrl();
        boolean z3 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aCo.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z3 = execute.isRedirect();
                i5++;
            }
            if (i5 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i5);
            }
        } while (z3);
        return execute;
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
            Response d4 = d(j4, -1);
            String mediaType = d4.body().contentType().toString();
            long a4 = a(d4, j4);
            this.aCj = new BufferedInputStream(d4.body().byteStream(), 1024);
            n nVar = new n(this.aCh.url, a4, mediaType);
            this.aCh = nVar;
            this.aBJ.a(nVar.url, nVar);
        } catch (IOException e4) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j4, e4);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aCj);
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

    public j(j jVar) {
        this.aCh = jVar.aCh;
        this.aBJ = jVar.aBJ;
        this.aBK = jVar.aBK;
    }
}
