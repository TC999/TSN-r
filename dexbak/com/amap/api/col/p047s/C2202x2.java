package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p047s.AbstractC2044dz;
import com.amap.api.col.p047s.C2163u2;
import com.amap.api.col.p047s.C2212y0;
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

/* compiled from: HttpUrlUtil.java */
/* renamed from: com.amap.api.col.s.x2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2202x2 {

    /* renamed from: t */
    private static SoftReference<SSLContext> f6661t;

    /* renamed from: u */
    private static SoftReference<C2224y2> f6662u;

    /* renamed from: a */
    private boolean f6663a;

    /* renamed from: b */
    private SSLContext f6664b;

    /* renamed from: c */
    private Proxy f6665c;

    /* renamed from: g */
    private String f6669g;

    /* renamed from: h */
    private C2163u2.InterfaceC2164a f6670h;

    /* renamed from: i */
    private C2206d f6671i;

    /* renamed from: k */
    private boolean f6673k;

    /* renamed from: l */
    private String f6674l;

    /* renamed from: m */
    private String f6675m;

    /* renamed from: d */
    private volatile boolean f6666d = false;

    /* renamed from: e */
    private long f6667e = -1;

    /* renamed from: f */
    private long f6668f = 0;

    /* renamed from: j */
    private String f6672j = "";

    /* renamed from: n */
    private boolean f6676n = false;

    /* renamed from: o */
    private boolean f6677o = false;

    /* renamed from: p */
    private String f6678p = "";

    /* renamed from: q */
    private String f6679q = "";

    /* renamed from: r */
    private String f6680r = "";

    /* renamed from: s */
    private C2208f f6681s = new C2208f();

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.s.x2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2203a implements Cloneable, Comparable {

        /* renamed from: a */
        public int f6682a;

        /* renamed from: b */
        public String f6683b;

        /* renamed from: c */
        public String f6684c;

        /* renamed from: d */
        public String f6685d;

        /* renamed from: e */
        public String f6686e;

        /* renamed from: f */
        public int f6687f;

        /* renamed from: g */
        public int f6688g;

        /* renamed from: h */
        public int f6689h;

        /* renamed from: i */
        public long f6690i;

        /* renamed from: j */
        public volatile AtomicInteger f6691j = new AtomicInteger(1);

        public C2203a(C2205c c2205c) {
            this.f6683b = c2205c.f6696c;
            this.f6684c = c2205c.f6698e;
            this.f6686e = c2205c.f6697d;
            this.f6687f = c2205c.f6706m;
            this.f6688g = c2205c.f6707n;
            this.f6689h = c2205c.f6695b.m53048a();
            this.f6685d = c2205c.f6694a;
            this.f6690i = c2205c.f6699f;
            if (this.f6687f == 10) {
                this.f6682a = 0;
            }
        }

        /* renamed from: a */
        public final C2203a clone() {
            try {
                return (C2203a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        /* renamed from: b */
        public final String m52293b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f6687f + "#";
                if (!TextUtils.isEmpty(this.f6686e)) {
                    str = str5 + this.f6686e + "#";
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.f6689h + "#") + this.f6691j + "#";
                if (!TextUtils.isEmpty(this.f6683b)) {
                    str2 = str6 + this.f6683b + "#";
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f6687f == 1) {
                    str3 = str2 + this.f6685d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f6687f == 1) {
                    str4 = str3 + this.f6690i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String m53091f = C2040d1.m53091f(C2124q2.m52646a(((str4 + this.f6684c + "#") + this.f6688g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                C2202x2.m52305i();
                return m53091f;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f6682a - ((C2203a) obj).f6682a;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.s.x2$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2204b {

        /* renamed from: a */
        public HttpURLConnection f6692a;

        /* renamed from: b */
        public int f6693b = this.f6693b;

        /* renamed from: b */
        public int f6693b = this.f6693b;

        public C2204b(HttpURLConnection httpURLConnection) {
            this.f6692a = httpURLConnection;
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.s.x2$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2205c implements Cloneable {

        /* renamed from: a */
        public String f6694a = "";

        /* renamed from: b */
        public AbstractC2044dz.EnumC2046b f6695b = AbstractC2044dz.EnumC2046b.FIRST_NONDEGRADE;

        /* renamed from: c */
        public String f6696c = "";

        /* renamed from: d */
        public String f6697d = "";

        /* renamed from: e */
        public String f6698e = "";

        /* renamed from: f */
        public long f6699f = 0;

        /* renamed from: g */
        public long f6700g = 0;

        /* renamed from: h */
        public long f6701h = 0;

        /* renamed from: i */
        public long f6702i = 0;

        /* renamed from: j */
        public long f6703j = 0;

        /* renamed from: k */
        public String f6704k = "-";

        /* renamed from: l */
        public String f6705l = "-";

        /* renamed from: m */
        public int f6706m = 0;

        /* renamed from: n */
        public int f6707n = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final C2205c clone() {
            try {
                return (C2205c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        /* renamed from: b */
        protected final String m52291b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f6696c)) {
                str = "-#";
            } else {
                str = this.f6696c + "#";
            }
            if (!TextUtils.isEmpty(this.f6697d)) {
                str2 = str + this.f6697d + "#";
            } else {
                str2 = str + "-#";
            }
            String m53091f = C2040d1.m53091f(C2124q2.m52646a(((((str2 + this.f6695b.m53048a() + "#") + this.f6701h + "#") + this.f6703j + "#") + this.f6699f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            C2202x2.m52305i();
            return m53091f;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f6694a + "', degradeType=" + this.f6695b + ", serverIp='" + this.f6696c + "', path='" + this.f6697d + "', hostname='" + this.f6698e + "', totalTime=" + this.f6699f + ", DNSTime=" + this.f6700g + ", connectionTime=" + this.f6701h + ", writeTime=" + this.f6702i + ", readTime=" + this.f6703j + ", serverTime='" + this.f6704k + "', datasize='" + this.f6705l + "', errorcode=" + this.f6706m + ", errorcodeSub=" + this.f6707n + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.s.x2$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2207e implements HostnameVerifier {

        /* renamed from: a */
        private String f6710a;

        /* renamed from: b */
        private String f6711b;

        private C2207e() {
        }

        /* renamed from: a */
        public final String m52289a() {
            return this.f6711b;
        }

        /* renamed from: b */
        public final void m52288b(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f6710a) && str.contains(":") && (split = str.split(":")) != null && split.length > 0) {
                this.f6710a = split[0];
            } else {
                this.f6710a = str;
            }
        }

        /* renamed from: c */
        public final void m52287c(String str) {
            this.f6711b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f6710a)) {
                return this.f6710a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f6711b)) {
                return defaultHostnameVerifier.verify(this.f6711b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ C2207e(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.s.x2$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2208f {

        /* renamed from: a */
        long f6712a = 0;

        /* renamed from: b */
        long f6713b = 0;

        /* renamed from: c */
        C2205c f6714c = new C2205c();

        /* renamed from: d */
        C2203a f6715d;

        /* renamed from: e */
        C2205c f6716e;

        /* renamed from: f */
        String f6717f;

        /* renamed from: g */
        URL f6718g;

        C2208f() {
        }

        /* renamed from: a */
        public final void m52286a() {
            this.f6714c.f6701h = SystemClock.elapsedRealtime() - this.f6713b;
        }

        /* renamed from: b */
        public final void m52285b(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            C2202x2.m52305i();
            try {
                this.f6714c.f6699f = SystemClock.elapsedRealtime() - this.f6712a;
                C2205c c2205c = this.f6714c;
                c2205c.f6706m = i;
                if (c2205c.f6695b.m53044e()) {
                    C2212y0.m52214r(false, this.f6714c.f6698e);
                }
                boolean m52302l = C2202x2.this.m52302l(this.f6714c.f6698e);
                if (m52302l) {
                    if (C2202x2.this.f6677o && !TextUtils.isEmpty(C2202x2.this.f6675m) && this.f6714c.f6695b.m53047b()) {
                        C2212y0.m52247F();
                    }
                    if (this.f6714c.f6695b.m53046c()) {
                        C2212y0.m52214r(this.f6714c.f6695b.m53046c(), this.f6714c.f6698e);
                    }
                    C2212y0.m52245H(this.f6716e);
                    C2212y0.m52215q(false, this.f6715d);
                    C2212y0.m52251B(this.f6714c);
                }
                C2212y0.m52216p(this.f6718g.toString(), this.f6714c.f6695b.m53046c(), true, m52302l);
                this.f6714c.toString();
                C2202x2.m52305i();
            } catch (Throwable unused) {
            }
        }

        /* renamed from: c */
        public final void m52284c(long j) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f6714c.f6705l = decimalFormat.format(((float) j) / 1024.0f);
        }

        /* renamed from: d */
        public final void m52283d(AbstractC2044dz abstractC2044dz, URL url) {
            this.f6718g = url;
            this.f6714c.f6697d = url.getPath();
            this.f6714c.f6698e = url.getHost();
            if (!TextUtils.isEmpty(C2202x2.this.f6675m) && abstractC2044dz.m53072B().m53047b()) {
                C2205c c2205c = this.f6714c;
                c2205c.f6696c = c2205c.f6698e.replace("[", "").replace("]", "");
                this.f6714c.f6698e = C2202x2.this.f6675m;
            }
            if (abstractC2044dz.m53072B().m53047b()) {
                abstractC2044dz.m53057n(this.f6714c.f6698e);
            }
            if (abstractC2044dz.m53072B().m53045d()) {
                this.f6717f = abstractC2044dz.m53069E();
            }
        }

        /* renamed from: e */
        public final void m52282e(C2021b3 c2021b3) {
            C2205c clone;
            try {
                this.f6714c.f6699f = SystemClock.elapsedRealtime() - this.f6712a;
                if (c2021b3 != null) {
                    c2021b3.f5898f = this.f6714c.f6695b.m53046c();
                }
                if (this.f6714c.f6695b.m53047b()) {
                    C2205c c2205c = this.f6714c;
                    if (c2205c.f6699f > 10000) {
                        C2212y0.m52214r(false, c2205c.f6698e);
                    }
                }
                if (this.f6714c.f6695b.m53045d()) {
                    C2212y0.m52214r(false, this.f6717f);
                }
                boolean m52302l = C2202x2.this.m52302l(this.f6714c.f6698e);
                if (m52302l) {
                    C2212y0.m52245H(this.f6714c);
                    C2212y0.m52215q(true, this.f6715d);
                    C2205c c2205c2 = this.f6714c;
                    if (c2205c2.f6699f > C2212y0.f6770s && (clone = c2205c2.clone()) != null) {
                        clone.f6706m = 1;
                        C2212y0.m52251B(clone);
                        clone.toString();
                        C2202x2.m52305i();
                    }
                }
                C2212y0.m52216p(this.f6718g.toString(), this.f6714c.f6695b.m53046c(), false, m52302l);
                this.f6714c.toString();
                C2202x2.m52305i();
            } catch (Throwable unused) {
            }
        }

        /* renamed from: f */
        public final void m52281f() {
            this.f6714c.f6702i = SystemClock.elapsedRealtime() - this.f6713b;
        }

        /* renamed from: g */
        public final void m52280g(int i) {
            this.f6714c.f6707n = i;
        }

        /* renamed from: h */
        public final void m52279h() {
            this.f6714c.f6703j = SystemClock.elapsedRealtime() - this.f6713b;
        }

        /* renamed from: i */
        public final void m52278i() {
            C2205c clone = this.f6714c.clone();
            if (this.f6714c.f6699f > C2212y0.f6770s) {
                clone.f6706m = 1;
            }
            C2212y0.m52220l(clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2202x2() {
        C2212y0.m52244I();
        try {
            this.f6669g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "ic");
        }
    }

    /* renamed from: a */
    private static int m52313a(Exception exc) {
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
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p047s.C2202x2.C2204b m52312b(com.amap.api.col.p047s.AbstractC2044dz r15, boolean r16) throws java.io.IOException, com.amap.api.col.p047s.C2022bv {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2202x2.m52312b(com.amap.api.col.s.dz, boolean):com.amap.api.col.s.x2$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x016d A[Catch: all -> 0x01ba, IOException -> 0x01bf, SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, IOException -> 0x01bf, all -> 0x01ba, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:44:0x00a4, B:104:0x016d, B:105:0x01b9), top: B:160:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[Catch: all -> 0x01ba, IOException -> 0x01bf, SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01ed, ConnectTimeoutException -> 0x01f2, IOException -> 0x01bf, all -> 0x01ba, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:44:0x00a4, B:104:0x016d, B:105:0x01b9), top: B:160:0x0007 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p047s.C2021b3 m52311c(com.amap.api.col.p047s.C2202x2.C2204b r15) throws com.amap.api.col.p047s.C2022bv, java.io.IOException {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2202x2.m52311c(com.amap.api.col.s.x2$b):com.amap.api.col.s.b3");
    }

    /* renamed from: f */
    private static String m52308f(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = C2212y0.f6758g;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? C2079j1.m52873d(context) : "");
    }

    /* renamed from: g */
    private static String m52307g(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = C2163u2.f6551e;
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
        String m52306h = m52306h(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf >= 0) {
            if (!str.endsWith("?") && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
        } else {
            stringBuffer.append("?");
        }
        if (m52306h != null) {
            stringBuffer.append(m52306h);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static String m52306h(Map<String, String> map) {
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

    /* renamed from: i */
    public static void m52305i() {
    }

    /* renamed from: j */
    private void m52304j(Map<String, String> map, HttpURLConnection httpURLConnection) {
        C2205c m52237P;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = C2163u2.f6550d;
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str2, C2163u2.f6550d.get(str2));
            }
        }
        String str3 = "";
        if (!this.f6674l.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f6672j) && C2212y0.m52242K(this.f6672j)) {
            this.f6676n = true;
            C2212y0.C2222h m52238O = C2212y0.m52238O(this.f6672j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(m52238O.f6812a));
            httpURLConnection.addRequestProperty("lct-info", m52238O.f6813b);
            httpURLConnection.addRequestProperty(CampaignEx.JSON_KEY_AD_AKS, C2212y0.m52248E(C2212y0.m52228d(this.f6672j)));
            httpURLConnection.addRequestProperty("lct-args", m52308f(C2212y0.m52208x(this.f6672j) != null ? C2212y0.m52208x(this.f6672j).m52917e() : "", this.f6672j));
        }
        httpURLConnection.addRequestProperty("csid", this.f6669g);
        if (m52302l(this.f6681s.f6714c.f6698e)) {
            C2208f c2208f = this.f6681s;
            if (!TextUtils.isEmpty(c2208f.f6714c.f6696c)) {
                str3 = C2040d1.m53091f(C2124q2.m52646a(c2208f.f6714c.f6696c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = c2208f.f6714c.f6696c;
            }
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (C2212y0.f6777z && (m52237P = C2212y0.m52237P()) != null) {
                httpURLConnection.addRequestProperty("nls", m52237P.m52291b());
                this.f6681s.f6716e = m52237P;
            }
            C2203a m52241L = C2212y0.m52241L();
            if (m52241L != null) {
                httpURLConnection.addRequestProperty("nlf", m52241L.m52293b());
                this.f6681s.f6715d = m52241L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m52302l(String str) {
        if (this.f6673k) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f6675m) && (this.f6675m.contains("rest") || this.f6675m.contains("apilocate"))) || m52296r(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m52301m(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
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
            long r7 = com.amap.api.col.p047s.C2212y0.m52231a(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r6.f6672j     // Catch: java.lang.Throwable -> L62
            boolean r7 = com.amap.api.col.p047s.C2212y0.m52212t(r0, r7)     // Catch: java.lang.Throwable -> L62
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2202x2.m52301m(java.util.Map, boolean):boolean");
    }

    /* renamed from: n */
    private C2224y2 m52300n() {
        try {
            SoftReference<C2224y2> softReference = f6662u;
            if (softReference == null || softReference.get() == null) {
                f6662u = new SoftReference<>(new C2224y2(C2212y0.f6758g, this.f6664b));
            }
            C2224y2 c2224y2 = f6661t != null ? f6662u.get() : null;
            return c2224y2 == null ? new C2224y2(C2212y0.f6758g, this.f6664b) : c2224y2;
        } catch (Throwable th) {
            C2060g2.m52972o(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "gsf");
            return null;
        }
    }

    /* renamed from: p */
    private static String m52298p(Map<String, List<String>> map) {
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

    /* renamed from: r */
    private static boolean m52296r(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* renamed from: s */
    private void m52295s(AbstractC2044dz abstractC2044dz) throws C2022bv {
        this.f6671i = new C2206d((byte) 0);
        this.f6677o = abstractC2044dz.m53068F();
        this.f6665c = abstractC2044dz.m53053v();
        this.f6670h = abstractC2044dz.m53073A();
        this.f6673k = abstractC2044dz.m53051x();
        this.f6672j = abstractC2044dz.m53067G();
        this.f6663a = C2048e1.m53039a().m53031i(abstractC2044dz.m53049z());
        String m53055t = abstractC2044dz.m53072B().m53047b() ? abstractC2044dz.m53055t() : abstractC2044dz.m53056s();
        this.f6674l = m53055t;
        this.f6674l = C2193w2.m52360a(m53055t, this.f6672j);
        this.f6675m = abstractC2044dz.mo52198r();
        if ("loc".equals(this.f6672j)) {
            String m53056s = abstractC2044dz.m53056s();
            String m53055t2 = abstractC2044dz.m53055t();
            if (!TextUtils.isEmpty(m53056s)) {
                try {
                    this.f6679q = new URL(m53056s).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(m53055t2)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.f6675m)) {
                    this.f6678p = this.f6675m;
                } else {
                    this.f6678p = new URL(m53055t2).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final C2021b3 m52310d(AbstractC2044dz abstractC2044dz) throws C2022bv {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        m52295s(abstractC2044dz);
                                        String m52307g = m52307g(this.f6674l, abstractC2044dz.mo52383o());
                                        this.f6674l = m52307g;
                                        C2021b3 m52346o = C2193w2.m52346o(m52307g, this.f6672j);
                                        if (m52346o != null) {
                                            this.f6681s.m52278i();
                                            return m52346o;
                                        }
                                        C2204b m52312b = m52312b(abstractC2044dz, false);
                                        HttpURLConnection httpURLConnection = m52312b.f6692a;
                                        this.f6681s.f6713b = SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.f6681s.m52286a();
                                        C2021b3 m52311c = m52311c(m52312b);
                                        this.f6681s.m52282e(m52311c);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th) {
                                            C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mgr");
                                        }
                                        this.f6681s.m52278i();
                                        return m52311c;
                                    } catch (InterruptedIOException unused) {
                                        this.f6681s.m52280g(7101);
                                        this.f6681s.m52285b(7);
                                        throw new C2022bv(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                                    } catch (SSLException e) {
                                        e.printStackTrace();
                                        this.f6681s.m52280g(m52313a(e));
                                        this.f6681s.m52285b(4);
                                        throw new C2022bv("IO 操作异常 - IOException");
                                    }
                                } catch (ConnectException e2) {
                                    this.f6681s.m52280g(m52313a(e2));
                                    this.f6681s.m52285b(6);
                                    throw new C2022bv(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                                } catch (UnknownHostException unused2) {
                                    this.f6681s.m52285b(9);
                                    throw new C2022bv("未知主机 - UnKnowHostException");
                                }
                            } catch (SocketTimeoutException e3) {
                                this.f6681s.m52280g(m52313a(e3));
                                this.f6681s.m52285b(2);
                                throw new C2022bv("socket 连接超时 - SocketTimeoutException");
                            } catch (ConnectTimeoutException e4) {
                                e4.printStackTrace();
                                this.f6681s.m52280g(m52313a(e4));
                                this.f6681s.m52285b(2);
                                throw new C2022bv("IO 操作异常 - IOException");
                            }
                        } catch (C2022bv e5) {
                            if (!e5.m53207i() && e5.m53209g() != 10) {
                                this.f6681s.m52285b(e5.m53210f());
                            }
                            throw e5;
                        }
                    } catch (IOException unused3) {
                        this.f6681s.m52285b(7);
                        throw new C2022bv("IO 操作异常 - IOException");
                    }
                } catch (MalformedURLException unused4) {
                    this.f6681s.m52285b(8);
                    throw new C2022bv("url异常 - MalformedURLException");
                }
            } catch (SocketException e6) {
                this.f6681s.m52280g(m52313a(e6));
                this.f6681s.m52285b(6);
                throw new C2022bv(com.amap.api.maps.AMapException.ERROR_SOCKET);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final C2021b3 m52299o(AbstractC2044dz abstractC2044dz) throws C2022bv {
        DataOutputStream dataOutputStream;
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                m52295s(abstractC2044dz);
                C2021b3 m52346o = C2193w2.m52346o(this.f6674l, this.f6672j);
                if (m52346o != null) {
                    this.f6681s.m52278i();
                    return m52346o;
                }
                C2204b m52312b = m52312b(abstractC2044dz, true);
                HttpURLConnection httpURLConnection2 = m52312b.f6692a;
                try {
                    this.f6681s.f6713b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f6681s.m52286a();
                    byte[] mo52382q = abstractC2044dz.mo52382q();
                    if (mo52382q == null || mo52382q.length == 0) {
                        Map<String, String> mo52383o = abstractC2044dz.mo52383o();
                        HashMap<String, String> hashMap = C2163u2.f6551e;
                        if (hashMap != null) {
                            if (mo52383o != null) {
                                mo52383o.putAll(hashMap);
                            } else {
                                mo52383o = hashMap;
                            }
                        }
                        String m52306h = m52306h(mo52383o);
                        if (!TextUtils.isEmpty(m52306h)) {
                            mo52382q = C2079j1.m52862o(m52306h);
                        }
                    }
                    if (mo52382q != null && mo52382q.length > 0) {
                        try {
                            this.f6681s.f6713b = SystemClock.elapsedRealtime();
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
                            dataOutputStream.write(mo52382q);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f6681s.m52281f();
                        } catch (Throwable th4) {
                            th = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.f6681s.m52281f();
                            throw th;
                        }
                    }
                    C2021b3 m52311c = m52311c(m52312b);
                    this.f6681s.m52282e(m52311c);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        C2041d2.m53085e(th5, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    }
                    this.f6681s.m52278i();
                    return m52311c;
                } catch (C2022bv e) {
                    e = e;
                    if (!e.m53207i() && e.m53209g() != 10) {
                        this.f6681s.m52285b(e.m53209g());
                    }
                    C2041d2.m53085e(e, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    throw e;
                } catch (ConnectException e2) {
                    e = e2;
                    e.printStackTrace();
                    this.f6681s.m52280g(m52313a(e));
                    this.f6681s.m52285b(6);
                    throw new C2022bv(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.f6681s.m52285b(8);
                    throw new C2022bv("url异常 - MalformedURLException");
                } catch (SocketException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.f6681s.m52280g(m52313a(e));
                    this.f6681s.m52285b(6);
                    throw new C2022bv(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f6681s.m52280g(m52313a(e));
                    this.f6681s.m52285b(2);
                    throw new C2022bv("socket 连接超时 - SocketTimeoutException");
                } catch (InterruptedIOException unused) {
                    this.f6681s.m52280g(7101);
                    this.f6681s.m52285b(7);
                    throw new C2022bv(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (UnknownHostException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f6681s.m52285b(5);
                    throw new C2022bv("未知主机 - UnKnowHostException");
                } catch (SSLException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f6681s.m52280g(m52313a(e));
                    this.f6681s.m52285b(4);
                    throw new C2022bv("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f6681s.m52280g(m52313a(e));
                    this.f6681s.m52285b(2);
                    throw new C2022bv("IO 操作异常 - IOException");
                } catch (IOException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f6681s.m52285b(7);
                    throw new C2022bv("IO 操作异常 - IOException");
                } catch (Throwable th6) {
                    th = th6;
                    C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                    this.f6681s.m52285b(9);
                    throw new C2022bv(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (C2022bv e10) {
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
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    C2041d2.m53085e(th9, DownloadCommon.DOWNLOAD_REPORT_HOST, "mPt");
                }
            }
            this.f6681s.m52278i();
            throw th8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.s.x2$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2206d {

        /* renamed from: a */
        private Vector<C2207e> f6708a;

        /* renamed from: b */
        private volatile C2207e f6709b;

        private C2206d() {
            this.f6708a = new Vector<>();
            this.f6709b = new C2207e((byte) 0);
        }

        /* renamed from: a */
        public final C2207e m52290a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f6709b;
            }
            for (int i = 0; i < this.f6708a.size(); i++) {
                C2207e c2207e = this.f6708a.get(i);
                if (c2207e != null && c2207e.m52289a().equals(str)) {
                    return c2207e;
                }
            }
            C2207e c2207e2 = new C2207e((byte) 0);
            c2207e2.m52287c(str);
            this.f6708a.add(c2207e2);
            return c2207e2;
        }

        /* synthetic */ C2206d(byte b) {
            this();
        }
    }
}
