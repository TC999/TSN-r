package com.hp.hpl.sparta;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: CharCircBuffer.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f37351a;

    /* renamed from: b  reason: collision with root package name */
    private int f37352b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f37353c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f37354d = true;

    b(int i4) {
        this.f37351a = new int[i4];
    }

    private void c(int i4) {
        if (this.f37354d) {
            int[] iArr = this.f37351a;
            int i5 = this.f37352b;
            iArr[i5] = i4;
            this.f37352b = (i5 + 1) % iArr.length;
            this.f37353c++;
        }
    }

    void a(char c4) {
        c(c4);
    }

    void b(int i4) {
        c(i4 + 65536);
    }

    void d(String str) {
        for (char c4 : str.toCharArray()) {
            a(c4);
        }
    }

    void e() {
        this.f37354d = false;
    }

    void f() {
        this.f37354d = true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f37351a.length * 11) / 10);
        int i4 = this.f37353c;
        int[] iArr = this.f37351a;
        int length = i4 < iArr.length ? iArr.length - i4 : 0;
        while (true) {
            int[] iArr2 = this.f37351a;
            if (length < iArr2.length) {
                int i5 = iArr2[(this.f37352b + length) % iArr2.length];
                if (i5 < 65536) {
                    stringBuffer.append((char) i5);
                } else {
                    stringBuffer.append(Integer.toString(i5 - 65536));
                }
                length++;
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
