package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: signatureEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e0 f57080a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.p f57081b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final a1 f57082c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f57083d;

    public l(@NotNull e0 type, @Nullable kotlin.reflect.jvm.internal.impl.load.java.p pVar, @Nullable a1 a1Var, boolean z3) {
        f0.p(type, "type");
        this.f57080a = type;
        this.f57081b = pVar;
        this.f57082c = a1Var;
        this.f57083d = z3;
    }

    @NotNull
    public final e0 a() {
        return this.f57080a;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.load.java.p b() {
        return this.f57081b;
    }

    @Nullable
    public final a1 c() {
        return this.f57082c;
    }

    public final boolean d() {
        return this.f57083d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return f0.g(this.f57080a, lVar.f57080a) && f0.g(this.f57081b, lVar.f57081b) && f0.g(this.f57082c, lVar.f57082c) && this.f57083d == lVar.f57083d;
        }
        return false;
    }

    @NotNull
    public final e0 getType() {
        return this.f57080a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f57080a.hashCode() * 31;
        kotlin.reflect.jvm.internal.impl.load.java.p pVar = this.f57081b;
        int hashCode2 = (hashCode + (pVar == null ? 0 : pVar.hashCode())) * 31;
        a1 a1Var = this.f57082c;
        int hashCode3 = (hashCode2 + (a1Var != null ? a1Var.hashCode() : 0)) * 31;
        boolean z3 = this.f57083d;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode3 + i4;
    }

    @NotNull
    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.f57080a + ", defaultQualifiers=" + this.f57081b + ", typeParameterForArgument=" + this.f57082c + ", isFromStarProjection=" + this.f57083d + ')';
    }
}
