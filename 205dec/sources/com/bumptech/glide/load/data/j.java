package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HttpUrlFetcher.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class j implements d<InputStream> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f16812g = "HttpUrlFetcher";

    /* renamed from: h  reason: collision with root package name */
    private static final int f16813h = 5;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final b f16814i = new a();

    /* renamed from: j  reason: collision with root package name */
    private static final int f16815j = -1;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.model.g f16816a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16817b;

    /* renamed from: c  reason: collision with root package name */
    private final b f16818c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f16819d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f16820e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f16821f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(com.bumptech.glide.load.model.g gVar, int i4) {
        this(gVar, i4, f16814i);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f16820e = com.bumptech.glide.util.b.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f16820e = httpURLConnection.getInputStream();
        }
        return this.f16820e;
    }

    private static boolean e(int i4) {
        return i4 / 100 == 2;
    }

    private static boolean f(int i4) {
        return i4 / 100 == 3;
    }

    private InputStream g(URL url, int i4, URL url2, Map<String, String> map) throws IOException {
        if (i4 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f16819d = this.f16818c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f16819d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f16819d.setConnectTimeout(this.f16817b);
            this.f16819d.setReadTimeout(this.f16817b);
            this.f16819d.setUseCaches(false);
            this.f16819d.setDoInput(true);
            this.f16819d.setInstanceFollowRedirects(false);
            this.f16819d.connect();
            this.f16820e = this.f16819d.getInputStream();
            if (this.f16821f) {
                return null;
            }
            int responseCode = this.f16819d.getResponseCode();
            if (e(responseCode)) {
                return c(this.f16819d);
            }
            if (!f(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.f16819d.getResponseMessage(), responseCode);
            }
            String headerField = this.f16819d.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                b();
                return g(url3, i4 + 1, url, map);
            }
            throw new HttpException("Received empty or null redirect url");
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f16820e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f16819d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f16819d = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f16821f = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long b4 = com.bumptech.glide.util.f.b();
        try {
            try {
                aVar.e(g(this.f16816a.i(), 0, null, this.f16816a.e()));
            } catch (IOException e4) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e4);
                }
                aVar.c(e4);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.util.f.a(b4));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.util.f.a(b4));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @VisibleForTesting
    j(com.bumptech.glide.load.model.g gVar, int i4, b bVar) {
        this.f16816a = gVar;
        this.f16817b = i4;
        this.f16818c = bVar;
    }
}
