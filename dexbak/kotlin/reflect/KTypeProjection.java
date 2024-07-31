package kotlin.reflect;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, m12616d2 = {"Lkotlin/reflect/t;", "", "", "toString", "Lkotlin/reflect/KVariance;", "a", "Lkotlin/reflect/r;", "b", "variance", "type", "d", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Lkotlin/reflect/KVariance;", "g", "()Lkotlin/reflect/KVariance;", "Lkotlin/reflect/r;", "getType", "()Lkotlin/reflect/r;", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/r;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class KTypeProjection {
    @Nullable

    /* renamed from: a */
    private final KVariance f41341a;
    @Nullable

    /* renamed from: b */
    private final KType f41342b;
    @NotNull

    /* renamed from: d */
    public static final C14457a f41340d = new C14457a(null);
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    public static final KTypeProjection f41339c = new KTypeProjection(null, null);

    /* compiled from: KTypeProjection.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m12616d2 = {"Lkotlin/reflect/t$a;", "", "Lkotlin/reflect/r;", "type", "Lkotlin/reflect/t;", "e", "a", "b", "c", "()Lkotlin/reflect/t;", "STAR", "star", "Lkotlin/reflect/t;", "getStar$annotations", "()V", "<init>", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.t$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14457a {
        private C14457a() {
        }

        @PublishedApi
        /* renamed from: d */
        public static /* synthetic */ void m7303d() {
        }

        @JvmStatic
        @NotNull
        /* renamed from: a */
        public final KTypeProjection m7306a(@NotNull KType type) {
            C14342f0.m8184p(type, "type");
            return new KTypeProjection(KVariance.IN, type);
        }

        @JvmStatic
        @NotNull
        /* renamed from: b */
        public final KTypeProjection m7305b(@NotNull KType type) {
            C14342f0.m8184p(type, "type");
            return new KTypeProjection(KVariance.OUT, type);
        }

        @NotNull
        /* renamed from: c */
        public final KTypeProjection m7304c() {
            return KTypeProjection.f41339c;
        }

        @JvmStatic
        @NotNull
        /* renamed from: e */
        public final KTypeProjection m7302e(@NotNull KType type) {
            C14342f0.m8184p(type, "type");
            return new KTypeProjection(KVariance.INVARIANT, type);
        }

        public /* synthetic */ C14457a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KTypeProjection(@Nullable KVariance kVariance, @Nullable KType kType) {
        String str;
        this.f41341a = kVariance;
        this.f41342b = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @JvmStatic
    @NotNull
    /* renamed from: c */
    public static final KTypeProjection m7312c(@NotNull KType kType) {
        return f41340d.m7306a(kType);
    }

    /* renamed from: e */
    public static /* synthetic */ KTypeProjection m7310e(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.f41341a;
        }
        if ((i & 2) != 0) {
            kType = kTypeProjection.f41342b;
        }
        return kTypeProjection.m7311d(kVariance, kType);
    }

    @JvmStatic
    @NotNull
    /* renamed from: f */
    public static final KTypeProjection m7309f(@NotNull KType kType) {
        return f41340d.m7305b(kType);
    }

    @JvmStatic
    @NotNull
    /* renamed from: h */
    public static final KTypeProjection m7307h(@NotNull KType kType) {
        return f41340d.m7302e(kType);
    }

    @Nullable
    /* renamed from: a */
    public final KVariance m7314a() {
        return this.f41341a;
    }

    @Nullable
    /* renamed from: b */
    public final KType m7313b() {
        return this.f41342b;
    }

    @NotNull
    /* renamed from: d */
    public final KTypeProjection m7311d(@Nullable KVariance kVariance, @Nullable KType kType) {
        return new KTypeProjection(kVariance, kType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof KTypeProjection) {
                KTypeProjection kTypeProjection = (KTypeProjection) obj;
                return C14342f0.m8193g(this.f41341a, kTypeProjection.f41341a) && C14342f0.m8193g(this.f41342b, kTypeProjection.f41342b);
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: g */
    public final KVariance m7308g() {
        return this.f41341a;
    }

    @Nullable
    public final KType getType() {
        return this.f41342b;
    }

    public int hashCode() {
        KVariance kVariance = this.f41341a;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.f41342b;
        return hashCode + (kType != null ? kType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.f41341a;
        if (kVariance == null) {
            return "*";
        }
        int i = C14458u.f41343a[kVariance.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "in " + this.f41342b;
            } else if (i == 3) {
                return "out " + this.f41342b;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return String.valueOf(this.f41342b);
    }
}
