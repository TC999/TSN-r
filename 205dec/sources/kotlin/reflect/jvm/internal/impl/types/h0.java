package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: SpecialTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h0 extends m1 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f58377b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d2.a<e0> f58378c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<e0> f58379d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.a<e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.g f58380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f58381b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.types.checker.g gVar, h0 h0Var) {
            super(0);
            this.f58380a = gVar;
            this.f58381b = h0Var;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final e0 invoke() {
            return this.f58380a.h((r2.g) this.f58381b.f58378c.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull d2.a<? extends e0> computation) {
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(computation, "computation");
        this.f58377b = storageManager;
        this.f58378c = computation;
        this.f58379d = storageManager.g(computation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m1
    @NotNull
    protected e0 L0() {
        return this.f58379d.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m1
    public boolean M0() {
        return this.f58379d.r();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e0
    @NotNull
    /* renamed from: O0 */
    public h0 J0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new h0(this.f58377b, new a(kotlinTypeRefiner, this));
    }
}
