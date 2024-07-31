package kotlin.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections._Collections;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p612k1.JvmClassMapping;
import p617l1.InterfaceC15280l;

@SinceKotlin(version = BuildConfig.VERSION_NAME)
@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012\u0006\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0004H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0017¨\u0006'"}, m12616d2 = {"Lkotlin/jvm/internal/x0;", "Lkotlin/reflect/r;", "", "i", "Lkotlin/reflect/t;", CampaignEx.JSON_KEY_AD_Q, "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "toString", "Lkotlin/reflect/g;", "a", "Lkotlin/reflect/g;", "o", "()Lkotlin/reflect/g;", "classifier", "", "b", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "arguments", "c", "Z", "f", "()Z", "isMarkedNullable", "Ljava/lang/Class;", UMCommonContent.f37777aG, "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "", "getAnnotations", "annotations", "<init>", "(Lkotlin/reflect/g;Ljava/util/List;Z)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.x0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class TypeReference implements KType {
    @NotNull

    /* renamed from: a */
    private final KClassifier f41211a;
    @NotNull

    /* renamed from: b */
    private final List<KTypeProjection> f41212b;

    /* renamed from: c */
    private final boolean f41213c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeReference.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/reflect/t;", "it", "", "a", "(Lkotlin/reflect/t;)Ljava/lang/CharSequence;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.jvm.internal.x0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14368a extends Lambda implements InterfaceC15280l<KTypeProjection, CharSequence> {
        C14368a() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull KTypeProjection it) {
            C14342f0.m8184p(it, "it");
            return TypeReference.this.m7980q(it);
        }
    }

    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> arguments, boolean z) {
        C14342f0.m8184p(classifier, "classifier");
        C14342f0.m8184p(arguments, "arguments");
        this.f41211a = classifier;
        this.f41212b = arguments;
        this.f41213c = z;
    }

    /* renamed from: i */
    private final String m7981i() {
        String m7979z;
        KClassifier mo7319o = mo7319o();
        if (!(mo7319o instanceof KClass)) {
            mo7319o = null;
        }
        KClass kClass = (KClass) mo7319o;
        Class<?> m12626c = kClass != null ? JvmClassMapping.m12626c(kClass) : null;
        if (m12626c == null) {
            m7979z = mo7319o().toString();
        } else {
            m7979z = m12626c.isArray() ? m7979z(m12626c) : m12626c.getName();
        }
        return m7979z + (getArguments().isEmpty() ? "" : _Collections.m12151Z2(getArguments(), ", ", "<", ">", 0, null, new C14368a(), 24, null)) + (mo7320f() ? "?" : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public final String m7980q(KTypeProjection kTypeProjection) {
        String valueOf;
        if (kTypeProjection.m7308g() == null) {
            return "*";
        }
        KType type = kTypeProjection.getType();
        if (!(type instanceof TypeReference)) {
            type = null;
        }
        TypeReference typeReference = (TypeReference) type;
        if (typeReference == null || (valueOf = typeReference.m7981i()) == null) {
            valueOf = String.valueOf(kTypeProjection.getType());
        }
        KVariance m7308g = kTypeProjection.m7308g();
        if (m7308g != null) {
            int i = C14366w0.f41209a[m7308g.ordinal()];
            if (i == 1) {
                return valueOf;
            }
            if (i == 2) {
                return "in " + valueOf;
            } else if (i == 3) {
                return "out " + valueOf;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: z */
    private final String m7979z(Class<?> cls) {
        return C14342f0.m8193g(cls, boolean[].class) ? "kotlin.BooleanArray" : C14342f0.m8193g(cls, char[].class) ? "kotlin.CharArray" : C14342f0.m8193g(cls, byte[].class) ? "kotlin.ByteArray" : C14342f0.m8193g(cls, short[].class) ? "kotlin.ShortArray" : C14342f0.m8193g(cls, int[].class) ? "kotlin.IntArray" : C14342f0.m8193g(cls, float[].class) ? "kotlin.FloatArray" : C14342f0.m8193g(cls, long[].class) ? "kotlin.LongArray" : C14342f0.m8193g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (C14342f0.m8193g(mo7319o(), typeReference.mo7319o()) && C14342f0.m8193g(getArguments(), typeReference.getArguments()) && mo7320f() == typeReference.mo7320f()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KType
    /* renamed from: f */
    public boolean mo7320f() {
        return this.f41213c;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> m12478E;
        m12478E = CollectionsKt__CollectionsKt.m12478E();
        return m12478E;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<KTypeProjection> getArguments() {
        return this.f41212b;
    }

    public int hashCode() {
        return (((mo7319o().hashCode() * 31) + getArguments().hashCode()) * 31) + Boolean.valueOf(mo7320f()).hashCode();
    }

    @Override // kotlin.reflect.KType
    @NotNull
    /* renamed from: o */
    public KClassifier mo7319o() {
        return this.f41211a;
    }

    @NotNull
    public String toString() {
        return m7981i() + " (Kotlin reflection is not available)";
    }
}
