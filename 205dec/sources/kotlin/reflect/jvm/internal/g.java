package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: kClassCache.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000\u001a\b\u0010\u0007\u001a\u00020\u0006H\u0000\"2\u0010\f\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00000\u00000\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\r"}, d2 = {"", "T", "Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/h;", "b", "Lkotlin/f1;", "a", "Lkotlin/reflect/jvm/internal/pcollections/b;", "", "kotlin.jvm.PlatformType", "Lkotlin/reflect/jvm/internal/pcollections/b;", "K_CLASS_CACHE", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static kotlin.reflect.jvm.internal.pcollections.b<String, Object> f55956a;

    static {
        kotlin.reflect.jvm.internal.pcollections.b<String, Object> c4 = kotlin.reflect.jvm.internal.pcollections.b.c();
        kotlin.jvm.internal.f0.o(c4, "empty<String, Any>()");
        f55956a = c4;
    }

    public static final void a() {
        kotlin.reflect.jvm.internal.pcollections.b<String, Object> c4 = kotlin.reflect.jvm.internal.pcollections.b.c();
        kotlin.jvm.internal.f0.o(c4, "empty()");
        f55956a = c4;
    }

    @NotNull
    public static final <T> h<T> b(@NotNull Class<T> jClass) {
        kotlin.jvm.internal.f0.p(jClass, "jClass");
        String name = jClass.getName();
        Object d4 = f55956a.d(name);
        if (d4 instanceof WeakReference) {
            h<T> hVar = (h) ((WeakReference) d4).get();
            if (kotlin.jvm.internal.f0.g(hVar != null ? hVar.d() : null, jClass)) {
                return hVar;
            }
        } else if (d4 != null) {
            WeakReference[] weakReferenceArr = (WeakReference[]) d4;
            int length = weakReferenceArr.length;
            int i4 = 0;
            while (i4 < length) {
                WeakReference weakReference = weakReferenceArr[i4];
                i4++;
                h<T> hVar2 = (h) weakReference.get();
                if (kotlin.jvm.internal.f0.g(hVar2 == null ? null : hVar2.d(), jClass)) {
                    return hVar2;
                }
            }
            int length2 = ((Object[]) d4).length;
            WeakReference[] weakReferenceArr2 = new WeakReference[length2 + 1];
            System.arraycopy(d4, 0, weakReferenceArr2, 0, length2);
            h<T> hVar3 = new h<>(jClass);
            weakReferenceArr2[length2] = new WeakReference(hVar3);
            kotlin.reflect.jvm.internal.pcollections.b<String, Object> h4 = f55956a.h(name, weakReferenceArr2);
            kotlin.jvm.internal.f0.o(h4, "K_CLASS_CACHE.plus(name, newArray)");
            f55956a = h4;
            return hVar3;
        }
        h<T> hVar4 = new h<>(jClass);
        kotlin.reflect.jvm.internal.pcollections.b<String, Object> h5 = f55956a.h(name, new WeakReference(hVar4));
        kotlin.jvm.internal.f0.o(h5, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        f55956a = h5;
        return hVar4;
    }
}
