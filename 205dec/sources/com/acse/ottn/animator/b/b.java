package com.acse.ottn.animator.b;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class b<T> extends d<T, Integer> {
    public b(String str) {
        super(Integer.class, str);
    }

    public abstract void a(T t3, int i4);

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void a2(T t3, Integer num) {
        a2((b<T>) t3, Integer.valueOf(num.intValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.animator.b.d
    public /* bridge */ /* synthetic */ void a(Object obj, Integer num) {
        a2((b<T>) obj, num);
    }
}
