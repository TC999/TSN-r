package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Comparisons.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003B\u001f\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003R'\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/comparisons/g;", "T", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "reversed", "Ljava/util/Comparator;", "()Ljava/util/Comparator;", "comparator", "<init>", "(Ljava/util/Comparator;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g<T> implements Comparator<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Comparator<T> f55493a;

    public g(@NotNull Comparator<T> comparator) {
        f0.p(comparator, "comparator");
        this.f55493a = comparator;
    }

    @NotNull
    public final Comparator<T> a() {
        return this.f55493a;
    }

    @Override // java.util.Comparator
    public int compare(T t3, T t4) {
        return this.f55493a.compare(t4, t3);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<T> reversed() {
        return this.f55493a;
    }
}
