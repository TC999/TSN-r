package com.acse.ottn.animator.a;

/* renamed from: com.acse.ottn.animator.a.f  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1366f implements F {
    @Override // com.acse.ottn.animator.a.F
    public Object evaluate(float f4, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i4 = intValue >> 24;
        int i5 = (intValue >> 16) & 255;
        int i6 = (intValue >> 8) & 255;
        int i7 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i4 + ((int) (((intValue2 >> 24) - i4) * f4))) << 24) | ((i5 + ((int) ((((intValue2 >> 16) & 255) - i5) * f4))) << 16) | ((i6 + ((int) ((((intValue2 >> 8) & 255) - i6) * f4))) << 8) | (i7 + ((int) (f4 * ((intValue2 & 255) - i7)))));
    }
}
