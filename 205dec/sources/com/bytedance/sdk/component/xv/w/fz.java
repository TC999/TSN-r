package com.bytedance.sdk.component.xv.w;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class fz {
    private static final char[] sr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: c  reason: collision with root package name */
    final String f31001c;
    private final List<String> ev;

    /* renamed from: f  reason: collision with root package name */
    private final String f31002f;
    private final String gd;

    /* renamed from: p  reason: collision with root package name */
    private final String f31003p;

    /* renamed from: r  reason: collision with root package name */
    private final List<String> f31004r;
    private final String ux;

    /* renamed from: w  reason: collision with root package name */
    final String f31005w;
    final int xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        String f31006c;
        String ev;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f31007f;

        /* renamed from: r  reason: collision with root package name */
        List<String> f31008r;
        String sr;

        /* renamed from: w  reason: collision with root package name */
        String f31009w = "";
        String xv = "";
        int ux = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.component.xv.w.fz$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public enum EnumC0463c {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public c() {
            ArrayList arrayList = new ArrayList();
            this.f31007f = arrayList;
            arrayList.add("");
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean r(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public c c(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f31006c = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f31006c = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public c query(String str) {
            this.f31008r = str != null ? fz.w(fz.c(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public c sr(String str) {
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

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f31006c);
            sb.append("://");
            if (!this.f31009w.isEmpty() || !this.xv.isEmpty()) {
                sb.append(this.f31009w);
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
            if (c4 != fz.c(this.f31006c)) {
                sb.append(':');
                sb.append(c4);
            }
            fz.c(sb, this.f31007f);
            if (this.f31008r != null) {
                sb.append('?');
                fz.w(sb, this.f31008r);
            }
            if (this.ev != null) {
                sb.append('#');
                sb.append(this.ev);
            }
            return sb.toString();
        }

        public c ux(String str) {
            this.f31008r = str != null ? fz.w(fz.c(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public c w(String str) {
            if (str != null) {
                this.f31009w = fz.c(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public c xv(String str) {
            if (str != null) {
                this.xv = fz.c(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        private static int f(String str, int i4, int i5) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(fz.c(str, i4, i5, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private static String ux(String str, int i4, int i5) {
            return com.bytedance.sdk.component.xv.w.c.xv.c(fz.c(str, i4, i5, false));
        }

        c w() {
            int size = this.f31007f.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f31007f.set(i4, fz.c(this.f31007f.get(i4), "[]", true, true, false, true));
            }
            List<String> list = this.f31008r;
            if (list != null) {
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    String str = this.f31008r.get(i5);
                    if (str != null) {
                        this.f31008r.set(i5, fz.c(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.ev;
            if (str2 != null) {
                this.ev = fz.c(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public fz xv() {
            if (this.f31006c != null) {
                if (this.sr != null) {
                    return new fz(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void sr() {
            List<String> list = this.f31007f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f31007f.isEmpty()) {
                List<String> list2 = this.f31007f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f31007f.add("");
        }

        public c c(int i4) {
            if (i4 > 0 && i4 <= 65535) {
                this.ux = i4;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i4);
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

        int c() {
            int i4 = this.ux;
            return i4 != -1 ? i4 : fz.c(this.f31006c);
        }

        EnumC0463c c(fz fzVar, String str) {
            int c4;
            int i4;
            int c5 = com.bytedance.sdk.component.xv.w.c.xv.c(str, 0, str.length());
            int w3 = com.bytedance.sdk.component.xv.w.c.xv.w(str, c5, str.length());
            if (w(str, c5, w3) != -1) {
                if (str.regionMatches(true, c5, "https:", 0, 6)) {
                    this.f31006c = "https";
                    c5 += 6;
                } else if (str.regionMatches(true, c5, "http:", 0, 5)) {
                    this.f31006c = "http";
                    c5 += 5;
                } else {
                    return EnumC0463c.UNSUPPORTED_SCHEME;
                }
            } else if (fzVar != null) {
                this.f31006c = fzVar.f31001c;
            } else {
                return EnumC0463c.MISSING_SCHEME;
            }
            int xv = xv(str, c5, w3);
            char c6 = '?';
            char c7 = '#';
            if (xv < 2 && fzVar != null && fzVar.f31001c.equals(this.f31006c)) {
                this.f31009w = fzVar.ux();
                this.xv = fzVar.f();
                this.sr = fzVar.f31005w;
                this.ux = fzVar.xv;
                this.f31007f.clear();
                this.f31007f.addAll(fzVar.p());
                if (c5 == w3 || str.charAt(c5) == '#') {
                    ux(fzVar.k());
                }
            } else {
                int i5 = c5 + xv;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    c4 = com.bytedance.sdk.component.xv.w.c.xv.c(str, i5, w3, "@/\\?#");
                    char charAt = c4 != w3 ? str.charAt(c4) : '\uffff';
                    if (charAt == '\uffff' || charAt == c7 || charAt == '/' || charAt == '\\' || charAt == c6) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z3) {
                            int c8 = com.bytedance.sdk.component.xv.w.c.xv.c(str, i5, c4, ':');
                            i4 = c4;
                            String c9 = fz.c(str, i5, c8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z4) {
                                c9 = this.f31009w + "%40" + c9;
                            }
                            this.f31009w = c9;
                            if (c8 != i4) {
                                this.xv = fz.c(str, c8 + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z3 = true;
                            }
                            z4 = true;
                        } else {
                            i4 = c4;
                            this.xv += "%40" + fz.c(str, i5, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
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
                        return EnumC0463c.INVALID_PORT;
                    }
                } else {
                    this.sr = ux(str, i5, sr);
                    this.ux = fz.c(this.f31006c);
                }
                if (this.sr == null) {
                    return EnumC0463c.INVALID_HOST;
                }
                c5 = c4;
            }
            int c10 = com.bytedance.sdk.component.xv.w.c.xv.c(str, c5, w3, "?#");
            c(str, c5, c10);
            if (c10 < w3 && str.charAt(c10) == '?') {
                int c11 = com.bytedance.sdk.component.xv.w.c.xv.c(str, c10, w3, '#');
                this.f31008r = fz.w(fz.c(str, c10 + 1, c11, " \"'<>#", true, false, true, true, null));
                c10 = c11;
            }
            if (c10 < w3 && str.charAt(c10) == '#') {
                this.ev = fz.c(str, 1 + c10, w3, "", true, false, false, false, null);
            }
            return EnumC0463c.SUCCESS;
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
                java.util.List<java.lang.String> r0 = r10.f31007f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f31007f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f31007f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = com.bytedance.sdk.component.xv.w.c.xv.c(r11, r6, r13, r12)
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.fz.c.c(java.lang.String, int, int):void");
        }

        private void c(String str, int i4, int i5, boolean z3, boolean z4) {
            String c4 = fz.c(str, i4, i5, " \"<>^`{}|/\\?#", z4, false, false, true, null);
            if (f(c4)) {
                return;
            }
            if (r(c4)) {
                sr();
                return;
            }
            List<String> list = this.f31007f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f31007f;
                list2.set(list2.size() - 1, c4);
            } else {
                this.f31007f.add(c4);
            }
            if (z3) {
                this.f31007f.add("");
            }
        }
    }

    fz(c cVar) {
        this.f31001c = cVar.f31006c;
        this.ux = c(cVar.f31009w, false);
        this.f31002f = c(cVar.xv, false);
        this.f31005w = cVar.sr;
        this.xv = cVar.c();
        this.f31004r = c(cVar.f31007f, false);
        List<String> list = cVar.f31008r;
        this.ev = list != null ? c(list, true) : null;
        String str = cVar.ev;
        this.gd = str != null ? c(str, false) : null;
        this.f31003p = cVar.toString();
    }

    public String a() {
        if (this.gd == null) {
            return null;
        }
        return this.f31003p.substring(this.f31003p.indexOf(35) + 1);
    }

    public String bk() {
        return sr("/...").w("").xv("").xv().toString();
    }

    public URL c() {
        try {
            return new URL(this.f31003p);
        } catch (MalformedURLException e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof fz) && ((fz) obj).f31003p.equals(this.f31003p);
    }

    public int ev() {
        return this.xv;
    }

    public String f() {
        if (this.f31002f.isEmpty()) {
            return "";
        }
        int indexOf = this.f31003p.indexOf(64);
        return this.f31003p.substring(this.f31003p.indexOf(58, this.f31001c.length() + 3) + 1, indexOf);
    }

    public String gd() {
        int indexOf = this.f31003p.indexOf(47, this.f31001c.length() + 3);
        String str = this.f31003p;
        return this.f31003p.substring(indexOf, com.bytedance.sdk.component.xv.w.c.xv.c(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f31003p.hashCode();
    }

    public String k() {
        if (this.ev == null) {
            return null;
        }
        int indexOf = this.f31003p.indexOf(63) + 1;
        String str = this.f31003p;
        return this.f31003p.substring(indexOf, com.bytedance.sdk.component.xv.w.c.xv.c(str, indexOf, str.length(), '#'));
    }

    public List<String> p() {
        int indexOf = this.f31003p.indexOf(47, this.f31001c.length() + 3);
        String str = this.f31003p;
        int c4 = com.bytedance.sdk.component.xv.w.c.xv.c(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < c4) {
            int i4 = indexOf + 1;
            int c5 = com.bytedance.sdk.component.xv.w.c.xv.c(this.f31003p, i4, c4, '/');
            arrayList.add(this.f31003p.substring(i4, c5));
            indexOf = c5;
        }
        return arrayList;
    }

    public String query() {
        if (this.ev == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        w(sb, this.ev);
        return sb.toString();
    }

    public String r() {
        return this.f31005w;
    }

    public boolean sr() {
        return this.f31001c.equals("https");
    }

    public c t() {
        c cVar = new c();
        cVar.f31006c = this.f31001c;
        cVar.f31009w = ux();
        cVar.xv = f();
        cVar.sr = this.f31005w;
        cVar.ux = this.xv != c(this.f31001c) ? this.xv : -1;
        cVar.f31007f.clear();
        cVar.f31007f.addAll(p());
        cVar.ux(k());
        cVar.ev = a();
        return cVar;
    }

    public String toString() {
        return this.f31003p;
    }

    public String ux() {
        if (this.ux.isEmpty()) {
            return "";
        }
        int length = this.f31001c.length() + 3;
        String str = this.f31003p;
        return this.f31003p.substring(length, com.bytedance.sdk.component.xv.w.c.xv.c(str, length, str.length(), ":@"));
    }

    public URI w() {
        String cVar = t().w().toString();
        try {
            return new URI(cVar);
        } catch (URISyntaxException e4) {
            try {
                return URI.create(cVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e4);
            }
        }
    }

    public String xv() {
        return this.f31001c;
    }

    public c sr(String str) {
        c cVar = new c();
        if (cVar.c(this, str) == c.EnumC0463c.SUCCESS) {
            return cVar;
        }
        return null;
    }

    public fz xv(String str) {
        c sr2 = sr(str);
        if (sr2 != null) {
            return sr2.xv();
        }
        return null;
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

    public static fz ux(String str) {
        c cVar = new c();
        if (cVar.c(null, str) == c.EnumC0463c.SUCCESS) {
            return cVar.xv();
        }
        return null;
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

    public static fz c(URL url) {
        return ux(url.toString());
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
                com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
                xvVar.c(str, i4, i6);
                c(xvVar, str, i6, i5, z3);
                return xvVar.ys();
            }
        }
        return str.substring(i4, i5);
    }

    static void c(com.bytedance.sdk.component.xv.c.xv xvVar, String str, int i4, int i5, boolean z3) {
        int i6;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt == 37 && (i6 = i4 + 2) < i5) {
                int c4 = com.bytedance.sdk.component.xv.w.c.xv.c(str.charAt(i4 + 1));
                int c5 = com.bytedance.sdk.component.xv.w.c.xv.c(str.charAt(i6));
                if (c4 != -1 && c5 != -1) {
                    xvVar.gd((c4 << 4) + c5);
                    i4 = i6;
                }
                xvVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z3) {
                    xvVar.gd(32);
                }
                xvVar.c(codePointAt);
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    static boolean c(String str, int i4, int i5) {
        int i6 = i4 + 2;
        return i6 < i5 && str.charAt(i4) == '%' && com.bytedance.sdk.component.xv.w.c.xv.c(str.charAt(i4 + 1)) != -1 && com.bytedance.sdk.component.xv.w.c.xv.c(str.charAt(i6)) != -1;
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
            com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
            xvVar.c(str, i4, i6);
            c(xvVar, str, i6, i5, str2, z3, z4, z5, z6, charset);
            return xvVar.ys();
        }
        return str.substring(i4, i5);
    }

    static void c(com.bytedance.sdk.component.xv.c.xv xvVar, String str, int i4, int i5, String str2, boolean z3, boolean z4, boolean z5, boolean z6, Charset charset) {
        com.bytedance.sdk.component.xv.c.xv xvVar2 = null;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (!z3 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z5) {
                    xvVar.w(z3 ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z6) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z3 && (!z4 || c(str, i4, i5)))))) {
                    xvVar.c(codePointAt);
                } else {
                    if (xvVar2 == null) {
                        xvVar2 = new com.bytedance.sdk.component.xv.c.xv();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.component.xv.w.c.xv.ux)) {
                        xvVar2.c(str, i4, Character.charCount(codePointAt) + i4, charset);
                    } else {
                        xvVar2.c(codePointAt);
                    }
                    while (!xvVar2.ux()) {
                        int ev = xvVar2.ev() & 255;
                        xvVar.gd(37);
                        char[] cArr = sr;
                        xvVar.gd((int) cArr[(ev >> 4) & 15]);
                        xvVar.gd((int) cArr[ev & 15]);
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
