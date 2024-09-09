package defpackage;

import io.github.libxposed.api.utils.DexParser;

/* renamed from: S  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class S extends T implements DexParser.FieldId {

    /* renamed from: b  reason: collision with root package name */
    public final DexParser.TypeId f55b;

    /* renamed from: c  reason: collision with root package name */
    public final DexParser.TypeId f56c;

    /* renamed from: d  reason: collision with root package name */
    public final DexParser.StringId f57d;

    public S(Z z3, int i4, int i5, int i6, int i7) {
        super(i4);
        DexParser.TypeId[] typeIdArr = z3.f91c;
        this.f55b = typeIdArr[i5];
        this.f56c = typeIdArr[i6];
        this.f57d = z3.f90b[i7];
    }

    @Override // io.github.libxposed.api.utils.DexParser.FieldId
    public final DexParser.TypeId getDeclaringClass() {
        return this.f56c;
    }

    @Override // io.github.libxposed.api.utils.DexParser.FieldId
    public final DexParser.StringId getName() {
        return this.f57d;
    }

    @Override // io.github.libxposed.api.utils.DexParser.FieldId
    public final DexParser.TypeId getType() {
        return this.f55b;
    }
}
