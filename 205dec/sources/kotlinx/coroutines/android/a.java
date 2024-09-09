package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import d2.l;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.q;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u0010&\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010(\u001a\u00020\u0005\u00a2\u0006\u0004\b)\u0010*B\u001d\b\u0016\u0012\u0006\u0010#\u001a\u00020 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b)\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010'\u00a8\u0006,"}, d2 = {"Lkotlinx/coroutines/android/a;", "Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/z0;", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "Lkotlinx/coroutines/i1;", "f", "", "toString", "", "other", "equals", "", "hashCode", "_immediate", "Lkotlinx/coroutines/android/a;", "a", "B", "()Lkotlinx/coroutines/android/a;", "immediate", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "Ljava/lang/String;", "name", "Z", "invokeImmediately", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends kotlinx.coroutines.android.b implements z0 {
    private volatile a _immediate;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a f59041a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f59042b;

    /* renamed from: c  reason: collision with root package name */
    private final String f59043c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f59044d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: HandlerDispatcher.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"kotlinx/coroutines/android/a$a", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.android.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1196a implements i1 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f59046b;

        C1196a(Runnable runnable) {
            this.f59046b = runnable;
        }

        @Override // kotlinx.coroutines.i1
        public void dispose() {
            a.this.f59042b.removeCallbacks(this.f59046b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Runnable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f59048b;

        public b(o oVar) {
            this.f59048b = oVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f59048b.G(a.this, f1.f55527a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: HandlerDispatcher.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements l<Throwable, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f59050b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Runnable runnable) {
            super(1);
            this.f59050b = runnable;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            invoke2(th);
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            a.this.f59042b.removeCallbacks(this.f59050b);
        }
    }

    private a(Handler handler, String str, boolean z3) {
        super(null);
        this.f59042b = handler;
        this.f59043c = str;
        this.f59044d = z3;
        this._immediate = z3 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
            f1 f1Var = f1.f55527a;
        }
        this.f59041a = aVar;
    }

    @Override // kotlinx.coroutines.android.b
    @NotNull
    /* renamed from: B */
    public a t() {
        return this.f59041a;
    }

    @Override // kotlinx.coroutines.z0
    public void d(long j4, @NotNull o<? super f1> oVar) {
        long v3;
        b bVar = new b(oVar);
        Handler handler = this.f59042b;
        v3 = q.v(j4, 4611686018427387903L);
        handler.postDelayed(bVar, v3);
        oVar.B(new c(bVar));
    }

    @Override // kotlinx.coroutines.l0
    public void dispatch(@NotNull f fVar, @NotNull Runnable runnable) {
        this.f59042b.post(runnable);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof a) && ((a) obj).f59042b == this.f59042b;
    }

    @Override // kotlinx.coroutines.android.b, kotlinx.coroutines.z0
    @NotNull
    public i1 f(long j4, @NotNull Runnable runnable, @NotNull f fVar) {
        long v3;
        Handler handler = this.f59042b;
        v3 = q.v(j4, 4611686018427387903L);
        handler.postDelayed(runnable, v3);
        return new C1196a(runnable);
    }

    public int hashCode() {
        return System.identityHashCode(this.f59042b);
    }

    @Override // kotlinx.coroutines.l0
    public boolean isDispatchNeeded(@NotNull f fVar) {
        return !this.f59044d || (f0.g(Looper.myLooper(), this.f59042b.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.p2, kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        String r3 = r();
        if (r3 != null) {
            return r3;
        }
        String str = this.f59043c;
        if (str == null) {
            str = this.f59042b.toString();
        }
        if (this.f59044d) {
            return str + ".immediate";
        }
        return str;
    }

    public /* synthetic */ a(Handler handler, String str, int i4, u uVar) {
        this(handler, (i4 & 2) != 0 ? null : str);
    }

    public a(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
