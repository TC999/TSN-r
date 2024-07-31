package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import com.kwad.sdk.api.model.AdnName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.handler.ssl.ApplicationProtocolNames;
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
import kotlin.Annotations;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractC14213q0;
import kotlin.collections.AbstractList;
import kotlin.collections._ArraysJvm;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.C14361s0;
import kotlin.ranges.C14413k;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0086\u0001\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a\u001d\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a\u001d\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a\u001d\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b\u001a \u0010\r\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\r\u0010\u0016\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\f\u0010\u001b\u001a\u00020\u0000*\u00020\u001aH\u0007\u001a \u0010\u001e\u001a\u00020\u0000*\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0007\u001a \u0010\u001f\u001a\u00020\u001a*\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0007\u001a\f\u0010!\u001a\u00020\u0000*\u00020 H\u0007\u001a*\u0010#\u001a\u00020\u0000*\u00020 2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u000bH\u0007\u001a\f\u0010$\u001a\u00020 *\u00020\u0000H\u0007\u001a*\u0010%\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u000bH\u0007\u001a\r\u0010&\u001a\u00020\u001a*\u00020\u0000H\u0087\b\u001a3\u0010)\u001a\u00020\u001a*\u00020\u00002\u0006\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0087\b\u001a,\u0010-\u001a\u00020\u0000*\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b¢\u0006\u0004\b-\u0010.\u001a4\u00101\u001a\u00020\u0000*\u00020/2\u0006\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b¢\u0006\u0004\b1\u00102\u001a4\u00105\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u0002032\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b¢\u0006\u0004\b5\u00106\u001a6\u00107\u001a\u00020\u0000*\u00020\u00002\b\u00104\u001a\u0004\u0018\u0001032\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b¢\u0006\u0004\b7\u00106\u001a<\u00108\u001a\u00020\u0000*\u00020/2\u0006\u00104\u001a\u0002032\u0006\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b¢\u0006\u0004\b8\u00109\u001a>\u0010:\u001a\u00020\u0000*\u00020/2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0087\b¢\u0006\u0004\b:\u00109\u001a\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00000?*\u00020;2\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020\u0003\u001a\u0015\u0010A\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0003H\u0087\b\u001a\u001d\u0010B\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0087\b\u001a\u001c\u0010D\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a$\u0010E\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u001c\u0010G\u001a\u00020\u000b*\u00020\u00002\u0006\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a)\u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010L\u001a\u00020KH\u0087\b\u001a\u0019\u0010N\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 2\u0006\u0010L\u001a\u00020KH\u0087\b\u001a!\u0010O\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b\u001a\u0011\u0010P\u001a\u00020\u00002\u0006\u0010H\u001a\u00020 H\u0087\b\u001a\u0011\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001aH\u0087\b\u001a!\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b\u001a!\u0010V\u001a\u00020\u00002\u0006\u0010U\u001a\u00020T2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b\u001a\u0011\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020WH\u0087\b\u001a\u0011\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020ZH\u0087\b\u001a\u0015\u0010^\u001a\u00020\u0003*\u00020\u00002\u0006\u0010]\u001a\u00020\u0003H\u0087\b\u001a\u0015\u0010_\u001a\u00020\u0003*\u00020\u00002\u0006\u0010]\u001a\u00020\u0003H\u0087\b\u001a\u001d\u0010a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010`\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0087\b\u001a\u001c\u0010b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u0015\u0010d\u001a\u00020\u000b*\u00020\u00002\u0006\u0010c\u001a\u00020;H\u0087\b\u001a\u0015\u0010e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010[\u001a\u00020WH\u0087\b\u001a\u0019\u0010f\u001a\u00020\u000b*\u0004\u0018\u00010;2\b\u0010\n\u001a\u0004\u0018\u00010;H\u0087\u0004\u001a \u0010g\u001a\u00020\u000b*\u0004\u0018\u00010;2\b\u0010\n\u001a\u0004\u0018\u00010;2\u0006\u0010\f\u001a\u00020\u000bH\u0007\u001a\r\u0010h\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\n\u0010i\u001a\u00020\u000b*\u00020;\u001a\u001d\u0010k\u001a\u00020\u0003*\u00020\u00002\u0006\u0010]\u001a\u00020\u00032\u0006\u0010j\u001a\u00020\u0003H\u0087\b\u001a4\u0010n\u001a\u00020\u000b*\u00020;2\u0006\u0010l\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020;2\u0006\u0010m\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a4\u0010o\u001a\u00020\u000b*\u00020\u00002\u0006\u0010l\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\u0015\u0010p\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0015\u0010q\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0015\u0010r\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0015\u0010s\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0087\b\u001a\u0017\u0010t\u001a\u00020 *\u00020\u00002\b\b\u0002\u0010L\u001a\u00020KH\u0087\b\u001a\u0017\u0010v\u001a\u00020<*\u00020\u00002\b\b\u0002\u0010u\u001a\u00020\u0003H\u0087\b\u001a\f\u0010w\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\u0014\u0010x\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0007\u001a\f\u0010y\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\u0014\u0010z\u001a\u00020\u0000*\u00020\u00002\u0006\u00104\u001a\u000203H\u0007\u001a\u0012\u0010|\u001a\u00020\u0000*\u00020;2\u0006\u0010{\u001a\u00020\u0003\"'\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00000}j\b\u0012\u0004\u0012\u00020\u0000`~*\u00020/8F¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0082\u0001"}, m12616d2 = {"", "", "ch", "", "fromIndex", "X1", "str", "Y1", "Z1", "a2", AdnName.OTHER, "", "ignoreCase", "K1", "oldChar", "newChar", ApplicationProtocolNames.HTTP_2, "oldValue", "newValue", "i2", "l2", "m2", "I2", "K2", "E2", "V1", "", "t1", "startIndex", "endIndex", "u1", "A2", "", "C1", "throwOnInvalidSequence", "D1", "F1", "G1", "z2", RtspHeaders.Values.DESTINATION, "destinationOffset", "B2", "", "", "args", "N1", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", IjkMediaMeta.IJKM_KEY_FORMAT, "O1", "(Lkotlin/jvm/internal/s0;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "M1", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "Q1", "P1", "(Lkotlin/jvm/internal/s0;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "R1", "", "Ljava/util/regex/Pattern;", "regex", "limit", "", "p2", "v2", "w2", "prefix", "s2", "r2", "suffix", "I1", "bytes", IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, "length", "Ljava/nio/charset/Charset;", "charset", "h1", "i1", "g1", "f1", "chars", "j1", "k1", "", "codePoints", "l1", "Ljava/lang/StringBuffer;", "stringBuffer", "d1", "Ljava/lang/StringBuilder;", "stringBuilder", "e1", "index", "o1", "p1", "beginIndex", "q1", "r1", "charSequence", "y1", "z1", "w1", "x1", "T1", "U1", "codePointOffset", "b2", "thisOffset", "otherOffset", "c2", "d2", "F2", "W1", "J2", "L2", "x2", "flags", "G2", "m1", "n1", "A1", "B1", "n", "g2", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "S1", "(Lkotlin/jvm/internal/s0;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StringsJVM extends StringNumberConversions {
    @Annotations(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    /* renamed from: A1 */
    public static final String m6624A1(@NotNull String decapitalize) {
        C14342f0.m8184p(decapitalize, "$this$decapitalize");
        if (!(decapitalize.length() > 0) || Character.isLowerCase(decapitalize.charAt(0))) {
            return decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String substring = decapitalize.substring(0, 1);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String lowerCase = substring.toLowerCase();
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            String substring2 = decapitalize.substring(1);
            C14342f0.m8185o(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: A2 */
    public static final char[] m6623A2(@NotNull String toCharArray, int i, int i2) {
        C14342f0.m8184p(toCharArray, "$this$toCharArray");
        AbstractList.Companion.m12305a(i, i2, toCharArray.length());
        char[] cArr = new char[i2 - i];
        toCharArray.getChars(i, i2, cArr, 0);
        return cArr;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    @Annotations(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: B1 */
    public static final String m6622B1(@NotNull String decapitalize, @NotNull Locale locale) {
        C14342f0.m8184p(decapitalize, "$this$decapitalize");
        C14342f0.m8184p(locale, "locale");
        if (!(decapitalize.length() > 0) || Character.isLowerCase(decapitalize.charAt(0))) {
            return decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String substring = decapitalize.substring(0, 1);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String lowerCase = substring.toLowerCase(locale);
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            String substring2 = decapitalize.substring(1);
            C14342f0.m8185o(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: B2 */
    private static final char[] m6621B2(String str, char[] cArr, int i, int i2, int i3) {
        if (str != null) {
            str.getChars(i2, i3, cArr, i);
            return cArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: C1 */
    public static final String m6620C1(@NotNull byte[] decodeToString) {
        C14342f0.m8184p(decodeToString, "$this$decodeToString");
        return new String(decodeToString, Charsets.f41591a);
    }

    /* renamed from: C2 */
    public static /* synthetic */ char[] m6619C2(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m6623A2(str, i, i2);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: D1 */
    public static final String m6618D1(@NotNull byte[] decodeToString, int i, int i2, boolean z) {
        C14342f0.m8184p(decodeToString, "$this$decodeToString");
        AbstractList.Companion.m12305a(i, i2, decodeToString.length);
        if (!z) {
            return new String(decodeToString, i, i2 - i, Charsets.f41591a);
        }
        String charBuffer = Charsets.f41591a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(decodeToString, i, i2 - i)).toString();
        C14342f0.m8185o(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    /* renamed from: D2 */
    static /* synthetic */ char[] m6617D2(String str, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        if (str != null) {
            str.getChars(i2, i3, cArr, i);
            return cArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: E1 */
    public static /* synthetic */ String m6616E1(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m6618D1(bArr, i, i2, z);
    }

    @Annotations(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: E2 */
    private static final String m6615E2(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: F1 */
    public static final byte[] m6614F1(@NotNull String encodeToByteArray) {
        C14342f0.m8184p(encodeToByteArray, "$this$encodeToByteArray");
        byte[] bytes = encodeToByteArray.getBytes(Charsets.f41591a);
        C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Annotations(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: F2 */
    private static final String m6613F2(String str, Locale locale) {
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: G1 */
    public static final byte[] m6612G1(@NotNull String encodeToByteArray, int i, int i2, boolean z) {
        C14342f0.m8184p(encodeToByteArray, "$this$encodeToByteArray");
        AbstractList.Companion.m12305a(i, i2, encodeToByteArray.length());
        if (!z) {
            String substring = encodeToByteArray.substring(i, i2);
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = Charsets.f41591a;
            if (substring != null) {
                byte[] bytes = substring.getBytes(charset);
                C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        ByteBuffer encode = Charsets.f41591a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(encodeToByteArray, i, i2));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            C14342f0.m8187m(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                C14342f0.m8185o(array2, "byteBuffer.array()");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @InlineOnly
    /* renamed from: G2 */
    private static final Pattern m6611G2(String str, int i) {
        Pattern compile = Pattern.compile(str, i);
        C14342f0.m8185o(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    /* renamed from: H1 */
    public static /* synthetic */ byte[] m6610H1(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m6612G1(str, i, i2, z);
    }

    /* renamed from: H2 */
    static /* synthetic */ Pattern m6609H2(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Pattern compile = Pattern.compile(str, i);
        C14342f0.m8185o(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    /* renamed from: I1 */
    public static boolean m6608I1(@NotNull String endsWith, @NotNull String suffix, boolean z) {
        boolean m6582d2;
        C14342f0.m8184p(endsWith, "$this$endsWith");
        C14342f0.m8184p(suffix, "suffix");
        if (!z) {
            return endsWith.endsWith(suffix);
        }
        m6582d2 = m6582d2(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
        return m6582d2;
    }

    @Annotations(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: I2 */
    private static final String m6607I2(String str) {
        if (str != null) {
            String upperCase = str.toUpperCase();
            C14342f0.m8185o(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: J1 */
    public static /* synthetic */ boolean m6606J1(String str, String str2, boolean z, int i, Object obj) {
        boolean m6608I1;
        if ((i & 2) != 0) {
            z = false;
        }
        m6608I1 = m6608I1(str, str2, z);
        return m6608I1;
    }

    @Annotations(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: J2 */
    private static final String m6605J2(String str, Locale locale) {
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            C14342f0.m8185o(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: K1 */
    public static boolean m6604K1(@Nullable String str, @Nullable String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: K2 */
    private static final String m6603K2(String str) {
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            C14342f0.m8185o(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: L1 */
    public static /* synthetic */ boolean m6602L1(String str, String str2, boolean z, int i, Object obj) {
        boolean m6604K1;
        if ((i & 2) != 0) {
            z = false;
        }
        m6604K1 = m6604K1(str, str2, z);
        return m6604K1;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: L2 */
    private static final String m6601L2(String str, Locale locale) {
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            C14342f0.m8185o(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Annotations(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: M1 */
    private static final /* synthetic */ String m6600M1(String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        C14342f0.m8185o(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    @InlineOnly
    /* renamed from: N1 */
    private static final String m6599N1(String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        C14342f0.m8185o(format, "java.lang.String.format(this, *args)");
        return format;
    }

    @InlineOnly
    /* renamed from: O1 */
    private static final String m6598O1(C14361s0 c14361s0, String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        C14342f0.m8185o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @Annotations(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: P1 */
    private static final /* synthetic */ String m6597P1(C14361s0 c14361s0, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        C14342f0.m8185o(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "formatNullable")
    /* renamed from: Q1 */
    private static final String m6596Q1(String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        C14342f0.m8185o(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "formatNullable")
    /* renamed from: R1 */
    private static final String m6595R1(C14361s0 c14361s0, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        C14342f0.m8185o(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    @NotNull
    /* renamed from: S1 */
    public static Comparator<String> m6594S1(@NotNull C14361s0 CASE_INSENSITIVE_ORDER) {
        C14342f0.m8184p(CASE_INSENSITIVE_ORDER, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        C14342f0.m8185o(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @InlineOnly
    /* renamed from: T1 */
    private static final String m6593T1(String str) {
        if (str != null) {
            String intern = str.intern();
            C14342f0.m8185o(intern, "(this as java.lang.String).intern()");
            return intern;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: U1 */
    public static final boolean m6592U1(@NotNull CharSequence isBlank) {
        boolean z;
        C14342f0.m8184p(isBlank, "$this$isBlank");
        if (isBlank.length() != 0) {
            C14413k m6428h3 = C14579x.m6428h3(isBlank);
            if (!(m6428h3 instanceof Collection) || !((Collection) m6428h3).isEmpty()) {
                Iterator<Integer> it = m6428h3.iterator();
                while (it.hasNext()) {
                    if (!CharJVM.m6876r(isBlank.charAt(((AbstractC14213q0) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: V1 */
    private static final String m6591V1(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            C14342f0.m8185o(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: W1 */
    private static final String m6590W1(String str, Locale locale) {
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: X1 */
    private static final int m6589X1(String str, char c, int i) {
        if (str != null) {
            return str.indexOf(c, i);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: Y1 */
    private static final int m6588Y1(String str, String str2, int i) {
        if (str != null) {
            return str.indexOf(str2, i);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: Z1 */
    private static final int m6587Z1(String str, char c, int i) {
        if (str != null) {
            return str.lastIndexOf(c, i);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: a2 */
    private static final int m6586a2(String str, String str2, int i) {
        if (str != null) {
            return str.lastIndexOf(str2, i);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: b2 */
    private static final int m6585b2(String str, int i, int i2) {
        if (str != null) {
            return str.offsetByCodePoints(i, i2);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: c2 */
    public static final boolean m6584c2(@NotNull CharSequence regionMatches, int i, @NotNull CharSequence other, int i2, int i3, boolean z) {
        boolean m6582d2;
        C14342f0.m8184p(regionMatches, "$this$regionMatches");
        C14342f0.m8184p(other, "other");
        if ((regionMatches instanceof String) && (other instanceof String)) {
            m6582d2 = m6582d2((String) regionMatches, i, (String) other, i2, i3, z);
            return m6582d2;
        }
        return C14579x.m6448a4(regionMatches, i, other, i2, i3, z);
    }

    @InlineOnly
    /* renamed from: d1 */
    private static final String m6583d1(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    /* renamed from: d2 */
    public static boolean m6582d2(@NotNull String regionMatches, int i, @NotNull String other, int i2, int i3, boolean z) {
        C14342f0.m8184p(regionMatches, "$this$regionMatches");
        C14342f0.m8184p(other, "other");
        if (!z) {
            return regionMatches.regionMatches(i, other, i2, i3);
        }
        return regionMatches.regionMatches(z, i, other, i2, i3);
    }

    @InlineOnly
    /* renamed from: e1 */
    private static final String m6581e1(StringBuilder sb) {
        return new String(sb);
    }

    @InlineOnly
    /* renamed from: f1 */
    private static final String m6579f1(byte[] bArr) {
        return new String(bArr, Charsets.f41591a);
    }

    @InlineOnly
    /* renamed from: g1 */
    private static final String m6577g1(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, Charsets.f41591a);
    }

    @NotNull
    /* renamed from: g2 */
    public static String m6576g2(@NotNull CharSequence repeat, int i) {
        C14342f0.m8184p(repeat, "$this$repeat");
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        } else if (i != 0) {
            if (i != 1) {
                int length = repeat.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(repeat.length() * i);
                        if (1 <= i) {
                            while (true) {
                                sb.append(repeat);
                                if (i2 == i) {
                                    break;
                                }
                                i2++;
                            }
                        }
                        String sb2 = sb.toString();
                        C14342f0.m8185o(sb2, "sb.toString()");
                        return sb2;
                    }
                    char charAt = repeat.charAt(0);
                    char[] cArr = new char[i];
                    for (int i3 = 0; i3 < i; i3++) {
                        cArr[i3] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return repeat.toString();
        } else {
            return "";
        }
    }

    @InlineOnly
    /* renamed from: h1 */
    private static final String m6575h1(byte[] bArr, int i, int i2, Charset charset) {
        return new String(bArr, i, i2, charset);
    }

    @NotNull
    /* renamed from: h2 */
    public static final String m6574h2(@NotNull String replace, char c, char c2, boolean z) {
        C14342f0.m8184p(replace, "$this$replace");
        if (!z) {
            String replace2 = replace.replace(c, c2);
            C14342f0.m8185o(replace2, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace2;
        }
        StringBuilder sb = new StringBuilder(replace.length());
        for (int i = 0; i < replace.length(); i++) {
            char charAt = replace.charAt(i);
            if (Char.m6858J(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @InlineOnly
    /* renamed from: i1 */
    private static final String m6573i1(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @NotNull
    /* renamed from: i2 */
    public static final String m6572i2(@NotNull String replace, @NotNull String oldValue, @NotNull String newValue, boolean z) {
        int m7481n;
        C14342f0.m8184p(replace, "$this$replace");
        C14342f0.m8184p(oldValue, "oldValue");
        C14342f0.m8184p(newValue, "newValue");
        int i = 0;
        int m6410n3 = C14579x.m6410n3(replace, oldValue, 0, z);
        if (m6410n3 < 0) {
            return replace;
        }
        int length = oldValue.length();
        m7481n = _Ranges.m7481n(length, 1);
        int length2 = (replace.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) replace, i, m6410n3);
                sb.append(newValue);
                i = m6410n3 + length;
                if (m6410n3 >= replace.length()) {
                    break;
                }
                m6410n3 = C14579x.m6410n3(replace, oldValue, m6410n3 + m7481n, z);
            } while (m6410n3 > 0);
            sb.append((CharSequence) replace, i, replace.length());
            String sb2 = sb.toString();
            C14342f0.m8185o(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    @InlineOnly
    /* renamed from: j1 */
    private static final String m6571j1(char[] cArr) {
        return new String(cArr);
    }

    /* renamed from: j2 */
    public static /* synthetic */ String m6570j2(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m6574h2(str, c, c2, z);
    }

    @InlineOnly
    /* renamed from: k1 */
    private static final String m6569k1(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    /* renamed from: k2 */
    public static /* synthetic */ String m6568k2(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m6572i2(str, str2, str3, z);
    }

    @InlineOnly
    /* renamed from: l1 */
    private static final String m6567l1(int[] iArr, int i, int i2) {
        return new String(iArr, i, i2);
    }

    @NotNull
    /* renamed from: l2 */
    public static final String m6566l2(@NotNull String replaceFirst, char c, char c2, boolean z) {
        int m6401q3;
        C14342f0.m8184p(replaceFirst, "$this$replaceFirst");
        m6401q3 = C14579x.m6401q3(replaceFirst, c, 0, z, 2, null);
        return m6401q3 < 0 ? replaceFirst : C14579x.m6512I4(replaceFirst, m6401q3, m6401q3 + 1, String.valueOf(c2)).toString();
    }

    @Annotations(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    /* renamed from: m1 */
    public static final String m6565m1(@NotNull String capitalize) {
        C14342f0.m8184p(capitalize, "$this$capitalize");
        Locale locale = Locale.getDefault();
        C14342f0.m8185o(locale, "Locale.getDefault()");
        return m6563n1(capitalize, locale);
    }

    @NotNull
    /* renamed from: m2 */
    public static final String m6564m2(@NotNull String replaceFirst, @NotNull String oldValue, @NotNull String newValue, boolean z) {
        int m6398r3;
        C14342f0.m8184p(replaceFirst, "$this$replaceFirst");
        C14342f0.m8184p(oldValue, "oldValue");
        C14342f0.m8184p(newValue, "newValue");
        m6398r3 = C14579x.m6398r3(replaceFirst, oldValue, 0, z, 2, null);
        return m6398r3 < 0 ? replaceFirst : C14579x.m6512I4(replaceFirst, m6398r3, oldValue.length() + m6398r3, newValue).toString();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    @Annotations(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: n1 */
    public static final String m6563n1(@NotNull String capitalize, @NotNull Locale locale) {
        C14342f0.m8184p(capitalize, "$this$capitalize");
        C14342f0.m8184p(locale, "locale");
        if (capitalize.length() > 0) {
            char charAt = capitalize.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = capitalize.substring(0, 1);
                    C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String upperCase = substring.toUpperCase(locale);
                    C14342f0.m8185o(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = capitalize.substring(1);
                C14342f0.m8185o(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return capitalize;
    }

    /* renamed from: n2 */
    public static /* synthetic */ String m6562n2(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m6566l2(str, c, c2, z);
    }

    @InlineOnly
    /* renamed from: o1 */
    private static final int m6561o1(String str, int i) {
        if (str != null) {
            return str.codePointAt(i);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: o2 */
    public static /* synthetic */ String m6560o2(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m6564m2(str, str2, str3, z);
    }

    @InlineOnly
    /* renamed from: p1 */
    private static final int m6559p1(String str, int i) {
        if (str != null) {
            return str.codePointBefore(i);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    /* renamed from: p2 */
    public static final List<String> m6558p2(@NotNull CharSequence split, @NotNull Pattern regex, int i) {
        List<String> m11537t;
        C14342f0.m8184p(split, "$this$split");
        C14342f0.m8184p(regex, "regex");
        C14579x.m6499M4(i);
        if (i == 0) {
            i = -1;
        }
        String[] split2 = regex.split(split, i);
        C14342f0.m8185o(split2, "regex.split(this, if (limit == 0) -1 else limit)");
        m11537t = _ArraysJvm.m11537t(split2);
        return m11537t;
    }

    @InlineOnly
    /* renamed from: q1 */
    private static final int m6557q1(String str, int i, int i2) {
        if (str != null) {
            return str.codePointCount(i, i2);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: q2 */
    public static /* synthetic */ List m6556q2(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m6558p2(charSequence, pattern, i);
    }

    /* renamed from: r1 */
    public static final int m6555r1(@NotNull String compareTo, @NotNull String other, boolean z) {
        C14342f0.m8184p(compareTo, "$this$compareTo");
        C14342f0.m8184p(other, "other");
        if (z) {
            return compareTo.compareToIgnoreCase(other);
        }
        return compareTo.compareTo(other);
    }

    /* renamed from: r2 */
    public static boolean m6554r2(@NotNull String startsWith, @NotNull String prefix, int i, boolean z) {
        boolean m6582d2;
        C14342f0.m8184p(startsWith, "$this$startsWith");
        C14342f0.m8184p(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix, i);
        }
        m6582d2 = m6582d2(startsWith, i, prefix, 0, prefix.length(), z);
        return m6582d2;
    }

    /* renamed from: s1 */
    public static /* synthetic */ int m6553s1(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m6555r1(str, str2, z);
    }

    /* renamed from: s2 */
    public static boolean m6552s2(@NotNull String startsWith, @NotNull String prefix, boolean z) {
        boolean m6582d2;
        C14342f0.m8184p(startsWith, "$this$startsWith");
        C14342f0.m8184p(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix);
        }
        m6582d2 = m6582d2(startsWith, 0, prefix, 0, prefix.length(), z);
        return m6582d2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: t1 */
    public static final String m6551t1(@NotNull char[] concatToString) {
        C14342f0.m8184p(concatToString, "$this$concatToString");
        return new String(concatToString);
    }

    /* renamed from: t2 */
    public static /* synthetic */ boolean m6550t2(String str, String str2, int i, boolean z, int i2, Object obj) {
        boolean m6554r2;
        if ((i2 & 4) != 0) {
            z = false;
        }
        m6554r2 = m6554r2(str, str2, i, z);
        return m6554r2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: u1 */
    public static final String m6549u1(@NotNull char[] concatToString, int i, int i2) {
        C14342f0.m8184p(concatToString, "$this$concatToString");
        AbstractList.Companion.m12305a(i, i2, concatToString.length);
        return new String(concatToString, i, i2 - i);
    }

    /* renamed from: u2 */
    public static /* synthetic */ boolean m6548u2(String str, String str2, boolean z, int i, Object obj) {
        boolean m6552s2;
        if ((i & 2) != 0) {
            z = false;
        }
        m6552s2 = m6552s2(str, str2, z);
        return m6552s2;
    }

    /* renamed from: v1 */
    public static /* synthetic */ String m6547v1(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return m6549u1(cArr, i, i2);
    }

    @InlineOnly
    /* renamed from: v2 */
    private static final String m6546v2(String str, int i) {
        if (str != null) {
            String substring = str.substring(i);
            C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: w1 */
    public static final boolean m6545w1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return C14579x.m6458X2(charSequence, charSequence2);
    }

    @InlineOnly
    /* renamed from: w2 */
    private static final String m6544w2(String str, int i, int i2) {
        if (str != null) {
            String substring = str.substring(i, i2);
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    /* renamed from: x1 */
    public static final boolean m6543x1(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        if (z) {
            return C14579x.m6461W2(charSequence, charSequence2);
        }
        return m6545w1(charSequence, charSequence2);
    }

    @InlineOnly
    /* renamed from: x2 */
    private static final byte[] m6542x2(String str, Charset charset) {
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: y1 */
    private static final boolean m6541y1(String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: y2 */
    static /* synthetic */ byte[] m6540y2(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: z1 */
    private static final boolean m6539z1(String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    /* renamed from: z2 */
    private static final char[] m6538z2(String str) {
        if (str != null) {
            char[] charArray = str.toCharArray();
            C14342f0.m8185o(charArray, "(this as java.lang.String).toCharArray()");
            return charArray;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
