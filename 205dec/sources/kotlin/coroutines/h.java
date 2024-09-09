package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeContinuationJvm.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u0000 \n*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001\u000fB!\b\u0000\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0017\b\u0011\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lkotlin/coroutines/h;", "T", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlin/Result;", "result", "Lkotlin/f1;", "resumeWith", "(Ljava/lang/Object;)V", "", "b", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "", "toString", "a", "Lkotlin/coroutines/c;", "delegate", "Ljava/lang/Object;", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "initialResult", "<init>", "(Lkotlin/coroutines/c;Ljava/lang/Object;)V", "(Lkotlin/coroutines/c;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@PublishedApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h<T> implements c<T>, kotlin.coroutines.jvm.internal.c {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final a f55508b = new a(null);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<h<?>, Object> f55509c = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f55510a;
    @Nullable
    private volatile Object result;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeContinuationJvm.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bRj\u0010\u0005\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lkotlin/coroutines/h$a;", "", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/h;", "kotlin.jvm.PlatformType", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "getRESULT$annotations", "()V", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private static /* synthetic */ void a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull c<? super T> delegate, @Nullable Object obj) {
        f0.p(delegate, "delegate");
        this.f55510a = delegate;
        this.result = obj;
    }

    @PublishedApi
    @Nullable
    public final Object b() {
        Object h4;
        Object h5;
        Object h6;
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            AtomicReferenceFieldUpdater<h<?>, Object> atomicReferenceFieldUpdater = f55509c;
            h5 = kotlin.coroutines.intrinsics.b.h();
            if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, coroutineSingletons, h5)) {
                h6 = kotlin.coroutines.intrinsics.b.h();
                return h6;
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            h4 = kotlin.coroutines.intrinsics.b.h();
            return h4;
        } else if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        } else {
            return obj;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        c<T> cVar = this.f55510a;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public f getContext() {
        return this.f55510a.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        Object h4;
        Object h5;
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 != coroutineSingletons) {
                h4 = kotlin.coroutines.intrinsics.b.h();
                if (obj2 != h4) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater<h<?>, Object> atomicReferenceFieldUpdater = f55509c;
                h5 = kotlin.coroutines.intrinsics.b.h();
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, h5, CoroutineSingletons.RESUMED)) {
                    this.f55510a.resumeWith(obj);
                    return;
                }
            } else if (io.netty.channel.a.a(f55509c, this, coroutineSingletons, obj)) {
                return;
            }
        }
    }

    @NotNull
    public String toString() {
        return f0.C("SafeContinuation for ", this.f55510a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public h(@NotNull c<? super T> delegate) {
        this(delegate, CoroutineSingletons.UNDECIDED);
        f0.p(delegate, "delegate");
    }
}
