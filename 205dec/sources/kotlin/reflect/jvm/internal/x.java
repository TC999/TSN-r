package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: moduleByClassLoader.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\u001a\b\u0010\u0004\u001a\u00020\u0003H\u0000\"&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\b\u00a8\u0006\n"}, d2 = {"Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/k;", "b", "Lkotlin/f1;", "a", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/g0;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/ConcurrentMap;", "moduleByClassLoader", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<g0, WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k>> f58679a = new ConcurrentHashMap();

    public static final void a() {
        f58679a.clear();
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k b(@NotNull Class<?> cls) {
        kotlin.jvm.internal.f0.p(cls, "<this>");
        ClassLoader f4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.f(cls);
        g0 g0Var = new g0(f4);
        ConcurrentMap<g0, WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k>> concurrentMap = f58679a;
        WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k> weakReference = concurrentMap.get(g0Var);
        if (weakReference != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(g0Var, weakReference);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k.f56557c.a(f4);
        while (true) {
            try {
                ConcurrentMap<g0, WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k>> concurrentMap2 = f58679a;
                WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k> putIfAbsent = concurrentMap2.putIfAbsent(g0Var, new WeakReference<>(a4));
                if (putIfAbsent == null) {
                    return a4;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k kVar2 = putIfAbsent.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(g0Var, putIfAbsent);
            } finally {
                g0Var.a(null);
            }
        }
    }
}
