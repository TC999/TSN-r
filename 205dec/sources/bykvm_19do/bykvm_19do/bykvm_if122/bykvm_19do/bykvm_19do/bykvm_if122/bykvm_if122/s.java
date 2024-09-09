package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpUrl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class s {

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f1352i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f1353a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1354b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1355c;

    /* renamed from: d  reason: collision with root package name */
    final String f1356d;

    /* renamed from: e  reason: collision with root package name */
    final int f1357e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f1358f;

    /* renamed from: g  reason: collision with root package name */
    private final String f1359g;

    /* renamed from: h  reason: collision with root package name */
    private final String f1360h;

    /* compiled from: HttpUrl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f1361a;

        /* renamed from: d  reason: collision with root package name */
        String f1364d;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f1366f;

        /* renamed from: g  reason: collision with root package name */
        List<String> f1367g;

        /* renamed from: h  reason: collision with root package name */
        String f1368h;

        /* renamed from: b  reason: collision with root package name */
        String f1362b = "";

        /* renamed from: c  reason: collision with root package name */
        String f1363c = "";

        /* renamed from: e  reason: collision with root package name */
        int f1365e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HttpUrl.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        public enum EnumC0037a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f1366f = arrayList;
            arrayList.add("");
        }

        private boolean g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(int i4) {
            if (i4 > 0 && i4 <= 65535) {
                this.f1365e = i4;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i4);
        }

        int b() {
            int i4 = this.f1365e;
            return i4 != -1 ? i4 : s.c(this.f1361a);
        }

        public a c(String str) {
            if (str != null) {
                String a4 = a(str, 0, str.length());
                if (a4 != null) {
                    this.f1364d = a4;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public a d(String str) {
            if (str != null) {
                this.f1363c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a e(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f1361a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f1361a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a f(String str) {
            if (str != null) {
                this.f1362b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1361a);
            sb.append("://");
            if (!this.f1362b.isEmpty() || !this.f1363c.isEmpty()) {
                sb.append(this.f1362b);
                if (!this.f1363c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f1363c);
                }
                sb.append('@');
            }
            if (this.f1364d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f1364d);
                sb.append(']');
            } else {
                sb.append(this.f1364d);
            }
            int b4 = b();
            if (b4 != s.c(this.f1361a)) {
                sb.append(':');
                sb.append(b4);
            }
            s.b(sb, this.f1366f);
            if (this.f1367g != null) {
                sb.append('?');
                s.a(sb, this.f1367g);
            }
            if (this.f1368h != null) {
                sb.append('#');
                sb.append(this.f1368h);
            }
            return sb.toString();
        }

        public a b(String str) {
            this.f1367g = str != null ? s.e(s.a(str, " \"'<>#", true, false, true, true)) : null;
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void d(java.lang.String r11, int r12, int r13) {
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
                java.util.List<java.lang.String> r0 = r10.f1366f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2a
            L1e:
                java.util.List<java.lang.String> r0 = r10.f1366f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f1366f
                r0.add(r2)
            L28:
                int r12 = r12 + 1
            L2a:
                r6 = r12
                if (r6 >= r13) goto L43
                java.lang.String r12 = "/\\"
                int r12 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(r11, r6, r13, r12)
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
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2a
                goto L28
            L43:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s.a.d(java.lang.String, int, int):void");
        }

        private static int f(String str, int i4, int i5) {
            int i6 = 0;
            while (i4 < i5) {
                char charAt = str.charAt(i4);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i6++;
                i4++;
            }
            return i6;
        }

        public a a(String str) {
            if (str != null) {
                return a(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        private static int b(String str, int i4, int i5) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.a(str, i4, i5, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private a a(String str, boolean z3) {
            int i4 = 0;
            do {
                int a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i4, str.length(), "/\\");
                a(str, i4, a4, a4 < str.length(), z3);
                i4 = a4 + 1;
            } while (i4 <= str.length());
            return this;
        }

        a c() {
            int size = this.f1366f.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f1366f.set(i4, s.a(this.f1366f.get(i4), "[]", true, true, false, true));
            }
            List<String> list = this.f1367g;
            if (list != null) {
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    String str = this.f1367g.get(i5);
                    if (str != null) {
                        this.f1367g.set(i5, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f1368h;
            if (str2 != null) {
                this.f1368h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        private static int e(String str, int i4, int i5) {
            if (i5 - i4 < 2) {
                return -1;
            }
            char charAt = str.charAt(i4);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    char charAt2 = str.charAt(i4);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private void d() {
            List<String> list = this.f1366f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f1366f.isEmpty()) {
                List<String> list2 = this.f1366f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f1366f.add("");
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.f1367g == null) {
                    this.f1367g = new ArrayList();
                }
                this.f1367g.add(s.a(str, " \"'<>#&=", true, false, true, true));
                this.f1367g.add(str2 != null ? s.a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public s a() {
            if (this.f1361a != null) {
                if (this.f1364d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private static int c(String str, int i4, int i5) {
            while (i4 < i5) {
                char charAt = str.charAt(i4);
                if (charAt == ':') {
                    return i4;
                }
                if (charAt == '[') {
                    do {
                        i4++;
                        if (i4 < i5) {
                        }
                    } while (str.charAt(i4) != ']');
                }
                i4++;
            }
            return i5;
        }

        EnumC0037a a(s sVar, String str) {
            int a4;
            int i4;
            int b4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(str, 0, str.length());
            int c4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.c(str, b4, str.length());
            if (e(str, b4, c4) != -1) {
                if (str.regionMatches(true, b4, "https:", 0, 6)) {
                    this.f1361a = "https";
                    b4 += 6;
                } else if (str.regionMatches(true, b4, "http:", 0, 5)) {
                    this.f1361a = "http";
                    b4 += 5;
                } else {
                    return EnumC0037a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.f1361a = sVar.f1353a;
            } else {
                return EnumC0037a.MISSING_SCHEME;
            }
            int f4 = f(str, b4, c4);
            char c5 = '?';
            char c6 = '#';
            if (f4 < 2 && sVar != null && sVar.f1353a.equals(this.f1361a)) {
                this.f1362b = sVar.f();
                this.f1363c = sVar.b();
                this.f1364d = sVar.f1356d;
                this.f1365e = sVar.f1357e;
                this.f1366f.clear();
                this.f1366f.addAll(sVar.d());
                if (b4 == c4 || str.charAt(b4) == '#') {
                    b(sVar.e());
                }
            } else {
                int i5 = b4 + f4;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i5, c4, "@/\\?#");
                    char charAt = a4 != c4 ? str.charAt(a4) : '\uffff';
                    if (charAt == '\uffff' || charAt == c6 || charAt == '/' || charAt == '\\' || charAt == c5) {
                        break;
                    } else if (charAt == '@') {
                        if (!z3) {
                            int a5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, i5, a4, ':');
                            i4 = a4;
                            String a6 = s.a(str, i5, a5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z4) {
                                a6 = this.f1362b + "%40" + a6;
                            }
                            this.f1362b = a6;
                            if (a5 != i4) {
                                this.f1363c = s.a(str, a5 + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z3 = true;
                            }
                            z4 = true;
                        } else {
                            i4 = a4;
                            this.f1363c += "%40" + s.a(str, i5, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i5 = i4 + 1;
                        c5 = '?';
                        c6 = '#';
                    }
                }
                int c7 = c(str, i5, a4);
                int i6 = c7 + 1;
                if (i6 < a4) {
                    this.f1364d = a(str, i5, c7);
                    int b5 = b(str, i6, a4);
                    this.f1365e = b5;
                    if (b5 == -1) {
                        return EnumC0037a.INVALID_PORT;
                    }
                } else {
                    this.f1364d = a(str, i5, c7);
                    this.f1365e = s.c(this.f1361a);
                }
                if (this.f1364d == null) {
                    return EnumC0037a.INVALID_HOST;
                }
                b4 = a4;
            }
            int a7 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, b4, c4, "?#");
            d(str, b4, a7);
            if (a7 < c4 && str.charAt(a7) == '?') {
                int a8 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, a7, c4, '#');
                this.f1367g = s.e(s.a(str, a7 + 1, a8, " \"'<>#", true, false, true, true, null));
                a7 = a8;
            }
            if (a7 < c4 && str.charAt(a7) == '#') {
                this.f1368h = s.a(str, 1 + a7, c4, "", true, false, false, false, null);
            }
            return EnumC0037a.SUCCESS;
        }

        private void a(String str, int i4, int i5, boolean z3, boolean z4) {
            String a4 = s.a(str, i4, i5, " \"<>^`{}|/\\?#", z4, false, false, true, null);
            if (g(a4)) {
                return;
            }
            if (h(a4)) {
                d();
                return;
            }
            List<String> list = this.f1366f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f1366f;
                list2.set(list2.size() - 1, a4);
            } else {
                this.f1366f.add(a4);
            }
            if (z3) {
                this.f1366f.add("");
            }
        }

        private static String a(String str, int i4, int i5) {
            return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(s.a(str, i4, i5, false));
        }
    }

    s(a aVar) {
        this.f1353a = aVar.f1361a;
        this.f1354b = a(aVar.f1362b, false);
        this.f1355c = a(aVar.f1363c, false);
        this.f1356d = aVar.f1364d;
        this.f1357e = aVar.b();
        a(aVar.f1366f, false);
        List<String> list = aVar.f1367g;
        this.f1358f = list != null ? a(list, true) : null;
        String str = aVar.f1368h;
        this.f1359g = str != null ? a(str, false) : null;
        this.f1360h = aVar.toString();
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4 += 2) {
            String str = list.get(i4);
            String str2 = list.get(i4 + 1);
            if (i4 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.f1355c.isEmpty()) {
            return "";
        }
        int indexOf = this.f1360h.indexOf(64);
        return this.f1360h.substring(this.f1360h.indexOf(58, this.f1353a.length() + 3) + 1, indexOf);
    }

    public List<String> d() {
        int indexOf = this.f1360h.indexOf(47, this.f1353a.length() + 3);
        String str = this.f1360h;
        int a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a4) {
            int i4 = indexOf + 1;
            int a5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1360h, i4, a4, '/');
            arrayList.add(this.f1360h.substring(i4, a5));
            indexOf = a5;
        }
        return arrayList;
    }

    public String e() {
        if (this.f1358f == null) {
            return null;
        }
        int indexOf = this.f1360h.indexOf(63) + 1;
        String str = this.f1360h;
        return this.f1360h.substring(indexOf, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).f1360h.equals(this.f1360h);
    }

    public String f() {
        if (this.f1354b.isEmpty()) {
            return "";
        }
        int length = this.f1353a.length() + 3;
        String str = this.f1360h;
        return this.f1360h.substring(length, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f1356d;
    }

    public boolean h() {
        return this.f1353a.equals("https");
    }

    public int hashCode() {
        return this.f1360h.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f1361a = this.f1353a;
        aVar.f1362b = f();
        aVar.f1363c = b();
        aVar.f1364d = this.f1356d;
        aVar.f1365e = this.f1357e != c(this.f1353a) ? this.f1357e : -1;
        aVar.f1366f.clear();
        aVar.f1366f.addAll(d());
        aVar.b(e());
        aVar.f1368h = a();
        return aVar;
    }

    public int j() {
        return this.f1357e;
    }

    public String k() {
        if (this.f1358f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f1358f);
        return sb.toString();
    }

    public String l() {
        return a("/...").f("").d("").a().toString();
    }

    public String m() {
        return this.f1353a;
    }

    public URI n() {
        String aVar = i().c().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e4) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e4);
            }
        }
    }

    public URL o() {
        try {
            return new URL(this.f1360h);
        } catch (MalformedURLException e4) {
            throw new RuntimeException(e4);
        }
    }

    public String toString() {
        return this.f1360h;
    }

    public String c() {
        int indexOf = this.f1360h.indexOf(47, this.f1353a.length() + 3);
        String str = this.f1360h;
        return this.f1360h.substring(indexOf, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, indexOf, str.length(), "?#"));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append('/');
            sb.append(list.get(i4));
        }
    }

    static List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 <= str.length()) {
            int indexOf = str.indexOf(38, i4);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i4);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i4, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i4, indexOf));
                arrayList.add(null);
            }
            i4 = indexOf + 1;
        }
        return arrayList;
    }

    public static s d(String str) {
        a aVar = new a();
        if (aVar.a((s) null, str) == a.EnumC0037a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    public String a() {
        if (this.f1359g == null) {
            return null;
        }
        return this.f1360h.substring(this.f1360h.indexOf(35) + 1);
    }

    public s b(String str) {
        a a4 = a(str);
        if (a4 != null) {
            return a4.a();
        }
        return null;
    }

    public a a(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0037a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    static String a(String str, boolean z3) {
        return a(str, 0, str.length(), z3);
    }

    private List<String> a(List<String> list, boolean z3) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            String str = list.get(i4);
            arrayList.add(str != null ? a(str, z3) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i4, int i5, boolean z3) {
        for (int i6 = i4; i6 < i5; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '%' || (charAt == '+' && z3)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                cVar.a(str, i4, i6);
                a(cVar, str, i6, i5, z3);
                return cVar.e();
            }
        }
        return str.substring(i4, i5);
    }

    static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, String str, int i4, int i5, boolean z3) {
        int i6;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt == 37 && (i6 = i4 + 2) < i5) {
                int a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i4 + 1));
                int a5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i6));
                if (a4 != -1 && a5 != -1) {
                    cVar.writeByte((a4 << 4) + a5);
                    i4 = i6;
                }
                cVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z3) {
                    cVar.writeByte(32);
                }
                cVar.c(codePointAt);
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i4, int i5) {
        int i6 = i4 + 2;
        return i6 < i5 && str.charAt(i4) == '%' && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i4 + 1)) != -1 && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str.charAt(i6)) != -1;
    }

    static String a(String str, int i4, int i5, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Charset charset) {
        int i6 = i4;
        while (i6 < i5) {
            int codePointAt = str.codePointAt(i6);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z6)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z3 && (!z4 || a(str, i6, i5)))) && (codePointAt != 43 || !z5))) {
                    i6 += Character.charCount(codePointAt);
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
            cVar.a(str, i4, i6);
            a(cVar, str, i6, i5, str2, z3, z4, z5, z6, charset);
            return cVar.e();
        }
        return str.substring(i4, i5);
    }

    static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, String str, int i4, int i5, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Charset charset) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar2 = null;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (!z3 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z5) {
                    cVar.d(z3 ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z6) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z3 && (!z4 || a(str, i4, i5)))))) {
                    cVar.c(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                    }
                    if (charset != null && !charset.equals(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1234i)) {
                        cVar2.a(str, i4, Character.charCount(codePointAt) + i4, charset);
                    } else {
                        cVar2.c(codePointAt);
                    }
                    while (!cVar2.x()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        char[] cArr = f1352i;
                        cVar.writeByte((int) cArr[(readByte >> 4) & 15]);
                        cVar.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return a(str, 0, str.length(), str2, z3, z4, z5, z6, null);
    }
}
