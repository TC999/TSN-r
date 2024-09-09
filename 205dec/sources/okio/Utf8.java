package okio;

import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Utf8.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\f\n\u0002\b\u0010\u001a'\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0080\b\u001a4\u0010\u0011\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0013\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0015\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0016\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b\u00f8\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b\u00f8\u0001\u0000\"\u0014\u0010\u0019\u001a\u00020\u000b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001b\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u00018\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\u00018\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001e\"\u0014\u0010 \u001a\u00020\u00018\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b \u0010\u001e\"\u0014\u0010!\u001a\u00020\u00018\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001e\"\u0014\u0010\"\u001a\u00020\u00018\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001e\"\u0014\u0010#\u001a\u00020\u00018\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006$"}, d2 = {"", "", "beginIndex", "endIndex", "", "size", "(Ljava/lang/String;II)J", "utf8Size", "codePoint", "", "isIsoControl", "", "byte", "isUtf8Continuation", "Lkotlin/Function1;", "Lkotlin/f1;", "yield", "processUtf8Bytes", "", "processUtf8CodePoints", "", "processUtf16Chars", "process2Utf8Bytes", "process3Utf8Bytes", "process4Utf8Bytes", "REPLACEMENT_BYTE", "B", "REPLACEMENT_CHARACTER", "C", "REPLACEMENT_CODE_POINT", "I", "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Utf8")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '\ufffd';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i4) {
        return (i4 >= 0 && 31 >= i4) || (127 <= i4 && 159 >= i4);
    }

    public static final boolean isUtf8Continuation(byte b4) {
        return (b4 & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] process2Utf8Bytes, int i4, int i5, @NotNull l<? super Integer, f1> yield) {
        f0.p(process2Utf8Bytes, "$this$process2Utf8Bytes");
        f0.p(yield, "yield");
        int i6 = i4 + 1;
        if (i5 <= i6) {
            yield.invoke(65533);
            return 1;
        }
        byte b4 = process2Utf8Bytes[i4];
        byte b5 = process2Utf8Bytes[i6];
        if (!((b5 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        int i7 = (b5 ^ 3968) ^ (b4 << 6);
        if (i7 < 128) {
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(Integer.valueOf(i7));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] process3Utf8Bytes, int i4, int i5, @NotNull l<? super Integer, f1> yield) {
        f0.p(process3Utf8Bytes, "$this$process3Utf8Bytes");
        f0.p(yield, "yield");
        int i6 = i4 + 2;
        if (i5 <= i6) {
            yield.invoke(65533);
            int i7 = i4 + 1;
            if (i5 > i7) {
                if ((process3Utf8Bytes[i7] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b4 = process3Utf8Bytes[i4];
        byte b5 = process3Utf8Bytes[i4 + 1];
        if (!((b5 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        byte b6 = process3Utf8Bytes[i6];
        if (!((b6 & 192) == 128)) {
            yield.invoke(65533);
            return 2;
        }
        int i8 = ((b6 ^ (-123008)) ^ (b5 << 6)) ^ (b4 << 12);
        if (i8 < 2048) {
            yield.invoke(65533);
            return 3;
        } else if (55296 <= i8 && 57343 >= i8) {
            yield.invoke(65533);
            return 3;
        } else {
            yield.invoke(Integer.valueOf(i8));
            return 3;
        }
    }

    public static final int process4Utf8Bytes(@NotNull byte[] process4Utf8Bytes, int i4, int i5, @NotNull l<? super Integer, f1> yield) {
        f0.p(process4Utf8Bytes, "$this$process4Utf8Bytes");
        f0.p(yield, "yield");
        int i6 = i4 + 3;
        if (i5 <= i6) {
            yield.invoke(65533);
            int i7 = i4 + 1;
            if (i5 > i7) {
                if ((process4Utf8Bytes[i7] & 192) == 128) {
                    int i8 = i4 + 2;
                    if (i5 > i8) {
                        if ((process4Utf8Bytes[i8] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b4 = process4Utf8Bytes[i4];
        byte b5 = process4Utf8Bytes[i4 + 1];
        if (!((b5 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        byte b6 = process4Utf8Bytes[i4 + 2];
        if (!((b6 & 192) == 128)) {
            yield.invoke(65533);
            return 2;
        }
        byte b7 = process4Utf8Bytes[i6];
        if (!((b7 & 192) == 128)) {
            yield.invoke(65533);
            return 3;
        }
        int i9 = (((b7 ^ 3678080) ^ (b6 << 6)) ^ (b5 << 12)) ^ (b4 << 18);
        if (i9 > 1114111) {
            yield.invoke(65533);
            return 4;
        } else if (55296 <= i9 && 57343 >= i9) {
            yield.invoke(65533);
            return 4;
        } else if (i9 < 65536) {
            yield.invoke(65533);
            return 4;
        } else {
            yield.invoke(Integer.valueOf(i9));
            return 4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0119, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf16Chars(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull d2.l<? super java.lang.Character, kotlin.f1> r19) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, d2.l):void");
    }

    public static final void processUtf8Bytes(@NotNull String processUtf8Bytes, int i4, int i5, @NotNull l<? super Byte, f1> yield) {
        int i6;
        char charAt;
        f0.p(processUtf8Bytes, "$this$processUtf8Bytes");
        f0.p(yield, "yield");
        while (i4 < i5) {
            char charAt2 = processUtf8Bytes.charAt(i4);
            if (f0.t(charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i4++;
                while (i4 < i5 && f0.t(processUtf8Bytes.charAt(i4), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) processUtf8Bytes.charAt(i4)));
                    i4++;
                }
            } else {
                if (f0.t(charAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if ('\ud800' <= charAt2 && '\udfff' >= charAt2) {
                    if (f0.t(charAt2, 56319) <= 0 && i5 > (i6 = i4 + 1) && '\udc00' <= (charAt = processUtf8Bytes.charAt(i6)) && '\udfff' >= charAt) {
                        int charAt3 = ((charAt2 << '\n') + processUtf8Bytes.charAt(i6)) - 56613888;
                        yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                        i4 += 2;
                    } else {
                        yield.invoke((byte) 63);
                    }
                } else {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                }
                i4++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0096, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0117, code lost:
        if (((r16[r4] & 192) == 128) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf8CodePoints(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull d2.l<? super java.lang.Integer, kotlin.f1> r19) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, d2.l):void");
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        return size$default(str, 0, 0, 3, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i4) {
        return size$default(str, i4, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String utf8Size, int i4, int i5) {
        int i6;
        f0.p(utf8Size, "$this$utf8Size");
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (i5 >= i4) {
            if (!(i5 <= utf8Size.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + utf8Size.length()).toString());
            }
            long j4 = 0;
            while (i4 < i5) {
                char charAt = utf8Size.charAt(i4);
                if (charAt < '\u0080') {
                    j4++;
                } else {
                    if (charAt < '\u0800') {
                        i6 = 2;
                    } else if (charAt < '\ud800' || charAt > '\udfff') {
                        i6 = 3;
                    } else {
                        int i7 = i4 + 1;
                        char charAt2 = i7 < i5 ? utf8Size.charAt(i7) : (char) 0;
                        if (charAt > '\udbff' || charAt2 < '\udc00' || charAt2 > '\udfff') {
                            j4++;
                            i4 = i7;
                        } else {
                            j4 += 4;
                            i4 += 2;
                        }
                    }
                    j4 += i6;
                }
                i4++;
            }
            return j4;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
    }

    public static /* synthetic */ long size$default(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return size(str, i4, i5);
    }
}
