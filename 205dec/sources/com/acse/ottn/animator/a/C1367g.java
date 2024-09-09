package com.acse.ottn.animator.a;

/* renamed from: com.acse.ottn.animator.a.g  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1367g implements F<Number> {
    @Override // com.acse.ottn.animator.a.F
    /* renamed from: a */
    public Float evaluate(float f4, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f4 * (number2.floatValue() - floatValue)));
    }
}
