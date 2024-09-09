package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractIterator.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH$J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\bH\u0004R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lkotlin/collections/b;", "T", "", "", "f", "hasNext", "next", "()Ljava/lang/Object;", "Lkotlin/f1;", "a", "value", "e", "(Ljava/lang/Object;)V", "d", "Lkotlin/collections/n1;", "Lkotlin/collections/n1;", "state", "b", "Ljava/lang/Object;", "nextValue", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b<T> implements Iterator<T>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private n1 f55260a = n1.NotReady;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private T f55261b;

    /* compiled from: AbstractIterator.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55262a;

        static {
            int[] iArr = new int[n1.values().length];
            iArr[n1.Done.ordinal()] = 1;
            iArr[n1.Ready.ordinal()] = 2;
            f55262a = iArr;
        }
    }

    private final boolean f() {
        this.f55260a = n1.Failed;
        a();
        return this.f55260a == n1.Ready;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        this.f55260a = n1.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(T t3) {
        this.f55261b = t3;
        this.f55260a = n1.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        n1 n1Var = this.f55260a;
        if (n1Var != n1.Failed) {
            int i4 = a.f55262a[n1Var.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return f();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f55260a = n1.NotReady;
            return this.f55261b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
