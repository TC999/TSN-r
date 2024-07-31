package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.col.p0463l.BaseNetManager;
import com.amap.api.services.core.AMapException;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.CoreProtocolImpl;
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
import p592g.AMapUtilCoreApi;
import p592g.NetProxy;

/* renamed from: com.amap.api.col.3l.u6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HttpUrlUtil {

    /* renamed from: t */
    private static SoftReference<SSLContext> f5458t;

    /* renamed from: u */
    private static SoftReference<MySSLSocketFactory> f5459u;

    /* renamed from: a */
    private boolean f5460a;

    /* renamed from: b */
    private SSLContext f5461b;

    /* renamed from: c */
    private Proxy f5462c;

    /* renamed from: g */
    private String f5466g;

    /* renamed from: h */
    private BaseNetManager.InterfaceC1926a f5467h;

    /* renamed from: i */
    private C1963d f5468i;

    /* renamed from: k */
    private boolean f5470k;

    /* renamed from: l */
    private String f5471l;

    /* renamed from: m */
    private String f5472m;

    /* renamed from: d */
    private volatile boolean f5463d = false;

    /* renamed from: e */
    private long f5464e = -1;

    /* renamed from: f */
    private long f5465f = 0;

    /* renamed from: j */
    private String f5469j = "";

    /* renamed from: n */
    private boolean f5473n = false;

    /* renamed from: o */
    private boolean f5474o = false;

    /* renamed from: p */
    private String f5475p = "";

    /* renamed from: q */
    private String f5476q = "";

    /* renamed from: r */
    private String f5477r = "";

    /* renamed from: s */
    private C1965f f5478s = new C1965f();

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1960a implements Cloneable, Comparable {

        /* renamed from: a */
        public int f5479a;

        /* renamed from: b */
        public String f5480b;

        /* renamed from: c */
        public String f5481c;

        /* renamed from: d */
        public String f5482d;

        /* renamed from: e */
        public String f5483e;

        /* renamed from: f */
        public int f5484f;

        /* renamed from: g */
        public int f5485g;

        /* renamed from: h */
        public int f5486h;

        /* renamed from: i */
        public long f5487i;

        /* renamed from: j */
        public volatile AtomicInteger f5488j = new AtomicInteger(1);

        public C1960a(C1962c c1962c) {
            this.f5480b = c1962c.f5493c;
            this.f5481c = c1962c.f5495e;
            this.f5483e = c1962c.f5494d;
            this.f5484f = c1962c.f5503m;
            this.f5485g = c1962c.f5504n;
            this.f5486h = c1962c.f5492b.m54697a();
            this.f5482d = c1962c.f5491a;
            this.f5487i = c1962c.f5496f;
            if (this.f5484f == 10) {
                this.f5479a = 0;
            }
        }

        /* renamed from: a */
        public final C1960a clone() {
            try {
                return (C1960a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        /* renamed from: b */
        public final String m53742b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f5484f + "#";
                if (!TextUtils.isEmpty(this.f5483e)) {
                    str = str5 + this.f5483e + "#";
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.f5486h + "#") + this.f5488j + "#";
                if (!TextUtils.isEmpty(this.f5480b)) {
                    str2 = str6 + this.f5480b + "#";
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f5484f == 1) {
                    str3 = str2 + this.f5482d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f5484f == 1) {
                    str4 = str3 + this.f5487i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String m54719f = Encrypt.m54719f(XXTEA.m54576a(((str4 + this.f5481c + "#") + this.f5485g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                HttpUrlUtil.m53751s();
                return m54719f;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f5479a - ((C1960a) obj).f5479a;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1961b {

        /* renamed from: a */
        public HttpURLConnection f5489a;

        /* renamed from: b */
        public int f5490b = this.f5490b;

        /* renamed from: b */
        public int f5490b = this.f5490b;

        public C1961b(HttpURLConnection httpURLConnection) {
            this.f5489a = httpURLConnection;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1962c implements Cloneable {

        /* renamed from: a */
        public String f5491a = "";

        /* renamed from: b */
        public AbstractC1840if.EnumC1842b f5492b = AbstractC1840if.EnumC1842b.FIRST_NONDEGRADE;

        /* renamed from: c */
        public String f5493c = "";

        /* renamed from: d */
        public String f5494d = "";

        /* renamed from: e */
        public String f5495e = "";

        /* renamed from: f */
        public long f5496f = 0;

        /* renamed from: g */
        public long f5497g = 0;

        /* renamed from: h */
        public long f5498h = 0;

        /* renamed from: i */
        public long f5499i = 0;

        /* renamed from: j */
        public long f5500j = 0;

        /* renamed from: k */
        public String f5501k = "-";

        /* renamed from: l */
        public String f5502l = "-";

        /* renamed from: m */
        public int f5503m = 0;

        /* renamed from: n */
        public int f5504n = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final C1962c clone() {
            try {
                return (C1962c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        /* renamed from: b */
        protected final String m53740b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f5493c)) {
                str = "-#";
            } else {
                str = this.f5493c + "#";
            }
            if (!TextUtils.isEmpty(this.f5494d)) {
                str2 = str + this.f5494d + "#";
            } else {
                str2 = str + "-#";
            }
            String m54719f = Encrypt.m54719f(XXTEA.m54576a(((((str2 + this.f5492b.m54697a() + "#") + this.f5498h + "#") + this.f5500j + "#") + this.f5496f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            HttpUrlUtil.m53751s();
            return m54719f;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f5491a + "', degradeType=" + this.f5492b + ", serverIp='" + this.f5493c + "', path='" + this.f5494d + "', hostname='" + this.f5495e + "', totalTime=" + this.f5496f + ", DNSTime=" + this.f5497g + ", connectionTime=" + this.f5498h + ", writeTime=" + this.f5499i + ", readTime=" + this.f5500j + ", serverTime='" + this.f5501k + "', datasize='" + this.f5502l + "', errorcode=" + this.f5503m + ", errorcodeSub=" + this.f5504n + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1964e implements HostnameVerifier {

        /* renamed from: a */
        private String f5507a;

        /* renamed from: b */
        private String f5508b;

        private C1964e() {
        }

        /* renamed from: a */
        public final String m53738a() {
            return this.f5508b;
        }

        /* renamed from: b */
        public final void m53737b(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f5507a) && str.contains(":") && (split = str.split(":")) != null && split.length > 0) {
                this.f5507a = split[0];
            } else {
                this.f5507a = str;
            }
        }

        /* renamed from: c */
        public final void m53736c(String str) {
            this.f5508b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f5507a)) {
                return this.f5507a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f5508b)) {
                return defaultHostnameVerifier.verify(this.f5508b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ C1964e(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C1965f {

        /* renamed from: a */
        long f5509a = 0;

        /* renamed from: b */
        long f5510b = 0;

        /* renamed from: c */
        C1962c f5511c = new C1962c();

        /* renamed from: d */
        C1960a f5512d;

        /* renamed from: e */
        C1962c f5513e;

        /* renamed from: f */
        String f5514f;

        /* renamed from: g */
        URL f5515g;

        C1965f() {
        }

        /* renamed from: a */
        public final void m53735a() {
            this.f5511c.f5498h = SystemClock.elapsedRealtime() - this.f5510b;
        }

        /* renamed from: b */
        public final void m53734b(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            HttpUrlUtil.m53751s();
            try {
                this.f5511c.f5496f = SystemClock.elapsedRealtime() - this.f5509a;
                C1962c c1962c = this.f5511c;
                c1962c.f5503m = i;
                if (c1962c.f5492b.m54693e()) {
                    AuthConfigManager.m55043u(false, this.f5511c.f5495e);
                }
                boolean m53748v = HttpUrlUtil.this.m53748v(this.f5511c.f5495e);
                if (m53748v) {
                    if (HttpUrlUtil.this.f5474o && !TextUtils.isEmpty(HttpUrlUtil.this.f5472m) && this.f5511c.f5492b.m54696b()) {
                        AuthConfigManager.m55076L();
                    }
                    if (this.f5511c.f5492b.m54695c()) {
                        AuthConfigManager.m55043u(this.f5511c.f5492b.m54695c(), this.f5511c.f5495e);
                    }
                    AuthConfigManager.m55078J(this.f5513e);
                    AuthConfigManager.m55044t(false, this.f5512d);
                    AuthConfigManager.m55083E(this.f5511c);
                }
                AuthConfigManager.m55045s(this.f5515g.toString(), this.f5511c.f5492b.m54695c(), true, m53748v);
                this.f5511c.toString();
                HttpUrlUtil.m53751s();
            } catch (Throwable unused) {
            }
        }

        /* renamed from: c */
        public final void m53733c(long j) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f5511c.f5502l = decimalFormat.format(((float) j) / 1024.0f);
        }

        /* renamed from: d */
        public final void m53732d(AbstractC1840if abstractC1840if, URL url) {
            this.f5515g = url;
            this.f5511c.f5494d = url.getPath();
            this.f5511c.f5495e = url.getHost();
            if (!TextUtils.isEmpty(HttpUrlUtil.this.f5472m) && abstractC1840if.getDegradeType().m54696b()) {
                C1962c c1962c = this.f5511c;
                c1962c.f5493c = c1962c.f5495e.replace("[", "").replace("]", "");
                this.f5511c.f5495e = HttpUrlUtil.this.f5472m;
            }
            if (abstractC1840if.getDegradeType().m54696b()) {
                abstractC1840if.setNon_degrade_final_Host(this.f5511c.f5495e);
            }
            if (abstractC1840if.getDegradeType().m54694d()) {
                this.f5514f = abstractC1840if.getNon_degrade_final_Host();
            }
        }

        /* renamed from: e */
        public final void m53731e(ResponseEntity responseEntity) {
            C1962c clone;
            try {
                this.f5511c.f5496f = SystemClock.elapsedRealtime() - this.f5509a;
                if (responseEntity != null) {
                    responseEntity.f5687f = this.f5511c.f5492b.m54695c();
                }
                if (this.f5511c.f5492b.m54696b()) {
                    C1962c c1962c = this.f5511c;
                    if (c1962c.f5496f > 10000) {
                        AuthConfigManager.m55043u(false, c1962c.f5495e);
                    }
                }
                if (this.f5511c.f5492b.m54694d()) {
                    AuthConfigManager.m55043u(false, this.f5514f);
                }
                boolean m53748v = HttpUrlUtil.this.m53748v(this.f5511c.f5495e);
                if (m53748v) {
                    AuthConfigManager.m55078J(this.f5511c);
                    AuthConfigManager.m55044t(true, this.f5512d);
                    C1962c c1962c2 = this.f5511c;
                    if (c1962c2.f5496f > AuthConfigManager.f4115s && (clone = c1962c2.clone()) != null) {
                        clone.f5503m = 1;
                        AuthConfigManager.m55083E(clone);
                        clone.toString();
                        HttpUrlUtil.m53751s();
                    }
                }
                AuthConfigManager.m55045s(this.f5515g.toString(), this.f5511c.f5492b.m54695c(), false, m53748v);
                this.f5511c.toString();
                HttpUrlUtil.m53751s();
            } catch (Throwable unused) {
            }
        }

        /* renamed from: f */
        public final void m53730f() {
            this.f5511c.f5499i = SystemClock.elapsedRealtime() - this.f5510b;
        }

        /* renamed from: g */
        public final void m53729g(int i) {
            this.f5511c.f5504n = i;
        }

        /* renamed from: h */
        public final void m53728h() {
            this.f5511c.f5500j = SystemClock.elapsedRealtime() - this.f5510b;
        }

        /* renamed from: i */
        public final void m53727i() {
            C1962c clone = this.f5511c.clone();
            if (this.f5511c.f5496f > AuthConfigManager.f4115s) {
                clone.f5503m = 1;
            }
            AuthConfigManager.m55049o(clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpUrlUtil() {
        AuthConfigManager.m55073O();
        try {
            this.f5466g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "ic");
        }
    }

    /* renamed from: a */
    private static int m53769a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return CoreProtocolImpl.C13167a.f38403e;
        }
        if (exc instanceof SSLKeyException) {
            return CoreProtocolImpl.C13167a.f38404f;
        }
        if (exc instanceof SSLProtocolException) {
            return CoreProtocolImpl.C13167a.f38405g;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return CoreProtocolImpl.C13167a.f38406h;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        return exc instanceof ConnectTimeoutException ? AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND : exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144 A[Catch: all -> 0x01b2, TryCatch #0 {all -> 0x01b2, blocks: (B:44:0x00cd, B:47:0x00e5, B:49:0x00e8, B:51:0x00ec, B:53:0x00f2, B:57:0x00fb, B:60:0x0107, B:62:0x010a, B:64:0x0110, B:74:0x013e, B:76:0x0144, B:78:0x014e, B:80:0x015f, B:82:0x0187, B:84:0x01a8, B:85:0x01ab, B:65:0x0126, B:67:0x012a, B:69:0x012d, B:71:0x0133, B:72:0x013a), top: B:137:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01da  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0463l.HttpUrlUtil.C1961b m53768b(com.amap.api.col.p0463l.AbstractC1840if r17, boolean r18, boolean r19) throws java.io.IOException, com.amap.api.col.p0463l.AMapCoreException {
        /*
            Method dump skipped, instructions count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.HttpUrlUtil.m53768b(com.amap.api.col.3l.if, boolean, boolean):com.amap.api.col.3l.u6$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x017a A[Catch: all -> 0x01c7, IOException -> 0x01cd, SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, IOException -> 0x01cd, all -> 0x01c7, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:44:0x00a8, B:105:0x017a, B:106:0x01c6), top: B:167:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x022b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8 A[Catch: all -> 0x01c7, IOException -> 0x01cd, SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01fb, ConnectTimeoutException -> 0x0200, IOException -> 0x01cd, all -> 0x01c7, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:44:0x00a8, B:105:0x017a, B:106:0x01c6), top: B:167:0x0009 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0463l.ResponseEntity m53767c(com.amap.api.col.p0463l.HttpUrlUtil.C1961b r17, boolean r18) throws com.amap.api.col.p0463l.AMapCoreException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.HttpUrlUtil.m53767c(com.amap.api.col.3l.u6$b, boolean):com.amap.api.col.3l.x6");
    }

    /* renamed from: e */
    private static String m53765e(String str) {
        URL url;
        int i;
        NetProxy m12743a = AMapUtilCoreApi.m12743a();
        if (m12743a == null) {
            return str;
        }
        URL url2 = null;
        try {
            url = new URL(str);
        } catch (Exception e) {
            e.printStackTrace();
            url = null;
        }
        if (url == null) {
            return str;
        }
        String m12740a = m12743a.m12740a(url.getHost(), url.getPath());
        if (TextUtils.isEmpty(m12740a)) {
            return str;
        }
        String[] split = m12740a.split(":");
        int i2 = 0;
        if (split.length == 2) {
            try {
                i = Integer.parseInt(split[1]);
            } catch (Exception e2) {
                e2.printStackTrace();
                i = 0;
            }
            i2 = i;
            m12740a = split[0];
        }
        try {
            String protocol = url.getProtocol();
            if (i2 == 0) {
                i2 = url.getPort();
            }
            url2 = new URL(protocol, m12740a, i2, url.getFile().toString());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return url2 == null ? str : url2.toString();
    }

    /* renamed from: f */
    private static String m53764f(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = AuthConfigManager.f4103g;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? C1925p4.m54200d(context) : "");
    }

    /* renamed from: g */
    private static String m53763g(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = BaseNetManager.f5080e;
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
        String m53761i = m53761i(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith("?") && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
        } else {
            stringBuffer.append("?");
        }
        if (m53761i != null) {
            stringBuffer.append(m53761i);
        }
        return stringBuffer.toString();
    }

    /* renamed from: h */
    private static String m53762h(HttpURLConnection httpURLConnection) {
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
    /* renamed from: i */
    public static String m53761i(Map<String, String> map) {
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

    /* renamed from: n */
    private void m53756n(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z) {
        C1962c m55068T;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = BaseNetManager.f5079d;
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str2, BaseNetManager.f5079d.get(str2));
            }
        }
        String str3 = "";
        if (z && !this.f5471l.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f5469j) && AuthConfigManager.m55074N(this.f5469j)) {
            this.f5473n = true;
            AuthConfigManager.C1808h m55070R = AuthConfigManager.m55070R(this.f5469j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(m55070R.f4157a));
            httpURLConnection.addRequestProperty("lct-info", m55070R.f4158b);
            httpURLConnection.addRequestProperty(CampaignEx.JSON_KEY_AD_AKS, AuthConfigManager.m55080H(AuthConfigManager.m55058f(this.f5469j)));
            httpURLConnection.addRequestProperty("lct-args", m53764f(AuthConfigManager.m55087A(this.f5469j) != null ? AuthConfigManager.m55087A(this.f5469j).m54396e() : "", this.f5469j));
        }
        httpURLConnection.addRequestProperty("csid", this.f5466g);
        if (m53748v(this.f5478s.f5511c.f5495e)) {
            C1965f c1965f = this.f5478s;
            if (!TextUtils.isEmpty(c1965f.f5511c.f5493c)) {
                str3 = Encrypt.m54719f(XXTEA.m54576a(c1965f.f5511c.f5493c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = c1965f.f5511c.f5493c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (AuthConfigManager.f4122z && (m55068T = AuthConfigManager.m55068T()) != null) {
                httpURLConnection.addRequestProperty("nls", m55068T.m53740b());
                this.f5478s.f5513e = m55068T;
            }
            C1960a m55069S = AuthConfigManager.m55069S();
            if (m55069S != null) {
                httpURLConnection.addRequestProperty("nlf", m55069S.m53742b());
                this.f5478s.f5512d = m55069S;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m53754p(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
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
            long r7 = com.amap.api.col.p0463l.AuthConfigManager.m55063a(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r6.f5469j     // Catch: java.lang.Throwable -> L62
            boolean r7 = com.amap.api.col.p0463l.AuthConfigManager.m55041w(r0, r7)     // Catch: java.lang.Throwable -> L62
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.HttpUrlUtil.m53754p(java.util.Map, boolean):boolean");
    }

    /* renamed from: r */
    private static String m53752r(Map<String, List<String>> map) {
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

    /* renamed from: s */
    public static void m53751s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public boolean m53748v(String str) {
        if (this.f5470k) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f5472m) && (this.f5472m.contains("rest") || this.f5472m.contains("apilocate"))) || m53745y(str);
    }

    /* renamed from: w */
    private MySSLSocketFactory m53747w() {
        try {
            SoftReference<MySSLSocketFactory> softReference = f5459u;
            if (softReference == null || softReference.get() == null) {
                f5459u = new SoftReference<>(new MySSLSocketFactory(AuthConfigManager.f4103g, this.f5461b));
            }
            MySSLSocketFactory mySSLSocketFactory = f5458t != null ? f5459u.get() : null;
            return mySSLSocketFactory == null ? new MySSLSocketFactory(AuthConfigManager.f4103g, this.f5461b) : mySSLSocketFactory;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "gsf");
            return null;
        }
    }

    /* renamed from: y */
    private static boolean m53745y(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* renamed from: z */
    private void m53744z(AbstractC1840if abstractC1840if) throws AMapCoreException {
        this.f5468i = new C1963d((byte) 0);
        this.f5474o = abstractC1840if.isIPV6Request();
        this.f5462c = abstractC1840if.getProxy();
        this.f5467h = abstractC1840if.getUrlConnectionImpl();
        this.f5470k = abstractC1840if.isBinary();
        this.f5469j = abstractC1840if.parseSdkNameFromRequest();
        this.f5460a = HttpsDecisionUtil.m54673a().m54669e(abstractC1840if.isHttps());
        String m54698b = abstractC1840if.getDegradeType().m54696b() ? abstractC1840if.m54698b() : abstractC1840if.m54700a();
        this.f5471l = m54698b;
        String m53765e = m53765e(m54698b);
        this.f5471l = m53765e;
        String m53860a = HttpLimitUtil.m53860a(m53765e, this.f5469j);
        this.f5471l = m53860a;
        "restrictionURLTest: ".concat(String.valueOf(m53860a));
        if (!URIRestrictManager.m53318b().m53317c(m53860a)) {
            this.f5472m = abstractC1840if.getIPDNSName();
            if ("loc".equals(this.f5469j)) {
                String m54700a = abstractC1840if.m54700a();
                String m54698b2 = abstractC1840if.m54698b();
                if (!TextUtils.isEmpty(m54700a)) {
                    try {
                        this.f5476q = new URL(m54700a).getHost();
                    } catch (Exception unused) {
                    }
                }
                if (TextUtils.isEmpty(m54698b2)) {
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(this.f5472m)) {
                        this.f5475p = this.f5472m;
                        return;
                    } else {
                        this.f5475p = new URL(m54698b2).getHost();
                        return;
                    }
                } catch (Exception unused2) {
                    return;
                }
            }
            return;
        }
        "restriction hit: ".concat(String.valueOf(m53860a));
        throw new AMapCoreException("限制访问的接口");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final Map<String, String> m53760j(AbstractC1840if abstractC1840if) throws AMapCoreException {
        String headerFieldKey;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                m53744z(abstractC1840if);
                this.f5471l = m53763g(this.f5471l, abstractC1840if.getParams());
                HttpURLConnection httpURLConnection2 = m53768b(abstractC1840if, false, false).f5489a;
                try {
                    this.f5478s.f5510b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f5478s.m53735a();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode < 400) {
                        HashMap hashMap = new HashMap();
                        for (int i = 0; i < 50 && (headerFieldKey = httpURLConnection2.getHeaderFieldKey(i)) != null; i++) {
                            hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection2.getHeaderField(headerFieldKey));
                        }
                        this.f5478s.m53731e(null);
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable th) {
                            BasicLogHandler.m54177e(th, "hth", "mgr");
                        }
                        this.f5478s.m53727i();
                        return hashMap;
                    }
                    this.f5478s.m53729g(responseCode);
                    this.f5478s.m53734b(10);
                    AMapCoreException aMapCoreException = new AMapCoreException("http读取header失败");
                    aMapCoreException.m55007a(responseCode);
                    throw aMapCoreException;
                } catch (AMapCoreException e) {
                    e = e;
                    this.f5478s.m53734b(e.m54999g());
                    throw e;
                } catch (ConnectException e2) {
                    e = e2;
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(6);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException unused) {
                    this.f5478s.m53734b(8);
                    throw new AMapCoreException("url异常 - MalformedURLException");
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(2);
                    throw new AMapCoreException("socket 连接超时 - SocketTimeoutException");
                } catch (UnknownHostException unused2) {
                    this.f5478s.m53734b(9);
                    throw new AMapCoreException("未知主机 - UnKnowHostException");
                } catch (SSLException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(4);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(2);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                } catch (InterruptedIOException unused3) {
                    this.f5478s.m53729g(7101);
                    this.f5478s.m53734b(7);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (SocketException e6) {
                    e = e6;
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(6);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (IOException unused4) {
                    this.f5478s.m53734b(7);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                } catch (Throwable th2) {
                    th = th2;
                    this.f5478s.m53734b(9);
                    th.printStackTrace();
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (AMapCoreException e7) {
                e = e7;
            } catch (ConnectException e8) {
                e = e8;
            } catch (MalformedURLException unused5) {
            } catch (SocketException e9) {
                e = e9;
            } catch (SocketTimeoutException e10) {
                e = e10;
            } catch (InterruptedIOException unused6) {
            } catch (UnknownHostException unused7) {
            } catch (SSLException e11) {
                e = e11;
            } catch (ConnectTimeoutException e12) {
                e = e12;
            } catch (IOException unused8) {
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th5) {
                    BasicLogHandler.m54177e(th5, "hth", "mgr");
                }
            }
            this.f5478s.m53727i();
            throw th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final void m53759k() {
        this.f5463d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final void m53758l(long j) {
        this.f5465f = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(19:6|7|8|(3:494|495|(15:497|11|12|13|(4:443|444|445|446)(1:15)|16|17|18|(1:20)(1:420)|21|(1:23)|24|(4:26|27|28|(2:30|31))(13:308|309|310|311|(6:318|319|(4:321|322|323|(1:325)(1:332))(1:391)|(2:327|328)(2:330|331)|329|312)|393|333|(1:335)(1:357)|336|(2:349|350)|338|339|(2:341|342))|36|37))|10|11|12|13|(0)(0)|16|17|18|(0)(0)|21|(0)|24|(0)(0)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02ae, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02af, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02b9, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02c2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02c3, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02cd, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02d7, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02e0, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02e1, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02eb, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x02f4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02f5, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02fe, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x02ff, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0308, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0309, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0312, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0313, code lost:
        r5 = r0;
        r8 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x031c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x031d, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0321, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0322, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0327, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0328, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x032d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x032e, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0333, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0334, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0339, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x033a, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x033f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0340, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0345, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0346, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x034b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x034c, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0351, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0352, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0357, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0358, code lost:
        r7 = null;
        r5 = r0;
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0148 A[Catch: all -> 0x00cc, fk -> 0x00cf, IOException -> 0x00d2, InterruptedIOException -> 0x00d5, SocketTimeoutException -> 0x00d8, SocketException -> 0x00db, UnknownHostException -> 0x00de, MalformedURLException -> 0x00e1, ConnectTimeoutException -> 0x00e4, SSLException -> 0x00e7, ConnectException -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #53 {fk -> 0x00cf, ConnectException -> 0x00ea, MalformedURLException -> 0x00e1, SocketException -> 0x00db, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, UnknownHostException -> 0x00de, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, IOException -> 0x00d2, all -> 0x00cc, blocks: (B:38:0x00bc, B:107:0x0148), top: B:599:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0192 A[Catch: all -> 0x02ae, fk -> 0x02b8, IOException -> 0x02c2, InterruptedIOException -> 0x02cc, SocketTimeoutException -> 0x02d6, SocketException -> 0x02e0, UnknownHostException -> 0x02ea, MalformedURLException -> 0x02f4, ConnectTimeoutException -> 0x02fe, SSLException -> 0x0308, ConnectException -> 0x0312, TRY_ENTER, TRY_LEAVE, TryCatch #54 {fk -> 0x02b8, ConnectException -> 0x0312, MalformedURLException -> 0x02f4, SocketException -> 0x02e0, SocketTimeoutException -> 0x02d6, ConnectTimeoutException -> 0x02fe, InterruptedIOException -> 0x02cc, UnknownHostException -> 0x02ea, SSLException -> 0x0308, IOException -> 0x02c2, all -> 0x02ae, blocks: (B:96:0x0130, B:120:0x0192), top: B:597:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0428 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0433 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0550 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:512:0x055b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0466 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:516:0x0471 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:520:0x037f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:524:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0591 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:528:0x059c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:530:0x04a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:532:0x04af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:536:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:538:0x05cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:540:0x04d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:542:0x05da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:547:0x04e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:549:0x03ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:551:0x03f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:557:0x050f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:561:0x051a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:565:0x04fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:567:0x053f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0417 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0455 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:575:0x03a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:577:0x036e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:579:0x05be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0580 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:583:0x04c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:585:0x03db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0493 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:601:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013c  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m53757m(com.amap.api.col.p0463l.AbstractC1840if r20, com.amap.api.col.p0463l.DownloadManager.InterfaceC1941a r21) {
        /*
            Method dump skipped, instructions count: 1556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.HttpUrlUtil.m53757m(com.amap.api.col.3l.if, com.amap.api.col.3l.s6$a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public final ResponseEntity m53753q(AbstractC1840if abstractC1840if) throws AMapCoreException {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    m53744z(abstractC1840if);
                                    String m53763g = m53763g(this.f5471l, abstractC1840if.getParams());
                                    this.f5471l = m53763g;
                                    ResponseEntity m53846o = HttpLimitUtil.m53846o(m53763g, this.f5469j);
                                    if (m53846o != null) {
                                        this.f5478s.m53727i();
                                        return m53846o;
                                    }
                                    C1961b m53768b = m53768b(abstractC1840if, false, true);
                                    HttpURLConnection httpURLConnection = m53768b.f5489a;
                                    this.f5478s.f5510b = SystemClock.elapsedRealtime();
                                    httpURLConnection.connect();
                                    this.f5478s.m53735a();
                                    ResponseEntity m53767c = m53767c(m53768b, abstractC1840if.isIgnoreGZip());
                                    this.f5478s.m53731e(m53767c);
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th) {
                                        BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mgr");
                                    }
                                    this.f5478s.m53727i();
                                    return m53767c;
                                } catch (ConnectTimeoutException e) {
                                    e.printStackTrace();
                                    this.f5478s.m53729g(m53769a(e));
                                    this.f5478s.m53734b(2);
                                    throw new AMapCoreException("IO 操作异常 - IOException");
                                } catch (InterruptedIOException unused) {
                                    this.f5478s.m53729g(7101);
                                    this.f5478s.m53734b(7);
                                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                                }
                            } catch (MalformedURLException unused2) {
                                this.f5478s.m53734b(8);
                                throw new AMapCoreException("url异常 - MalformedURLException");
                            } catch (UnknownHostException unused3) {
                                this.f5478s.m53734b(9);
                                throw new AMapCoreException("未知主机 - UnKnowHostException");
                            }
                        } catch (AMapCoreException e2) {
                            if (!e2.m54997i() && e2.m54999g() != 10) {
                                this.f5478s.m53734b(e2.m55000f());
                            }
                            throw e2;
                        } catch (SSLException e3) {
                            e3.printStackTrace();
                            this.f5478s.m53729g(m53769a(e3));
                            this.f5478s.m53734b(4);
                            throw new AMapCoreException("IO 操作异常 - IOException");
                        }
                    } catch (ConnectException e4) {
                        this.f5478s.m53729g(m53769a(e4));
                        this.f5478s.m53734b(6);
                        throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                    } catch (SocketTimeoutException e5) {
                        this.f5478s.m53729g(m53769a(e5));
                        this.f5478s.m53734b(2);
                        throw new AMapCoreException("socket 连接超时 - SocketTimeoutException");
                    }
                } catch (IOException unused4) {
                    this.f5478s.m53734b(7);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                }
            } catch (SocketException e6) {
                this.f5478s.m53729g(m53769a(e6));
                this.f5478s.m53734b(6);
                throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_SOCKET);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public final void m53750t(long j) {
        this.f5464e = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* renamed from: x */
    public final ResponseEntity m53746x(AbstractC1840if abstractC1840if) throws AMapCoreException {
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = 0;
        dataOutputStream2 = 0;
        try {
            try {
                m53744z(abstractC1840if);
                ResponseEntity m53846o = HttpLimitUtil.m53846o(this.f5471l, this.f5469j);
                if (m53846o != null) {
                    this.f5478s.m53727i();
                    return m53846o;
                }
                C1961b m53768b = m53768b(abstractC1840if, true, true);
                HttpURLConnection httpURLConnection = m53768b.f5489a;
                try {
                    this.f5478s.f5510b = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    this.f5478s.m53735a();
                    byte[] entityBytes = abstractC1840if.getEntityBytes();
                    if (entityBytes == null || entityBytes.length == 0) {
                        Map<String, String> params = abstractC1840if.getParams();
                        HashMap<String, String> hashMap = BaseNetManager.f5080e;
                        if (hashMap != null) {
                            if (params != null) {
                                params.putAll(hashMap);
                            } else {
                                params = hashMap;
                            }
                        }
                        String m53761i = m53761i(params);
                        if (!TextUtils.isEmpty(m53761i)) {
                            entityBytes = C1925p4.m54189o(m53761i);
                        }
                    }
                    if (entityBytes != null && entityBytes.length > 0) {
                        try {
                            this.f5478s.f5510b = SystemClock.elapsedRealtime();
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
                            this.f5478s.m53730f();
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != 0) {
                                dataOutputStream2.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f5478s.m53730f();
                            throw th;
                        }
                    }
                    ResponseEntity m53767c = m53767c(m53768b, abstractC1840if.isIgnoreGZip());
                    this.f5478s.m53731e(m53767c);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        BasicLogHandler.m54177e(th4, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    }
                    this.f5478s.m53727i();
                    return m53767c;
                } catch (AMapCoreException e) {
                    e = e;
                    if (!e.m54997i() && e.m54999g() != 10) {
                        this.f5478s.m53734b(e.m54999g());
                    }
                    BasicLogHandler.m54177e(e, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    throw e;
                } catch (ConnectException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(6);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.f5478s.m53734b(8);
                    throw new AMapCoreException("url异常 - MalformedURLException");
                } catch (SocketException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(6);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(2);
                    throw new AMapCoreException("socket 连接超时 - SocketTimeoutException");
                } catch (ConnectTimeoutException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(2);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                } catch (InterruptedIOException unused) {
                    this.f5478s.m53729g(7101);
                    this.f5478s.m53734b(7);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (UnknownHostException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f5478s.m53734b(5);
                    throw new AMapCoreException("未知主机 - UnKnowHostException");
                } catch (SSLException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f5478s.m53729g(m53769a(e));
                    this.f5478s.m53734b(4);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                } catch (IOException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f5478s.m53734b(7);
                    throw new AMapCoreException("IO 操作异常 - IOException");
                } catch (Throwable th5) {
                    th = th5;
                    BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    this.f5478s.m53734b(9);
                    throw new AMapCoreException(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (AMapCoreException e10) {
                e = e10;
            } catch (InterruptedIOException unused2) {
            } catch (ConnectException e11) {
                e = e11;
            } catch (MalformedURLException e12) {
                e = e12;
            } catch (SocketException e13) {
                e = e13;
            } catch (SocketTimeoutException e14) {
                e = e14;
            } catch (UnknownHostException e15) {
                e = e15;
            } catch (SSLException e16) {
                e = e16;
            } catch (ConnectTimeoutException e17) {
                e = e17;
            } catch (IOException e18) {
                e = e18;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            if (0 != 0) {
                try {
                    dataOutputStream2.disconnect();
                } catch (Throwable th8) {
                    BasicLogHandler.m54177e(th8, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                }
            }
            this.f5478s.m53727i();
            throw th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1963d {

        /* renamed from: a */
        private Vector<C1964e> f5505a;

        /* renamed from: b */
        private volatile C1964e f5506b;

        private C1963d() {
            this.f5505a = new Vector<>();
            this.f5506b = new C1964e((byte) 0);
        }

        /* renamed from: a */
        public final C1964e m53739a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f5506b;
            }
            for (int i = 0; i < this.f5505a.size(); i++) {
                C1964e c1964e = this.f5505a.get(i);
                if (c1964e != null && c1964e.m53738a().equals(str)) {
                    return c1964e;
                }
            }
            C1964e c1964e2 = new C1964e((byte) 0);
            c1964e2.m53736c(str);
            this.f5505a.add(c1964e2);
            return c1964e2;
        }

        /* synthetic */ C1963d(byte b) {
            this();
        }
    }
}
