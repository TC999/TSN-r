package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewCapturedType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a1 f58286a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private d2.a<? extends List<? extends l1>> f58287b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final j f58288c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a1 f58289d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.p f58290e;

    /* compiled from: NewCapturedType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<List<? extends l1>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List<l1> f58291a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends l1> list) {
            super(0);
            this.f58291a = list;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends l1> invoke() {
            return this.f58291a;
        }
    }

    /* compiled from: NewCapturedType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<List<? extends l1>> {
        b() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        public final List<? extends l1> invoke() {
            d2.a aVar = j.this.f58287b;
            if (aVar == null) {
                return null;
            }
            return (List) aVar.invoke();
        }
    }

    /* compiled from: NewCapturedType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<List<? extends l1>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List<l1> f58293a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends l1> list) {
            super(0);
            this.f58293a = list;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends l1> invoke() {
            return this.f58293a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NewCapturedType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.a<List<? extends l1>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f58295b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(0);
            this.f58295b = gVar;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends l1> invoke() {
            int Z;
            List<l1> j4 = j.this.j();
            g gVar = this.f58295b;
            Z = kotlin.collections.y.Z(j4, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (l1 l1Var : j4) {
                arrayList.add(l1Var.M0(gVar));
            }
            return arrayList;
        }
    }

    public j(@NotNull a1 projection, @Nullable d2.a<? extends List<? extends l1>> aVar, @Nullable j jVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var) {
        kotlin.p c4;
        f0.p(projection, "projection");
        this.f58286a = projection;
        this.f58287b = aVar;
        this.f58288c = jVar;
        this.f58289d = a1Var;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new b());
        this.f58290e = c4;
    }

    private final List<l1> f() {
        return (List) this.f58290e.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public boolean c() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: e */
    public List<l1> j() {
        List<l1> F;
        List<l1> f4 = f();
        if (f4 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return f4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(j.class, obj == null ? null : obj.getClass())) {
            if (obj != null) {
                j jVar = (j) obj;
                j jVar2 = this.f58288c;
                if (jVar2 == null) {
                    jVar2 = this;
                }
                j jVar3 = jVar.f58288c;
                if (jVar3 != null) {
                    jVar = jVar3;
                }
                return jVar2 == jVar;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        }
        return false;
    }

    public final void g(@NotNull List<? extends l1> supertypes) {
        f0.p(supertypes, "supertypes");
        this.f58287b = new c(supertypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.a1> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b
    @NotNull
    public a1 getProjection() {
        return this.f58286a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: h */
    public j a(@NotNull g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        a1 a4 = getProjection().a(kotlinTypeRefiner);
        f0.o(a4, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f58287b == null ? null : new d(kotlinTypeRefiner);
        j jVar = this.f58288c;
        if (jVar == null) {
            jVar = this;
        }
        return new j(a4, dVar, jVar, this.f58289d);
    }

    public int hashCode() {
        j jVar = this.f58288c;
        return jVar == null ? super.hashCode() : jVar.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.h k() {
        e0 type = getProjection().getType();
        f0.o(type, "projection.type");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(type);
    }

    @NotNull
    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }

    public /* synthetic */ j(a1 a1Var, d2.a aVar, j jVar, kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2, int i4, kotlin.jvm.internal.u uVar) {
        this(a1Var, (i4 & 2) != 0 ? null : aVar, (i4 & 4) != 0 ? null : jVar, (i4 & 8) != 0 ? null : a1Var2);
    }

    public /* synthetic */ j(a1 a1Var, List list, j jVar, int i4, kotlin.jvm.internal.u uVar) {
        this(a1Var, list, (i4 & 4) != 0 ? null : jVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(@NotNull a1 projection, @NotNull List<? extends l1> supertypes, @Nullable j jVar) {
        this(projection, new a(supertypes), jVar, null, 8, null);
        f0.p(projection, "projection");
        f0.p(supertypes, "supertypes");
    }
}
