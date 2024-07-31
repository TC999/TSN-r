package com.acse.ottn.animator.p032b;

/* renamed from: com.acse.ottn.animator.b.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1371b<T> extends AbstractC1373d<T, Integer> {
    public AbstractC1371b(String str) {
        super(Integer.class, str);
    }

    /* renamed from: a */
    public abstract void mo57009a(T t, int i);

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void m57008a(T t, Integer num) {
        m57008a((AbstractC1371b<T>) t, Integer.valueOf(num.intValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.animator.p032b.AbstractC1373d
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo57002a(Object obj, Integer num) {
        m57008a((AbstractC1371b<T>) obj, num);
    }
}
