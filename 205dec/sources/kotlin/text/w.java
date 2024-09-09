package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.r0;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StringsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0086\u0001\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a\u001d\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a\u001d\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a\u001d\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a \u0010\r\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\r\u0010\u0016\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\f\u0010\u001b\u001a\u00020\u0000*\u00020\u001aH\u0007\u001a \u0010\u001e\u001a\u00020\u0000*\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0007\u001a \u0010\u001f\u001a\u00020\u001a*\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0007\u001a\f\u0010!\u001a\u00020\u0000*\u00020 H\u0007\u001a*\u0010#\u001a\u00020\u0000*\u00020 2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u000bH\u0007\u001a\f\u0010$\u001a\u00020 *\u00020\u0000H\u0007\u001a*\u0010%\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u000bH\u0007\u001a\r\u0010&\u001a\u00020\u001a*\u00020\u0000H\u0087\b\u001a3\u0010)\u001a\u00020\u001a*\u00020\u00002\u0006\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0087\b\u001a,\u0010-\u001a\u00020\u0000*\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b\u00a2\u0006\u0004\b-\u0010.\u001a4\u00101\u001a\u00020\u0000*\u00020/2\u0006\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b\u00a2\u0006\u0004\b1\u00102\u001a4\u00105\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u0002032\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b\u00a2\u0006\u0004\b5\u00106\u001a6\u00107\u001a\u00020\u0000*\u00020\u00002\b\u00104\u001a\u0004\u0018\u0001032\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b\u00a2\u0006\u0004\b7\u00106\u001a<\u00108\u001a\u00020\u0000*\u00020/2\u0006\u00104\u001a\u0002032\u0006\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b\u00a2\u0006\u0004\b8\u00109\u001a>\u0010:\u001a\u00020\u0000*\u00020/2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b\u00a2\u0006\u0004\b:\u00109\u001a\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00000?*\u00020;2\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020\u0003\u001a\u0015\u0010A\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0003H\u0087\b\u001a\u001d\u0010B\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0087\b\u001a\u001c\u0010D\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010E\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u001c\u0010G\u001a\u00020\u000b*\u00020\u00002\u0006\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a)\u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010L\u001a\u00020KH\u0087\b\u001a\u0019\u0010N\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 2\u0006\u0010L\u001a\u00020KH\u0087\b\u001a!\u0010O\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b\u001a\u0011\u0010P\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 H\u0087\b\u001a\u0011\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001aH\u0087\b\u001a!\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b\u001a!\u0010V\u001a\u00020\u00002\u0006\u0010U\u001a\u00020T2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b\u001a\u0011\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020WH\u0087\b\u001a\u0011\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020ZH\u0087\b\u001a\u0015\u0010^\u001a\u00020\u0003*\u00020\u00002\u0006\u0010]\u001a\u00020\u0003H\u0087\b\u001a\u0015\u0010_\u001a\u00020\u0003*\u00020\u00002\u0006\u0010]\u001a\u00020\u0003H\u0087\b\u001a\u001d\u0010a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010`\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0087\b\u001a\u001c\u0010b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u0015\u0010d\u001a\u00020\u000b*\u00020\u00002\u0006\u0010c\u001a\u00020;H\u0087\b\u001a\u0015\u0010e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010[\u001a\u00020WH\u0087\b\u001a\u0019\u0010f\u001a\u00020\u000b*\u0004\u0018\u00010;2\b\u0010\n\u001a\u0004\u0018\u00010;H\u0087\u0004\u001a \u0010g\u001a\u00020\u000b*\u0004\u0018\u00010;2\b\u0010\n\u001a\u0004\u0018\u00010;2\u0006\u0010\f\u001a\u00020\u000bH\u0007\u001a\r\u0010h\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\n\u0010i\u001a\u00020\u000b*\u00020;\u001a\u001d\u0010k\u001a\u00020\u0003*\u00020\u00002\u0006\u0010]\u001a\u00020\u00032\u0006\u0010j\u001a\u00020\u0003H\u0087\b\u001a4\u0010n\u001a\u00020\u000b*\u00020;2\u0006\u0010l\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020;2\u0006\u0010m\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a4\u0010o\u001a\u00020\u000b*\u00020\u00002\u0006\u0010l\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u0015\u0010p\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0015\u0010q\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0015\u0010r\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0015\u0010s\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0017\u0010t\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010L\u001a\u00020KH\u0087\b\u001a\u0017\u0010v\u001a\u00020<*\u00020\u00002\b\b\u0002\u0010u\u001a\u00020\u0003H\u0087\b\u001a\f\u0010w\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\u0014\u0010x\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0007\u001a\f\u0010y\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\u0014\u0010z\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0007\u001a\u0012\u0010|\u001a\u00020\u0000*\u00020;2\u0006\u0010{\u001a\u00020\u0003\"'\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00000}j\b\u0012\u0004\u0012\u00020\u0000`~*\u00020/8F\u00a2\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001\u00a8\u0006\u0082\u0001"}, d2 = {"", "", "ch", "", "fromIndex", "X1", "str", "Y1", "Z1", "a2", "other", "", "ignoreCase", "K1", "oldChar", "newChar", "h2", "oldValue", "newValue", "i2", "l2", "m2", "I2", "K2", "E2", "V1", "", "t1", "startIndex", "endIndex", "u1", "A2", "", "C1", "throwOnInvalidSequence", "D1", "F1", "G1", "z2", "destination", "destinationOffset", "B2", "", "", "args", "N1", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "format", "O1", "(Lkotlin/jvm/internal/s0;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "M1", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "Q1", "P1", "(Lkotlin/jvm/internal/s0;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "R1", "", "Ljava/util/regex/Pattern;", "regex", "limit", "", "p2", "v2", "w2", "prefix", "s2", "r2", "suffix", "I1", "bytes", "offset", "length", "Ljava/nio/charset/Charset;", "charset", "h1", "i1", "g1", "f1", "chars", "j1", "k1", "", "codePoints", "l1", "Ljava/lang/StringBuffer;", "stringBuffer", "d1", "Ljava/lang/StringBuilder;", "stringBuilder", "e1", "index", "o1", "p1", "beginIndex", "q1", "r1", "charSequence", "y1", "z1", "w1", "x1", "T1", "U1", "codePointOffset", "b2", "thisOffset", "otherOffset", "c2", "d2", "F2", "W1", "J2", "L2", "x2", "flags", "G2", "m1", "n1", "A1", "B1", "n", "g2", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "S1", "(Lkotlin/jvm/internal/s0;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class w extends v {
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    public static final String A1(@NotNull String str) {
        f0.p(str, "<this>");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        String substring = str.substring(0, 1);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String lowerCase = substring.toLowerCase();
        f0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        String substring2 = str.substring(1);
        f0.o(substring2, "this as java.lang.String).substring(startIndex)");
        return f0.C(lowerCase, substring2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final char[] A2(@NotNull String str, int i4, int i5) {
        f0.p(str, "<this>");
        kotlin.collections.c.Companion.a(i4, i5, str.length());
        char[] cArr = new char[i5 - i4];
        str.getChars(i4, i5, cArr, 0);
        return cArr;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String B1(@NotNull String str, @NotNull Locale locale) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        String substring = str.substring(0, 1);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String lowerCase = substring.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String substring2 = str.substring(1);
        f0.o(substring2, "this as java.lang.String).substring(startIndex)");
        return f0.C(lowerCase, substring2);
    }

    @InlineOnly
    private static final char[] B2(String str, char[] destination, int i4, int i5, int i6) {
        f0.p(str, "<this>");
        f0.p(destination, "destination");
        str.getChars(i5, i6, destination, i4);
        return destination;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String C1(@NotNull byte[] bArr) {
        f0.p(bArr, "<this>");
        return new String(bArr, d.f58930b);
    }

    public static /* synthetic */ char[] C2(String str, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        return A2(str, i4, i5);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String D1(@NotNull byte[] bArr, int i4, int i5, boolean z3) {
        f0.p(bArr, "<this>");
        kotlin.collections.c.Companion.a(i4, i5, bArr.length);
        if (!z3) {
            return new String(bArr, i4, i5 - i4, d.f58930b);
        }
        String charBuffer = d.f58930b.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i4, i5 - i4)).toString();
        f0.o(charBuffer, "decoder.decode(ByteBuffe\u2026- startIndex)).toString()");
        return charBuffer;
    }

    static /* synthetic */ char[] D2(String str, char[] destination, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = str.length();
        }
        f0.p(str, "<this>");
        f0.p(destination, "destination");
        str.getChars(i5, i6, destination, i4);
        return destination;
    }

    public static /* synthetic */ String E1(byte[] bArr, int i4, int i5, boolean z3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = bArr.length;
        }
        if ((i6 & 4) != 0) {
            z3 = false;
        }
        return D1(bArr, i4, i5, z3);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String E2(String str) {
        f0.p(str, "<this>");
        String lowerCase = str.toLowerCase();
        f0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final byte[] F1(@NotNull String str) {
        f0.p(str, "<this>");
        byte[] bytes = str.getBytes(d.f58930b);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String F2(String str, Locale locale) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final byte[] G1(@NotNull String str, int i4, int i5, boolean z3) {
        f0.p(str, "<this>");
        kotlin.collections.c.Companion.a(i4, i5, str.length());
        if (!z3) {
            String substring = str.substring(i4, i5);
            f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            byte[] bytes = substring.getBytes(d.f58930b);
            f0.o(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer encode = d.f58930b.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i4, i5));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            f0.m(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                f0.o(array2, "{\n        byteBuffer.array()\n    }");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @InlineOnly
    private static final Pattern G2(String str, int i4) {
        f0.p(str, "<this>");
        Pattern compile = Pattern.compile(str, i4);
        f0.o(compile, "compile(this, flags)");
        return compile;
    }

    public static /* synthetic */ byte[] H1(String str, int i4, int i5, boolean z3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            z3 = false;
        }
        return G1(str, i4, i5, z3);
    }

    static /* synthetic */ Pattern H2(String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        f0.p(str, "<this>");
        Pattern compile = Pattern.compile(str, i4);
        f0.o(compile, "compile(this, flags)");
        return compile;
    }

    public static boolean I1(@NotNull String str, @NotNull String suffix, boolean z3) {
        boolean d22;
        f0.p(str, "<this>");
        f0.p(suffix, "suffix");
        if (!z3) {
            return str.endsWith(suffix);
        }
        d22 = d2(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
        return d22;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String I2(String str) {
        f0.p(str, "<this>");
        String upperCase = str.toUpperCase();
        f0.o(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static /* synthetic */ boolean J1(String str, String str2, boolean z3, int i4, Object obj) {
        boolean I1;
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        I1 = I1(str, str2, z3);
        return I1;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String J2(String str, Locale locale) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static boolean K1(@Nullable String str, @Nullable String str2, boolean z3) {
        if (str == null) {
            return str2 == null;
        } else if (!z3) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String K2(String str) {
        f0.p(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    public static /* synthetic */ boolean L1(String str, String str2, boolean z3, int i4, Object obj) {
        boolean K1;
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        K1 = K1(str, str2, z3);
        return K1;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String L2(String str, Locale locale) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @InlineOnly
    private static final /* synthetic */ String M1(String str, Locale locale, Object... args) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        f0.p(args, "args");
        String format = String.format(locale, str, Arrays.copyOf(args, args.length));
        f0.o(format, "format(locale, this, *args)");
        return format;
    }

    @InlineOnly
    private static final String N1(String str, Object... args) {
        f0.p(str, "<this>");
        f0.p(args, "args");
        String format = String.format(str, Arrays.copyOf(args, args.length));
        f0.o(format, "format(this, *args)");
        return format;
    }

    @InlineOnly
    private static final String O1(s0 s0Var, String format, Object... args) {
        f0.p(s0Var, "<this>");
        f0.p(format, "format");
        f0.p(args, "args");
        String format2 = String.format(format, Arrays.copyOf(args, args.length));
        f0.o(format2, "format(format, *args)");
        return format2;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @InlineOnly
    private static final /* synthetic */ String P1(s0 s0Var, Locale locale, String format, Object... args) {
        f0.p(s0Var, "<this>");
        f0.p(locale, "locale");
        f0.p(format, "format");
        f0.p(args, "args");
        String format2 = String.format(locale, format, Arrays.copyOf(args, args.length));
        f0.o(format2, "format(locale, format, *args)");
        return format2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "formatNullable")
    private static final String Q1(String str, Locale locale, Object... args) {
        f0.p(str, "<this>");
        f0.p(args, "args");
        String format = String.format(locale, str, Arrays.copyOf(args, args.length));
        f0.o(format, "format(locale, this, *args)");
        return format;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "formatNullable")
    private static final String R1(s0 s0Var, Locale locale, String format, Object... args) {
        f0.p(s0Var, "<this>");
        f0.p(format, "format");
        f0.p(args, "args");
        String format2 = String.format(locale, format, Arrays.copyOf(args, args.length));
        f0.o(format2, "format(locale, format, *args)");
        return format2;
    }

    @NotNull
    public static Comparator<String> S1(@NotNull s0 s0Var) {
        f0.p(s0Var, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        f0.o(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    @InlineOnly
    private static final String T1(String str) {
        f0.p(str, "<this>");
        String intern = str.intern();
        f0.o(intern, "this as java.lang.String).intern()");
        return intern;
    }

    public static final boolean U1(@NotNull CharSequence charSequence) {
        kotlin.ranges.k h32;
        boolean r3;
        boolean z3;
        f0.p(charSequence, "<this>");
        if (charSequence.length() != 0) {
            h32 = x.h3(charSequence);
            if (!(h32 instanceof Collection) || !((Collection) h32).isEmpty()) {
                Iterator<Integer> it = h32.iterator();
                while (it.hasNext()) {
                    r3 = b.r(charSequence.charAt(((r0) it).nextInt()));
                    if (!r3) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (!z3) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String V1(String str) {
        f0.p(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String W1(String str, Locale locale) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @InlineOnly
    private static final int X1(String str, char c4, int i4) {
        f0.p(str, "<this>");
        return str.indexOf(c4, i4);
    }

    @InlineOnly
    private static final int Y1(String str, String str2, int i4) {
        f0.p(str, "<this>");
        f0.p(str2, "str");
        return str.indexOf(str2, i4);
    }

    @InlineOnly
    private static final int Z1(String str, char c4, int i4) {
        f0.p(str, "<this>");
        return str.lastIndexOf(c4, i4);
    }

    @InlineOnly
    private static final int a2(String str, String str2, int i4) {
        f0.p(str, "<this>");
        f0.p(str2, "str");
        return str.lastIndexOf(str2, i4);
    }

    @InlineOnly
    private static final int b2(String str, int i4, int i5) {
        f0.p(str, "<this>");
        return str.offsetByCodePoints(i4, i5);
    }

    public static final boolean c2(@NotNull CharSequence charSequence, int i4, @NotNull CharSequence other, int i5, int i6, boolean z3) {
        boolean d22;
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        if ((charSequence instanceof String) && (other instanceof String)) {
            d22 = d2((String) charSequence, i4, (String) other, i5, i6, z3);
            return d22;
        }
        return x.a4(charSequence, i4, other, i5, i6, z3);
    }

    @InlineOnly
    private static final String d1(StringBuffer stringBuffer) {
        f0.p(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    public static boolean d2(@NotNull String str, int i4, @NotNull String other, int i5, int i6, boolean z3) {
        f0.p(str, "<this>");
        f0.p(other, "other");
        if (!z3) {
            return str.regionMatches(i4, other, i5, i6);
        }
        return str.regionMatches(z3, i4, other, i5, i6);
    }

    @InlineOnly
    private static final String e1(StringBuilder stringBuilder) {
        f0.p(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }

    @InlineOnly
    private static final String f1(byte[] bytes) {
        f0.p(bytes, "bytes");
        return new String(bytes, d.f58930b);
    }

    @InlineOnly
    private static final String g1(byte[] bytes, int i4, int i5) {
        f0.p(bytes, "bytes");
        return new String(bytes, i4, i5, d.f58930b);
    }

    @NotNull
    public static String g2(@NotNull CharSequence charSequence, int i4) {
        f0.p(charSequence, "<this>");
        int i5 = 1;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i4 + '.').toString());
        } else if (i4 != 0) {
            if (i4 != 1) {
                int length = charSequence.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i4);
                        if (1 <= i4) {
                            while (true) {
                                int i6 = i5 + 1;
                                sb.append(charSequence);
                                if (i5 == i4) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        String sb2 = sb.toString();
                        f0.o(sb2, "{\n                    va\u2026tring()\n                }");
                        return sb2;
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i4];
                    for (int i7 = 0; i7 < i4; i7++) {
                        cArr[i7] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return charSequence.toString();
        } else {
            return "";
        }
    }

    @InlineOnly
    private static final String h1(byte[] bytes, int i4, int i5, Charset charset) {
        f0.p(bytes, "bytes");
        f0.p(charset, "charset");
        return new String(bytes, i4, i5, charset);
    }

    @NotNull
    public static final String h2(@NotNull String str, char c4, char c5, boolean z3) {
        f0.p(str, "<this>");
        if (!z3) {
            String replace = str.replace(c4, c5);
            f0.o(replace, "this as java.lang.String\u2026replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i4 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            i4++;
            if (c.J(charAt, c4, z3)) {
                charAt = c5;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb2;
    }

    @InlineOnly
    private static final String i1(byte[] bytes, Charset charset) {
        f0.p(bytes, "bytes");
        f0.p(charset, "charset");
        return new String(bytes, charset);
    }

    @NotNull
    public static final String i2(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z3) {
        int n4;
        f0.p(str, "<this>");
        f0.p(oldValue, "oldValue");
        f0.p(newValue, "newValue");
        int i4 = 0;
        int n32 = x.n3(str, oldValue, 0, z3);
        if (n32 < 0) {
            return str;
        }
        int length = oldValue.length();
        n4 = kotlin.ranges.q.n(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i4, n32);
                sb.append(newValue);
                i4 = n32 + length;
                if (n32 >= str.length()) {
                    break;
                }
                n32 = x.n3(str, oldValue, n32 + n4, z3);
            } while (n32 > 0);
            sb.append((CharSequence) str, i4, str.length());
            String sb2 = sb.toString();
            f0.o(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    @InlineOnly
    private static final String j1(char[] chars) {
        f0.p(chars, "chars");
        return new String(chars);
    }

    public static /* synthetic */ String j2(String str, char c4, char c5, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return h2(str, c4, c5, z3);
    }

    @InlineOnly
    private static final String k1(char[] chars, int i4, int i5) {
        f0.p(chars, "chars");
        return new String(chars, i4, i5);
    }

    public static /* synthetic */ String k2(String str, String str2, String str3, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return i2(str, str2, str3, z3);
    }

    @InlineOnly
    private static final String l1(int[] codePoints, int i4, int i5) {
        f0.p(codePoints, "codePoints");
        return new String(codePoints, i4, i5);
    }

    @NotNull
    public static final String l2(@NotNull String str, char c4, char c5, boolean z3) {
        int q3;
        f0.p(str, "<this>");
        q3 = x.q3(str, c4, 0, z3, 2, null);
        return q3 < 0 ? str : x.I4(str, q3, q3 + 1, String.valueOf(c5)).toString();
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    public static final String m1(@NotNull String str) {
        f0.p(str, "<this>");
        Locale locale = Locale.getDefault();
        f0.o(locale, "getDefault()");
        return n1(str, locale);
    }

    @NotNull
    public static final String m2(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z3) {
        int r3;
        f0.p(str, "<this>");
        f0.p(oldValue, "oldValue");
        f0.p(newValue, "newValue");
        r3 = x.r3(str, oldValue, 0, z3, 2, null);
        return r3 < 0 ? str : x.I4(str, r3, oldValue.length() + r3, newValue).toString();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String n1(@NotNull String str, @NotNull Locale locale) {
        f0.p(str, "<this>");
        f0.p(locale, "locale");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    String upperCase = substring.toUpperCase(locale);
                    f0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                f0.o(substring2, "this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            return str;
        }
        return str;
    }

    public static /* synthetic */ String n2(String str, char c4, char c5, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return l2(str, c4, c5, z3);
    }

    @InlineOnly
    private static final int o1(String str, int i4) {
        f0.p(str, "<this>");
        return str.codePointAt(i4);
    }

    public static /* synthetic */ String o2(String str, String str2, String str3, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return m2(str, str2, str3, z3);
    }

    @InlineOnly
    private static final int p1(String str, int i4) {
        f0.p(str, "<this>");
        return str.codePointBefore(i4);
    }

    @NotNull
    public static final List<String> p2(@NotNull CharSequence charSequence, @NotNull Pattern regex, int i4) {
        List<String> t3;
        f0.p(charSequence, "<this>");
        f0.p(regex, "regex");
        x.M4(i4);
        if (i4 == 0) {
            i4 = -1;
        }
        String[] split = regex.split(charSequence, i4);
        f0.o(split, "regex.split(this, if (limit == 0) -1 else limit)");
        t3 = kotlin.collections.o.t(split);
        return t3;
    }

    @InlineOnly
    private static final int q1(String str, int i4, int i5) {
        f0.p(str, "<this>");
        return str.codePointCount(i4, i5);
    }

    public static /* synthetic */ List q2(CharSequence charSequence, Pattern pattern, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return p2(charSequence, pattern, i4);
    }

    public static final int r1(@NotNull String str, @NotNull String other, boolean z3) {
        f0.p(str, "<this>");
        f0.p(other, "other");
        if (z3) {
            return str.compareToIgnoreCase(other);
        }
        return str.compareTo(other);
    }

    public static boolean r2(@NotNull String str, @NotNull String prefix, int i4, boolean z3) {
        boolean d22;
        f0.p(str, "<this>");
        f0.p(prefix, "prefix");
        if (!z3) {
            return str.startsWith(prefix, i4);
        }
        d22 = d2(str, i4, prefix, 0, prefix.length(), z3);
        return d22;
    }

    public static /* synthetic */ int s1(String str, String str2, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return r1(str, str2, z3);
    }

    public static boolean s2(@NotNull String str, @NotNull String prefix, boolean z3) {
        boolean d22;
        f0.p(str, "<this>");
        f0.p(prefix, "prefix");
        if (!z3) {
            return str.startsWith(prefix);
        }
        d22 = d2(str, 0, prefix, 0, prefix.length(), z3);
        return d22;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String t1(@NotNull char[] cArr) {
        f0.p(cArr, "<this>");
        return new String(cArr);
    }

    public static /* synthetic */ boolean t2(String str, String str2, int i4, boolean z3, int i5, Object obj) {
        boolean r22;
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        r22 = r2(str, str2, i4, z3);
        return r22;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String u1(@NotNull char[] cArr, int i4, int i5) {
        f0.p(cArr, "<this>");
        kotlin.collections.c.Companion.a(i4, i5, cArr.length);
        return new String(cArr, i4, i5 - i4);
    }

    public static /* synthetic */ boolean u2(String str, String str2, boolean z3, int i4, Object obj) {
        boolean s22;
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        s22 = s2(str, str2, z3);
        return s22;
    }

    public static /* synthetic */ String v1(char[] cArr, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = cArr.length;
        }
        return u1(cArr, i4, i5);
    }

    @InlineOnly
    private static final String v2(String str, int i4) {
        f0.p(str, "<this>");
        String substring = str.substring(i4);
        f0.o(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean w1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return x.X2(charSequence, charSequence2);
    }

    @InlineOnly
    private static final String w2(String str, int i4, int i5) {
        f0.p(str, "<this>");
        String substring = str.substring(i4, i5);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean x1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z3) {
        if (z3) {
            return x.W2(charSequence, charSequence2);
        }
        return w1(charSequence, charSequence2);
    }

    @InlineOnly
    private static final byte[] x2(String str, Charset charset) {
        f0.p(str, "<this>");
        f0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @InlineOnly
    private static final boolean y1(String str, CharSequence charSequence) {
        f0.p(str, "<this>");
        f0.p(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    static /* synthetic */ byte[] y2(String str, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = d.f58930b;
        }
        f0.p(str, "<this>");
        f0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @InlineOnly
    private static final boolean z1(String str, StringBuffer stringBuilder) {
        f0.p(str, "<this>");
        f0.p(stringBuilder, "stringBuilder");
        return str.contentEquals(stringBuilder);
    }

    @InlineOnly
    private static final char[] z2(String str) {
        f0.p(str, "<this>");
        char[] charArray = str.toCharArray();
        f0.o(charArray, "this as java.lang.String).toCharArray()");
        return charArray;
    }
}
