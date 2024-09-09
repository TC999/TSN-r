package com.beizi.ad.internal.b;

import android.text.TextUtils;
import com.beizi.ad.internal.utilities.HaoboLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpUrlSource.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h implements o {

    /* renamed from: a  reason: collision with root package name */
    private final com.beizi.ad.internal.b.b.c f13721a;

    /* renamed from: b  reason: collision with root package name */
    private p f13722b;

    /* renamed from: c  reason: collision with root package name */
    private HttpURLConnection f13723c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f13724d;

    public h(String str) {
        this(str, com.beizi.ad.internal.b.b.d.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() throws com.beizi.ad.internal.b.m {
        /*
            r6 = this;
            java.lang.String r0 = com.beizi.ad.internal.utilities.HaoboLog.httpUrlSourceLogTag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Read content info failFrom "
            r1.append(r2)
            com.beizi.ad.internal.b.p r2 = r6.f13722b
            java.lang.String r2 = r2.f13738a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.beizi.ad.internal.utilities.HaoboLog.d(r0, r1)
            r0 = 0
            r1 = 10000(0x2710, float:1.4013E-41)
            r2 = 0
            java.net.HttpURLConnection r0 = r6.a(r0, r1)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63
            int r1 = r0.getContentLength()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r0.getContentType()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.io.InputStream r2 = r0.getInputStream()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.p r4 = new com.beizi.ad.internal.b.p     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.p r5 = r6.f13722b     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r5 = r5.f13738a     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r4.<init>(r5, r1, r3)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r6.f13722b = r4     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.b.c r1 = r6.f13721a     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r4.f13738a     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r1.a(r3, r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r1 = com.beizi.ad.internal.utilities.HaoboLog.httpUrlSourceLogTag     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r3.<init>()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r4 = "Source info fetched: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.p r4 = r6.f13722b     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r3.append(r4)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.utilities.HaoboLog.d(r1, r3)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            com.beizi.ad.internal.b.n.a(r2)
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
            java.lang.String r3 = com.beizi.ad.internal.utilities.HaoboLog.httpUrlSourceLogTag     // Catch: java.lang.Throwable -> L5c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r4.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = "Error fetching info failFrom "
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            com.beizi.ad.internal.b.p r5 = r6.f13722b     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r5.f13738a     // Catch: java.lang.Throwable -> L5c
            r4.append(r5)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5c
            com.beizi.ad.internal.utilities.HaoboLog.e(r3, r4, r1)     // Catch: java.lang.Throwable -> L5c
            com.beizi.ad.internal.b.n.a(r2)
            if (r0 == 0) goto L87
        L84:
            r0.disconnect()
        L87:
            return
        L88:
            com.beizi.ad.internal.b.n.a(r2)
            if (r0 == 0) goto L90
            r0.disconnect()
        L90:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.b.h.e():void");
    }

    @Override // com.beizi.ad.internal.b.o
    public synchronized int a() throws m {
        if (this.f13722b.f13739b == Integer.MIN_VALUE) {
            e();
        }
        return this.f13722b.f13739b;
    }

    @Override // com.beizi.ad.internal.b.o
    public void b() throws m {
        HttpURLConnection httpURLConnection = this.f13723c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (IllegalArgumentException | NullPointerException e4) {
                throw new RuntimeException("Wait... but why? WTF!? ", e4);
            }
        }
    }

    public synchronized String c() throws m {
        if (TextUtils.isEmpty(this.f13722b.f13740c)) {
            e();
        }
        return this.f13722b.f13740c;
    }

    public String d() {
        return this.f13722b.f13738a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f13722b + "}";
    }

    public h(String str, com.beizi.ad.internal.b.b.c cVar) {
        this.f13721a = (com.beizi.ad.internal.b.b.c) k.a(cVar);
        p a4 = cVar.a(str);
        this.f13722b = a4 == null ? new p(str, Integer.MIN_VALUE, n.a(str)) : a4;
    }

    @Override // com.beizi.ad.internal.b.o
    public void a(int i4) throws m {
        try {
            HttpURLConnection a4 = a(i4, -1);
            this.f13723c = a4;
            String contentType = a4.getContentType();
            this.f13724d = new BufferedInputStream(this.f13723c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f13723c;
            p pVar = new p(this.f13722b.f13738a, a(httpURLConnection, i4, httpURLConnection.getResponseCode()), contentType);
            this.f13722b = pVar;
            this.f13721a.a(pVar.f13738a, pVar);
        } catch (IOException e4) {
            throw new m("Error opening connection for " + this.f13722b.f13738a + " with offset " + i4, e4);
        }
    }

    public h(h hVar) {
        this.f13722b = hVar.f13722b;
        this.f13721a = hVar.f13721a;
    }

    private int a(HttpURLConnection httpURLConnection, int i4, int i5) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        return i5 == 200 ? contentLength : i5 == 206 ? contentLength + i4 : this.f13722b.f13739b;
    }

    @Override // com.beizi.ad.internal.b.o
    public int a(byte[] bArr) throws m {
        InputStream inputStream = this.f13724d;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e4) {
                throw new i("Reading source " + this.f13722b.f13738a + " is interrupted", e4);
            } catch (IOException e5) {
                throw new m("Error reading data failFrom " + this.f13722b.f13738a, e5);
            }
        }
        throw new m("Error reading data failFrom " + this.f13722b.f13738a + ": connection is absent!");
    }

    private HttpURLConnection a(int i4, int i5) throws IOException, m {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z3;
        String str2 = this.f13722b.f13738a;
        int i6 = 0;
        do {
            String str3 = HaoboLog.httpUrlSourceLogTag;
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (i4 > 0) {
                str = " with offset " + i4;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            HaoboLog.d(str3, sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            if (i4 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i4 + "-");
            }
            if (i5 > 0) {
                httpURLConnection.setConnectTimeout(i5);
                httpURLConnection.setReadTimeout(i5);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z3 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z3) {
                str2 = httpURLConnection.getHeaderField("Location");
                i6++;
                httpURLConnection.disconnect();
            }
            if (i6 > 5) {
                throw new m("Too many redirects: " + i6);
            }
        } while (z3);
        return httpURLConnection;
    }
}
