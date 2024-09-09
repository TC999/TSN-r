package kotlin.collections;

import com.acse.ottn.f3;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ReversedViews.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/collections/f1;", "T", "Lkotlin/collections/c;", "", "index", f3.f5657f, "(I)Ljava/lang/Object;", "", "a", "Ljava/util/List;", "delegate", "getSize", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class f1<T> extends c<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f55321a;

    /* compiled from: SlidingWindow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\n"}, d2 = {"kotlin/collections/f1$a", "Lkotlin/collections/c;", "Lkotlin/f1;", "a", "", "c", "I", "count", "d", "index", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a extends c<T> {

        /* renamed from: c  reason: collision with root package name */
        private int f55322c;

        /* renamed from: d  reason: collision with root package name */
        private int f55323d;

        a() {
            this.f55322c = f1.this.size();
            this.f55323d = f1.f(f1.this);
        }

        protected void a() {
            if (this.f55322c == 0) {
                c();
                return;
            }
            d(f1.c(f1.this)[this.f55323d]);
            this.f55323d = (this.f55323d + 1) % f1.d(f1.this);
            this.f55322c--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f1(@NotNull List<? extends T> delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f55321a = delegate;
    }

    @Override // kotlin.collections.c, java.util.List
    public T get(int i4) {
        int Y0;
        List<T> list = this.f55321a;
        Y0 = d0.Y0(this, i4);
        return list.get(Y0);
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f55321a.size();
    }
}
