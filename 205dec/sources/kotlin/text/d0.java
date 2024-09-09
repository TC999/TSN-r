package kotlin.text;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.n0;
import kotlin.r0;
import kotlin.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UStrings.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u001e\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u001e\u0010\r\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u0016\u0010\u000f\u001a\u00020\u0000*\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0006*\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\t*\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u00020\f*\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001d\u001a\u00020\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010 \u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010!\u001a\u0004\u0018\u00010\u0006*\u00020\u0003H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\"\u001a\u0004\u0018\u00010\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010#\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010$\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010%\u001a\u0004\u0018\u00010\f*\u00020\u0003H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010&\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lkotlin/n0;", "", "radix", "", "b", "(BI)Ljava/lang/String;", "Lkotlin/b1;", "d", "(SI)Ljava/lang/String;", "Lkotlin/r0;", "c", "(II)Ljava/lang/String;", "Lkotlin/v0;", "a", "(JI)Ljava/lang/String;", "e", "(Ljava/lang/String;)B", "f", "(Ljava/lang/String;I)B", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/String;)S", "r", "(Ljava/lang/String;I)S", "i", "(Ljava/lang/String;)I", "j", "(Ljava/lang/String;I)I", "m", "(Ljava/lang/String;)J", "n", "(Ljava/lang/String;I)J", "g", "h", "s", "t", "k", "l", "o", "p", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "UStringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d0 {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String a(long j4, int i4) {
        int a4;
        a4 = b.a(i4);
        return g1.l(j4, a4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String b(byte b4, int i4) {
        int a4;
        a4 = b.a(i4);
        String num = Integer.toString(b4 & 255, a4);
        f0.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String c(int i4, int i5) {
        int a4;
        a4 = b.a(i5);
        String l4 = Long.toString(i4 & 4294967295L, a4);
        f0.o(l4, "toString(this, checkRadix(radix))");
        return l4;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final String d(short s3, int i4) {
        int a4;
        a4 = b.a(i4);
        String num = Integer.toString(s3 & 65535, a4);
        f0.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte e(@NotNull String str) {
        f0.p(str, "<this>");
        n0 g4 = g(str);
        if (g4 != null) {
            return g4.j0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte f(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        n0 h4 = h(str, i4);
        if (h4 != null) {
            return h4.j0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final n0 g(@NotNull String str) {
        f0.p(str, "<this>");
        return h(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final n0 h(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        r0 l4 = l(str, i4);
        if (l4 == null) {
            return null;
        }
        int l02 = l4.l0();
        if (g1.c(l02, r0.i(255)) > 0) {
            return null;
        }
        return n0.b(n0.i((byte) l02));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int i(@NotNull String str) {
        f0.p(str, "<this>");
        r0 k4 = k(str);
        if (k4 != null) {
            return k4.l0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int j(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        r0 l4 = l(str, i4);
        if (l4 != null) {
            return l4.l0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final r0 k(@NotNull String str) {
        f0.p(str, "<this>");
        return l(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final r0 l(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        b.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char charAt = str.charAt(0);
        int i6 = 1;
        if (f0.t(charAt, 48) >= 0) {
            i6 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int i7 = r0.i(i4);
        int i8 = 119304647;
        while (i6 < length) {
            int i9 = i6 + 1;
            int b4 = b.b(str.charAt(i6), i4);
            if (b4 < 0) {
                return null;
            }
            if (g1.c(i5, i8) > 0) {
                if (i8 == 119304647) {
                    i8 = g1.d(-1, i7);
                    if (g1.c(i5, i8) > 0) {
                    }
                }
                return null;
            }
            int i10 = r0.i(i5 * i7);
            int i11 = r0.i(r0.i(b4) + i10);
            if (g1.c(i11, i10) < 0) {
                return null;
            }
            i5 = i11;
            i6 = i9;
        }
        return r0.b(i5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long m(@NotNull String str) {
        f0.p(str, "<this>");
        v0 o4 = o(str);
        if (o4 != null) {
            return o4.l0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long n(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        v0 p3 = p(str, i4);
        if (p3 != null) {
            return p3.l0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final v0 o(@NotNull String str) {
        f0.p(str, "<this>");
        return p(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final v0 p(@NotNull String str, int i4) {
        int b4;
        f0.p(str, "<this>");
        b.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j4 = -1;
        int i5 = 0;
        char charAt = str.charAt(0);
        if (f0.t(charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i5 = 1;
        }
        long i6 = v0.i(i4);
        long j5 = 0;
        long j6 = 512409557603043100L;
        while (i5 < length) {
            int i7 = i5 + 1;
            if (b.b(str.charAt(i5), i4) < 0) {
                return null;
            }
            if (g1.g(j5, j6) > 0) {
                if (j6 == 512409557603043100L) {
                    j6 = g1.h(j4, i6);
                    if (g1.g(j5, j6) > 0) {
                    }
                }
                return null;
            }
            long i8 = v0.i(j5 * i6);
            long i9 = v0.i(v0.i(r0.i(b4) & 4294967295L) + i8);
            if (g1.g(i9, i8) < 0) {
                return null;
            }
            j5 = i9;
            i5 = i7;
            j4 = -1;
        }
        return v0.b(j5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short q(@NotNull String str) {
        f0.p(str, "<this>");
        b1 s3 = s(str);
        if (s3 != null) {
            return s3.j0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short r(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        b1 t3 = t(str, i4);
        if (t3 != null) {
            return t3.j0();
        }
        v.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final b1 s(@NotNull String str) {
        f0.p(str, "<this>");
        return t(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @Nullable
    public static final b1 t(@NotNull String str, int i4) {
        f0.p(str, "<this>");
        r0 l4 = l(str, i4);
        if (l4 == null) {
            return null;
        }
        int l02 = l4.l0();
        if (g1.c(l02, r0.i(65535)) > 0) {
            return null;
        }
        return b1.b(b1.i((short) l02));
    }
}
