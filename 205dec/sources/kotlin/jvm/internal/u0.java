package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TypeParameterReference.kt */
@SinceKotlin(version = "1.4")
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001\u000fB)\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\t\u00a2\u0006\u0004\b(\u0010)J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lkotlin/jvm/internal/u0;", "Lkotlin/reflect/s;", "", "Lkotlin/reflect/r;", "upperBounds", "Lkotlin/f1;", "b", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/Object;", "container", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KVariance;", "c", "Lkotlin/reflect/KVariance;", "o", "()Lkotlin/reflect/KVariance;", "variance", "d", "Z", "l", "()Z", "isReified", "e", "Ljava/util/List;", "bounds", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "f", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u0 implements kotlin.reflect.s {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f55683f = new a(null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Object f55684a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f55685b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final KVariance f55686c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f55687d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private volatile List<? extends kotlin.reflect.r> f55688e;

    /* compiled from: TypeParameterReference.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lkotlin/jvm/internal/u0$a;", "", "Lkotlin/reflect/s;", "typeParameter", "", "a", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: TypeParameterReference.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: kotlin.jvm.internal.u0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class C1102a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f55689a;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                f55689a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final String a(@NotNull kotlin.reflect.s typeParameter) {
            f0.p(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i4 = C1102a.f55689a[typeParameter.o().ordinal()];
            if (i4 == 2) {
                sb.append("in ");
            } else if (i4 == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            String sb2 = sb.toString();
            f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    public u0(@Nullable Object obj, @NotNull String name, @NotNull KVariance variance, boolean z3) {
        f0.p(name, "name");
        f0.p(variance, "variance");
        this.f55684a = obj;
        this.f55685b = name;
        this.f55686c = variance;
        this.f55687d = z3;
    }

    public static /* synthetic */ void a() {
    }

    public final void b(@NotNull List<? extends kotlin.reflect.r> upperBounds) {
        f0.p(upperBounds, "upperBounds");
        if (this.f55688e == null) {
            this.f55688e = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof u0) {
            u0 u0Var = (u0) obj;
            if (f0.g(this.f55684a, u0Var.f55684a) && f0.g(getName(), u0Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public String getName() {
        return this.f55685b;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public List<kotlin.reflect.r> getUpperBounds() {
        List<kotlin.reflect.r> l4;
        List list = this.f55688e;
        if (list == null) {
            l4 = kotlin.collections.x.l(n0.n(Object.class));
            this.f55688e = l4;
            return l4;
        }
        return list;
    }

    public int hashCode() {
        Object obj = this.f55684a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.s
    public boolean l() {
        return this.f55687d;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public KVariance o() {
        return this.f55686c;
    }

    @NotNull
    public String toString() {
        return f55683f.a(this);
    }
}
