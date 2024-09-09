package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: moduleByClassLoader.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u0019J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u000b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/g0;", "", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ClassLoader;", "a", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "ref", "b", "I", "getIdentityHashCode", "()I", "identityHashCode", "c", "Ljava/lang/ClassLoader;", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "temporaryStrongRef", "classLoader", "<init>", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<ClassLoader> f55957a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55958b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ClassLoader f55959c;

    public g0(@NotNull ClassLoader classLoader) {
        kotlin.jvm.internal.f0.p(classLoader, "classLoader");
        this.f55957a = new WeakReference<>(classLoader);
        this.f55958b = System.identityHashCode(classLoader);
        this.f55959c = classLoader;
    }

    public final void a(@Nullable ClassLoader classLoader) {
        this.f55959c = classLoader;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof g0) && this.f55957a.get() == ((g0) obj).f55957a.get();
    }

    public int hashCode() {
        return this.f55958b;
    }

    @NotNull
    public String toString() {
        ClassLoader classLoader = this.f55957a.get();
        return classLoader == null ? "<null>" : classLoader.toString();
    }
}
