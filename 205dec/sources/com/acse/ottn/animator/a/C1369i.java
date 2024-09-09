package com.acse.ottn.animator.a;

/* renamed from: com.acse.ottn.animator.a.i  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1369i implements F<Integer> {
    @Override // com.acse.ottn.animator.a.F
    /* renamed from: a */
    public Integer evaluate(float f4, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (intValue + (f4 * (num2.intValue() - intValue))));
    }
}
