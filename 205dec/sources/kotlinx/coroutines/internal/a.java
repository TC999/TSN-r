package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayQueue.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0003R\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/a;", "", "T", "Lkotlin/f1;", "c", "element", "a", "(Ljava/lang/Object;)V", "e", "()Ljava/lang/Object;", "b", "", "[Ljava/lang/Object;", "elements", "", "I", "head", "tail", "", "d", "()Z", "isEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f60342a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f60343b;

    /* renamed from: c  reason: collision with root package name */
    private int f60344c;

    private final void c() {
        Object[] objArr = this.f60342a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.collections.o.l1(objArr, objArr2, 0, this.f60343b, 0, 10, null);
        Object[] objArr3 = this.f60342a;
        int length2 = objArr3.length;
        int i4 = this.f60343b;
        kotlin.collections.o.l1(objArr3, objArr2, length2 - i4, 0, i4, 4, null);
        this.f60342a = objArr2;
        this.f60343b = 0;
        this.f60344c = length;
    }

    public final void a(@NotNull T t3) {
        Object[] objArr = this.f60342a;
        int i4 = this.f60344c;
        objArr[i4] = t3;
        int length = (objArr.length - 1) & (i4 + 1);
        this.f60344c = length;
        if (length == this.f60343b) {
            c();
        }
    }

    public final void b() {
        this.f60343b = 0;
        this.f60344c = 0;
        this.f60342a = new Object[this.f60342a.length];
    }

    public final boolean d() {
        return this.f60343b == this.f60344c;
    }

    @Nullable
    public final T e() {
        int i4 = this.f60343b;
        if (i4 == this.f60344c) {
            return null;
        }
        Object[] objArr = this.f60342a;
        T t3 = (T) objArr[i4];
        objArr[i4] = null;
        this.f60343b = (i4 + 1) & (objArr.length - 1);
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
