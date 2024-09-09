package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractTypeChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class TypeCheckerState {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f58251a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f58252b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f58253c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final r2.p f58254d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final h f58255e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final i f58256f;

    /* renamed from: g  reason: collision with root package name */
    private int f58257g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f58258h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ArrayDeque<r2.i> f58259i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Set<r2.i> f58260j;

    /* compiled from: AbstractTypeChecker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* compiled from: AbstractTypeChecker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a {

        /* compiled from: AbstractTypeChecker.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static abstract class AbstractC1179a extends a {
            public AbstractC1179a() {
                super(null);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final b f58261a = new b();

            private b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.a
            @NotNull
            public r2.i a(@NotNull TypeCheckerState state, @NotNull r2.g type) {
                kotlin.jvm.internal.f0.p(state, "state");
                kotlin.jvm.internal.f0.p(type, "type");
                return state.j().l(type);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final c f58262a = new c();

            private c() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.a
            public /* bridge */ /* synthetic */ r2.i a(TypeCheckerState typeCheckerState, r2.g gVar) {
                return (r2.i) b(typeCheckerState, gVar);
            }

            @NotNull
            public Void b(@NotNull TypeCheckerState state, @NotNull r2.g type) {
                kotlin.jvm.internal.f0.p(state, "state");
                kotlin.jvm.internal.f0.p(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class d extends a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final d f58263a = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.a
            @NotNull
            public r2.i a(@NotNull TypeCheckerState state, @NotNull r2.g type) {
                kotlin.jvm.internal.f0.p(state, "state");
                kotlin.jvm.internal.f0.p(type, "type");
                return state.j().t(type);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public abstract r2.i a(@NotNull TypeCheckerState typeCheckerState, @NotNull r2.g gVar);
    }

    public TypeCheckerState(boolean z3, boolean z4, boolean z5, @NotNull r2.p typeSystemContext, @NotNull h kotlinTypePreparator, @NotNull i kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.f0.p(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f58251a = z3;
        this.f58252b = z4;
        this.f58253c = z5;
        this.f58254d = typeSystemContext;
        this.f58255e = kotlinTypePreparator;
        this.f58256f = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean d(TypeCheckerState typeCheckerState, r2.g gVar, r2.g gVar2, boolean z3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 4) != 0) {
                z3 = false;
            }
            return typeCheckerState.c(gVar, gVar2, z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    @Nullable
    public Boolean c(@NotNull r2.g subType, @NotNull r2.g superType, boolean z3) {
        kotlin.jvm.internal.f0.p(subType, "subType");
        kotlin.jvm.internal.f0.p(superType, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<r2.i> arrayDeque = this.f58259i;
        kotlin.jvm.internal.f0.m(arrayDeque);
        arrayDeque.clear();
        Set<r2.i> set = this.f58260j;
        kotlin.jvm.internal.f0.m(set);
        set.clear();
        this.f58258h = false;
    }

    public boolean f(@NotNull r2.g subType, @NotNull r2.g superType) {
        kotlin.jvm.internal.f0.p(subType, "subType");
        kotlin.jvm.internal.f0.p(superType, "superType");
        return true;
    }

    @NotNull
    public LowerCapturedTypePolicy g(@NotNull r2.i subType, @NotNull r2.b superType) {
        kotlin.jvm.internal.f0.p(subType, "subType");
        kotlin.jvm.internal.f0.p(superType, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Nullable
    public final ArrayDeque<r2.i> h() {
        return this.f58259i;
    }

    @Nullable
    public final Set<r2.i> i() {
        return this.f58260j;
    }

    @NotNull
    public final r2.p j() {
        return this.f58254d;
    }

    public final void k() {
        this.f58258h = true;
        if (this.f58259i == null) {
            this.f58259i = new ArrayDeque<>(4);
        }
        if (this.f58260j == null) {
            this.f58260j = kotlin.reflect.jvm.internal.impl.utils.f.f58554c.a();
        }
    }

    public final boolean l(@NotNull r2.g type) {
        kotlin.jvm.internal.f0.p(type, "type");
        return this.f58253c && this.f58254d.s(type);
    }

    public final boolean m() {
        return this.f58251a;
    }

    public final boolean n() {
        return this.f58252b;
    }

    @NotNull
    public final r2.g o(@NotNull r2.g type) {
        kotlin.jvm.internal.f0.p(type, "type");
        return this.f58255e.a(type);
    }

    @NotNull
    public final r2.g p(@NotNull r2.g type) {
        kotlin.jvm.internal.f0.p(type, "type");
        return this.f58256f.a(type);
    }
}
