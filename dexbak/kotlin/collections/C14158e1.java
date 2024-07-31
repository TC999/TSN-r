package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReversedViews.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlin/collections/e1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/d;", "", "index", "get", "(I)Ljava/lang/Object;", "", "a", "Ljava/util/List;", "delegate", "getSize", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.e1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14158e1<T> extends AbstractList<T> {

    /* renamed from: a */
    private final List<T> f40892a;

    /* JADX WARN: Multi-variable type inference failed */
    public C14158e1(@NotNull List<? extends T> delegate) {
        C14342f0.m8184p(delegate, "delegate");
        this.f40892a = delegate;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        int m12311a1;
        List<T> list = this.f40892a;
        m12311a1 = ReversedViews.m12311a1(this, i);
        return list.get(m12311a1);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f40892a.size();
    }
}
