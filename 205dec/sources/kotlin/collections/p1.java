package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: UArraySorting.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a*\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a*\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\t\u001a*\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u000e\u001a*\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0013\u001a*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lkotlin/o0;", "array", "", "left", "right", "b", "([BII)I", "Lkotlin/f1;", "f", "([BII)V", "Lkotlin/c1;", "c", "([SII)I", "g", "([SII)V", "Lkotlin/s0;", "d", "([III)I", "h", "([III)V", "Lkotlin/w0;", "a", "([JII)I", "e", "([JII)V", "fromIndex", "toIndex", "j", "k", "l", "i", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p1 {
    @ExperimentalUnsignedTypes
    private static final int a(long[] jArr, int i4, int i5) {
        long q3 = kotlin.w0.q(jArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (kotlin.g1.g(kotlin.w0.q(jArr, i4), q3) < 0) {
                i4++;
            }
            while (kotlin.g1.g(kotlin.w0.q(jArr, i5), q3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                long q4 = kotlin.w0.q(jArr, i4);
                kotlin.w0.y(jArr, i4, kotlin.w0.q(jArr, i5));
                kotlin.w0.y(jArr, i5, q4);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    private static final int b(byte[] bArr, int i4, int i5) {
        int i6;
        byte q3 = kotlin.o0.q(bArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (true) {
                i6 = q3 & 255;
                if (kotlin.jvm.internal.f0.t(kotlin.o0.q(bArr, i4) & 255, i6) >= 0) {
                    break;
                }
                i4++;
            }
            while (kotlin.jvm.internal.f0.t(kotlin.o0.q(bArr, i5) & 255, i6) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                byte q4 = kotlin.o0.q(bArr, i4);
                kotlin.o0.y(bArr, i4, kotlin.o0.q(bArr, i5));
                kotlin.o0.y(bArr, i5, q4);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    private static final int c(short[] sArr, int i4, int i5) {
        int i6;
        short q3 = kotlin.c1.q(sArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (true) {
                i6 = q3 & 65535;
                if (kotlin.jvm.internal.f0.t(kotlin.c1.q(sArr, i4) & 65535, i6) >= 0) {
                    break;
                }
                i4++;
            }
            while (kotlin.jvm.internal.f0.t(kotlin.c1.q(sArr, i5) & 65535, i6) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                short q4 = kotlin.c1.q(sArr, i4);
                kotlin.c1.y(sArr, i4, kotlin.c1.q(sArr, i5));
                kotlin.c1.y(sArr, i5, q4);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    private static final int d(int[] iArr, int i4, int i5) {
        int q3 = kotlin.s0.q(iArr, (i4 + i5) / 2);
        while (i4 <= i5) {
            while (kotlin.g1.c(kotlin.s0.q(iArr, i4), q3) < 0) {
                i4++;
            }
            while (kotlin.g1.c(kotlin.s0.q(iArr, i5), q3) > 0) {
                i5--;
            }
            if (i4 <= i5) {
                int q4 = kotlin.s0.q(iArr, i4);
                kotlin.s0.y(iArr, i4, kotlin.s0.q(iArr, i5));
                kotlin.s0.y(iArr, i5, q4);
                i4++;
                i5--;
            }
        }
        return i4;
    }

    @ExperimentalUnsignedTypes
    private static final void e(long[] jArr, int i4, int i5) {
        int a4 = a(jArr, i4, i5);
        int i6 = a4 - 1;
        if (i4 < i6) {
            e(jArr, i4, i6);
        }
        if (a4 < i5) {
            e(jArr, a4, i5);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void f(byte[] bArr, int i4, int i5) {
        int b4 = b(bArr, i4, i5);
        int i6 = b4 - 1;
        if (i4 < i6) {
            f(bArr, i4, i6);
        }
        if (b4 < i5) {
            f(bArr, b4, i5);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void g(short[] sArr, int i4, int i5) {
        int c4 = c(sArr, i4, i5);
        int i6 = c4 - 1;
        if (i4 < i6) {
            g(sArr, i4, i6);
        }
        if (c4 < i5) {
            g(sArr, c4, i5);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void h(int[] iArr, int i4, int i5) {
        int d4 = d(iArr, i4, i5);
        int i6 = d4 - 1;
        if (i4 < i6) {
            h(iArr, i4, i6);
        }
        if (d4 < i5) {
            h(iArr, d4, i5);
        }
    }

    @ExperimentalUnsignedTypes
    public static final void i(@NotNull long[] array, int i4, int i5) {
        kotlin.jvm.internal.f0.p(array, "array");
        e(array, i4, i5 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void j(@NotNull byte[] array, int i4, int i5) {
        kotlin.jvm.internal.f0.p(array, "array");
        f(array, i4, i5 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void k(@NotNull short[] array, int i4, int i5) {
        kotlin.jvm.internal.f0.p(array, "array");
        g(array, i4, i5 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void l(@NotNull int[] array, int i4, int i5) {
        kotlin.jvm.internal.f0.p(array, "array");
        h(array, i4, i5 - 1);
    }
}
