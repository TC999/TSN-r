package com.bytedance.sdk.component.w.c;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class r {
    private static final char[] sr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: c  reason: collision with root package name */
    final String f30414c;
    private final List<String> ev;

    /* renamed from: f  reason: collision with root package name */
    private final String f30415f;
    private final String gd;

    /* renamed from: p  reason: collision with root package name */
    private final String f30416p;

    /* renamed from: r  reason: collision with root package name */
    private final List<String> f30417r;
    private final String ux;

    /* renamed from: w  reason: collision with root package name */
    final String f30418w;
    final int xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        String f30419c;
        String ev;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f30420f;

        /* renamed from: r  reason: collision with root package name */
        List<String> f30421r;
        String sr;

        /* renamed from: w  reason: collision with root package name */
        String f30422w = "";
        String xv = "";
        int ux = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.component.w.c.r$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public enum EnumC0457c {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public c() {
            ArrayList arrayList = new ArrayList();
            this.f30420f = arrayList;
            arrayList.add("");
        }

        private boolean f(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private boolean ux(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public c c(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f30419c = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f30419c = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public c query(String str) {
            this.f30421r = str != null ? r.w(r.c(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public c sr(String str) {
            this.f30421r = str != null ? r.w(r.c(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f30419c);
            sb.append("://");
            if (!this.f30422w.isEmpty() || !this.xv.isEmpty()) {
                sb.append(this.f30422w);
                if (!this.xv.isEmpty()) {
                    sb.append(':');
                    sb.append(this.xv);
                }
                sb.append('@');
            }
            if (this.sr.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.sr);
                sb.append(']');
            } else {
                sb.append(this.sr);
            }
            int c4 = c();
            if (c4 != r.c(this.f30419c)) {
                sb.append(':');
                sb.append(c4);
            }
            r.c(sb, this.f30420f);
            if (this.f30421r != null) {
                sb.append('?');
                r.w(sb, this.f30421r);
            }
            if (this.ev != null) {
                sb.append('#');
                sb.append(this.ev);
            }
            return sb.toString();
        }

        public c w(String str) {
            if (str != null) {
                String ux = ux(str, 0, str.length());
                if (ux != null) {
                    this.sr = ux;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public c xv(String str) {
            if (str != null) {
                return c(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        private static String ux(String str, int i4, int i5) {
            return com.bytedance.sdk.component.w.c.w.p.c(r.c(str, i4, i5, false));
        }

        private static int sr(String str, int i4, int i5) {
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

        private void xv() {
            List<String> list = this.f30420f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f30420f.isEmpty()) {
                List<String> list2 = this.f30420f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f30420f.add("");
        }

        private static int f(String str, int i4, int i5) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(r.c(str, i4, i5, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public r w() {
            if (this.f30419c != null) {
                if (this.sr != null) {
                    return new r(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private static int xv(String str, int i4, int i5) {
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

        int c() {
            int i4 = this.ux;
            return i4 != -1 ? i4 : r.c(this.f30419c);
        }

        private c c(String str, boolean z3) {
            int i4 = 0;
            do {
                int c4 = com.bytedance.sdk.component.w.c.w.p.c(str, i4, str.length(), "/\\");
                c(str, i4, c4, c4 < str.length(), z3);
                i4 = c4 + 1;
            } while (i4 <= str.length());
            return this;
        }

        private static int w(String str, int i4, int i5) {
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

        public c c(String str, String str2) {
            if (str != null) {
                if (this.f30421r == null) {
                    this.f30421r = new ArrayList();
                }
                this.f30421r.add(r.c(str, " \"'<>#&=", true, false, true, true));
                this.f30421r.add(str2 != null ? r.c(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        EnumC0457c c(r rVar, String str) {
            int c4;
            int i4;
            int c5 = com.bytedance.sdk.component.w.c.w.p.c(str, 0, str.length());
            int w3 = com.bytedance.sdk.component.w.c.w.p.w(str, c5, str.length());
            if (w(str, c5, w3) != -1) {
                if (str.regionMatches(true, c5, "https:", 0, 6)) {
                    this.f30419c = "https";
                    c5 += 6;
                } else if (str.regionMatches(true, c5, "http:", 0, 5)) {
                    this.f30419c = "http";
                    c5 += 5;
                } else {
                    return EnumC0457c.UNSUPPORTED_SCHEME;
                }
            } else if (rVar != null) {
                this.f30419c = rVar.f30414c;
            } else {
                return EnumC0457c.MISSING_SCHEME;
            }
            int xv = xv(str, c5, w3);
            char c6 = '?';
            char c7 = '#';
            if (xv < 2 && rVar != null && rVar.f30414c.equals(this.f30419c)) {
                this.f30422w = rVar.w();
                this.xv = rVar.xv();
                this.sr = rVar.f30418w;
                this.ux = rVar.xv;
                this.f30420f.clear();
                this.f30420f.addAll(rVar.sr());
                if (c5 == w3 || str.charAt(c5) == '#') {
                    sr(rVar.ux());
                }
            } else {
                int i5 = c5 + xv;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    c4 = com.bytedance.sdk.component.w.c.w.p.c(str, i5, w3, "@/\\?#");
                    char charAt = c4 != w3 ? str.charAt(c4) : '\uffff';
                    if (charAt == '\uffff' || charAt == c7 || charAt == '/' || charAt == '\\' || charAt == c6) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z3) {
                            int c8 = com.bytedance.sdk.component.w.c.w.p.c(str, i5, c4, ':');
                            i4 = c4;
                            String c9 = r.c(str, i5, c8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z4) {
                                c9 = this.f30422w + "%40" + c9;
                            }
                            this.f30422w = c9;
                            if (c8 != i4) {
                                this.xv = r.c(str, c8 + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z3 = true;
                            }
                            z4 = true;
                        } else {
                            i4 = c4;
                            this.xv += "%40" + r.c(str, i5, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i5 = i4 + 1;
                    }
                    c6 = '?';
                    c7 = '#';
                }
                int sr = sr(str, i5, c4);
                int i6 = sr + 1;
                if (i6 < c4) {
                    this.sr = ux(str, i5, sr);
                    int f4 = f(str, i6, c4);
                    this.ux = f4;
                    if (f4 == -1) {
                        return EnumC0457c.INVALID_PORT;
                    }
                } else {
                    this.sr = ux(str, i5, sr);
                    this.ux = r.c(this.f30419c);
                }
                if (this.sr == null) {
                    return EnumC0457c.INVALID_HOST;
                }
                c5 = c4;
            }
            int c10 = com.bytedance.sdk.component.w.c.w.p.c(str, c5, w3, "?#");
            c(str, c5, c10);
            if (c10 < w3 && str.charAt(c10) == '?') {
                int c11 = com.bytedance.sdk.component.w.c.w.p.c(str, c10, w3, '#');
                this.f30421r = r.w(r.c(str, c10 + 1, c11, " \"'<>#", true, false, true, true, null));
                c10 = c11;
            }
            if (c10 < w3 && str.charAt(c10) == '#') {
                this.ev = r.c(str, 1 + c10, w3, "", true, false, false, false, null);
            }
            return EnumC0457c.SUCCESS;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void c(java.lang.String r11, int r12, int r13) {
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
                java.util.List<java.lang.String> r0 = r10.f30420f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f30420f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f30420f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = com.bytedance.sdk.component.w.c.w.p.c(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.c(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.c.r.c.c(java.lang.String, int, int):void");
        }

        private void c(String str, int i4, int i5, boolean z3, boolean z4) {
            String c4 = r.c(str, i4, i5, " \"<>^`{}|/\\?#", z4, false, false, true, null);
            if (ux(c4)) {
                return;
            }
            if (f(c4)) {
                xv();
                return;
            }
            List<String> list = this.f30420f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f30420f;
                list2.set(list2.size() - 1, c4);
            } else {
                this.f30420f.add(c4);
            }
            if (z3) {
                this.f30420f.add("");
            }
        }
    }

    r(c cVar) {
        this.f30414c = cVar.f30419c;
        this.ux = c(cVar.f30422w, false);
        this.f30415f = c(cVar.xv, false);
        this.f30418w = cVar.sr;
        this.xv = cVar.c();
        this.f30417r = c(cVar.f30420f, false);
        List<String> list = cVar.f30421r;
        this.ev = list != null ? c(list, true) : null;
        String str = cVar.ev;
        this.gd = str != null ? c(str, false) : null;
        this.f30416p = cVar.toString();
    }

    public URL c() {
        try {
            return new URL(this.f30416p);
        } catch (MalformedURLException e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && ((r) obj).f30416p.equals(this.f30416p);
    }

    public String f() {
        if (this.gd == null) {
            return null;
        }
        return this.f30416p.substring(this.f30416p.indexOf(35) + 1);
    }

    public int hashCode() {
        return this.f30416p.hashCode();
    }

    public String query() {
        if (this.ev == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        w(sb, this.ev);
        return sb.toString();
    }

    public c r() {
        c cVar = new c();
        cVar.f30419c = this.f30414c;
        cVar.f30422w = w();
        cVar.xv = xv();
        cVar.sr = this.f30418w;
        cVar.ux = this.xv != c(this.f30414c) ? this.xv : -1;
        cVar.f30420f.clear();
        cVar.f30420f.addAll(sr());
        cVar.sr(ux());
        cVar.ev = f();
        return cVar;
    }

    public List<String> sr() {
        int indexOf = this.f30416p.indexOf(47, this.f30414c.length() + 3);
        String str = this.f30416p;
        int c4 = com.bytedance.sdk.component.w.c.w.p.c(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < c4) {
            int i4 = indexOf + 1;
            int c5 = com.bytedance.sdk.component.w.c.w.p.c(this.f30416p, i4, c4, '/');
            arrayList.add(this.f30416p.substring(i4, c5));
            indexOf = c5;
        }
        return arrayList;
    }

    public String toString() {
        return this.f30416p;
    }

    public String ux() {
        if (this.ev == null) {
            return null;
        }
        int indexOf = this.f30416p.indexOf(63) + 1;
        String str = this.f30416p;
        return this.f30416p.substring(indexOf, com.bytedance.sdk.component.w.c.w.p.c(str, indexOf, str.length(), '#'));
    }

    public String w() {
        if (this.ux.isEmpty()) {
            return "";
        }
        int length = this.f30414c.length() + 3;
        String str = this.f30416p;
        return this.f30416p.substring(length, com.bytedance.sdk.component.w.c.w.p.c(str, length, str.length(), ":@"));
    }

    public String xv() {
        if (this.f30415f.isEmpty()) {
            return "";
        }
        int indexOf = this.f30416p.indexOf(64);
        return this.f30416p.substring(this.f30416p.indexOf(58, this.f30414c.length() + 3) + 1, indexOf);
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void c(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append('/');
            sb.append(list.get(i4));
        }
    }

    static void w(StringBuilder sb, List<String> list) {
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

    public static r xv(String str) {
        c cVar = new c();
        if (cVar.c((r) null, str) == c.EnumC0457c.SUCCESS) {
            return cVar.w();
        }
        return null;
    }

    static String c(String str, boolean z3) {
        return c(str, 0, str.length(), z3);
    }

    private List<String> c(List<String> list, boolean z3) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            String str = list.get(i4);
            arrayList.add(str != null ? c(str, z3) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static List<String> w(String str) {
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

    static String c(String str, int i4, int i5, boolean z3) {
        for (int i6 = i4; i6 < i5; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '%' || (charAt == '+' && z3)) {
                com.bytedance.sdk.component.w.c.w.c cVar = new com.bytedance.sdk.component.w.c.w.c();
                cVar.c(str, i4, i6);
                c(cVar, str, i6, i5, z3);
                return cVar.xv();
            }
        }
        return str.substring(i4, i5);
    }

    static void c(com.bytedance.sdk.component.w.c.w.c cVar, String str, int i4, int i5, boolean z3) {
        int i6;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt == 37 && (i6 = i4 + 2) < i5) {
                int c4 = com.bytedance.sdk.component.w.c.w.p.c(str.charAt(i4 + 1));
                int c5 = com.bytedance.sdk.component.w.c.w.p.c(str.charAt(i6));
                if (c4 != -1 && c5 != -1) {
                    cVar.w((c4 << 4) + c5);
                    i4 = i6;
                }
                cVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z3) {
                    cVar.w(32);
                }
                cVar.c(codePointAt);
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    static boolean c(String str, int i4, int i5) {
        int i6 = i4 + 2;
        return i6 < i5 && str.charAt(i4) == '%' && com.bytedance.sdk.component.w.c.w.p.c(str.charAt(i4 + 1)) != -1 && com.bytedance.sdk.component.w.c.w.p.c(str.charAt(i6)) != -1;
    }

    static String c(String str, int i4, int i5, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Charset charset) {
        int i6 = i4;
        while (i6 < i5) {
            int codePointAt = str.codePointAt(i6);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z6)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z3 && (!z4 || c(str, i6, i5)))) && (codePointAt != 43 || !z5))) {
                    i6 += Character.charCount(codePointAt);
                }
            }
            com.bytedance.sdk.component.w.c.w.c cVar = new com.bytedance.sdk.component.w.c.w.c();
            cVar.c(str, i4, i6);
            c(cVar, str, i6, i5, str2, z3, z4, z5, z6, charset);
            return cVar.xv();
        }
        return str.substring(i4, i5);
    }

    static void c(com.bytedance.sdk.component.w.c.w.c cVar, String str, int i4, int i5, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Charset charset) {
        com.bytedance.sdk.component.w.c.w.c cVar2 = null;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (!z3 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z5) {
                    cVar.c(z3 ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z6) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z3 && (!z4 || c(str, i4, i5)))))) {
                    cVar.c(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new com.bytedance.sdk.component.w.c.w.c();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.w.c.w.p.f30443c)) {
                        cVar2.c(str, i4, Character.charCount(codePointAt) + i4, charset);
                    } else {
                        cVar2.c(codePointAt);
                    }
                    while (!cVar2.c()) {
                        int w3 = cVar2.w() & 255;
                        cVar.w(37);
                        char[] cArr = sr;
                        cVar.w((int) cArr[(w3 >> 4) & 15]);
                        cVar.w((int) cArr[w3 & 15]);
                    }
                }
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    static String c(String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return c(str, 0, str.length(), str2, z3, z4, z5, z6, null);
    }
}
