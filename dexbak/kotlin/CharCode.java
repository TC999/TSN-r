package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14356p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u0011\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\"\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m12616d2 = {"", "code", "", "a", "c", "(C)I", "getCode$annotations", "(C)V", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CharCode {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: a */
    private static final char m12509a(int i) {
        if (i < m12507c((char) 0) || i > m12507c(C14356p.f41165b)) {
            throw new IllegalArgumentException("Invalid Char code: " + i);
        }
        return (char) i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final int m12507c(char c) {
        return c;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: d */
    public static /* synthetic */ void m12506d(char c) {
    }
}
