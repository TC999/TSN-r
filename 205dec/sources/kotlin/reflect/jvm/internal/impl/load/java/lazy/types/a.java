package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.k1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TypeUsage f56936a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final JavaTypeFlexibility f56937b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f56938c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Set<a1> f56939d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final m0 f56940e;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean z3, @Nullable Set<? extends a1> set, @Nullable m0 m0Var) {
        f0.p(howThisTypeIsUsed, "howThisTypeIsUsed");
        f0.p(flexibility, "flexibility");
        this.f56936a = howThisTypeIsUsed;
        this.f56937b = flexibility;
        this.f56938c = z3;
        this.f56939d = set;
        this.f56940e = m0Var;
    }

    public static /* synthetic */ a b(a aVar, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z3, Set set, m0 m0Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            typeUsage = aVar.f56936a;
        }
        if ((i4 & 2) != 0) {
            javaTypeFlexibility = aVar.f56937b;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i4 & 4) != 0) {
            z3 = aVar.f56938c;
        }
        boolean z4 = z3;
        Set<a1> set2 = set;
        if ((i4 & 8) != 0) {
            set2 = aVar.f56939d;
        }
        Set set3 = set2;
        if ((i4 & 16) != 0) {
            m0Var = aVar.f56940e;
        }
        return aVar.a(typeUsage, javaTypeFlexibility2, z4, set3, m0Var);
    }

    @NotNull
    public final a a(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean z3, @Nullable Set<? extends a1> set, @Nullable m0 m0Var) {
        f0.p(howThisTypeIsUsed, "howThisTypeIsUsed");
        f0.p(flexibility, "flexibility");
        return new a(howThisTypeIsUsed, flexibility, z3, set, m0Var);
    }

    @Nullable
    public final m0 c() {
        return this.f56940e;
    }

    @NotNull
    public final JavaTypeFlexibility d() {
        return this.f56937b;
    }

    @NotNull
    public final TypeUsage e() {
        return this.f56936a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f56936a == aVar.f56936a && this.f56937b == aVar.f56937b && this.f56938c == aVar.f56938c && f0.g(this.f56939d, aVar.f56939d) && f0.g(this.f56940e, aVar.f56940e);
        }
        return false;
    }

    @Nullable
    public final Set<a1> f() {
        return this.f56939d;
    }

    public final boolean g() {
        return this.f56938c;
    }

    @NotNull
    public final a h(@Nullable m0 m0Var) {
        return b(this, null, null, false, null, m0Var, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f56936a.hashCode() * 31) + this.f56937b.hashCode()) * 31;
        boolean z3 = this.f56938c;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode + i4) * 31;
        Set<a1> set = this.f56939d;
        int hashCode2 = (i5 + (set == null ? 0 : set.hashCode())) * 31;
        m0 m0Var = this.f56940e;
        return hashCode2 + (m0Var != null ? m0Var.hashCode() : 0);
    }

    @NotNull
    public final a i(@NotNull JavaTypeFlexibility flexibility) {
        f0.p(flexibility, "flexibility");
        return b(this, null, flexibility, false, null, null, 29, null);
    }

    @NotNull
    public final a j(@NotNull a1 typeParameter) {
        f0.p(typeParameter, "typeParameter");
        Set<a1> set = this.f56939d;
        return b(this, null, null, false, set != null ? k1.D(set, typeParameter) : i1.f(typeParameter), null, 23, null);
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f56936a + ", flexibility=" + this.f56937b + ", isForAnnotationParameter=" + this.f56938c + ", visitedTypeParameters=" + this.f56939d + ", defaultType=" + this.f56940e + ')';
    }

    public /* synthetic */ a(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z3, Set set, m0 m0Var, int i4, u uVar) {
        this(typeUsage, (i4 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i4 & 4) != 0 ? false : z3, (i4 & 8) != 0 ? null : set, (i4 & 16) != 0 ? null : m0Var);
    }
}
