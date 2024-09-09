package defpackage;

import io.github.libxposed.api.utils.DexParser;

/* renamed from: X  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class X extends T implements DexParser.TypeId {

    /* renamed from: b  reason: collision with root package name */
    public final DexParser.StringId f69b;

    public X(Z z3, int i4, int i5) {
        super(i4);
        this.f69b = z3.f90b[i5];
    }

    @Override // io.github.libxposed.api.utils.DexParser.TypeId
    public final DexParser.StringId getDescriptor() {
        return this.f69b;
    }
}
