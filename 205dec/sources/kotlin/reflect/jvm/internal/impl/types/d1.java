package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitution.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f58326a = new b(null);
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final d1 f58327b = new a();

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends d1 {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        public /* bridge */ /* synthetic */ a1 e(e0 e0Var) {
            return (a1) i(e0Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        public boolean f() {
            return true;
        }

        @Nullable
        public Void i(@NotNull e0 key) {
            kotlin.jvm.internal.f0.p(key, "key");
            return null;
        }

        @NotNull
        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends d1 {
        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        public boolean a() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        public boolean b() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations) {
            kotlin.jvm.internal.f0.p(annotations, "annotations");
            return d1.this.d(annotations);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        @Nullable
        public a1 e(@NotNull e0 key) {
            kotlin.jvm.internal.f0.p(key, "key");
            return d1.this.e(key);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        public boolean f() {
            return d1.this.f();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.d1
        @NotNull
        public e0 g(@NotNull e0 topLevelType, @NotNull Variance position) {
            kotlin.jvm.internal.f0.p(topLevelType, "topLevelType");
            kotlin.jvm.internal.f0.p(position, "position");
            return d1.this.g(topLevelType, position);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    @NotNull
    public final f1 c() {
        f1 g4 = f1.g(this);
        kotlin.jvm.internal.f0.o(g4, "create(this)");
        return g4;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations) {
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        return annotations;
    }

    @Nullable
    public abstract a1 e(@NotNull e0 e0Var);

    public boolean f() {
        return false;
    }

    @NotNull
    public e0 g(@NotNull e0 topLevelType, @NotNull Variance position) {
        kotlin.jvm.internal.f0.p(topLevelType, "topLevelType");
        kotlin.jvm.internal.f0.p(position, "position");
        return topLevelType;
    }

    @NotNull
    public final d1 h() {
        return new c();
    }
}
