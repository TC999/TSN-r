package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletionState.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001B4\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J$\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/e0;", "", "a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "b", "result", "onCancellation", "c", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0 {
    @JvmField
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Object f59623a;
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final d2.l<Throwable, kotlin.f1> f59624b;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(@Nullable Object obj, @NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        this.f59623a = obj;
        this.f59624b = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ e0 d(e0 e0Var, Object obj, d2.l lVar, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = e0Var.f59623a;
        }
        if ((i4 & 2) != 0) {
            lVar = e0Var.f59624b;
        }
        return e0Var.c(obj, lVar);
    }

    @Nullable
    public final Object a() {
        return this.f59623a;
    }

    @NotNull
    public final d2.l<Throwable, kotlin.f1> b() {
        return this.f59624b;
    }

    @NotNull
    public final e0 c(@Nullable Object obj, @NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        return new e0(obj, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof e0) {
                e0 e0Var = (e0) obj;
                return kotlin.jvm.internal.f0.g(this.f59623a, e0Var.f59623a) && kotlin.jvm.internal.f0.g(this.f59624b, e0Var.f59624b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f59623a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        d2.l<Throwable, kotlin.f1> lVar = this.f59624b;
        return hashCode + (lVar != null ? lVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f59623a + ", onCancellation=" + this.f59624b + ")";
    }
}
