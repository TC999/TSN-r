package kotlin.collections;

import com.beizi.fusion.widget.ScrollClickView;
import com.kuaishou.weapon.p205p0.C7304t;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unsigned;
import kotlin.UnsignedUtils;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a*\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a*\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\t\u001a*\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000e\u001a*\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013\u001a*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m12616d2 = {"Lkotlin/o0;", "array", "", ScrollClickView.DIR_LEFT, ScrollClickView.DIR_RIGHT, "b", "([BII)I", "Lkotlin/f1;", "f", "([BII)V", "Lkotlin/c1;", "c", "([SII)I", "g", "([SII)V", "Lkotlin/s0;", "d", "([III)I", "h", "([III)V", "Lkotlin/w0;", "a", "([JII)I", "e", "([JII)V", "fromIndex", "toIndex", "j", "k", C7304t.f25048d, "i", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.o1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UArraySorting {
    @Unsigned
    /* renamed from: a */
    private static final int m11778a(long[] jArr, int i, int i2) {
        long m5824k = ULongArray.m5824k(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedUtils.m8557g(ULongArray.m5824k(jArr, i), m5824k) < 0) {
                i++;
            }
            while (UnsignedUtils.m8557g(ULongArray.m5824k(jArr, i2), m5824k) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m5824k2 = ULongArray.m5824k(jArr, i);
                ULongArray.m5817r(jArr, i, ULongArray.m5824k(jArr, i2));
                ULongArray.m5817r(jArr, i2, m5824k2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @Unsigned
    /* renamed from: b */
    private static final int m11777b(byte[] bArr, int i, int i2) {
        int i3;
        byte m7748k = UByteArray.m7748k(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m7748k2 = UByteArray.m7748k(bArr, i) & UByte.f41242c;
                i3 = m7748k & UByte.f41242c;
                if (C14342f0.m8180t(m7748k2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (C14342f0.m8180t(UByteArray.m7748k(bArr, i2) & UByte.f41242c, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m7748k3 = UByteArray.m7748k(bArr, i);
                UByteArray.m7741r(bArr, i, UByteArray.m7748k(bArr, i2));
                UByteArray.m7741r(bArr, i2, m7748k3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @Unsigned
    /* renamed from: c */
    private static final int m11776c(short[] sArr, int i, int i2) {
        int i3;
        short m12492k = UShortArray.m12492k(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m12492k2 = UShortArray.m12492k(sArr, i) & UShort.f40820c;
                i3 = m12492k & UShort.f40820c;
                if (C14342f0.m8180t(m12492k2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (C14342f0.m8180t(UShortArray.m12492k(sArr, i2) & UShort.f40820c, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m12492k3 = UShortArray.m12492k(sArr, i);
                UShortArray.m12485r(sArr, i, UShortArray.m12492k(sArr, i2));
                UShortArray.m12485r(sArr, i2, m12492k3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @Unsigned
    /* renamed from: d */
    private static final int m11775d(int[] iArr, int i, int i2) {
        int m7284k = UIntArray.m7284k(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedUtils.m8561c(UIntArray.m7284k(iArr, i), m7284k) < 0) {
                i++;
            }
            while (UnsignedUtils.m8561c(UIntArray.m7284k(iArr, i2), m7284k) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m7284k2 = UIntArray.m7284k(iArr, i);
                UIntArray.m7277r(iArr, i, UIntArray.m7284k(iArr, i2));
                UIntArray.m7277r(iArr, i2, m7284k2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @Unsigned
    /* renamed from: e */
    private static final void m11774e(long[] jArr, int i, int i2) {
        int m11778a = m11778a(jArr, i, i2);
        int i3 = m11778a - 1;
        if (i < i3) {
            m11774e(jArr, i, i3);
        }
        if (m11778a < i2) {
            m11774e(jArr, m11778a, i2);
        }
    }

    @Unsigned
    /* renamed from: f */
    private static final void m11773f(byte[] bArr, int i, int i2) {
        int m11777b = m11777b(bArr, i, i2);
        int i3 = m11777b - 1;
        if (i < i3) {
            m11773f(bArr, i, i3);
        }
        if (m11777b < i2) {
            m11773f(bArr, m11777b, i2);
        }
    }

    @Unsigned
    /* renamed from: g */
    private static final void m11772g(short[] sArr, int i, int i2) {
        int m11776c = m11776c(sArr, i, i2);
        int i3 = m11776c - 1;
        if (i < i3) {
            m11772g(sArr, i, i3);
        }
        if (m11776c < i2) {
            m11772g(sArr, m11776c, i2);
        }
    }

    @Unsigned
    /* renamed from: h */
    private static final void m11771h(int[] iArr, int i, int i2) {
        int m11775d = m11775d(iArr, i, i2);
        int i3 = m11775d - 1;
        if (i < i3) {
            m11771h(iArr, i, i3);
        }
        if (m11775d < i2) {
            m11771h(iArr, m11775d, i2);
        }
    }

    @Unsigned
    /* renamed from: i */
    public static final void m11770i(@NotNull long[] array, int i, int i2) {
        C14342f0.m8184p(array, "array");
        m11774e(array, i, i2 - 1);
    }

    @Unsigned
    /* renamed from: j */
    public static final void m11769j(@NotNull byte[] array, int i, int i2) {
        C14342f0.m8184p(array, "array");
        m11773f(array, i, i2 - 1);
    }

    @Unsigned
    /* renamed from: k */
    public static final void m11768k(@NotNull short[] array, int i, int i2) {
        C14342f0.m8184p(array, "array");
        m11772g(array, i, i2 - 1);
    }

    @Unsigned
    /* renamed from: l */
    public static final void m11767l(@NotNull int[] array, int i, int i2) {
        C14342f0.m8184p(array, "array");
        m11771h(array, i, i2 - 1);
    }
}
