package defpackage;

import io.github.libxposed.api.utils.DexParser;
import java.nio.ByteBuffer;

/* renamed from: Y  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public class Y implements DexParser.Value {

    /* renamed from: a  reason: collision with root package name */
    public final int f87a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f88b;

    public Y(int i4, ByteBuffer byteBuffer) {
        this.f87a = i4;
        if (byteBuffer == null) {
            this.f88b = null;
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.f88b = bArr;
        byteBuffer.get(bArr);
    }

    @Override // io.github.libxposed.api.utils.DexParser.Value
    public final byte[] getValue() {
        return this.f88b;
    }

    @Override // io.github.libxposed.api.utils.DexParser.Value
    public final int getValueType() {
        return this.f87a;
    }
}
