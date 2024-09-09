package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import org.jetbrains.annotations.NotNull;

/* compiled from: NewKotlinTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m implements l {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final g f58299c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final f f58300d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final OverridingUtil f58301e;

    public m(@NotNull g kotlinTypeRefiner, @NotNull f kotlinTypePreparator) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        f0.p(kotlinTypePreparator, "kotlinTypePreparator");
        this.f58299c = kotlinTypeRefiner;
        this.f58300d = kotlinTypePreparator;
        OverridingUtil n4 = OverridingUtil.n(c());
        f0.o(n4, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f58301e = n4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.l
    @NotNull
    public OverridingUtil a() {
        return this.f58301e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public boolean b(@NotNull e0 a4, @NotNull e0 b4) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        return e(a.b(false, false, null, f(), c(), 6, null), a4.K0(), b4.K0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.l
    @NotNull
    public g c() {
        return this.f58299c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public boolean d(@NotNull e0 subtype, @NotNull e0 supertype) {
        f0.p(subtype, "subtype");
        f0.p(supertype, "supertype");
        return g(a.b(true, false, null, f(), c(), 6, null), subtype.K0(), supertype.K0());
    }

    public final boolean e(@NotNull TypeCheckerState typeCheckerState, @NotNull l1 a4, @NotNull l1 b4) {
        f0.p(typeCheckerState, "<this>");
        f0.p(a4, "a");
        f0.p(b4, "b");
        return kotlin.reflect.jvm.internal.impl.types.f.f58335a.i(typeCheckerState, a4, b4);
    }

    @NotNull
    public f f() {
        return this.f58300d;
    }

    public final boolean g(@NotNull TypeCheckerState typeCheckerState, @NotNull l1 subType, @NotNull l1 superType) {
        f0.p(typeCheckerState, "<this>");
        f0.p(subType, "subType");
        f0.p(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.f.q(kotlin.reflect.jvm.internal.impl.types.f.f58335a, typeCheckerState, subType, superType, false, 8, null);
    }

    public /* synthetic */ m(g gVar, f fVar, int i4, kotlin.jvm.internal.u uVar) {
        this(gVar, (i4 & 2) != 0 ? f.a.f58277a : fVar);
    }
}
