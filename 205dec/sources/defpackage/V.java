package defpackage;

import io.github.libxposed.api.utils.DexParser;

/* renamed from: V  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class V extends T implements DexParser.ProtoId {

    /* renamed from: b  reason: collision with root package name */
    public final DexParser.StringId f65b;

    /* renamed from: c  reason: collision with root package name */
    public final DexParser.TypeId f66c;

    /* renamed from: d  reason: collision with root package name */
    public final DexParser.TypeId[] f67d;

    public V(Z z3, int i4, int[] iArr) {
        super(i4);
        this.f65b = z3.f90b[iArr[0]];
        int i5 = iArr[1];
        DexParser.TypeId[] typeIdArr = z3.f91c;
        this.f66c = typeIdArr[i5];
        int i6 = 2;
        if (iArr.length <= 2) {
            this.f67d = null;
            return;
        }
        this.f67d = new DexParser.TypeId[iArr.length - 2];
        while (true) {
            DexParser.TypeId[] typeIdArr2 = this.f67d;
            if (i6 >= typeIdArr2.length) {
                return;
            }
            typeIdArr2[i6] = typeIdArr[iArr[i6]];
            i6++;
        }
    }

    @Override // io.github.libxposed.api.utils.DexParser.ProtoId
    public final DexParser.TypeId[] getParameters() {
        return this.f67d;
    }

    @Override // io.github.libxposed.api.utils.DexParser.ProtoId
    public final DexParser.TypeId getReturnType() {
        return this.f66c;
    }

    @Override // io.github.libxposed.api.utils.DexParser.ProtoId
    public final DexParser.StringId getShorty() {
        return this.f65b;
    }
}
