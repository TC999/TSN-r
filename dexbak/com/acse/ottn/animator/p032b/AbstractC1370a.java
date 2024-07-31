package com.acse.ottn.animator.p032b;

/* renamed from: com.acse.ottn.animator.b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1370a<T> extends AbstractC1373d<T, Float> {
    public AbstractC1370a(String str) {
        super(Float.class, str);
    }

    /* renamed from: a */
    public abstract void mo57011a(T t, float f);

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void m57010a(T t, Float f) {
        mo57011a((AbstractC1370a<T>) t, f.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.animator.p032b.AbstractC1373d
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo57002a(Object obj, Float f) {
        m57010a((AbstractC1370a<T>) obj, f);
    }
}
