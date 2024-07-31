package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.MediaType;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.UByte;

/* compiled from: Util.java */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1061c {

    /* renamed from: a */
    public static final byte[] f1233a;

    /* renamed from: b */
    public static final String[] f1234b = new String[0];

    /* renamed from: c */
    public static final ResponseBody f1235c;

    /* renamed from: d */
    private static final ByteString f1236d;

    /* renamed from: e */
    private static final ByteString f1237e;

    /* renamed from: f */
    private static final ByteString f1238f;

    /* renamed from: g */
    private static final ByteString f1239g;

    /* renamed from: h */
    private static final ByteString f1240h;

    /* renamed from: i */
    public static final Charset f1241i;

    /* renamed from: j */
    private static final Charset f1242j;

    /* renamed from: k */
    private static final Charset f1243k;

    /* renamed from: l */
    private static final Charset f1244l;

    /* renamed from: m */
    private static final Charset f1245m;

    /* renamed from: n */
    public static final TimeZone f1246n;

    /* renamed from: o */
    public static final Comparator<String> f1247o;

    /* renamed from: p */
    private static final Pattern f1248p;

    /* compiled from: Util.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1062a implements Comparator<String> {
        C1062a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* compiled from: Util.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class ThreadFactoryC1063b implements ThreadFactory {

        /* renamed from: a */
        final /* synthetic */ String f1249a;

        /* renamed from: b */
        final /* synthetic */ boolean f1250b;

        ThreadFactoryC1063b(String str, boolean z) {
            this.f1249a = str;
            this.f1250b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tt_pangle_thread_" + this.f1249a);
            thread.setDaemon(this.f1250b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f1233a = bArr;
        f1235c = ResponseBody.m58818a(null, bArr);
        RequestBody.m58191a((MediaType) null, bArr);
        f1236d = ByteString.m58942a("efbbbf");
        f1237e = ByteString.m58942a("feff");
        f1238f = ByteString.m58942a("fffe");
        f1239g = ByteString.m58942a("0000ffff");
        f1240h = ByteString.m58942a("ffff0000");
        f1241i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f1242j = Charset.forName("UTF-16BE");
        f1243k = Charset.forName("UTF-16LE");
        f1244l = Charset.forName("UTF-32BE");
        f1245m = Charset.forName("UTF-32LE");
        f1246n = TimeZone.getTimeZone("GMT");
        f1247o = new C1062a();
        f1248p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* renamed from: a */
    public static int m58480a(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    return -1;
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    /* renamed from: a */
    public static void m58479a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: b */
    public static boolean m58456b(Source source, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long mo58874c = source.mo58555t().mo58873d() ? source.mo58555t().mo58874c() - nanoTime : Long.MAX_VALUE;
        source.mo58555t().mo58871a(Math.min(mo58874c, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.mo58558a(buffer, 8192L) != -1) {
                buffer.m58966a();
            }
            if (mo58874c == Long.MAX_VALUE) {
                source.mo58555t().mo58876a();
            } else {
                source.mo58555t().mo58871a(nanoTime + mo58874c);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (mo58874c == Long.MAX_VALUE) {
                source.mo58555t().mo58876a();
            } else {
                source.mo58555t().mo58871a(nanoTime + mo58874c);
            }
            return false;
        } catch (Throwable th) {
            if (mo58874c == Long.MAX_VALUE) {
                source.mo58555t().mo58876a();
            } else {
                source.mo58555t().mo58871a(nanoTime + mo58874c);
            }
            throw th;
        }
    }

    /* renamed from: c */
    public static int m58451c(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: d */
    public static String m58449d(String str, int i, int i2) {
        int m58454b = m58454b(str, i, i2);
        return str.substring(m58454b, m58451c(str, m58454b, i2));
    }

    /* renamed from: a */
    public static boolean m58473a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: c */
    public static int m58452c(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m58475a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    public static boolean m58450d(String str) {
        return f1248p.matcher(str).matches();
    }

    /* renamed from: a */
    public static void m58463a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m58474a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m58477a(Source source, int i, TimeUnit timeUnit) {
        try {
            return m58456b(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m58460a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m58458a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m58465a(String str, boolean z) {
        return new ThreadFactoryC1063b(str, z);
    }

    /* renamed from: a */
    public static String[] m58461a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public static boolean m58453b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m58476a(HttpUrl httpUrl, boolean z) {
        String m58307g;
        if (httpUrl.m58307g().contains(":")) {
            m58307g = "[" + httpUrl.m58307g() + "]";
        } else {
            m58307g = httpUrl.m58307g();
        }
        if (z || httpUrl.m58304j() != HttpUrl.m58313c(httpUrl.m58301m())) {
            return m58307g + ":" + httpUrl.m58304j();
        }
        return m58307g;
    }

    /* renamed from: b */
    public static int m58454b(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    private static boolean m58455b(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m58474a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m58462a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m58457a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m58469a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m58470a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m58472a(String str) {
        InetAddress m58471a;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                m58471a = m58471a(str, 1, str.length() - 1);
            } else {
                m58471a = m58471a(str, 0, str.length());
            }
            if (m58471a == null) {
                return null;
            }
            byte[] address = m58471a.getAddress();
            if (address.length == 16) {
                return m58459a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (m58455b(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m58464a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m58478a(BufferedSource bufferedSource, Charset charset) throws IOException {
        ByteString byteString = f1236d;
        if (bufferedSource.mo58912a(0L, byteString)) {
            bufferedSource.skip(byteString.mo58881e());
            return f1241i;
        }
        ByteString byteString2 = f1237e;
        if (bufferedSource.mo58912a(0L, byteString2)) {
            bufferedSource.skip(byteString2.mo58881e());
            return f1242j;
        }
        ByteString byteString3 = f1238f;
        if (bufferedSource.mo58912a(0L, byteString3)) {
            bufferedSource.skip(byteString3.mo58881e());
            return f1243k;
        }
        ByteString byteString4 = f1239g;
        if (bufferedSource.mo58912a(0L, byteString4)) {
            bufferedSource.skip(byteString4.mo58881e());
            return f1244l;
        }
        ByteString byteString5 = f1240h;
        if (bufferedSource.mo58912a(0L, byteString5)) {
            bufferedSource.skip(byteString5.mo58881e());
            return f1245m;
        }
        return charset;
    }

    /* renamed from: a */
    public static int m58467a(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: a */
    public static AssertionError m58466a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress m58471a(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r12 >= r13) goto L7a
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r12 + 2
            if (r8 > r13) goto L27
            java.lang.String r9 = "::"
            r10 = 2
            boolean r9 = r11.regionMatches(r12, r9, r3, r10)
            if (r9 == 0) goto L27
            if (r5 == r2) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r13) goto L25
            goto L7a
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L4a
            java.lang.String r8 = ":"
            r9 = 1
            boolean r8 = r11.regionMatches(r12, r8, r3, r9)
            if (r8 == 0) goto L35
            int r12 = r12 + 1
            goto L4a
        L35:
            java.lang.String r8 = "."
            boolean r12 = r11.regionMatches(r12, r8, r3, r9)
            if (r12 == 0) goto L49
            int r12 = r4 + (-2)
            boolean r11 = m58468a(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L7a
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r12 = r6
            r8 = 0
        L4d:
            if (r12 >= r13) goto L60
            char r9 = r11.charAt(r12)
            int r9 = m58480a(r9)
            if (r9 != r2) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L60:
            int r9 = r12 - r6
            if (r9 == 0) goto L79
            r10 = 4
            if (r9 <= r10) goto L68
            goto L79
        L68:
            int r7 = r4 + 1
            int r9 = r8 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r7 + 1
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L79:
            return r7
        L7a:
            if (r4 == r0) goto L8b
            if (r5 != r2) goto L7f
            return r7
        L7f:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r3)
        L8b:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
            return r11
        L90:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            goto L97
        L96:
            throw r11
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c.m58471a(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: a */
    private static boolean m58468a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* renamed from: a */
    private static String m58459a(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i2) {
                buffer.writeByte(58);
                i += i4;
                if (i == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i > 0) {
                    buffer.writeByte(58);
                }
                buffer.mo58917g(((bArr[i] & UByte.f41242c) << 8) | (bArr[i + 1] & UByte.f41242c));
                i += 2;
            }
        }
        return buffer.m58948e();
    }
}
