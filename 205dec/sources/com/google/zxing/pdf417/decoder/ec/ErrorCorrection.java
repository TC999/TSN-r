package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i4 = 0;
        for (int i5 = 1; i5 < this.field.getSize() && i4 < degree; i5++) {
            if (modulusPoly.evaluateAt(i5) == 0) {
                iArr[i4] = this.field.inverse(i5);
                i4++;
            }
        }
        if (i4 == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i4 = 1; i4 <= degree; i4++) {
            iArr2[degree - i4] = this.field.multiply(i4, modulusPoly2.getCoefficient(i4));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            int inverse = this.field.inverse(iArr[i5]);
            iArr3[i5] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return iArr3;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i4) throws ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        while (true) {
            ModulusPoly modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
            ModulusPoly modulusPoly4 = one;
            ModulusPoly modulusPoly5 = zero;
            zero = modulusPoly4;
            if (modulusPoly.getDegree() >= i4 / 2) {
                if (!modulusPoly.isZero()) {
                    ModulusPoly zero2 = this.field.getZero();
                    int inverse = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
                    while (modulusPoly2.getDegree() >= modulusPoly.getDegree() && !modulusPoly2.isZero()) {
                        int degree = modulusPoly2.getDegree() - modulusPoly.getDegree();
                        int multiply = this.field.multiply(modulusPoly2.getCoefficient(modulusPoly2.getDegree()), inverse);
                        zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                        modulusPoly2 = modulusPoly2.subtract(modulusPoly.multiplyByMonomial(degree, multiply));
                    }
                    one = zero2.multiply(zero).subtract(modulusPoly5).negative();
                } else {
                    throw ChecksumException.getChecksumInstance();
                }
            } else {
                int coefficient = zero.getCoefficient(0);
                if (coefficient != 0) {
                    int inverse2 = this.field.inverse(coefficient);
                    return new ModulusPoly[]{zero.multiply(inverse2), modulusPoly.multiply(inverse2)};
                }
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public int decode(int[] iArr, int i4, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i4];
        boolean z3 = false;
        for (int i5 = i4; i5 > 0; i5--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i5));
            iArr3[i4 - i5] = evaluateAt;
            if (evaluateAt != 0) {
                z3 = true;
            }
        }
        if (z3) {
            ModulusPoly one = this.field.getOne();
            if (iArr2 != null) {
                for (int i6 : iArr2) {
                    int exp = this.field.exp((iArr.length - 1) - i6);
                    ModulusGF modulusGF = this.field;
                    one = one.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, exp), 1}));
                }
            }
            ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i4, 1), new ModulusPoly(this.field, iArr3), i4);
            ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
            ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
            int[] findErrorLocations = findErrorLocations(modulusPoly2);
            int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
            for (int i7 = 0; i7 < findErrorLocations.length; i7++) {
                int length = (iArr.length - 1) - this.field.log(findErrorLocations[i7]);
                if (length >= 0) {
                    iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i7]);
                } else {
                    throw ChecksumException.getChecksumInstance();
                }
            }
            return findErrorLocations.length;
        }
        return 0;
    }
}
