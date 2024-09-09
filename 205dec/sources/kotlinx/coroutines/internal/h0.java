package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ConcurrentLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/h0;", "Lkotlinx/coroutines/internal/g0;", "S", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "value", "h", "(Ljava/lang/Object;)Z", "isClosed", "f", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/g0;", "getSegment$annotations", "()V", "segment", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h0<S extends g0<S>> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f60362a;

    private /* synthetic */ h0(@Nullable Object obj) {
        this.f60362a = obj;
    }

    @NotNull
    public static final /* synthetic */ h0 a(@Nullable Object obj) {
        return new h0(obj);
    }

    @NotNull
    public static Object b(@Nullable Object obj) {
        return obj;
    }

    public static boolean c(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof h0) && kotlin.jvm.internal.f0.g(obj, ((h0) obj2).j());
    }

    public static final boolean d(@Nullable Object obj, @Nullable Object obj2) {
        return kotlin.jvm.internal.f0.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @NotNull
    public static final S f(Object obj) {
        if (obj != f.f60356b) {
            if (obj != null) {
                return (S) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type S");
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static int g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final boolean h(Object obj) {
        return obj == f.f60356b;
    }

    @NotNull
    public static String i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return c(this.f60362a, obj);
    }

    public int hashCode() {
        return g(this.f60362a);
    }

    @Nullable
    public final /* synthetic */ Object j() {
        return this.f60362a;
    }

    public String toString() {
        return i(this.f60362a);
    }
}
