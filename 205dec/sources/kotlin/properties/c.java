package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ObservableProperty.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J+\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\u000f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0096\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0012\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0011\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lkotlin/properties/c;", "V", "Lkotlin/properties/f;", "", "Lkotlin/reflect/n;", "property", "oldValue", "newValue", "", "d", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlin/f1;", "c", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)V", "thisRef", "a", "(Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "value", "b", "(Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "Ljava/lang/Object;", "initialValue", "<init>", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c<V> implements f<Object, V> {

    /* renamed from: a  reason: collision with root package name */
    private V f55756a;

    public c(V v3) {
        this.f55756a = v3;
    }

    @Override // kotlin.properties.f, kotlin.properties.e
    public V a(@Nullable Object obj, @NotNull n<?> property) {
        f0.p(property, "property");
        return this.f55756a;
    }

    @Override // kotlin.properties.f
    public void b(@Nullable Object obj, @NotNull n<?> property, V v3) {
        f0.p(property, "property");
        V v4 = this.f55756a;
        if (d(property, v4, v3)) {
            this.f55756a = v3;
            c(property, v4, v3);
        }
    }

    protected void c(@NotNull n<?> property, V v3, V v4) {
        f0.p(property, "property");
    }

    protected boolean d(@NotNull n<?> property, V v3, V v4) {
        f0.p(property, "property");
        return true;
    }
}
