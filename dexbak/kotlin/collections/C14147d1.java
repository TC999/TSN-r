package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReversedViews.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0006J \u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0013¨\u0006\u0017"}, m12616d2 = {"Lkotlin/collections/d1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/g;", "", "index", "get", "(I)Ljava/lang/Object;", "Lkotlin/f1;", "clear", "c", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "add", "(ILjava/lang/Object;)V", "", "a", "Ljava/util/List;", "delegate", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.d1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14147d1<T> extends AbstractMutableList<T> {

    /* renamed from: a */
    private final List<T> f40878a;

    public C14147d1(@NotNull List<T> delegate) {
        C14342f0.m8184p(delegate, "delegate");
        this.f40878a = delegate;
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: a */
    public int mo11949a() {
        return this.f40878a.size();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int m12310b1;
        List<T> list = this.f40878a;
        m12310b1 = ReversedViews.m12310b1(this, i);
        list.add(m12310b1, t);
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: c */
    public T mo11948c(int i) {
        int m12311a1;
        List<T> list = this.f40878a;
        m12311a1 = ReversedViews.m12311a1(this, i);
        return list.remove(m12311a1);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f40878a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int m12311a1;
        List<T> list = this.f40878a;
        m12311a1 = ReversedViews.m12311a1(this, i);
        return list.get(m12311a1);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int m12311a1;
        List<T> list = this.f40878a;
        m12311a1 = ReversedViews.m12311a1(this, i);
        return list.set(m12311a1, t);
    }
}
