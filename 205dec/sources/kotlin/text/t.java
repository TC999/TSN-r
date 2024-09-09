package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StringBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b\u001a6\u0010\n\u001a\u00020\t2\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a>\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a1\u0010\u0010\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u000e\"\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0012\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000e\"\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0087\b\u001a\u001f\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0087\b\u001a\u001f\u0010\u0018\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000f\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000f\u001a\u00020\u001bH\u0087\b\u001a\u001d\u0010\u001e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000f\u001a\u00020\u001dH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001f"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "obj", "h0", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "s0", "", "capacity", "r0", "", "value", "j0", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "i0", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "k0", "", "m0", "o0", "n0", "", "q0", "", "l0", "", "p0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class t extends s {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    private static final StringBuilder h0(StringBuilder sb, Object obj) {
        f0.p(sb, "<this>");
        sb.append(obj);
        f0.o(sb, "this.append(obj)");
        return sb;
    }

    @NotNull
    public static final StringBuilder i0(@NotNull StringBuilder sb, @NotNull Object... value) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        int length = value.length;
        int i4 = 0;
        while (i4 < length) {
            Object obj = value[i4];
            i4++;
            sb.append(obj);
        }
        return sb;
    }

    @NotNull
    public static StringBuilder j0(@NotNull StringBuilder sb, @NotNull String... value) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        int length = value.length;
        int i4 = 0;
        while (i4 < length) {
            String str = value[i4];
            i4++;
            sb.append(str);
        }
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder k0(StringBuilder sb) {
        f0.p(sb, "<this>");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder l0(StringBuilder sb, char c4) {
        f0.p(sb, "<this>");
        sb.append(c4);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder m0(StringBuilder sb, CharSequence charSequence) {
        f0.p(sb, "<this>");
        sb.append(charSequence);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder n0(StringBuilder sb, Object obj) {
        f0.p(sb, "<this>");
        sb.append(obj);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder o0(StringBuilder sb, String str) {
        f0.p(sb, "<this>");
        sb.append(str);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder p0(StringBuilder sb, boolean z3) {
        f0.p(sb, "<this>");
        sb.append(z3);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder q0(StringBuilder sb, char[] value) {
        f0.p(sb, "<this>");
        f0.p(value, "value");
        sb.append(value);
        f0.o(sb, "append(value)");
        sb.append('\n');
        f0.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String r0(int i4, d2.l<? super StringBuilder, f1> builderAction) {
        f0.p(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i4);
        builderAction.invoke(sb);
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb2;
    }

    @InlineOnly
    private static final String s0(d2.l<? super StringBuilder, f1> builderAction) {
        f0.p(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
