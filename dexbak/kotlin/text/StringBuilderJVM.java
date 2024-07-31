package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, m12616d2 = {"Lkotlin/text/a0;", "", "", "a", "Ljava/lang/String;", "LINE_SEPARATOR", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class StringBuilderJVM {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public static final String f41549a;
    @NotNull

    /* renamed from: b */
    public static final StringBuilderJVM f41550b = new StringBuilderJVM();

    static {
        String property = System.getProperty("line.separator");
        C14342f0.m8187m(property);
        f41549a = property;
    }

    private StringBuilderJVM() {
    }
}
