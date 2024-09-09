package com.acse.ottn.animator.b;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class a<T> extends d<T, Float> {
    public a(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t3, float f4);

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void a2(T t3, Float f4) {
        a((a<T>) t3, f4.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.animator.b.d
    public /* bridge */ /* synthetic */ void a(Object obj, Float f4) {
        a2((a<T>) obj, f4);
    }
}
