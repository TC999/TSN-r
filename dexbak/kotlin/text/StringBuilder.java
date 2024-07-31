package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b\u001a6\u0010\n\u001a\u00020\t2\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a>\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a1\u0010\u0010\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u000e\"\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0012\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000e\"\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0087\b\u001a\u001f\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0087\b\u001a\u001f\u0010\u0018\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000f\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000f\u001a\u00020\u001bH\u0087\b\u001a\u001d\u0010\u001e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000f\u001a\u00020\u001dH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m12616d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "obj", "h0", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "s0", "", "capacity", "r0", "", DomainCampaignEx.LOOPBACK_VALUE, "j0", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "i0", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "k0", "", "m0", "o0", "n0", "", "q0", "", "l0", "", C7202bq.f24604g, "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class StringBuilder extends C14577s {
    @Annotations(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    /* renamed from: h0 */
    private static final java.lang.StringBuilder m6672h0(java.lang.StringBuilder sb, Object obj) {
        sb.append(obj);
        C14342f0.m8185o(sb, "this.append(obj)");
        return sb;
    }

    @NotNull
    /* renamed from: i0 */
    public static final java.lang.StringBuilder m6671i0(@NotNull java.lang.StringBuilder append, @NotNull Object... value) {
        C14342f0.m8184p(append, "$this$append");
        C14342f0.m8184p(value, "value");
        for (Object obj : value) {
            append.append(obj);
        }
        return append;
    }

    @NotNull
    /* renamed from: j0 */
    public static final java.lang.StringBuilder m6670j0(@NotNull java.lang.StringBuilder append, @NotNull String... value) {
        C14342f0.m8184p(append, "$this$append");
        C14342f0.m8184p(value, "value");
        for (String str : value) {
            append.append(str);
        }
        return append;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: k0 */
    private static final java.lang.StringBuilder m6669k0(java.lang.StringBuilder sb) {
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: l0 */
    private static final java.lang.StringBuilder m6668l0(java.lang.StringBuilder sb, char c) {
        sb.append(c);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: m0 */
    private static final java.lang.StringBuilder m6667m0(java.lang.StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: n0 */
    private static final java.lang.StringBuilder m6666n0(java.lang.StringBuilder sb, Object obj) {
        sb.append(obj);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: o0 */
    private static final java.lang.StringBuilder m6665o0(java.lang.StringBuilder sb, String str) {
        sb.append(str);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: p0 */
    private static final java.lang.StringBuilder m6664p0(java.lang.StringBuilder sb, boolean z) {
        sb.append(z);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: q0 */
    private static final java.lang.StringBuilder m6663q0(java.lang.StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        C14342f0.m8185o(sb, "append(value)");
        sb.append('\n');
        C14342f0.m8185o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: r0 */
    private static final String m6662r0(int i, InterfaceC15280l<? super java.lang.StringBuilder, Unit> interfaceC15280l) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i);
        interfaceC15280l.invoke(sb);
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @InlineOnly
    /* renamed from: s0 */
    private static final String m6661s0(InterfaceC15280l<? super java.lang.StringBuilder, Unit> interfaceC15280l) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        interfaceC15280l.invoke(sb);
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
