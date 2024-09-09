package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00010\nj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lkotlin/sequences/b;", "T", "K", "Lkotlin/collections/b;", "Lkotlin/f1;", "a", "", "c", "Ljava/util/Iterator;", "source", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "e", "Ljava/util/HashSet;", "observed", "Lkotlin/Function1;", "keySelector", "<init>", "(Ljava/util/Iterator;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b<T, K> extends kotlin.collections.b<T> {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Iterator<T> f58773c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final d2.l<T, K> f58774d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<K> f58775e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Iterator<? extends T> source, @NotNull d2.l<? super T, ? extends K> keySelector) {
        f0.p(source, "source");
        f0.p(keySelector, "keySelector");
        this.f58773c = source;
        this.f58774d = keySelector;
        this.f58775e = new HashSet<>();
    }

    @Override // kotlin.collections.b
    protected void a() {
        while (this.f58773c.hasNext()) {
            T next = this.f58773c.next();
            if (this.f58775e.add(this.f58774d.invoke(next))) {
                e(next);
                return;
            }
        }
        d();
    }
}
