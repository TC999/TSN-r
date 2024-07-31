package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: StringBuilderJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007\u001a!\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\n\u001a-\u0010\f\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\r\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b\u001a%\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a7\u0010\u0012\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0087\b\u001a-\u0010\u0013\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a-\u0010\u0015\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a5\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a5\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0019\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b\u001a\u001d\u0010\u001b\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001cH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001eH\u0087\b\u001a\u001d\u0010!\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020 H\u0087\b\u001a\u001d\u0010#\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\"H\u0087\b\u001a\u001d\u0010%\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020$H\u0087\b\u001a\u0014\u0010(\u001a\u00060&j\u0002`'*\u00060&j\u0002`'H\u0007\u001a\u001f\u0010)\u001a\u00060&j\u0002`'*\u00060&j\u0002`'2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001d\u0010*\u001a\u00060&j\u0002`'*\u00060&j\u0002`'2\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u0014\u0010+\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007\u001a\u001f\u0010,\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001f\u0010-\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001f\u0010.\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0087\b\u001a\u001f\u00100\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0087\b\u001a%\u00101\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b\u001a\u001d\u00102\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001d\u00103\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u001d\u00105\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u000204H\u0087\b\u001a\u001d\u00106\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0087\b\u001a\u001d\u00107\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001cH\u0087\b\u001a\u001d\u00108\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001eH\u0087\b\u001a\u001d\u00109\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020 H\u0087\b\u001a\u001d\u0010:\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\"H\u0087\b\u001a\u001d\u0010;\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020$H\u0087\b¨\u0006<"}, m12616d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Y", "", "index", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "d0", "startIndex", "endIndex", "", "e0", "Z", "a0", "", RtspHeaders.Values.DESTINATION, "destinationOffset", "f0", "F", "", ExifInterface.LONGITUDE_EAST, "c0", "b0", "Ljava/lang/StringBuffer;", "B", "C", UMCommonContent.f37777aG, "", "D", "", IAdInterListener.AdReqParam.WIDTH, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "y", "", "x", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "G", "I", "H", "J", ExifInterface.GPS_DIRECTION_TRUE, "Q", ExifInterface.LATITUDE_SOUTH, "", "R", "U", "X", "L", "", ExifInterface.LONGITUDE_WEST, "O", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "P", "N", "M", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C14577s extends RegexExtensions {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: A */
    private static final StringBuilder m6709A(StringBuilder sb, long j) {
        sb.append(j);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: B */
    private static final StringBuilder m6708B(StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: C */
    private static final StringBuilder m6707C(StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: D */
    private static final StringBuilder m6706D(StringBuilder sb, short s) {
        sb.append((int) s);
        C14342f0.m8185o(sb, "append(value.toInt())");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: E */
    private static final StringBuilder m6705E(StringBuilder sb, CharSequence charSequence, int i, int i2) {
        sb.append(charSequence, i, i2);
        C14342f0.m8185o(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: F */
    private static final StringBuilder m6704F(StringBuilder sb, char[] cArr, int i, int i2) {
        sb.append(cArr, i, i2 - i);
        C14342f0.m8185o(sb, "this.append(value, start…x, endIndex - startIndex)");
        return sb;
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    /* renamed from: G */
    public static final Appendable m6703G(@NotNull Appendable appendln) {
        C14342f0.m8184p(appendln, "$this$appendln");
        Appendable append = appendln.append(StringBuilderJVM.f41549a);
        C14342f0.m8185o(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: H */
    private static final Appendable m6702H(Appendable appendable, char c) {
        Appendable append = appendable.append(c);
        C14342f0.m8185o(append, "append(value)");
        return m6703G(append);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: I */
    private static final Appendable m6701I(Appendable appendable, CharSequence charSequence) {
        Appendable append = appendable.append(charSequence);
        C14342f0.m8185o(append, "append(value)");
        return m6703G(append);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    /* renamed from: J */
    public static final StringBuilder m6700J(@NotNull StringBuilder appendln) {
        C14342f0.m8184p(appendln, "$this$appendln");
        appendln.append(StringBuilderJVM.f41549a);
        C14342f0.m8185o(appendln, "append(SystemProperties.LINE_SEPARATOR)");
        return appendln;
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: K */
    private static final StringBuilder m6699K(StringBuilder sb, byte b) {
        sb.append((int) b);
        C14342f0.m8185o(sb, "append(value.toInt())");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: L */
    private static final StringBuilder m6698L(StringBuilder sb, char c) {
        sb.append(c);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: M */
    private static final StringBuilder m6697M(StringBuilder sb, double d) {
        sb.append(d);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: N */
    private static final StringBuilder m6696N(StringBuilder sb, float f) {
        sb.append(f);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: O */
    private static final StringBuilder m6695O(StringBuilder sb, int i) {
        sb.append(i);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: P */
    private static final StringBuilder m6694P(StringBuilder sb, long j) {
        sb.append(j);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: Q */
    private static final StringBuilder m6693Q(StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: R */
    private static final StringBuilder m6692R(StringBuilder sb, Object obj) {
        sb.append(obj);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: S */
    private static final StringBuilder m6691S(StringBuilder sb, String str) {
        sb.append(str);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: T */
    private static final StringBuilder m6690T(StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: U */
    private static final StringBuilder m6689U(StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: V */
    private static final StringBuilder m6688V(StringBuilder sb, short s) {
        sb.append((int) s);
        C14342f0.m8185o(sb, "append(value.toInt())");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: W */
    private static final StringBuilder m6687W(StringBuilder sb, boolean z) {
        sb.append(z);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @Annotations(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    /* renamed from: X */
    private static final StringBuilder m6686X(StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        C14342f0.m8185o(sb, "append(value)");
        return m6700J(sb);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: Y */
    public static final StringBuilder m6685Y(@NotNull StringBuilder clear) {
        C14342f0.m8184p(clear, "$this$clear");
        clear.setLength(0);
        return clear;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: Z */
    private static final StringBuilder m6684Z(StringBuilder sb, int i) {
        StringBuilder deleteCharAt = sb.deleteCharAt(i);
        C14342f0.m8185o(deleteCharAt, "this.deleteCharAt(index)");
        return deleteCharAt;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: a0 */
    private static final StringBuilder m6683a0(StringBuilder sb, int i, int i2) {
        StringBuilder delete = sb.delete(i, i2);
        C14342f0.m8185o(delete, "this.delete(startIndex, endIndex)");
        return delete;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: b0 */
    private static final StringBuilder m6682b0(StringBuilder sb, int i, CharSequence charSequence, int i2, int i3) {
        StringBuilder insert = sb.insert(i, charSequence, i2, i3);
        C14342f0.m8185o(insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: c0 */
    private static final StringBuilder m6681c0(StringBuilder sb, int i, char[] cArr, int i2, int i3) {
        StringBuilder insert = sb.insert(i, cArr, i2, i3 - i2);
        C14342f0.m8185o(insert, "this.insert(index, value…x, endIndex - startIndex)");
        return insert;
    }

    @InlineOnly
    /* renamed from: d0 */
    private static final void m6680d0(StringBuilder set, int i, char c) {
        C14342f0.m8184p(set, "$this$set");
        set.setCharAt(i, c);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: e0 */
    private static final StringBuilder m6679e0(StringBuilder sb, int i, int i2, String str) {
        StringBuilder replace = sb.replace(i, i2, str);
        C14342f0.m8185o(replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: f0 */
    private static final void m6678f0(StringBuilder sb, char[] cArr, int i, int i2, int i3) {
        sb.getChars(i2, i3, cArr, i);
    }

    /* renamed from: g0 */
    static /* synthetic */ void m6677g0(StringBuilder sb, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sb.length();
        }
        sb.getChars(i2, i3, cArr, i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: w */
    private static final StringBuilder m6676w(StringBuilder sb, byte b) {
        sb.append((int) b);
        C14342f0.m8185o(sb, "append(value.toInt())");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: x */
    private static final StringBuilder m6675x(StringBuilder sb, double d) {
        sb.append(d);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: y */
    private static final StringBuilder m6674y(StringBuilder sb, float f) {
        sb.append(f);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: z */
    private static final StringBuilder m6673z(StringBuilder sb, int i) {
        sb.append(i);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }
}
