package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StorageManager.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface n {
    <T> T a(@NotNull d2.a<? extends T> aVar);

    @NotNull
    <K, V> a<K, V> b();

    @NotNull
    <K, V> g<K, V> c(@NotNull d2.l<? super K, ? extends V> lVar);

    @NotNull
    <K, V> b<K, V> d();

    @NotNull
    <K, V> h<K, V> e(@NotNull d2.l<? super K, ? extends V> lVar);

    @NotNull
    <T> i<T> f(@NotNull d2.a<? extends T> aVar, @Nullable d2.l<? super Boolean, ? extends T> lVar, @NotNull d2.l<? super T, f1> lVar2);

    @NotNull
    <T> i<T> g(@NotNull d2.a<? extends T> aVar);

    @NotNull
    <T> i<T> h(@NotNull d2.a<? extends T> aVar, @NotNull T t3);

    @NotNull
    <T> j<T> i(@NotNull d2.a<? extends T> aVar);
}
