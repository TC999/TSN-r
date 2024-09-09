package defpackage;

import io.github.libxposed.api.utils.DexParser;
import java.nio.ByteBuffer;

/* renamed from: Q  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class Q extends Y implements DexParser.Element {

    /* renamed from: c  reason: collision with root package name */
    public final DexParser.StringId f54c;

    public Q(Z z3, int i4, int i5, ByteBuffer byteBuffer) {
        super(i5, byteBuffer);
        this.f54c = z3.f90b[i4];
    }

    @Override // io.github.libxposed.api.utils.DexParser.Element
    public final DexParser.StringId getName() {
        return this.f54c;
    }
}
