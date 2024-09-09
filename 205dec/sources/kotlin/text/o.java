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
/* compiled from: Appendable.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u001a7\u0010\u000b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\n\"\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a;\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "T", "", "value", "", "startIndex", "endIndex", "f", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "", "a", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "c", "e", "", "d", "element", "Lkotlin/Function1;", "transform", "Lkotlin/f1;", "b", "(Ljava/lang/Appendable;Ljava/lang/Object;Ld2/l;)V", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class o {
    @NotNull
    public static final <T extends Appendable> T a(@NotNull T t3, @NotNull CharSequence... value) {
        f0.p(t3, "<this>");
        f0.p(value, "value");
        int length = value.length;
        int i4 = 0;
        while (i4 < length) {
            CharSequence charSequence = value[i4];
            i4++;
            t3.append(charSequence);
        }
        return t3;
    }

    public static <T> void b(@NotNull Appendable appendable, T t3, @Nullable d2.l<? super T, ? extends CharSequence> lVar) {
        f0.p(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.invoke(t3));
            return;
        }
        if (t3 == null ? true : t3 instanceof CharSequence) {
            appendable.append((CharSequence) t3);
        } else if (t3 instanceof Character) {
            appendable.append(((Character) t3).charValue());
        } else {
            appendable.append(String.valueOf(t3));
        }
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable c(Appendable appendable) {
        f0.p(appendable, "<this>");
        Appendable append = appendable.append('\n');
        f0.o(append, "append('\\n')");
        return append;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable d(Appendable appendable, char c4) {
        f0.p(appendable, "<this>");
        Appendable append = appendable.append(c4);
        f0.o(append, "append(value)");
        Appendable append2 = append.append('\n');
        f0.o(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable e(Appendable appendable, CharSequence charSequence) {
        f0.p(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        f0.o(append, "append(value)");
        Appendable append2 = append.append('\n');
        f0.o(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T extends Appendable> T f(@NotNull T t3, @NotNull CharSequence value, int i4, int i5) {
        f0.p(t3, "<this>");
        f0.p(value, "value");
        T t4 = (T) t3.append(value, i4, i5);
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
    }
}
