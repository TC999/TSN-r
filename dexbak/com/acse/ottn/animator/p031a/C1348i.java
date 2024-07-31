package com.acse.ottn.animator.p031a;

/* renamed from: com.acse.ottn.animator.a.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1348i implements InterfaceC1325F<Integer> {
    @Override // com.acse.ottn.animator.p031a.InterfaceC1325F
    /* renamed from: a */
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (intValue + (f * (num2.intValue() - intValue))));
    }
}
