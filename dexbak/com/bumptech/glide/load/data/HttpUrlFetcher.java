package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.data.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: g */
    private static final String f13489g = "HttpUrlFetcher";

    /* renamed from: h */
    private static final int f13490h = 5;
    @VisibleForTesting

    /* renamed from: i */
    static final InterfaceC3567b f13491i = new C3566a();

    /* renamed from: j */
    private static final int f13492j = -1;

    /* renamed from: a */
    private final GlideUrl f13493a;

    /* renamed from: b */
    private final int f13494b;

    /* renamed from: c */
    private final InterfaceC3567b f13495c;

    /* renamed from: d */
    private HttpURLConnection f13496d;

    /* renamed from: e */
    private InputStream f13497e;

    /* renamed from: f */
    private volatile boolean f13498f;

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: com.bumptech.glide.load.data.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3566a implements InterfaceC3567b {
        C3566a() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.InterfaceC3567b
        /* renamed from: a */
        public HttpURLConnection mo45466a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: com.bumptech.glide.load.data.j$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3567b {
        /* renamed from: a */
        HttpURLConnection mo45466a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, f13491i);
    }

    /* renamed from: c */
    private InputStream m45470c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f13497e = ContentLengthInputStream.m44423b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f13489g, 3)) {
                Log.d(f13489g, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f13497e = httpURLConnection.getInputStream();
        }
        return this.f13497e;
    }

    /* renamed from: e */
    private static boolean m45469e(int i) {
        return i / 100 == 2;
    }

    /* renamed from: f */
    private static boolean m45468f(int i) {
        return i / 100 == 3;
    }

    /* renamed from: g */
    private InputStream m45467g(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f13496d = this.f13495c.mo45466a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f13496d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f13496d.setConnectTimeout(this.f13494b);
            this.f13496d.setReadTimeout(this.f13494b);
            this.f13496d.setUseCaches(false);
            this.f13496d.setDoInput(true);
            this.f13496d.setInstanceFollowRedirects(false);
            this.f13496d.connect();
            this.f13497e = this.f13496d.getInputStream();
            if (this.f13498f) {
                return null;
            }
            int responseCode = this.f13496d.getResponseCode();
            if (m45469e(responseCode)) {
                return m45470c(this.f13496d);
            }
            if (!m45468f(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.f13496d.getResponseMessage(), responseCode);
            }
            String headerField = this.f13496d.getHeaderField(HttpHeaders.Names.LOCATION);
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                mo45009b();
                return m45467g(url3, i + 1, url, map);
            }
            throw new HttpException("Received empty or null redirect url");
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo45010a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: b */
    public void mo45009b() {
        InputStream inputStream = this.f13497e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f13496d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f13496d = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.f13498f = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    /* renamed from: d */
    public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super InputStream> interfaceC3562a) {
        StringBuilder sb;
        long m44411b = LogTime.m44411b();
        try {
            try {
                interfaceC3562a.mo45051e(m45467g(this.f13493a.m45088i(), 0, null, this.f13493a.m45092e()));
            } catch (IOException e) {
                if (Log.isLoggable(f13489g, 3)) {
                    Log.d(f13489g, "Failed to load data for url", e);
                }
                interfaceC3562a.mo45052c(e);
                if (!Log.isLoggable(f13489g, 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable(f13489g, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.m44412a(m44411b));
                Log.v(f13489g, sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable(f13489g, 2)) {
                Log.v(f13489g, "Finished http url fetcher fetch in " + LogTime.m44412a(m44411b));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl, int i, InterfaceC3567b interfaceC3567b) {
        this.f13493a = glideUrl;
        this.f13494b = i;
        this.f13495c = interfaceC3567b;
    }
}
