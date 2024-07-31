package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import io.netty.handler.codec.http.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.mbridge.msdk.click.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class JavaHttpSpider {

    /* renamed from: a */
    private static final String f30075a = "f";

    /* renamed from: b */
    private Setting f30076b;

    /* renamed from: c */
    private String f30077c;

    /* renamed from: d */
    private boolean f30078d = true;

    /* renamed from: e */
    private final int f30079e = 3145728;

    /* renamed from: f */
    private C11224a f30080f;

    /* compiled from: JavaHttpSpider.java */
    /* renamed from: com.mbridge.msdk.click.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11224a {

        /* renamed from: a */
        public String f30081a;

        /* renamed from: b */
        public String f30082b;

        /* renamed from: c */
        public String f30083c;

        /* renamed from: d */
        public String f30084d;

        /* renamed from: e */
        public int f30085e;

        /* renamed from: f */
        public int f30086f;

        /* renamed from: g */
        public String f30087g;

        /* renamed from: h */
        public String f30088h;

        /* renamed from: a */
        public final String m23060a() {
            return "statusCode=" + this.f30086f + ", location=" + this.f30081a + ", contentType=" + this.f30082b + ", contentLength=" + this.f30085e + ", contentEncoding=" + this.f30083c + ", referer=" + this.f30084d;
        }

        public final String toString() {
            return "http响应头：...\nstatusCode=" + this.f30086f + ", location=" + this.f30081a + ", contentType=" + this.f30082b + ", contentLength=" + this.f30085e + ", contentEncoding=" + this.f30083c + ", referer=" + this.f30084d;
        }
    }

    public JavaHttpSpider() {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        this.f30076b = m23252b;
        if (m23252b == null) {
            this.f30076b = SettingManager.m23261a().m23253b();
        }
    }

    /* renamed from: a */
    public final C11224a m23061a(String str, boolean z, boolean z2, CampaignEx campaignEx) {
        HttpURLConnection httpURLConnection;
        int i;
        byte[] bytes;
        HttpURLConnection httpURLConnection2 = null;
        if (URLUtil.isNetworkUrl(str)) {
            String replace = str.replace(" ", "%20");
            URLUtil.isHttpsUrl(replace);
            String str2 = f30075a;
            SameLogTool.m21736b(str2, replace);
            this.f30080f = new C11224a();
            try {
                httpURLConnection = (HttpURLConnection) new URL(replace).openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                if ((!z && !z2) || campaignEx == null) {
                    httpURLConnection.setRequestProperty("User-Agent", SameDiTool.m21811A());
                }
                if (z && campaignEx != null && campaignEx.getcUA() == 1) {
                    httpURLConnection.setRequestProperty("User-Agent", SameDiTool.m21811A());
                }
                if (z2 && campaignEx != null && campaignEx.getImpUA() == 1) {
                    httpURLConnection.setRequestProperty("User-Agent", SameDiTool.m21811A());
                }
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (this.f30076b.m23366af() && !TextUtils.isEmpty(this.f30077c)) {
                    httpURLConnection.setRequestProperty("referer", this.f30077c);
                }
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                this.f30080f.f30081a = httpURLConnection.getHeaderField(HttpHeaders.Names.LOCATION);
                this.f30080f.f30084d = httpURLConnection.getHeaderField("Referer");
                this.f30080f.f30086f = httpURLConnection.getResponseCode();
                this.f30080f.f30082b = httpURLConnection.getContentType();
                this.f30080f.f30085e = httpURLConnection.getContentLength();
                this.f30080f.f30083c = httpURLConnection.getContentEncoding();
                SameLogTool.m21736b(str2, this.f30080f.toString());
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.f30080f.f30083c);
                C11224a c11224a = this.f30080f;
                if (c11224a.f30086f == 200 && this.f30078d && (i = c11224a.f30085e) > 0 && i < 3145728 && !TextUtils.isEmpty(replace) && !replace.endsWith(".apk")) {
                    try {
                        String m23062a = m23062a(httpURLConnection.getInputStream(), equalsIgnoreCase);
                        if (!TextUtils.isEmpty(m23062a) && (bytes = m23062a.getBytes()) != null && bytes.length > 0 && bytes.length < 3145728) {
                            this.f30080f.f30087g = m23062a.trim();
                        }
                    } catch (Throwable unused) {
                    }
                }
                this.f30077c = replace;
                httpURLConnection.disconnect();
                return this.f30080f;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                try {
                    this.f30080f.f30088h = th.getMessage();
                    SameLogTool.m21734c("http jump", "connecting");
                    return this.f30080f;
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m23062a(java.io.InputStream r4, boolean r5) {
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
            com.mbridge.msdk.click.f$a r5 = r3.f30080f     // Catch: java.lang.Throwable -> L2c
            if (r5 != 0) goto L40
            com.mbridge.msdk.click.f$a r5 = new com.mbridge.msdk.click.f$a     // Catch: java.lang.Throwable -> L2c
            r5.<init>()     // Catch: java.lang.Throwable -> L2c
            r3.f30080f = r5     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> L2c
            r5.f30088h = r2     // Catch: java.lang.Throwable -> L2c
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.JavaHttpSpider.m23062a(java.io.InputStream, boolean):java.lang.String");
    }
}