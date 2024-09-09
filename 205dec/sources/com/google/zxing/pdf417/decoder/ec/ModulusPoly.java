package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ModulusPoly {
    private final int[] coefficients;
    private final ModulusGF field;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length != 0) {
            this.field = modulusGF;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i4 = 1;
                while (i4 < length && iArr[i4] == 0) {
                    i4++;
                }
                if (i4 == length) {
                    this.coefficients = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i4];
                this.coefficients = iArr2;
                System.arraycopy(iArr, i4, iArr2, 0, iArr2.length);
                return;
            }
            this.coefficients = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly add(ModulusPoly modulusPoly) {
        if (this.field.equals(modulusPoly.field)) {
            if (isZero()) {
                return modulusPoly;
            }
            if (modulusPoly.isZero()) {
                return this;
            }
            int[] iArr = this.coefficients;
            int[] iArr2 = modulusPoly.coefficients;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i4 = length; i4 < iArr.length; i4++) {
                iArr3[i4] = this.field.add(iArr2[i4 - length], iArr[i4]);
            }
            return new ModulusPoly(this.field, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int evaluateAt(int i4) {
        if (i4 == 0) {
            return getCoefficient(0);
        }
        if (i4 == 1) {
            int i5 = 0;
            for (int i6 : this.coefficients) {
                i5 = this.field.add(i5, i6);
            }
            return i5;
        }
        int[] iArr = this.coefficients;
        int i7 = iArr[0];
        int length = iArr.length;
        for (int i8 = 1; i8 < length; i8++) {
            ModulusGF modulusGF = this.field;
            i7 = modulusGF.add(modulusGF.multiply(i4, i7), this.coefficients[i8]);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCoefficient(int i4) {
        int[] iArr = this.coefficients;
        return iArr[(iArr.length - 1) - i4];
    }

    int[] getCoefficients() {
        return this.coefficients;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDegree() {
        return this.coefficients.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isZero() {
        return this.coefficients[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly multiply(ModulusPoly modulusPoly) {
        if (this.field.equals(modulusPoly.field)) {
            if (!isZero() && !modulusPoly.isZero()) {
                int[] iArr = this.coefficients;
                int length = iArr.length;
                int[] iArr2 = modulusPoly.coefficients;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    for (int i6 = 0; i6 < length2; i6++) {
                        int i7 = i4 + i6;
                        ModulusGF modulusGF = this.field;
                        iArr3[i7] = modulusGF.add(iArr3[i7], modulusGF.multiply(i5, iArr2[i6]));
                    }
                }
                return new ModulusPoly(this.field, iArr3);
            }
            return this.field.getZero();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly multiplyByMonomial(int i4, int i5) {
        if (i4 >= 0) {
            if (i5 == 0) {
                return this.field.getZero();
            }
            int length = this.coefficients.length;
            int[] iArr = new int[i4 + length];
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = this.field.multiply(this.coefficients[i6], i5);
            }
            return new ModulusPoly(this.field, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly negative() {
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.field.subtract(0, this.coefficients[i4]);
        }
        return new ModulusPoly(this.field, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly subtract(ModulusPoly modulusPoly) {
        if (this.field.equals(modulusPoly.field)) {
            return modulusPoly.isZero() ? this : add(modulusPoly.negative());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    sb.append(coefficient);
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly multiply(int i4) {
        if (i4 == 0) {
            return this.field.getZero();
        }
        if (i4 == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = this.field.multiply(this.coefficients[i5], i4);
        }
        return new ModulusPoly(this.field, iArr);
    }
}
