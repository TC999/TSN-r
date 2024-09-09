package com.google.zxing.pdf417.decoder.ec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(929, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int i4, int i5) {
        this.modulus = i4;
        this.expTable = new int[i4];
        this.logTable = new int[i4];
        int i6 = 1;
        for (int i7 = 0; i7 < i4; i7++) {
            this.expTable[i7] = i6;
            i6 = (i6 * i5) % i4;
        }
        for (int i8 = 0; i8 < i4 - 1; i8++) {
            this.logTable[this.expTable[i8]] = i8;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int add(int i4, int i5) {
        return (i4 + i5) % this.modulus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly buildMonomial(int i4, int i5) {
        if (i4 >= 0) {
            if (i5 == 0) {
                return this.zero;
            }
            int[] iArr = new int[i4 + 1];
            iArr[0] = i5;
            return new ModulusPoly(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int exp(int i4) {
        return this.expTable[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly getOne() {
        return this.one;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSize() {
        return this.modulus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly getZero() {
        return this.zero;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int inverse(int i4) {
        if (i4 != 0) {
            return this.expTable[(this.modulus - this.logTable[i4]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int log(int i4) {
        if (i4 != 0) {
            return this.logTable[i4];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int multiply(int i4, int i5) {
        if (i4 == 0 || i5 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i4] + iArr2[i5]) % (this.modulus - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int subtract(int i4, int i5) {
        int i6 = this.modulus;
        return ((i4 + i6) - i5) % i6;
    }
}
