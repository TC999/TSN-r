package com.beizi.p051ad.internal.p058b;

import android.text.TextUtils;
import com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorage;
import com.beizi.p051ad.internal.p058b.p060b.SourceInfoStorageFactory;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.beizi.ad.internal.b.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HttpUrlSource implements InterfaceC2875o {

    /* renamed from: a */
    private final SourceInfoStorage f10044a;

    /* renamed from: b */
    private SourceInfo f10045b;

    /* renamed from: c */
    private HttpURLConnection f10046c;

    /* renamed from: d */
    private InputStream f10047d;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.m49623a());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m49580e() throws com.beizi.p051ad.internal.p058b.ProxyCacheException {
        /*
            r6 = this;
            java.lang.String r0 = com.beizi.p051ad.internal.utilities.HaoboLog.httpUrlSourceLogTag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info failFrom "
            r1.append(r2)
            com.beizi.ad.internal.b.p r2 = r6.f10045b
            java.lang.String r2 = r2.f10061a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.beizi.p051ad.internal.utilities.HaoboLog.m49292d(r0, r1)
            r0 = 0
            r1 = 10000(0x2710, float:1.4013E-41)
            r2 = 0
            java.net.HttpURLConnection r0 = r6.m49584a(r0, r1)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            int r1 = r0.getContentLength()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r0.getContentType()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.io.InputStream r2 = r0.getInputStream()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.p r4 = new com.beizi.ad.internal.b.p     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.p r5 = r6.f10045b     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r5 = r5.f10061a     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r4.<init>(r5, r1, r3)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r6.f10045b = r4     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.b.c r1 = r6.f10044a     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r4.f10061a     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r1.mo49624a(r3, r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r1 = com.beizi.p051ad.internal.utilities.HaoboLog.httpUrlSourceLogTag     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r3.<init>()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r4 = "Source info fetched: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.p r4 = r6.f10045b     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r3.append(r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.p051ad.internal.utilities.HaoboLog.m49292d(r1, r3)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.p051ad.internal.p058b.ProxyCacheUtils.m49552a(r2)
            goto L84
        L5c:
            r1 = move-exception
            goto L88
        L5e:
            r1 = move-exception
            goto L65
        L60:
            r1 = move-exception
            r0 = r2
            goto L88
        L63:
            r1 = move-exception
            r0 = r2
        L65:
            java.lang.String r3 = com.beizi.p051ad.internal.utilities.HaoboLog.httpUrlSourceLogTag     // Catch: java.lang.Throwable -> L5c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = "Error fetching info failFrom "
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            com.beizi.ad.internal.b.p r5 = r6.f10045b     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r5.f10061a     // Catch: java.lang.Throwable -> L5c
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            com.beizi.p051ad.internal.utilities.HaoboLog.m49289e(r3, r4, r1)     // Catch: java.lang.Throwable -> L5c
            com.beizi.p051ad.internal.p058b.ProxyCacheUtils.m49552a(r2)
            if (r0 == 0) goto L87
        L84:
            r0.disconnect()
        L87:
            return
        L88:
            com.beizi.p051ad.internal.p058b.ProxyCacheUtils.m49552a(r2)
            if (r0 == 0) goto L90
            r0.disconnect()
        L90:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.p058b.HttpUrlSource.m49580e():void");
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2875o
    /* renamed from: a */
    public synchronized int mo49545a() throws ProxyCacheException {
        if (this.f10045b.f10062b == Integer.MIN_VALUE) {
            m49580e();
        }
        return this.f10045b.f10062b;
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2875o
    /* renamed from: b */
    public void mo49542b() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f10046c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            }
        }
    }

    /* renamed from: c */
    public synchronized String m49582c() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f10045b.f10063c)) {
            m49580e();
        }
        return this.f10045b.f10063c;
    }

    /* renamed from: d */
    public String m49581d() {
        return this.f10045b.f10061a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f10045b + "}";
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this.f10044a = (SourceInfoStorage) Preconditions.m49572a(sourceInfoStorage);
        SourceInfo mo49625a = sourceInfoStorage.mo49625a(str);
        this.f10045b = mo49625a == null ? new SourceInfo(str, Integer.MIN_VALUE, ProxyCacheUtils.m49551a(str)) : mo49625a;
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2875o
    /* renamed from: a */
    public void mo49544a(int i) throws ProxyCacheException {
        try {
            HttpURLConnection m49584a = m49584a(i, -1);
            this.f10046c = m49584a;
            String contentType = m49584a.getContentType();
            this.f10047d = new BufferedInputStream(this.f10046c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f10046c;
            SourceInfo sourceInfo = new SourceInfo(this.f10045b.f10061a, m49583a(httpURLConnection, i, httpURLConnection.getResponseCode()), contentType);
            this.f10045b = sourceInfo;
            this.f10044a.mo49624a(sourceInfo.f10061a, sourceInfo);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.f10045b.f10061a + " with offset " + i, e);
        }
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.f10045b = httpUrlSource.f10045b;
        this.f10044a = httpUrlSource.f10044a;
    }

    /* renamed from: a */
    private int m49583a(HttpURLConnection httpURLConnection, int i, int i2) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == 200 ? contentLength : i2 == 206 ? contentLength + i : this.f10045b.f10062b;
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2875o
    /* renamed from: a */
    public int mo49543a(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f10047d;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.f10045b.f10061a + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data failFrom " + this.f10045b.f10061a, e2);
            }
        }
        throw new ProxyCacheException("Error reading data failFrom " + this.f10045b.f10061a + ": connection is absent!");
    }

    /* renamed from: a */
    private HttpURLConnection m49584a(int i, int i2) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f10045b.f10061a;
        int i3 = 0;
        do {
            String str3 = HaoboLog.httpUrlSourceLogTag;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (i > 0) {
                str = " with offset " + i;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            HaoboLog.m49292d(str3, sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpHeaders.Names.LOCATION);
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z);
        return httpURLConnection;
    }
}
