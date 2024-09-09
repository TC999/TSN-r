package kotlin.collections;

import com.acse.ottn.f3;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ReversedViews.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\u0006J \u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lkotlin/collections/e1;", "T", "Lkotlin/collections/f;", "", "index", f3.f5657f, "(I)Ljava/lang/Object;", "Lkotlin/f1;", "clear", "removeAt", "element", f3.f5659h, "(ILjava/lang/Object;)Ljava/lang/Object;", "add", "(ILjava/lang/Object;)V", "", "a", "Ljava/util/List;", "delegate", "getSize", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e1<T> extends f<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f55315a;

    public e1(@NotNull List<T> delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f55315a = delegate;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i4, T t3) {
        int Z0;
        List<T> list = this.f55315a;
        Z0 = d0.Z0(this, i4);
        list.add(Z0, t3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f55315a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i4) {
        int Y0;
        List<T> list = this.f55315a;
        Y0 = d0.Y0(this, i4);
        return list.get(Y0);
    }

    @Override // kotlin.collections.f
    public int getSize() {
        return this.f55315a.size();
    }

    @Override // kotlin.collections.f
    public T removeAt(int i4) {
        int Y0;
        List<T> list = this.f55315a;
        Y0 = d0.Y0(this, i4);
        return list.remove(Y0);
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public T set(int i4, T t3) {
        int Y0;
        List<T> list = this.f55315a;
        Y0 = d0.Y0(this, i4);
        return list.set(Y0, t3);
    }
}
