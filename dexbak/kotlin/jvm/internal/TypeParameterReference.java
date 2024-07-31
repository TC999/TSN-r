package kotlin.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsJVM;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = BuildConfig.VERSION_NAME)
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u000fB)\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006*"}, m12616d2 = {"Lkotlin/jvm/internal/v0;", "Lkotlin/reflect/s;", "", "Lkotlin/reflect/r;", "upperBounds", "Lkotlin/f1;", "f", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "a", "Ljava/util/List;", "bounds", "b", "Ljava/lang/Object;", "container", "c", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KVariance;", "d", "Lkotlin/reflect/KVariance;", "i", "()Lkotlin/reflect/KVariance;", "variance", "e", "Z", "()Z", "isReified", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.v0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class TypeParameterReference implements KTypeParameter {
    @NotNull

    /* renamed from: f */
    public static final C14364a f41202f = new C14364a(null);

    /* renamed from: a */
    private volatile List<? extends KType> f41203a;

    /* renamed from: b */
    private final Object f41204b;
    @NotNull

    /* renamed from: c */
    private final String f41205c;
    @NotNull

    /* renamed from: d */
    private final KVariance f41206d;

    /* renamed from: e */
    private final boolean f41207e;

    /* compiled from: TypeParameterReference.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, m12616d2 = {"Lkotlin/jvm/internal/v0$a;", "", "Lkotlin/reflect/s;", "typeParameter", "", "a", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.jvm.internal.v0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14364a {
        private C14364a() {
        }

        @NotNull
        /* renamed from: a */
        public final String m7986a(@NotNull KTypeParameter typeParameter) {
            C14342f0.m8184p(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = C14362u0.f41193a[typeParameter.mo7315i().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            String sb2 = sb.toString();
            C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public /* synthetic */ C14364a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TypeParameterReference(@Nullable Object obj, @NotNull String name, @NotNull KVariance variance, boolean z) {
        C14342f0.m8184p(name, "name");
        C14342f0.m8184p(variance, "variance");
        this.f41204b = obj;
        this.f41205c = name;
        this.f41206d = variance;
        this.f41207e = z;
    }

    /* renamed from: b */
    public static /* synthetic */ void m7988b() {
    }

    @Override // kotlin.reflect.KTypeParameter
    /* renamed from: e */
    public boolean mo7316e() {
        return this.f41207e;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
            if (C14342f0.m8193g(this.f41204b, typeParameterReference.f41204b) && C14342f0.m8193g(getName(), typeParameterReference.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final void m7987f(@NotNull List<? extends KType> upperBounds) {
        C14342f0.m8184p(upperBounds, "upperBounds");
        if (this.f41203a == null) {
            this.f41203a = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public String getName() {
        return this.f41205c;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public List<KType> getUpperBounds() {
        List<KType> m8965k;
        List list = this.f41203a;
        if (list != null) {
            return list;
        }
        m8965k = CollectionsJVM.m8965k(Reflection.m8115l(Object.class));
        this.f41203a = m8965k;
        return m8965k;
    }

    public int hashCode() {
        Object obj = this.f41204b;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    /* renamed from: i */
    public KVariance mo7315i() {
        return this.f41206d;
    }

    @NotNull
    public String toString() {
        return f41202f.m7986a(this);
    }
}
