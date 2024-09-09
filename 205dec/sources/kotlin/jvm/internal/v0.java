package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TypeReference.kt */
@SinceKotlin(version = "1.4")
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\b\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u000fB1\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010%\u001a\u00020\u000b\u00a2\u0006\u0004\b/\u00100B'\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0006\u0010.\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0006H\u0002J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u001a\u0010\u0012\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR \u0010%\u001a\u00020\u000b8\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010\u001e\u001a\u0004\b\"\u0010#R\u001c\u0010)\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u0014\u0010.\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010-\u00a8\u00062"}, d2 = {"Lkotlin/jvm/internal/v0;", "Lkotlin/reflect/r;", "", "convertPrimitiveToWrapper", "", "h", "Lkotlin/reflect/t;", "e", "", "other", "equals", "", "hashCode", "toString", "Lkotlin/reflect/g;", "a", "Lkotlin/reflect/g;", "()Lkotlin/reflect/g;", "classifier", "", "b", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "arguments", "c", "Lkotlin/reflect/r;", "s", "()Lkotlin/reflect/r;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "platformTypeUpperBound", "d", "I", "o", "()I", "getFlags$kotlin_stdlib$annotations", "flags", "Ljava/lang/Class;", "l", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "", "getAnnotations", "annotations", "()Z", "isMarkedNullable", "<init>", "(Lkotlin/reflect/g;Ljava/util/List;Lkotlin/reflect/r;I)V", "(Lkotlin/reflect/g;Ljava/util/List;Z)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v0 implements kotlin.reflect.r {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f55698e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    public static final int f55699f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f55700g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f55701h = 4;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.g f55702a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<kotlin.reflect.t> f55703b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.r f55704c;

    /* renamed from: d  reason: collision with root package name */
    private final int f55705d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: TypeReference.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lkotlin/jvm/internal/v0$a;", "", "", "IS_MARKED_NULLABLE", "I", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: TypeReference.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55706a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f55706a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeReference.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/t;", "it", "", "a", "(Lkotlin/reflect/t;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<kotlin.reflect.t, CharSequence> {
        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull kotlin.reflect.t it) {
            f0.p(it, "it");
            return v0.this.e(it);
        }
    }

    @SinceKotlin(version = "1.6")
    public v0(@NotNull kotlin.reflect.g classifier, @NotNull List<kotlin.reflect.t> arguments, @Nullable kotlin.reflect.r rVar, int i4) {
        f0.p(classifier, "classifier");
        f0.p(arguments, "arguments");
        this.f55702a = classifier;
        this.f55703b = arguments;
        this.f55704c = rVar;
        this.f55705d = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(kotlin.reflect.t tVar) {
        if (tVar.g() == null) {
            return "*";
        }
        kotlin.reflect.r type = tVar.getType();
        v0 v0Var = type instanceof v0 ? (v0) type : null;
        String valueOf = v0Var == null ? String.valueOf(tVar.getType()) : v0Var.h(true);
        int i4 = b.f55706a[tVar.g().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return f0.C("out ", valueOf);
                }
                throw new NoWhenBranchMatchedException();
            }
            return f0.C("in ", valueOf);
        }
        return valueOf;
    }

    private final String h(boolean z3) {
        String name;
        kotlin.reflect.g a4 = a();
        kotlin.reflect.d dVar = a4 instanceof kotlin.reflect.d ? (kotlin.reflect.d) a4 : null;
        Class<?> c4 = dVar != null ? c2.a.c(dVar) : null;
        if (c4 == null) {
            name = a().toString();
        } else if ((this.f55705d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (c4.isArray()) {
            name = l(c4);
        } else {
            name = (z3 && c4.isPrimitive()) ? c2.a.e((kotlin.reflect.d) a()).getName() : c4.getName();
        }
        String str = name + (getArguments().isEmpty() ? "" : kotlin.collections.f0.X2(getArguments(), ", ", "<", ">", 0, null, new c(), 24, null)) + (b() ? "?" : "");
        kotlin.reflect.r rVar = this.f55704c;
        if (rVar instanceof v0) {
            String h4 = ((v0) rVar).h(true);
            if (f0.g(h4, str)) {
                return str;
            }
            if (f0.g(h4, f0.C(str, "?"))) {
                return f0.C(str, "!");
            }
            return '(' + str + ".." + h4 + ')';
        }
        return str;
    }

    private final String l(Class<?> cls) {
        return f0.g(cls, boolean[].class) ? "kotlin.BooleanArray" : f0.g(cls, char[].class) ? "kotlin.CharArray" : f0.g(cls, byte[].class) ? "kotlin.ByteArray" : f0.g(cls, short[].class) ? "kotlin.ShortArray" : f0.g(cls, int[].class) ? "kotlin.IntArray" : f0.g(cls, float[].class) ? "kotlin.FloatArray" : f0.g(cls, long[].class) ? "kotlin.LongArray" : f0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void r() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void u() {
    }

    @Override // kotlin.reflect.r
    @NotNull
    public kotlin.reflect.g a() {
        return this.f55702a;
    }

    @Override // kotlin.reflect.r
    public boolean b() {
        return (this.f55705d & 1) != 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof v0) {
            v0 v0Var = (v0) obj;
            if (f0.g(a(), v0Var.a()) && f0.g(getArguments(), v0Var.getArguments()) && f0.g(this.f55704c, v0Var.f55704c) && this.f55705d == v0Var.f55705d) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.r
    @NotNull
    public List<kotlin.reflect.t> getArguments() {
        return this.f55703b;
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.valueOf(this.f55705d).hashCode();
    }

    public final int o() {
        return this.f55705d;
    }

    @Nullable
    public final kotlin.reflect.r s() {
        return this.f55704c;
    }

    @NotNull
    public String toString() {
        return f0.C(h(false), " (Kotlin reflection is not available)");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v0(@NotNull kotlin.reflect.g classifier, @NotNull List<kotlin.reflect.t> arguments, boolean z3) {
        this(classifier, arguments, null, z3 ? 1 : 0);
        f0.p(classifier, "classifier");
        f0.p(arguments, "arguments");
    }
}
