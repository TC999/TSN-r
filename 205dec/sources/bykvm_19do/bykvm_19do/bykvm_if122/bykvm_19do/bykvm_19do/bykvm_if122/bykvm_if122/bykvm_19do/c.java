package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
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

/* compiled from: Util.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f1226a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f1227b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final b0 f1228c;

    /* renamed from: d  reason: collision with root package name */
    private static final f f1229d;

    /* renamed from: e  reason: collision with root package name */
    private static final f f1230e;

    /* renamed from: f  reason: collision with root package name */
    private static final f f1231f;

    /* renamed from: g  reason: collision with root package name */
    private static final f f1232g;

    /* renamed from: h  reason: collision with root package name */
    private static final f f1233h;

    /* renamed from: i  reason: collision with root package name */
    public static final Charset f1234i;

    /* renamed from: j  reason: collision with root package name */
    private static final Charset f1235j;

    /* renamed from: k  reason: collision with root package name */
    private static final Charset f1236k;

    /* renamed from: l  reason: collision with root package name */
    private static final Charset f1237l;

    /* renamed from: m  reason: collision with root package name */
    private static final Charset f1238m;

    /* renamed from: n  reason: collision with root package name */
    public static final TimeZone f1239n;

    /* renamed from: o  reason: collision with root package name */
    public static final Comparator<String> f1240o;

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f1241p;

    /* compiled from: Util.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* compiled from: Util.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1243b;

        b(String str, boolean z3) {
            this.f1242a = str;
            this.f1243b = z3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tt_pangle_thread_" + this.f1242a);
            thread.setDaemon(this.f1243b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f1226a = bArr;
        f1228c = b0.a(null, bArr);
        z.a((u) null, bArr);
        f1229d = f.a("efbbbf");
        f1230e = f.a("feff");
        f1231f = f.a("fffe");
        f1232g = f.a("0000ffff");
        f1233h = f.a("ffff0000");
        f1234i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f1235j = Charset.forName("UTF-16BE");
        f1236k = Charset.forName("UTF-16LE");
        f1237l = Charset.forName("UTF-32BE");
        f1238m = Charset.forName("UTF-32LE");
        f1239n = TimeZone.getTimeZone("GMT");
        f1240o = new a();
        f1241p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int a(char c4) {
        if (c4 < '0' || c4 > '9') {
            char c5 = 'a';
            if (c4 < 'a' || c4 > 'f') {
                c5 = 'A';
                if (c4 < 'A' || c4 > 'F') {
                    return -1;
                }
            }
            return (c4 - c5) + 10;
        }
        return c4 - '0';
    }

    public static void a(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean b(s sVar, int i4, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c4 = sVar.t().d() ? sVar.t().c() - nanoTime : Long.MAX_VALUE;
        sVar.t().a(Math.min(c4, timeUnit.toNanos(i4)) + nanoTime);
        try {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
            while (sVar.a(cVar, 8192L) != -1) {
                cVar.a();
            }
            if (c4 == Long.MAX_VALUE) {
                sVar.t().a();
            } else {
                sVar.t().a(nanoTime + c4);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c4 == Long.MAX_VALUE) {
                sVar.t().a();
            } else {
                sVar.t().a(nanoTime + c4);
            }
            return false;
        } catch (Throwable th) {
            if (c4 == Long.MAX_VALUE) {
                sVar.t().a();
            } else {
                sVar.t().a(nanoTime + c4);
            }
            throw th;
        }
    }

    public static int c(String str, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            char charAt = str.charAt(i6);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i6 + 1;
            }
        }
        return i4;
    }

    public static String d(String str, int i4, int i5) {
        int b4 = b(str, i4, i5);
        return str.substring(b4, c(str, b4, i5));
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int c(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= '\u007f') {
                return i4;
            }
        }
        return -1;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean d(String str) {
        return f1241p.matcher(str).matches();
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e4) {
                if (!a(e4)) {
                    throw e4;
                }
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(s sVar, int i4, TimeUnit timeUnit) {
        try {
            return b(sVar, i4, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z3) {
        return new b(str, z3);
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i4]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i4++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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

    public static String a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar, boolean z3) {
        String g4;
        if (sVar.g().contains(":")) {
            g4 = "[" + sVar.g() + "]";
        } else {
            g4 = sVar.g();
        }
        if (z3 || sVar.j() != bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s.c(sVar.m())) {
            return g4 + ":" + sVar.j();
        }
        return g4;
    }

    public static int b(String str, int i4, int i5) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    private static boolean b(String str) {
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= '\u007f' || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (comparator.compare(strArr[i4], str) == 0) {
                return i4;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i4, int i5, String str2) {
        while (i4 < i5) {
            if (str2.indexOf(str.charAt(i4)) != -1) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static int a(String str, int i4, int i5, char c4) {
        while (i4 < i5) {
            if (str.charAt(i4) == c4) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static String a(String str) {
        InetAddress a4;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                a4 = a(str, 1, str.length() - 1);
            } else {
                a4 = a(str, 0, str.length());
            }
            if (a4 == null) {
                return null;
            }
            byte[] address = a4.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (b(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        f fVar = f1229d;
        if (eVar.a(0L, fVar)) {
            eVar.skip(fVar.e());
            return f1234i;
        }
        f fVar2 = f1230e;
        if (eVar.a(0L, fVar2)) {
            eVar.skip(fVar2.e());
            return f1235j;
        }
        f fVar3 = f1231f;
        if (eVar.a(0L, fVar3)) {
            eVar.skip(fVar3.e());
            return f1236k;
        }
        f fVar4 = f1232g;
        if (eVar.a(0L, fVar4)) {
            eVar.skip(fVar4.e());
            return f1237l;
        }
        f fVar5 = f1233h;
        if (eVar.a(0L, fVar5)) {
            eVar.skip(fVar5.e());
            return f1238m;
        }
        return charset;
    }

    public static int a(String str, long j4, TimeUnit timeUnit) {
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j4);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i4 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static AssertionError a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress a(java.lang.String r11, int r12, int r13) {
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
            boolean r11 = a(r11, r6, r13, r1, r12)
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
            int r9 = a(r9)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean a(String str, int i4, int i5, byte[] bArr, int i6) {
        int i7 = i6;
        while (i4 < i5) {
            if (i7 == bArr.length) {
                return false;
            }
            if (i7 != i6) {
                if (str.charAt(i4) != '.') {
                    return false;
                }
                i4++;
            }
            int i8 = i4;
            int i9 = 0;
            while (i8 < i5) {
                char charAt = str.charAt(i8);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i9 == 0 && i4 != i8) || (i9 = ((i9 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i8++;
                }
            }
            if (i8 - i4 == 0) {
                return false;
            }
            bArr[i7] = (byte) i9;
            i7++;
            i4 = i8;
        }
        return i7 == i6 + 4;
    }

    private static String a(byte[] bArr) {
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            int i8 = i6;
            while (i8 < 16 && bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                i8 += 2;
            }
            int i9 = i8 - i6;
            if (i9 > i7 && i9 >= 4) {
                i5 = i6;
                i7 = i9;
            }
            i6 = i8 + 2;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        while (i4 < bArr.length) {
            if (i4 == i5) {
                cVar.writeByte(58);
                i4 += i7;
                if (i4 == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i4 > 0) {
                    cVar.writeByte(58);
                }
                cVar.g(((bArr[i4] & 255) << 8) | (bArr[i4 + 1] & 255));
                i4 += 2;
            }
        }
        return cVar.e();
    }
}
