package com.acse.ottn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a1 implements f4<Number> {
    @Override // com.acse.ottn.f4
    /* renamed from: a */
    public Float evaluate(float f4, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f4 * (number2.floatValue() - floatValue)));
    }
}
