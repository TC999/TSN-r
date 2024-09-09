package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationQualifiersFqNames.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f f56974a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Collection<AnnotationQualifierApplicabilityType> f56975b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f56976c;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f nullabilityQualifier, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z3) {
        f0.p(nullabilityQualifier, "nullabilityQualifier");
        f0.p(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f56974a = nullabilityQualifier;
        this.f56975b = qualifierApplicabilityTypes;
        this.f56976c = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ p b(p pVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar, Collection collection, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = pVar.f56974a;
        }
        if ((i4 & 2) != 0) {
            collection = pVar.f56975b;
        }
        if ((i4 & 4) != 0) {
            z3 = pVar.f56976c;
        }
        return pVar.a(fVar, collection, z3);
    }

    @NotNull
    public final p a(@NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f nullabilityQualifier, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z3) {
        f0.p(nullabilityQualifier, "nullabilityQualifier");
        f0.p(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new p(nullabilityQualifier, qualifierApplicabilityTypes, z3);
    }

    public final boolean c() {
        return this.f56976c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f d() {
        return this.f56974a;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> e() {
        return this.f56975b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return f0.g(this.f56974a, pVar.f56974a) && f0.g(this.f56975b, pVar.f56975b) && this.f56976c == pVar.f56976c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f56974a.hashCode() * 31) + this.f56975b.hashCode()) * 31;
        boolean z3 = this.f56976c;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f56974a + ", qualifierApplicabilityTypes=" + this.f56975b + ", definitelyNotNull=" + this.f56976c + ')';
    }

    public /* synthetic */ p(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar, Collection collection, boolean z3, int i4, kotlin.jvm.internal.u uVar) {
        this(fVar, collection, (i4 & 4) != 0 ? fVar.c() == NullabilityQualifier.NOT_NULL : z3);
    }
}
