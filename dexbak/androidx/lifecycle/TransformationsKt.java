package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: Transformations.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\b\u001a>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0086\bø\u0001\u0000\u001aD\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001a\b\u0004\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, m12616d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "switchMap", "lifecycle-livedata-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 1})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class TransformationsKt {
    @NotNull
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> distinctUntilChanged) {
        C14342f0.m8184p(distinctUntilChanged, "$this$distinctUntilChanged");
        LiveData<X> distinctUntilChanged2 = Transformations.distinctUntilChanged(distinctUntilChanged);
        C14342f0.m8185o(distinctUntilChanged2, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged2;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> map, @NotNull final InterfaceC15280l<? super X, ? extends Y> transform) {
        C14342f0.m8184p(map, "$this$map");
        C14342f0.m8184p(transform, "transform");
        LiveData<Y> map2 = Transformations.map(map, new Function<X, Y>() { // from class: androidx.lifecycle.TransformationsKt$map$1
            @Override // androidx.arch.core.util.Function
            public final Y apply(X x) {
                return (Y) InterfaceC15280l.this.invoke(x);
            }
        });
        C14342f0.m8185o(map2, "Transformations.map(this) { transform(it) }");
        return map2;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> switchMap, @NotNull final InterfaceC15280l<? super X, ? extends LiveData<Y>> transform) {
        C14342f0.m8184p(switchMap, "$this$switchMap");
        C14342f0.m8184p(transform, "transform");
        LiveData<Y> switchMap2 = Transformations.switchMap(switchMap, new Function<X, LiveData<Y>>() { // from class: androidx.lifecycle.TransformationsKt$switchMap$1
            @Override // androidx.arch.core.util.Function
            public final LiveData<Y> apply(X x) {
                return (LiveData) InterfaceC15280l.this.invoke(x);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.arch.core.util.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((TransformationsKt$switchMap$1<I, O, X, Y>) obj);
            }
        });
        C14342f0.m8185o(switchMap2, "Transformations.switchMap(this) { transform(it) }");
        return switchMap2;
    }
}
