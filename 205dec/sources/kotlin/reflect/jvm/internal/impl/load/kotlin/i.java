package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final l<T> f57226a;

    /* renamed from: b  reason: collision with root package name */
    private int f57227b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private T f57228c;

    public void a() {
    }

    public void b() {
        if (this.f57228c == null) {
            this.f57227b++;
        }
    }

    public void c(@NotNull T objectType) {
        f0.p(objectType, "objectType");
        d(objectType);
    }

    protected final void d(@NotNull T type) {
        String g22;
        f0.p(type, "type");
        if (this.f57228c == null) {
            int i4 = this.f57227b;
            if (i4 > 0) {
                l<T> lVar = this.f57226a;
                g22 = kotlin.text.w.g2("[", i4);
                type = lVar.a(f0.C(g22, this.f57226a.d(type)));
            }
            this.f57228c = type;
        }
    }

    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull T type) {
        f0.p(name, "name");
        f0.p(type, "type");
        d(type);
    }
}
