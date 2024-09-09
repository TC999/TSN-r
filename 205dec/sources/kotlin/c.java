package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CharCode.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u0011\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\"\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"", "code", "", "a", "b", "(C)I", "getCode$annotations", "(C)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char a(int i4) {
        if (i4 < 0 || i4 > 65535) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Invalid Char code: ", Integer.valueOf(i4)));
        }
        return (char) i4;
    }

    private static final int b(char c4) {
        return c4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static /* synthetic */ void c(char c4) {
    }
}
