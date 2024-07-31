package com.acse.ottn.animator.p031a;

/* renamed from: com.acse.ottn.animator.a.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1346g implements InterfaceC1325F<Number> {
    @Override // com.acse.ottn.animator.p031a.InterfaceC1325F
    /* renamed from: a */
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f * (number2.floatValue() - floatValue)));
    }
}
