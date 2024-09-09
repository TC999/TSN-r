package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0<T> implements a0<T> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.c, T> f56672b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.f f56673c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.c, T> f56674d;

    /* compiled from: JavaNullabilityAnnotationSettings.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b0<T> f56675a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b0<T> b0Var) {
            super(1);
            this.f56675a = b0Var;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final T invoke(kotlin.reflect.jvm.internal.impl.name.c it) {
            f0.o(it, "it");
            return (T) kotlin.reflect.jvm.internal.impl.name.e.a(it, this.f56675a.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(@NotNull Map<kotlin.reflect.jvm.internal.impl.name.c, ? extends T> states) {
        f0.p(states, "states");
        this.f56672b = states;
        kotlin.reflect.jvm.internal.impl.storage.f fVar = new kotlin.reflect.jvm.internal.impl.storage.f("Java nullability annotation states");
        this.f56673c = fVar;
        kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.c, T> e4 = fVar.e(new a(this));
        f0.o(e4, "storageManager.createMem\u2026cificFqname(states)\n    }");
        this.f56674d = e4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.a0
    @Nullable
    public T a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return this.f56674d.invoke(fqName);
    }

    @NotNull
    public final Map<kotlin.reflect.jvm.internal.impl.name.c, T> b() {
        return this.f56672b;
    }
}
