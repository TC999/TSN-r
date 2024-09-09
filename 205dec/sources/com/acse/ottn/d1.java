package com.acse.ottn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class d1<T> extends b3<T, Float> {
    public d1(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t3, float f4);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.b3
    public /* bridge */ /* synthetic */ void a(Object obj, Float f4) {
        a2((d1<T>) obj, f4);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void a2(T t3, Float f4) {
        a((d1<T>) t3, f4.floatValue());
    }
}
