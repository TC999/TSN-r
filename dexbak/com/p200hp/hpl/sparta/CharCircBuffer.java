package com.p200hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class CharCircBuffer {

    /* renamed from: a */
    private final int[] f23849a;

    /* renamed from: b */
    private int f23850b = 0;

    /* renamed from: c */
    private int f23851c = 0;

    /* renamed from: d */
    private boolean f23852d = true;

    CharCircBuffer(int i) {
        this.f23849a = new int[i];
    }

    /* renamed from: c */
    private void m35290c(int i) {
        if (this.f23852d) {
            int[] iArr = this.f23849a;
            int i2 = this.f23850b;
            iArr[i2] = i;
            this.f23850b = (i2 + 1) % iArr.length;
            this.f23851c++;
        }
    }

    /* renamed from: a */
    void m35292a(char c) {
        m35290c(c);
    }

    /* renamed from: b */
    void m35291b(int i) {
        m35290c(i + 65536);
    }

    /* renamed from: d */
    void m35289d(String str) {
        for (char c : str.toCharArray()) {
            m35292a(c);
        }
    }

    /* renamed from: e */
    void m35288e() {
        this.f23852d = false;
    }

    /* renamed from: f */
    void m35287f() {
        this.f23852d = true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f23849a.length * 11) / 10);
        int i = this.f23851c;
        int[] iArr = this.f23849a;
        int length = i < iArr.length ? iArr.length - i : 0;
        while (true) {
            int[] iArr2 = this.f23849a;
            if (length < iArr2.length) {
                int i2 = iArr2[(this.f23850b + length) % iArr2.length];
                if (i2 < 65536) {
                    stringBuffer.append((char) i2);
                } else {
                    stringBuffer.append(Integer.toString(i2 - 65536));
                }
                length++;
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
