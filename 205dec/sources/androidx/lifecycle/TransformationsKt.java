package androidx.lifecycle;

import androidx.arch.core.util.Function;
import d2.l;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Transformations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\b\u001a>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0086\b\u00f8\u0001\u0000\u001aD\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001a\b\u0004\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\b"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "switchMap", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TransformationsKt {
    @NotNull
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> distinctUntilChanged) {
        f0.p(distinctUntilChanged, "$this$distinctUntilChanged");
        LiveData<X> distinctUntilChanged2 = Transformations.distinctUntilChanged(distinctUntilChanged);
        f0.o(distinctUntilChanged2, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged2;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> map, @NotNull final l<? super X, ? extends Y> transform) {
        f0.p(map, "$this$map");
        f0.p(transform, "transform");
        LiveData<Y> map2 = Transformations.map(map, new Function<X, Y>() { // from class: androidx.lifecycle.TransformationsKt$map$1
            @Override // androidx.arch.core.util.Function
            public final Y apply(X x3) {
                return (Y) l.this.invoke(x3);
            }
        });
        f0.o(map2, "Transformations.map(this) { transform(it) }");
        return map2;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> switchMap, @NotNull final l<? super X, ? extends LiveData<Y>> transform) {
        f0.p(switchMap, "$this$switchMap");
        f0.p(transform, "transform");
        LiveData<Y> switchMap2 = Transformations.switchMap(switchMap, new Function<X, LiveData<Y>>() { // from class: androidx.lifecycle.TransformationsKt$switchMap$1
            @Override // androidx.arch.core.util.Function
            public final LiveData<Y> apply(X x3) {
                return (LiveData) l.this.invoke(x3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.arch.core.util.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((TransformationsKt$switchMap$1<I, O, X, Y>) obj);
            }
        });
        f0.o(switchMap2, "Transformations.switchMap(this) { transform(it) }");
        return switchMap2;
    }
}
