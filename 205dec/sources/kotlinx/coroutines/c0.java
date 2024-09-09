package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CancellableContinuationImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003J&\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J`\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0011\u0010#\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lkotlinx/coroutines/c0;", "", "Lkotlinx/coroutines/p;", "cont", "", "cause", "Lkotlin/f1;", "i", "a", "Lkotlinx/coroutines/m;", "b", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "c", "d", "e", "result", "cancelHandler", "onCancellation", "idempotentResume", "cancelCause", "f", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "Lkotlinx/coroutines/m;", "Ljava/lang/Throwable;", "h", "()Z", "cancelled", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/m;Ld2/l;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c0 {
    @JvmField
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Object f59065a;
    @JvmField
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final m f59066b;
    @JvmField
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final d2.l<Throwable, kotlin.f1> f59067c;
    @JvmField
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Object f59068d;
    @JvmField
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f59069e;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@Nullable Object obj, @Nullable m mVar, @Nullable d2.l<? super Throwable, kotlin.f1> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        this.f59065a = obj;
        this.f59066b = mVar;
        this.f59067c = lVar;
        this.f59068d = obj2;
        this.f59069e = th;
    }

    public static /* synthetic */ c0 g(c0 c0Var, Object obj, m mVar, d2.l lVar, Object obj2, Throwable th, int i4, Object obj3) {
        if ((i4 & 1) != 0) {
            obj = c0Var.f59065a;
        }
        if ((i4 & 2) != 0) {
            mVar = c0Var.f59066b;
        }
        m mVar2 = mVar;
        d2.l<Throwable, kotlin.f1> lVar2 = lVar;
        if ((i4 & 4) != 0) {
            lVar2 = c0Var.f59067c;
        }
        d2.l lVar3 = lVar2;
        if ((i4 & 8) != 0) {
            obj2 = c0Var.f59068d;
        }
        Object obj4 = obj2;
        if ((i4 & 16) != 0) {
            th = c0Var.f59069e;
        }
        return c0Var.f(obj, mVar2, lVar3, obj4, th);
    }

    @Nullable
    public final Object a() {
        return this.f59065a;
    }

    @Nullable
    public final m b() {
        return this.f59066b;
    }

    @Nullable
    public final d2.l<Throwable, kotlin.f1> c() {
        return this.f59067c;
    }

    @Nullable
    public final Object d() {
        return this.f59068d;
    }

    @Nullable
    public final Throwable e() {
        return this.f59069e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof c0) {
                c0 c0Var = (c0) obj;
                return kotlin.jvm.internal.f0.g(this.f59065a, c0Var.f59065a) && kotlin.jvm.internal.f0.g(this.f59066b, c0Var.f59066b) && kotlin.jvm.internal.f0.g(this.f59067c, c0Var.f59067c) && kotlin.jvm.internal.f0.g(this.f59068d, c0Var.f59068d) && kotlin.jvm.internal.f0.g(this.f59069e, c0Var.f59069e);
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final c0 f(@Nullable Object obj, @Nullable m mVar, @Nullable d2.l<? super Throwable, kotlin.f1> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        return new c0(obj, mVar, lVar, obj2, th);
    }

    public final boolean h() {
        return this.f59069e != null;
    }

    public int hashCode() {
        Object obj = this.f59065a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        m mVar = this.f59066b;
        int hashCode2 = (hashCode + (mVar != null ? mVar.hashCode() : 0)) * 31;
        d2.l<Throwable, kotlin.f1> lVar = this.f59067c;
        int hashCode3 = (hashCode2 + (lVar != null ? lVar.hashCode() : 0)) * 31;
        Object obj2 = this.f59068d;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f59069e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void i(@NotNull p<?> pVar, @NotNull Throwable th) {
        m mVar = this.f59066b;
        if (mVar != null) {
            pVar.l(mVar, th);
        }
        d2.l<Throwable, kotlin.f1> lVar = this.f59067c;
        if (lVar != null) {
            pVar.p(lVar, th);
        }
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.f59065a + ", cancelHandler=" + this.f59066b + ", onCancellation=" + this.f59067c + ", idempotentResume=" + this.f59068d + ", cancelCause=" + this.f59069e + ")";
    }

    public /* synthetic */ c0(Object obj, m mVar, d2.l lVar, Object obj2, Throwable th, int i4, kotlin.jvm.internal.u uVar) {
        this(obj, (i4 & 2) != 0 ? null : mVar, (i4 & 4) != 0 ? null : lVar, (i4 & 8) != 0 ? null : obj2, (i4 & 16) != 0 ? null : th);
    }
}
