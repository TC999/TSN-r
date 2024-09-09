package y1;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: bitwiseOperations.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\r\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\f\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u00a8\u0006\u000b"}, d2 = {"", "other", "a", "e", "g", "c", "", "b", "f", "h", "d", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte a(byte b4, byte b5) {
        return (byte) (b4 & b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short b(short s3, short s4) {
        return (short) (s3 & s4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte c(byte b4) {
        return (byte) (b4 ^ (-1));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short d(short s3) {
        return (short) (s3 ^ (-1));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte e(byte b4, byte b5) {
        return (byte) (b4 | b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short f(short s3, short s4) {
        return (short) (s3 | s4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte g(byte b4, byte b5) {
        return (byte) (b4 ^ b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short h(short s3, short s4) {
        return (short) (s3 ^ s4);
    }
}
