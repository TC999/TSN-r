package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SequenceBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007\u00a2\u0006\u0004\b-\u0010.J\u000f\u0010\u0006\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u0010\u0010\f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lkotlin/sequences/n;", "T", "Lkotlin/sequences/o;", "", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "l", "()Ljava/lang/Object;", "", "j", "", "hasNext", "next", "value", "e", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "iterator", "g", "(Ljava/util/Iterator;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "Lkotlin/sequences/State;", "a", "I", "state", "b", "Ljava/lang/Object;", "nextValue", "c", "Ljava/util/Iterator;", "nextIterator", "d", "Lkotlin/coroutines/c;", "k", "()Lkotlin/coroutines/c;", "m", "(Lkotlin/coroutines/c;)V", "nextStep", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n<T> extends o<T> implements Iterator<T>, kotlin.coroutines.c<f1>, e2.a {

    /* renamed from: a  reason: collision with root package name */
    private int f58818a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private T f58819b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends T> f58820c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private kotlin.coroutines.c<? super f1> f58821d;

    private final Throwable j() {
        int i4 = this.f58818a;
        if (i4 != 4) {
            if (i4 != 5) {
                return new IllegalStateException(f0.C("Unexpected state of the iterator: ", Integer.valueOf(this.f58818a)));
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T l() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.o
    @Nullable
    public Object e(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object h5;
        Object h6;
        this.f58819b = t3;
        this.f58818a = 3;
        m(cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        h5 = kotlin.coroutines.intrinsics.b.h();
        if (h4 == h5) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        h6 = kotlin.coroutines.intrinsics.b.h();
        return h4 == h6 ? h4 : f1.f55527a;
    }

    @Override // kotlin.sequences.o
    @Nullable
    public Object g(@NotNull Iterator<? extends T> it, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object h5;
        Object h6;
        if (it.hasNext()) {
            this.f58820c = it;
            this.f58818a = 2;
            m(cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            h5 = kotlin.coroutines.intrinsics.b.h();
            if (h4 == h5) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            h6 = kotlin.coroutines.intrinsics.b.h();
            return h4 == h6 ? h4 : f1.f55527a;
        }
        return f1.f55527a;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i4 = this.f58818a;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2 || i4 == 3) {
                        return true;
                    }
                    if (i4 == 4) {
                        return false;
                    }
                    throw j();
                }
                Iterator<? extends T> it = this.f58820c;
                f0.m(it);
                if (it.hasNext()) {
                    this.f58818a = 2;
                    return true;
                }
                this.f58820c = null;
            }
            this.f58818a = 5;
            kotlin.coroutines.c<? super f1> cVar = this.f58821d;
            f0.m(cVar);
            this.f58821d = null;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m119constructorimpl(f1.f55527a));
        }
    }

    @Nullable
    public final kotlin.coroutines.c<f1> k() {
        return this.f58821d;
    }

    public final void m(@Nullable kotlin.coroutines.c<? super f1> cVar) {
        this.f58821d = cVar;
    }

    @Override // java.util.Iterator
    public T next() {
        int i4 = this.f58818a;
        if (i4 == 0 || i4 == 1) {
            return l();
        }
        if (i4 == 2) {
            this.f58818a = 1;
            Iterator<? extends T> it = this.f58820c;
            f0.m(it);
            return it.next();
        } else if (i4 == 3) {
            this.f58818a = 0;
            T t3 = this.f58819b;
            this.f58819b = null;
            return t3;
        } else {
            throw j();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        d0.n(obj);
        this.f58818a = 4;
    }
}
