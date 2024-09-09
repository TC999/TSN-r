package defpackage;

import io.github.libxposed.api.utils.DexParser;

/* renamed from: U  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class U extends T implements DexParser.MethodId {

    /* renamed from: b  reason: collision with root package name */
    public final DexParser.TypeId f59b;

    /* renamed from: c  reason: collision with root package name */
    public final DexParser.ProtoId f60c;

    /* renamed from: d  reason: collision with root package name */
    public final DexParser.StringId f61d;

    public U(Z z3, int i4, int i5, int i6, int i7) {
        super(i4);
        this.f59b = z3.f91c[i5];
        this.f60c = z3.f92d[i6];
        this.f61d = z3.f90b[i7];
    }

    @Override // io.github.libxposed.api.utils.DexParser.MethodId
    public final DexParser.TypeId getDeclaringClass() {
        return this.f59b;
    }

    @Override // io.github.libxposed.api.utils.DexParser.MethodId
    public final DexParser.StringId getName() {
        return this.f61d;
    }

    @Override // io.github.libxposed.api.utils.DexParser.MethodId
    public final DexParser.ProtoId getPrototype() {
        return this.f60c;
    }
}
