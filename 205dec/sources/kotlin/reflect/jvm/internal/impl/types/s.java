package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s extends d1 {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f58410e = new a(null);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d1 f58411c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final d1 f58412d;

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final d1 a(@NotNull d1 first, @NotNull d1 second) {
            kotlin.jvm.internal.f0.p(first, "first");
            kotlin.jvm.internal.f0.p(second, "second");
            return first.f() ? second : second.f() ? first : new s(first, second, null);
        }
    }

    private s(d1 d1Var, d1 d1Var2) {
        this.f58411c = d1Var;
        this.f58412d = d1Var2;
    }

    public /* synthetic */ s(d1 d1Var, d1 d1Var2, kotlin.jvm.internal.u uVar) {
        this(d1Var, d1Var2);
    }

    @JvmStatic
    @NotNull
    public static final d1 i(@NotNull d1 d1Var, @NotNull d1 d1Var2) {
        return f58410e.a(d1Var, d1Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean a() {
        return this.f58411c.a() || this.f58412d.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean b() {
        return this.f58411c.b() || this.f58412d.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        return this.f58412d.d(this.f58411c.d(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @Nullable
    public a1 e(@NotNull e0 key) {
        kotlin.jvm.internal.f0.p(key, "key");
        a1 e4 = this.f58411c.e(key);
        return e4 == null ? this.f58412d.e(key) : e4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean f() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @NotNull
    public e0 g(@NotNull e0 topLevelType, @NotNull Variance position) {
        kotlin.jvm.internal.f0.p(topLevelType, "topLevelType");
        kotlin.jvm.internal.f0.p(position, "position");
        return this.f58412d.g(this.f58411c.g(topLevelType, position), position);
    }
}
