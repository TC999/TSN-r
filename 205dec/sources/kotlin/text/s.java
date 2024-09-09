package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StringBuilderJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007\u001a!\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\n\u001a-\u0010\f\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\r\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b\u001a%\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a7\u0010\u0012\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0087\b\u001a-\u0010\u0013\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a-\u0010\u0015\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a5\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a5\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0019\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b\u001a\u001d\u0010\u001b\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001cH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001eH\u0087\b\u001a\u001d\u0010!\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020 H\u0087\b\u001a\u001d\u0010#\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\"H\u0087\b\u001a\u001d\u0010%\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020$H\u0087\b\u001a\u0014\u0010(\u001a\u00060&j\u0002`'*\u00060&j\u0002`'H\u0007\u001a\u001f\u0010)\u001a\u00060&j\u0002`'*\u00060&j\u0002`'2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001d\u0010*\u001a\u00060&j\u0002`'*\u00060&j\u0002`'2\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u0014\u0010+\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007\u001a\u001f\u0010,\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001f\u0010-\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001f\u0010.\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0087\b\u001a\u001f\u00100\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0087\b\u001a%\u00101\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b\u001a\u001d\u00102\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001d\u00103\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u001d\u00105\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u000204H\u0087\b\u001a\u001d\u00106\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\u0087\b\u001a\u001d\u00107\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001cH\u0087\b\u001a\u001d\u00108\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\u001eH\u0087\b\u001a\u001d\u00109\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020 H\u0087\b\u001a\u001d\u0010:\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020\"H\u0087\b\u001a\u001d\u0010;\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0006\u001a\u00020$H\u0087\b\u00a8\u0006<"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Y", "", "index", "", "value", "Lkotlin/f1;", "d0", "startIndex", "endIndex", "", "e0", "Z", "a0", "", "destination", "destinationOffset", "f0", "F", "", "E", "c0", "b0", "Ljava/lang/StringBuffer;", "B", "C", "z", "", "D", "", "w", "", "A", "", "y", "", "x", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "G", "I", "H", "J", "T", "Q", "S", "", "R", "U", "X", "L", "", "W", "O", "V", "K", "P", "N", "M", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class s extends r {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder A(StringBuilder sb, long j4) {
        f0.p(sb, "<this>");
        sb.append(j4);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder B(StringBuilder sb, StringBuffer stringBuffer) {
        f0.p(sb, "<this>");
        sb.append(stringBuffer);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder C(StringBuilder sb, StringBuilder sb2) {
        f0.p(sb, "<this>");
        sb.append((CharSequence) sb2);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder D(StringBuilder sb, short s3) {
        f0.p(sb, "<this>");
        sb.append((int) s3);
        f0.o(sb, "append(value.toInt())");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder E(StringBuilder sb, CharSequence value, int i4, int i5) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        sb.append(value, i4, i5);
        f0.o(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder F(StringBuilder sb, char[] value, int i4, int i5) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        sb.append(value, i4, i5 - i4);
        f0.o(sb, "this.append(value, start\u2026x, endIndex - startIndex)");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    public static final Appendable G(@NotNull Appendable appendable) {
        f0.p(appendable, "<this>");
        Appendable append = appendable.append(a0.f58901b);
        f0.o(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable H(Appendable appendable, char c4) {
        f0.p(appendable, "<this>");
        Appendable append = appendable.append(c4);
        f0.o(append, "append(value)");
        return G(append);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable I(Appendable appendable, CharSequence charSequence) {
        f0.p(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        f0.o(append, "append(value)");
        return G(append);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    public static final StringBuilder J(@NotNull StringBuilder sb) {
        f0.p(sb, "<this>");
        sb.append(a0.f58901b);
        f0.o(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder K(StringBuilder sb, byte b4) {
        f0.p(sb, "<this>");
        sb.append((int) b4);
        f0.o(sb, "append(value.toInt())");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder L(StringBuilder sb, char c4) {
        f0.p(sb, "<this>");
        sb.append(c4);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder M(StringBuilder sb, double d4) {
        f0.p(sb, "<this>");
        sb.append(d4);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder N(StringBuilder sb, float f4) {
        f0.p(sb, "<this>");
        sb.append(f4);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder O(StringBuilder sb, int i4) {
        f0.p(sb, "<this>");
        sb.append(i4);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder P(StringBuilder sb, long j4) {
        f0.p(sb, "<this>");
        sb.append(j4);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder Q(StringBuilder sb, CharSequence charSequence) {
        f0.p(sb, "<this>");
        sb.append(charSequence);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder R(StringBuilder sb, Object obj) {
        f0.p(sb, "<this>");
        sb.append(obj);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder S(StringBuilder sb, String str) {
        f0.p(sb, "<this>");
        sb.append(str);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder T(StringBuilder sb, StringBuffer stringBuffer) {
        f0.p(sb, "<this>");
        sb.append(stringBuffer);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder U(StringBuilder sb, StringBuilder sb2) {
        f0.p(sb, "<this>");
        sb.append((CharSequence) sb2);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder V(StringBuilder sb, short s3) {
        f0.p(sb, "<this>");
        sb.append((int) s3);
        f0.o(sb, "append(value.toInt())");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder W(StringBuilder sb, boolean z3) {
        f0.p(sb, "<this>");
        sb.append(z3);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder X(StringBuilder sb, char[] value) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        sb.append(value);
        f0.o(sb, "append(value)");
        return J(sb);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final StringBuilder Y(@NotNull StringBuilder sb) {
        f0.p(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder Z(StringBuilder sb, int i4) {
        f0.p(sb, "<this>");
        StringBuilder deleteCharAt = sb.deleteCharAt(i4);
        f0.o(deleteCharAt, "this.deleteCharAt(index)");
        return deleteCharAt;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder a0(StringBuilder sb, int i4, int i5) {
        f0.p(sb, "<this>");
        StringBuilder delete = sb.delete(i4, i5);
        f0.o(delete, "this.delete(startIndex, endIndex)");
        return delete;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder b0(StringBuilder sb, int i4, CharSequence value, int i5, int i6) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        StringBuilder insert = sb.insert(i4, value, i5, i6);
        f0.o(insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder c0(StringBuilder sb, int i4, char[] value, int i5, int i6) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        StringBuilder insert = sb.insert(i4, value, i5, i6 - i5);
        f0.o(insert, "this.insert(index, value\u2026x, endIndex - startIndex)");
        return insert;
    }

    @InlineOnly
    private static final void d0(StringBuilder sb, int i4, char c4) {
        f0.p(sb, "<this>");
        sb.setCharAt(i4, c4);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final StringBuilder e0(StringBuilder sb, int i4, int i5, String value) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        StringBuilder replace = sb.replace(i4, i5, value);
        f0.o(replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final void f0(StringBuilder sb, char[] destination, int i4, int i5, int i6) {
        f0.p(sb, "<this>");
        f0.p(destination, "destination");
        sb.getChars(i5, i6, destination, i4);
    }

    static /* synthetic */ void g0(StringBuilder sb, char[] destination, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = sb.length();
        }
        f0.p(sb, "<this>");
        f0.p(destination, "destination");
        sb.getChars(i5, i6, destination, i4);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder w(StringBuilder sb, byte b4) {
        f0.p(sb, "<this>");
        sb.append((int) b4);
        f0.o(sb, "append(value.toInt())");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder x(StringBuilder sb, double d4) {
        f0.p(sb, "<this>");
        sb.append(d4);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder y(StringBuilder sb, float f4) {
        f0.p(sb, "<this>");
        sb.append(f4);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder z(StringBuilder sb, int i4) {
        f0.p(sb, "<this>");
        sb.append(i4);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }
}
