package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final NullabilityQualifier f57006a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f57007b;

    public f(@NotNull NullabilityQualifier qualifier, boolean z3) {
        f0.p(qualifier, "qualifier");
        this.f57006a = qualifier;
        this.f57007b = z3;
    }

    public static /* synthetic */ f b(f fVar, NullabilityQualifier nullabilityQualifier, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            nullabilityQualifier = fVar.f57006a;
        }
        if ((i4 & 2) != 0) {
            z3 = fVar.f57007b;
        }
        return fVar.a(nullabilityQualifier, z3);
    }

    @NotNull
    public final f a(@NotNull NullabilityQualifier qualifier, boolean z3) {
        f0.p(qualifier, "qualifier");
        return new f(qualifier, z3);
    }

    @NotNull
    public final NullabilityQualifier c() {
        return this.f57006a;
    }

    public final boolean d() {
        return this.f57007b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f57006a == fVar.f57006a && this.f57007b == fVar.f57007b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f57006a.hashCode() * 31;
        boolean z3 = this.f57007b;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f57006a + ", isForWarningOnly=" + this.f57007b + ')';
    }

    public /* synthetic */ f(NullabilityQualifier nullabilityQualifier, boolean z3, int i4, u uVar) {
        this(nullabilityQualifier, (i4 & 2) != 0 ? false : z3);
    }
}
