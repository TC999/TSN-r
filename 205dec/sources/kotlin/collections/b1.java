package kotlin.collections;

import com.acse.ottn.f3;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SlidingWindow.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lkotlin/collections/b1;", "E", "Lkotlin/collections/c;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "fromIndex", "toIndex", "Lkotlin/f1;", "a", "index", f3.f5657f, "(I)Ljava/lang/Object;", "", "Ljava/util/List;", "list", "b", "I", "c", "_size", "getSize", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b1<E> extends c<E> implements RandomAccess {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<E> f55263a;

    /* renamed from: b  reason: collision with root package name */
    private int f55264b;

    /* renamed from: c  reason: collision with root package name */
    private int f55265c;

    /* JADX WARN: Multi-variable type inference failed */
    public b1(@NotNull List<? extends E> list) {
        kotlin.jvm.internal.f0.p(list, "list");
        this.f55263a = list;
    }

    public final void a(int i4, int i5) {
        c.Companion.d(i4, i5, this.f55263a.size());
        this.f55264b = i4;
        this.f55265c = i5 - i4;
    }

    @Override // kotlin.collections.c, java.util.List
    public E get(int i4) {
        c.Companion.b(i4, this.f55265c);
        return this.f55263a.get(this.f55264b + i4);
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f55265c;
    }
}
