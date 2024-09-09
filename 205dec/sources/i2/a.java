package i2;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JavaVisibilities.kt */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f54761a = new a();

    /* compiled from: JavaVisibilities.kt */
    /* renamed from: i2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class C1079a extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final C1079a f54762c = new C1079a();

        private C1079a() {
            super("package", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @Nullable
        public Integer a(@NotNull i1 visibility) {
            f0.p(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            return h1.f56275a.b(visibility) ? 1 : -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public String b() {
            return "public/*package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public i1 d() {
            return h1.g.f56284c;
        }
    }

    /* compiled from: JavaVisibilities.kt */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class b extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final b f54763c = new b();

        private b() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @Nullable
        public Integer a(@NotNull i1 visibility) {
            f0.p(visibility, "visibility");
            if (f0.g(this, visibility)) {
                return 0;
            }
            if (visibility == h1.b.f56279c) {
                return null;
            }
            return Integer.valueOf(h1.f56275a.b(visibility) ? 1 : -1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public String b() {
            return "protected/*protected and package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public i1 d() {
            return h1.g.f56284c;
        }
    }

    /* compiled from: JavaVisibilities.kt */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class c extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final c f54764c = new c();

        private c() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public String b() {
            return "protected/*protected static*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public i1 d() {
            return h1.g.f56284c;
        }
    }

    private a() {
    }
}
