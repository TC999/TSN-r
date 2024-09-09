package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PackageReference.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001e\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lkotlin/jvm/internal/l0;", "Lkotlin/jvm/internal/r;", "", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "d", "()Ljava/lang/Class;", "jClass", "b", "Ljava/lang/String;", "moduleName", "", "Lkotlin/reflect/c;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Collection;", "members", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l0 implements r {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f55638a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f55639b;

    public l0(@NotNull Class<?> jClass, @NotNull String moduleName) {
        f0.p(jClass, "jClass");
        f0.p(moduleName, "moduleName");
        this.f55638a = jClass;
        this.f55639b = moduleName;
    }

    @Override // kotlin.jvm.internal.r
    @NotNull
    public Class<?> d() {
        return this.f55638a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof l0) && f0.g(d(), ((l0) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> q() {
        throw new KotlinReflectionNotSupportedError();
    }

    @NotNull
    public String toString() {
        return f0.C(d().toString(), " (Kotlin reflection is not available)");
    }
}
