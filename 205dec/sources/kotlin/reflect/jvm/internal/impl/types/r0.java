package kotlin.reflect.jvm.internal.impl.types;

import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r0 extends b1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a1 f58407a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.p f58408b;

    /* compiled from: StarProjectionImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<e0> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final e0 invoke() {
            return s0.b(r0.this.f58407a);
        }
    }

    public r0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 typeParameter) {
        kotlin.p c4;
        kotlin.jvm.internal.f0.p(typeParameter, "typeParameter");
        this.f58407a = typeParameter;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new a());
        this.f58408b = c4;
    }

    private final e0 e() {
        return (e0) this.f58408b.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public a1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    public boolean b() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    @NotNull
    public e0 getType() {
        return e();
    }
}
