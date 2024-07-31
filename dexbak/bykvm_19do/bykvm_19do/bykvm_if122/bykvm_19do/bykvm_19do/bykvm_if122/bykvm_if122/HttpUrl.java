package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.slf4j.Marker;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class HttpUrl {

    /* renamed from: i */
    private static final char[] f1359i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f1360a;

    /* renamed from: b */
    private final String f1361b;

    /* renamed from: c */
    private final String f1362c;

    /* renamed from: d */
    final String f1363d;

    /* renamed from: e */
    final int f1364e;

    /* renamed from: f */
    private final List<String> f1365f;

    /* renamed from: g */
    private final String f1366g;

    /* renamed from: h */
    private final String f1367h;

    /* compiled from: HttpUrl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1077a {

        /* renamed from: a */
        String f1368a;

        /* renamed from: d */
        String f1371d;

        /* renamed from: f */
        final List<String> f1373f;

        /* renamed from: g */
        List<String> f1374g;

        /* renamed from: h */
        String f1375h;

        /* renamed from: b */
        String f1369b = "";

        /* renamed from: c */
        String f1370c = "";

        /* renamed from: e */
        int f1372e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HttpUrl.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public enum EnumC1078a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C1077a() {
            ArrayList arrayList = new ArrayList();
            this.f1373f = arrayList;
            arrayList.add("");
        }

        /* renamed from: g */
        private boolean m58277g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: h */
        private boolean m58276h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: a */
        public C1077a m58297a(int i) {
            if (i > 0 && i <= 65535) {
                this.f1372e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        /* renamed from: b */
        int m58290b() {
            int i = this.f1372e;
            return i != -1 ? i : HttpUrl.m58313c(this.f1368a);
        }

        /* renamed from: c */
        public C1077a m58286c(String str) {
            if (str != null) {
                String m58294a = m58294a(str, 0, str.length());
                if (m58294a != null) {
                    this.f1371d = m58294a;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* renamed from: d */
        public C1077a m58283d(String str) {
            if (str != null) {
                this.f1370c = HttpUrl.m58321a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: e */
        public C1077a m58281e(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase(IDataSource.f43971a)) {
                    this.f1368a = IDataSource.f43971a;
                } else if (str.equalsIgnoreCase("https")) {
                    this.f1368a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /* renamed from: f */
        public C1077a m58279f(String str) {
            if (str != null) {
                this.f1369b = HttpUrl.m58321a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1368a);
            sb.append("://");
            if (!this.f1369b.isEmpty() || !this.f1370c.isEmpty()) {
                sb.append(this.f1369b);
                if (!this.f1370c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f1370c);
                }
                sb.append('@');
            }
            if (this.f1371d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f1371d);
                sb.append(']');
            } else {
                sb.append(this.f1371d);
            }
            int m58290b = m58290b();
            if (m58290b != HttpUrl.m58313c(this.f1368a)) {
                sb.append(':');
                sb.append(m58290b);
            }
            HttpUrl.m58315b(sb, this.f1373f);
            if (this.f1374g != null) {
                sb.append('?');
                HttpUrl.m58319a(sb, this.f1374g);
            }
            if (this.f1375h != null) {
                sb.append('#');
                sb.append(this.f1375h);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public C1077a m58289b(String str) {
            this.f1374g = str != null ? HttpUrl.m58309e(HttpUrl.m58321a(str, okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0028 -> B:12:0x002a). Please submit an issue!!! */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m58282d(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f1373f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2a
            L1e:
                java.util.List<java.lang.String> r0 = r10.f1373f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f1373f
                r0.add(r2)
            L28:
                int r12 = r12 + 1
            L2a:
                r6 = r12
                if (r6 >= r13) goto L43
                java.lang.String r12 = "/\\"
                int r12 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c.m58469a(r11, r6, r13, r12)
                if (r12 >= r13) goto L37
                r0 = 1
                goto L38
            L37:
                r0 = 0
            L38:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.m58293a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2a
                goto L28
            L43:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl.C1077a.m58282d(java.lang.String, int, int):void");
        }

        /* renamed from: f */
        private static int m58278f(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: a */
        public C1077a m58295a(String str) {
            if (str != null) {
                return m58291a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        /* renamed from: b */
        private static int m58288b(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.m58323a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        /* renamed from: a */
        private C1077a m58291a(String str, boolean z) {
            int i = 0;
            do {
                int m58469a = C1061c.m58469a(str, i, str.length(), "/\\");
                m58293a(str, i, m58469a, m58469a < str.length(), z);
                i = m58469a + 1;
            } while (i <= str.length());
            return this;
        }

        /* renamed from: c */
        C1077a m58287c() {
            int size = this.f1373f.size();
            for (int i = 0; i < size; i++) {
                this.f1373f.set(i, HttpUrl.m58321a(this.f1373f.get(i), okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.f1374g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f1374g.get(i2);
                    if (str != null) {
                        this.f1374g.set(i2, HttpUrl.m58321a(str, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.f1375h;
            if (str2 != null) {
                this.f1375h = HttpUrl.m58321a(str2, okhttp3.HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        /* renamed from: e */
        private static int m58280e(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: d */
        private void m58284d() {
            List<String> list = this.f1373f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f1373f.isEmpty()) {
                List<String> list2 = this.f1373f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f1373f.add("");
        }

        /* renamed from: a */
        public C1077a m58292a(String str, String str2) {
            if (str != null) {
                if (this.f1374g == null) {
                    this.f1374g = new ArrayList();
                }
                this.f1374g.add(HttpUrl.m58321a(str, okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                this.f1374g.add(str2 != null ? HttpUrl.m58321a(str2, okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        /* renamed from: a */
        public HttpUrl m58298a() {
            if (this.f1368a != null) {
                if (this.f1371d != null) {
                    return new HttpUrl(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* renamed from: c */
        private static int m58285c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: a */
        EnumC1078a m58296a(HttpUrl httpUrl, String str) {
            int m58469a;
            int i;
            int m58454b = C1061c.m58454b(str, 0, str.length());
            int m58451c = C1061c.m58451c(str, m58454b, str.length());
            if (m58280e(str, m58454b, m58451c) != -1) {
                if (str.regionMatches(true, m58454b, "https:", 0, 6)) {
                    this.f1368a = "https";
                    m58454b += 6;
                } else if (str.regionMatches(true, m58454b, "http:", 0, 5)) {
                    this.f1368a = IDataSource.f43971a;
                    m58454b += 5;
                } else {
                    return EnumC1078a.UNSUPPORTED_SCHEME;
                }
            } else if (httpUrl != null) {
                this.f1368a = httpUrl.f1360a;
            } else {
                return EnumC1078a.MISSING_SCHEME;
            }
            int m58278f = m58278f(str, m58454b, m58451c);
            char c = '?';
            char c2 = '#';
            if (m58278f < 2 && httpUrl != null && httpUrl.f1360a.equals(this.f1368a)) {
                this.f1369b = httpUrl.m58308f();
                this.f1370c = httpUrl.m58317b();
                this.f1371d = httpUrl.f1363d;
                this.f1372e = httpUrl.f1364e;
                this.f1373f.clear();
                this.f1373f.addAll(httpUrl.m58312d());
                if (m58454b == m58451c || str.charAt(m58454b) == '#') {
                    m58289b(httpUrl.m58310e());
                }
            } else {
                int i2 = m58454b + m58278f;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    m58469a = C1061c.m58469a(str, i2, m58451c, "@/\\?#");
                    char charAt = m58469a != m58451c ? str.charAt(m58469a) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    } else if (charAt == '@') {
                        if (!z) {
                            int m58470a = C1061c.m58470a(str, i2, m58469a, ':');
                            i = m58469a;
                            String m58323a = HttpUrl.m58323a(str, i2, m58470a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                m58323a = this.f1369b + "%40" + m58323a;
                            }
                            this.f1369b = m58323a;
                            if (m58470a != i) {
                                this.f1370c = HttpUrl.m58323a(str, m58470a + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = m58469a;
                            this.f1370c += "%40" + HttpUrl.m58323a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int m58285c = m58285c(str, i2, m58469a);
                int i3 = m58285c + 1;
                if (i3 < m58469a) {
                    this.f1371d = m58294a(str, i2, m58285c);
                    int m58288b = m58288b(str, i3, m58469a);
                    this.f1372e = m58288b;
                    if (m58288b == -1) {
                        return EnumC1078a.INVALID_PORT;
                    }
                } else {
                    this.f1371d = m58294a(str, i2, m58285c);
                    this.f1372e = HttpUrl.m58313c(this.f1368a);
                }
                if (this.f1371d == null) {
                    return EnumC1078a.INVALID_HOST;
                }
                m58454b = m58469a;
            }
            int m58469a2 = C1061c.m58469a(str, m58454b, m58451c, "?#");
            m58282d(str, m58454b, m58469a2);
            if (m58469a2 < m58451c && str.charAt(m58469a2) == '?') {
                int m58470a2 = C1061c.m58470a(str, m58469a2, m58451c, '#');
                this.f1374g = HttpUrl.m58309e(HttpUrl.m58323a(str, m58469a2 + 1, m58470a2, okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                m58469a2 = m58470a2;
            }
            if (m58469a2 < m58451c && str.charAt(m58469a2) == '#') {
                this.f1375h = HttpUrl.m58323a(str, 1 + m58469a2, m58451c, "", true, false, false, false, null);
            }
            return EnumC1078a.SUCCESS;
        }

        /* renamed from: a */
        private void m58293a(String str, int i, int i2, boolean z, boolean z2) {
            String m58323a = HttpUrl.m58323a(str, i, i2, okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (m58277g(m58323a)) {
                return;
            }
            if (m58276h(m58323a)) {
                m58284d();
                return;
            }
            List<String> list = this.f1373f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f1373f;
                list2.set(list2.size() - 1, m58323a);
            } else {
                this.f1373f.add(m58323a);
            }
            if (z) {
                this.f1373f.add("");
            }
        }

        /* renamed from: a */
        private static String m58294a(String str, int i, int i2) {
            return C1061c.m58472a(HttpUrl.m58322a(str, i, i2, false));
        }
    }

    HttpUrl(C1077a c1077a) {
        this.f1360a = c1077a.f1368a;
        this.f1361b = m58320a(c1077a.f1369b, false);
        this.f1362c = m58320a(c1077a.f1370c, false);
        this.f1363d = c1077a.f1371d;
        this.f1364e = c1077a.m58290b();
        m58318a(c1077a.f1373f, false);
        List<String> list = c1077a.f1374g;
        this.f1365f = list != null ? m58318a(list, true) : null;
        String str = c1077a.f1375h;
        this.f1366g = str != null ? m58320a(str, false) : null;
        this.f1367h = c1077a.toString();
    }

    /* renamed from: a */
    static void m58319a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.f41567c);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: c */
    public static int m58313c(String str) {
        if (str.equals(IDataSource.f43971a)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: b */
    public String m58317b() {
        if (this.f1362c.isEmpty()) {
            return "";
        }
        int indexOf = this.f1367h.indexOf(64);
        return this.f1367h.substring(this.f1367h.indexOf(58, this.f1360a.length() + 3) + 1, indexOf);
    }

    /* renamed from: d */
    public List<String> m58312d() {
        int indexOf = this.f1367h.indexOf(47, this.f1360a.length() + 3);
        String str = this.f1367h;
        int m58469a = C1061c.m58469a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < m58469a) {
            int i = indexOf + 1;
            int m58470a = C1061c.m58470a(this.f1367h, i, m58469a, '/');
            arrayList.add(this.f1367h.substring(i, m58470a));
            indexOf = m58470a;
        }
        return arrayList;
    }

    /* renamed from: e */
    public String m58310e() {
        if (this.f1365f == null) {
            return null;
        }
        int indexOf = this.f1367h.indexOf(63) + 1;
        String str = this.f1367h;
        return this.f1367h.substring(indexOf, C1061c.m58470a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f1367h.equals(this.f1367h);
    }

    /* renamed from: f */
    public String m58308f() {
        if (this.f1361b.isEmpty()) {
            return "";
        }
        int length = this.f1360a.length() + 3;
        String str = this.f1367h;
        return this.f1367h.substring(length, C1061c.m58469a(str, length, str.length(), ":@"));
    }

    /* renamed from: g */
    public String m58307g() {
        return this.f1363d;
    }

    /* renamed from: h */
    public boolean m58306h() {
        return this.f1360a.equals("https");
    }

    public int hashCode() {
        return this.f1367h.hashCode();
    }

    /* renamed from: i */
    public C1077a m58305i() {
        C1077a c1077a = new C1077a();
        c1077a.f1368a = this.f1360a;
        c1077a.f1369b = m58308f();
        c1077a.f1370c = m58317b();
        c1077a.f1371d = this.f1363d;
        c1077a.f1372e = this.f1364e != m58313c(this.f1360a) ? this.f1364e : -1;
        c1077a.f1373f.clear();
        c1077a.f1373f.addAll(m58312d());
        c1077a.m58289b(m58310e());
        c1077a.f1375h = m58328a();
        return c1077a;
    }

    /* renamed from: j */
    public int m58304j() {
        return this.f1364e;
    }

    /* renamed from: k */
    public String m58303k() {
        if (this.f1365f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m58319a(sb, this.f1365f);
        return sb.toString();
    }

    /* renamed from: l */
    public String m58302l() {
        return m58325a("/...").m58279f("").m58283d("").m58298a().toString();
    }

    /* renamed from: m */
    public String m58301m() {
        return this.f1360a;
    }

    /* renamed from: n */
    public URI m58300n() {
        String c1077a = m58305i().m58287c().toString();
        try {
            return new URI(c1077a);
        } catch (URISyntaxException e) {
            try {
                return URI.create(c1077a.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: o */
    public URL m58299o() {
        try {
            return new URL(this.f1367h);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.f1367h;
    }

    /* renamed from: c */
    public String m58314c() {
        int indexOf = this.f1367h.indexOf(47, this.f1360a.length() + 3);
        String str = this.f1367h;
        return this.f1367h.substring(indexOf, C1061c.m58469a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: b */
    static void m58315b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: e */
    static List<String> m58309e(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: d */
    public static HttpUrl m58311d(String str) {
        C1077a c1077a = new C1077a();
        if (c1077a.m58296a((HttpUrl) null, str) == C1077a.EnumC1078a.SUCCESS) {
            return c1077a.m58298a();
        }
        return null;
    }

    /* renamed from: a */
    public String m58328a() {
        if (this.f1366g == null) {
            return null;
        }
        return this.f1367h.substring(this.f1367h.indexOf(35) + 1);
    }

    /* renamed from: b */
    public HttpUrl m58316b(String str) {
        C1077a m58325a = m58325a(str);
        if (m58325a != null) {
            return m58325a.m58298a();
        }
        return null;
    }

    /* renamed from: a */
    public C1077a m58325a(String str) {
        C1077a c1077a = new C1077a();
        if (c1077a.m58296a(this, str) == C1077a.EnumC1078a.SUCCESS) {
            return c1077a;
        }
        return null;
    }

    /* renamed from: a */
    static String m58320a(String str, boolean z) {
        return m58322a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m58318a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m58320a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m58322a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.m58957a(str, i, i3);
                m58326a(buffer, str, i3, i2, z);
                return buffer.m58948e();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m58326a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int m58480a = C1061c.m58480a(str.charAt(i + 1));
                int m58480a2 = C1061c.m58480a(str.charAt(i3));
                if (m58480a != -1 && m58480a2 != -1) {
                    buffer.writeByte((m58480a << 4) + m58480a2);
                    i = i3;
                }
                buffer.m58950c(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.m58950c(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m58324a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && C1061c.m58480a(str.charAt(i + 1)) != -1 && C1061c.m58480a(str.charAt(i3)) != -1;
    }

    /* renamed from: a */
    static String m58323a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m58324a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.m58957a(str, i, i3);
            m58327a(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
            return buffer.m58948e();
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m58327a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.mo58918d(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || m58324a(str, i, i2)))))) {
                    buffer.m58950c(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset != null && !charset.equals(C1061c.f1241i)) {
                        buffer2.m58956a(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        buffer2.m58950c(codePointAt);
                    }
                    while (!buffer2.mo58901x()) {
                        int readByte = buffer2.readByte() & UByte.f41242c;
                        buffer.writeByte(37);
                        char[] cArr = f1359i;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m58321a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m58323a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
