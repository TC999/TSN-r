package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.p;
import kotlin.collections.y;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.c0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CapturedTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.a<e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a1 f57824a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(a1 a1Var) {
            super(0);
            this.f57824a = a1Var;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final e0 invoke() {
            e0 type = this.f57824a.getType();
            f0.o(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* compiled from: CapturedTypeConstructor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends o {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d1 f57825d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f57826e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d1 d1Var, boolean z3) {
            super(d1Var);
            this.f57825d = d1Var;
            this.f57826e = z3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.o, kotlin.reflect.jvm.internal.impl.types.d1
        public boolean b() {
            return this.f57826e;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.o, kotlin.reflect.jvm.internal.impl.types.d1
        @Nullable
        public a1 e(@NotNull e0 key) {
            f0.p(key, "key");
            a1 e4 = super.e(key);
            if (e4 == null) {
                return null;
            }
            f b4 = key.H0().b();
            return d.b(e4, b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1 ? (kotlin.reflect.jvm.internal.impl.descriptors.a1) b4 : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a1 b(a1 a1Var, kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2) {
        if (a1Var2 == null || a1Var.c() == Variance.INVARIANT) {
            return a1Var;
        }
        if (a1Var2.o() == a1Var.c()) {
            if (a1Var.b()) {
                n NO_LOCKS = kotlin.reflect.jvm.internal.impl.storage.f.f58216e;
                f0.o(NO_LOCKS, "NO_LOCKS");
                return new c1(new h0(NO_LOCKS, new a(a1Var)));
            }
            return new c1(a1Var.getType());
        }
        return new c1(c(a1Var));
    }

    @NotNull
    public static final e0 c(@NotNull a1 typeProjection) {
        f0.p(typeProjection, "typeProjection");
        return new kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a(typeProjection, null, false, null, 14, null);
    }

    public static final boolean d(@NotNull e0 e0Var) {
        f0.p(e0Var, "<this>");
        return e0Var.H0() instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b;
    }

    @NotNull
    public static final d1 e(@NotNull d1 d1Var, boolean z3) {
        List<Pair> Oz;
        int Z;
        f0.p(d1Var, "<this>");
        if (d1Var instanceof c0) {
            c0 c0Var = (c0) d1Var;
            kotlin.reflect.jvm.internal.impl.descriptors.a1[] j4 = c0Var.j();
            Oz = p.Oz(c0Var.i(), c0Var.j());
            Z = y.Z(Oz, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (Pair pair : Oz) {
                arrayList.add(b((a1) pair.getFirst(), (kotlin.reflect.jvm.internal.impl.descriptors.a1) pair.getSecond()));
            }
            Object[] array = arrayList.toArray(new a1[0]);
            if (array != null) {
                return new c0(j4, (a1[]) array, z3);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return new b(d1Var, z3);
    }

    public static /* synthetic */ d1 f(d1 d1Var, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = true;
        }
        return e(d1Var, z3);
    }
}
