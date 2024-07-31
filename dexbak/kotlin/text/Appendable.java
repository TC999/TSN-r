package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u000b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\n\"\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a;\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m12616d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_DIRECTION_TRUE, "", DomainCampaignEx.LOOPBACK_VALUE, "", "startIndex", "endIndex", "f", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "", "a", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "c", "e", "", "d", "element", "Lkotlin/Function1;", "transform", "Lkotlin/f1;", "b", "(Ljava/lang/Appendable;Ljava/lang/Object;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Appendable {
    @NotNull
    /* renamed from: a */
    public static final <T extends java.lang.Appendable> T m6734a(@NotNull T append, @NotNull CharSequence... value) {
        C14342f0.m8184p(append, "$this$append");
        C14342f0.m8184p(value, "value");
        for (CharSequence charSequence : value) {
            append.append(charSequence);
        }
        return append;
    }

    /* renamed from: b */
    public static <T> void m6733b(@NotNull java.lang.Appendable appendElement, T t, @Nullable InterfaceC15280l<? super T, ? extends CharSequence> interfaceC15280l) {
        C14342f0.m8184p(appendElement, "$this$appendElement");
        if (interfaceC15280l != null) {
            appendElement.append(interfaceC15280l.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendElement.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendElement.append(((Character) t).charValue());
        } else {
            appendElement.append(String.valueOf(t));
        }
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: c */
    private static final java.lang.Appendable m6732c(java.lang.Appendable appendable) {
        java.lang.Appendable append = appendable.append('\n');
        C14342f0.m8185o(append, "append('\\n')");
        return append;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: d */
    private static final java.lang.Appendable m6731d(java.lang.Appendable appendable, char c) {
        java.lang.Appendable append = appendable.append(c);
        C14342f0.m8185o(append, "append(value)");
        java.lang.Appendable append2 = append.append('\n');
        C14342f0.m8185o(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: e */
    private static final java.lang.Appendable m6730e(java.lang.Appendable appendable, CharSequence charSequence) {
        java.lang.Appendable append = appendable.append(charSequence);
        C14342f0.m8185o(append, "append(value)");
        java.lang.Appendable append2 = append.append('\n');
        C14342f0.m8185o(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: f */
    public static final <T extends java.lang.Appendable> T m6729f(@NotNull T appendRange, @NotNull CharSequence value, int i, int i2) {
        C14342f0.m8184p(appendRange, "$this$appendRange");
        C14342f0.m8184p(value, "value");
        T t = (T) appendRange.append(value, i, i2);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
