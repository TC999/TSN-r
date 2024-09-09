package defpackage;

import io.github.libxposed.api.utils.DexParser;
import java.nio.ByteBuffer;

/* renamed from: O  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class O implements DexParser.Annotation {

    /* renamed from: a  reason: collision with root package name */
    public final int f49a;

    /* renamed from: b  reason: collision with root package name */
    public final DexParser.TypeId f50b;

    /* renamed from: c  reason: collision with root package name */
    public final DexParser.Element[] f51c;

    public O(Z z3, int i4, int i5, int[] iArr, Object[] objArr) {
        this.f49a = i4;
        this.f50b = z3.f91c[i5];
        this.f51c = new DexParser.Element[objArr.length];
        for (int i6 = 0; i6 < objArr.length; i6++) {
            int i7 = i6 * 2;
            this.f51c[i6] = new Q(z3, iArr[i7], iArr[i7 + 1], (ByteBuffer) objArr[i6]);
        }
    }

    @Override // io.github.libxposed.api.utils.DexParser.Annotation
    public final DexParser.Element[] getElements() {
        return this.f51c;
    }

    @Override // io.github.libxposed.api.utils.DexParser.Annotation
    public final DexParser.TypeId getType() {
        return this.f50b;
    }

    @Override // io.github.libxposed.api.utils.DexParser.Annotation
    public final int getVisibility() {
        return this.f49a;
    }
}
