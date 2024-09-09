package com.acse.ottn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q1 implements f4<Integer> {
    @Override // com.acse.ottn.f4
    /* renamed from: a */
    public Integer evaluate(float f4, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (intValue + (f4 * (num2.intValue() - intValue))));
    }
}
