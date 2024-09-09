package kotlinx.coroutines.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.f1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadSafeHeap.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b0\u0010\u0012J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082\u0010\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082\u0010\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fH\u0002\u00a2\u0006\u0004\b\u0007\u0010\rJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014J&\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u0016H\u0086\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00028\u00002\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00170\u0016H\u0086\b\u00a2\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000e\u0010!J\u0011\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0001\u00a2\u0006\u0004\b\"\u0010\u0014J\u0017\u0010$\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0006H\u0001\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0000H\u0001\u00a2\u0006\u0004\b&\u0010\u001dR \u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00068F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\nR\u0011\u0010/\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00061"}, d2 = {"Lkotlinx/coroutines/internal/s0;", "Lkotlinx/coroutines/internal/t0;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "i", "Lkotlin/f1;", "p", "(I)V", "o", "", "()[Lkotlinx/coroutines/internal/t0;", "j", CampaignEx.JSON_KEY_AD_Q, "(II)V", "d", "()V", "h", "()Lkotlinx/coroutines/internal/t0;", "m", "Lkotlin/Function1;", "", "predicate", "l", "(Ld2/l;)Lkotlinx/coroutines/internal/t0;", "node", "b", "(Lkotlinx/coroutines/internal/t0;)V", "cond", "c", "(Lkotlinx/coroutines/internal/t0;Ld2/l;)Z", "(Lkotlinx/coroutines/internal/t0;)Z", "e", "index", "k", "(I)Lkotlinx/coroutines/internal/t0;", "a", "[Lkotlinx/coroutines/internal/t0;", "value", "f", "()I", "n", "size", "g", "()Z", "isEmpty", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s0<T extends t0 & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f60416a;

    private final T[] i() {
        T[] tArr = this.f60416a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new t0[4];
            this.f60416a = tArr2;
            return tArr2;
        } else if (f() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, f() * 2);
            kotlin.jvm.internal.f0.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((t0[]) copyOf);
            this.f60416a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void n(int i4) {
        this._size = i4;
    }

    private final void o(int i4) {
        while (true) {
            int i5 = (i4 * 2) + 1;
            if (i5 >= f()) {
                return;
            }
            T[] tArr = this.f60416a;
            kotlin.jvm.internal.f0.m(tArr);
            int i6 = i5 + 1;
            if (i6 < f()) {
                T t3 = tArr[i6];
                kotlin.jvm.internal.f0.m(t3);
                T t4 = tArr[i5];
                kotlin.jvm.internal.f0.m(t4);
                if (((Comparable) t3).compareTo(t4) < 0) {
                    i5 = i6;
                }
            }
            T t5 = tArr[i4];
            kotlin.jvm.internal.f0.m(t5);
            T t6 = tArr[i5];
            kotlin.jvm.internal.f0.m(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            q(i4, i5);
            i4 = i5;
        }
    }

    private final void p(int i4) {
        while (i4 > 0) {
            T[] tArr = this.f60416a;
            kotlin.jvm.internal.f0.m(tArr);
            int i5 = (i4 - 1) / 2;
            T t3 = tArr[i5];
            kotlin.jvm.internal.f0.m(t3);
            T t4 = tArr[i4];
            kotlin.jvm.internal.f0.m(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            q(i4, i5);
            i4 = i5;
        }
    }

    private final void q(int i4, int i5) {
        T[] tArr = this.f60416a;
        kotlin.jvm.internal.f0.m(tArr);
        T t3 = tArr[i5];
        kotlin.jvm.internal.f0.m(t3);
        T t4 = tArr[i4];
        kotlin.jvm.internal.f0.m(t4);
        tArr[i4] = t3;
        tArr[i5] = t4;
        t3.d(i4);
        t4.d(i5);
    }

    @PublishedApi
    public final void a(@NotNull T t3) {
        t3.a(this);
        T[] i4 = i();
        int f4 = f();
        n(f4 + 1);
        i4[f4] = t3;
        t3.d(f4);
        p(f4);
    }

    public final void b(@NotNull T t3) {
        synchronized (this) {
            a(t3);
            f1 f1Var = f1.f55527a;
        }
    }

    public final boolean c(@NotNull T t3, @NotNull d2.l<? super T, Boolean> lVar) {
        boolean z3;
        synchronized (this) {
            try {
                if (lVar.invoke(e()).booleanValue()) {
                    a(t3);
                    z3 = true;
                } else {
                    z3 = false;
                }
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th;
            }
        }
        kotlin.jvm.internal.c0.c(1);
        return z3;
    }

    public final void d() {
        synchronized (this) {
            T[] tArr = this.f60416a;
            if (tArr != null) {
                kotlin.collections.o.w2(tArr, null, 0, 0, 6, null);
            }
            this._size = 0;
            f1 f1Var = f1.f55527a;
        }
    }

    @PublishedApi
    @Nullable
    public final T e() {
        T[] tArr = this.f60416a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int f() {
        return this._size;
    }

    public final boolean g() {
        return f() == 0;
    }

    @Nullable
    public final T h() {
        T e4;
        synchronized (this) {
            e4 = e();
        }
        return e4;
    }

    public final boolean j(@NotNull T t3) {
        boolean z3;
        synchronized (this) {
            if (t3.b() == null) {
                z3 = false;
            } else {
                k(t3.f());
                z3 = true;
            }
        }
        return z3;
    }

    @PublishedApi
    @NotNull
    public final T k(int i4) {
        T[] tArr = this.f60416a;
        kotlin.jvm.internal.f0.m(tArr);
        n(f() - 1);
        if (i4 < f()) {
            q(i4, f());
            int i5 = (i4 - 1) / 2;
            if (i4 > 0) {
                T t3 = tArr[i4];
                kotlin.jvm.internal.f0.m(t3);
                T t4 = tArr[i5];
                kotlin.jvm.internal.f0.m(t4);
                if (((Comparable) t3).compareTo(t4) < 0) {
                    q(i4, i5);
                    p(i5);
                }
            }
            o(i4);
        }
        T t5 = tArr[f()];
        kotlin.jvm.internal.f0.m(t5);
        t5.a(null);
        t5.d(-1);
        tArr[f()] = null;
        return t5;
    }

    @Nullable
    public final T l(@NotNull d2.l<? super T, Boolean> lVar) {
        synchronized (this) {
            try {
                T e4 = e();
                if (e4 != null) {
                    T k4 = lVar.invoke(e4).booleanValue() ? k(0) : null;
                    kotlin.jvm.internal.c0.d(1);
                    kotlin.jvm.internal.c0.c(1);
                    return k4;
                }
                kotlin.jvm.internal.c0.d(2);
                kotlin.jvm.internal.c0.c(2);
                return null;
            } catch (Throwable th) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th;
            }
        }
    }

    @Nullable
    public final T m() {
        T k4;
        synchronized (this) {
            k4 = f() > 0 ? k(0) : null;
        }
        return k4;
    }
}
