package xyz.adscope.common.network.urlconnect;

import android.text.TextUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.connect.stream.NullStream;
import xyz.adscope.common.network.connect.stream.SourceStream;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class URLConnection implements Connection {

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f65031a;

    /* renamed from: b  reason: collision with root package name */
    public String f65032b = "Location";

    public URLConnection(HttpURLConnection httpURLConnection) {
        this.f65031a = httpURLConnection;
    }

    public static InputStream a(String str, InputStream inputStream) {
        return (TextUtils.isEmpty(str) || !str.contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
    }

    public static boolean a(int i4) {
        return i4 > 100 && i4 != 204 && i4 != 205 && (i4 < 300 || i4 >= 400);
    }

    public static boolean a(String str, int i4) {
        return !"HEAD".equalsIgnoreCase(str) && a(i4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HttpURLConnection httpURLConnection = this.f65031a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public void disconnect() {
        HttpURLConnection httpURLConnection = this.f65031a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public int getCode() {
        return this.f65031a.getResponseCode();
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public Map<String, List<String>> getHeaders() {
        return this.f65031a.getHeaderFields();
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public InputStream getInputStream() {
        int responseCode = this.f65031a.getResponseCode();
        return !a(this.f65031a.getRequestMethod(), responseCode) ? new NullStream(this) : responseCode >= 400 ? a(this.f65031a.getContentEncoding(), new SourceStream(this, this.f65031a.getErrorStream())) : a(this.f65031a.getContentEncoding(), new SourceStream(this, this.f65031a.getInputStream()));
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public String getLocationUrl() {
        return this.f65031a.getHeaderField(this.f65032b);
    }

    @Override // xyz.adscope.common.network.connect.Connection
    public OutputStream getOutputStream() {
        return this.f65031a.getOutputStream();
    }
}
