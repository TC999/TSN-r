package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Visibilities.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h1 f56275a = new h1();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map<i1, Integer> f56276b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final h f56277c;

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final a f56278c = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final b f56279c = new b();

        private b() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final c f56280c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final d f56281c = new d();

        private d() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final e f56282c = new e();

        private e() {
            super("private", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final f f56283c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
        @NotNull
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final g f56284c = new g();

        private g() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final h f56285c = new h();

        private h() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class i extends i1 {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final i f56286c = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map g4 = kotlin.collections.w0.g();
        g4.put(f.f56283c, 0);
        g4.put(e.f56282c, 0);
        g4.put(b.f56279c, 1);
        g4.put(g.f56284c, 1);
        h hVar = h.f56285c;
        g4.put(hVar, 2);
        f56276b = kotlin.collections.w0.d(g4);
        f56277c = hVar;
    }

    private h1() {
    }

    @Nullable
    public final Integer a(@NotNull i1 first, @NotNull i1 second) {
        kotlin.jvm.internal.f0.p(first, "first");
        kotlin.jvm.internal.f0.p(second, "second");
        if (first == second) {
            return 0;
        }
        Map<i1, Integer> map = f56276b;
        Integer num = map.get(first);
        Integer num2 = map.get(second);
        if (num == null || num2 == null || kotlin.jvm.internal.f0.g(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(@NotNull i1 visibility) {
        kotlin.jvm.internal.f0.p(visibility, "visibility");
        return visibility == e.f56282c || visibility == f.f56283c;
    }
}
