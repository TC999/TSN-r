package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.j1;
import org.jetbrains.annotations.NotNull;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final f f57790a = new f();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f57791b;

    static {
        Set<kotlin.reflect.jvm.internal.impl.name.c> u3;
        u3 = j1.u(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.internal.NoInfer"), new kotlin.reflect.jvm.internal.impl.name.c("kotlin.internal.Exact"));
        f57791b = u3;
    }

    private f() {
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.c> a() {
        return f57791b;
    }
}
