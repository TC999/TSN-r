package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g extends l {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<b> f58361b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f58362c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a implements y0 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f58363a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final kotlin.p f58364b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f58365c;

        /* compiled from: AbstractTypeConstructor.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.g$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1183a extends Lambda implements d2.a<List<? extends e0>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ g f58367b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1183a(g gVar) {
                super(0);
                this.f58367b = gVar;
            }

            @Override // d2.a
            @NotNull
            public final List<? extends e0> invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.h.b(a.this.f58363a, this.f58367b.j());
            }
        }

        public a(@NotNull g this$0, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.p c4;
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f58365c = this$0;
            this.f58363a = kotlinTypeRefiner;
            c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new C1183a(this$0));
            this.f58364b = c4;
        }

        private final List<e0> e() {
            return (List) this.f58364b.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f58365c.a(kotlinTypeRefiner);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
            return this.f58365c.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return this.f58365c.c();
        }

        public boolean equals(@Nullable Object obj) {
            return this.f58365c.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        /* renamed from: f */
        public List<e0> j() {
            return e();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = this.f58365c.getParameters();
            kotlin.jvm.internal.f0.o(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.f58365c.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.h k() {
            kotlin.reflect.jvm.internal.impl.builtins.h k4 = this.f58365c.k();
            kotlin.jvm.internal.f0.o(k4, "this@AbstractTypeConstructor.builtIns");
            return k4;
        }

        @NotNull
        public String toString() {
            return this.f58365c.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Collection<e0> f58368a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private List<? extends e0> f58369b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Collection<? extends e0> allSupertypes) {
            List<? extends e0> l4;
            kotlin.jvm.internal.f0.p(allSupertypes, "allSupertypes");
            this.f58368a = allSupertypes;
            l4 = kotlin.collections.x.l(w.f58444c);
            this.f58369b = l4;
        }

        @NotNull
        public final Collection<e0> a() {
            return this.f58368a;
        }

        @NotNull
        public final List<e0> b() {
            return this.f58369b;
        }

        public final void c(@NotNull List<? extends e0> list) {
            kotlin.jvm.internal.f0.p(list, "<set-?>");
            this.f58369b = list;
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<b> {
        c() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final b invoke() {
            return new b(g.this.i());
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.l<Boolean, b> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f58371a = new d();

        d() {
            super(1);
        }

        @NotNull
        public final b a(boolean z3) {
            List l4;
            l4 = kotlin.collections.x.l(w.f58444c);
            return new b(l4);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return a(bool.booleanValue());
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements d2.l<b, kotlin.f1> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.l<y0, Iterable<? extends e0>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f58373a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(1);
                this.f58373a = gVar;
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final Iterable<e0> invoke(@NotNull y0 it) {
                kotlin.jvm.internal.f0.p(it, "it");
                return this.f58373a.h(it, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends Lambda implements d2.l<e0, kotlin.f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f58374a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(g gVar) {
                super(1);
                this.f58374a = gVar;
            }

            public final void a(@NotNull e0 it) {
                kotlin.jvm.internal.f0.p(it, "it");
                this.f58374a.r(it);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ kotlin.f1 invoke(e0 e0Var) {
                a(e0Var);
                return kotlin.f1.f55527a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends Lambda implements d2.l<y0, Iterable<? extends e0>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f58375a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(g gVar) {
                super(1);
                this.f58375a = gVar;
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final Iterable<e0> invoke(@NotNull y0 it) {
                kotlin.jvm.internal.f0.p(it, "it");
                return this.f58375a.h(it, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class d extends Lambda implements d2.l<e0, kotlin.f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f58376a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(g gVar) {
                super(1);
                this.f58376a = gVar;
            }

            public final void a(@NotNull e0 it) {
                kotlin.jvm.internal.f0.p(it, "it");
                this.f58376a.s(it);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ kotlin.f1 invoke(e0 e0Var) {
                a(e0Var);
                return kotlin.f1.f55527a;
            }
        }

        e() {
            super(1);
        }

        public final void a(@NotNull b supertypes) {
            kotlin.jvm.internal.f0.p(supertypes, "supertypes");
            Collection<e0> a4 = g.this.o().a(g.this, supertypes.a(), new c(g.this), new d(g.this));
            if (a4.isEmpty()) {
                e0 l4 = g.this.l();
                a4 = l4 == null ? null : kotlin.collections.x.l(l4);
                if (a4 == null) {
                    a4 = CollectionsKt__CollectionsKt.F();
                }
            }
            if (g.this.n()) {
                kotlin.reflect.jvm.internal.impl.descriptors.y0 o4 = g.this.o();
                g gVar = g.this;
                o4.a(gVar, a4, new a(gVar), new b(g.this));
            }
            g gVar2 = g.this;
            List<e0> list = a4 instanceof List ? (List) a4 : null;
            if (list == null) {
                list = kotlin.collections.f0.G5(a4);
            }
            supertypes.c(gVar2.q(list));
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ kotlin.f1 invoke(b bVar) {
            a(bVar);
            return kotlin.f1.f55527a;
        }
    }

    public g(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager) {
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        this.f58361b = storageManager.f(new c(), d.f58371a, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<e0> h(y0 y0Var, boolean z3) {
        List o4;
        g gVar = y0Var instanceof g ? (g) y0Var : null;
        if (gVar == null) {
            Collection<e0> supertypes = y0Var.j();
            kotlin.jvm.internal.f0.o(supertypes, "supertypes");
            return supertypes;
        }
        o4 = kotlin.collections.f0.o4(gVar.f58361b.invoke().a(), gVar.m(z3));
        return o4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public y0 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    @NotNull
    protected abstract Collection<e0> i();

    @Nullable
    protected e0 l() {
        return null;
    }

    @NotNull
    protected Collection<e0> m(boolean z3) {
        List F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    protected boolean n() {
        return this.f58362c;
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.y0 o();

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: p */
    public List<e0> j() {
        return this.f58361b.invoke().b();
    }

    @NotNull
    protected List<e0> q(@NotNull List<e0> supertypes) {
        kotlin.jvm.internal.f0.p(supertypes, "supertypes");
        return supertypes;
    }

    protected void r(@NotNull e0 type) {
        kotlin.jvm.internal.f0.p(type, "type");
    }

    protected void s(@NotNull e0 type) {
        kotlin.jvm.internal.f0.p(type, "type");
    }
}
