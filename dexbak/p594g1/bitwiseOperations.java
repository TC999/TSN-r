package p594g1;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\r\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\f\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0006H\u0087\b¨\u0006\u000b"}, m12616d2 = {"", AdnName.OTHER, "a", "e", "g", "c", "", "b", "f", "h", "d", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: g1.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class bitwiseOperations {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: a */
    private static final byte m12739a(byte b, byte b2) {
        return (byte) (b & b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: b */
    private static final short m12738b(short s, short s2) {
        return (short) (s & s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: c */
    private static final byte m12737c(byte b) {
        return (byte) (b ^ (-1));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: d */
    private static final short m12736d(short s) {
        return (short) (s ^ (-1));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: e */
    private static final byte m12735e(byte b, byte b2) {
        return (byte) (b | b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: f */
    private static final short m12734f(short s, short s2) {
        return (short) (s | s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: g */
    private static final byte m12733g(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: h */
    private static final short m12732h(short s, short s2) {
        return (short) (s ^ s2);
    }
}
