package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: JavaHttpSpider.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38902a = "f";

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.c.a f38903b;

    /* renamed from: c  reason: collision with root package name */
    private String f38904c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f38905d = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f38906e = 3145728;

    /* renamed from: f  reason: collision with root package name */
    private a f38907f;

    /* compiled from: JavaHttpSpider.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38908a;

        /* renamed from: b  reason: collision with root package name */
        public String f38909b;

        /* renamed from: c  reason: collision with root package name */
        public String f38910c;

        /* renamed from: d  reason: collision with root package name */
        public String f38911d;

        /* renamed from: e  reason: collision with root package name */
        public int f38912e;

        /* renamed from: f  reason: collision with root package name */
        public int f38913f;

        /* renamed from: g  reason: collision with root package name */
        public String f38914g;

        /* renamed from: h  reason: collision with root package name */
        public String f38915h;

        public final String a() {
            return "statusCode=" + this.f38913f + ", location=" + this.f38908a + ", contentType=" + this.f38909b + ", contentLength=" + this.f38912e + ", contentEncoding=" + this.f38910c + ", referer=" + this.f38911d;
        }

        public final String toString() {
            return "http\u54cd\u5e94\u5934\uff1a...\nstatusCode=" + this.f38913f + ", location=" + this.f38908a + ", contentType=" + this.f38909b + ", contentLength=" + this.f38912e + ", contentEncoding=" + this.f38910c + ", referer=" + this.f38911d;
        }
    }

    public f() {
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        this.f38903b = b4;
        if (b4 == null) {
            this.f38903b = com.mbridge.msdk.c.b.a().b();
        }
    }

    public final a a(String str, boolean z3, boolean z4, CampaignEx campaignEx) {
        HttpURLConnection httpURLConnection;
        int i4;
        byte[] bytes;
        HttpURLConnection httpURLConnection2 = null;
        if (URLUtil.isNetworkUrl(str)) {
            String replace = str.replace(" ", "%20");
            URLUtil.isHttpsUrl(replace);
            String str2 = f38902a;
            x.b(str2, replace);
            this.f38907f = new a();
            try {
                httpURLConnection = (HttpURLConnection) new URL(replace).openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                if ((!z3 && !z4) || campaignEx == null) {
                    httpURLConnection.setRequestProperty("User-Agent", t.A());
                }
                if (z3 && campaignEx != null && campaignEx.getcUA() == 1) {
                    httpURLConnection.setRequestProperty("User-Agent", t.A());
                }
                if (z4 && campaignEx != null && campaignEx.getImpUA() == 1) {
                    httpURLConnection.setRequestProperty("User-Agent", t.A());
                }
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (this.f38903b.af() && !TextUtils.isEmpty(this.f38904c)) {
                    httpURLConnection.setRequestProperty("referer", this.f38904c);
                }
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                this.f38907f.f38908a = httpURLConnection.getHeaderField("Location");
                this.f38907f.f38911d = httpURLConnection.getHeaderField("Referer");
                this.f38907f.f38913f = httpURLConnection.getResponseCode();
                this.f38907f.f38909b = httpURLConnection.getContentType();
                this.f38907f.f38912e = httpURLConnection.getContentLength();
                this.f38907f.f38910c = httpURLConnection.getContentEncoding();
                x.b(str2, this.f38907f.toString());
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.f38907f.f38910c);
                a aVar = this.f38907f;
                if (aVar.f38913f == 200 && this.f38905d && (i4 = aVar.f38912e) > 0 && i4 < 3145728 && !TextUtils.isEmpty(replace) && !replace.endsWith(".apk")) {
                    try {
                        String a4 = a(httpURLConnection.getInputStream(), equalsIgnoreCase);
                        if (!TextUtils.isEmpty(a4) && (bytes = a4.getBytes()) != null && bytes.length > 0 && bytes.length < 3145728) {
                            this.f38907f.f38914g = a4.trim();
                        }
                    } catch (Throwable unused) {
                    }
                }
                this.f38904c = replace;
                httpURLConnection.disconnect();
                return this.f38907f;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                try {
                    this.f38907f.f38915h = th.getMessage();
                    x.c("http jump", "connecting");
                    return this.f38907f;
                } finally {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[Catch: all -> 0x002c, TryCatch #5 {all -> 0x002c, blocks: (B:4:0x0008, B:5:0x000e, B:19:0x002f, B:21:0x0033, B:22:0x0040), top: B:38:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045 A[Catch: Exception -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0049, blocks: (B:10:0x0022, B:24:0x0045), top: B:41:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.InputStream r4, boolean r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto Le
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r4 = r5
        Le:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
        L18:
            java.lang.String r4 = r5.readLine()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            if (r4 == 0) goto L22
            r0.append(r4)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            goto L18
        L22:
            r5.close()     // Catch: java.lang.Exception -> L49
            goto L4d
        L26:
            r4 = move-exception
            r1 = r5
            goto L52
        L29:
            r4 = move-exception
            r1 = r5
            goto L2f
        L2c:
            r4 = move-exception
            goto L52
        L2e:
            r4 = move-exception
        L2f:
            com.mbridge.msdk.click.f$a r5 = r3.f38907f     // Catch: java.lang.Throwable -> L2c
            if (r5 != 0) goto L40
            com.mbridge.msdk.click.f$a r5 = new com.mbridge.msdk.click.f$a     // Catch: java.lang.Throwable -> L2c
            r5.<init>()     // Catch: java.lang.Throwable -> L2c
            r3.f38907f = r5     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> L2c
            r5.f38915h = r2     // Catch: java.lang.Throwable -> L2c
        L40:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L4d
            r1.close()     // Catch: java.lang.Exception -> L49
            goto L4d
        L49:
            r4 = move-exception
            r4.printStackTrace()
        L4d:
            java.lang.String r4 = r0.toString()
            return r4
        L52:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.lang.Exception -> L58
            goto L5c
        L58:
            r5 = move-exception
            r5.printStackTrace()
        L5c:
            goto L5e
        L5d:
            throw r4
        L5e:
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.f.a(java.io.InputStream, boolean):java.lang.String");
    }
}
