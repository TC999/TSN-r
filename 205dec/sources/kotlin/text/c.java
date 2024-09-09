package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Char.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\f\u0010\t\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0000H\u0007\u001a\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bH\u0087\n\u001a\u001c\u0010\u0011\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u001a\n\u0010\u0012\u001a\u00020\u000f*\u00020\u0000\u00a8\u0006\u0013"}, d2 = {"", "", "F", "radix", "G", "H", "(C)Ljava/lang/Integer;", "I", "(CI)Ljava/lang/Integer;", "D", "E", "", "N", "other", "M", "", "ignoreCase", "J", "L", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/CharsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c extends b {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char D(int i4) {
        boolean z3 = false;
        if (i4 >= 0 && i4 < 10) {
            z3 = true;
        }
        if (z3) {
            return (char) (i4 + 48);
        }
        throw new IllegalArgumentException("Int " + i4 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char E(int i4, int i5) {
        boolean z3 = false;
        if (2 <= i5 && i5 < 37) {
            z3 = true;
        }
        if (!z3) {
            throw new IllegalArgumentException("Invalid radix: " + i5 + ". Valid radix values are in range 2..36");
        } else if (i4 >= 0 && i4 < i5) {
            return (char) (i4 < 10 ? i4 + 48 : ((char) (i4 + 65)) - '\n');
        } else {
            throw new IllegalArgumentException("Digit " + i4 + " does not represent a valid digit in radix " + i5);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int F(char c4) {
        int b4 = b.b(c4, 10);
        if (b4 >= 0) {
            return b4;
        }
        throw new IllegalArgumentException("Char " + c4 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int G(char c4, int i4) {
        Integer I = I(c4, i4);
        if (I != null) {
            return I.intValue();
        }
        throw new IllegalArgumentException("Char " + c4 + " is not a digit in the given radix=" + i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer H(char c4) {
        Integer valueOf = Integer.valueOf(b.b(c4, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer I(char c4, int i4) {
        b.a(i4);
        Integer valueOf = Integer.valueOf(b.b(c4, i4));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final boolean J(char c4, char c5, boolean z3) {
        if (c4 == c5) {
            return true;
        }
        if (z3) {
            char upperCase = Character.toUpperCase(c4);
            char upperCase2 = Character.toUpperCase(c5);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    public static /* synthetic */ boolean K(char c4, char c5, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return J(c4, c5, z3);
    }

    public static final boolean L(char c4) {
        return '\ud800' <= c4 && c4 < '\ue000';
    }

    @InlineOnly
    private static final String M(char c4, String other) {
        f0.p(other, "other");
        return c4 + other;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String N(char c4) {
        return e0.a(c4);
    }
}
