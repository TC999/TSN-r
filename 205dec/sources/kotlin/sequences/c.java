package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lkotlin/sequences/c;", "T", "K", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "source", "Lkotlin/Function1;", "keySelector", "<init>", "(Lkotlin/sequences/m;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c<T, K> implements m<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58776a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<T, K> f58777b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull m<? extends T> source, @NotNull d2.l<? super T, ? extends K> keySelector) {
        f0.p(source, "source");
        f0.p(keySelector, "keySelector");
        this.f58776a = source;
        this.f58777b = keySelector;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new b(this.f58776a.iterator(), this.f58777b);
    }
}
