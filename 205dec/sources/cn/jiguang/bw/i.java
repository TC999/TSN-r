package cn.jiguang.bw;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class i implements Serializable, Cloneable, Comparable {

    /* renamed from: e  reason: collision with root package name */
    private static final DecimalFormat f3055e;

    /* renamed from: a  reason: collision with root package name */
    protected g f3056a;

    /* renamed from: b  reason: collision with root package name */
    protected int f3057b;

    /* renamed from: c  reason: collision with root package name */
    protected int f3058c;

    /* renamed from: d  reason: collision with root package name */
    protected long f3059d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f3055e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(b bVar, int i4) {
        g gVar = new g(bVar);
        int g4 = bVar.g();
        int g5 = bVar.g();
        return i4 == 0 ? a(gVar, g4, g5) : a(gVar, g4, g5, bVar.h(), bVar.g(), bVar);
    }

    public static i a(g gVar, int i4, int i5) {
        return a(gVar, i4, i5, 0L);
    }

    public static i a(g gVar, int i4, int i5, long j4) {
        if (gVar.a()) {
            return a(gVar, i4, i5, j4, false);
        }
        throw new j(gVar);
    }

    private static i a(g gVar, int i4, int i5, long j4, int i6, b bVar) {
        i a4 = a(gVar, i4, i5, j4, bVar != null);
        if (bVar != null) {
            if (bVar.b() < i6) {
                throw new IOException("truncated record");
            }
            bVar.a(i6);
            a4.a(bVar);
            if (bVar.b() > 0) {
                throw new IOException("invalid record length");
            }
            bVar.c();
        }
        return a4;
    }

    private static final i a(g gVar, int i4, int i5, long j4, boolean z3) {
        m mVar = new m();
        mVar.f3056a = gVar;
        mVar.f3057b = i4;
        mVar.f3058c = i5;
        mVar.f3059d = j4;
        return mVar;
    }

    private void a(c cVar, boolean z3) {
        this.f3056a.a(cVar);
        cVar.c(this.f3057b);
        cVar.c(this.f3058c);
        cVar.a(z3 ? 0L : this.f3059d);
        int a4 = cVar.a();
        cVar.c(0);
        a(cVar, (a) null, true);
        cVar.a((cVar.a() - a4) - 2, a4);
    }

    private byte[] a(boolean z3) {
        c cVar = new c();
        a(cVar, z3);
        return cVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        this.f3059d = j4;
    }

    abstract void a(b bVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, int i4, a aVar) {
        this.f3056a.a(cVar, aVar);
        cVar.c(this.f3057b);
        cVar.c(this.f3058c);
    }

    abstract void a(c cVar, a aVar, boolean z3);

    public boolean a(i iVar) {
        return f() == iVar.f() && this.f3058c == iVar.f3058c && this.f3056a.equals(iVar.f3056a);
    }

    public byte[] a() {
        c cVar = new c();
        a(cVar, (a) null, true);
        return cVar.b();
    }

    abstract String b();

    public String c() {
        return b();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        i iVar = (i) obj;
        if (this == iVar) {
            return 0;
        }
        int compareTo = this.f3056a.compareTo(iVar.f3056a);
        if (compareTo != 0) {
            return compareTo;
        }
        int i4 = this.f3058c - iVar.f3058c;
        if (i4 != 0) {
            return i4;
        }
        int i5 = this.f3057b - iVar.f3057b;
        if (i5 != 0) {
            return i5;
        }
        byte[] a4 = a();
        byte[] a5 = iVar.a();
        for (int i6 = 0; i6 < a4.length && i6 < a5.length; i6++) {
            int i7 = (a4[i6] & 255) - (a5[i6] & 255);
            if (i7 != 0) {
                return i7;
            }
        }
        return a4.length - a5.length;
    }

    public g d() {
        return this.f3056a;
    }

    public int e() {
        return this.f3057b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f3057b == iVar.f3057b && this.f3058c == iVar.f3058c && this.f3056a.equals(iVar.f3056a)) {
                return Arrays.equals(a(), iVar.a());
            }
        }
        return false;
    }

    public int f() {
        return this.f3057b;
    }

    public int g() {
        return this.f3058c;
    }

    public long h() {
        return this.f3059d;
    }

    public int hashCode() {
        int i4 = 0;
        for (byte b4 : a(true)) {
            i4 += (i4 << 3) + (b4 & 255);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i i() {
        try {
            return (i) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f3056a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String b4 = b();
        if (!b4.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(b4);
        }
        return stringBuffer.toString();
    }
}
