package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KTypeProjection.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J!\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lkotlin/reflect/t;", "", "", "toString", "Lkotlin/reflect/KVariance;", "a", "Lkotlin/reflect/r;", "b", "variance", "type", "d", "", "hashCode", "other", "", "equals", "Lkotlin/reflect/KVariance;", "g", "()Lkotlin/reflect/KVariance;", "Lkotlin/reflect/r;", "getType", "()Lkotlin/reflect/r;", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/r;)V", "c", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f58685c = new a(null);
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final t f58686d = new t(null, null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final KVariance f58687a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final r f58688b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: KTypeProjection.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0011\u0010\n\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lkotlin/reflect/t$a;", "", "Lkotlin/reflect/r;", "type", "Lkotlin/reflect/t;", "e", "a", "b", "c", "()Lkotlin/reflect/t;", "STAR", "star", "Lkotlin/reflect/t;", "getStar$annotations", "()V", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @PublishedApi
        public static /* synthetic */ void d() {
        }

        @JvmStatic
        @NotNull
        public final t a(@NotNull r type) {
            f0.p(type, "type");
            return new t(KVariance.IN, type);
        }

        @JvmStatic
        @NotNull
        public final t b(@NotNull r type) {
            f0.p(type, "type");
            return new t(KVariance.OUT, type);
        }

        @NotNull
        public final t c() {
            return t.f58686d;
        }

        @JvmStatic
        @NotNull
        public final t e(@NotNull r type) {
            f0.p(type, "type");
            return new t(KVariance.INVARIANT, type);
        }
    }

    /* compiled from: KTypeProjection.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58689a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f58689a = iArr;
        }
    }

    public t(@Nullable KVariance kVariance, @Nullable r rVar) {
        String str;
        this.f58687a = kVariance;
        this.f58688b = rVar;
        if ((kVariance == null) == (rVar == null)) {
            return;
        }
        if (g() == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + g() + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @JvmStatic
    @NotNull
    public static final t c(@NotNull r rVar) {
        return f58685c.a(rVar);
    }

    public static /* synthetic */ t e(t tVar, KVariance kVariance, r rVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            kVariance = tVar.f58687a;
        }
        if ((i4 & 2) != 0) {
            rVar = tVar.f58688b;
        }
        return tVar.d(kVariance, rVar);
    }

    @JvmStatic
    @NotNull
    public static final t f(@NotNull r rVar) {
        return f58685c.b(rVar);
    }

    @JvmStatic
    @NotNull
    public static final t h(@NotNull r rVar) {
        return f58685c.e(rVar);
    }

    @Nullable
    public final KVariance a() {
        return this.f58687a;
    }

    @Nullable
    public final r b() {
        return this.f58688b;
    }

    @NotNull
    public final t d(@Nullable KVariance kVariance, @Nullable r rVar) {
        return new t(kVariance, rVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.f58687a == tVar.f58687a && f0.g(this.f58688b, tVar.f58688b);
        }
        return false;
    }

    @Nullable
    public final KVariance g() {
        return this.f58687a;
    }

    @Nullable
    public final r getType() {
        return this.f58688b;
    }

    public int hashCode() {
        KVariance kVariance = this.f58687a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        r rVar = this.f58688b;
        return hashCode + (rVar != null ? rVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.f58687a;
        int i4 = kVariance == null ? -1 : b.f58689a[kVariance.ordinal()];
        if (i4 != -1) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return f0.C("out ", this.f58688b);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return f0.C("in ", this.f58688b);
            }
            return String.valueOf(this.f58688b);
        }
        return "*";
    }
}
