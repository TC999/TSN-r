package cn.jiguang.bw;

import java.security.SecureRandom;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static SecureRandom f3025d = new SecureRandom();

    /* renamed from: a  reason: collision with root package name */
    private int f3026a;

    /* renamed from: b  reason: collision with root package name */
    private int f3027b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f3028c;

    public d() {
        this.f3027b = 256;
        d();
    }

    public d(int i4) {
        this.f3027b = 256;
        d();
        a(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this(bVar.g());
        this.f3027b = bVar.g();
        int i4 = 0;
        while (true) {
            int[] iArr = this.f3028c;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = bVar.g();
            i4++;
        }
    }

    private void d() {
        this.f3028c = new int[4];
        this.f3027b = 256;
        this.f3026a = -1;
    }

    public int a() {
        int i4;
        int i5 = this.f3026a;
        if (i5 >= 0) {
            return i5;
        }
        synchronized (this) {
            if (this.f3026a < 0) {
                this.f3026a = f3025d.nextInt(65535);
            }
            i4 = this.f3026a;
        }
        return i4;
    }

    public void a(int i4) {
        if (i4 >= 0 && i4 <= 65535) {
            this.f3026a = i4;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i4 + " is out of range");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        cVar.c(a());
        cVar.c(this.f3027b);
        int i4 = 0;
        while (true) {
            int[] iArr = this.f3028c;
            if (i4 >= iArr.length) {
                return;
            }
            cVar.c(iArr[i4]);
            i4++;
        }
    }

    public int b() {
        return this.f3027b & 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4) {
        int[] iArr = this.f3028c;
        if (iArr[i4] == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i4] = iArr[i4] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f3027b;
    }

    public int c(int i4) {
        return this.f3028c[i4];
    }

    public Object clone() {
        d dVar = new d();
        dVar.f3026a = this.f3026a;
        dVar.f3027b = this.f3027b;
        int[] iArr = this.f3028c;
        System.arraycopy(iArr, 0, dVar.f3028c, 0, iArr.length);
        return dVar;
    }

    String d(int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + a());
        stringBuffer.append("\n");
        stringBuffer.append("; ");
        for (int i5 = 0; i5 < 4; i5++) {
            stringBuffer.append(n.a(i5) + ": " + c(i5) + " ");
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return d(b());
    }
}
