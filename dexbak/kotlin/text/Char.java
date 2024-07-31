package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\f\u0010\t\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0000H\u0007\u001a\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bH\u0087\n\u001a\u001c\u0010\u0011\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u001a\n\u0010\u0012\u001a\u00020\u000f*\u00020\u0000¨\u0006\u0013"}, m12616d2 = {"", "", "F", "radix", "G", "H", "(C)Ljava/lang/Integer;", "I", "(CI)Ljava/lang/Integer;", "D", ExifInterface.LONGITUDE_EAST, "", "N", AdnName.OTHER, "M", "", "ignoreCase", "J", "L", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/CharsKt")
/* renamed from: kotlin.text.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Char extends CharJVM {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: D */
    public static final char m6864D(int i) {
        if (i < 0 || 9 < i) {
            throw new IllegalArgumentException("Int " + i + " is not a decimal digit");
        }
        return (char) (i + 48);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: E */
    public static final char m6863E(int i, int i2) {
        if (2 > i2 || 36 < i2) {
            throw new IllegalArgumentException("Invalid radix: " + i2 + ". Valid radix values are in range 2..36");
        } else if (i >= 0 && i < i2) {
            return (char) (i < 10 ? i + 48 : ((char) (i + 65)) - '\n');
        } else {
            throw new IllegalArgumentException("Digit " + i + " does not represent a valid digit in radix " + i2);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: F */
    public static final int m6862F(char c) {
        int m6892b = CharJVM.m6892b(c, 10);
        if (m6892b >= 0) {
            return m6892b;
        }
        throw new IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: G */
    public static final int m6861G(char c, int i) {
        Integer m6859I = m6859I(c, i);
        if (m6859I != null) {
            return m6859I.intValue();
        }
        throw new IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: H */
    public static final Integer m6860H(char c) {
        Integer valueOf = Integer.valueOf(CharJVM.m6892b(c, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    /* renamed from: I */
    public static final Integer m6859I(char c, int i) {
        CharJVM.m6893a(i);
        Integer valueOf = Integer.valueOf(CharJVM.m6892b(c, i));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    /* renamed from: J */
    public static final boolean m6858J(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    /* renamed from: K */
    public static /* synthetic */ boolean m6857K(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6858J(c, c2, z);
    }

    /* renamed from: L */
    public static final boolean m6856L(char c) {
        return 55296 <= c && 57343 >= c;
    }

    @InlineOnly
    /* renamed from: M */
    private static final String m6855M(char c, String str) {
        return String.valueOf(c) + str;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    /* renamed from: N */
    public static final String m6854N(char c) {
        return _OneToManyTitlecaseMappings.m6829a(c);
    }
}
