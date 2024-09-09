package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeReference.kt */
@SinceKotlin(version = "1.4")
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012\u0006\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0004H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0017\u00a8\u0006'"}, d2 = {"Lkotlin/jvm/internal/x0;", "Lkotlin/reflect/r;", "", "i", "Lkotlin/reflect/t;", CampaignEx.JSON_KEY_AD_Q, "", "other", "", "equals", "", "hashCode", "toString", "Lkotlin/reflect/g;", "a", "Lkotlin/reflect/g;", "o", "()Lkotlin/reflect/g;", "classifier", "", "b", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "arguments", "c", "Z", "f", "()Z", "isMarkedNullable", "Ljava/lang/Class;", "z", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "", "getAnnotations", "annotations", "<init>", "(Lkotlin/reflect/g;Ljava/util/List;Z)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class x0 implements kotlin.reflect.r {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.g f55711a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<kotlin.reflect.t> f55712b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f55713c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeReference.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/t;", "it", "", "a", "(Lkotlin/reflect/t;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a extends Lambda implements l1.l<kotlin.reflect.t, CharSequence> {
        a() {
            super(1);
        }

        @Override // l1.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull kotlin.reflect.t it) {
            f0.p(it, "it");
            return x0.this.q(it);
        }
    }

    public x0(@NotNull kotlin.reflect.g classifier, @NotNull List<kotlin.reflect.t> arguments, boolean z3) {
        f0.p(classifier, "classifier");
        f0.p(arguments, "arguments");
        this.f55711a = classifier;
        this.f55712b = arguments;
        this.f55713c = z3;
    }

    private final String i() {
        String z3;
        kotlin.reflect.g o4 = o();
        if (!(o4 instanceof kotlin.reflect.d)) {
            o4 = null;
        }
        kotlin.reflect.d dVar = (kotlin.reflect.d) o4;
        Class<?> c4 = dVar != null ? k1.a.c(dVar) : null;
        if (c4 == null) {
            z3 = o().toString();
        } else {
            z3 = c4.isArray() ? z(c4) : c4.getName();
        }
        return z3 + (getArguments().isEmpty() ? "" : kotlin.collections.v.Z2(getArguments(), ", ", "<", ">", 0, null, new a(), 24, null)) + (f() ? "?" : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q(kotlin.reflect.t tVar) {
        String valueOf;
        if (tVar.g() == null) {
            return "*";
        }
        kotlin.reflect.r type = tVar.getType();
        if (!(type instanceof x0)) {
            type = null;
        }
        x0 x0Var = (x0) type;
        if (x0Var == null || (valueOf = x0Var.i()) == null) {
            valueOf = String.valueOf(tVar.getType());
        }
        KVariance g4 = tVar.g();
        if (g4 != null) {
            int i4 = w0.f55709a[g4.ordinal()];
            if (i4 == 1) {
                return valueOf;
            }
            if (i4 == 2) {
                return "in " + valueOf;
            } else if (i4 == 3) {
                return "out " + valueOf;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String z(Class<?> cls) {
        return f0.g(cls, boolean[].class) ? "kotlin.BooleanArray" : f0.g(cls, char[].class) ? "kotlin.CharArray" : f0.g(cls, byte[].class) ? "kotlin.ByteArray" : f0.g(cls, short[].class) ? "kotlin.ShortArray" : f0.g(cls, int[].class) ? "kotlin.IntArray" : f0.g(cls, float[].class) ? "kotlin.FloatArray" : f0.g(cls, long[].class) ? "kotlin.LongArray" : f0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof x0) {
            x0 x0Var = (x0) obj;
            if (f0.g(o(), x0Var.o()) && f0.g(getArguments(), x0Var.getArguments()) && f() == x0Var.f()) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f55713c;
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        return kotlin.collections.v.E();
    }

    @Override // kotlin.reflect.r
    @NotNull
    public List<kotlin.reflect.t> getArguments() {
        return this.f55712b;
    }

    public int hashCode() {
        return (((o().hashCode() * 31) + getArguments().hashCode()) * 31) + Boolean.valueOf(f()).hashCode();
    }

    @NotNull
    public kotlin.reflect.g o() {
        return this.f55711a;
    }

    @NotNull
    public String toString() {
        return i() + " (Kotlin reflection is not available)";
    }
}
