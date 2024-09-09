package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TestCoroutineContext.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B'\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R(\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011R\"\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001b8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001c\u00a8\u0006!"}, d2 = {"Lkotlinx/coroutines/test/c;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/internal/t0;", "Lkotlin/f1;", "run", "other", "", "e", "", "toString", "Lkotlinx/coroutines/internal/s0;", "a", "Lkotlinx/coroutines/internal/s0;", "b", "()Lkotlinx/coroutines/internal/s0;", "(Lkotlinx/coroutines/internal/s0;)V", "heap", "I", "f", "()I", "d", "(I)V", "index", "c", "Ljava/lang/Runnable;", "", "J", "count", "time", "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c implements Comparable<c>, Runnable, t0 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private s0<?> f60737a;

    /* renamed from: b  reason: collision with root package name */
    private int f60738b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f60739c;

    /* renamed from: d  reason: collision with root package name */
    private final long f60740d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public final long f60741e;

    public c(@NotNull Runnable runnable, long j4, long j5) {
        this.f60739c = runnable;
        this.f60740d = j4;
        this.f60741e = j5;
    }

    @Override // kotlinx.coroutines.internal.t0
    public void a(@Nullable s0<?> s0Var) {
        this.f60737a = s0Var;
    }

    @Override // kotlinx.coroutines.internal.t0
    @Nullable
    public s0<?> b() {
        return this.f60737a;
    }

    @Override // kotlinx.coroutines.internal.t0
    public void d(int i4) {
        this.f60738b = i4;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(@NotNull c cVar) {
        long j4 = this.f60741e;
        long j5 = cVar.f60741e;
        if (j4 == j5) {
            j4 = this.f60740d;
            j5 = cVar.f60740d;
        }
        return (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
    }

    @Override // kotlinx.coroutines.internal.t0
    public int f() {
        return this.f60738b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f60739c.run();
    }

    @NotNull
    public String toString() {
        return "TimedRunnable(time=" + this.f60741e + ", run=" + this.f60739c + ')';
    }

    public /* synthetic */ c(Runnable runnable, long j4, long j5, int i4, u uVar) {
        this(runnable, (i4 & 2) != 0 ? 0L : j4, (i4 & 4) != 0 ? 0L : j5);
    }
}
