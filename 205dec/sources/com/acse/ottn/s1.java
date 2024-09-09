package com.acse.ottn;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class s1<T> extends b3<T, Integer> {
    public s1(String str) {
        super(Integer.class, str);
    }

    public abstract void a(T t3, int i4);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.b3
    public /* bridge */ /* synthetic */ void a(Object obj, Integer num) {
        a2((s1<T>) obj, num);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void a2(T t3, Integer num) {
        a2((s1<T>) t3, Integer.valueOf(num.intValue()));
    }
}
