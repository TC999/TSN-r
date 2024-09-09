package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: NameUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final g f57575a = new g();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Regex f57576b = new Regex("[^\\p{L}\\p{Digit}]");

    private g() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String name) {
        f0.p(name, "name");
        return f57576b.replace(name, "_");
    }
}
