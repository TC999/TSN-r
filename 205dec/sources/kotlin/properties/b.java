package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Delegates.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lkotlin/properties/b;", "", "T", "Lkotlin/properties/f;", "thisRef", "Lkotlin/reflect/n;", "property", "a", "(Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "value", "Lkotlin/f1;", "b", "(Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b<T> implements f<Object, T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private T f55755a;

    @Override // kotlin.properties.f, kotlin.properties.e
    @NotNull
    public T a(@Nullable Object obj, @NotNull n<?> property) {
        f0.p(property, "property");
        T t3 = this.f55755a;
        if (t3 != null) {
            return t3;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // kotlin.properties.f
    public void b(@Nullable Object obj, @NotNull n<?> property, @NotNull T value) {
        f0.p(property, "property");
        f0.p(value, "value");
        this.f55755a = value;
    }
}
