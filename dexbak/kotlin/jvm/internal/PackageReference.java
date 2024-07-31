package kotlin.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001e\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0019"}, m12616d2 = {"Lkotlin/jvm/internal/l0;", "Lkotlin/jvm/internal/r;", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/lang/Class;", "jClass", "b", "Ljava/lang/String;", "moduleName", "", "Lkotlin/reflect/c;", "()Ljava/util/Collection;", "members", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.l0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {
    @NotNull

    /* renamed from: a */
    private final Class<?> f41148a;

    /* renamed from: b */
    private final String f41149b;

    public PackageReference(@NotNull Class<?> jClass, @NotNull String moduleName) {
        C14342f0.m8184p(jClass, "jClass");
        C14342f0.m8184p(moduleName, "moduleName");
        this.f41148a = jClass;
        this.f41149b = moduleName;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    /* renamed from: a */
    public Collection<KCallable<?>> mo7329a() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof PackageReference) && C14342f0.m8193g(mo8048q(), ((PackageReference) obj).mo8048q());
    }

    public int hashCode() {
        return mo8048q().hashCode();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    /* renamed from: q */
    public Class<?> mo8048q() {
        return this.f41148a;
    }

    @NotNull
    public String toString() {
        return mo8048q().toString() + " (Kotlin reflection is not available)";
    }
}
