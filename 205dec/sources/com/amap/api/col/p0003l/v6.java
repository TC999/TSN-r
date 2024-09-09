package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.q6;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpUrlUtil.java */
/* renamed from: com.amap.api.col.3l.v6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v6 {

    /* renamed from: t  reason: collision with root package name */
    private static SoftReference<SSLContext> f9234t;

    /* renamed from: u  reason: collision with root package name */
    private static SoftReference<w6> f9235u;

    /* renamed from: a  reason: collision with root package name */
    private boolean f9236a;

    /* renamed from: b  reason: collision with root package name */
    private SSLContext f9237b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f9238c;

    /* renamed from: g  reason: collision with root package name */
    private String f9242g;

    /* renamed from: h  reason: collision with root package name */
    private q6.a f9243h;

    /* renamed from: i  reason: collision with root package name */
    private d f9244i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9246k;

    /* renamed from: l  reason: collision with root package name */
    private String f9247l;

    /* renamed from: m  reason: collision with root package name */
    private String f9248m;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f9239d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f9240e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f9241f = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f9245j = "";

    /* renamed from: n  reason: collision with root package name */
    private boolean f9249n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9250o = false;

    /* renamed from: p  reason: collision with root package name */
    private String f9251p = "";

    /* renamed from: q  reason: collision with root package name */
    private String f9252q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f9253r = "";

    /* renamed from: s  reason: collision with root package name */
    private f f9254s = new f();

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.v6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements Cloneable, Comparable {

        /* renamed from: a  reason: collision with root package name */
        public int f9255a;

        /* renamed from: b  reason: collision with root package name */
        public String f9256b;

        /* renamed from: c  reason: collision with root package name */
        public String f9257c;

        /* renamed from: d  reason: collision with root package name */
        public String f9258d;

        /* renamed from: e  reason: collision with root package name */
        public String f9259e;

        /* renamed from: f  reason: collision with root package name */
        public int f9260f;

        /* renamed from: g  reason: collision with root package name */
        public int f9261g;

        /* renamed from: h  reason: collision with root package name */
        public int f9262h;

        /* renamed from: i  reason: collision with root package name */
        public long f9263i;

        /* renamed from: j  reason: collision with root package name */
        public volatile AtomicInteger f9264j = new AtomicInteger(1);

        public a(c cVar) {
            this.f9256b = cVar.f9269c;
            this.f9257c = cVar.f9271e;
            this.f9259e = cVar.f9270d;
            this.f9260f = cVar.f9279m;
            this.f9261g = cVar.f9280n;
            this.f9262h = cVar.f9268b.a();
            this.f9258d = cVar.f9267a;
            this.f9263i = cVar.f9272f;
            if (this.f9260f == 10) {
                this.f9255a = 0;
            }
        }

        /* renamed from: a */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f9260f + "#";
                if (!TextUtils.isEmpty(this.f9259e)) {
                    str = str5 + this.f9259e + "#";
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.f9262h + "#") + this.f9264j + "#";
                if (!TextUtils.isEmpty(this.f9256b)) {
                    str2 = str6 + this.f9256b + "#";
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f9260f == 1) {
                    str3 = str2 + this.f9258d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f9260f == 1) {
                    str4 = str3 + this.f9263i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String f4 = j4.f(m6.a(((str4 + this.f9257c + "#") + this.f9261g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                v6.s();
                return f4;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f9255a - ((a) obj).f9255a;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.v6$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HttpURLConnection f9265a;

        /* renamed from: b  reason: collision with root package name */
        public int f9266b = this.f9266b;

        /* renamed from: b  reason: collision with root package name */
        public int f9266b = this.f9266b;

        public b(HttpURLConnection httpURLConnection) {
            this.f9265a = httpURLConnection;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.v6$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public String f9267a = "";

        /* renamed from: b  reason: collision with root package name */
        public Cif.b f9268b = Cif.b.FIRST_NONDEGRADE;

        /* renamed from: c  reason: collision with root package name */
        public String f9269c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f9270d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f9271e = "";

        /* renamed from: f  reason: collision with root package name */
        public long f9272f = 0;

        /* renamed from: g  reason: collision with root package name */
        public long f9273g = 0;

        /* renamed from: h  reason: collision with root package name */
        public long f9274h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f9275i = 0;

        /* renamed from: j  reason: collision with root package name */
        public long f9276j = 0;

        /* renamed from: k  reason: collision with root package name */
        public String f9277k = "-";

        /* renamed from: l  reason: collision with root package name */
        public String f9278l = "-";

        /* renamed from: m  reason: collision with root package name */
        public int f9279m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f9280n = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        protected final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f9269c)) {
                str = "-#";
            } else {
                str = this.f9269c + "#";
            }
            if (!TextUtils.isEmpty(this.f9270d)) {
                str2 = str + this.f9270d + "#";
            } else {
                str2 = str + "-#";
            }
            String f4 = j4.f(m6.a(((((str2 + this.f9268b.a() + "#") + this.f9274h + "#") + this.f9276j + "#") + this.f9272f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            v6.s();
            return f4;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f9267a + "', degradeType=" + this.f9268b + ", serverIp='" + this.f9269c + "', path='" + this.f9270d + "', hostname='" + this.f9271e + "', totalTime=" + this.f9272f + ", DNSTime=" + this.f9273g + ", connectionTime=" + this.f9274h + ", writeTime=" + this.f9275i + ", readTime=" + this.f9276j + ", serverTime='" + this.f9277k + "', datasize='" + this.f9278l + "', errorcode=" + this.f9279m + ", errorcodeSub=" + this.f9280n + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.v6$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        private String f9283a;

        /* renamed from: b  reason: collision with root package name */
        private String f9284b;

        private e() {
        }

        public final String a() {
            return this.f9284b;
        }

        public final void b(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f9283a) && str.contains(":") && (split = str.split(":")) != null && split.length > 0) {
                this.f9283a = split[0];
            } else {
                this.f9283a = str;
            }
        }

        public final void c(String str) {
            this.f9284b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f9283a)) {
                return this.f9283a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f9284b)) {
                return defaultHostnameVerifier.verify(this.f9284b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.v6$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        long f9285a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f9286b = 0;

        /* renamed from: c  reason: collision with root package name */
        c f9287c = new c();

        /* renamed from: d  reason: collision with root package name */
        a f9288d;

        /* renamed from: e  reason: collision with root package name */
        c f9289e;

        /* renamed from: f  reason: collision with root package name */
        String f9290f;

        /* renamed from: g  reason: collision with root package name */
        URL f9291g;

        f() {
        }

        public final void a() {
            this.f9287c.f9274h = SystemClock.elapsedRealtime() - this.f9286b;
        }

        public final void b(int i4) {
            "----errorcode-----".concat(String.valueOf(i4));
            v6.s();
            try {
                this.f9287c.f9272f = SystemClock.elapsedRealtime() - this.f9285a;
                c cVar = this.f9287c;
                cVar.f9279m = i4;
                if (cVar.f9268b.e()) {
                    g4.u(false, this.f9287c.f9271e);
                }
                boolean v3 = v6.this.v(this.f9287c.f9271e);
                if (v3) {
                    if (v6.this.f9250o && !TextUtils.isEmpty(v6.this.f9248m) && this.f9287c.f9268b.b()) {
                        g4.L();
                    }
                    if (this.f9287c.f9268b.c()) {
                        g4.u(this.f9287c.f9268b.c(), this.f9287c.f9271e);
                    }
                    g4.J(this.f9289e);
                    g4.t(false, this.f9288d);
                    g4.E(this.f9287c);
                }
                g4.s(this.f9291g.toString(), this.f9287c.f9268b.c(), true, v3);
                this.f9287c.toString();
                v6.s();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j4) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f9287c.f9278l = decimalFormat.format(((float) j4) / 1024.0f);
        }

        public final void d(Cif cif, URL url) {
            this.f9291g = url;
            this.f9287c.f9270d = url.getPath();
            this.f9287c.f9271e = url.getHost();
            if (!TextUtils.isEmpty(v6.this.f9248m) && cif.getDegradeType().b()) {
                c cVar = this.f9287c;
                cVar.f9269c = cVar.f9271e.replace("[", "").replace("]", "");
                this.f9287c.f9271e = v6.this.f9248m;
            }
            if (cif.getDegradeType().b()) {
                cif.setNon_degrade_final_Host(this.f9287c.f9271e);
            }
            if (cif.getDegradeType().d()) {
                this.f9290f = cif.getNon_degrade_final_Host();
            }
        }

        public final void e(y6 y6Var) {
            c clone;
            try {
                this.f9287c.f9272f = SystemClock.elapsedRealtime() - this.f9285a;
                if (y6Var != null) {
                    y6Var.f9529f = this.f9287c.f9268b.c();
                }
                if (this.f9287c.f9268b.b()) {
                    c cVar = this.f9287c;
                    if (cVar.f9272f > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        g4.u(false, cVar.f9271e);
                    }
                }
                if (this.f9287c.f9268b.d()) {
                    g4.u(false, this.f9290f);
                }
                boolean v3 = v6.this.v(this.f9287c.f9271e);
                if (v3) {
                    g4.J(this.f9287c);
                    g4.t(true, this.f9288d);
                    c cVar2 = this.f9287c;
                    if (cVar2.f9272f > g4.f7827s && (clone = cVar2.clone()) != null) {
                        clone.f9279m = 1;
                        g4.E(clone);
                        clone.toString();
                        v6.s();
                    }
                }
                g4.s(this.f9291g.toString(), this.f9287c.f9268b.c(), false, v3);
                this.f9287c.toString();
                v6.s();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.f9287c.f9275i = SystemClock.elapsedRealtime() - this.f9286b;
        }

        public final void g(int i4) {
            this.f9287c.f9280n = i4;
        }

        public final void h() {
            this.f9287c.f9276j = SystemClock.elapsedRealtime() - this.f9286b;
        }

        public final void i() {
            c clone = this.f9287c.clone();
            if (this.f9287c.f9272f > g4.f7827s) {
                clone.f9279m = 1;
            }
            g4.o(clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v6() {
        g4.O();
        try {
            this.f9242g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "ic");
        }
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        return exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0145 A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:44:0x00ce, B:47:0x00e6, B:49:0x00e9, B:51:0x00ed, B:53:0x00f3, B:57:0x00fc, B:60:0x0108, B:62:0x010b, B:64:0x0111, B:74:0x013f, B:76:0x0145, B:78:0x014f, B:80:0x0160, B:82:0x0188, B:84:0x01a9, B:85:0x01ac, B:65:0x0127, B:67:0x012b, B:69:0x012e, B:71:0x0134, B:72:0x013b), top: B:137:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003l.v6.b b(com.amap.api.col.p0003l.Cif r17, boolean r18, boolean r19) throws java.io.IOException, com.amap.api.col.p0003l.fk {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v6.b(com.amap.api.col.3l.if, boolean, boolean):com.amap.api.col.3l.v6$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x017a A[Catch: all -> 0x01c8, IOException -> 0x01ce, SocketTimeoutException -> 0x01fd, ConnectTimeoutException -> 0x0202, TRY_ENTER, TryCatch #20 {SocketTimeoutException -> 0x01fd, ConnectTimeoutException -> 0x0202, IOException -> 0x01ce, all -> 0x01c8, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:44:0x00a8, B:105:0x017a, B:106:0x01c7), top: B:167:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0217 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8 A[Catch: all -> 0x01c8, IOException -> 0x01ce, SocketTimeoutException -> 0x01fd, ConnectTimeoutException -> 0x0202, TRY_ENTER, TRY_LEAVE, TryCatch #20 {SocketTimeoutException -> 0x01fd, ConnectTimeoutException -> 0x0202, IOException -> 0x01ce, all -> 0x01c8, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:44:0x00a8, B:105:0x017a, B:106:0x01c7), top: B:167:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003l.y6 c(com.amap.api.col.p0003l.v6.b r17, boolean r18) throws com.amap.api.col.p0003l.fk, java.io.IOException {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v6.c(com.amap.api.col.3l.v6$b, boolean):com.amap.api.col.3l.y6");
    }

    private static String e(String str) {
        URL url;
        int i4;
        f.b a4 = f.a.a();
        if (a4 == null) {
            return str;
        }
        URL url2 = null;
        try {
            url = new URL(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            url = null;
        }
        if (url == null) {
            return str;
        }
        String a5 = a4.a(url.getHost(), url.getPath());
        if (TextUtils.isEmpty(a5)) {
            return str;
        }
        String[] split = a5.split(":");
        int i5 = 0;
        if (split.length == 2) {
            try {
                i4 = Integer.parseInt(split[1]);
            } catch (Exception e5) {
                e5.printStackTrace();
                i4 = 0;
            }
            i5 = i4;
            a5 = split[0];
        }
        try {
            String protocol = url.getProtocol();
            if (i5 == 0) {
                i5 = url.getPort();
            }
            url2 = new URL(protocol, a5, i5, url.getFile().toString());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return url2 == null ? str : url2.toString();
    }

    private static String f(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = g4.f7815g;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? q4.d(context) : "");
    }

    private static String g(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = q6.f8838e;
        if (hashMap != null) {
            if (map != null) {
                map.putAll(hashMap);
            } else {
                map = hashMap;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf >= 0) {
            HashMap hashMap2 = new HashMap();
            String substring = str.substring(indexOf);
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                String encode = URLEncoder.encode(key);
                if (!substring.matches(".*[\\?\\&]" + encode + "=.*")) {
                    hashMap2.put(key, value);
                }
            }
            map = hashMap2;
        }
        if (map.size() == 0) {
            return str;
        }
        String i4 = i(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith("?") && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
        } else {
            stringBuffer.append("?");
        }
        if (i4 != null) {
            stringBuffer.append(i4);
        }
        return stringBuffer.toString();
    }

    private static String h(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(key));
                sb.append("=");
                sb.append(URLEncoder.encode(value));
            }
            return sb.toString();
        }
        return null;
    }

    private void n(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z3) {
        c T;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = q6.f8837d;
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str2, q6.f8837d.get(str2));
            }
        }
        String str3 = "";
        if (z3 && !this.f9247l.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f9245j) && g4.N(this.f9245j)) {
            this.f9249n = true;
            g4.h R = g4.R(this.f9245j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(R.f7869a));
            httpURLConnection.addRequestProperty("lct-info", R.f7870b);
            httpURLConnection.addRequestProperty(CampaignEx.JSON_KEY_AD_AKS, g4.H(g4.f(this.f9245j)));
            httpURLConnection.addRequestProperty("lct-args", f(g4.A(this.f9245j) != null ? g4.A(this.f9245j).e() : "", this.f9245j));
        }
        httpURLConnection.addRequestProperty("csid", this.f9242g);
        if (v(this.f9254s.f9287c.f9271e)) {
            f fVar = this.f9254s;
            if (!TextUtils.isEmpty(fVar.f9287c.f9269c)) {
                str3 = j4.f(m6.a(fVar.f9287c.f9269c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.f9287c.f9269c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (g4.f7834z && (T = g4.T()) != null) {
                httpURLConnection.addRequestProperty("nls", T.b());
                this.f9254s.f9289e = T;
            }
            a S = g4.S();
            if (S != null) {
                httpURLConnection.addRequestProperty("nlf", S.b());
                this.f9254s.f9288d = S;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean p(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "#"
            java.lang.String r1 = "lct"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "sc"
            java.lang.Object r4 = r7.get(r4)     // Catch: java.lang.Throwable -> L62
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L3c
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L62
            if (r5 <= 0) goto L3c
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L62
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L62
            if (r5 != 0) goto L3c
            boolean r5 = r4.contains(r0)     // Catch: java.lang.Throwable -> L62
            if (r5 != 0) goto L2a
        L28:
            r0 = 1
            goto L3d
        L2a:
            java.lang.String[] r0 = r4.split(r0)     // Catch: java.lang.Throwable -> L62
            int r4 = r0.length     // Catch: java.lang.Throwable -> L62
            if (r4 <= r2) goto L3c
            java.lang.String r4 = "1"
            r0 = r0[r2]     // Catch: java.lang.Throwable -> L62
            boolean r0 = r4.equals(r0)     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L3c
            goto L28
        L3c:
            r0 = 0
        L3d:
            if (r0 != 0) goto L40
            return r3
        L40:
            if (r8 == 0) goto L63
            boolean r8 = r7.containsKey(r1)     // Catch: java.lang.Throwable -> L62
            if (r8 == 0) goto L62
            java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Throwable -> L62
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L62
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L62
            if (r8 <= 0) goto L62
            long r7 = com.amap.api.col.p0003l.g4.a(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r6.f9245j     // Catch: java.lang.Throwable -> L62
            boolean r7 = com.amap.api.col.p0003l.g4.w(r0, r7)     // Catch: java.lang.Throwable -> L62
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v6.p(java.util.Map, boolean):boolean");
    }

    private static String r(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                String[] split = str.split("#");
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(String str) {
        if (this.f9246k) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f9248m) && (this.f9248m.contains("rest") || this.f9248m.contains("apilocate"))) || y(str);
    }

    private w6 w() {
        try {
            SoftReference<w6> softReference = f9235u;
            if (softReference == null || softReference.get() == null) {
                f9235u = new SoftReference<>(new w6(g4.f7815g, this.f9237b));
            }
            w6 w6Var = f9234t != null ? f9235u.get() : null;
            return w6Var == null ? new w6(g4.f7815g, this.f9237b) : w6Var;
        } catch (Throwable th) {
            u5.p(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "gsf");
            return null;
        }
    }

    private static boolean y(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    private void z(Cif cif) throws fk {
        this.f9244i = new d((byte) 0);
        this.f9250o = cif.isIPV6Request();
        this.f9238c = cif.getProxy();
        this.f9243h = cif.getUrlConnectionImpl();
        this.f9246k = cif.isBinary();
        this.f9245j = cif.parseSdkNameFromRequest();
        this.f9236a = k4.a().e(cif.isHttps());
        String b4 = cif.getDegradeType().b() ? cif.b() : cif.a();
        this.f9247l = b4;
        String e4 = e(b4);
        this.f9247l = e4;
        String a4 = u6.a(e4, this.f9245j);
        this.f9247l = a4;
        "restrictionURLTest: ".concat(String.valueOf(a4));
        if (!a7.b().c(a4)) {
            this.f9248m = cif.getIPDNSName();
            if ("loc".equals(this.f9245j)) {
                String a5 = cif.a();
                String b5 = cif.b();
                if (!TextUtils.isEmpty(a5)) {
                    try {
                        this.f9252q = new URL(a5).getHost();
                    } catch (Exception unused) {
                    }
                }
                if (TextUtils.isEmpty(b5)) {
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(this.f9248m)) {
                        this.f9251p = this.f9248m;
                        return;
                    } else {
                        this.f9251p = new URL(b5).getHost();
                        return;
                    }
                } catch (Exception unused2) {
                    return;
                }
            }
            return;
        }
        "restriction hit: ".concat(String.valueOf(a4));
        throw new fk("\u9650\u5236\u8bbf\u95ee\u7684\u63a5\u53e3");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> j(Cif cif) throws fk {
        String headerFieldKey;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                z(cif);
                this.f9247l = g(this.f9247l, cif.getParams());
                HttpURLConnection httpURLConnection2 = b(cif, false, false).f9265a;
                try {
                    this.f9254s.f9286b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f9254s.a();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode < 400) {
                        HashMap hashMap = new HashMap();
                        for (int i4 = 0; i4 < 50 && (headerFieldKey = httpURLConnection2.getHeaderFieldKey(i4)) != null; i4++) {
                            hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection2.getHeaderField(headerFieldKey));
                        }
                        this.f9254s.e(null);
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable th) {
                            q5.e(th, "hth", "mgr");
                        }
                        this.f9254s.i();
                        return hashMap;
                    }
                    this.f9254s.g(responseCode);
                    this.f9254s.b(10);
                    fk fkVar = new fk("http\u8bfb\u53d6header\u5931\u8d25");
                    fkVar.a(responseCode);
                    throw fkVar;
                } catch (fk e4) {
                    e = e4;
                    this.f9254s.b(e.g());
                    throw e;
                } catch (ConnectException e5) {
                    e = e5;
                    this.f9254s.g(a(e));
                    this.f9254s.b(6);
                    throw new fk("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                } catch (MalformedURLException unused) {
                    this.f9254s.b(8);
                    throw new fk("url\u5f02\u5e38 - MalformedURLException");
                } catch (SocketTimeoutException e6) {
                    e = e6;
                    this.f9254s.g(a(e));
                    this.f9254s.b(2);
                    throw new fk("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException");
                } catch (UnknownHostException unused2) {
                    this.f9254s.b(9);
                    throw new fk("\u672a\u77e5\u4e3b\u673a - UnKnowHostException");
                } catch (SSLException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(4);
                    throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (ConnectTimeoutException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(2);
                    throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (InterruptedIOException unused3) {
                    this.f9254s.g(7101);
                    this.f9254s.b(7);
                    throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
                } catch (SocketException e9) {
                    e = e9;
                    this.f9254s.g(a(e));
                    this.f9254s.b(6);
                    throw new fk("socket \u8fde\u63a5\u5f02\u5e38 - SocketException");
                } catch (IOException unused4) {
                    this.f9254s.b(7);
                    throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (Throwable th2) {
                    th = th2;
                    this.f9254s.b(9);
                    th.printStackTrace();
                    throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
                }
            } catch (fk e10) {
                e = e10;
            } catch (ConnectException e11) {
                e = e11;
            } catch (MalformedURLException unused5) {
            } catch (SocketException e12) {
                e = e12;
            } catch (SocketTimeoutException e13) {
                e = e13;
            } catch (InterruptedIOException unused6) {
            } catch (UnknownHostException unused7) {
            } catch (SSLException e14) {
                e = e14;
            } catch (ConnectTimeoutException e15) {
                e = e15;
            } catch (IOException unused8) {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th5) {
                    q5.e(th5, "hth", "mgr");
                }
            }
            this.f9254s.i();
            throw th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() {
        this.f9239d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(long j4) {
        this.f9241f = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(3:6|7|8)|(3:494|495|(15:497|11|12|13|(4:443|444|445|446)(1:15)|16|17|18|(1:20)(1:420)|21|(1:23)|24|(4:26|27|28|(2:30|31))(13:308|309|310|311|(6:318|319|(4:321|322|323|(1:325)(1:332))(1:391)|(2:327|328)(2:330|331)|329|312)|393|333|(1:335)(1:357)|336|(2:349|350)|338|339|(2:341|342))|36|37))|10|11|12|13|(0)(0)|16|17|18|(0)(0)|21|(0)|24|(0)(0)|36|37) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:6|7|8|(3:494|495|(15:497|11|12|13|(4:443|444|445|446)(1:15)|16|17|18|(1:20)(1:420)|21|(1:23)|24|(4:26|27|28|(2:30|31))(13:308|309|310|311|(6:318|319|(4:321|322|323|(1:325)(1:332))(1:391)|(2:327|328)(2:330|331)|329|312)|393|333|(1:335)(1:357)|336|(2:349|350)|338|339|(2:341|342))|36|37))|10|11|12|13|(0)(0)|16|17|18|(0)(0)|21|(0)|24|(0)(0)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02af, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02b0, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02ba, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02c4, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02ce, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02d8, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02e1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02e2, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02eb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02ec, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x02f5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02f6, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0300, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0309, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x030a, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0313, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0314, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x031d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x031e, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0322, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0323, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0328, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0329, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x032e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x032f, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0334, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0335, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x033a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x033b, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0340, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0341, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0346, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0347, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x034c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x034d, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0352, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0353, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0358, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0359, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0148 A[Catch: all -> 0x00cc, fk -> 0x00cf, IOException -> 0x00d2, InterruptedIOException -> 0x00d5, SocketTimeoutException -> 0x00d8, SocketException -> 0x00db, UnknownHostException -> 0x00de, MalformedURLException -> 0x00e1, ConnectTimeoutException -> 0x00e4, SSLException -> 0x00e7, ConnectException -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #52 {fk -> 0x00cf, ConnectException -> 0x00ea, MalformedURLException -> 0x00e1, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, UnknownHostException -> 0x00de, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, IOException -> 0x00d2, all -> 0x00cc, blocks: (B:38:0x00bc, B:107:0x0148), top: B:601:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0193 A[Catch: all -> 0x02af, fk -> 0x02b9, IOException -> 0x02c3, InterruptedIOException -> 0x02cd, SocketTimeoutException -> 0x02d7, SocketException -> 0x02e1, UnknownHostException -> 0x02eb, MalformedURLException -> 0x02f5, ConnectTimeoutException -> 0x02ff, SSLException -> 0x0309, ConnectException -> 0x0313, TRY_ENTER, TRY_LEAVE, TryCatch #53 {fk -> 0x02b9, ConnectException -> 0x0313, MalformedURLException -> 0x02f5, SocketException -> 0x02e1, SocketTimeoutException -> 0x02d7, ConnectTimeoutException -> 0x02ff, InterruptedIOException -> 0x02cd, UnknownHostException -> 0x02eb, SSLException -> 0x0309, IOException -> 0x02c3, all -> 0x02af, blocks: (B:96:0x0130, B:120:0x0193), top: B:599:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:504:0x051b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0429 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0434 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0551 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:514:0x055c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:516:0x0467 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:518:0x0472 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0380 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:526:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0592 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:530:0x059d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:532:0x04a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x04b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:536:0x03b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:538:0x03c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:540:0x05d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:542:0x04da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:544:0x05db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:549:0x04e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:551:0x03ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:553:0x03f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0510 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:565:0x04ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:567:0x0540 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0418 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0456 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:575:0x03a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:577:0x05bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:579:0x036f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0581 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:583:0x04c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:585:0x03dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0494 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:603:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(com.amap.api.col.p0003l.Cif r20, com.amap.api.col.p0003l.t6.a r21) {
        /*
            Method dump skipped, instructions count: 1557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v6.m(com.amap.api.col.3l.if, com.amap.api.col.3l.t6$a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y6 q(Cif cif) throws fk {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                z(cif);
                                String g4 = g(this.f9247l, cif.getParams());
                                this.f9247l = g4;
                                y6 o4 = u6.o(g4, this.f9245j);
                                if (o4 != null) {
                                    this.f9254s.i();
                                    return o4;
                                }
                                b b4 = b(cif, false, true);
                                HttpURLConnection httpURLConnection = b4.f9265a;
                                this.f9254s.f9286b = SystemClock.elapsedRealtime();
                                httpURLConnection.connect();
                                this.f9254s.a();
                                y6 c4 = c(b4, cif.isIgnoreGZip());
                                this.f9254s.e(c4);
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mgr");
                                }
                                this.f9254s.i();
                                return c4;
                            } catch (ConnectException e4) {
                                this.f9254s.g(a(e4));
                                this.f9254s.b(6);
                                throw new fk("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                            } catch (SocketException e5) {
                                this.f9254s.g(a(e5));
                                this.f9254s.b(6);
                                throw new fk("socket \u8fde\u63a5\u5f02\u5e38 - SocketException");
                            }
                        } catch (InterruptedIOException unused) {
                            this.f9254s.g(7101);
                            this.f9254s.b(7);
                            throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
                        } catch (IOException unused2) {
                            this.f9254s.b(7);
                            throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                        }
                    } catch (SocketTimeoutException e6) {
                        this.f9254s.g(a(e6));
                        this.f9254s.b(2);
                        throw new fk("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException");
                    } catch (ConnectTimeoutException e7) {
                        e7.printStackTrace();
                        this.f9254s.g(a(e7));
                        this.f9254s.b(2);
                        throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                    }
                } catch (MalformedURLException unused3) {
                    this.f9254s.b(8);
                    throw new fk("url\u5f02\u5e38 - MalformedURLException");
                } catch (UnknownHostException unused4) {
                    this.f9254s.b(9);
                    throw new fk("\u672a\u77e5\u4e3b\u673a - UnKnowHostException");
                }
            } catch (fk e8) {
                if (!e8.i() && e8.g() != 10) {
                    this.f9254s.b(e8.f());
                }
                throw e8;
            } catch (SSLException e9) {
                e9.printStackTrace();
                this.f9254s.g(a(e9));
                this.f9254s.b(4);
                throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(long j4) {
        this.f9240e = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final y6 x(Cif cif) throws fk {
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = 0;
        dataOutputStream2 = 0;
        try {
            try {
                z(cif);
                y6 o4 = u6.o(this.f9247l, this.f9245j);
                if (o4 != null) {
                    this.f9254s.i();
                    return o4;
                }
                b b4 = b(cif, true, true);
                HttpURLConnection httpURLConnection = b4.f9265a;
                try {
                    this.f9254s.f9286b = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    this.f9254s.a();
                    byte[] entityBytes = cif.getEntityBytes();
                    if (entityBytes == null || entityBytes.length == 0) {
                        Map<String, String> params = cif.getParams();
                        HashMap<String, String> hashMap = q6.f8838e;
                        if (hashMap != null) {
                            if (params != null) {
                                params.putAll(hashMap);
                            } else {
                                params = hashMap;
                            }
                        }
                        String i4 = i(params);
                        if (!TextUtils.isEmpty(i4)) {
                            entityBytes = q4.o(i4);
                        }
                    }
                    if (entityBytes != null && entityBytes.length > 0) {
                        try {
                            this.f9254s.f9286b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection.getOutputStream();
                            try {
                                dataOutputStream = new DataOutputStream(outputStream);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = null;
                        }
                        try {
                            dataOutputStream.write(entityBytes);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f9254s.f();
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != 0) {
                                dataOutputStream2.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f9254s.f();
                            throw th;
                        }
                    }
                    y6 c4 = c(b4, cif.isIgnoreGZip());
                    this.f9254s.e(c4);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        q5.e(th4, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    }
                    this.f9254s.i();
                    return c4;
                } catch (fk e4) {
                    e = e4;
                    if (!e.i() && e.g() != 10) {
                        this.f9254s.b(e.g());
                    }
                    q5.e(e, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    throw e;
                } catch (ConnectException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(6);
                    throw new fk("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                } catch (SocketException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(6);
                    throw new fk("socket \u8fde\u63a5\u5f02\u5e38 - SocketException");
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(2);
                    throw new fk("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException");
                } catch (ConnectTimeoutException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(2);
                    throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (InterruptedIOException unused) {
                    this.f9254s.g(7101);
                    this.f9254s.b(7);
                    throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
                } catch (MalformedURLException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f9254s.b(8);
                    throw new fk("url\u5f02\u5e38 - MalformedURLException");
                } catch (UnknownHostException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f9254s.b(5);
                    throw new fk("\u672a\u77e5\u4e3b\u673a - UnKnowHostException");
                } catch (SSLException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.f9254s.g(a(e));
                    this.f9254s.b(4);
                    throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    this.f9254s.b(7);
                    throw new fk("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (Throwable th5) {
                    th = th5;
                    q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    this.f9254s.b(9);
                    throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
                }
            } catch (fk e13) {
                e = e13;
            } catch (InterruptedIOException unused2) {
            } catch (ConnectException e14) {
                e = e14;
            } catch (MalformedURLException e15) {
                e = e15;
            } catch (SocketException e16) {
                e = e16;
            } catch (SocketTimeoutException e17) {
                e = e17;
            } catch (UnknownHostException e18) {
                e = e18;
            } catch (SSLException e19) {
                e = e19;
            } catch (ConnectTimeoutException e20) {
                e = e20;
            } catch (IOException e21) {
                e = e21;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            if (0 != 0) {
                try {
                    dataOutputStream2.disconnect();
                } catch (Throwable th8) {
                    q5.e(th8, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                }
            }
            this.f9254s.i();
            throw th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.v6$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Vector<e> f9281a;

        /* renamed from: b  reason: collision with root package name */
        private volatile e f9282b;

        private d() {
            this.f9281a = new Vector<>();
            this.f9282b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f9282b;
            }
            for (int i4 = 0; i4 < this.f9281a.size(); i4++) {
                e eVar = this.f9281a.get(i4);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e((byte) 0);
            eVar2.c(str);
            this.f9281a.add(eVar2);
            return eVar2;
        }

        /* synthetic */ d(byte b4) {
            this();
        }
    }
}
