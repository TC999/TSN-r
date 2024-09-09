package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dz;
import com.amap.api.col.s.u2;
import com.amap.api.col.s.y0;
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
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x2 {

    /* renamed from: t  reason: collision with root package name */
    private static SoftReference<SSLContext> f10389t;

    /* renamed from: u  reason: collision with root package name */
    private static SoftReference<y2> f10390u;

    /* renamed from: a  reason: collision with root package name */
    private boolean f10391a;

    /* renamed from: b  reason: collision with root package name */
    private SSLContext f10392b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f10393c;

    /* renamed from: g  reason: collision with root package name */
    private String f10397g;

    /* renamed from: h  reason: collision with root package name */
    private u2.a f10398h;

    /* renamed from: i  reason: collision with root package name */
    private d f10399i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10401k;

    /* renamed from: l  reason: collision with root package name */
    private String f10402l;

    /* renamed from: m  reason: collision with root package name */
    private String f10403m;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f10394d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f10395e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f10396f = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f10400j = "";

    /* renamed from: n  reason: collision with root package name */
    private boolean f10404n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10405o = false;

    /* renamed from: p  reason: collision with root package name */
    private String f10406p = "";

    /* renamed from: q  reason: collision with root package name */
    private String f10407q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f10408r = "";

    /* renamed from: s  reason: collision with root package name */
    private f f10409s = new f();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements Cloneable, Comparable {

        /* renamed from: a  reason: collision with root package name */
        public int f10410a;

        /* renamed from: b  reason: collision with root package name */
        public String f10411b;

        /* renamed from: c  reason: collision with root package name */
        public String f10412c;

        /* renamed from: d  reason: collision with root package name */
        public String f10413d;

        /* renamed from: e  reason: collision with root package name */
        public String f10414e;

        /* renamed from: f  reason: collision with root package name */
        public int f10415f;

        /* renamed from: g  reason: collision with root package name */
        public int f10416g;

        /* renamed from: h  reason: collision with root package name */
        public int f10417h;

        /* renamed from: i  reason: collision with root package name */
        public long f10418i;

        /* renamed from: j  reason: collision with root package name */
        public volatile AtomicInteger f10419j = new AtomicInteger(1);

        public a(c cVar) {
            this.f10411b = cVar.f10424c;
            this.f10412c = cVar.f10426e;
            this.f10414e = cVar.f10425d;
            this.f10415f = cVar.f10434m;
            this.f10416g = cVar.f10435n;
            this.f10417h = cVar.f10423b.a();
            this.f10413d = cVar.f10422a;
            this.f10418i = cVar.f10427f;
            if (this.f10415f == 10) {
                this.f10410a = 0;
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
                String str5 = this.f10415f + "#";
                if (!TextUtils.isEmpty(this.f10414e)) {
                    str = str5 + this.f10414e + "#";
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.f10417h + "#") + this.f10419j + "#";
                if (!TextUtils.isEmpty(this.f10411b)) {
                    str2 = str6 + this.f10411b + "#";
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f10415f == 1) {
                    str3 = str2 + this.f10413d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f10415f == 1) {
                    str4 = str3 + this.f10418i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String f4 = d1.f(q2.a(((str4 + this.f10412c + "#") + this.f10416g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                x2.i();
                return f4;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f10410a - ((a) obj).f10410a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HttpURLConnection f10420a;

        /* renamed from: b  reason: collision with root package name */
        public int f10421b = this.f10421b;

        /* renamed from: b  reason: collision with root package name */
        public int f10421b = this.f10421b;

        public b(HttpURLConnection httpURLConnection) {
            this.f10420a = httpURLConnection;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public String f10422a = "";

        /* renamed from: b  reason: collision with root package name */
        public dz.b f10423b = dz.b.FIRST_NONDEGRADE;

        /* renamed from: c  reason: collision with root package name */
        public String f10424c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f10425d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f10426e = "";

        /* renamed from: f  reason: collision with root package name */
        public long f10427f = 0;

        /* renamed from: g  reason: collision with root package name */
        public long f10428g = 0;

        /* renamed from: h  reason: collision with root package name */
        public long f10429h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f10430i = 0;

        /* renamed from: j  reason: collision with root package name */
        public long f10431j = 0;

        /* renamed from: k  reason: collision with root package name */
        public String f10432k = "-";

        /* renamed from: l  reason: collision with root package name */
        public String f10433l = "-";

        /* renamed from: m  reason: collision with root package name */
        public int f10434m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f10435n = 0;

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
            if (TextUtils.isEmpty(this.f10424c)) {
                str = "-#";
            } else {
                str = this.f10424c + "#";
            }
            if (!TextUtils.isEmpty(this.f10425d)) {
                str2 = str + this.f10425d + "#";
            } else {
                str2 = str + "-#";
            }
            String f4 = d1.f(q2.a(((((str2 + this.f10423b.a() + "#") + this.f10429h + "#") + this.f10431j + "#") + this.f10427f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            x2.i();
            return f4;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f10422a + "', degradeType=" + this.f10423b + ", serverIp='" + this.f10424c + "', path='" + this.f10425d + "', hostname='" + this.f10426e + "', totalTime=" + this.f10427f + ", DNSTime=" + this.f10428g + ", connectionTime=" + this.f10429h + ", writeTime=" + this.f10430i + ", readTime=" + this.f10431j + ", serverTime='" + this.f10432k + "', datasize='" + this.f10433l + "', errorcode=" + this.f10434m + ", errorcodeSub=" + this.f10435n + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        private String f10438a;

        /* renamed from: b  reason: collision with root package name */
        private String f10439b;

        private e() {
        }

        public final String a() {
            return this.f10439b;
        }

        public final void b(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f10438a) && str.contains(":") && (split = str.split(":")) != null && split.length > 0) {
                this.f10438a = split[0];
            } else {
                this.f10438a = str;
            }
        }

        public final void c(String str) {
            this.f10439b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f10438a)) {
                return this.f10438a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f10439b)) {
                return defaultHostnameVerifier.verify(this.f10439b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        long f10440a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f10441b = 0;

        /* renamed from: c  reason: collision with root package name */
        c f10442c = new c();

        /* renamed from: d  reason: collision with root package name */
        a f10443d;

        /* renamed from: e  reason: collision with root package name */
        c f10444e;

        /* renamed from: f  reason: collision with root package name */
        String f10445f;

        /* renamed from: g  reason: collision with root package name */
        URL f10446g;

        f() {
        }

        public final void a() {
            this.f10442c.f10429h = SystemClock.elapsedRealtime() - this.f10441b;
        }

        public final void b(int i4) {
            "----errorcode-----".concat(String.valueOf(i4));
            x2.i();
            try {
                this.f10442c.f10427f = SystemClock.elapsedRealtime() - this.f10440a;
                c cVar = this.f10442c;
                cVar.f10434m = i4;
                if (cVar.f10423b.e()) {
                    y0.r(false, this.f10442c.f10426e);
                }
                boolean l4 = x2.this.l(this.f10442c.f10426e);
                if (l4) {
                    if (x2.this.f10405o && !TextUtils.isEmpty(x2.this.f10403m) && this.f10442c.f10423b.b()) {
                        y0.F();
                    }
                    if (this.f10442c.f10423b.c()) {
                        y0.r(this.f10442c.f10423b.c(), this.f10442c.f10426e);
                    }
                    y0.H(this.f10444e);
                    y0.q(false, this.f10443d);
                    y0.B(this.f10442c);
                }
                y0.p(this.f10446g.toString(), this.f10442c.f10423b.c(), true, l4);
                this.f10442c.toString();
                x2.i();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j4) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f10442c.f10433l = decimalFormat.format(((float) j4) / 1024.0f);
        }

        public final void d(dz dzVar, URL url) {
            this.f10446g = url;
            this.f10442c.f10425d = url.getPath();
            this.f10442c.f10426e = url.getHost();
            if (!TextUtils.isEmpty(x2.this.f10403m) && dzVar.B().b()) {
                c cVar = this.f10442c;
                cVar.f10424c = cVar.f10426e.replace("[", "").replace("]", "");
                this.f10442c.f10426e = x2.this.f10403m;
            }
            if (dzVar.B().b()) {
                dzVar.n(this.f10442c.f10426e);
            }
            if (dzVar.B().d()) {
                this.f10445f = dzVar.E();
            }
        }

        public final void e(b3 b3Var) {
            c clone;
            try {
                this.f10442c.f10427f = SystemClock.elapsedRealtime() - this.f10440a;
                if (b3Var != null) {
                    b3Var.f9648f = this.f10442c.f10423b.c();
                }
                if (this.f10442c.f10423b.b()) {
                    c cVar = this.f10442c;
                    if (cVar.f10427f > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        y0.r(false, cVar.f10426e);
                    }
                }
                if (this.f10442c.f10423b.d()) {
                    y0.r(false, this.f10445f);
                }
                boolean l4 = x2.this.l(this.f10442c.f10426e);
                if (l4) {
                    y0.H(this.f10442c);
                    y0.q(true, this.f10443d);
                    c cVar2 = this.f10442c;
                    if (cVar2.f10427f > y0.f10493s && (clone = cVar2.clone()) != null) {
                        clone.f10434m = 1;
                        y0.B(clone);
                        clone.toString();
                        x2.i();
                    }
                }
                y0.p(this.f10446g.toString(), this.f10442c.f10423b.c(), false, l4);
                this.f10442c.toString();
                x2.i();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.f10442c.f10430i = SystemClock.elapsedRealtime() - this.f10441b;
        }

        public final void g(int i4) {
            this.f10442c.f10435n = i4;
        }

        public final void h() {
            this.f10442c.f10431j = SystemClock.elapsedRealtime() - this.f10441b;
        }

        public final void i() {
            c clone = this.f10442c.clone();
            if (this.f10442c.f10427f > y0.f10493s) {
                clone.f10434m = 1;
            }
            y0.l(clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x2() {
        y0.I();
        try {
            this.f10397g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "ic");
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

    /* JADX WARN: Removed duplicated region for block: B:120:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142 A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:44:0x00cb, B:47:0x00e3, B:49:0x00e6, B:51:0x00ea, B:53:0x00f0, B:57:0x00f9, B:60:0x0105, B:62:0x0108, B:64:0x010e, B:74:0x013c, B:76:0x0142, B:78:0x014c, B:80:0x015d, B:82:0x0185, B:84:0x01a6, B:85:0x01a9, B:65:0x0124, B:67:0x0128, B:69:0x012b, B:71:0x0131, B:72:0x0138), top: B:137:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.s.x2.b b(com.amap.api.col.s.dz r15, boolean r16) throws java.io.IOException, com.amap.api.col.s.bv {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.x2.b(com.amap.api.col.s.dz, boolean):com.amap.api.col.s.x2$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x016d A[Catch: all -> 0x01ba, IOException -> 0x01bf, SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, IOException -> 0x01bf, all -> 0x01ba, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:44:0x00a4, B:104:0x016d, B:105:0x01b9), top: B:160:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[Catch: all -> 0x01ba, IOException -> 0x01bf, SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, IOException -> 0x01bf, all -> 0x01ba, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:44:0x00a4, B:104:0x016d, B:105:0x01b9), top: B:160:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.s.b3 c(com.amap.api.col.s.x2.b r15) throws com.amap.api.col.s.bv, java.io.IOException {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.x2.c(com.amap.api.col.s.x2$b):com.amap.api.col.s.b3");
    }

    private static String f(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = y0.f10481g;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? j1.d(context) : "");
    }

    private static String g(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = u2.f10279e;
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
        String h4 = h(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith("?") && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
        } else {
            stringBuffer.append("?");
        }
        if (h4 != null) {
            stringBuffer.append(h4);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Map<String, String> map) {
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

    public static void i() {
    }

    private void j(Map<String, String> map, HttpURLConnection httpURLConnection) {
        c P;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = u2.f10278d;
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str2, u2.f10278d.get(str2));
            }
        }
        String str3 = "";
        if (!this.f10402l.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f10400j) && y0.K(this.f10400j)) {
            this.f10404n = true;
            y0.h O = y0.O(this.f10400j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(O.f10535a));
            httpURLConnection.addRequestProperty("lct-info", O.f10536b);
            httpURLConnection.addRequestProperty(CampaignEx.JSON_KEY_AD_AKS, y0.E(y0.d(this.f10400j)));
            httpURLConnection.addRequestProperty("lct-args", f(y0.x(this.f10400j) != null ? y0.x(this.f10400j).e() : "", this.f10400j));
        }
        httpURLConnection.addRequestProperty("csid", this.f10397g);
        if (l(this.f10409s.f10442c.f10426e)) {
            f fVar = this.f10409s;
            if (!TextUtils.isEmpty(fVar.f10442c.f10424c)) {
                str3 = d1.f(q2.a(fVar.f10442c.f10424c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.f10442c.f10424c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (y0.f10500z && (P = y0.P()) != null) {
                httpURLConnection.addRequestProperty("nls", P.b());
                this.f10409s.f10444e = P;
            }
            a L2 = y0.L();
            if (L2 != null) {
                httpURLConnection.addRequestProperty("nlf", L2.b());
                this.f10409s.f10443d = L2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str) {
        if (this.f10401k) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f10403m) && (this.f10403m.contains("rest") || this.f10403m.contains("apilocate"))) || r(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
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
            long r7 = com.amap.api.col.s.y0.a(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r6.f10400j     // Catch: java.lang.Throwable -> L62
            boolean r7 = com.amap.api.col.s.y0.t(r0, r7)     // Catch: java.lang.Throwable -> L62
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.x2.m(java.util.Map, boolean):boolean");
    }

    private y2 n() {
        try {
            SoftReference<y2> softReference = f10390u;
            if (softReference == null || softReference.get() == null) {
                f10390u = new SoftReference<>(new y2(y0.f10481g, this.f10392b));
            }
            y2 y2Var = f10389t != null ? f10390u.get() : null;
            return y2Var == null ? new y2(y0.f10481g, this.f10392b) : y2Var;
        } catch (Throwable th) {
            g2.o(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "gsf");
            return null;
        }
    }

    private static String p(Map<String, List<String>> map) {
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

    private static boolean r(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    private void s(dz dzVar) throws bv {
        this.f10399i = new d((byte) 0);
        this.f10405o = dzVar.F();
        this.f10393c = dzVar.v();
        this.f10398h = dzVar.A();
        this.f10401k = dzVar.x();
        this.f10400j = dzVar.G();
        this.f10391a = e1.a().i(dzVar.z());
        String t3 = dzVar.B().b() ? dzVar.t() : dzVar.s();
        this.f10402l = t3;
        this.f10402l = w2.a(t3, this.f10400j);
        this.f10403m = dzVar.r();
        if ("loc".equals(this.f10400j)) {
            String s3 = dzVar.s();
            String t4 = dzVar.t();
            if (!TextUtils.isEmpty(s3)) {
                try {
                    this.f10407q = new URL(s3).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(t4)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.f10403m)) {
                    this.f10406p = this.f10403m;
                } else {
                    this.f10406p = new URL(t4).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b3 d(dz dzVar) throws bv {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        s(dzVar);
                                        String g4 = g(this.f10402l, dzVar.o());
                                        this.f10402l = g4;
                                        b3 o4 = w2.o(g4, this.f10400j);
                                        if (o4 != null) {
                                            this.f10409s.i();
                                            return o4;
                                        }
                                        b b4 = b(dzVar, false);
                                        HttpURLConnection httpURLConnection = b4.f10420a;
                                        this.f10409s.f10441b = SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.f10409s.a();
                                        b3 c4 = c(b4);
                                        this.f10409s.e(c4);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th) {
                                            d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mgr");
                                        }
                                        this.f10409s.i();
                                        return c4;
                                    } catch (InterruptedIOException unused) {
                                        this.f10409s.g(7101);
                                        this.f10409s.b(7);
                                        throw new bv("\u672a\u77e5\u7684\u9519\u8bef");
                                    } catch (SSLException e4) {
                                        e4.printStackTrace();
                                        this.f10409s.g(a(e4));
                                        this.f10409s.b(4);
                                        throw new bv("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                                    }
                                } catch (ConnectException e5) {
                                    this.f10409s.g(a(e5));
                                    this.f10409s.b(6);
                                    throw new bv("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                                } catch (UnknownHostException unused2) {
                                    this.f10409s.b(9);
                                    throw new bv("\u672a\u77e5\u4e3b\u673a - UnKnowHostException");
                                }
                            } catch (SocketTimeoutException e6) {
                                this.f10409s.g(a(e6));
                                this.f10409s.b(2);
                                throw new bv("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException");
                            } catch (ConnectTimeoutException e7) {
                                e7.printStackTrace();
                                this.f10409s.g(a(e7));
                                this.f10409s.b(2);
                                throw new bv("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                            }
                        } catch (bv e8) {
                            if (!e8.i() && e8.g() != 10) {
                                this.f10409s.b(e8.f());
                            }
                            throw e8;
                        }
                    } catch (IOException unused3) {
                        this.f10409s.b(7);
                        throw new bv("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                    }
                } catch (MalformedURLException unused4) {
                    this.f10409s.b(8);
                    throw new bv("url\u5f02\u5e38 - MalformedURLException");
                }
            } catch (SocketException e9) {
                this.f10409s.g(a(e9));
                this.f10409s.b(6);
                throw new bv("socket \u8fde\u63a5\u5f02\u5e38 - SocketException");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b3 o(dz dzVar) throws bv {
        DataOutputStream dataOutputStream;
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                s(dzVar);
                b3 o4 = w2.o(this.f10402l, this.f10400j);
                if (o4 != null) {
                    this.f10409s.i();
                    return o4;
                }
                b b4 = b(dzVar, true);
                HttpURLConnection httpURLConnection2 = b4.f10420a;
                try {
                    this.f10409s.f10441b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f10409s.a();
                    byte[] q3 = dzVar.q();
                    if (q3 == null || q3.length == 0) {
                        Map<String, String> o5 = dzVar.o();
                        HashMap<String, String> hashMap = u2.f10279e;
                        if (hashMap != null) {
                            if (o5 != null) {
                                o5.putAll(hashMap);
                            } else {
                                o5 = hashMap;
                            }
                        }
                        String h4 = h(o5);
                        if (!TextUtils.isEmpty(h4)) {
                            q3 = j1.o(h4);
                        }
                    }
                    if (q3 != null && q3.length > 0) {
                        try {
                            this.f10409s.f10441b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                dataOutputStream = new DataOutputStream(outputStream);
                            } catch (Throwable th2) {
                                dataOutputStream = null;
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            dataOutputStream = null;
                            th = th3;
                            outputStream = null;
                        }
                        try {
                            dataOutputStream.write(q3);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f10409s.f();
                        } catch (Throwable th4) {
                            th = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f10409s.f();
                            throw th;
                        }
                    }
                    b3 c4 = c(b4);
                    this.f10409s.e(c4);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        d2.e(th5, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    }
                    this.f10409s.i();
                    return c4;
                } catch (bv e4) {
                    e = e4;
                    if (!e.i() && e.g() != 10) {
                        this.f10409s.b(e.g());
                    }
                    d2.e(e, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    throw e;
                } catch (ConnectException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f10409s.g(a(e));
                    this.f10409s.b(6);
                    throw new bv("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
                } catch (MalformedURLException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f10409s.b(8);
                    throw new bv("url\u5f02\u5e38 - MalformedURLException");
                } catch (SocketException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f10409s.g(a(e));
                    this.f10409s.b(6);
                    throw new bv("socket \u8fde\u63a5\u5f02\u5e38 - SocketException");
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f10409s.g(a(e));
                    this.f10409s.b(2);
                    throw new bv("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException");
                } catch (InterruptedIOException unused) {
                    this.f10409s.g(7101);
                    this.f10409s.b(7);
                    throw new bv("\u672a\u77e5\u7684\u9519\u8bef");
                } catch (UnknownHostException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f10409s.b(5);
                    throw new bv("\u672a\u77e5\u4e3b\u673a - UnKnowHostException");
                } catch (SSLException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f10409s.g(a(e));
                    this.f10409s.b(4);
                    throw new bv("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (ConnectTimeoutException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.f10409s.g(a(e));
                    this.f10409s.b(2);
                    throw new bv("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    this.f10409s.b(7);
                    throw new bv("IO \u64cd\u4f5c\u5f02\u5e38 - IOException");
                } catch (Throwable th6) {
                    th = th6;
                    d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    this.f10409s.b(9);
                    throw new bv("\u672a\u77e5\u7684\u9519\u8bef");
                }
            } catch (bv e13) {
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
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    d2.e(th9, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                }
            }
            this.f10409s.i();
            throw th8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Vector<e> f10436a;

        /* renamed from: b  reason: collision with root package name */
        private volatile e f10437b;

        private d() {
            this.f10436a = new Vector<>();
            this.f10437b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f10437b;
            }
            for (int i4 = 0; i4 < this.f10436a.size(); i4++) {
                e eVar = this.f10436a.get(i4);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e((byte) 0);
            eVar2.c(str);
            this.f10436a.add(eVar2);
            return eVar2;
        }

        /* synthetic */ d(byte b4) {
            this();
        }
    }
}
